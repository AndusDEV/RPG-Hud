package net.spellcraftgaming.rpghud.gui.hud.element.defaulthud;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

@OnlyIn(Dist.CLIENT)
public class HudElementWidgetDefault extends HudElement {

    public HudElementWidgetDefault() {
        super(HudElementType.WIDGET, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return !this.mc.gameSettings.hideGUI && this.mc.playerController.shouldDrawHUD();
    }

    @Override
    public void drawElement(Gui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        this.bind(INTERFACE);
        int posX = this.settings.getPositionValue(Settings.widget_position)[0];
        int posY = this.settings.getPositionValue(Settings.widget_position)[1];
        gui.drawTexturedModalRect(posX + (this.settings.getBoolValue(Settings.render_player_face) ? 50 : 25),
                posY + (this.settings.getBoolValue(Settings.render_player_face) ? 8 : 0), 0, 0, 114, 35);
        if(this.mc.player.getRidingEntity() instanceof EntityLivingBase)
            gui.drawTexturedModalRect(posX + (this.settings.getBoolValue(Settings.render_player_face) ? 51 : 31),
                    posY + (this.settings.getBoolValue(Settings.render_player_face) ? 39 : 30), 164, 0, 92, 20);

        int facePosX = this.settings.getPositionValue(Settings.face_position)[0];
        int facePosY = this.settings.getPositionValue(Settings.face_position)[1];
        if(this.settings.getBoolValue(Settings.render_player_face)) {
            gui.drawTexturedModalRect(posX + facePosX, posY + facePosY, 114, 0, 50, 50);
            this.bind(getPlayerSkin(this.mc.player));
            GL11.glScaled(0.5D, 0.5D, 0.5D);
            gui.drawTexturedModalRect(posX * 2 + 34 + facePosX * 2, posY * 2 + 34 + facePosY * 2, 32, 32, 32, 32);
            gui.drawTexturedModalRect(posX * 2 + 34 + facePosX * 2, posY * 2 + 34 + facePosY * 2, 160, 32, 32, 32);
            GL11.glScaled(2.0D, 2.0D, 2.0D);
            this.mc.getTextureManager().bindTexture(Gui.ICONS);
        } else {
            gui.drawTexturedModalRect(posX, posY + (this.settings.getBoolValue(Settings.render_player_face) ? 11 : 3), 114, 50, 25, 29);
            this.mc.getTextureManager().bindTexture(Gui.ICONS);
        }
    }

}
