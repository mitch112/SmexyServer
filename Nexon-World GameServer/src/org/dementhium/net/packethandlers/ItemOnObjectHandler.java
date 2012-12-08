package org.dementhium.net.packethandlers;

import org.dementhium.cache.format.CacheObjectDefinition;
import org.dementhium.content.activity.ActivityManager;
import org.dementhium.content.activity.impl.warriorsguild.AnimationGame;
import org.dementhium.content.areas.CoordinateEvent;
import org.dementhium.content.dialogue.Dialogue;
import org.dementhium.content.dialogue.DialogueManager;
import org.dementhium.content.dialogue.DialogueType;
import org.dementhium.content.dialogue.OptionAction;
import org.dementhium.content.dialogue.OptionAction.ActionType;
import org.dementhium.content.misc.WaterFilling;
import org.dementhium.content.skills.cooking.Cooking;
import org.dementhium.content.skills.runecrafting.Talisman;
import org.dementhium.content.skills.smithing.Smithing;
import org.dementhium.model.Item;
import org.dementhium.model.Location;
import org.dementhium.model.World;
import org.dementhium.model.definition.ItemDefinition;
import org.dementhium.model.map.GameObject;
import org.dementhium.model.map.path.DefaultPathFinder;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.net.ActionSender;
import org.dementhium.net.PacketHandler;
import org.dementhium.net.message.Message;

/**
 * @author 'Mystic Flow <Steven@rune-server.org>
 * @author Steve <golden_32@live.com>
 * @author Lumby <lumbyjr@hotmail.com>
 */
public class ItemOnObjectHandler extends PacketHandler {

	private static final int ITEM_ON_OBJECT = 11;

	@Override
	public void handlePacket(Player player, Message packet) {
		switch (packet.getOpcode()) {
		case ITEM_ON_OBJECT:
			handleItemOnObject(player, packet);
			break;
		}

	}

	private void handleItemOnObject(final Player player, final Message packet) {
		packet.readLEInt(); //not sure
		packet.readLEShortA();
		final int itemUsed = packet.readShort();
		final int objX = packet.readShort();
		packet.readByteS();
		int objectId = packet.readShortA();
		final int objY = packet.readLEShortA();
		final Location location = Location.locate(objX, objY, player.getLocation().getZ());
		if (player.getRights() > 1) {
			player.sendMessage("Incoming item on object opcode - id: " + objectId + ", item id: " + itemUsed + ", x: " + objX + ", y:" + objY + ".");
		}
		World.getWorld().doPath(new DefaultPathFinder(), player, objX, objY);

		final GameObject gameObject = location.getGameObject(objectId);

		if (gameObject == null) {
			return;
		}
		if (gameObject.getId() != objectId) {
			return;
		}
		final CacheObjectDefinition definition = gameObject.getDefinition();
		final int objectClicked = objectId;
		World.getWorld().submitAreaEvent(player, new CoordinateEvent(player, objX, objY, definition.getSizeX(), definition.getSizeY()) {

			@Override
			public void execute() {
				player.getMask().setFacePosition(gameObject.getLocation(), definition.getSizeX(), definition.getSizeY());
				doObjectAction(player, packet, gameObject, itemUsed, objX, objY, objectClicked, definition);
			}

		});

	}

