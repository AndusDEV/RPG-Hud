package net.spellcraftgaming.rpghud.gui.hud.element.texture;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

@OnlyIn(Dist.CLIENT)
public class HudElementHealthMountTexture extends HudElement {

    public HudElementHealthMountTexture() {
        super(HudElementType.HEALTH_MOUNT, 0, 0, 0, 0, false);
        this.parent = HudElementType.WIDGET;
    }

    @Override
    public boolean checkConditions() {
        return this.mc.player.getRidingEntity() instanceof LivingEntity && !this.mc.gameSettings.hideGUI && this.mc.playerController.shouldDrawHUD();
    }

    @Override
    public void drawElement(AbstractGui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        this.bind(INTERFACE);
        GlStateManager.color3f(1f, 1f, 1f);
        LivingEntity mount = (LivingEntity) this.mc.player.getRidingEntity();
        int health = (int) Math.ceil(mount.getHealth());
        int healthMax = (int) mount.getMaxHealth();
        int posX = (this.settings.getBoolValue(Settings.render_player_face) ? 53 : 25) + this.settings.getPositionValue(Settings.mount_health_position)[0];
        int posY = (this.settings.getBoolValue(Settings.render_player_face) ? 54 : 49) + this.settings.getPositionValue(Settings.mount_health_position)[1];

        gui.blit(posX, posY, 0, 124, (int) (88.0D * ((double) health / (double) healthMax)), 8);

        String stringHealth = this.settings.getBoolValue(Settings.mount_health_percentage) ? (int) Math.floor((double) health / (double) healthMax * 100) + "%"
                : health + "/" + healthMax;

        if(this.settings.getBoolValue(Settings.show_numbers_health)) {
            GlStateManager.scaled(0.5, 0.5, 0.5);
            gui.drawCenteredString(this.mc.fontRenderer, stringHealth, posX * 2 + 88, posY * 2 + 4, -1);
            GlStateManager.scaled(2.0, 2.0, 2.0);
        }
        GlStateManager.color3f(1f, 1f, 1f);
        this.mc.getTextureManager().bindTexture(AbstractGui.GUI_ICONS_LOCATION);
    }

}
