package org.dementhium.model.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.dementhium.model.World;
import org.dementhium.model.player.Player;

/**
 * Handles skulling in the wilderness.
 * @author Emperor
 *
 */
public class SkullManager {

	/**
	 * The player.
	 */
	private final Player player;
	
	/**
	 * The amount of ticks left for the skull to disappear (if any).
	 */
	private int skullTicks = -1;
	
	/**
	 * A list of players this player has attacked first.
	 */
	private List<Player> victims = new ArrayList<Player>();
	
	/**
	 * A list of players who attacked this player first.
	 */
	private List<Player> attackers = new ArrayList<Player>();
	
	/**
	 * Constructs a new {@code SkullManager} {@code Object}.
	 * @param player The player.
	 */
	public SkullManager(Player player) {
		this.player = player;
	}
	
	/**
	 * Appends a skull on this player, if required.
	 * @param other The other player.
	 */
	public void appendSkull(Player other) {
		if (other.getSkullManager().isSkulled()) {
			for (Player othersVictim : other.getSkullManager().getVictims()) {
				if (othersVictim != null) {
					if (othersVictim.getUsername().equals(player.getUsername()))
						return;
				}
			}
			for (Player playersAttacker : attackers) {
				if (playersAttacker != null) {
					if (playersAttacker.getUsername().equals(other.getUsername()))
						return;
				}
			}
		}
		
		//ADD VICTIM (OTHER) TO PLAYER's (PLAYER) VICTIM LIST:
		int i = 0;
		List<Player> victimList = new CopyOnWriteArrayList<Player>(victims);
		for (Player victim : victimList) {
			if (victim != null) {
				if (victim.getUsername().equals(other.getUsername())) {
					victimList.remove(i);
				}
				i ++;
			}
		}
		victimList.add(other);
		victims = victimList;
	
		//ADD ATTACKER (PLAYER) TO OTHER's (VICTIM) ATTACKER LIST:
		i = 0;
		List<Player> attackerList = new CopyOnWriteArrayList<Player>(other.getSkullManager().getAttackers());
		for (Player attacker : attackerList) {
			if (attacker != null) {
				if (attacker.getUsername().equals(player.getUsername())) {
					attackerList.remove(i);
				}
				i ++;
			}
		}
		attackerList.add(player);
		other.getSkullManager().attackers = attackerList;
		
		//SETS THE OTHER SKULL STUFF:
		player.setAttribute("skulled", true);
		skullTicks = World.getTicks() + 3333;
		player.getMask().setApperanceUpdate(true);
	}
	public void appendSkullWithoutCombat() {
		player.setAttribute("skulled", true);
		/*
		 * We don't want people who are skulled for 20 mins, to walk into the Abyss and recieve a 10 min skull.
		 */
		if ((skullTicks - World.getTicks()) < 1650)
			skullTicks = World.getTicks() + 1650; //(1650 (if each tick is 0.6 seconds) =+- 10 mins)		
		player.getMask().setApperanceUpdate(true);
	}
	public void removeSkull() {
		int i = 0;
		for(Player other : victims) {
			List<Player> othersAttackerList = new CopyOnWriteArrayList<Player>(other.getSkullManager().getAttackers());
			if (other != null) {
				for (Player othersAttackers : othersAttackerList) {
					if (othersAttackers != null) {
						if (othersAttackers.getUsername().equals(player.getUsername())) {
							othersAttackerList.remove(i);
							other.getSkullManager().attackers = othersAttackerList;
						}
						i++;
					}
				}
			}
			i = 0;
		}
		i = 0;
		for(Player other : attackers) {
			List<Player> othersVictimList = new CopyOnWriteArrayList<Player>(other.getSkullManager().getVictims());
			if (other != null) {
				for (Player othersVictims : othersVictimList) {
					if (othersVictims != null) {
						if (othersVictims.getUsername().equals(player.getUsername())) {
							othersVictimList.remove(i);
							other.getSkullManager().victims = othersVictimList;
						}
						i++;
					}
				}
			}
			i = 0;
		}
		victims.clear();
		attackers.clear();
		player.setAttribute("skulled", false);
		skullTicks = -1;
		player.getMask().setApperanceUpdate(true);
	}
	/**
	 * Gets the amount of ticks left.
	 * @return The amount of ticks.
	 */
	public int getTicks() {
		if (skullTicks != -1 && (skullTicks < World.getTicks())) {
			skullTicks = -1;
			player.getMask().setApperanceUpdate(true);
		}	
		return skullTicks;
	}
	
	/**
	 * Sets the amount of skull ticks left.
	 * @param ticks The ticks.
	 */
	public void setTicks(int ticks) {
		this.skullTicks = ticks;
		player.getMask().setApperanceUpdate(true);
	}
	
	/**
	 * Checks if the player is skulled.
	 * @return {@code True} if so, {@code false} if not.
	 */
	public boolean isSkulled() {
		return skullTicks > World.getTicks();
	}

	/**
	 * @return the victims
	 */
	public List<Player> getVictims() {
		return victims;
	}

	/**
	 * @return the attackers
	 */
	public List<Player> getAttackers() {
		return attackers;
	}
}