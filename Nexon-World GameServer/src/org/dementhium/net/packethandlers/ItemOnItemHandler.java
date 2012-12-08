package org.dementhium.net.packethandlers;

import org.dementhium.content.misc.Decanting;
import org.dementhium.content.skills.Firemaking;
import org.dementhium.content.skills.Fletching;
import org.dementhium.content.skills.crafting.GemCutting;
import org.dementhium.content.skills.crafting.LeatherCrafting;
import org.dementhium.content.skills.herblore.Herblore;
import org.dementhium.content.skills.magic.Enchant;
import org.dementhium.model.Item;
import org.dementhium.model.World;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.net.ActionSender;
import org.dementhium.net.PacketHandler;
import org.dementhium.net.message.Message;
import org.dementhium.tickable.Tick;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author Steve <golden_32@live.com>
 * @author Lumby <lumbyjr@hotmail.com>
 */
public class ItemOnItemHandler extends PacketHandler {

	private static final int ITEM_ON_ITEM = 3;

	@Override
	public void handlePacket(Player player, Message packet) {
		switch (packet.getOpcode()) {
		case ITEM_ON_ITEM:
			handleItemOnItem(player, packet);
			break;
		}

	}

	private void handleItemOnItem(Player player, Message packet) {
		int interfaceId1 = packet.readShort();
		packet.readShort();
		int usedWithSlot = packet.readShort();
		int itemUsed = packet.readLEShort();
		int usedSlot = packet.readShort();
		int interfaceId2 = packet.readShort();
		int childId = packet.readShort();
		int itemUsedWith = packet.readLEShortA();

		Item firstItem = player.getInventory().get(usedSlot);
		Item secondItem = player.getInventory().get(usedWithSlot);
		if (interfaceId1 == 149) {
			switch (childId) {
			case 38:
				lowAlch(player, itemUsed, usedSlot);
				break;
			case 59:
				highAlch(player, itemUsed, usedSlot);
				break;
			case 17:
			case 74:
			default:
			}
		}
		if (Enchant.enchant(player, childId, itemUsed, usedSlot))
			return;
		if (firstItem == null || secondItem == null) {
			return;
		}
		if (firstItem.getId() != itemUsed || secondItem.getId() != itemUsedWith) {
			return;
		}
		if (usedWithSlot == usedSlot) {
			return;
		}
		ActionSender.sendCloseChatBox(player);
		if (Fletching.getItemForId(itemUsed, itemUsedWith, false) != null) {
			Fletching.sendInterfaces(player,
					Fletching.getItemForId(itemUsed, itemUsedWith, false));
			return;
		} else if (Firemaking.firemake(player, itemUsed, itemUsedWith,
				usedWithSlot, usedSlot, false)) {
			return;
		} else if (GemCutting.cutGem(player, itemUsed, itemUsedWith)) {
			return;
		} else if (LeatherCrafting.handleItemOnItem(player, firstItem,
				secondItem)) {
			return;
		} else if (Decanting.decantPotion(player, usedSlot, usedWithSlot)) {
			return;
		}
		int item = Herblore.isHerbloreSkill(new Item(itemUsed), new Item(
				itemUsedWith));
		if (item > -1) {
			player.setAttribute("itemUsedSkill", new Item(itemUsed));
			player.setAttribute("itemUsedSkill2", new Item(itemUsedWith));
			Herblore.sendInterface(player, item, new Item(itemUsed), new Item(
					itemUsedWith));
			return;
		}
		if (itemUsed == 985 && itemUsedWith == 987 || itemUsed == 987
				&& itemUsedWith == 985) {
			player.getInventory().getContainer().remove(new Item(985, 1));
			player.getInventory().getContainer().remove(new Item(987, 1));
			player.getInventory().addItem(989, 1);
			player.sendMessage("You join the two halves of the key together");
			return;
		}
 		if ((itemUsed == 11690 && itemUsedWith == 11704) || (itemUsed == 11704 && itemUsedWith == 11690)) {
 			player.getInventory().set(usedSlot, null);
 			player.getInventory().set(usedWithSlot, null);
 			player.getInventory().set(usedSlot, new Item(11696, 1));
			player.getInventory().refresh();
			player.sendMessage("You attach the hilt to the blade and make a Bandos godsword.");
			return;
		} else if ((itemUsed == 11690 && itemUsedWith == 11706) || (itemUsed == 11706 && itemUsedWith == 11690)) {
 			player.getInventory().set(usedSlot, null);
 			player.getInventory().set(usedWithSlot, null);
 			player.getInventory().set(usedSlot, new Item(11698, 1));
			player.getInventory().refresh();
			player.sendMessage("You attach the hilt to the blade and make a Saradomin godsword.");
			return;
		} else if ((itemUsed == 11690 && itemUsedWith == 11708) || (itemUsed == 11708 && itemUsedWith == 11690)) {
 			player.getInventory().set(usedSlot, null);
 			player.getInventory().set(usedWithSlot, null);
 			player.getInventory().set(usedSlot, new Item(11700, 1));
			player.getInventory().refresh();
			player.sendMessage("You attach the hilt to the blade and make a Zamorak godsword.");
			return;
		} else if ((itemUsed == 11690 && itemUsedWith == 11702) || (itemUsed == 11702 && itemUsedWith == 11690)) {
 			player.getInventory().set(usedSlot, null);
 			player.getInventory().set(usedWithSlot, null);
 			player.getInventory().set(usedSlot, new Item(11694, 1));
			player.getInventory().refresh();
			player.sendMessage("You attach the hilt to the blade and make an Armadyl godsword.");
			return;
		}
		else if (((itemUsed == 11710 && itemUsedWith == 11712) || (itemUsed == 11712 && itemUsedWith == 11710))
				|| ((itemUsed == 11710 && itemUsedWith == 11714) || (itemUsed == 11714 && itemUsedWith == 11710))
				|| ((itemUsed == 11712 && itemUsedWith == 11714) || (itemUsed == 11714 && itemUsedWith == 11712))
				|| ((itemUsed == 11710 && itemUsedWith == 11692) || (itemUsed == 11692 && itemUsedWith == 11710))
				|| ((itemUsed == 11712 && itemUsedWith == 11688) || (itemUsed == 11688 && itemUsedWith == 11712))
				|| ((itemUsed == 11714 && itemUsedWith == 11686) || (itemUsed == 11686 && itemUsedWith == 11714))) {
			player.sendMessage("Those pieces of the godsword can't be joined together like that - try forging them.");
			return;
		}
		else if (itemUsed == 13734 && itemUsedWith == 13754) {
			player.getInventory().getContainer().remove(new Item(13734, 1));
			player.getInventory().getContainer().remove(new Item(13754, 1));
			player.getInventory().addItem(13736, 1);
			player.sendMessage("You pour the holy elixir on the spirit shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsedWith == 13752) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13752, 1));
			player.getInventory().addItem(13744, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsedWith == 13746 || itemUsed == 13746
				&& itemUsedWith == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13746, 1));
			player.getInventory().addItem(13738, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		} else if (itemUsed == 13736 && itemUsedWith == 13750 || itemUsed == 13750
				&& itemUsedWith == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13750, 1));
			player.getInventory().addItem(13742, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsedWith == 13748 || itemUsed == 13748
				&& itemUsedWith == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13748, 1));
			player.getInventory().addItem(13740, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
			if (itemUsed == 4164 && itemUsedWith == 4166 || itemUsed == 4164 && itemUsedWith == 4168 || 
				itemUsed == 4164 && itemUsedWith == 4551 || itemUsed == 4164 && itemUsedWith == 8921 || 
				itemUsed == 4166 && itemUsedWith == 4164 || itemUsed == 4166 && itemUsedWith == 4168 || 
				itemUsed == 4166 && itemUsedWith == 4551 || itemUsed == 4166 && itemUsedWith == 8921 || 
				itemUsed == 4168 && itemUsedWith == 4164 || itemUsed == 4168 && itemUsedWith == 4166 || 
				itemUsed == 4168 && itemUsedWith == 4551 || itemUsed == 4168 && itemUsedWith == 8921 || 
				itemUsed == 4551 && itemUsedWith == 4164 || itemUsed == 4551 && itemUsedWith == 4166 || 
				itemUsed == 4551 && itemUsedWith == 4168 || itemUsed == 4551 && itemUsedWith == 8921 ||
				itemUsed == 8921 && itemUsedWith == 4164 || itemUsed == 8921 && itemUsedWith == 4166 ||
				itemUsed == 8921 && itemUsedWith == 4168 || itemUsed == 8921 && itemUsedWith == 4551 ) {
			if (player.getInventory().contains(4164) && player.getInventory().contains(4166) && 
				player.getInventory().contains(4168) && player.getInventory().contains(4551) && 
				player.getInventory().contains(8921)) {
			if (player.getSkills().getLevel(Skills.CRAFTING) < 55) {
				player.sendMessage("You need a crafting level of 55 to do this.");
				return;
			}
			if (!player.hasLearned()) {
				player.sendMessage("You haven't learned how to do this.");
				return;
			}
			player.getInventory().getContainer().remove(new Item(4164, 1));
			player.getInventory().getContainer().remove(new Item(4166, 1));
			player.getInventory().getContainer().remove(new Item(4168, 1));
			player.getInventory().getContainer().remove(new Item(4551, 1));
			player.getInventory().getContainer().remove(new Item(8921, 1));
			player.getInventory().addItem(13263, 1);
			player.sendMessage("You attatch the equipment to get a Slayer helmet.");
			return;
		} else {
			player.sendMessage("You don't have the required items to do this.");
		}
	}
		if (itemUsed == 4155 && itemUsedWith == 1635 || itemUsed == 1635 && itemUsedWith == 4155) {
			if (player.getLearnedRing() < 1) {
				player.sendMessage("You haven't learned how to do this yet.");
				return;
			}
			if (player.getSkills().getLevel(Skills.CRAFTING) < 55) {
				player.sendMessage("You need a crafting level of 55 to do this.");
				return;
			}
				player.getInventory().addItem(13281, 1);
		}

		if (itemUsed == 13263 && itemUsedWith == 15488 || itemUsed == 13263 && itemUsedWith == 15490 ||
					itemUsed == 15488 && itemUsedWith == 13263 || itemUsed == 15488 && itemUsedWith == 15490 ||
					itemUsed == 15490 && itemUsedWith == 13263 || itemUsed == 15490 && itemUsedWith == 15488) {
			if (player.getInventory().contains(13263) && player.getInventory().contains(15490) && 
				player.getInventory().contains(15488)) {
			if (player.getSkills().getLevel(Skills.CRAFTING) < 55) {
				player.sendMessage("You need a crafting level of 55 to do this.");
				return;
			}
			if (!player.hasLearned()) {
				player.sendMessage("You haven't learned how to do this.");
				return;
			}
				player.getInventory().getContainer().remove(new Item(13263, 1));
				player.getInventory().getContainer().remove(new Item(15488, 1));
				player.getInventory().getContainer().remove(new Item(15490, 1));
				player.getInventory().addItem(15492, 1);
				player.sendMessage("You attatch the Hexcrest and Focus sight to the slayer helm.");
			} else {
				player.sendMessage("You don't have the required items to do this.");
			}
			return;
		}
		if (player.getRights() == 2)
			player.sendMessage("Unhandled option on item action: "
					+ interfaceId1 + ", " + childId + ", " + interfaceId2 + ".");
		//player.sendMessage("Nothing interesting happens.");
	}

