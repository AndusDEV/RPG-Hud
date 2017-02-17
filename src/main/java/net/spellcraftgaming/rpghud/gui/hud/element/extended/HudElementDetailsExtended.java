package net.spellcraftgaming.rpghud.gui.hud.element.extended;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTippedArrow;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.spellcraftgaming.rpghud.gui.GuiIngameRPGHud;
import net.spellcraftgaming.rpghud.gui.hud.element.vanilla.HudElementDetailsVanilla;
import net.spellcraftgaming.rpghud.main.ModRPGHud;

public class HudElementDetailsExtended extends HudElementDetailsVanilla {

	protected int offset = 0;
	protected int count1;
	protected int count2;
	protected int count3;
	protected static final ItemStack nullStack = new ItemStack(Blocks.AIR);
	protected ItemStack itemMainHandLast = nullStack;
	protected ItemStack itemOffhandLast = nullStack;
	protected ItemStack itemMainHandLastArrow = nullStack;
	protected ItemStack itemArrow = nullStack;

	public HudElementDetailsExtended() {
		super();
	}

	@Override
	public boolean checkConditions() {
		return !this.mc.gameSettings.showDebugInfo && !((GuiIngameRPGHud) this.mc.ingameGUI).getChat().getChatOpen();
	}

	@Override
	public void drawElement(Gui gui, float zLevel, float partialTicks) {
		this.offset = 0;
		if (gui instanceof GuiIngameRPGHud) {
			if (this.settings.show_armor) {
				drawArmorDetails(gui);
			}
			drawItemDetails(gui, EnumHand.MAIN_HAND);
			drawItemDetails(gui, EnumHand.OFF_HAND);
			if (this.settings.show_arrowcount) {
				drawArrowCount(gui);
			}
		}
	}

	/**
	 * Draws the armor details
	 * 
	 * @param gui
	 *            the GUI to draw one
	 */
	@Override
	protected void drawArmorDetails(Gui gui) {
		this.mc.mcProfiler.startSection("armor_details");
		if (this.settings.reduce_size)
			GL11.glScaled(0.5D, 0.5D, 0.5D);
		for (int i = this.mc.thePlayer.inventory.armorInventory.length - 1; i >= 0; i--) {
			if (this.mc.thePlayer.inventory.armorItemInSlot(i) != null && this.mc.thePlayer.inventory.armorItemInSlot(i).getItem() instanceof ItemArmor) {
				this.mc.thePlayer.inventory.armorItemInSlot(i).getMaxDamage();
				ItemStack item = this.mc.thePlayer.inventory.armorItemInSlot(i);
				String s = (item.getMaxDamage() - item.getItemDamage()) + "/" + item.getMaxDamage();
				this.mc.getRenderItem().renderItemIntoGUI(item, this.settings.reduce_size ? 4 : 2, (this.settings.reduce_size ? 144 : 72) + this.offset);
				GL11.glDisable(GL11.GL_LIGHTING);
				gui.drawString(this.mc.fontRendererObj, s, 23, (this.settings.reduce_size ? 152 : 76) + this.offset, -1);
				this.offset += 16;
			}
		}
		if (this.settings.reduce_size)
			GL11.glScaled(2.0D, 2.0D, 2.0D);
		this.mc.mcProfiler.endSection();
	}

