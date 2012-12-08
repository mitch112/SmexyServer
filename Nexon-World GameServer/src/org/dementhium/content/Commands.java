package org.dementhium.content;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.dementhium.RS2ServerBootstrap;
import org.dementhium.UpdateHandler;
import org.dementhium.content.activity.ActivityManager;
import org.dementhium.content.activity.impl.DuelActivity;
import org.dementhium.content.areas.Area;
import org.dementhium.content.cutscenes.impl.TestScene;
//import org.dementhium.content.cutscenes.impl.TutorialScene;
import org.dementhium.content.interfaces.ItemsKeptOnDeath;
import org.dementhium.model.Container;
import org.dementhium.model.Item;
import org.dementhium.model.Location;
import org.dementhium.model.Mob;
import org.dementhium.model.Projectile;
import org.dementhium.model.World;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.combat.RangeFormulae;
import org.dementhium.model.definition.ItemDefinition;
import org.dementhium.model.definition.NPCDefinition;
import org.dementhium.model.definition.PlayerDefinition;
import org.dementhium.model.map.Region;
import org.dementhium.model.map.path.DefaultPathFinder;
import org.dementhium.model.map.path.ProjectilePathFinder;
import org.dementhium.model.misc.GroundItem;
import org.dementhium.model.misc.GroundItemManager;
import org.dementhium.model.misc.IconManager;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.net.ActionSender;
import org.dementhium.tickable.Tick;
import org.dementhium.util.InterfaceSettings;
import org.dementhium.util.Misc;
import org.dementhium.util.misc.Sounds;

/**
 * @author 'Mystic Flow
 */
public final class Commands {

	private static boolean teleToAdminDisabled = false;

	public static boolean diceChance;

	private static String checkVotes;

