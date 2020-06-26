package net.spellcraftgaming.rpghud.gui.hud.element.vanilla;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.settings.AttackIndicatorStatus;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

public class HudElementHotbarVanilla extends HudElement {

    protected static final ResourceLocation WIDGETS_TEX_PATH = new ResourceLocation("textures/gui/widgets.png");

    public int offset = 0;

    public HudElementHotbarVanilla() {
        super(HudElementType.HOTBAR, 0, 0, 0, 0, true);
    }

    @Override
    public void drawElement(AbstractGui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        if(this.mc.playerController.getCurrentGameType() == GameType.SPECTATOR)
            this.mc.ingameGUI.getSpectatorGui().renderTooltip(partialTicks);
        else if(this.mc.getRenderViewEntity() instanceof PlayerEntity) {
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(WIDGETS_TEX_PATH);
            ItemStack itemstack = this.mc.player.getHeldItemOffhand();
            HandSide enumhandside = this.mc.player.getPrimaryHand().opposite();
            int i = scaledWidth / 2 + this.settings.getPositionValue(Settings.hotbar_position)[0];
            int posY = this.settings.getPositionValue(Settings.hotbar_position)[1] + this.offset;
            float f = zLevel;
            zLevel = -90.0F;
            gui.blit(i - 91, scaledHeight - 22 + posY, 0, 0, 182, 22);
            gui.blit(i - 91 - 1 + this.mc.player.inventory.currentItem * 20, scaledHeight - 22 + posY - 1, 0, 22, 24, 22);
            if(!itemstack.isEmpty())
                if(enumhandside == HandSide.LEFT)
                    gui.blit(i - 91 - 29, scaledHeight - 23 + posY, 24, 22, 29, 24);
                else
                    gui.blit(i + 91, scaledHeight - 23 + posY, 53, 22, 29, 24);

            zLevel = f;
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
                    GlStateManager.DestFactor.ZERO);
            RenderHelper.enableGUIStandardItemLighting();

            for(int l = 0; l < 9; ++l) {
                int i1 = i - 90 + l * 20 + 2;
                int j1 = scaledHeight - 16 - 3 + posY;
                this.renderHotbarItem(i1, j1, partialTicks, this.mc.player, this.mc.player.inventory.mainInventory.get(l));
            }

            if(!itemstack.isEmpty()) {
                int l1 = scaledHeight - 16 - 3 + posY;
                if(enumhandside == HandSide.LEFT)
                    this.renderHotbarItem(i - 91 - 26, l1, partialTicks, this.mc.player, itemstack);
                else
                    this.renderHotbarItem(i + 91 + 10, l1, partialTicks, this.mc.player, itemstack);
            }

            if(this.mc.gameSettings.attackIndicator == AttackIndicatorStatus.HOTBAR) {
                float f1 = this.mc.player.getCooledAttackStrength(0.0F);
                if(f1 < 1.0F) {
                    int i2 = scaledHeight - 20 + posY;
                    int j2 = i + 91 + 6;
                    if(enumhandside == HandSide.RIGHT)
                        j2 = i - 91 - 22;

                    this.mc.getTextureManager().bindTexture(AbstractGui.GUI_ICONS_LOCATION);
                    int k1 = (int) (f1 * 19.0F);
                    GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                    gui.blit(j2, i2, 0, 94, 18, 18);
                    gui.blit(j2, i2 + 18 - k1, 18, 112 - k1, 18, k1);
                }
            }

            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }

    /**
     * Renders an item on the screen
     * 
     * @param xPos         the x position on the screen
     * @param yPos         the y position on the screen
     * @param partialTicks the partial ticks (used for animation)
     * @param player       the player who should get the item rendered
     * @param item         the item (via ItemStack)
     */
    protected void renderHotbarItem(int x, int y, float partialTicks, PlayerEntity player, ItemStack item) {
        if(!item.isEmpty()) {
            float f = item.getAnimationsToGo() - partialTicks;
            if(f > 0.0F) {
                GlStateManager.pushMatrix();
                float f1 = 1.0F + f / 5.0F;
                GlStateManager.translatef(x + 8, y + 12, 0.0F);
                GlStateManager.scalef(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
                GlStateManager.translatef((-(x + 8)), (-(y + 12)), 0.0F);
            }

            this.mc.getItemRenderer().renderItemAndEffectIntoGUI(player, item, x, y);
            if(f > 0.0F)
                GlStateManager.popMatrix();

            this.mc.getItemRenderer().renderItemOverlays(this.mc.fontRenderer, item, x, y);
        }
    }

}