	private boolean hasFireStaff(Player player) {
		if (player.getEquipment().getContainer().contains(new Item(1387))
				|| player.getEquipment().getContainer()
						.contains(new Item(1393))
				|| player.getEquipment().getContainer()
						.contains(new Item(1401))
				|| player.getEquipment().getContainer()
						.contains(new Item(3053))
				|| player.getEquipment().getContainer()
						.contains(new Item(3054))) {
			return true;
		}
		return false;
	}

	private void lowAlch(final Player player, int itemId, int slot) {
		System.out.println("HI");
		if (player.getSkills().getLevel(Skills.MAGIC) < 21) {
			player.sendMessage("You need a higher magic level to cast this spell.");
			return;
		} else if (player.getAttribute("alching") != null) {
			player.sendMessage("You are already casting an alchemy spell.");
			return;
		} else if (!player.getInventory().getContainer()
				.contains(new Item(561, 1))) {
			player.sendMessage("You do not have the required runes or staff to cast that.");
			return;
		} else if (!player.getInventory().getContainer()
				.contains(new Item(554, 3))
				&& !hasFireStaff(player)) {
			player.sendMessage("You do not have the required runes or staff to cast that.");
			return;
		} else {

			final double alcValue = player.getInventory().getContainer()
					.get(slot).getDefinition().getLowAlchPrice();
			if (alcValue == 0) {
				player.sendMessage("This item has no alchemy value. Please report it to an administrator.");
				return;
			}
			if (itemId == 995) {
				player.sendMessage("You cannot cast an alchemy spell on money.");
				return;
			}
			if (player.getInventory().getContainer().getFreeSlots() == 0
					&& !player.getInventory().getContainer()
							.contains(new Item(995))) {
				player.sendMessage("You do not have any room in your inventory to cast an alchemy spell.");
				return;
			}
			if (hasFireStaff(player)) {
				player.animate(9625);
				player.graphics(1692);
			} else {
				player.animate(712);
				player.graphics(112);
			}

			player.setAttribute("cantMove", Boolean.TRUE);
			player.setAttribute("alching", Boolean.TRUE);
			player.getInventory().getContainer().remove(new Item(itemId, 1));
			player.getInventory().getContainer().remove(new Item(561, 1));
			player.getInventory().getContainer().remove(new Item(554, 3));
			player.getInventory().refresh();
			ActionSender.sendBConfig(player, 168, 7);
			World.getWorld().submit(new Tick(4) {
				@Override
				public void execute() {
					player.getInventory().addItem(995, (int) alcValue);
					player.getSkills().addExperience(Skills.MAGIC, 31);
					player.getInventory().refresh();
					player.removeAttribute("cantMove");
					player.removeAttribute("alching");
					stop();
				}
			});
		}
	}