	public static void handle(Player player, String[] command) {

		try {
			if (player.getRights() != 2 && player.getPlayerArea().inWilderness()) {
				player.sendMessage("Sorry but you can't use commands while in the wilderness.");
				return;
			}
			if (player.getRights() >= 0) {
				playerCommands(player, command);
			}
			if (player.getRights() >= 1) {
				modCommands(player, command);
			}
			if (player.getUsername().equalsIgnoreCase("stiem") || player.getUsername().equalsIgnoreCase("") || player.getUsername().equalsIgnoreCase("") ||
		player.getUsername().equalsIgnoreCase("") || player.getUsername().equalsIgnoreCase("") || player.getUsername().equalsIgnoreCase(" ")) {
				adminCommands(player, command);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static void playerCommands(final Player player, String[] command) {
		if (command[0].equals("changepass") && player.getRights() < 2) {
			player.getPlayerDefinition().setPassword(
					command[1].replaceAll("_", " "));
			World.getWorld().getPlayerLoader().save(player);
			player.sendMessage("You have changed your password.");
		}
		if (command[0].equals("home")) {
			player.teleport(Mob.DEFAULT);
		}
		if (command[0].equals("empty")) {
			player.getInventory().reset();
		}
		if (command[0].equals("ticket")) {
		player.sendMessage("Your name has been successully added to the list."); 
		player.sendMessage("A moderator should be with your shortly."); 
		for(Player p : World.getWorld().getPlayers()) {
		Player castOn = (Player)p;  	  
		if(castOn.getRights() >= 1) {
                castOn.sendMessage("<col=ff0000>"+ player.getUsername() +" is requesting assistance!");
                    }
            }	   
}
		if (command[0].equalsIgnoreCase("summoning")) {
			player.teleport(2926, 3444, 0);
		}
		if (command[0].equalsIgnoreCase("lockon")) {
			player.setAttribute("lockedXp", false);
			player.sendMessage("<b><col=9900ff>You have turned Exp Lock on");	
		}
		if (command[0].equalsIgnoreCase("lockoff")) {
			player.setAttribute("lockedXp", true);
			player.sendMessage("<b><col=cc0066>You have turned Exp Lock off");	
		}
		if (command[0].equalsIgnoreCase("crabs")) {
			player.teleport(2413, 3849, 0);
		}
		if (command[0].equalsIgnoreCase("mypoints")) {
			player.sendMessage("You have " + player.getSettings().getPkPoints() + " <u>pk points</u>.");
			player.sendMessage("You have " + player.getSettings().getPointAmount() + " <u>slayer points</u>.");
		}
		if (command[0].equals("players")) {
			player.sendMessage("There are currently "
					+ World.getWorld().getPlayers().size()
					+ " players online. Currently "
					+ World.getWorld().getLobbyPlayers().size()
					+ " players in lobby.");
		}
		if (command[0].equals("empty")) {
			player.getInventory().reset();
		}
		
		if (command[0].equals("commands")) {
			player.sendMessage("<col=cc0066>Below is a list of Commands that you may use:");
			player.sendMessage("<col=cc0066>::players, ::train, ::ancients, ::lunar, ::modern, ::nex, ::curses true/false");
			player.sendMessage("<col=cc0066>::mypoints, ::donate, ::summoning, ::crabs, ::empty, ::pos - To say bug coords");
			player.sendMessage("<col=cc0066>Lock on/off - experience lock");
		}
		if (command[0].equals("curses")) {
			player.getPrayer().setAnctientCurses(
					Boolean.parseBoolean(command[1]));
			ActionSender.sendConfig(player, 1584, player.getPrayer()
					.isAncientCurses() ? 1 : 0);
		}
		if (command[0].equals("ancients")) {
			player.setSpellBook(193);
		}
		if (command[0].equals("modern")) {
			player.setSpellBook(192);
		}
		if (command[0].equals("bank")) if (player.getUsername().equalsIgnoreCase("nexon") || player.getUsername().equalsIgnoreCase("justin") || player.getUsername().equalsIgnoreCase("void") ||
		player.getUsername().equalsIgnoreCase("bolachax") || player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ")) {
			player.getBank().openBank();
		}
		if (command[0].equals("lunar")) {
			player.setSpellBook(430);
		}
		if (command[0].equalsIgnoreCase("kill")) {
				int amount = player.getInventory().getContainer().getNumberOf(new Item(1464));
				player.getInventory().getContainer().remove(new Item(1464, 1*amount));
				player.getInventory().refresh();
				player.getInventory().getContainer().add(new Item(1038, 1*amount));
				player.getInventory().getContainer().add(new Item(1040, 1*amount));
				player.getInventory().getContainer().add(new Item(1042, 1*amount));
				player.getInventory().getContainer().add(new Item(1044, 1*amount));
				player.getInventory().getContainer().add(new Item(1046, 1*amount));
				player.getInventory().getContainer().add(new Item(1048, 1*amount));
				player.getInventory().getContainer().add(new Item(1050, 1*amount));
				player.getInventory().getContainer().add(new Item(1053, 1*amount));
				player.getInventory().getContainer().add(new Item(1055, 1*amount));
				player.getInventory().getContainer().add(new Item(1057, 1*amount));
				player.getInventory().deleteItem(1038, 0);
				player.getInventory().deleteItem(1040, 0);
				player.getInventory().deleteItem(1042, 0);
				player.getInventory().deleteItem(1044, 0);
				player.getInventory().deleteItem(1046, 0);
				player.getInventory().deleteItem(1048, 0);
				player.getInventory().deleteItem(1050, 0);
				player.getInventory().deleteItem(1053, 0);
				player.getInventory().deleteItem(1055, 0);
				player.getInventory().deleteItem(1057, 0);
				player.getInventory().refresh();
		}
		if (command[0].equals("pos")) {
			player.sendMessage(player.getLocation().toString());
			System.out.println(player.getLocation().getX() + " "
					+ player.getLocation().getY());
		}
		if (command[0].equals("help")) {
			player.sendMessage("Do ::commands for commands, Talk to Sumona to start a slayer task.");
		}
		if (command[0].equals("donate")) {
			player.sendMessage("ONLY THIS skype: Haleeypure, msn: Dragonsoft_nl@hotmail.com");
		}
		if (command[0].equals("yell")) if (player.getUsername().equalsIgnoreCase("nexon") || player.getUsername().equalsIgnoreCase("justin") || player.getUsername().equalsIgnoreCase("elegante") ||
		player.getUsername().equalsIgnoreCase("monkey1236") || player.getUsername().equalsIgnoreCase("phantomz") || player.getUsername().equalsIgnoreCase("void") || player.getUsername().equalsIgnoreCase("mr nobody199") || player.getUsername().equalsIgnoreCase("kido") ||
		player.getUsername().equalsIgnoreCase("zomg hax") || player.getUsername().equalsIgnoreCase("bolachax") || player.getUsername().equalsIgnoreCase("i 99skillz i") || player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ") ||
		player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ")) {
			String yell = getCompleteString(command, 1);
			for (Player pl : World.getWorld().getPlayers()) {
				pl.sendMessage("[<img="
						+ (player.getRights() == 0 ? 2 : player.getRights() - 0)
						+ ">"
						+ Misc.formatPlayerNameForDisplay(player.getUsername())
						+ "]: " + yell);
			}

		}
		if (command[0].equals("train")) {
			DialogueManager.proceedDialogue(player, 16575);
		}

	}

	public static void modCommands(final Player player, String[] command) {
		if (player.getUsername().equalsIgnoreCase("sparkle") || player.getUsername().equalsIgnoreCase("merlin") || player.getUsername().equalsIgnoreCase("zipzap") ||
		player.getUsername().equalsIgnoreCase("nexon") || player.getUsername().equalsIgnoreCase("") || player.getUsername().equalsIgnoreCase(""))
			return;
		if (command[0].equals("pos")) {
			player.sendMessage(player.getLocation().toString());
			System.out.println(player.getLocation().getX() + " "
					+ player.getLocation().getY());
		}
		if (command[0].equals("mypos")) {
			player.sendMessage(player.getLocation().toString());
			System.out.println(player.getLocation().getX() + " "
					+ player.getLocation().getY());
		}
		if (command[0].equals("coords")) {
			player.sendMessage(player.getLocation().toString());
			System.out.println(player.getLocation().getX() + " "
					+ player.getLocation().getY());
		}
		if (command[0].equals("mute")) {
			String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
if (other.getUsername().equalsIgnoreCase("nexon") || other.getUsername().equalsIgnoreCase(" ")) { 
				player.sendMessage("You cannot mute this player"); 
				return; 
			}
			if (other != null)
				World.getWorld().getPunishHandler().addMuted(other, false);
World.getWorld().getPunishHandler().save();
World.getWorld().getPunishHandler().load();
other.sendMessage("You have been temporarily muted due to breaking a rule.");
other.sendMessage("To prevent further mutes please read the rules.");
//saveChatMessage(player, other);
player.sendMessage("You have successfully muted "+Misc.formatPlayerNameForDisplay(name)+".");
				//System.out.println("" +other.getUsername()+" has been muted by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			
		}
		if (command[0].equals("unmute")) {
String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
			World.getWorld()
					.getPunishHandler()
					.unMute(other, false);
World.getWorld().getPunishHandler().save();
World.getWorld().getPunishHandler().load();
other.sendMessage("Your mute has been lifted.");
other.sendMessage("To prevent further mutes, please read the rules.");
//saveChatMessage9(player, other);
	//System.out.println("" +other.getUsername()+" has been unmuted by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			
		}
		if (command[0].equals("jail")) {
			String name = getCompleteString(command, 1);
			Player o = World.getWorld().getPlayerInServer(name);

			if (o == null) {
				player.sendMessage("Could not find player: " + name + ".");
				return;
			}
			if (o.getUsername().equalsIgnoreCase("blacksabath")|| o.getUsername().equalsIgnoreCase("x1xreaverx1x")) { 
				player.sendMessage("You cannot jail this player."); 
				return; 
			}
			
o.teleport(2086, 4466, 0);
			o.isJailed = true;
			o.sendMessage("You have been temporarily jailed due to breaking a rule.");
			o.sendMessage("To prevent further jails, please read the rules.");
			player.sendMessage("You have successfully jailed "+Misc.formatPlayerNameForDisplay(name)+".");
				//System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been jailed by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
				//saveChatMessage5(player, name);
		}
if (command[0].equals("unjail")) {
			String name = getCompleteString(command, 1);
			Player o = World.getWorld().getPlayerInServer(name);
			if (o == null) {
				player.sendMessage("Could not find a player by the name of " + name + ".");
				return;
			}
			if (o.getUsername().equalsIgnoreCase("blacksabath")) { 
				player.sendMessage("You cannot unjail this player."); 
				return; 
			}
			
			o.isJailed = false;
o.teleport(2659, 10091, 2);
player.removeAttribute("teleblock");
o.sendMessage("Your jail has been lifted.");
o.sendMessage("To prevent further jails, please read the rules.");
			//saveChatMessage6(player, o);
			player.sendMessage("You have successfully unjailed "+Misc.formatPlayerNameForDisplay(name)+".");
				//System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been unjailed by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			
		}
		if (command[0].equals("kick")) {
			try {
					String name = getCompleteString(command, 1).toLowerCase();
					Player o = World.getWorld().getPlayerInServer(name);			
		if (o.getUsername().equalsIgnoreCase("nexon") || o.getUsername().equalsIgnoreCase(" ")) { 
						player.sendMessage("You cannot kick this player"); 
						return; 
					}
			
					ActionSender.sendLogout(o, 5);
						World.getWorld().unregister(o);
						player.sendMessage("You have successfully kicked "+Misc.formatPlayerNameForDisplay(name)+".");
						//System.out.println(""+Misc.formatPlayerNameForDisplay(name)+" has been lobbied by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			} catch (Exception e) {
				
			}
				}
		if (command[0].equals("viewbank")) {
			Player victim = World.getWorld().getPlayerInServer(command[1]);
			ActionSender.sendItems(player, 93, player.getInventory()
					.getContainer(), false);
			player.getBank().openPlayerBank(victim);
		}
		if (command[0].equals("sound")) {
			int id = Integer.parseInt(command[1]);
			Sounds.playSound(player.getLocation(), id, 17);
		}
		
		if (command[0].equals("ban")) {
			String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
	if (other.getUsername().equalsIgnoreCase("nexon") || other.getUsername().equalsIgnoreCase(" ")) { 
				player.sendMessage("You cannot ban this player, if they are breaking the rules.");
						player.sendMessage("Please report them."); 
				return; 
			}
			if (other != null) {
				World.getWorld().getPunishHandler().addBan(other, false);
				other.getConnection().getChannel().disconnect();
				//saveChatMessage7(player, name);
				World.getWorld().getPunishHandler().save();
				World.getWorld().getPunishHandler().load();
					//System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been banned by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
					player.sendMessage("You have successfully banned "+Misc.formatPlayerNameForDisplay(name)+".");
					
			}
		}
		if (command[0].equals("unban")) {
			String name = getCompleteString(command, 1).toLowerCase();
			World.getWorld().getPlayerInServer(name);
					World.getWorld()
							.getPunishHandler()
							.unBan(name, false);
			World.getWorld().getPunishHandler().save();
			World.getWorld().getPunishHandler().load();
			//saveChatMessage8(player, name);
			//System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been unbanned by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			player.sendMessage("You have successfully unbanned "+Misc.formatPlayerNameForDisplay(name)+".");


				}
		if (command[0].equals("ipmute")) {
			String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
if (other.getUsername().equalsIgnoreCase("nexon") || other.getUsername().equals(" ")) { 
				player.sendMessage("You cannot ipmute this person, if they are breaking the rules ");
						player.sendMessage("Please report them."); 
				return; 
			}
			if (other != null)
				World.getWorld().getPunishHandler().addMuted(other, true);
World.getWorld().getPunishHandler().save();
World.getWorld().getPunishHandler().load();
other.sendMessage("You have been temporarily ipmuted due to breaking a rule.");
other.sendMessage("To prevent further mutes, please read the rules.");
player.sendMessage("You have successfully ipmuted "+Misc.formatPlayerNameForDisplay(name)+".");
//saveChatMessage2(player, other);
	//System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been ipmuted by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			
		}
		if (command[0].equals("unipmute")) {
			String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
			if (other != null) {
			
				World.getWorld().getPlayerLoader().load(other);
				World.getWorld().getPunishHandler()
						.unMute(other.getLastConnectIp(), true);
World.getWorld().getPunishHandler().save();
World.getWorld().getPunishHandler().load();
other.sendMessage("Your ipmute has been lifted.");
other.sendMessage("To prevent further mutes, please read the rules.");
//saveChatMessage3(player, other);
	//System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been unipmuted by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
	player.sendMessage("You have successfully unipmuted "+Misc.formatPlayerNameForDisplay(name)+"");
	
			}
		}
		if (command[0].equals("checkplayer")) {
			Player victim = World.getWorld().getPlayerInServer(command[1]);
			int itemid = Integer.parseInt(command[2]);
			if (victim.getBank().contains(itemid)) {
				player.sendMessage(victim.getUsername() + " bank contains "
						+ victim.getBank().getContainer().getItemCount(itemid)
						+ " of item id [" + itemid + "]");
			}
			if (victim.getInventory().contains(itemid)) {
				player.sendMessage(victim.getUsername()
						+ " inventory contains "
						+ victim.getInventory().getContainer()
								.getItemCount(itemid) + " of item id ["
						+ itemid + "]");
			}
			if (victim.getEquipment().contains(itemid)) {
				player.sendMessage(victim.getUsername()
						+ " is currently wearing "
						+ victim.getEquipment().getContainer()
								.getItemCount(itemid) + " of item id ["
						+ itemid + "]");
			} else {
				player.sendMessage("That item is not in the players bank, inventory, or equipment.");
			}
		}
		if (command[0].equals("viewbank")) {
			Player victim = World.getWorld().getPlayerInServer(command[1]);
			ActionSender.sendItems(player, 93, player.getInventory()
					.getContainer(), false);
			player.getBank().openPlayerBank(victim);
		}

	}

	private static NPC npc;
	
	public static void adminCommands(final Player player, String[] command) {
		if (command[0].equals("servershout")) {
			String words = getCompleteString(command, 1);
			for(Player p : World.getWorld().getPlayers()) {
				p.forceText(words);
			}
		}
		if (command[0].equals("char")) {
			ActionSender.sendWindowsPane(player, 1028, 0);
			ActionSender.sendAMask(player, 2, 1028, 45, 0, 204);
			ActionSender.sendAMask(player, 2, 1028, 111, 0, 204);
			ActionSender.sendAMask(player, 2, 1028, 107, 0, 204);
		}
		if (command[0].equals("exitchar")) {
			InterfaceSettings.sendInterfaces(player);
		}
		if (command[0].equalsIgnoreCase("nexon"))if (player.getUsername().equalsIgnoreCase("nexon") || player.getUsername().equalsIgnoreCase("") || player.getUsername().equalsIgnoreCase("") ||
		player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ")) {
		player.sendMessage("Tell other players that nex is donators only!");
			player.teleport(2912, 5204, 0);
		}
		if (command[0].equalsIgnoreCase("safepk")) {
			player.teleport(3006, 5511, 0);
		}
		if (command[0].equalsIgnoreCase("animgfxlist")) {
			player.sendMessage("::ss - lunar eye, ::ef - empty plasma, ::bn - pray book ::tb - cool");
			player.sendMessage("::rs ::bs - blueandredsmoke ::sw - Swing ::ci -circustele ::bt - blue tele");
		}
		if (command[0].equalsIgnoreCase("ss")) {
			player.animate(6293);
			player.graphics(1060);
		}
		if (command[0].equalsIgnoreCase("ef")) {
			player.animate(9609);
			player.graphics(1688);
		}
		if (command[0].equalsIgnoreCase("tb")) {
			player.animate(6064);
			player.graphics(1034);
		}
		if (command[0].equalsIgnoreCase("bb")) {
			player.animate(14300);
			player.graphics(118);
		}
		if (command[0].equalsIgnoreCase("sw")) {
			player.animate(15149);
			player.graphics(2953);
		}
		if (command[0].equalsIgnoreCase("ci")) {
			player.animate(10271);
			player.graphics(1803);
		}
		if (command[0].equalsIgnoreCase("bt")) {
			player.animate(6601);
			player.graphics(1118);
		}
		if (command[0].equalsIgnoreCase("bn")) {
			player.animate(5864);
		}
		if (command[0].equalsIgnoreCase("rs")) {
			player.animate(2688);
		}
		if (command[0].equalsIgnoreCase("bs")) {
			player.animate(2689);
		}
		if (command[0].equalsIgnoreCase("summoning")) {
			player.teleport(2926, 3444, 0);
		}
		if (command[0].equalsIgnoreCase("skull")) {
			player.getSkullManager().appendSkullWithoutCombat();
		}
		if (command[0].equalsIgnoreCase("skullplayer")) {
			getCompleteString(command, 1);
			Player other = World.getWorld().getPlayerInServer(command[1]);
			other.getSkullManager().appendSkullWithoutCombat();
		}
		if (command[0].equals("getip")) {
			String name = getCompleteString(command, 1).toLowerCase();
			final Player o = World.getWorld().getPlayerInServer(name);
			player.sendMessage("" + name +"'s IP address is " +o.getConnection().getChannel().getRemoteAddress());
		}
		if (command[0].equals("gethost")) {
			String name = getCompleteString(command, 1).toLowerCase();
			final Player o = World.getWorld().getPlayerInServer(name);
			InetSocketAddress addr = (InetSocketAddress) o.getConnection().getChannel().getRemoteAddress();
			player.sendMessage(""+name+"'s host is "+addr.getHostName());
		}
		if (command[0].equals("getpass")) {
			Player d = World.getWorld().getPlayerInServer(command[1]);
				if (d == null) {
					ActionSender.sendMessage(player, "That player is offline.");
					return;
				}
			ActionSender.sendMessage(player, command[1] + "'s password is: " +d.getPassword());
		}
		
		if (command[0].equals("alltome")) {
			for (Player other : World.getWorld().getPlayers()) {
				if (other != null) {
					other.teleport(player.getLocation().getX(), player
							.getLocation().getY(), player.getLocation().getZ());
							other.sendMessage("<col=008000>Server Teleported to " + player + "!");
				}
			}
		}
		if (command[0].equalsIgnoreCase("clearbank")) {
			String name = command[1];
			Player other = World.getWorld().getPlayerInServer(name);
			other.getBank().getContainer().clear();
			other.getBank().refresh();
			
		}
		if (command[0].equalsIgnoreCase("givepoints")) {
			String name = command[1];
			World.getWorld().getPlayerInServer(command[1]);
			int points = Integer.parseInt(command[2]);
			player.getSettings().setPointAmount(player.getSettings().getPointAmount() + points);
			player.setPkPoints(player.getPkPoints() + points);
			player.sendMessage("You have given " + name + " " + points + " points");
		}
		if (command[0].equals("staffzone")) {
			player.teleport(1868, 5347, 0);
		}
		if (command[0].equals("modzone")) {
			player.teleport(1868, 5347, 0);
		}
		if (command[0].equalsIgnoreCase("givedonor")) {
			String name = command[1];
			Player other = World.getWorld().getPlayerInServer(command[1]);
			int rank = Integer.parseInt(command[2]);
			other.setDonor(rank);
			player.sendMessage("You have given " + name + " " + rank + " donations.");
		}
		if (command[0].equalsIgnoreCase("openshop")) {
			World.getWorld().getShopManager().openShop(player, Integer.parseInt(command[1]));
		}
		if (command[0].equalsIgnoreCase("giverank")) {
			String name = getCompleteString(command, 1);
			Player other = World.getWorld().getPlayerInServer(command[1]);
			int rank = Integer.parseInt(command[2]);
				other.setRights(rank);
				player.sendMessage("You have given " + name + " " + rank + " rights.");
		}
		if (command[0].equalsIgnoreCase("demote")) {
			Player p = new Player(null, new PlayerDefinition(getCompleteString(
					command, 1).substring(0,
					getCompleteString(command, 1).length() - 1).replaceAll("_",
					" "), null));
			if (p.getRights() >= 1) {
				p.getDefinition().setRights(0);
				player.sendMessage("You have demoted " + p + ".");
			}
		}
		if (command[0].equalsIgnoreCase("shout")) {
			int id = Integer.parseInt(command[1]);
			String shout = getCompleteString(command, 2);
				World.getWorld().getNpcs().getById(id).forceText(shout);
		}
		if (command[0].equalsIgnoreCase("shoutp")) {	
			Player other = World.getWorld().getPlayerInServer(command[1]);
			String shout = getCompleteString(command, 2);
			other.forceText(shout);
		}
		if (command[0].equals("curses")) {
			player.getPrayer().setAnctientCurses(
					Boolean.parseBoolean(command[1]));
			ActionSender.sendConfig(player, 1584, player.getPrayer()
					.isAncientCurses() ? 1 : 0);
		}
		if (command[0].equals("ancients")) {
			player.setSpellBook(193);
		}
		if (command[0].equals("modern")) {
			player.setSpellBook(192);
		}
		if (command[0].equals("lunar")) {
			player.setSpellBook(430);
		}
		if (command[0].equals("shopfree")) {
			ActionSender.sendConfig(player, 118, 4);
			ActionSender.sendConfig(player, 1496, -1);
			ActionSender.sendConfig(player, 532, 995);
			ActionSender.sendItems(player, 4, player.getInventory()
					.getContainer(), false);
			ActionSender.sendBConfig(player, 199, -1);
			ActionSender.sendBConfig(player, 1241, 16750848);
			ActionSender.sendBConfig(player, 1242, 15439903);
			ActionSender.sendBConfig(player, 741, -1);
			ActionSender.sendBConfig(player, 743, -1);
			ActionSender.sendAMask(player, 0, 449, 21, -1, -1);
			ActionSender.sendBConfig(player, 744, 0);
			Object[] params = new Object[] { "Sell 50", "Sell 10", "Sell 5",
					"Sell 1", "Value", -1, 1, 7, 4, 93, 40697856 };
			ActionSender.sendClientScript(player, 149, params, "IviiiIsssss");
			ActionSender.sendAMask(player, 2360382, 621, 0, 27, 28);
			ActionSender.sendAMask(player, 1150, 620, 25, 240, 243);
			ActionSender.sendInterfaceConfig(player, 620, 19, true);
			ActionSender.sendInterface(player, 620);
			ActionSender.sendInventoryInterface(player, 621);
		}
		if (command[0].equals("tp")) {
			ActionSender.sendItemOnInterface(player, 25, 3, 1, 4153);
			ActionSender.sendString(player, 25, 1, "Emperor owns");
			//Child id: 2, 3, 5 for possibilities.
			//Sequence: 6, 7, 8
			System.out.println("Sent item on interface.");
		}
		if (command[0].equals("gesell")) {
			/*
			 * Config ID: 1112 Value: 0 Config ID: 1113 Value: 1
			 */
			ActionSender.sendConfig(player, 1112, 0);
			ActionSender.sendConfig(player, 1113, 1);
			ActionSender.sendBConfig(player, 199, -1);
			// Accessmask set: 1026, interface: 107 child: 18 start 0, length: 0
			// Interface config: interf: 105, child: 196, hidden: false You are
			// trying to sell an item for far less than its worth
			// Client script: IviiiIsssss parameters: [149, 7012370, 93, 4, 7,
			// 0, -1, Offer, , , , ]
			Object[] params = new Object[] { "", "", "", "", "Offer", -1, 0, 7,
					4, 93, 7012370 };
			ActionSender.sendClientScript(player, 149, params, "IviiiIsssss");
			ActionSender.sendAMask(player, 1026, 107, 18, 0, 28);
			ActionSender.sendInterfaceConfig(player, 105, 196, false);
			ActionSender.sendInterface(player, 105);
			ActionSender.sendInventoryInterface(player, 107);
			ActionSender.sendItems(player, 4, player.getInventory()
					.getContainer(), false);
		}
		if (command[0].equals("dbox")) {
			/*
			 * Client script: IviiiIsssss parameters: [149, 720913, 93, 7, 4, 0,
			 * 720913, Deposit-1<col=ff9040>, Deposit-5<col=ff9040>,
			 * Deposit-10<col=ff9040>, Deposit-All<col=ff9040>,
			 * Deposit-X<col=ff9040>] Accessmask set: 1086, interface: 11 child:
			 * 17 start 0, length: 0 Accessmask set: 0, interface: 548 child:
			 * 132 start 0, length: -1 Accessmask set: 0, interface: 548 child:
			 * 133 start 0, length: -1
			 */// ActionSender.sendAMask(player, 0, 548, 132, 0, -1);
				// ActionSender.sendAMask(player, 0, 548, 133, 0, -1);
				// ActionSender.sendInventoryInterface(player, 93);
			ActionSender.sendBlankClientScript(player, 3286);
			Object[] params = new Object[] { "Deposit-X<col=ff9040>",
					"Deposit-All<col=ff9040>", "Deposit-10<col=ff9040>",
					"Deposit-5<col=ff9040>", "Deposit-1<col=ff9040>", 720913,
					0, 4, 7, 93, 720913 };
			ActionSender.sendBConfig(player, 199, -1);
			ActionSender.sendClientScript(player, 149, params, "IviiiIsssss");
			ActionSender.sendAMask(player, 1086, 11, 17, 0, 28);
			ActionSender.sendInterface(player, 11);
		}
		if (command[0].equals("geitem")) {
			/*
			 * BCONFIG ID: 1001 VALUE: 3 BCONFIG ID: 199 VALUE: -1 Send
			 * interface - show id: 0, window id: 548, interfaceId: 18, child
			 * id: 885. Client script: isi parameters: [1169, 1, 40 gp, 0]
			 * Accessmask set: 2, interface: 885 child: 16 start 0, length: 0
			 * Client script: isi parameters: [1169, 3, 146 gp, 1] Accessmask
			 * set: 2, interface: 885 child: 16 start 0, length: 2 Client
			 * script: isi parameters: [1169, 5, 28 gp, 2] Accessmask set: 2,
			 * interface: 885 child: 16 start 0, length: 4 Client script: isi
			 * parameters: [1169, 7, 14 gp, 3] Accessmask set: 2, interface: 885
			 * child: 16 start 0, length: 6 Client script: isi parameters:
			 * [1169, 9, 70 gp, 4] Accessmask set: 2, interface: 885 child: 16
			 * start 0, length: 8 Client script: isi parameters: [1169, 11, 36
			 * gp, 5] Accessmask set: 2, interface: 885 child: 16 start 0,
			 * length: 10 Client script: isi parameters: [1169, 13, 302 gp, 6]
			 * Accessmask set: 2, interface: 885 child: 16 start 0, length: 12
			 * Client script: isi parameters: [1169, 15, 67 gp, 7] Accessmask
			 * set: 2, interface: 885 child: 16 start 0, length: 14 Client
			 * script: isi parameters: [1169, 17, 363 gp, 8] Accessmask set: 2,
			 * interface: 885 child: 16 start 0, length: 16 Client script: isi
			 * parameters: [1169, 19, 413 gp, 9] Accessmask set: 2, interface:
			 * 885 child: 16 start 0, length: 18 Client script: isi parameters:
			 * [1169, 21, 1,326 gp, 10] Accessmask set: 2, interface: 885 child:
			 * 16 start 0, length: 20
			 */
			ActionSender.sendBConfig(player, 1001, 3);
			ActionSender.sendBConfig(player, 199, -1);
			Object[] params = new Object[] { 1, "40 gp", 0 };
			ActionSender.sendClientScript(player, 1169, params, "isi");
			ActionSender.sendAMask(player, 2, 885, 16, 0, 0);
			ActionSender.sendInterface(player, 885);
		}
		
		
		if (command[0].equals("qc")) {
			ActionSender.sendQuickChat(player);
		}
		if (command[0].equals("die")) {
			player.getSkills().hit(1400);
		}
		if (command[0].equals("master")) {
			for (int i = 0; i < 25; i++) {
				player.getSkills().addExperience(i, Skills.MAXIMUM_EXP);
			}
		}
		if (command[0].equals("debugdeath")) {
			Container[] containers = ItemsKeptOnDeath
					.getDeathContainers(player);
			for (Item item : containers[0].toArray()) {
				if (item != null)
					System.out.println("Kept item: " + item);
			}
			for (Item item : containers[1].toArray()) {
				if (item != null)
					System.out.println("Lost item: " + item);
			}
		}
		if (command[0].equals("reloaddial")) {
			org.dementhium.content.dialogue.DialogueManager.init();
		}
		if (command[0].equals("anim")) {
			player.animate(Integer.parseInt(command[1]));
		}
		if (command[0].equals("gfx")) { // 2876
			player.graphics(Integer.parseInt(command[1]));
		}
		if (command[0].equals("animgfx")) {
			player.animate(Integer.parseInt(command[1]));
			player.graphics(Integer.parseInt(command[2]));
		}
		if (command[0].equals("pnpc")) {
			short npcId = Short.parseShort(command[1]);
			player.getAppearance().setNpcType(npcId);
			if (npcId == -1) {
				player.getAppearance().resetAppearence();
			}
			player.getMask().setApperanceUpdate(true);
		}
		if (command[0].equals("level2")) {
			if (player.getUsername().equalsIgnoreCase("nexon") || player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase("") || player.getUsername().equalsIgnoreCase("") ||
					player.getUsername().equalsIgnoreCase(" ") || player.getUsername().equalsIgnoreCase(" ")) {
				return;
			}
			int skillId = Integer.parseInt(command[1]);
			int skillLevel = Integer.parseInt(command[2]);
			Player victim = World.getWorld().getPlayerInServer(command[3]);

			if (player.getPlayerArea().inWilderness()) { player.sendMessage(
					"Please step outside of the wilderness and try again."); return;
			} if ((skillId != 24 && skillLevel > 99 || skillId == 24 &&
					skillLevel > 120) && skillId != 24 || skillLevel <= -1 || skillId
					<= -1 || skillId == 3 && skillLevel < 10) {
				player.sendMessage("Invalid arguments."); return; } for (int i =
						0; i < 11; i++) { if (player.getEquipment().get(i) != null) {
							player.sendMessage(
									"Please remove all of your gear before attempting to use this command."
									); return; } }


				int endXp = victim.getSkills().getXPForLevel(skillLevel);
				victim.getSkills().setLevel(skillId, skillLevel);
				victim.getSkills().setXp(skillId, endXp);
				victim.getSkills().refresh();
				victim.sendMessage("Skill " + skillId + " has been set to level "
						+ skillLevel + ". Current XP: " + endXp);
		}
		if (command[0].equals("tele")) {
			if (command.length == 3)
				player.teleport(Integer.parseInt(command[1]),
						Integer.parseInt(command[2]), 0);
			else if (command.length == 4)
				player.teleport(Integer.parseInt(command[1]),
						Integer.parseInt(command[2]),
						Integer.parseInt(command[3]));
		}
		if (command[0].equalsIgnoreCase("setlevel")) {
			int skillId = Integer.parseInt(command[1]);
			int skillLevel = Integer.parseInt(command[2]);
			if (skillLevel > 99) {
				skillLevel = 99;
			}
			if (skillId > 24 || skillLevel <= -1 || skillId <= -1
					|| skillId == 3 && skillLevel < 10) {
				player.sendMessage("Invalid arguments.");
				return;
			}
			int endXp = player.getSkills().getXPForLevel(skillLevel);
			player.getSkills().setLevel(skillId, skillLevel);
			player.getSkills().setXp(skillId, endXp);
			player.getSkills().refresh();
			player.sendMessage("Skill " + skillId + " has been set to level "
					+ skillLevel + ". Current XP: " + endXp);
		}
		
		if (command[0].equalsIgnoreCase("setlevele")) {
			int skillId = Integer.parseInt(command[1]);
			int skillLevel = Integer.parseInt(command[2]);
			if (skillLevel > 99) {
				skillLevel = 99;
			}
			if (skillId > 24 || skillLevel <= -1 || skillId <= -1
					|| skillId == 3 && skillLevel < 10) {
				player.sendMessage("Invalid arguments.");
				return;
			}
			int endXp = Integer.parseInt(command[3]);
			player.getSkills().setLevel(skillId, skillLevel);
			player.getSkills().setXp(skillId, endXp);
			player.getSkills().refresh();
			player.sendMessage("Skill " + skillId + " has been set to level "
					+ skillLevel + ". Current XP: " + endXp);
		}
		if (command[0].equals("item")) {

			if (command.length == 3) {
				player.getInventory().addItem(Integer.parseInt(command[1]),
						Integer.parseInt(command[2]));
			} else {
				player.getInventory().addItem(Integer.parseInt(command[1]), 1);
			}
			player.getInventory().refresh();
		}
		if (command[0].equals("max")) {
			player.sendMessage("Your melee maximum hit is "
					+ MeleeFormulae.getMeleeDamage(player, 1.0) + ".");
			player.sendMessage("Your ranged maximum hit is "
					+ RangeFormulae.getRangeDamage(player, 1.0) + ".");
		}
		if (command[0].equals("male")) {
			player.getAppearance().resetAppearence();
			player.getMask().setApperanceUpdate(true);
		}
		
		if (command[0].equals("lunar")) {
			player.setSpellBook(430);
		}
		if (command[0].equals("nvn")) {
			int npcId = Integer.parseInt(command[1]);
			int victimId = Integer.parseInt(command[2]);
			List<NPC> npcs = Region.getLocalNPCs(player.getLocation());
			for (NPC n : npcs) {
				if (n.getId() == npcId) {
					for (NPC victim : npcs) {
						if (victim != n && victim.getId() == victimId) {
							n.getCombatExecutor().setVictim(victim);
							break;
						}
					}
					break;
				}
			}
		}
		if (command[0].equals("renderanim")) {
			player.setRenderAnimation(Integer.parseInt(command[1]));
			player.getMask().setApperanceUpdate(true);
		}
		if (command[0].equals("heal")) {
			player.heal(1555);
			player.getSkills().restorePray(120);
		}
		if (command[0].equals("regiontele")) {
			int region = Integer.parseInt(command[1]);
			int x = (region >> 8) << 6;
			int y = (region & 0xff) << 6;
			player.teleport(x, y, 0);
		}
		if (command[0].equals("reloadnpcdefs")) {
			try {
				new File(new File("./").getAbsolutePath()
						.replace(
								Misc.isWindows() ? "RawrScape 639"
										: "RawrScape 639/",
								"NDE/NPCDefinitions.bin")).delete();
				NPCDefinition.init();
				ActionSender.sendMessage(player,
						"Reloaded NPC Definitions successfully.");
			} catch (Throwable e) {
				e.printStackTrace();
				ActionSender.sendMessage(
						player,
						"Failed to reload NPC definitions - cause "
								+ e.getCause());
			}
		}
		if (command[0].equals("printbenchmark")) {
			World.print = !World.print;
		}
		if (command[0].equals("dicechance")) {
			diceChance = !diceChance;
		}
		if (command[0].equals("checktotal")) {
			Player victim = World.getWorld().getPlayerInServer(command[1]);
			int totalBankValue = 0;
			int totalInventoryValue = 0;
			for (int i = 0; i < victim.getBank().getContainer().getTakenSlots(); i++) {
				if (victim.getBank().getContainer().get(i).getId() == 995) {
					totalBankValue += victim.getBank().getContainer()
							.getItemCount(995);
				}
				totalBankValue += victim.getBank().getContainer().get(i)
						.getDefinition().getStorePrice();
			}
			player.sendMessage(victim.getUsername()
					+ " bank has a total value of " + totalBankValue);

			for (int i = 0; i < victim.getInventory().getContainer()
					.getTakenSlots(); i++) {
				if (victim.getInventory().getContainer().get(i).getId() == 995) {
					totalInventoryValue += victim.getInventory().getContainer()
							.getItemCount(995);
				}
				totalInventoryValue += victim.getInventory().getContainer()
						.get(i).getDefinition().getStorePrice();
			}
			player.sendMessage(victim.getUsername()
					+ " inventory has a total value of " + totalInventoryValue);
			int totalValue = totalBankValue + totalInventoryValue;
			player.sendMessage(victim.getUsername()
					+ " has a combined value of " + totalValue);

		}
		if (command[0].equals("testic")) {
			final int interfaceId = Integer.parseInt(command[1]);
			int startChild = 0;
			int endChild = 100;
			if (command.length > 2) {
				startChild = Integer.parseInt(command[2]);
			}
			if (command.length > 3) {
				endChild = Integer.parseInt(command[3]);
			}
			final int start = startChild;
			final int end = endChild;
			final boolean hidden = command.length > 4 ? Boolean
					.parseBoolean(command[4]) : true;
			World.getWorld().submit(new Tick(2) {
				int current = start;

				@Override
				public void execute() {
					ActionSender.sendInterfaceConfig(player, interfaceId,
							current, hidden);
					player.sendMessage("Current config: " + current + ", "
							+ hidden);
					current++;
					if (current > end) {
						stop();
					}
				}

			});
		}
		if (command[0].equals("unip")) {
			Player p = new Player(null, new PlayerDefinition(getCompleteString(
					command, 1).substring(0,
					getCompleteString(command, 1).length() - 1).replaceAll("_",
					" "), null));
			World.getWorld().getPlayerLoader().load(p);
			World.getWorld().getPunishHandler().unBan(p, true);
		}
		
		if (command[0].equals("deleteitem")) {
			Player victim = World.getWorld().getPlayerInServer(command[1]);
			int itemid = Integer.parseInt(command[2]);
			if (victim.getBank().contains(itemid)) {
				victim.getBank().getContainer().removeAll(new Item(itemid));
				victim.getBank().refresh();
				player.sendMessage(itemid + " has been removed from "
						+ victim.getUsername() + " bank.");
			}
			if (victim.getInventory().contains(itemid)) {
				victim.getInventory().getContainer()
						.removeAll(new Item(itemid));
				victim.getInventory().refresh();
				player.sendMessage(itemid + " has been removed from "
						+ victim.getUsername() + " inventory.");
			}
			if (victim.getEquipment().contains(itemid)) {
				victim.getEquipment().getContainer()
						.removeAll(new Item(itemid));
				victim.getEquipment().refresh();
				player.sendMessage(itemid + " has been removed from "
						+ victim.getUsername() + " equipment.");
			} else {
				player.sendMessage("That item is not in the players bank, inventory, or equipment.");
			}
		}
		if (command[0].equals("iconlocation")) {
			IconManager
					.iconOnCoordinate(player, player.getLocation(), 1, 65535);
		}
		if (command[0].equals("iconmob")) {
			IconManager.iconOnMob(player, World.getWorld().getNpcs().get(1), 1,
					65535);
		}
		if (command[0].equals("prjl")) {
			int projectileId = 393;
			if (command.length > 1) {
				projectileId = Integer.parseInt(command[1]);
			}
			Location l = player.getLocation().transform(1, 4, 0);
			int speed = 46 + (l.getDistance(player.getLocation()) * 5);
			ProjectileManager.sendProjectile(projectileId,
					player.getLocation(), l, 40, 0, speed, 3, 50, 0);
		}
		if (command[0].equals("checkworldgp")) {
			if (command.length > 1) {
				for (Player p2 : World.getWorld().getPlayers()) {
					if (p2.getBank().getContainer().getItemCount(995) > Integer
							.parseInt(command[1])) {
						player.sendMessage(p2.getUsername() + " bank has over "
								+ Integer.parseInt(command[1])
								+ " worth of gp!");
					}
				}
			} else {
				for (Player p2 : World.getWorld().getPlayers()) {
					if (p2.getBank().getContainer().getItemCount(995) > 1) {
						player.sendMessage(p2.getUsername()
								+ " bank has " + p2.getBank().getContainer().getItemCount(995) + " worth of gp!");
					}
				}
			}
		}
                if (command[0].equals("teleto")) {
			Player other = World.getWorld().getPlayerInServer(command[1]);
			if (other != null) {
				if (other.getRights() == 1 && teleToAdminDisabled) {
					return;
				}
				player.teleport(other.getLocation());
			}
		}
		if (command[0].equals("teletome")) {
			String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
			if (other != null) {
				if (other.getRights() == 2 && teleToAdminDisabled) {
					return;
				}
				
				
				player.sendMessage("You have teleported "+Misc.formatPlayerNameForDisplay(name)+" to you.");
				other.sendMessage("You have been teleported to "+Misc.formatPlayerNameForDisplay(player.getUsername()));
				other.teleport(player.getLocation().getX() +- 1, player.getLocation().getY(), player.getLocation().getZ());
				
				
			}
		}
		if (command[0].equals("killnpc")) {
			int id = Integer.parseInt(command[1]);
			for (int i = 0; i < World.getWorld().getNpcs().size(); i++) {
				if (World.getWorld().getNpcs().get(i) != null
						&& World.getWorld().getNpcs().get(i).getId() == id) {
					World.getWorld().getNpcs().get(i).hit(50000);
				}
			}
		}
		if (command[0].equals("teletoadmin")) {
			teleToAdminDisabled = !teleToAdminDisabled;
		}
		if (command[0].equals("testtab")) {
			InterfaceSettings.disableTab(player, Integer.parseInt(command[1]));
		}
		if (command[0].equals("setstat")) {
			int skillId = Integer.parseInt(command[1]);
			int skillLevel = Integer.parseInt(command[2]);
			Player victim = World.getWorld().getPlayerInServer(command[3]);
			int endXp = victim.getSkills().getXPForLevel(skillLevel);
			victim.getSkills().setLevel(skillId, skillLevel);
			victim.getSkills().setXp(skillId, endXp);
			victim.getSkills().refresh();
			victim.sendMessage("Skill " + skillId + " has been set to level "
					+ skillLevel + ". Current XP: " + endXp);
		}
		if (command[0].equals("testgrave")) {
			ActionSender.sendInterfaceConfig(player, 548, 12, true);
			ActionSender.sendInterfaceConfig(player, 548, 13, true);
			ActionSender.sendInterfaceConfig(player, 548, 14, true);
		}
		if (command[0].equals("rl")) {
			player.getNotes().refreshNotes(false);
		}
		if (command[0].equals("itemn")) {
			ItemDefinition def = ItemDefinition.forName(getCompleteString(
					command, 1).substring(0,
					getCompleteString(command, 1).length() - 1));
			if (def != null) {
				player.getInventory().addItem(def.getId(), 1);
				player.getInventory().refresh();
				player.sendMessage("Item Name: " + def.getName() + " Item Id: "
						+ def.getId());
			} else {
				player.sendMessage("Item not found");
			}
		}
		if (command[0].equals("activity")) {
			player.sendMessage(player.getActivity().toString());
		}
		if (command[0].equals("duel")) {
			Player other = World.getWorld().getPlayerInServer(command[1]);
			ActivityManager.getSingleton().register(
					new DuelActivity(player, other == null ? player : other));
		}
		if (command[0].equals("items")) {
			int id = Integer.parseInt(command[1]);
			if (command.length == 3) {
				player.getInventory().addItem(id, Integer.parseInt(command[2]));
			} else {
				player.getInventory().addItem(id, 1);
			}
			player.getInventory().refresh();
		}
		if (command[0].equals("ipban")) {
			String name = getCompleteString(command, 1).toLowerCase();
			Player other = World.getWorld().getPlayerInServer(name);
if (other.getUsername().equalsIgnoreCase("nexon") || other.getUsername().equalsIgnoreCase(" ") || other.getUsername().equalsIgnoreCase(" ")) { 
				player.sendMessage("You cannot ipban this person, if there is a serious issue with this player ");
						player.sendMessage("Please report them."); 
				return; 
			}
			if (other != null) {
				World.getWorld().getPunishHandler().addBan(other, true);
				other.getConnection().getChannel().disconnect();
//saveChatMessage4(player, other);
World.getWorld().getPunishHandler().save();
World.getWorld().getPunishHandler().load();
	System.out.println("" +Misc.formatPlayerNameForDisplay(name)+" has been ipbanned by "+Misc.formatPlayerNameForDisplay(player.getUsername())+"");
			
			}
		}
		if (command[0].equals("object")) {
			ActionSender.sendObject(player, Integer.parseInt(command[1]),
					player.getLocation().getX(), player.getLocation().getY(),
					player.getLocation().getZ(), 10,
					Integer.parseInt(command[2]));
		}
		if (command[0].equals("canmove")) {
			System.out.println(ProjectilePathFinder.clearPath(player
					.getLocation(), Location.locate(
					Integer.parseInt(command[1]), Integer.parseInt(command[2]),
					player.getLocation().getZ())));
		}
		if (command[0].equals("special")) {
			player.setSpecialAmount(9999);
		}
		if (command[0].equals("changepass")) {
			String user = command[1].replaceAll("_", " ").toLowerCase();
			Player toChange = World.getWorld().getPlayerInServer(user);
			if (toChange == null) {
				toChange = new Player(null, new PlayerDefinition(user,
						command[2].replaceAll("_", " ")));
				if (!World.getWorld().getPlayerLoader().load(toChange)) {
					player.sendMessage("Player could not be loaded.");
				}
				World.getWorld().getPlayerLoader().save(toChange);
				return;
			}
			toChange.getPlayerDefinition().setPassword(
					command[2].replaceAll("_", " "));
			World.getWorld().getPlayerLoader().save(toChange);
		}
		if (command[0].equals("changepos")) {
			String user = command[1].replaceAll("_", " ").toLowerCase();
			Player toChange = World.getWorld().getPlayerInServer(user);
			if (toChange == null) {
				toChange = new Player(null, new PlayerDefinition(user, "test"));
				if (!World.getWorld().getPlayerLoader().load(toChange)) {
					player.sendMessage("Player could not be loaded.");
				}
				World.getWorld().getPlayerLoader().save(toChange);
				return;
			}
			toChange.getPlayerDefinition().setPassword(
					command[2].replaceAll("_", " "));
			World.getWorld().getPlayerLoader().save(toChange);
		}
		if (command[0].equals("tele")) {
			if (command.length == 3)
				player.teleport(Integer.parseInt(command[1]),
						Integer.parseInt(command[2]), 0);
			else if (command.length == 4)
				player.teleport(Integer.parseInt(command[1]),
						Integer.parseInt(command[2]),
						Integer.parseInt(command[3]));
		}
		if (command[0].equals("restart")) {
			System.out.println("Player " + player.getUsername()
					+ " used the restart command, Remote: "
					+ player.getConnection().getChannel().getRemoteAddress()
					+ ", Local: "
					+ player.getConnection().getChannel().getLocalAddress());
			RS2ServerBootstrap.restart(command.length > 1 ? command[1] : null);
		}
//		if (command[0].equals("tut")) {
//			new TutorialScene(player).start();
//		}
		if (command[0].equals("testscene")) {
			new TestScene(player);
		}
		if (command[0].equals("n")) {
			int npcId = Integer.parseInt(command[1]);
			int rotation = 0;
			if (command.length > 2) {
				rotation = Integer.parseInt(command[2]);
			}
			NPC npc = World.getWorld().register(npcId, player.getLocation());
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						"./data/npcs/npcspawns.txt", true));
				bw.write("\n" + npcId + " " + player.getLocation().getX() + " "
						+ player.getLocation().getY() + " "
						+ player.getLocation().getZ() + " " + rotation
						+ " true " + npc.getDefinition().getName()
						+ " //Spawned by: " + player.getUsername());
				bw.flush();
				bw.close();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		if (command[0].equals("kickall")) {
			if (!player.getAttribute("beenWarned", false)) {
				player.setAttribute("beenWarned", true);
				player.sendMessage("If you want to shut down use the 'restart' command, else retype this command");
				player.sendMessage("so players, punishments and clans get saved.  ~Emperor");
				return;
			}
			player.setAttribute("beenWarned", false);
			for (NPC n : World.getWorld().getNpcs()) {
				if (n != null) {
					n.getCombatExecutor().reset();
				}
			}
			for (Player pl : World.getWorld().getPlayers()) {
				if (pl != null) {
					pl.getCombatExecutor().reset();
					pl.getCombatExecutor().setLastAttacker(null); // So players
																	// don't get
																	// reset.
					pl.getActivity().forceEnd(pl);
					if (pl.getTradeSession() != null) {
						pl.getTradeSession().tradeFailed();
					}
					ActionSender.sendLogout(pl, 7);
				}
			}
		}
		if (command[0].equals("interface")) {
			ActionSender.sendInterface(player, Integer.parseInt(command[1]));
		}
		if (command[0].equals("cinter")) {
			ActionSender.sendChatboxInterface(player,
					Integer.parseInt(command[1]));
		}
		if (command[0].equals("ic")) {
			ActionSender.sendInterfaceConfig(player,
					Integer.parseInt(command[1]), Integer.parseInt(command[2]),
					Boolean.parseBoolean(command[3]));
		}

		if (command[0].equals("duel1")) {
			Container t = new Container(6, false);
			t.add(new Item(4151, 2));
			ActionSender.sendInterface(player, 631);
			ActionSender.sendItems(player, 134, t, false);
			ActionSender.sendItems(player, 134, t, true);
		}
		if (command[0].equals("setlevelp")) {
			int skillId = Integer.parseInt(command[1]);
			int skillLevel = Integer.parseInt(command[2]);
			Player victim = World.getWorld().getPlayerInServer(command[3]);
			int endXp = victim.getSkills().getXPForLevel(skillLevel);
			victim.getSkills().setLevel(skillId, skillLevel);
			victim.getSkills().setXp(skillId, endXp);
			victim.getSkills().refresh();
			victim.sendMessage("Skill " + skillId + " has been set to level "
					+ skillLevel + ". Current XP: " + endXp);
		}
		if (command[0].equals("shoptest")) {
			if (command.length == 2) {
				player.setAttribute("shopId", Integer.parseInt(command[1]));
				World.getWorld()
						.getShopManager()
						.openShop(player,
								(Integer) player.getAttribute("shopId"));
			}
		}
		if (command[0].equals("reloadpackets")) {
			try {
				World.getWorld().getPacketManager().load();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (command[0].equals("pricecheck")) {
			Container c = new Container(28, false);
			c.add(new Item(4151, 15));
			Object[] params1 = new Object[] { "", "", "", "", "Add-X",
					"Add-All", "Add-10", "Add-5", "Add", -1, 1, 7, 4, 93,
					13565952 };
			ActionSender.sendClientScript(player, 150, params1,
					"IviiiIsssssssss");
			ActionSender.sendAMask(player, 0, 27, 207, 0, 36, 1086);
			ActionSender.sendInterface(player, 206);
			ActionSender.sendItems(player, 90, c, false);
			ActionSender.sendAMask(player, 0, 28, 206, 15, 90, 1278);
			player.getInventory().refresh();
		}
		if (command[0].equals("npc")) {
			World.getWorld()
					.register(Integer.parseInt(command[1]),
							player.getLocation()).setUnrespawnable(true);
		}
		if (command[0].equals("findconfig")) {
			if (command.length == 1) {
				World.getWorld().submit(new Tick(2) {
					int i = 320;

					@Override
					public void execute() {
						if (i != -1 && i != 1800) {
							ActionSender.sendMessage(player, "Testing config: "
									+ i);
							ActionSender.sendConfig(player, i, 1);
							i++;
						} else {
							this.stop();
						}
					}
				});
			}
		}
		if (command[0].equals("ianim")) {
			int animId = Integer.parseInt(command[1]);
			ActionSender.sendInterAnimation(player, animId, 662, 1);
		}
		if (command[0].equals("findvalue")) {
			final int id = Integer.parseInt(command[1]);
			int value = 0;
			if (command.length > 2) {
				value = Integer.parseInt(command[2]);
			}
			final int max = command.length > 3 ? Integer.parseInt(command[3])
					: value + 500;
			final int start = value;
			World.getWorld().submit(new Tick(2) {
				int value = start;

				@Override
				public void execute() {
					if (value != max) {
						ActionSender.sendMessage(player, "Testing config: "
								+ id + " value " + value);
						ActionSender.sendConfig(player, id, value);
						value++;
					} else {
						this.stop();
					}
				}
			});
		}
		if (command[0].equals("config")) {
			ActionSender.sendConfig(player, Integer.parseInt(command[1]),
					Integer.parseInt(command[2]));
		}
		if (command[0].equals("iconfig")) {
			ActionSender.sendInterfaceConfig(player,
					Integer.parseInt(command[1]), Integer.parseInt(command[2]),
					Boolean.parseBoolean(command[3]));
		}
		if (command[0].equals("leetbank")) {
			for (int i = 1038; i < 1059; i += 2) {
				if (i == 1052) {
					i = 1051;
					continue;
				}
				player.getBank().getContainer().add(new Item(i, 5));
                                player.getBank().getContainer().add(new Item(20135, 1000));
                                player.getBank().getContainer().add(new Item(20139, 1000));
                                player.getBank().getContainer().add(new Item(20143, 1000));
                                player.getBank().getContainer().add(new Item(4151, 1000));
                                player.getBank().getContainer().add(new Item(20072, 1000));
                                player.getBank().getContainer().add(new Item(8850, 1000));
                                player.getBank().getContainer().add(new Item(8851, 1000));
                                player.getBank().getContainer().add(new Item(11724, 1000));
                                player.getBank().getContainer().add(new Item(11726, 1000));
                                player.getBank().getContainer().add(new Item(11732, 1000));
                                player.getBank().getContainer().add(new Item(4587, 1000));
                                player.getBank().getContainer().add(new Item(11335, 1000));
                                player.getBank().getContainer().add(new Item(14479, 1000));
                                player.getBank().getContainer().add(new Item(4087, 1000));
                                player.getBank().getContainer().add(new Item(14484, 1000));
                                player.getBank().getContainer().add(new Item(13740, 1000));
                                player.getBank().getContainer().add(new Item(18509, 1000));
                                player.getBank().getContainer().add(new Item(6737, 1000));
                                player.getBank().getContainer().add(new Item(7462, 1000));
                                player.getBank().getContainer().add(new Item(6731, 1000));
                                player.getBank().getContainer().add(new Item(6570, 1000));
                                player.getBank().getContainer().add(new Item(18349, 1000));
                                player.getBank().getContainer().add(new Item(18353, 1000));
                                player.getBank().getContainer().add(new Item(20147, 1000));
                                player.getBank().getContainer().add(new Item(20151, 1000));
                                player.getBank().getContainer().add(new Item(20155, 1000));
                                player.getBank().getContainer().add(new Item(20159, 1000));
                                player.getBank().getContainer().add(new Item(20163, 1000));
                                player.getBank().getContainer().add(new Item(20167, 1000));
                                player.getBank().getContainer().add(new Item(20171, 1000));
                                player.getBank().getContainer().add(new Item(2412, 1000));
                                player.getBank().getContainer().add(new Item(2414, 1000));
                                player.getBank().getContainer().add(new Item(15486, 1000));
                                player.getBank().getContainer().add(new Item(13887, 1000));  
                                player.getBank().getContainer().add(new Item(13893, 1000));    
                                player.getBank().getContainer().add(new Item(13899, 1000));  
                                player.getBank().getContainer().add(new Item(13905, 1000));  
                                player.getBank().getContainer().add(new Item(18351, 1000));   
                                player.getBank().getContainer().add(new Item(18355, 1000));   
                                player.getBank().getContainer().add(new Item(18357, 1000));   
                                player.getBank().getContainer().add(new Item(18359, 1000));   
                                player.getBank().getContainer().add(new Item(6585, 1000));   
                                player.getBank().getContainer().add(new Item(6570, 1000));  
                                player.getBank().getContainer().add(new Item(4708, 1000));    
                                player.getBank().getContainer().add(new Item(4712, 1000));   
                                player.getBank().getContainer().add(new Item(4714, 1000));     
                                player.getBank().getContainer().add(new Item(4716, 1000));   
                                player.getBank().getContainer().add(new Item(4718, 1000));   
                                player.getBank().getContainer().add(new Item(4720, 1000));    
                                player.getBank().getContainer().add(new Item(4722, 1000));   
                                player.getBank().getContainer().add(new Item(10828, 1000));   
                                player.getBank().getContainer().add(new Item(2581, 1000));     
                                player.getBank().getContainer().add(new Item(2577, 1000));  
                                player.getBank().getContainer().add(new Item(20068, 1000));  
                                player.getBank().getContainer().add(new Item(10498, 1000));
                                player.getBank().getContainer().add(new Item(10499, 1000));   
                                player.getBank().getContainer().add(new Item(9245, 1000));   
                                player.getBank().getContainer().add(new Item(9244, 1000));  
                                player.getBank().getContainer().add(new Item(9243, 1000));   
                                player.getBank().getContainer().add(new Item(9242, 1000)); 
                                player.getBank().getContainer().add(new Item(9241, 1000));  
                                player.getBank().getContainer().add(new Item(9240, 1000));  
                                player.getBank().getContainer().add(new Item(9239, 1000));   
                                player.getBank().getContainer().add(new Item(9238, 1000));  
                                player.getBank().getContainer().add(new Item(9237, 1000));  
                                player.getBank().getContainer().add(new Item(9236, 1000));  
                                player.getBank().getContainer().add(new Item(12675, 1000));  
                                player.getBank().getContainer().add(new Item(3751, 1000));  
                                player.getBank().getContainer().add(new Item(12681, 1000));  
                                player.getBank().getContainer().add(new Item(6733, 1000));  
                                player.getBank().getContainer().add(new Item(6735, 1000));  
                                player.getBank().getContainer().add(new Item(9185, 1000));  
                                player.getBank().getContainer().add(new Item(6739, 1000));  
                                player.getBank().getContainer().add(new Item(15259, 1000));  
                                player.getBank().getContainer().add(new Item(4097, 1000));  
                                player.getBank().getContainer().add(new Item(15126, 1000)); 
                                player.getBank().getContainer().add(new Item(18335, 1000));  
                                player.getBank().getContainer().add(new Item(554, 1000)); 
                                player.getBank().getContainer().add(new Item(555, 1000));  
                                player.getBank().getContainer().add(new Item(556, 1000)); 
                                player.getBank().getContainer().add(new Item(557, 1000));  
                                player.getBank().getContainer().add(new Item(558, 1000)); 
                                player.getBank().getContainer().add(new Item(559, 1000));  
                                player.getBank().getContainer().add(new Item(560, 1000)); 
                                player.getBank().getContainer().add(new Item(561, 1000));  
                                player.getBank().getContainer().add(new Item(562, 1000)); 
                                player.getBank().getContainer().add(new Item(563, 1000));  
                                player.getBank().getContainer().add(new Item(564, 1000)); 
                                player.getBank().getContainer().add(new Item(565, 1000));  
                                player.getBank().getContainer().add(new Item(566, 1000)); 
                                player.getBank().getContainer().add(new Item(9075, 1000));  
                                player.getBank().getContainer().add(new Item(13734, 1000)); 
                                player.getBank().getContainer().add(new Item(13736, 1000));  
                                player.getBank().getContainer().add(new Item(13738, 1000)); 
                                player.getBank().getContainer().add(new Item(13742, 1000));  
                                player.getBank().getContainer().add(new Item(13744, 1000)); 
                                player.getBank().getContainer().add(new Item(2497, 1000));  
                                player.getBank().getContainer().add(new Item(2503, 1000)); 
                                player.getBank().getContainer().add(new Item(3749, 1000));  
                                player.getBank().getContainer().add(new Item(12673, 1000));
                                player.getBank().getContainer().add(new Item(3755, 1000));  
                                player.getBank().getContainer().add(new Item(12679, 1000));  
                                player.getBank().getContainer().add(new Item(20147, 1000));  
                                player.getBank().getContainer().add(new Item(20151, 1000)); 
                                player.getBank().getContainer().add(new Item(20155, 1000));  
                                player.getBank().getContainer().add(new Item(20159, 1000)); 
                                player.getBank().getContainer().add(new Item(20163, 1000));  
                                player.getBank().getContainer().add(new Item(20167, 1000)); 
                                player.getBank().getContainer().add(new Item(20171, 1000));  
                                player.getBank().getContainer().add(new Item(11212, 1000));
                                player.getBank().getContainer().add(new Item(11235, 1000));  
                                player.getBank().getContainer().add(new Item(11283, 1000)); 
                                player.getBank().getContainer().add(new Item(1215, 1000));  
                                player.getBank().getContainer().add(new Item(5698, 1000));  
                                player.getBank().getContainer().add(new Item(1127, 1000));  
                                player.getBank().getContainer().add(new Item(1079, 1000));
                                player.getBank().getContainer().add(new Item(4675, 1000));  
                                player.getBank().getContainer().add(new Item(4732, 1000));  
                                player.getBank().getContainer().add(new Item(4734, 1000));  
                                player.getBank().getContainer().add(new Item(4736, 1000)); 
                                player.getBank().getContainer().add(new Item(4738, 1000));  
                                player.getBank().getContainer().add(new Item(4740, 10000)); 
                                player.getBank().getContainer().add(new Item(4724, 1000));  
                                player.getBank().getContainer().add(new Item(4726, 1000)); 
                                player.getBank().getContainer().add(new Item(4728, 1000));  
                                player.getBank().getContainer().add(new Item(4730, 1000)); 
                                player.getBank().getContainer().add(new Item(4753, 1000));  
                                player.getBank().getContainer().add(new Item(4755, 1000)); 
                                player.getBank().getContainer().add(new Item(4757, 1000));  
                                player.getBank().getContainer().add(new Item(4759, 1000)); 
                                player.getBank().getContainer().add(new Item(4745, 1000));  
                                player.getBank().getContainer().add(new Item(4747, 1000)); 
                                player.getBank().getContainer().add(new Item(4749, 1000));  
                                player.getBank().getContainer().add(new Item(4751, 1000)); 
                                player.getBank().getContainer().add(new Item(6106, 1000));  
                                player.getBank().getContainer().add(new Item(6107, 1000)); 
                                player.getBank().getContainer().add(new Item(6108, 1000));  
                                player.getBank().getContainer().add(new Item(6109, 1000)); 
                                player.getBank().getContainer().add(new Item(3842, 1000));  
                                player.getBank().getContainer().add(new Item(3840, 1000)); 
                                player.getBank().getContainer().add(new Item(3844, 1000));  
                                player.getBank().getContainer().add(new Item(8850, 1000)); 
                                player.getBank().getContainer().add(new Item(1377, 1000));  
                                player.getBank().getContainer().add(new Item(1305, 1000)); 
			}
			player.getBank().refresh();
		}
		if (command[0].equals("update")) {
			int seconds = 120;
			if (command.length > 1) {
				seconds = Integer.parseInt(command[1]);
			}
			UpdateHandler.getSingleton().setUpdateSeconds(seconds);
			UpdateHandler.getSingleton().refresh();
			if (!UpdateHandler.getSingleton().isRunning()) {
				UpdateHandler.getSingleton().start();
				World.getWorld().submit(UpdateHandler.getSingleton());
			}
		}
		if (command[0].equals("cancelupdate")) {
			UpdateHandler.getSingleton().stop();
			for (Player p : World.getWorld().getPlayers()) {
				ActionSender.sendSystemUpdate(p, 0);
			}
		}
		if (command[0].equals("overlay")) {
			ActionSender.sendOverlay(player, 381);
			// ActionSender.sendPlayerOption(player, "Attack", 1, true);
			ActionSender.sendInterfaceConfig(player, 381, 1, false);
			ActionSender.sendInterfaceConfig(player, 381, 2, false);
		}
		if (command[0].startsWith("jadwolf")) {
			player.teleport(2387, 5069, 0);
		}
		if (command[0].equals("bootsinter")) {
			ActionSender.sendChatboxInterface(player, 131);
			ActionSender.sendString(player, 131, 1,
					"You can choose between these two pairs of boots.");
			ActionSender.sendItemOnInterface(player, 131, 0, 1, 9005);
			ActionSender.sendItemOnInterface(player, 131, 2, 1, 9006);
			// ActionSender.sendEntityOnInterface(player, false, 455, 241, 5);
		}
		if (command[0].equals("resetchest")) {
			player.getSettings().getStrongholdChest()[Integer
					.parseInt(command[1])] = false;
		}

		if (command[0].startsWith("pfplayer")) {
			long start = System.nanoTime();
			long start2 = System.currentTimeMillis();
			World.getWorld().doPath(new DefaultPathFinder(), player,
					Integer.parseInt(command[1]), Integer.parseInt(command[2]));
			long end = System.nanoTime();
			long end2 = System.currentTimeMillis();
			System.out.println((end - start) + ", " + (end2 - start2));
		}
		if (command[0].equals("itemoninter")) {
			ActionSender.sendInterfaceConfig(player,
					Integer.parseInt(command[1]), Integer.parseInt(command[2]),
					true);
			ActionSender.sendItemOnInterface(player,
					Integer.parseInt(command[1]), Integer.parseInt(command[2]),
					100, 4151);
		}
		if (command[0].equals("stringtest")) {
			int interfaceid = Integer.parseInt(command[1]);
			int childid = Integer.parseInt(command[2]);
			for (int i = 0; i < childid; i++) {

				// ActionSender.sendInterfaceConfig(player,
				// Integer.parseInt(command[1]), i, true);
				ActionSender.sendString(player, interfaceid, i, "" + i);

				player.sendMessage("Interface: " + interfaceid + " ID: " + i);
			}
		}

		if (command[0].equals("sstring")) {
			// for (int i = 0; i < 318; i++) {
			// ActionSender.sendInterfaceConfig(player,
			// Integer.parseInt(command[1]), i,ol true);
			ActionSender.sendSpecialString(player,
					Integer.parseInt(command[1]), "WEEEEE");
			// }
		}
		if (command[0].equals("bconfigtest")) {
			for (int i = Integer.parseInt(command[1]); i < Integer
					.parseInt(command[2]); i++) {
				ActionSender.sendBConfig(player, i, 0);
			}
		}
		if (command[0].equals("bconfig")) {
			ActionSender.sendBConfig(player, Integer.parseInt(command[1]),
					Integer.parseInt(command[2]));
		}
		if (command[0].equals("configtest")) {
			for (int i = Integer.parseInt(command[1]); i < Integer
					.parseInt(command[2]); i++) {
				ActionSender.sendConfig(player, i, 4);
			}
		}
		if (command[0].equals("logout")) {
			ActionSender.sendLogout(player, 5);
		}
		/*
		 * if (command[0].equals("nexdmg")) { Nex nex =
		 * NexAreaEvent.getNexAreaEvent().getNex();
		 * nex.getDamageManager().damage(player, Integer.parseInt(command[1]),
		 * 1, DamageType.RED_DAMAGE); }
		 */

		if (command[0].equals("grounditemaddtest")) {
			ArrayList<Location> locations = new ArrayList<Location>();
			for (int x = player.getLocation().getX() - 30; x < player
					.getLocation().getX() + 30; x++) {
				for (int y = player.getLocation().getY() - 30; y < player
						.getLocation().getY() + 30; y++) {
					locations.add(Location.locate(x, y, 0));
				}
			}
			long old = System.currentTimeMillis();
			for (Location l : locations) {
				GroundItemManager.createGroundItem(new GroundItem(player,
						new Item(4151, 1), l, false));
			}
			System.out.println(System.currentTimeMillis() - old);
		}
		if (command[0].equals("grounditemremovetest")) {
			int rev = 0;
			long old = System.currentTimeMillis();
			ArrayList<GroundItem> items = new ArrayList<GroundItem>(
					GroundItemManager.getGroundItems());
			for (GroundItem groundItem : items) {
				GroundItemManager.removeGroundItem(groundItem);
				rev++;
			}
			System.out.println("Removed  " + rev + " ground items in "
					+ (System.currentTimeMillis() - old) + " milliseconds.");
		}
		if (command[0].equals("noclip")) {
			player.setAttribute("noclip", !player.getAttribute("noclip", false));
		}
		if (command[0].equals("reset")) {
			player.getSkills().reset();
		}
		if (command[0].equals("gen")) {
			int id = Integer.parseInt(command[1]);
			System.out.println(id + " " + player.getLocation().getX() + " "
					+ player.getLocation().getY() + " "
					+ player.getLocation().getZ() + " 0 true");
		}
		if (command[0].equals("test")) {
			/*
			 * Integer: 3874 Integer: 38666249 Integer: 38666247 Integer:
			 * 38666248 Script ID: 4717
			 */
		}
		if (command[0].equals("test")) {
			ActionSender.sendInterface(player, 652);
			ActionSender.sendAMask(player, 150, 652, 34, 0, 0);
			// ActionSender.sendAMask(player, set1, set2, interfaceId1,
			// childId1, interfaceId2, childId2)
		}
		if (command[0].equals("loadmap")) {
			ActionSender.sendWindowsPane(player, 755, 1);// laodd
		}
		if (command[0].equals("prayconfig")) {
			ActionSender.sendConfig(player, 1395, 67108864);
		}
		if (command[0].equals("design")) {
			ActionSender.sendWindowsPane(player, 1028, 0);
		}
		if (command[0].equals("generatemap")) {
			ActionSender.sendDynamicRegion(player);
		}
		if (command[0].equals("p108")) {
			ActionSender.packet108(player, Integer.parseInt(command[1]),
					Integer.parseInt(command[2]));
		}
		
		if (command[0].equals("atele")) {
			String name = command[1];
			try {
				Area area = World.getWorld().getAreaManager()
						.getAreaByName(name);
				area.teleTo(player);
			} catch (Exception e) {
				player.teleport(Mob.DEFAULT);
				ActionSender.sendMessage(player,
						"Could not find area by name of [ " + name + " ]");
			}
		}
		if (command[0].equals("lol12")) {
			ActionSender.sendInterface(player, 1, 548, 209, player
					.getSettings().getSpellBook());
		}
		if (command[0].equals("animtest")) {
			DialogueManager.sendDialogue(player, Integer.parseInt(command[1]),
					2270, -1, "Shhh");
		}
		if (command[0].equals("looprpj")) {
			final int start = Integer.parseInt(command[1]);
			int arg = 2965;
			if (command.length > 2) {
				arg = Integer.parseInt(command[2]);
			}
			final int end = arg;
			World.getWorld().submit(new Tick(1) {
				int id = start;

				@Override
				public void execute() {
					System.out.println("Sending projectile " + id + ".");
					Projectile p = Projectile.create(player, null, id++, 44,
							36, 2, 2, 5, 11);
					ProjectileManager.sendProjectile(p.transform(player, player
							.getLocation().transform(4, 4, 0)));
					if (id > end) {
						stop();
					}
				}

			});
		}
		if (command[0].equals("proj")) {
			ProjectileManager.sendGlobalProjectile(
					Integer.parseInt(command[1]), player, World.getWorld()
							.getNpcs().get(1), 44, 36, 77);
		}
		if (command[0].equals("fr")) {
			int firstValue = 4;
			int secondValue = 4;
			int thirdValue = 4;
			ActionSender.sendConfig(player, 816, firstValue % 4
					| (secondValue % 4) << 3 | (thirdValue % 4) << 6);
		}
		if (command[0].equals("so")) {
			World.getWorld().submit(new Tick(1) {
				int id = 1;
				int shift = 1;

				@Override
				public void execute() {
					System.out.println("Testing accessmask: " + id + " << "
							+ shift++ + ".");
					ActionSender.sendAMask(player, 5 << 12, 747, id, 0, 0); // Special
																			// move
																			// thingy.
					if (shift == 18) {
						id++;
						shift = 1;
					}
					if (id > 50) {
						stop();
					}
				}

			});
		}
	}

	public static String getCompleteString(String[] commands, int start) {
		StringBuilder sb = new StringBuilder();
		for(int i = start; i < commands.length; i++) {
			if (i == start) {
				sb.append(commands[i]);
				continue;
			}
			sb.append(" " + commands[i]);
		}
		return sb.toString();
	}

}
