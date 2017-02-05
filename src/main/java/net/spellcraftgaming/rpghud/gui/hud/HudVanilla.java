package net.spellcraftgaming.rpghud.gui.hud;

import net.minecraft.client.Minecraft;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementEmpty;
import net.spellcraftgaming.rpghud.gui.hud.element.vanilla.*;

public class HudVanilla extends Hud {

	public HudVanilla(Minecraft mc, String hudKey, String hudName) {
		super(mc, hudKey, hudName);
	}

	@Override
	public HudElement setElementCrosshair() {
		return new HudElementCrosshairVanilla();
	}

	@Override
	public HudElement setElementHotbar() {
		return new HudElementHotbarVanilla();
	}

	@Override
	public HudElement setElementHealth() {
		return new HudElementHealthVanilla();
	}

	@Override
	public HudElement setElementFood() {
		return new HudElementFoodVanilla();
	}

	@Override
	public HudElement setElementArmor() {
		return new HudElementArmorVanilla();
	}

	@Override
	public HudElement setElementAir() {
		return new HudElementAirVanilla();
	}

	@Override
	public HudElement setElementExperience() {
		return new HudElementExperienceVanilla();
	}

	@Override
	public HudElement setElementLevel() {
		return new HudElementLevelVanilla();
	}

	@Override
	public HudElement setElementJumpBar() {
		return new HudElementJumpBarVanilla();
	}

	@Override
	public HudElement setElementHealthMount() {
		return new HudElementHealthMountVanilla();
	}

	@Override
	public HudElement setElementClock() {
		return new HudElementClockVanilla();
	}

	@Override
	public HudElement setElementDetails() {
		return new HudElementDetailsVanilla();
	}

	@Override
	public HudElement setElementWidget() {
		return new HudElementEmpty();
	}

	@Override
	public HudElement setElementRecordOverlay() {
		return new HudElementRecordOverlayVanilla();
	}

	@Override
	protected HudElement setElementChat() {
		return new HudElementChatVanilla();
	}

	@Override
	protected HudElement setElementCompass() {
		return new HudElementCompassVanilla();
	}
	
	@Override
	protected HudElement setElementPickup() {
		return new HudElementPickupVanilla();
	}
}