	private void highAlch(final Player player, int itemId, int slot) {
		if (player.getSettings().getSpellBook() == 192) {
			if (player.getSkills().getLevel(6) < 55) {
				player.sendMessage("You need a higher magic level to cast this spell.");
				return;
			} else if (player.getAttribute("alching") != null) {
				player.sendMessage("You are already casting an alchemy spell.");
				return;
			} else if (!player.getInventory().getContainer()
					.contains(new Item(561, 1))) {
				player.sendMessage("You do not have the required runes or staff to cast that.");
				return;
			} else if (!player.getInventory().getContainer()
					.contains(new Item(554, 5))
					&& !hasFireStaff(player)) {
				player.sendMessage("You do not have the required runes or staff to cast that.");
				return;

			} else {
				final double alcValue = player.getInventory().getContainer()
						.get(slot).getDefinition().getHighAlchPrice();
				if (alcValue == 0) {
					player.sendMessage("This item has no alchemy value. Please report it to an administrator.");
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(
								"./data/missing_alch.txt", true));
						bw.write("\n Item Id: " + itemId + " has no alch value");
						bw.flush();
						bw.close();
					} catch (Throwable t) {
						t.printStackTrace();
					}
					return;
				}
				if (itemId == 995) {
					player.sendMessage("You cannot cast an alchemy spell on money.");
					return;
				}
				if (player.getInventory().getContainer().getFreeSlots() == 0
						&& !player.getInventory().getContainer()
								.contains(new Item(995))) {
					player.sendMessage("You do not have any room in your inventory to cast an alchemy spell.");
					return;
				}
				if (hasFireStaff(player)) {
					player.animate(9633);
					player.graphics(1693);
				} else {
					player.animate(713);
					player.graphics(113);
				}
				player.setAttribute("cantMove", Boolean.TRUE);
				player.setAttribute("alching", Boolean.TRUE);
				player.getInventory().getContainer()
						.remove(new Item(itemId, 1));
				player.getInventory().getContainer().remove(new Item(561, 1));
				player.getInventory().getContainer().remove(new Item(554, 5));
				player.getInventory().refresh();
				ActionSender.sendBConfig(player, 168, 7);
				World.getWorld().submit(new Tick(4) {
					@Override
					public void execute() {
						player.getInventory().addItem(995, (int) alcValue);
						player.getSkills().addExperience(Skills.MAGIC, 65);
						player.getInventory().refresh();
						player.removeAttribute("cantMove");
						player.removeAttribute("alching");
						stop();
					}
				});
			}
		} else {
			ActionSender
					.sendMessage(player,
							"Please acknoledge that using cheat-clients is against the rules.");
			ActionSender
					.sendMessage(player,
							"If you think this is a bug, please report it on the forums");
		}
	}

}
