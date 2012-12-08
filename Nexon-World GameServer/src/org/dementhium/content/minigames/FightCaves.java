package org.dementhium.content.minigames;

import org.dementhium.content.DialogueManager;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.player.Player;
import org.dementhium.util.Misc;
import org.dementhium.model.World;

public class FightCaves {

	public static void enterCave(final Player player) {
		NPC jad = new NPC(2745, 2397, 5086, 0);
		player.requestWalk(2438, 5168);
		player.teleport(2412, 5117, 0);
		player.requestWalk(2407, 5090);
		player.setAttribute("teleblock", 999999999);
		DialogueManager.sendDialogue(player, DialogueManager.CALM_TALK, 2617, -1, "You're on your own now, " + player.getUsername() + ".", "Prepare to fight for your life!");
		World.getWorld().getNpcs().add(jad);
	}
	
	public static void exitCave(final Player player) {
		player.removeAttribute("teleblock");
		DialogueManager.sendDialogue(player, DialogueManager.CALM_TALK, 2617, -1, "Do not feel bad human,", "I knew you couldn't do it.");
		player.getSkills().completeRestore();
		player.getSkills().restorePray(120);
		player.setSpecialAmount(1000);
		player.teleport(2438, 5168, 0);
	}
	
	/**
	 * Tokuul Reward
	 */
	public static int getTokkulReward() {
		return (int) (Misc.random(500));
	}

	public static void teleFromCave(final Player player ) {
		player.teleport(2439, 5169, 0);
		DialogueManager.sendDialogue(player, DialogueManager.CALM_TALK, 2617, -1, "You have defeated TzTok-Jad, I am most impressed!", "Please accept this gift as a reward.");
		player.getInventory().addItem(6570, 1);
		player.getInventory().addItem(6529, 16064);
		player.removeAttribute("teleblock");
		player.getSkills().completeRestore();
		player.getSkills().restorePray(120);
		player.setSpecialAmount(1000);
	}
	public static void fightCaveAttacks(final NPC npc, final Player p) {
		if (npc.isDead() || npc.destroyed() || p.isDead() || p.destroyed() || p.isDead()) {
			return;
		}
		Misc.random(npc.getMaxHp());
		p.getPrayer().getHeadIcon();
		npc.getAttackDelay();
		npc.getAttackAnimation();
		switch(npc.getId()) {
		case 2745: 
		
			break;
		}
}
	
}