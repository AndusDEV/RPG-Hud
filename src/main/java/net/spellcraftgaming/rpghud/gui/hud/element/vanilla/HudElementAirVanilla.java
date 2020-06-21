package net.spellcraftgaming.rpghud.gui.hud.element.vanilla;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.client.ForgeIngameGui;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;
import net.spellcraftgaming.rpghud.settings.Settings;

public class HudElementAirVanilla extends HudElement {

    public HudElementAirVanilla() {
        super(HudElementType.AIR, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return (this.mc.player.areEyesInFluid(FluidTags.WATER) || this.mc.player.getAir() < this.mc.player.getMaxAir()) && !this.mc.gameSettings.hideGUI
                && this.mc.playerController.shouldDrawHUD();
    }

    @Override
    public void drawElement(AbstractGui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        GlStateManager.enableBlend();
        int left = scaledWidth / 2 + 91 + this.settings.getPositionValue(Settings.air_position)[0];
        int top = scaledHeight - ForgeIngameGui.right_height + this.settings.getPositionValue(Settings.air_position)[1];

        int air = this.mc.player.getAir();
        int full = (int) Math.ceil((air - 2) * 10.0D / 300.0D);
        int partial = (int) (Math.ceil(air * 10.0D / 300.0D) - full);

        for(int i = 0; i < full + partial; ++i)
            gui.blit(left - i * 8 - 9, top, (i < full ? 16 : 25), 18, 9, 9);
        ForgeIngameGui.right_height += 10;
    }

}
