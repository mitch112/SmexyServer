package org.dementhium.content.skills.slayer;

import org.dementhium.content.skills.slayer.SlayerTask.Master;
import org.dementhium.model.World;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.model.player.Equipment;
import org.dementhium.net.ActionSender;

import static org.dementhium.content.DialogueManager.*;

/**
 * @author 'Mystic Flow <Steven@rune-server.org>
 */
public class Slayer {

	public void refresh() {
		ActionSender.sendConfig(player, 300, player.getSettings().getPointAmount());
		this.player.getMask().setApperanceUpdate(true);
	}

    /**
     * Tips
     * Ghouls - Ghouls aren't undead, but they are stronger
     * and tougher then they look. They're also very cowardly and
     * will run if they're losing a fight. They wait to ambush
     * those entering Morytania, close to the River Salve.
     */

    private Player player;
    private SlayerTask task;

    public Slayer(Player player) {
        this.player = player;
    }


    public boolean handleDialouge(int stage) {
        if (!(stage >= 2000 && stage <= 3000)) {
            return false;
        }
        NPC talkingTo = player.getSettings().getSpeakingTo() == null ? null : player.getSettings().getSpeakingTo().getNPC();
        Master master = player.getSettings().getSpeakingTo() == null ? null : Master.forId(talkingTo.getId());
        switch (stage) {
            case 2000:
				if (master == Master.SUMONA)
                    sendDialogue(player, CALM_TALK, talkingTo.getId(), 2009, "'Ello, and what are you after then?");
				if (master == Master.VANNAKA)
					sendDialogue(player, CALM_TALK, talkingTo.getId(), 2009, "'Ello, and what are you after then?");
				return true;
            case 2001:
                sendOptionDialogue(player, new int[]{2002, 2003, 2004, 2005, 2006}, "I need another assignment.", "Open Rewards shop.", "Slayer Areas", "Er...nothing...");
                return true;
            case 2002:
                sendDialogue(player, CALM_TALK, -1, 2012, "I need another assignment.");
                return true;
            case 2003:
                sendDialogue(player, HAPPY_TALKING, -1, 2007, "Do you have anything for trade?");
                return true;
			case 2004:
				player.sendSlayerLearn();
				return false;
			case 2505:
				sendOptionDialogue(player, new int[]{2222, 2223, 2224, 2225, -1}, "Kuradel's Dungeon", "Slayer Tower", "Fremennik Dungeon", "Mithril Dragons", "Nothing");
				return true;
			case 2222:
				player.teleport(1661, 5258, 0);
				return false;
			case 2223:
				player.teleport(3429, 3534, 0);
				return false;
			case 2224:
				player.teleport(2808, 10002, 0);
				return false;
			case 2225:
				player.teleport(1765, 5333, 0);
				return false;
            case 2006:
                sendDialogue(player, CALM_TALK, -1, -1, "Er...nothing...");
                return false;
            case 2007:
				World.getWorld().getShopManager().openShop(player, 1595);
                return false;
            case 2009:
                sendOptionDialogue(player, new int[]{2012, 2004, 2007, 2505, 2006}, "I need another assignment", "Open rewards shop", "Open shop", "Slayer Areas", "Er...nothing...");
                return true;
            case 2010:
                sendDialogue(player, HAPPY_TALKING, -1, -1, "Sorry I was just leaving.");
                return true;
            case 2011:
                sendDialogue(player, CALM_TALK, talkingTo.getId(), -1, "There isn't much information on it now, come back later.");
                return true;
            case 2012:
                if (task != null) {
                    sendDialogue(player, CONFUSED, talkingTo.getId(), -1, "You're still hunting " + task.getName() + "; come back when you've", "finished your task.");
                } else {
                    double slayerExperience = player.getSkills().getXp(Skills.SLAYER);
                    SlayerTask newTask = null;
                    if (slayerExperience == 0) {
                        newTask = new SlayerTask(master, 0, 15);
                        sendDialogue(player, CALM_TALK, talkingTo.getId(), -1, "For your first task I'm assigning you to", "kill 15 rock crabs.");
                    } else {
                        newTask = SlayerTask.random(player, master);
                        sendDialogue(player, CALM_TALK, talkingTo.getId(), -1, "Great, you're doing great. Your new task is to kill", newTask.getTaskAmount() + " " + newTask.getName() + "s");
                    }
                    this.task = newTask;
                }
                return true;
			case 2090:
				sendDialogue(player, CONFUSED, talkingTo.getId(), -1, "Why don't you just talk to me?");
				return true;
            case 2013:
                sendDialogue(player, HAPPY_TALKING, talkingTo.getId(), 2014, "Hello there, @PLAYER_NAME@, what can I help you with?");
                return true;
            case 2014:
                sendOptionDialogue(player, new int[]{2015, 2016, 2017, 2018, 2019}, "How am I doing so far?", "Who are you?", "Where are you?", "Got any tips for me?", "Nothing really.");
                return true;
            case 2015:
                sendDialogue(player, CALM_TALK, -1, 2020, "How am I doing so far?");
                return true;
            case 2016:
                sendDialogue(player, CALM_TALK, -1, 2021, "Who are you?");
                return true;
            case 2017:
                sendDialogue(player, CALM_TALK, -1, 2022, "Where are you?");
                return true;
            case 2018:
                sendDialogue(player, CALM_TALK, -1, 2023, "Got any tips for me?");
                return true;
            case 2019:
                sendDialogue(player, CALM_TALK, -1, -1, "Nothing really.");
                return true;
            case 2020:
                if (task != null) {
                    sendDialogue(player, HAPPY_TALKING, talkingTo.getId(), 2040, "You're current assigned to kill " + task.getName().toLowerCase() + "s. Only " + task.getTaskAmount() + " more", "to go.");
                } else {
                    sendDialogue(player, HAPPY_TALKING, talkingTo.getId(), 2040, "You currently have no task, come to me so I can assign you one.");
                }
                return true;
            case 2021:
                //TODO Support for different masters.
                sendDialogue(player, HAPPY_TALKING, talkingTo.getId(), 2041, "My name's SUMONA; I'm a Slayer Master.");
                return true;
            case 2022:
                sendDialogue(player, HAPPY_TALKING, talkingTo.getId(), 2042, "You'll find me in the default city used for Dementhium.", "I'll be here when you need a new task.");
                return true;
            case 2023:
                sendDialogue(player, CALM_TALK, talkingTo.getId(), 2043, "At the moment, no.");
                return true;
            case 2040:
                sendOptionDialogue(player, new int[]{2016, 2017, 2018, 2019}, "Who are you?", "Where are you?", "Got any tips for me?", "Nothing really.");
                return true;
            case 2041:
                sendOptionDialogue(player, new int[]{2015, 2017, 2018, 2019}, "How am I doing so far?", "Where are you?", "Got any tips for me?", "Nothing really.");
                return true;
            case 2042:
                sendOptionDialogue(player, new int[]{2015, 2016, 2018, 2019}, "How am I doing so far?", "Who are you?", "Got any tips for me?", "Nothing really.");
                return true;
            case 2043:
                sendOptionDialogue(player, new int[]{2015, 2016, 2017, 2019}, "How am I doing so far?", "Who are you?", "Where are you?", "Nothing really.");
                return true;
        }
        return true;
    }


