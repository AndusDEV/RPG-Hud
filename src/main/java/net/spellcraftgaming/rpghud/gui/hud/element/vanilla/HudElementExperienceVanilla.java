package net.spellcraftgaming.rpghud.gui.hud.element.vanilla;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.LivingEntity;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementExperienceVanilla extends HudElement {

    public HudElementExperienceVanilla() {
        super(HudElementType.EXPERIENCE, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return !(this.mc.player.getRidingEntity() instanceof LivingEntity) && !this.mc.gameSettings.hideGUI && this.mc.playerController.shouldDrawHUD();
    }

    @Override
    public void drawElement(AbstractGui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
        if(this.mc.playerController.gameIsSurvivalOrAdventure()) {
            this.mc.getTextureManager().bindTexture(AbstractGui.GUI_ICONS_LOCATION);
            int i = this.mc.player.xpBarCap();
            if(i > 0) {
                int k = (int) (this.mc.player.experience * 183.0F);
                int l = scaledHeight - 32 + 3;
                gui.blit(scaledWidth / 2 - 91, l, 0, 64, 182, 5);
                if(k > 0)
                    gui.blit(scaledWidth / 2 - 91, l, 0, 69, k, 5);
            }
        }
        GlStateManager.enableBlend();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
