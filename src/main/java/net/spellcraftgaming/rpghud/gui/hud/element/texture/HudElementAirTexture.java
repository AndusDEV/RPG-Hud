package net.spellcraftgaming.rpghud.gui.hud.element.texture;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.spellcraftgaming.lib.GameData;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

public class HudElementAirTexture extends HudElement {

    public HudElementAirTexture() {
        super(HudElementType.AIR, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return GameData.isPlayerUnderwater();
    }

    @Override
    public void drawElement(Gui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        bind(INTERFACE);
        GlStateManager.color(1f, 1f, 1f);
        int height = scaledHeight + this.settings.getPositionValue(Settings.air_position)[1];
        int adjustedWidth = (scaledWidth / 2) + this.settings.getPositionValue(Settings.air_position)[0];
        int airAmount = GameData.getPlayerAir();
        gui.drawTexturedModalRect(adjustedWidth - 70, height - 80, 0, 160, 141, 10);
        gui.drawTexturedModalRect(adjustedWidth - 70, height - 80, 0, 140, (int) (141.0D * (airAmount / 300.0D)), 10);
        GlStateManager.color(1f, 1f, 1f);
        GameData.bindIcons();
    }

}