	protected void doObjectAction(Player player, Message packet, GameObject object, int itemUsed, int objX, int objY, int objId, CacheObjectDefinition definition) {
		ActionSender.sendCloseChatBox(player);
		String name = definition.getName().toLowerCase();
		if (player.getActivity().itemAction(player, new Item(itemUsed, 1), 0, "ItemOnObject", object)) {
			return;
		}
		CacheObjectDefinition def = object.getDefinition();
		if (def.getName().toLowerCase().contains("locked chest")) {
			if (objId == 49345) {
				if (itemUsed == 8869) {
					player.getInventory().deleteItem(8869, 1);
					player.getInventory().addItem(player.dungChestReward(), 1);
				}
			}
		}
		if (def.getName().toLowerCase().contains("anvil")) {
			if (itemUsed == 11286 || itemUsed == 1540) {
				DialogueManager.sendDialogue(player, 0);
				return;
			} else if (itemUsed == 13736) {
				if (player.getInventory().contains(13746)) {
					DialogueManager.sendDialogue(player, 17);
					return;
				} else if (player.getInventory().contains(13748)) {
					DialogueManager.sendDialogue(player, 27);
					return;
				} else if (player.getInventory().contains(13750)) {
					DialogueManager.sendDialogue(player, 29);
					return;
				} else {
					DialogueManager.sendDialogue(player, 31);
					return;
				}
			} else if (itemUsed == 13746) {
				DialogueManager.sendDialogue(player, 17);
				return;
			} else if (itemUsed == 13748) {
				DialogueManager.sendDialogue(player, 27);
				return;
			} else if (itemUsed == 13750) {
				DialogueManager.sendDialogue(player, 29);
				return;
			} else if (itemUsed == 13752) {
				DialogueManager.sendDialogue(player, 31);
				return;

			//Godsword Blade making (attach Hilt for Godsword):	
			} else if (itemUsed == 11710) { //gs shard 1
				if (player.getInventory().contains(11712)) { //shard 1 + 2
					DialogueManager.sendDialogue(player, 35);
					return;
				} else if (player.getInventory().contains(11714)) { //shard 1 + 3
					DialogueManager.sendDialogue(player, 44);
					return;
				} else if (player.getInventory().contains(11692)) { //shard 1 + shards (2 + 3)
					DialogueManager.sendDialogue(player, 46);
					return;
				} else {
					DialogueManager.sendDialogue(player, 35);
					return;
				}
			} else if (itemUsed == 11712) { //gs shard 2
				if (player.getInventory().contains(11714)) { //shard 2 + 3
					DialogueManager.sendDialogue(player, 45);
					return;
				} else if (player.getInventory().contains(11710)) { //shard 2 + 1
					DialogueManager.sendDialogue(player, 35);
					return;
				} else if (player.getInventory().contains(11688)) { //shard 2 + shards (1 + 3)
					DialogueManager.sendDialogue(player, 47);
					return;
				} else {
					DialogueManager.sendDialogue(player, 35);
					return;
				}
			} else if (itemUsed == 11714) { //gs shard 3
				if (player.getInventory().contains(11712)) { //shard 3 + 2
					DialogueManager.sendDialogue(player, 45);
					return;
				} else if (player.getInventory().contains(11714)) { //shard 3 + 1
					DialogueManager.sendDialogue(player, 44);
					return;
				} else if (player.getInventory().contains(11686)) { //shard 3 + shards (1 + 2)
					DialogueManager.sendDialogue(player, 36);
					return;
				} else {
					DialogueManager.sendDialogue(player, 45);
					return;
				}
			} else if (itemUsed == 11686) { //gs shards (1 + 2)
				DialogueManager.sendDialogue(player, 36);
				return;
			} else if (itemUsed == 11688) { //gs shards (1 + 3)
				DialogueManager.sendDialogue(player, 47);
				return;
			}else if (itemUsed == 11692) { //gs shards (2 + 3)
				DialogueManager.sendDialogue(player, 46);
				return;
			}
		} else if (def.getName().toLowerCase().equals("altar")) {
			if (itemUsed == 13734 || itemUsed == 13754) {
				if (player.getSkills().getLevel(Skills.PRAYER) < 85) {
					Dialogue dial = new Dialogue();
					dial.setType(DialogueType.DISPLAY_BOX);
					dial.getMessage().add("You need a prayer level of 85 to bless this shield.");
					dial.getActions().add(OptionAction.create(ActionType.CLOSE_DIALOGUE));
					dial.send(player);
					return;
				}
				if (!player.getInventory().contains(13734)) {
					player.sendMessage("You do not have a spirit shield to bless.");
					return;
				} else if (!player.getInventory().contains(13754)) {
					player.sendMessage("You need holy elixir to bless a spirit shield.");
					return;
				}
				player.getSkills().addExperience(Skills.PRAYER, 1500);
				player.animate(Animation.create(645));
				player.getInventory().getContainer().remove(new Item(13734));
				player.getInventory().getContainer().remove(new Item(13754));
				player.getInventory().addItem(new Item(13736));
				player.sendMessage("You bless the spirit shield.");
				return;
		} else if (itemUsed == 526) {
			player.sendMessage("You use bones to the altar.");
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getInventory().getContainer().remove(new Item(526));
			player.getSkills().addExperience(Skills.PRAYER, 8);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 528) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(528));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 8);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 530) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(530));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 8);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 532) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(532));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 30);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 2859) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(2859));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 8);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 3125) {
			player.sendMessage("You pray to the gods");
			player.getInventory().getContainer().remove(new Item(3125));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 30);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 4812) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(4812));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 44);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 534) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(534));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 60);
			player.getInventory().refresh();
				return;
		} else if (itemUsed == 536) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(536));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 144);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 3179) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(3179));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 10);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 6812) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(6812));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 100);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 6729) {
						player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(6729));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 250);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 18830) {
			player.getInventory().getContainer().remove(new Item(18830));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 500);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 18832) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(18832));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 500);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 15217) {
			player.sendMessage("You pray to the gods");
			player.getInventory().getContainer().remove(new Item(15217));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 30);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 15218) {
			player.sendMessage("You pray to the gods");
			player.getInventory().getContainer().remove(new Item(15218));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 30);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 15219) {
						player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(15219));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 30);
			player.getInventory().refresh();
			return;
		} else if (itemUsed == 15410) {
					player.sendMessage("You use bones to the altar.");
			player.getInventory().getContainer().remove(new Item(15410));
			ActionSender.spawnPositionedGraphic(object.getLocation(), 624);
			player.getSkills().addExperience(Skills.PRAYER, 900);
			player.getInventory().refresh();
			return;
		}
		}
		if (Smithing.itemOnObjectInteraction(player, itemUsed, objId)) {
			return;
		}
		else if (itemUsed == 13734 && itemUsed == 13754 || itemUsed == 13754
				&& itemUsed == 13734) {
			player.getInventory().getContainer().remove(new Item(13734, 1));
			player.getInventory().getContainer().remove(new Item(13754, 1));
			player.getInventory().addItem(13736, 1);
			player.sendMessage("You pour the holy elixir on the spirit shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsed == 13752 || itemUsed == 13752
				&& itemUsed == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13752, 1));
			player.getInventory().addItem(13744, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsed == 13746 || itemUsed == 13746
				&& itemUsed == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13746, 1));
			player.getInventory().addItem(13738, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsed == 13750 || itemUsed == 13750
				&& itemUsed == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13750, 1));
			player.getInventory().addItem(13742, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
		else if (itemUsed == 13736 && itemUsed == 13748 || itemUsed == 13748
				&& itemUsed == 13736) {
			player.getInventory().getContainer().remove(new Item(13736, 1));
			player.getInventory().getContainer().remove(new Item(13748, 1));
			player.getInventory().addItem(13740, 1);
			player.sendMessage("You attatch the sigil to the shield.");
			return;
		}
		if(WaterFilling.isWaterItem(itemUsed) && name.contains("sink") || WaterFilling.isWaterItem(itemUsed) && name.contains("fountain") || WaterFilling.isWaterItem(itemUsed) && name.contains("well") || WaterFilling.isWaterItem(itemUsed) && name.contains("geyser") || WaterFilling.isWaterItem(itemUsed) && name.contains("waterpump")){
			WaterFilling waterfilling = new WaterFilling(player, itemUsed);
			player.submitTick("skill_action_tick", waterfilling, true);
			return;
		}
		if (objId == 15621 && AnimationGame.isArmourPiece(itemUsed)) {
			player.setActivity(new AnimationGame(player, itemUsed, objId));
			ActivityManager.getSingleton().register(player.getActivity());
			return;
		}
		if (Cooking.itemForId(player, itemUsed, objId) != null) {
			player.setAttribute("cookingObj", objId);
			Cooking.showInterface(player, Cooking.itemForId(player, itemUsed, objId), itemUsed);
			return;
		}
		Talisman talisman = Talisman.forId(itemUsed);
		if (talisman != null) {
			if(talisman.getObjectId() == objId){
				if(player.getSkills().getLevel(Skills.RUNECRAFTING) < talisman.getLevel()){
					player.sendMessage("You need a higher runecrafting level to enter.");
					return;
				}
				player.sendMessage("You hold the "+ItemDefinition.forId(talisman.getId()).getName()+" towards the mysterious ruins.");
				player.teleport(talisman.getInsideLocation());
				player.sendMessage("You feel a powerful force take hold of you...");
				return;
			}
		}
		switch (objId) {
		}
		player.sendMessage("Nothing interesting happens.");
		System.out.println("Item on Object ID: "+objId);
	}


}
