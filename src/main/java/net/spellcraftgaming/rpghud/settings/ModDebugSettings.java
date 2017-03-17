package net.spellcraftgaming.rpghud.settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ModDebugSettings {

	/** Instance of Minecraft*/
	protected Minecraft mc;
	
	
	/** The file the settings are read from and wrote into*/
	private File settingFile;

	public boolean forceRenderCrosshair = false;
	public boolean renderVanillaCrosshair = false;
	public boolean preventEventCrosshair = false;
	public boolean preventElementRenderCrosshair = false;

	public boolean forceRenderArmor = false;
	public boolean renderVanillaArmor = false;
	public boolean preventEventArmor = false;
	public boolean preventElementRenderArmor = false;

	public boolean forceRenderHotbar = false;
	public boolean renderVanillaHotbar = false;
	public boolean preventEventHotbar = false;
	public boolean preventElementRenderHotbar = false;

	public boolean forceRenderAir = false;
	public boolean renderVanillaAir = false;
	public boolean preventEventAir = false;
	public boolean preventElementRenderAir = false;

	public boolean forceRenderHealth = false;
	public boolean renderVanillaHealth = false;
	public boolean preventEventHealth = false;
	public boolean preventElementRenderHealth = false;

	public boolean forceRenderFood = false;
	public boolean renderVanillaFood = false;
	public boolean preventEventFood = false;
	public boolean preventElementRenderFood = false;

	public boolean forceRenderExp = false;
	public boolean renderVanillaExp = false;
	public boolean preventEventExp = false;
	public boolean preventElementRenderExp = false;

	public boolean forceRenderExpLv = false;
	public boolean renderVanillaExpLv = false;
	public boolean preventEventExpLv = false;
	public boolean preventElementRenderExpLv = false;

	public boolean forceRenderHealthMount = false;
	public boolean renderVanillaHealthMount = false;
	public boolean preventEventHealthMount = false;
	public boolean preventElementRenderHealthMount = false;

	public boolean forceRenderJumpBar = false;
	public boolean renderVanillaJumpBar = false;
	public boolean preventEventJumpBar = false;
	public boolean preventElementRenderJumpBar = false;
	
	public boolean forceRenderChat = false;
	public boolean renderVanillaChat = false;
	public boolean preventEventChat = false;
	public boolean preventElementRenderChat = false;

	public ModDebugSettings(File file) {
		this.mc = Minecraft.getMinecraft();
		this.settingFile = new File(file, "RPGHud_settings_debug.txt");
		loadOptions();
	}

	/** Toggles the setting with the specified EnumOptionsDebugMod
	 * 
	 * @param option the EnumOptionsDebugMod to toggle
	 */
	public void setOptionValue(EnumOptionsDebugMod option) {
		if (option == EnumOptionsDebugMod.FORCE_RENDER_CROSSHAIR) {
			this.forceRenderCrosshair = !this.forceRenderCrosshair;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_CROSSHAIR) {
			this.renderVanillaCrosshair = !this.renderVanillaCrosshair;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_CROSSHAIR) {
			this.preventEventCrosshair = !this.preventEventCrosshair;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_CROSSHAIR) {
			this.preventElementRenderCrosshair = !this.preventElementRenderCrosshair;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_ARMOR) {
			this.forceRenderArmor = !this.forceRenderArmor;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_ARMOR) {
			this.renderVanillaArmor = !this.renderVanillaArmor;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_ARMOR) {
			this.preventEventArmor = !this.preventEventArmor;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_ARMOR) {
			this.preventElementRenderArmor = !this.preventElementRenderArmor;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_HOTBAR) {
			this.forceRenderHotbar = !this.forceRenderHotbar;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_HOTBAR) {
			this.renderVanillaHotbar = !this.renderVanillaHotbar;
			System.out.println(option + ":" + this.renderVanillaHotbar);
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_HOTBAR) {
			this.preventEventHotbar = !this.preventEventHotbar;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_HOTBAR) {
			this.preventElementRenderHotbar = !this.preventElementRenderHotbar;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_AIR) {
			this.forceRenderAir = !this.forceRenderAir;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_AIR) {
			this.renderVanillaAir = !this.renderVanillaAir;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_AIR) {
			this.preventEventAir = !this.preventEventAir;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_AIR) {
			this.preventElementRenderAir = !this.preventElementRenderAir;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_HEALTH) {
			this.forceRenderHealth = !this.forceRenderHealth;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_HEALTH) {
			this.renderVanillaHealth = !this.renderVanillaHealth;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_HEALTH) {
			this.preventEventHealth = !this.preventEventHealth;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_HEALTH) {
			this.preventElementRenderHealth = !this.preventElementRenderHealth;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_FOOD) {
			this.forceRenderFood = !this.forceRenderFood;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_FOOD) {
			this.renderVanillaFood = !this.renderVanillaFood;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_FOOD) {
			this.preventEventFood = !this.preventEventFood;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_FOOD) {
			this.preventElementRenderFood = !this.preventElementRenderFood;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_EXPERIENCE) {
			this.forceRenderExp = !this.forceRenderExp;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_EXPERIENCE) {
			this.renderVanillaExp = !this.renderVanillaExp;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_EXPERIENCE) {
			this.preventEventExp = !this.preventEventExp;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_EXPERIENCE) {
			this.preventElementRenderExp = !this.preventElementRenderExp;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_LEVEL) {
			this.forceRenderExpLv = !this.forceRenderExpLv;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_LEVEL) {
			this.renderVanillaExpLv = !this.renderVanillaExpLv;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_LEVEL) {
			this.preventEventExpLv = !this.preventEventExpLv;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_LEVEL) {
			this.preventElementRenderExpLv = !this.preventElementRenderExpLv;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_HEALTH_MOUNT) {
			this.forceRenderHealthMount = !this.forceRenderHealthMount;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_HEALTH_MOUNT) {
			this.renderVanillaHealthMount = !this.renderVanillaHealthMount;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_HEALTH_MOUNT) {
			this.preventEventHealthMount = !this.preventEventHealthMount;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_HEALTH_MOUNT) {
			this.preventElementRenderHealthMount = !this.preventElementRenderHealthMount;
		}

		if (option == EnumOptionsDebugMod.FORCE_RENDER_JUMP_BAR) {
			this.forceRenderJumpBar = !this.forceRenderJumpBar;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_JUMP_BAR) {
			this.renderVanillaJumpBar = !this.renderVanillaJumpBar;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_JUMP_BAR) {
			this.preventEventJumpBar = !this.preventEventJumpBar;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_JUMP_BAR) {
			this.preventElementRenderJumpBar = !this.preventElementRenderJumpBar;
		}
		
		if (option == EnumOptionsDebugMod.FORCE_RENDER_CHAT) {
			this.forceRenderChat = !this.forceRenderChat;
		}
		if (option == EnumOptionsDebugMod.RENDER_VANILLA_CHAT) {
			this.renderVanillaChat = !this.renderVanillaChat;
		}
		if (option == EnumOptionsDebugMod.PREVENT_EVENT_CHAT) {
			this.preventEventChat = !this.preventEventChat;
		}
		if (option == EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_CHAT) {
			this.preventElementRenderChat = !this.preventElementRenderChat;
		}

		saveOptions();
	}

	static final class SwitchOptions {
		static final int[] optionIds = new int[EnumOptionsDebugMod.values().length];

		static {
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_CROSSHAIR.ordinal()] = 0;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_CROSSHAIR.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_CROSSHAIR.ordinal()] = 2;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_CROSSHAIR.ordinal()] = 3;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_ARMOR.ordinal()] = 4;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_ARMOR.ordinal()] = 5;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_ARMOR.ordinal()] = 6;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_ARMOR.ordinal()] = 7;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_HOTBAR.ordinal()] = 8;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_HOTBAR.ordinal()] = 9;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_HOTBAR.ordinal()] = 10;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_HOTBAR.ordinal()] = 11;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_AIR.ordinal()] = 12;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_AIR.ordinal()] = 13;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_AIR.ordinal()] = 14;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_AIR.ordinal()] = 15;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_HEALTH.ordinal()] = 16;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_HEALTH.ordinal()] = 17;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_HEALTH.ordinal()] = 18;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_HEALTH.ordinal()] = 19;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_FOOD.ordinal()] = 20;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_FOOD.ordinal()] = 21;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_FOOD.ordinal()] = 22;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_FOOD.ordinal()] = 23;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_EXPERIENCE.ordinal()] = 24;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_EXPERIENCE.ordinal()] = 25;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_EXPERIENCE.ordinal()] = 26;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_EXPERIENCE.ordinal()] = 27;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_LEVEL.ordinal()] = 28;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_LEVEL.ordinal()] = 29;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_LEVEL.ordinal()] = 30;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_LEVEL.ordinal()] = 31;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_HEALTH_MOUNT.ordinal()] = 32;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_HEALTH_MOUNT.ordinal()] = 33;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_HEALTH_MOUNT.ordinal()] = 34;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_HEALTH_MOUNT.ordinal()] = 35;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_JUMP_BAR.ordinal()] = 36;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_JUMP_BAR.ordinal()] = 37;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_JUMP_BAR.ordinal()] = 38;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_JUMP_BAR.ordinal()] = 39;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.FORCE_RENDER_CHAT.ordinal()] = 40;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.RENDER_VANILLA_CHAT.ordinal()] = 41;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_EVENT_CHAT.ordinal()] = 42;
			} catch (NoSuchFieldError e) {
			}
			try {
				optionIds[EnumOptionsDebugMod.PREVENT_ELEMENT_RENDER_CHAT.ordinal()] = 43;
			} catch (NoSuchFieldError e) {
			}
		}
	}

	/**Returns the ordinal value of this setting*/
	public boolean getOptionOrdinalValue(EnumOptionsDebugMod options) {
		switch (ModDebugSettings.SwitchOptions.optionIds[options.ordinal()]) {
		case 0:
			return this.forceRenderCrosshair;
		case 1:
			return this.renderVanillaCrosshair;
		case 2:
			return this.preventEventCrosshair;
		case 3:
			return this.preventElementRenderCrosshair;

		case 4:
			return this.forceRenderArmor;
		case 5:
			return this.renderVanillaArmor;
		case 6:
			return this.preventEventArmor;
		case 7:
			return this.preventElementRenderArmor;

		case 8:
			return this.forceRenderHotbar;
		case 9:
			return this.renderVanillaHotbar;
		case 10:
			return this.preventEventHotbar;
		case 11:
			return this.preventElementRenderHotbar;

		case 12:
			return this.forceRenderAir;
		case 13:
			return this.renderVanillaAir;
		case 14:
			return this.preventEventAir;
		case 15:
			return this.preventElementRenderAir;

		case 16:
			return this.forceRenderHealth;
		case 17:
			return this.renderVanillaHealth;
		case 18:
			return this.preventEventHealth;
		case 19:
			return this.preventElementRenderHealth;

		case 20:
			return this.forceRenderFood;
		case 21:
			return this.renderVanillaFood;
		case 22:
			return this.preventEventFood;
		case 23:
			return this.preventElementRenderFood;

		case 24:
			return this.forceRenderExp;
		case 25:
			return this.renderVanillaExp;
		case 26:
			return this.preventEventExp;
		case 27:
			return this.preventElementRenderExp;

		case 28:
			return this.forceRenderExpLv;
		case 29:
			return this.renderVanillaExpLv;
		case 30:
			return this.preventEventExpLv;
		case 31:
			return this.preventElementRenderExpLv;

		case 32:
			return this.forceRenderHealthMount;
		case 33:
			return this.renderVanillaHealthMount;
		case 34:
			return this.preventEventHealthMount;
		case 35:
			return this.preventElementRenderHealthMount;

		case 36:
			return this.forceRenderJumpBar;
		case 37:
			return this.renderVanillaJumpBar;
		case 38:
			return this.preventEventJumpBar;
		case 39:
			return this.preventElementRenderJumpBar;
			
		case 40:
			return this.forceRenderChat;
		case 41:
			return this.renderVanillaChat;
		case 42:
			return this.preventEventChat;
		case 43:
			return this.preventElementRenderChat;

		default:
			return false;
		}
	}

	/** Loads the settings from the file */
	public void loadOptions() {
		try {
			if (!this.settingFile.exists()) {
				return;
			}
			BufferedReader reader = new BufferedReader(new FileReader(this.settingFile));
			String s = "";
			while ((s = reader.readLine()) != null) {
				try {
					String[] string = s.split(":");
					if (string[0].equals("forceRenderCrosshair")) {
						this.forceRenderCrosshair = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaCrosshair")) {
						this.renderVanillaCrosshair = string[1].equals("true");
					}
					if (string[0].equals("preventEventCrosshair")) {
						this.preventEventCrosshair = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderCrosshair")) {
						this.preventElementRenderCrosshair = string[1].equals("true");
					}

					if (string[0].equals("forceRenderArmor")) {
						this.forceRenderArmor = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaArmor")) {
						this.renderVanillaArmor = string[1].equals("true");
					}
					if (string[0].equals("preventEventArmor")) {
						this.preventEventArmor = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderArmor")) {
						this.preventElementRenderArmor = string[1].equals("true");
					}

					if (string[0].equals("forceRenderHotbar")) {
						this.forceRenderHotbar = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaHotbar")) {
						this.renderVanillaHotbar = string[1].equals("true");
					}
					if (string[0].equals("preventEventHotbar")) {
						this.preventEventHotbar = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderHotbar")) {
						this.preventElementRenderHotbar = string[1].equals("true");
					}

					if (string[0].equals("forceRenderAir")) {
						this.forceRenderAir = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaAir")) {
						this.renderVanillaAir = string[1].equals("true");
					}
					if (string[0].equals("preventEventAir")) {
						this.preventEventAir = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderAir")) {
						this.preventElementRenderAir = string[1].equals("true");
					}

					if (string[0].equals("forceRenderHealth")) {
						this.forceRenderHealth = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaHealth")) {
						this.renderVanillaHealth = string[1].equals("true");
					}
					if (string[0].equals("preventEventHealth")) {
						this.preventEventHealth = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderHealth")) {
						this.preventElementRenderHealth = string[1].equals("true");
					}

					if (string[0].equals("forceRenderFood")) {
						this.forceRenderFood = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaFood")) {
						this.renderVanillaFood = string[1].equals("true");
					}
					if (string[0].equals("preventEventFood")) {
						this.preventEventFood = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderFood")) {
						this.preventElementRenderFood = string[1].equals("true");
					}

					if (string[0].equals("forceRenderExp")) {
						this.forceRenderExp = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaExp")) {
						this.renderVanillaExp = string[1].equals("true");
					}
					if (string[0].equals("preventEventExp")) {
						this.preventEventExp = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderExp")) {
						this.preventElementRenderExp = string[1].equals("true");
					}

					if (string[0].equals("forceRenderExpLv")) {
						this.forceRenderExpLv = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaExpLv")) {
						this.renderVanillaExpLv = string[1].equals("true");
					}
					if (string[0].equals("preventEventExpLv")) {
						this.preventEventExpLv = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderExpLv")) {
						this.preventElementRenderExpLv = string[1].equals("true");
					}

					if (string[0].equals("forceRenderHealthMount")) {
						this.forceRenderHealthMount = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaHealthMount")) {
						this.renderVanillaHealthMount = string[1].equals("true");
					}
					if (string[0].equals("preventEventHealthMount")) {
						this.preventEventHealthMount = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderHealthMount")) {
						this.preventElementRenderHealthMount = string[1].equals("true");
					}

					if (string[0].equals("forceRenderJumpBar")) {
						this.forceRenderJumpBar = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaJumpBar")) {
						this.renderVanillaJumpBar = string[1].equals("true");
					}
					if (string[0].equals("preventEventJumpBar")) {
						this.preventEventJumpBar = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderJumpBar")) {
						this.preventElementRenderJumpBar = string[1].equals("true");
					}
					
					if (string[0].equals("forceRenderChat")) {
						this.forceRenderChat = string[1].equals("true");
					}
					if (string[0].equals("renderVanillaChat")) {
						this.renderVanillaChat = string[1].equals("true");
					}
					if (string[0].equals("preventEventChat")) {
						this.preventEventChat = string[1].equals("true");
					}
					if (string[0].equals("preventElementRenderChat")) {
						this.preventElementRenderChat = string[1].equals("true");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Returns the String of the Button for the specified setting
	 * 
	 * @param option the option whose button text will be returned
	 * @return the String
	 */
	public String getKeyBinding(EnumOptionsDebugMod option) {
		String s = option.getEnumString() + ": ";
		boolean flag = this.getOptionOrdinalValue(option);
		return flag ? s + I18n.format("options.on", new Object[0]) : s + I18n.format("options.off", new Object[0]);
	}

	/** Saves the settings to the file*/
	public void saveOptions() {
		if (!FMLClientHandler.instance().isLoading()) {
			try {
				PrintWriter exception = new PrintWriter(new FileWriter(this.settingFile));
				exception.println("forceRenderCrosshair:" + this.forceRenderCrosshair);
				exception.println("renderVanillaCrosshair:" + this.renderVanillaCrosshair);
				exception.println("preventEventCrosshair:" + this.preventEventCrosshair);
				exception.println("preventElementRenderCrosshair:" + this.preventElementRenderCrosshair);

				exception.println("forceRenderArmor:" + this.forceRenderArmor);
				exception.println("renderVanillaArmor:" + this.renderVanillaArmor);
				exception.println("preventEventArmor:" + this.preventEventArmor);
				exception.println("preventElementRenderArmor:" + this.preventElementRenderArmor);

				exception.println("forceRenderHotbar:" + this.forceRenderHotbar);
				exception.println("renderVanillaHotbar:" + this.renderVanillaHotbar);
				exception.println("preventEventHotbar:" + this.preventEventHotbar);
				exception.println("preventElementRenderHotbar:" + this.preventElementRenderHotbar);

				exception.println("forceRenderAir:" + this.forceRenderAir);
				exception.println("renderVanillaAir:" + this.renderVanillaAir);
				exception.println("preventEventAir:" + this.preventEventAir);
				exception.println("preventElementRenderAir:" + this.preventElementRenderAir);

				exception.println("forceRenderHealth:" + this.forceRenderHealth);
				exception.println("renderVanillaHealth:" + this.renderVanillaHealth);
				exception.println("preventEventHealth:" + this.preventEventHealth);
				exception.println("preventElementRenderHealth:" + this.preventElementRenderHealth);

				exception.println("forceRenderFood:" + this.forceRenderFood);
				exception.println("renderVanillaFood:" + this.renderVanillaFood);
				exception.println("preventEventFood:" + this.preventEventFood);
				exception.println("preventElementRenderFood:" + this.preventElementRenderFood);

				exception.println("forceRenderExp:" + this.forceRenderExp);
				exception.println("renderVanillaExp:" + this.renderVanillaExp);
				exception.println("preventEventExp:" + this.preventEventExp);
				exception.println("preventElementRenderExp:" + this.preventElementRenderExp);

				exception.println("forceRenderExpLv:" + this.forceRenderExpLv);
				exception.println("renderVanillaExpLv:" + this.renderVanillaExpLv);
				exception.println("preventEventExpLv:" + this.preventEventExpLv);
				exception.println("preventElementRenderExpLv:" + this.preventElementRenderExpLv);

				exception.println("forceRenderHealthMount:" + this.forceRenderHealthMount);
				exception.println("renderVanillaHealthMount:" + this.renderVanillaHealthMount);
				exception.println("preventEventHealthMount:" + this.preventEventHealthMount);
				exception.println("preventElementRenderHealthMount:" + this.preventElementRenderHealthMount);

				exception.println("forceRenderJumpBar:" + this.forceRenderJumpBar);
				exception.println("renderVanillaJumpBar:" + this.renderVanillaJumpBar);
				exception.println("preventEventJumpBar:" + this.preventEventJumpBar);
				exception.println("preventElementRenderJumpBar:" + this.preventElementRenderJumpBar);
				
				exception.println("forceRenderChat:" + this.forceRenderChat);
				exception.println("renderVanillaChat:" + this.renderVanillaChat);
				exception.println("preventEventChat:" + this.preventEventChat);
				exception.println("preventElementRenderChat:" + this.preventElementRenderChat);

				exception.close();
			} catch (Exception var2) {
				var2.printStackTrace();
			}
		}
	}
}
