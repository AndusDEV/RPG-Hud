package net.spellcraftgaming.rpghud.gui.hud.element.extended;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementTexture;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementWidgetExtended extends HudElementTexture {

	public HudElementWidgetExtended() {
		super(HudElementType.WIDGET, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.playerController.shouldDrawHUD();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		bind(INTERFACE);
		gui.drawTexturedModalRect(0, 0, 0, 50, 162, 50);
		if (this.mc.thePlayer.ridingEntity instanceof EntityLivingBase) {
			gui.drawTexturedModalRect(51, 44, 163, 0, 92, 20);
		}

		bind(getPlayerSkin(this.mc.thePlayer));
		GL11.glScaled(0.5D, 0.5D, 0.5D);
		gui.drawTexturedModalRect(34, 34, 32, 32, 32, 32);
		gui.drawTexturedModalRect(34, 34, 160, 32, 32, 32);
		GL11.glScaled(2.0D, 2.0D, 2.0D);
		bind(Gui.icons);
	}

}
