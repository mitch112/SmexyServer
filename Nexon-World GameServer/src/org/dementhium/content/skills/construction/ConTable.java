package org.dementhium.content.skills.construction;
import org.dementhium.net.ActionSender;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;


public class ConTable {
	
	public static ActionSender Action;
	public static int modifier = 1;

	public static void handleCon(Player p, int buttonId) { 
			if (p.getInventory().numberOf(8794) >= 1 && p.getInventory().numberOf(2347) >= 1) {
				switch (buttonId) {
					
					case 45:
						if (p.getInventory().numberOf(960) >= 2) {
						tableConfigs(p, "Rocking Chair", 40, 8500, 960, 2);
						} else {
						tableCloseMsg(p, "2 planks");
						}
					break;
					
					case 46:
					if (Level(p, 29) == true) {
						if (p.getInventory().numberOf(8778) >= 2) {
								tableConfigs(p, "Oak bookcase", 96, 8512, 8778, 2);
								} else {
									tableCloseMsg(p, "2 Oak planks");
								}
							}
					break;
					
					case 47:
					if (Level(p, 36) == true) {
						if (p.getInventory().numberOf(8778) >= 2 && p.getInventory().numberOf(2353) >= 1) {
								tableConfigs(p, "Dragon Bitter barrel", 150, 8524, 8778, 2);
								p.getInventory().deleteItem(2353, 1);
								} else {
									tableCloseMsg(p, "2 Oak planks and 1 Steel bar");
								}
							}
					break;
					
					case 48:
					if (Level(p, 52) == true) {
						if (p.getInventory().numberOf(8780) >= 3) {
								tableConfigs(p, "Teak kitchen table", 215, 8532, 8780, 3);
								} else {
									tableCloseMsg(p, "3 Teak planks");
								}
							}
					break;
					
					case 49:
					if (Level(p, 52) == true) {
						if (p.getInventory().numberOf(8782) >= 6) {
								tableConfigs(p, "Mahogany table", 370, 8558, 8782, 6);
								} else {
									tableCloseMsg(p, "6 Mahogany planks");
								}
							}
					break;
					
					case 50:
					if (Level(p, 61) == true) {
						if (p.getInventory().numberOf(8782) >= 4 && p.getInventory().numberOf(8784) >= 4) {
								tableConfigs(p, "Gilded bench", 1760, 8574, 8782, 4);
								p.getInventory().deleteItem(8784, 4);
								} else {
									tableCloseMsg(p, "4 Mahogany planks and 4 Gold leaves");
								}
							}
					break;
					
					case 51:
					if (Level(p, 53) == true) {
						if (p.getInventory().numberOf(8782) >= 3) {
						tableConfigs(p, "Mahogany 4-Poster", 450, 8586, 8782, 3);
							} else {
							tableCloseMsg(p, "3 Mahogany planks");
							}
						}
					break;
					
					case 52:
					if (Level(p, 64) == true) {
						if (p.getInventory().numberOf(8782) >= 2) {
						tableConfigs(p, "Mahogany dresser", 281, 8606, 8782, 2);
							} else {
							tableCloseMsg(p, "2 Mahogany planks");
							}
						}
					break;
					
					case 53: 
					if (Level(p, 87) == true) {
						if (p.getInventory().numberOf(8782) >= 3 && p.getInventory().numberOf(8784) >= 1) {
						tableConfigs(p, "Gilded wardrobe", 720, 8622, 8782, 3);
						p.getInventory().deleteItem(8784, 1);
							} else {
							tableCloseMsg(p, "3 Mahogany planks and 1 Gold leaf");
							}
						}
					break;
					
					case 54:
					if (Level(p, 85) == true) {
						if (p.getInventory().numberOf(8782) >= 2 && p.getInventory().numberOf(8784) >= 1) {
								tableConfigs(p, "Gilded clock", 602, 8594, 8782, 2);
								p.getInventory().deleteItem(8784, 1);
								} else {
									tableCloseMsg(p, "2 Mahogany planks and 1 Gold leaf");
								}
							}
					break;
					
					case 55:
					if (Level(p, 90) == true) {
						if (p.getInventory().numberOf(8786) >= 1) {
							tableConfigs(p, "Marble cape rack", 500, 9847, 8786, 1);
								} else {
								tableCloseMsg(p, "1 Marble block");
								}
						}
					break;
					
					case 56:
					if (Level(p, 96) == true) {
						if (p.getInventory().numberOf(8786) >= 1) {
						tableConfigs(p, "Marble magic wardrobe", 600, 9858, 8786, 1);
							} else {
							tableCloseMsg(p, "1 Marble block");
							}
						}
					break;
					
					case 57:
					if (Level(p, 82) == true) {
						if (p.getInventory().numberOf(8782) >= 3) {
						tableConfigs(p, "Mahogany armour case", 420, 9861, 8782, 3);
							} else {
							tableCloseMsg(p, "3 Mahogany planks");
							}
						}
					break;
					
					case 58:
					if (Level(p, 84) == true) {
						if (p.getInventory().numberOf(8782) >= 2) {
						tableConfigs(p, "Mahogany treasure chest", 380, 9864, 8782, 2);
							} else {
							tableCloseMsg(p, "2 Mahogany planks");
							}
						}
					break;
					
					case 59:
					if (Level(p, 80) == true) {
						if (p.getInventory().numberOf(8782) >= 2) {
						tableConfigs(p, "Mahogany costume box", 310, 9867, 8782, 2);
							} else {
							tableCloseMsg(p, "2 Mahogany planks");
							}
						}
					break;
					
					case 60:
					if (Level(p, 80) == true) {
						if (p.getInventory().numberOf(8782) >= 2) {
						tableConfigs(p, "Mahogany toy box", 280, 9851, 8782, 2);
							} else {
							tableCloseMsg(p, "2 Mahogany planks");
							}
						}
					break;
					
				}
			} else {
			ActionSender.sendCloseInterface(p);
			ActionSender.sendMessage(p, "You must have a saw and hammer in your inventory to construct this item.");
			}
	}
	
	public static void tableConfigs(Player p, String name, int exp, int id, int plank, int amount)	{
	//7276 lean over emote, 898 smithing emote //Could not find actual table emote :/
		p.getInventory().deleteItem(plank, amount);
		ActionSender.sendCloseInterface(p);
		p.animate(7276);
		p.getInventory().addItem(id, 1);
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