package net.spellcraftgaming.rpghud.gui.hud.element.hotbar;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementBarred;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementHealthHotbar extends HudElementBarred {

	public HudElementHealthHotbar() {
		super(HudElementType.HEALTH, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.playerController.shouldDrawHUD() && !(this.mc.thePlayer.ridingEntity instanceof EntityLivingBase);
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		ScaledResolution res = new ScaledResolution(this.mc);
		int height = res.getScaledHeight();
		int health = MathHelper.ceiling_float_int(this.mc.thePlayer.getHealth());
		int posX = this.settings.render_player_face ? 49 : 25;
		IAttributeInstance attrMaxHealth = this.mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth);
		int healthMax = (int) attrMaxHealth.getAttributeValue();
		int absorption = MathHelper.floor_float(this.mc.thePlayer.getAbsorptionAmount());
		
		if(absorption > 1) drawCustomBar(posX, height - 56, 200, 10, (double) (health + absorption) / (double) (healthMax + absorption) * 100D, -1, -1, this.settings.color_absorption, offsetColorPercent(this.settings.color_absorption, OFFSET_PERCENT));
		
		if (this.mc.thePlayer.isPotionActive(Potion.poison)) {
			drawCustomBar(posX, height - 56, 200, 10, (double) health / (double) (healthMax + absorption) * 100D, -1, -1, this.settings.color_poison, offsetColorPercent(this.settings.color_poison, OFFSET_PERCENT));
		} else {
			drawCustomBar(posX, height - 56, 200, 10, (double) health / (double) (healthMax + absorption) * 100D, -1, -1, this.settings.color_health, offsetColorPercent(this.settings.color_health, OFFSET_PERCENT));
		}
		String stringHealth = (health + absorption) + "/" + healthMax;
		if (this.settings.show_numbers_health)
			gui.drawCenteredString(this.mc.fontRendererObj, stringHealth, posX + 100, height - 55, -1);
	}
}
