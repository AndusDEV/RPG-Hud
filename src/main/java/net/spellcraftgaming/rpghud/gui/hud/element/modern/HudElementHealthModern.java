package net.spellcraftgaming.rpghud.gui.hud.element.modern;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.spellcraftgaming.rpghud.gui.hud.HudModern;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementBarred;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementHealthModern extends HudElementBarred{

	public HudElementHealthModern() {
		super(HudElementType.HEALTH, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.playerController.shouldDrawHUD();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		int health = MathHelper.ceiling_float_int(this.mc.thePlayer.getHealth());
		IAttributeInstance attrMaxHealth = this.mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth);
		int healthMax = (int) attrMaxHealth.getAttributeValue();
		int xOffset = ((HudModern) this.rpgHud.huds.get("modern")).getPosX();
		
		int width = this.mc.fontRendererObj.getStringWidth(healthMax + "/" + healthMax) / 2 + 4;
		((HudModern) this.rpgHud.huds.get("modern")).setPosX(width);
		String stringHealth = health + "/" + healthMax;
		if (this.settings.show_numbers_health && this.settings.show_numbers_stamina) {
			drawRect(this.settings.render_player_face ? 23 : 2, 4, width, 8, 0xA0000000);
			GL11.glScaled(0.5D, 0.5D, 0.5D);
			gui.drawCenteredString(this.mc.fontRendererObj, stringHealth, this.settings.render_player_face ? (xOffset * 2) + 28: 24, 12, -1);
			GL11.glScaled(2.0D, 2.0D, 2.0D);
		}
		
		int posX = (this.settings.render_player_face ? 24 : 2) + ((this.settings.show_numbers_health && this.settings.show_numbers_stamina) ? xOffset + 1: 0);
		drawTetragon(posX, posX, 3, 3, 97, 83, 10, 10, 0xA0000000);
		drawTetragon(posX + 2, posX + 2, 5, 5, 89, 79, 6, 6, 0x20FFFFFF);
		
		if (this.mc.thePlayer.isPotionActive(Potion.poison)) {
			drawTetragon(posX + 2, posX + 2, 5, 5, (int) (89 * ((double)health / (double) healthMax)), (int) (89 * ((double)health / (double) healthMax)) - 10, 6, 6, this.settings.color_poison);
		} else {
			drawTetragon(posX + 2, posX + 2, 5, 5, (int) (89 * ((double)health / (double) healthMax)), (int) (89 * ((double)health / (double) healthMax)) - 10, 6, 6, this.settings.color_health);
		}
	}

}
