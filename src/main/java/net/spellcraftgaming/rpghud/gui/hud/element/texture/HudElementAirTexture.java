package net.spellcraftgaming.rpghud.gui.hud.element.texture;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

@OnlyIn(Dist.CLIENT)
public class HudElementAirTexture extends HudElement {

    public HudElementAirTexture() {
        super(HudElementType.AIR, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return (this.mc.player.areEyesInFluid(FluidTags.WATER) || this.mc.player.getAir() < this.mc.player.getMaxAir()) && !this.mc.gameSettings.hideGUI
                && this.mc.playerController.shouldDrawHUD();
    }

    @Override
    public void drawElement(Gui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        this.bind(INTERFACE);
        GlStateManager.color3f(1f, 1f, 1f);
        int height = scaledHeight + this.settings.getPositionValue(Settings.air_position)[1];
        int adjustedWidth = (scaledWidth / 2) + this.settings.getPositionValue(Settings.air_position)[0];
        int airAmount = this.mc.player.getAir();
        double maxAir = this.mc.player.getMaxAir();
        gui.drawTexturedModalRect(adjustedWidth - 70, height - 80, 0, 160, 141, 10);
        gui.drawTexturedModalRect(adjustedWidth - 70, height - 80, 0, 140, (int) (141.0D * (airAmount / maxAir)), 10);
        GlStateManager.color3f(1f, 1f, 1f);
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
    }

}