    public SlayerTask getSlayerTask() {
        return task;
    }

    public void killedTask() {
		if (player.getEquipment().getSlot(Equipment.SLOT_HANDS) == 6720) {
			player.getSkills().addExperience(Skills.SLAYER, task.getXPAmount() * 3);
		} else {
			player.getSkills().addExperience(Skills.SLAYER, task.getXPAmount());
		}
        task.decreaseAmount();
        if (task.getTaskAmount() < 1) {
            player.sendMessage("You have finished your slayer task, talk to a slayer master for a new one.");
			player.getSettings().taskPoint = (player.getSettings().taskPoint + 1);
			if (player.getSettings().getTaskPoint() < 10) {
				player.sendMessage("You have been awarded 5 slayer points for completing your task.");
				player.getSettings().slayerPoint = (player.getSettings().slayerPoint + 5);
			} else if (player.getSettings().getTaskPoint() >= 10 && player.getSettings().getTaskPoint() <= 19) {
				player.sendMessage("You have been awarded 20 slayer points for completing " + player.getSettings().getTaskPoint() + " tasks in a row.");
				player.getSettings().slayerPoint = (player.getSettings().slayerPoint + 20);
			} else if (player.getSettings().getTaskPoint() >= 20 && player.getSettings().getTaskPoint() <= 39) {
				player.sendMessage("You have been awarded 40 slayer points for completing " + player.getSettings().getTaskPoint() + " tasks in a row.");
				player.getSettings().slayerPoint = (player.getSettings().slayerPoint + 40);
			} else if (player.getSettings().getTaskPoint() >= 40 && player.getSettings().getTaskPoint() <= 79) {
				player.sendMessage("You have been awarded 80 slayer points for completing " + player.getSettings().getTaskPoint() + " tasks in a row.");
				player.getSettings().slayerPoint = (player.getSettings().slayerPoint + 80);
			} else {
				player.sendMessage("You have been awarded 10 slayer points for completing your task.");
				player.getSettings().slayerPoint = (player.getSettings().slayerPoint + 10);
			}
            task = null;
        }
    }

    public void setSlayerTask(SlayerTask slayerTask) {
        this.task = slayerTask;
    }

}