	/**
	 * Draws the held item details
	 * 
	 * @param gui
	 *            the GUI to draw on
	 * @param hand
	 *            the hand whose item should be detailed
	 */
	@Override
	protected void drawItemDetails(Gui gui, EnumHand hand) {
		ItemStack item = this.mc.thePlayer.getHeldItem(hand);
		if (item != null) {
			if (this.settings.show_itemdurability && item.isItemStackDamageable()) {
				if (this.settings.reduce_size)
					GL11.glScaled(0.5D, 0.5D, 0.5D);
				String s = (item.getMaxDamage() - item.getItemDamage()) + "/" + item.getMaxDamage();
				RenderHelper.enableGUIStandardItemLighting();
				this.mc.getRenderItem().renderItemIntoGUI(item, this.settings.reduce_size ? 4 : 2, (this.settings.reduce_size ? 144 : 72) + this.offset);
				GL11.glDisable(GL11.GL_LIGHTING);
				gui.drawString(this.mc.fontRendererObj, s, 23, (this.settings.reduce_size ? 152 : 76) + this.offset, -1);
				RenderHelper.disableStandardItemLighting();
				this.offset += 16;
				if (this.settings.reduce_size)
					GL11.glScaled(2.0D, 2.0D, 2.0D);
			} else if (this.settings.show_blockcount && item.getItem() instanceof ItemBlock) {
				int x = Minecraft.getMinecraft().thePlayer.inventory.getSizeInventory();
				int z = 0;
				if ((hand == EnumHand.MAIN_HAND ? ModRPGHud.renderDetailsAgain[0] : ModRPGHud.renderDetailsAgain[1]) || !ItemStack.areItemStacksEqual((hand == EnumHand.MAIN_HAND ? this.itemMainHandLast : this.itemOffhandLast), item) || !ItemStack.areItemStacksEqual(this.itemMainHandLast, item)) {
					if (hand == EnumHand.MAIN_HAND) {
						this.itemMainHandLast = item.copy();
						ModRPGHud.renderDetailsAgain[0] = false;
					} else {
						this.itemOffhandLast = item.copy();
						ModRPGHud.renderDetailsAgain[1] = false;
					}
					for (int y = 0; y < x; y++) {
						item = Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(y);
						if (item != null && Item.getIdFromItem(item.getItem()) == Item.getIdFromItem(this.mc.thePlayer.getHeldItem(hand).getItem())) {
							z += item.stackSize;
						}
					}
					if (hand == EnumHand.MAIN_HAND)
						this.count1 = z;
					else
						this.count2 = z;
				} else {
					if (hand == EnumHand.MAIN_HAND)
						z = this.count1;
					else
						z = this.count2;
				}

				item = this.mc.thePlayer.getHeldItem(hand);
				String s = "x " + z;
				if (this.settings.reduce_size)
					GL11.glScaled(0.5D, 0.5D, 0.5D);
				RenderHelper.enableGUIStandardItemLighting();
				this.mc.getRenderItem().renderItemIntoGUI(item, this.settings.reduce_size ? 4 : 2, (this.settings.reduce_size ? 144 : 72) + this.offset);
				GL11.glDisable(GL11.GL_LIGHTING);
				gui.drawString(this.mc.fontRendererObj, s, 23, (this.settings.reduce_size ? 152 : 76) + this.offset, -1);
				if (this.settings.reduce_size)
					GL11.glScaled(2.0D, 2.0D, 2.0D);
				this.offset += 16;
			}
		}
	}

	/**
	 * Draws the amount of arrows the player has in his inventory on the screen
	 * 
	 * @param gui
	 *            the GUI to draw on
	 */
	@Override
	protected void drawArrowCount(Gui gui) {
		ItemStack item = this.mc.thePlayer.getHeldItemMainhand();
		if (this.settings.show_arrowcount && item != null && this.mc.thePlayer.getHeldItemMainhand().getItem() instanceof ItemBow) {
			int x = Minecraft.getMinecraft().thePlayer.inventory.getSizeInventory();
			int z = 0;

			if (ModRPGHud.renderDetailsAgain[2] || !ItemStack.areItemStacksEqual(this.itemMainHandLastArrow, item)) {
				ModRPGHud.renderDetailsAgain[2] = false;

				item = findAmmo(this.mc.thePlayer);
				if(item != nullStack) {
					this.itemArrow = item.copy();
					PotionType type1 = null;
					if (item.getItem() instanceof ItemTippedArrow)
						type1 = PotionUtils.getPotionTypeFromNBT(item.getTagCompound());
					for (int y = 0; y < x; y++) {
						ItemStack item3 = Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(y);
						if (ItemStack.areItemsEqual(item, item3)) {
							if (item.getItem() instanceof ItemTippedArrow) {
								PotionType type2 = PotionUtils.getPotionTypeFromNBT(item3.getTagCompound());
								if (type1.getEffects() == type2.getEffects()) {
									z += item3.stackSize;
								}
							} else {
								z += item3.stackSize;
							}
						}
					}
					this.count3 = z;
				} else {
					this.count3 = 0;
				}
			} else {
				z = this.count3;
			}

			String s = "x " + z;
			if (this.settings.reduce_size)
				GL11.glScaled(0.5D, 0.5D, 0.5D);
			RenderHelper.enableGUIStandardItemLighting();
			if (this.itemArrow == nullStack){
				this.itemArrow = new ItemStack(Items.ARROW);
			}
			
			this.mc.getRenderItem().renderItemIntoGUI(item, this.settings.reduce_size ? 4 : 2, (this.settings.reduce_size ? 144 : 72) + this.offset);
			GL11.glDisable(GL11.GL_LIGHTING);
			gui.drawString(this.mc.fontRendererObj, s, 23, (this.settings.reduce_size ? 152 : 76) + this.offset, -1);
			if (this.settings.reduce_size)
				GL11.glScaled(2.0D, 2.0D, 2.0D);
			this.offset += 16;

		}
		if(item == nullStack || item == null) {
			this.itemMainHandLastArrow = nullStack;
		} else {
			this.itemMainHandLastArrow = item.copy();
		}
	}

}
