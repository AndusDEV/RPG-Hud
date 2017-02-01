package net.spellcraftgaming.rpghud.gui.hud.element.extended;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementBarred;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementHealthMountExtended extends HudElementBarred {

	public HudElementHealthMountExtended() {
		super(HudElementType.HEALTH_MOUNT, 0, 0, 0, 0, false);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.thePlayer.getRidingEntity() instanceof EntityLivingBase && this.mc.playerController.shouldDrawHUD();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		int[] colorHealth = getColor(this.settings.color_health);
		EntityLivingBase mount = (EntityLivingBase) this.mc.thePlayer.getRidingEntity();
		int health = (int) Math.ceil(mount.getHealth());
		int healthMax = (int) mount.getMaxHealth();
		drawCustomBar(53, 54, 88, 8, (double) health / (double) healthMax * 100.0D, 0, 0, colorHealth[0], colorHealth[1]);
		String stringHealth = health + "/" + healthMax;

		if (this.settings.show_numbers_health) {
			GlStateManager.scale(0.5, 0.5, 0.5);
			gui.drawCenteredString(this.mc.fontRendererObj, stringHealth, 194, 112, -1);
			GlStateManager.scale(2.0, 2.0, 2.0);
		}
	}

}
