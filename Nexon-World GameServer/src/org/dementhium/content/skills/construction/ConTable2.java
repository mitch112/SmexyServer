package org.dementhium.content.skills.construction;

import org.dementhium.net.ActionSender;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;

	/**
	* @author 'Wildking72 @Rune-Server & MoparScape
	*/

public class ConTable2 {
	
	//For interface 402 - Not finished
	
	public static ActionSender Action;
	public static int modifier = 1;

	public static void handleCon(Player p, int buttonId) {
			if (p.getInventory().numberOf(8794) >= 1 && p.getInventory().numberOf(2347) >= 1) {
				switch (buttonId) {
					case 93:
					case 94:
					if (p.getInventory().numberOf(995) >= 1000) {
						tableConfigs(p, "Parlour - Garden", 25, 995, 1000);
					} else {
						tableCloseMsg(p, "1000 Coins");
					}
						break;
					case 95:
					if (Level(p, 5) == true) {
						if (p.getInventory().numberOf(995) >= 5000) {
								tableConfigs(p, "Kitchen", 75, 995, 5000);
						} else {
								tableCloseMsg(p, "5000 Coins");
								}
							}
						break;
					case 96:
					if (Level(p, 10) == true) {
						if (p.getInventory().numberOf(995) >= 5000) {
								tableConfigs(p, "Dining Room", 115, 995, 5000);
						} else {
								tableCloseMsg(p, "5000 Coins");
								}
							}
						break;
					case 97:
					if (Level(p, 15) == true) {
						if (p.getInventory().numberOf(995) >= 10000) {
								tableConfigs(p, "Work Shop", 154, 995, 10000);
						} else {
								tableCloseMsg(p, "10000 Coins");
								}
							}
						break;
					case 98:
					if (Level(p, 20) == true) {
						if (p.getInventory().numberOf(995) >= 10000) {
								tableConfigs(p, "Bedroom", 180, 995, 10000);
						} else {
								tableCloseMsg(p, "10000 Coins");
								}
							}
						break;
					case 99:
					if (Level(p, 25) == true) {
						if (p.getInventory().numberOf(995) >= 15000) {
								tableConfigs(p, "Hall", 229, 995, 15000);
						} else {
								tableCloseMsg(p, "15000 Coins");
								}
							}
						break;
					case 100:
					if (Level(p, 30) == true) {
						if (p.getInventory().numberOf(995) >= 25000) {
								tableConfigs(p, "Games Room", 262, 995, 25000);
						} else {
								tableCloseMsg(p, "25000 Coins");
								}
							}
						break;
				}
			} else {
			ActionSender.sendCloseInterface(p);
			ActionSender.sendMessage(p, "You must have a saw and hammer in your inventory to construct this item.");
			}
	}
	
	public static void tableConfigs(Player p, String name, double exp, int item, int amount)	{
		p.getInventory().deleteItem(item, amount);
		ActionSender.sendCloseInterface(p);
		p.animate(7276);
		p.getSkills().addExperience(22, exp * modifier);
		ActionSender.sendMessage(p, "You have packed a new " + name + "!");
	}
	
	public static void tableCloseMsg(Player p, String string) {
		ActionSender.sendCloseInterface(p);
		ActionSender.sendMessage(p, "You need " + string + " to make this.");
	}
	
	public static boolean Level(Player p, int lvl) {
		if (p.getSkills().getLevel(Skills.CONSTRUCTION) >= lvl) {
			return true;
		} else {
			lvlClose(p, lvl);
		return false;
		}
	}
	
	public static void lvlClose(Player p, int lvl) {
				ActionSender.sendCloseInterface(p);
				ActionSender.sendMessage(p, "Level " + lvl + " Construction is required to construct this item.");
		}
}