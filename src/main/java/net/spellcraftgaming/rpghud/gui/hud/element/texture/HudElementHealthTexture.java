package net.spellcraftgaming.rpghud.gui.hud.element.texture;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

@OnlyIn(Dist.CLIENT)
public class HudElementHealthTexture extends HudElement {

    public HudElementHealthTexture() {
        super(HudElementType.HEALTH, 0, 0, 0, 0, false);
        this.parent = HudElementType.WIDGET;
    }

    @Override
    public boolean checkConditions() {
        return !this.mc.gameSettings.hideGUI && this.mc.playerController.shouldDrawHUD();
    }

    @Override
    public void drawElement(Gui gui, float zLevel, float partialTicks, int scaledHeight, int scaledWidth) {
        this.bind(INTERFACE);
        GlStateManager.color3f(1f, 1f, 1f);
        int health = MathHelper.ceil(this.mc.player.getHealth());
        int absorption = MathHelper.ceil(this.mc.player.getAbsorptionAmount());
        int healthMax = MathHelper.ceil(this.mc.player.getMaxHealth());
        int posX = (this.settings.getBoolValue(Settings.render_player_face) ? 49 : 25) + this.settings.getPositionValue(Settings.health_position)[0];
        int posY = (this.settings.getBoolValue(Settings.render_player_face) ? 9 : 5) + this.settings.getPositionValue(Settings.health_position)[1];
        if(absorption > 1)
            gui.drawTexturedModalRect(posX, posY, 0, 88, (int) (110.0D * ((double) (health + absorption) / (double) (healthMax + absorption))), 12);
        if(this.mc.player.isPotionActive(MobEffects.POISON))
            gui.drawTexturedModalRect(posX, posY, 141, 160, (int) (110.0D * ((double) health / (double) (healthMax + absorption))), 12);
        else if(this.mc.player.isPotionActive(MobEffects.WITHER))
            gui.drawTexturedModalRect(posX, posY, 34, 244, (int) (110.0D * ((double) health / (double) (healthMax + absorption))), 12);
        else
            gui.drawTexturedModalRect(posX, posY, 0, 100, (int) (110.0D * ((double) health / (double) (healthMax + absorption))), 12);

        String stringHealth = this.settings.getBoolValue(Settings.health_percentage) ? (int) Math.floor((double) health / (double) healthMax * 100) + "%"
                : (health + absorption) + "/" + healthMax;
        if(this.settings.getBoolValue(Settings.show_numbers_health))
            gui.drawCenteredString(this.mc.fontRenderer, stringHealth, posX + 55, posY + 2, -1);
        GlStateManager.color3f(1f, 1f, 1f);
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
    }

}
