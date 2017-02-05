package net.spellcraftgaming.rpghud.gui.hud.element.texture;

import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementTexture;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public class HudElementFoodTexture extends HudElementTexture {

	public HudElementFoodTexture() {
		super(HudElementType.FOOD, 0, 0, 0, 0, true);
	}

	@Override
	public boolean checkConditions() {
		return this.mc.playerController.shouldDrawHUD();
	}
	
	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		bind(INTERFACE);
		int stamina = this.mc.thePlayer.getFoodStats().getFoodLevel();
		ItemStack currentItem = this.mc.thePlayer.getHeldItem();
		if (currentItem != null && currentItem.getItem() instanceof ItemFood && this.mc.thePlayer.getFoodStats().needFood() && this.settings.show_hunger_preview) {
			float value = ((ItemFood) this.mc.thePlayer.getHeldItem().getItem()).getHealAmount(this.mc.thePlayer.getHeldItem());
			int bonusHunger = (int) (value + stamina);
			if (bonusHunger > 20)
				bonusHunger = 20;
			gui.drawTexturedModalRect(49, 22, 141, 148, (int) (110.0D * (bonusHunger / 20.0D)), 12);
		}
		if (this.mc.thePlayer.isPotionActive(Potion.hunger)) {
			gui.drawTexturedModalRect(49, 22, 141, 136, (int) (110.0D * (stamina / 20.0D)), 12);
		} else {
			gui.drawTexturedModalRect(49, 22, 110, 100, (int) (110.0D * (stamina / 20.0D)), 12);
		}
		String staminaString = stamina + "/" + "20";
		if (this.settings.show_numbers_stamina)
			gui.drawCenteredString(this.mc.fontRendererObj, staminaString, 49 + 55, 24, -1);
		bind(Gui.icons);
	}

}
