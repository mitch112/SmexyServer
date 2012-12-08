package org.dementhium.model.player;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.dementhium.UpdateHandler;
import org.dementhium.content.activity.impl.CastleWarsActivity;
import org.dementhium.content.chardesign.CharacterDesign;
import org.dementhium.content.cutscenes.impl.TutorialScene;
import org.dementhium.content.misc.DFS;
import org.dementhium.content.misc.PriceCheck;
import org.dementhium.content.misc.PunishHandler;
import org.dementhium.content.misc.WildernessDitch;
import org.dementhium.content.skills.Prayer;
import org.dementhium.content.skills.runecrafting.Talisman;
import org.dementhium.content.skills.slayer.Slayer;
import org.dementhium.content.skills.slayer.SlayerTask;
import org.dementhium.content.skills.slayer.SlayerTask.Master;
import org.dementhium.model.Item;
import org.dementhium.model.Location;
import org.dementhium.model.Mob;
import org.dementhium.model.Projectile;
import org.dementhium.model.SpecialAttack;
import org.dementhium.model.SpecialAttackContainer;
import org.dementhium.model.World;
import org.dementhium.model.combat.Ammunition;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.RangeData;
import org.dementhium.model.combat.RangeFormulae;
import org.dementhium.model.combat.RangeWeapon;
import org.dementhium.model.combat.impl.SpecialAction;
import org.dementhium.model.definition.ItemDefinition;
import org.dementhium.model.definition.PlayerDefinition;
import org.dementhium.model.definition.WeaponInterface;
import org.dementhium.model.map.ObjectManager;
import org.dementhium.model.map.region.RegionBuilder;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Appearance;
import org.dementhium.model.mask.ForceText;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.mask.Appearance.Gender;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.misc.SkullManager;
import org.dementhium.model.npc.NpcUpdate;
import org.dementhium.model.player.Notes.Note;
import org.dementhium.net.ActionSender;
import org.dementhium.net.GameSession;
import org.dementhium.net.handler.DementhiumHandler;
import org.dementhium.net.message.Message;
import org.dementhium.task.Task;
import org.dementhium.task.impl.PlayerResetTask;
import org.dementhium.task.impl.PlayerTickTask;
import org.dementhium.task.impl.PlayerUpdateTask;
import org.dementhium.tickable.Tick;
import org.dementhium.tickable.impl.PlayerAreaTick;
import org.dementhium.tickable.impl.PlayerRestorationTick;
import org.dementhium.util.BufferUtils;
import org.dementhium.util.Constants;
import org.dementhium.util.InterfaceSettings;
import org.dementhium.util.Misc;
import org.jboss.netty.buffer.ChannelBuffer;
import org.dementhium.model.misc.IconManager;
import org.dementhium.model.npc.NPC;

/**
 * @author 'Mystic Flow
 * @author `Discardedx2
 * @author Steve
 * @author Lumby
 */
public final class Player extends Mob {

	public boolean inArena = false;
	public int Donator = 0;
    public int NewDonator = 0;
    public int donator = 0;
	private int learn = 0;

	public int getLearnedRing() {
		return learn;
	}
	
	public void setLearnedRing(int learn) {
		this.learn = learn;
	}
	private final WildernessDitch ditch = new WildernessDitch();
	private final DFS dfs = new DFS(this);
	public DFS getDFS() {
		return dfs;
	}
	public int Donator() {
		return this.donator;
	}
	public int getDonator() {
		return definition.getDonator();
	}
	public void disableInArena(final Player player) {
		World.getWorld().submit(new Tick(1) {
				@Override
				public void execute() {
					if (inArena == false) {
						stop();
					}
					if (inArena == true) {
						if(player.getPrayer().isAncientCurses()) {
							player.getPrayer().closeOnPrayers(1, new int[] {Prayer.DEFLECT_MAGIC, Prayer.DEFLECT_MELEE, Prayer.DEFLECT_MISSILES, Prayer.DEFLECT_SUMMONING});
						} else {
							player.getPrayer().closeOnPrayers(0, new int[] {Prayer.PROTECT_FROM_MAGIC, Prayer.PROTECT_FROM_MISSILES, Prayer.PROTECT_FROM_MELEE, Prayer.PROTECT_FROM_SUMMONING});
						}
						player.getPrayer().recalculatePrayer();
						player.getMask().setApperanceUpdate(true);
					}
				}
			});
	}
	
	public void addKolodion(Player player, final int npcId) {
		World.getWorld().submit(new Tick(1) {
			@Override
			public void execute() {
				Player player = getPlayer();
				NPC kolodion = new NPC(npcId, player.getLocation().getX() - 1, player.getLocation().getY() - 1, player.getLocation().getZ());
				World.getWorld().getNpcs().add(kolodion);
				IconManager.iconOnMob(player, kolodion, 1, -1);
				kolodion.setAttribute("enemyIndex", player.getIndex());
				kolodion.getMask().setInteractingEntity(player);
				kolodion.getCombatExecutor().setVictim(player);
				stop();
			}
		});
	}

	private CharacterDesign characterDesign;

	public void initiateCharacterDesign() {
		characterDesign = new CharacterDesign();
		CharacterDesign.initiate(this, appearance);
	}

	public CharacterDesign getCharacterDesign() {
		return characterDesign;
	}
	private transient ActionSender actionsender;

	public void setActionSender(ActionSender actionsender) {
		this.actionsender = actionsender;
	}
	public ActionSender getActionSender() {
		if (actionsender == null)
			actionsender = new ActionSender();
		return actionsender;
	}
	public WildernessDitch getditch() {
		return ditch;
	}
	private int money = 0;

	public int getMoneyBag() {
		return money;
	}

	public void setMoneyBag(int money) {
		this.money = money;
	}
	
	public boolean broad = false;

	public boolean hasLearnedBroads() {
		return broad;
	}
	
	public boolean armadyl = false;

	public boolean hasArmadyl() {
		return armadyl;
	}
	
	public boolean learned = false;

	public boolean hasLearned() {
		return learned;
	}

	public void sendSlayerLearn() {
		ActionSender.sendString(getPlayer(), 163, 18, "" + getSettings().getPointAmount());
		if (hasLearned() == true) {
			ActionSender.sendString(getPlayer(), 163, 27, "(already learned)");
		} else if (getLearnedRing() > 0) {
			ActionSender.sendString(getPlayer(), 163, 26, "(already learned)");
		} else if (hasLearnedBroads()) {
			ActionSender.sendString(getPlayer(), 163, 25, "(already learned)");
		} else {
			ActionSender.sendString(getPlayer(), 163, 27, "");
			ActionSender.sendString(getPlayer(), 163, 26, "");
			ActionSender.sendString(getPlayer(), 163, 25, "");
		}
		ActionSender.sendString(getPlayer(), 163, 30, "120 points");
		ActionSender.sendString(getPlayer(), 163, 29, "170 points");
		ActionSender.sendInterface(getPlayer(), 163);
	}
	
	public void sendSlayerBuy() {
		ActionSender.sendString(getPlayer(), 164, 20, "" + getSettings().getPointAmount());
		ActionSender.sendString(getPlayer(), 164, 28, "Buy Slayer gloves or Korasi");
		ActionSender.sendString(getPlayer(), 164, 36, "90 points or 500 points");
		ActionSender.sendItemOnInterface(getPlayer(), 164, 30, 10, 6720);
		ActionSender.sendItemOnInterface(getPlayer(), 164, 29, 10, 19784);
		ActionSender.sendInterface(getPlayer(), 164);
	}
	
	public void sendSlayerAssign() {
		ActionSender.sendString(getPlayer(), 161, 19, "" + getSettings().getPointAmount());
		ActionSender.sendInterface(getPlayer(), 161);
	}

	String randomDeath() {
		int death = Misc.random(1, 6);
		switch (death) {
			case 1: return "You were clearly a better fighter than ";
			case 2: return "With a crushing blow you finish ";
			case 3: return "With the power of the gods you smite down ";
			case 4: return "You finish off ";
			case 5: return "With an almighty strike you finish off ";
			case 6: return "You proved yourself against ";
		}
		return "You killed ";
	}

	String deathMessages() {
		int death = Misc.random(1, 4);
		switch (death) {
			case 1: return "Come with me";
			case 2: return "You've faced your doom";
			case 3: return "You mine now";
			case 4: return "This was your last chance";
		}
		return "Time to die ";
	}

	public int[] dungRewards = {526, 526, 526, 
					526, 526, 16293, 526, 526, 526, 526,
					526, 526, 16359, 526, 526, 526, 526,
					526, 526, 16403, 526, 526, 526, 526,
					526, 526, 16425, 526, 526, 526, 526,
					526, 526, 16667, 526, 526, 526, 526,
					526, 526, 16689, 526, 526, 526, 526,
					526, 526, 16711, 526, 526, 526, 526,
					526, 526, 16733, 526, 526, 526, 526,
					526, 526, 16837, 526, 526, 526, 526,
					526, 526, 16909, 526, 526, 526, 526,
					526, 526, 16955, 526, 526, 526, 526,
					526, 526, 17039, 526, 526, 526, 526,
					526, 526, 17143, 526, 526, 526, 526,
					526, 526, 17259, 526, 526, 526, 526,
					526, 526, 17361, 526, 526, 526, 526,
					526, 526, 15773, 526, 526, 526, 526};

	public int dungChestReward() {
                return dungRewards[(int)(Math.random()*dungRewards.length)];
        }

	private final PlayerDefinition definition;

	private final Appearance appearance = new Appearance(this);
	private final FriendManager friendManager = new FriendManager(this);
	private final Inventory inventory = new Inventory(this);
	private final Equipment equipment = new Equipment(this);
	private final Skills skills = new Skills(this);
	private final Bank bank = new Bank(this);
	private final Bonuses bonuses = new Bonuses(this);
	private final PlayerUpdate gpi = new PlayerUpdate(this);
	private final NpcUpdate gni = new NpcUpdate(this);
	private final Settings settings = new Settings();
	private final Prayer prayer = new Prayer(this);
	private final RegionData region = new RegionData(this);
	private final PriceCheck priceCheck = new PriceCheck(this);
	private final Notes notes = new Notes(this);
	private final Slayer slayer = new Slayer(this);
	private final PlayerAreaTick playerAreaTick = new PlayerAreaTick(this);

	private List<Integer> mapRegionIds;
	private boolean isAtDynamicRegion;

	/**
	 * The skull manager used.
	 */
	private final SkullManager skullManager = new SkullManager(this);

	/**
	 * The quest storage used.
	 */
	private final QuestStorage questStorage = new QuestStorage();

	private GameSession connection;
	private TradeSession currentTradeSession;
	private Player tradePartner;

	private DementhiumHandler handler;

	private boolean isOnline;
	private boolean starter;
	private boolean active;

	private int viewDistance = 0;

	public Task tickTask = new PlayerTickTask(this),
			updateTask = new PlayerUpdateTask(this),
			resetTask = new PlayerResetTask(this);

	private String lastConnectIp = "null";

	private int viewportDepth;
	private int renderAnimation = -1;

	private long doubleXPTimer;

	private long lastPing = System.currentTimeMillis();

	private static int[] emptyLot = RegionBuilder.findEmptyMap(40, 40); // 16x16
	private final static Location houseLocation = Location.locate(emptyLot[0],
			emptyLot[1], 0);

	public Location getHouseLocation() {
		return houseLocation;
	}

	public void setHouseLocation() {

	}

	public Player(GameSession connection, PlayerDefinition definition) {
		super();
		this.definition = definition;
		this.connection = connection;
	}

	public void loadPlayer() {
		handler = null;
		if (!connection.isInLobby()) {
			setOnline(true);
			loadEntityVariables();
			ActionSender.loginResponse(this);
			World.getWorld().submit(playerAreaTick);
			World.getWorld().submit(new PlayerRestorationTick(this));
			initPackets1();
		} else {
			ActionSender.sendLobbyResponse(this);
		}
		if (World.getWorld().getAreaManager().getAreaByName("Nex")
				.contains(getLocation())) {
			teleport(DEFAULT);
		}
		if (World.getWorld().getAreaManager().getAreaByName("SafePk")
				.contains(getLocation())) {
				ActionSender.sendPlayerOption(this, "Attack", 1, true);
		}
		String name = Misc.formatPlayerNameForDisplay(getUsername());
		for (Player player : World.getWorld().getPlayers()) {
			if (player.getFriendManager().getFriends().contains(name)) {
				player.getFriendManager().updateFriend(name, this);
			}
		}
		for (Player player : World.getWorld().getLobbyPlayers()) {
			if (player.getFriendManager().getFriends().contains(name)) {
				player.getFriendManager().updateFriend(name, this);
			}
		}
		if (getAttribute("clanToJoin") != null) {
			World.getWorld().getClanManager()
					.joinClan(this, (String) getAttribute("clanToJoin"));
			removeAttribute("clanToJoin");
		}
		if (getEquipment().getSlot(Equipment.SLOT_SHIELD) == 8856
				&& !getAttribute("disabledTabs", false)) {
			for (int i : Constants.W_GUILD_CATAPULT_TABS)
				InterfaceSettings.disableTab(this, i);
			ActionSender.sendInterface(this, 1, getConnection()
					.getDisplayMode() >= 2 ? 746 : 548, getConnection()
					.getDisplayMode() >= 2 ? 92 : 207, 411);
			ActionSender.sendBConfig(this, 168, 5);
			setAttribute("disabledTabs", true);
		}
		loadFriendList();
		setDefaultAttributes();
		if (!starter) {
			this.getAppearance().resetAppearence();
			getMask().setApperanceUpdate(true);
		}
	}
	public void initPackets1() {
		World.getWorld().submit(new Tick(2) {
			public void execute() {
				stop();
				active = true;
			}
		});
		ActionSender.sendLoginConfigurations(this);
		ActionSender.sendOtherLoginPackets(this);
		if (!starter) {
			doubleXPTimer = System.currentTimeMillis() + 7200000;
			new TutorialScene(this).start();
			return;
		}
		if (isDead()) {
			skills.sendDead();
		}
		equipment.calculateType();
		for (int i = 0; i < 13; i++) {
			Item item = equipment.get(i);
			if (item != null) {
				ItemDefinition definition = ItemDefinition.forId(item.getId());
				if (equipment.hpModifier(definition)) {
					skills.raiseTotalHp(equipment.getModifier(definition));
				}
			}
		}
		ActionSender.sendConfig(this, 1249, settings.getLastXAmount());
		if (CastleWarsActivity.getSingleton().getZamorakTeam()
				.getDisconnectedPlayers().contains(getUsername())) {
			CastleWarsActivity.getSingleton().getZamorakTeam()
					.getDisconnectedPlayers().remove(getUsername());
			CastleWarsActivity.getSingleton().getZamorakTeam().getPlayers()
					.add(this);
			setActivity(CastleWarsActivity.getSingleton());
			ActionSender.sendPlayerOption(this, "Attack", 1, true);
			ActionSender.sendOverlay(this, 58);
		} else if (CastleWarsActivity.getSingleton().getSaradominTeam()
				.getDisconnectedPlayers().contains(getUsername())) {
			CastleWarsActivity.getSingleton().getSaradominTeam()
					.getDisconnectedPlayers().remove(getUsername());
			CastleWarsActivity.getSingleton().getSaradominTeam().getPlayers()
					.add(this);
			setActivity(CastleWarsActivity.getSingleton());
			ActionSender.sendPlayerOption(this, "Attack", 1, true);
			ActionSender.sendOverlay(this, 58);
		} else if (World.getWorld().getAreaManager()
				.getAreaByName("CastleWarsArea").contains(getLocation())
				|| World.getWorld().getAreaManager()
						.getAreaByName("CastleWarsUnderground")
						.contains(getLocation())) {
			CastleWarsActivity.getSingleton().removeItems(this);
			if (equipment.getSlot(Equipment.SLOT_WEAPON) == 4037
					|| equipment.getSlot(Equipment.SLOT_WEAPON) == 4039) {
				equipment.set(Equipment.SLOT_WEAPON, null);
			}
			teleport(2440 + Misc.random(4), 3083 + Misc.random(12), 0);
		}
		notes.loadNotes();
		notes.refreshNotes(false);
		addObjects();
		this.lastConnectIp = PunishHandler.formatIp(getConnection()
				.getChannel().getRemoteAddress().toString());
		if (UpdateHandler.getSingleton().isRunning()) {
			ActionSender.sendSystemUpdate(this, UpdateHandler.getSingleton()
					.getUpdateSeconds());
		}
		/*
		 * Set tiara config if wearing on login
		 */
		int itemId = this.getEquipment().getSlot(Equipment.SLOT_HAT);
		Talisman talisman = Talisman.getTalismanByTiara(itemId);
		if (talisman != null) {
			if (itemId == talisman.getTiaraId()) {
				ActionSender.sendConfig(this, 491, talisman.getTiaraConfig());
			}
		}
	}


	public void initPackets() {
		World.getWorld().submit(new Tick(2) {
			public void execute() {
				stop();
				active = true;
			}
		});
		ActionSender.sendLoginConfigurations(this);
		ActionSender.sendOtherLoginPackets(this);
		if (!starter) {
			doubleXPTimer = System.currentTimeMillis() + 7200000;
			new TutorialScene(this).start();
			return;
		}
		if (isDead()) {
			skills.sendDead();
		}
		equipment.calculateType();
		for (int i = 0; i < 13; i++) {
			Item item = equipment.get(i);
			if (item != null) {
				ItemDefinition definition = ItemDefinition.forId(item.getId());
				if (equipment.hpModifier(definition)) {
					skills.raiseTotalHp(equipment.getModifier(definition));
				}
			}
		}
		ActionSender.sendConfig(this, 1249, settings.getLastXAmount());
		if (CastleWarsActivity.getSingleton().getZamorakTeam()
				.getDisconnectedPlayers().contains(getUsername())) {
			CastleWarsActivity.getSingleton().getZamorakTeam()
					.getDisconnectedPlayers().remove(getUsername());
			CastleWarsActivity.getSingleton().getZamorakTeam().getPlayers()
					.add(this);
			setActivity(CastleWarsActivity.getSingleton());
			ActionSender.sendPlayerOption(this, "Attack", 1, true);
			ActionSender.sendOverlay(this, 58);
		} else if (CastleWarsActivity.getSingleton().getSaradominTeam()
				.getDisconnectedPlayers().contains(getUsername())) {
			CastleWarsActivity.getSingleton().getSaradominTeam()
					.getDisconnectedPlayers().remove(getUsername());
			CastleWarsActivity.getSingleton().getSaradominTeam().getPlayers()
					.add(this);
			setActivity(CastleWarsActivity.getSingleton());
			ActionSender.sendPlayerOption(this, "Attack", 1, true);
			ActionSender.sendOverlay(this, 58);
		} else if (World.getWorld().getAreaManager()
				.getAreaByName("CastleWarsArea").contains(getLocation())
				|| World.getWorld().getAreaManager()
						.getAreaByName("CastleWarsUnderground")
						.contains(getLocation())) {
			CastleWarsActivity.getSingleton().removeItems(this);
			if (equipment.getSlot(Equipment.SLOT_WEAPON) == 4037
					|| equipment.getSlot(Equipment.SLOT_WEAPON) == 4039) {
				equipment.set(Equipment.SLOT_WEAPON, null);
			}
			teleport(2440 + Misc.random(4), 3083 + Misc.random(12), 0);
		}
		notes.loadNotes();
		notes.refreshNotes(false);
		addObjects();
		this.lastConnectIp = PunishHandler.formatIp(getConnection()
				.getChannel().getRemoteAddress().toString());
		if (UpdateHandler.getSingleton().isRunning()) {
			ActionSender.sendSystemUpdate(this, UpdateHandler.getSingleton()
					.getUpdateSeconds());
		}
		/*
		 * Set tiara config if wearing on login
		 */
		int itemId = this.getEquipment().getSlot(Equipment.SLOT_HAT);
		Talisman talisman = Talisman.getTalismanByTiara(itemId);
		if (talisman != null) {
			if (itemId == talisman.getTiaraId()) {
				ActionSender.sendConfig(this, 491, talisman.getTiaraConfig());
			}
		}
	}

	private void setDefaultAttributes() {
		setAttribute("canWalk", Boolean.TRUE);

	}

	public void loadFriendList() {
		ActionSender.sendUnlockIgnoreList(this);
		friendManager.loadIgnoreList();
		friendManager.loadFriendList();
	}

	public GameSession getConnection() {
		return connection;
	}

	public String getUsername() {
		return definition.getName();
	}

	public String getPassword() {
		return definition.getPassword();
	}

	public int getRights() {
		return definition.getRights();
	}

	public int getDonor() {
		return definition.getDonor();
	}
	
	public int getPkPoints() {
		return settings.getPkPoints();
	}
	public boolean isJailed;
	public boolean playerJailed;
	public void setJailed(boolean isJailed) {
		this.playerJailed = isJailed;
	}
	public boolean isJailed() {
		return playerJailed;
	}
	public int getKilledPersons() {
		return settings.getKilledPersons();
	}
	public int[] looks = new int[7];
	public  int[] colours = new int[5];
	public void load(ByteBuffer buffer) {
		BufferUtils.readRS2String(buffer);
		if(buffer.remaining() > 0) {
			setLocation(Location.locate(buffer.getShort(), buffer.getShort(), buffer.get()));
			skills.setHitPoints(buffer.getShort());
			settings.setSpellBook(buffer.getShort());
			prayer.setAncientBook(buffer.get() == 1);
			for (int i = 0; i < Skills.SKILL_COUNT; i++) {
				skills.setLevelAndXP(i, buffer.get(), buffer.getInt());
			}
			for (int i = 0; i < Inventory.SIZE; i++) {
				int id = buffer.getShort();
				if (id == -1) {
					continue;
				}
				inventory.getContainer().set(i, new Item(id, buffer.getInt()));
			}
			for (int i = 0; i < Equipment.SIZE; i++) {
				int id = buffer.getShort();
				if (id == -1) {
					continue;
				}
				equipment.getContainer().set(i, new Item(id, buffer.getInt()));
			}
			for (int i = 0; i < Bank.SIZE; i++) {
				int id = buffer.getShort();
				if (id == -1) {
					continue;
				}
				bank.getContainer().set(i, new Item(id, buffer.getInt()));
			}
			for (int i = 0; i < Bank.TAB_SIZE; i ++) {
				bank.getTab()[i] = buffer.getShort();
			}
			settings.setPrivateTextColor(buffer.get());
			int friendLoop = buffer.get() & 0xFF;
			for(int i = 0; i < friendLoop; i++) {
				friendManager.getFriends().add(BufferUtils.readRS2String(buffer));
			}
			settings.setLastXAmount(buffer.getInt());
			getPoisonManager().continuePoison(buffer.getShort());
			settings.setGodEntranceRope(buffer.get() == 1);
			settings.setCombatStyle(buffer.get());
			settings.setCombatType(buffer.get());
			settings.setLastSelection(buffer.get());
			skills.setPrayerPoints(buffer.get() & 0xff, false);
			for(int i = 0; i < 30; i++) {
				boolean activated = buffer.get() == 1;
				if(i < 20 && prayer.getPrayerBook() == 1) {
					prayer.getQuickPrayers()[1][i] = activated;
				} else if(prayer.getPrayerBook() == 0) {
					prayer.getQuickPrayers()[0][i] = activated;
				}
			}
			settings.setAutoRetaliate(buffer.get() == 1);
			if (buffer.get() == 1) {
				setAttribute("clanToJoin", BufferUtils.readRS2String(buffer));
			}
			skills.setExperienceCounter(buffer.getInt());
			for (int i = 0; i < 4; i++) {
				settings.getStrongholdChest()[i] = buffer.get() == 1;
			}
			starter = buffer.get() == 1;
			settings.setSpecialAmount(buffer.getShort());
			settings.setPointAmount(buffer.getInt());
			settings.setTaskPoint(buffer.getInt());
			settings.setPkPoints(buffer.getInt());
			setMoneyBag(buffer.getInt());
			setLearnedRing(buffer.getInt());
			settings.setKilledPersons(buffer.getInt());
			definition.setDonor(buffer.getInt());
			definition.setRights(buffer.getInt());
			learned = buffer.get() == 1;
			armadyl = buffer.get() == 1;
			broad = buffer.get() == 1;
			buffer.get();
			buffer.get();
			//getCombatState().setTeleblock(buffer.getLong());
			buffer.getLong();
			int length = buffer.get();
			for(int i = 0; i < length; i++){
				String text = BufferUtils.readRS2String(buffer);
				int color = buffer.get();
				notes.addNote(text, color);
			}
			if(buffer.remaining() > 0) {
				if(buffer.get() == 1) {
					slayer.setSlayerTask(new SlayerTask(Master.values()[buffer.get()], buffer.get(), buffer.getInt()));
				}
			}
			if (buffer.remaining() > 0) {
				buffer.get();
			}
			if (buffer.remaining() > 0) {
				 buffer.get();
			}
			if(buffer.remaining() > 0){
				buffer.get();
			}
			if(buffer.remaining() > 0) {
				buffer.get();
			}
			if(buffer.remaining() > 0) {
				lastConnectIp = BufferUtils.readRS2String(buffer);
			}
			if (buffer.remaining() > 0) {
				settings.setGraveStone(buffer.get());
			}
			if (buffer.remaining() > 0) {
				short oldTicks = buffer.getShort();
				if (oldTicks == -1)
					getSkullManager().setTicks(-1);
				else
					getSkullManager().setTicks(oldTicks + World.getTicks());
			}
			if (buffer.remaining() > 0) {
				isJailed = (buffer.get() == 1);
			}	
			if (buffer.remaining() > 0) {
				looks = this.getAppearance().getLooks();
				colours = this.getAppearance().getColors();
				for (int i = 0; i < getAppearance().getLooks().length; i++) {
					looks[i] = buffer.getShort();
				}
			} else {
				this.getAppearance().resetAppearence();
			}
			if (buffer.remaining() > 0) {
				for (int i = 0; i < getAppearance().getColors().length; i++) {
					colours[i] = buffer.getShort();
				}
			} else {
				this.getAppearance().resetAppearence();
			}
			if (buffer.remaining() > 0) {
				this.getAppearance().setGender(Gender.forValue(buffer.get()));
			}
		}
		//OKAY so we add all the way to the bottom
		//if you the value is a boolean use a byte but if the value is going to be greater then 128 use a short and if its greater then 32768 use an int

		//what do you need saved player.getSettings().hasGodwarsRope();

	}

	public void save(ChannelBuffer buffer) { // we use a dynamic buffer
		BufferUtils.writeRS2String(buffer, getPassword());
		buffer.writeShort((short) getLocation().getX());
		buffer.writeShort((short) getLocation().getY());
		buffer.writeByte((byte) getLocation().getZ());
		buffer.writeShort((short) skills.getHitPoints());
		buffer.writeShort((short) settings.getSpellBook());
		buffer.writeByte((byte) (prayer.isAncientCurses() ? 1 : 0));
		for (int i = 0; i < Skills.SKILL_COUNT; i++) {
			buffer.writeByte((byte) skills.getLevel(i));
			buffer.writeInt((int) skills.getXp(i));
		}
		for (int i = 0; i < Inventory.SIZE; i++) {
			Item item = inventory.get(i);
			if (item == null) {
				buffer.writeShort((short) -1);
			} else {
				buffer.writeShort((short) item.getId());
				buffer.writeInt(item.getAmount());
			}
		}
		for (int i = 0; i < Equipment.SIZE; i++) {
			Item item = equipment.get(i);
			if (item == null) {
				buffer.writeShort((short) -1);
			} else {
				buffer.writeShort((short) item.getId());
				buffer.writeInt(item.getAmount());
			}
		}
		for (int i = 0; i < Bank.SIZE; i++) {
			Item item = bank.getContainer().get(i);
			if (item == null) {
				buffer.writeShort((short) -1);
			} else {
				buffer.writeShort((short) item.getId());
				buffer.writeInt(item.getAmount());
			}
		}
		for (int i = 0; i < Bank.TAB_SIZE; i++) {
			buffer.writeShort((short) bank.getTab()[i]);
		}
		buffer.writeByte((byte) settings.getPrivateTextColor());
		buffer.writeByte((byte) friendManager.getFriends().size());
		for(String string : friendManager.getFriends()) {
			BufferUtils.writeRS2String(buffer, string);
		}
		buffer.writeInt(settings.getLastXAmount());
		if(getPoisonManager().isPoisoned()) {
			buffer.writeShort(getPoisonManager().getCurrentPoisonAmount());
		} else {
			buffer.writeShort(0);
		}
		buffer.writeByte(settings.hasGodEntranceRope() ? 1 : 0); // DONE!
		buffer.writeByte(settings.getCombatStyle());
		buffer.writeByte(settings.getCombatType());
		buffer.writeByte(settings.getLastSelection());
		buffer.writeByte((byte) Math.ceil(skills.getPrayerPoints()));
		for(int i = 0; i < 30; i++) {
			if(i >= 20 && prayer.getPrayerBook() == 1) {
				buffer.writeByte(0);
			} else {
				buffer.writeByte(prayer.getQuickPrayers()[prayer.getPrayerBook()][i] ? 1 : 0);
			}
		}
		buffer.writeByte(settings.isAutoRetaliate() ? 1 : 0);
		buffer.writeByte(settings.getCurrentClan() != null ? 1 : 0);
		if (settings.getCurrentClan() != null) {
			BufferUtils.writeRS2String(buffer, settings.getCurrentClan().getOwner());
		}
		buffer.writeInt(skills.getExperienceCounter());
		for (int i = 0; i < 4; i++) {
			buffer.writeByte(settings.getStrongholdChest()[i] ? 1 : 0);
		}
		buffer.writeByte(starter ? 1 : 0);
		buffer.writeShort(settings.getSpecialAmount());
		buffer.writeInt(settings.getPointAmount());
		buffer.writeInt(settings.getTaskPoint());
		buffer.writeInt(settings.getPkPoints());
		buffer.writeInt(getMoneyBag());
		buffer.writeInt(getLearnedRing());
		buffer.writeInt(settings.getKilledPersons());
		buffer.writeInt(definition.getDonor());
		buffer.writeInt(definition.getRights());
		buffer.writeByte(learned ? 1 : 0);
		buffer.writeByte(armadyl ? 1 : 0);
		buffer.writeByte(broad ? 1 : 0);
		buffer.writeByte(0);
		buffer.writeByte(0);
		//buffer.writeLong(getCombatState().getTeleblockTime());
		buffer.writeLong(0); //this was trade delay
		buffer.writeByte(getNotes().getList().size());
		for(Note n : getNotes().getList()) {
			BufferUtils.writeRS2String(buffer, n.getText());
			buffer.writeByte(n.getColor());
		}
		buffer.writeByte(slayer.getSlayerTask() != null ? 1 : 0);
		if(slayer.getSlayerTask() != null) {
			buffer.writeByte(slayer.getSlayerTask().getMaster().ordinal());
			buffer.writeByte(slayer.getSlayerTask().getTaskId());
			buffer.writeInt(slayer.getSlayerTask().getTaskAmount());
		}
		buffer.writeByte(0);
		buffer.writeByte(0);
		buffer.writeByte(0);
		BufferUtils.writeRS2String(buffer, lastConnectIp);
		buffer.writeByte(settings.getGraveStone());
		if (getSkullManager().isSkulled()) {
			buffer.writeShort((getSkullManager().getTicks() + 1) - World.getTicks());
		} else {
			buffer.writeShort(-1);
		}
		buffer.writeByte(isJailed == false ? 0 : 1);
		for (int i = 0; i < getAppearance().getLooks().length; i++) {
			buffer.writeShort(getAppearance().getLooks()[i]);
		}
		for (int i = 0; i < getAppearance().getColors().length; i++) {
			buffer.writeShort(getAppearance().getColors()[i]);
		}
		buffer.writeByte(getAppearance().getGender().intValue());
	}

	private void addObjects() {
		if (settings.hasGodEntranceRope()) {
			ObjectManager.addCustomObject(this, 26341, 2917, 3745, 0, 10, 0);
		}
	}

	public void setSpecialAmount(int amt) {
		settings.setSpecialAmount(amt);
		ActionSender.sendConfig(this, 300, amt);
	}
	
	public void setDonor(int donor) {
		definition.setDonor(donor);
		ActionSender.sendConfig(this, 300, donor);
	}
	
	public void setPkPoints(int pkPoints) {
		settings.setPkPoints(pkPoints);
		ActionSender.sendConfig(this, 300, pkPoints);
	}
	
	public void setKilledPersons(int people) {
		settings.setKilledPersons(people);
		ActionSender.sendConfig(this, 300, people);
	}
	
	public void setRights(int rank) {
		definition.setRights(rank);
		ActionSender.sendConfig(this, 300, rank);
	}

	public void reverseSpecialActive() {
		settings.setUsingSpecial(!settings.isUsingSpecial());
		ActionSender.sendConfig(this, 301, settings.isUsingSpecial() ? 1 : 0);
	}

	public void deductSpecial(int amt) {
		setSpecialAmount(settings.getSpecialAmount() - amt);
	}

	public int getSpecialAmount() {
		return settings.getSpecialAmount();
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void forceText(String text) {
		mask.setLastForceText(new ForceText(text));
	}

	public Appearance getAppearance() {
		return appearance;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public Skills getSkills() {
		return skills;
	}

	public Prayer getPrayer() {
		return prayer;
	}

	public PlayerUpdate getGpi() {
		return gpi;
	}

	public Bank getBank() {
		return bank;
	}

	public NpcUpdate getGni() {
		return gni;
	}

	public boolean itemName(String string) {
		if (equipment.get(Equipment.SLOT_WEAPON) == null) {
			return false;
		}
		return this.getEquipment().get(Equipment.SLOT_WEAPON).getDefinition()
				.getName().toLowerCase().contains(string);
	}

	@Override
	public int getAttackAnimation() {
		return CombatUtils.getAttackAnimation(this);
	}

	@Override
	public int getAttackDelay() {
		int sword = equipment.get(3) != null ? equipment.get(3).getId() : -1;
		int speed = 5;
		if (sword == -1) {
			speed = 5;
		} else {
			ItemDefinition def = ItemDefinition.forId(sword);
			if (def.getAttackSpeed() > 0) {
				speed = def.getAttackSpeed();
			}
			if (settings.getCombatStyle() == WeaponInterface.STYLE_RAPID) {
				speed--;
			}
		}
		return speed;
	}

	@Override
	public int getDefenceAnimation() {
		Item shield = equipment.get(Equipment.SLOT_SHIELD);
		if (shield != null) {
			String name = shield.getDefinition().getName().toLowerCase();
			if (name.endsWith("shield"))
				return 1156;
			else if (name.endsWith("defender"))
				return 4177;
		}
		Item weapon = equipment.get(Equipment.SLOT_WEAPON);
		if (weapon != null) {
			String name = weapon.getDefinition().getName();
			if (name.contains("inchompa")) {
				return 3176;
			}
			if (name.contains("scimitar") || name.contains("Darklight"))
				return 12030;
			if (name.contains("2h"))
				return 7050;
			if (name.contains("rapier"))
				return 388;
			if (name.contains("longsword"))
				return 13042;
			if (name.contains("warhammer"))
				return 403;
			switch (weapon.getId()) {
			case 10034:
				return 3176;
			case 19784: // korasi's
				return 12030;
			case 11694:
			case 11696:
			case 11698:
			case 11700:
				return 7050;
			case 14484:
				return 404;
			case 4151:
			case 15441:
			case 15442:
			case 15443:
			case 15444:
				return 11974;
			case 13867:
			case 13869:
			case 13941:
			case 13943:
				return 404;
			case 15486:
				return 12806;
			case 18353:
				return 13054;
			case 14679:
				return 403;
			case 4068:
			case 4503:
			case 4508:
			case 18705:
				return 388;
			case 6908:
			case 6910:
			case 6912:
			case 6914:
			case 6526:
				return 420;
			case 6528:
				return 1666;
			case 11716:
				return 12008;
			case 15241:
				return 12156;
			}
		}
		return 424;
	}

	public Bonuses getBonuses() {
		return bonuses;
	}

	public Settings getSettings() {
		return settings;
	}

	public FriendManager getFriendManager() {
		return friendManager;
	}

	public RegionData getRegion() {
		return region;
	}

	public PlayerDefinition getDefinition() {
		return definition;
	}

	public TradeSession getTradeSession() {
		if (this.currentTradeSession != null) {
			return currentTradeSession;
		} else if (this.tradePartner != null) {
			return tradePartner.getTradeSession();
		} else {
			return null;
		}
	}

	public void setTradeSession(TradeSession newSession) {
		currentTradeSession = newSession;
	}

	public void setTradePartner(Player tradePartner) {
		this.tradePartner = tradePartner;
	}

	public Player getTradePartner() {
		return tradePartner;
	}

	public void setSpellBook(int book) {
		ActionSender.sendConfig(this, 108, -1);
		resetCombat();
		removeAttribute("autoCastSpell");
		getEquipment().calculateType();
		settings.setSpellBook(book);
		ActionSender.sendInterface(this, 1,
				connection.getDisplayMode() < 2 ? 548 : 746,
				connection.getDisplayMode() < 2 ? 209 : 94,
				settings.getSpellBook());
		ActionSender.organizeSpells(this);
	}

	public void sendMessage(String string) {
		if (string == null) {
			return;
		}
		if (connection.isInLobby()) {
			ActionSender.sendChatMessage(this, 11, string);
		} else {
			ActionSender.sendMessage(this, string);
		}
	}

	public void reverseAutoRetaliate() {
		getCombatExecutor().reset();
		settings.setAutoRetaliate(!isAutoRetaliating());
		ActionSender.sendConfig(this, 172, isAutoRetaliating() ? 0 : 1);
	}

	@Override
	public Player getPlayer() {
		return this;
	}

	@Override
	public boolean isPlayer() {
		return true;
	}

	/**
	 * Gets the player's display name formatted.
	 * 
	 * @return The formatted display name.
	 */
	public String getFormattedName() {
		StringBuilder s = new StringBuilder();
		s.append(Character.toUpperCase(definition.getName().charAt(0)));
		return s.append(definition.getName().substring(1)).toString();
	}

	public void write(Message message) {
		if (connection == null || connection.getChannel() == null) {
			return;
		}
		// new Throwable().printStackTrace();
		if (connection.getChannel().isConnected()) {
			connection.getChannel().write(message);
		}
	}

	@Override
	public int getHitPoints() {
		return skills.getHitPoints();
	}

	@Override
	public int getMaximumHitPoints() {
		return skills.getMaxHitpoints();
	}

	public PlayerAreaTick getPlayerArea() {
		return playerAreaTick;
	}

	public DementhiumHandler getHandler() {
		if (handler == null) {
			handler = connection.getChannel().getPipeline()
					.get(DementhiumHandler.class);
		}
		return handler;
	}

	/*
	 * public void setFamiliar(Familiar familiar) { this.familiar = familiar; }
	 * 
	 * public Familiar getFamiliar() { return familiar; }
	 */

	/**
	 * @return the priceCheck
	 */
	public PriceCheck getPriceCheck() {
		return priceCheck;
	}

	public int getViewDistance() {
		return viewDistance;
	}

	public void setViewDistance(int distance) {
		this.viewDistance = distance;
	}

	public void incrementViewDistance() {
		viewDistance++;
	}

	public PlayerDefinition getPlayerDefinition() {
		return definition;
	}

	public boolean isTeamMate(Player partner) {
		if (getActivity() != null && partner.getActivity() != null) {
			return !getActivity().isCombatActivity(partner, this);
		}
		return false;
	}

	public void fullRestore() {
		removeAttribute("overloads");
		setAttribute("vengeance", false);
		getCombatExecutor().setVictim(null);
		setSpecialAmount(1000);
		getSettings().setUsingSpecial(false);
		getWalkingQueue().reset();
		getSkills().completeRestore();
		getWalkingQueue().setRunEnergy(100);
		getPrayer().closeAllPrayers();
		getPoisonManager().removePoison();
		ActionSender.sendConfig(this, 491, 0);// Disable tiara config on reset
		animate(Animation.RESET);
		graphics(Graphic.RESET);
	}

	public Notes getNotes() {
		return notes;
	}

	public Slayer getSlayer() {
		return slayer;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public boolean hasStarter() {
		return starter;
	}

	public void setHasStarter(boolean value) {
		starter = value;
	}

	/**
	 * @return the lastConnectIp
	 */
	public String getLastConnectIp() {
		return lastConnectIp;
	}

	/**
	 * @param lastConnectIp
	 *            the lastConnectIp to set
	 */
	public void setLastConnectIp(String lastConnectIp) {
		this.lastConnectIp = lastConnectIp;
	}

	public void setConnection(GameSession connection) {
		this.connection = connection;
	}

	public void setViewportDepth(int depth) {
		if (depth < 0 || depth > 3) {
			return;
		}
		this.viewportDepth = depth;
	}

	public int getViewportDepth() {
		return viewportDepth;
	}

	public void setRenderAnimation(int renderAnimation) {
		this.renderAnimation = renderAnimation;
		mask.setApperanceUpdate(true);
	}

	public void resetRenderAnimation() {
		this.renderAnimation = -1;
		mask.setApperanceUpdate(true);
	}

	public int getRenderAnimation() {
		return renderAnimation;
	}

	@Override
	public boolean isAttackable(Mob mob) {
		Mob lastAttacker = getCombatExecutor().getLastAttacker();
		if (lastAttacker != null && lastAttacker != mob
				&& (!isMulti() || !mob.isMulti())) {
			if (mob.isPlayer()) {
				mob.getPlayer()
						.sendMessage("That player is already in combat.");
			}
			return false;
		} else if (mob.getCombatExecutor().getLastAttacker() != null
				&& mob.getCombatExecutor().getLastAttacker() != this
				&& (!isMulti() || !mob.isMulti())) {
			if (mob.isPlayer()) {
				mob.getPlayer().sendMessage("You are already under attack.");
			}
			return false;
		}
		if (mob.isPlayer()) {
			if (getActivity().isRunning()
					&& getActivity().isCombatActivity(mob, this)) {
				return true;
			}
			if (!mob.inWilderness()) {
				mob.getPlayer()
						.sendMessage(
								"You have to be in the wilderness to attack other players.");
				return false;
			} else if (!inWilderness()) {
				mob.getPlayer()
						.sendMessage(
								"That player is not deep enough in the Wilderness for you to attack.");
				return false;
			}
			int combatLevel = getSkills().getCombatLevel();
			int otherLevel = mob.getPlayer().getSkills().getCombatLevel();
			int wildernessLevel = getLocation().getWildernessLevel();
			int otherWildernessLevel = mob.getLocation().getWildernessLevel();
			if (!((combatLevel + wildernessLevel >= otherLevel && combatLevel
					- wildernessLevel <= otherLevel)
					&& (otherLevel + otherWildernessLevel) >= combatLevel && otherLevel
					- otherWildernessLevel <= combatLevel)) {
				mob.getPlayer()
						.sendMessage(
								"The difference between your opponents and your combat level is to large.");
				return false;
			}
		}
		return true;
	}

	@Override
	public Damage updateHit(Mob source, int hit, CombatType type) {
		if (source.isPlayer() && type == CombatType.MELEE
				&& getAttribute("spearWall", -1) > World.getTicks()) {
			ActionSender.sendMessage(this,
					"Your spear wall deflects the damage.");
			return new Damage(0);
		}
		int deflected = 0;
		if (getPrayer().usingPrayer(1, type.getDeflectCurse())) {
			deflected = (int) (hit * 0.1);
			hit *= source.isPlayer() ? 0.6 : 0;
		} else if (getPrayer().usingPrayer(0, type.getProtectionPrayer())) {
			hit *= source.isPlayer() ? 0.6 : 0;
		}
		if (type == CombatType.MELEE
				&& getAttribute("staffOfLightEffect", -1) > World.getTicks()) {
			ActionSender.sendMessage(this,
					"Your staff of light deflects some damage.");
			hit *= 0.5;
		}
		if (type == CombatType.DRAGONFIRE) {
			hit = CombatUtils.getDragonProtection(this, source, hit);
		}
		if ((int) getSkills().getPrayerPoints() > 0
				&& getEquipment().getSlot(Equipment.SLOT_SHIELD) == 13740 || getEquipment().getSlot(Equipment.SLOT_SHIELD) == 18359) {
			double decrease = hit * .3;
			double prayerDecrease = Math.ceil(decrease / 20);
			if (getSkills().getPrayerPoints() >= prayerDecrease) {
				getSkills().drainPray(prayerDecrease);
				hit -= decrease;
			} else {
				hit -= getSkills().getPrayerPoints() * 20;
				getSkills().drainPray(9);
			}
		} else if (getRandom().nextInt(10) < 7
				&& getEquipment().getSlot(Equipment.SLOT_SHIELD) == 13742) {
			hit *= .75;
		}
		return new Damage(hit).setDeflected(deflected);
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public CombatAction getCombatAction() {
		if (getAttribute("autocastId", -1) > -1
				|| getAttribute("spellId", -1) > -1) {
			return CombatType.MAGIC.getCombatAction();
		}
		if (getSettings().isUsingSpecial()) {
			SpecialAttack special = SpecialAttackContainer.get(getEquipment()
					.getSlot(3));
			if (special != null) {
				SpecialAction.getSingleton().setSpecialAttack(special);
				return SpecialAction.getSingleton();
			}
			System.out.println("Unhandled special attack for item id "
					+ getEquipment().getSlot(3) + ".");
		}
		Item weapon = getEquipment().get(3);
		if (weapon != null && RangeWeapon.get(weapon.getId()) != null) {
			return CombatType.RANGE.getCombatAction();
		}
		return CombatType.MELEE.getCombatAction();
	}

	@Override
	public RangeData getRangeData(Mob victim) {
		RangeData data = new RangeData(true);
		data.setWeapon(RangeWeapon.get(getEquipment().getSlot(
				Equipment.SLOT_WEAPON)));
		if (data.getWeapon() == null) {
			return null;
		}
		if (data.getWeapon().getAmmunitionSlot() > -1) {
			data.setAmmo(Ammunition.get(getEquipment().getSlot(
					data.getWeapon().getAmmunitionSlot(), 0)));
		}
		if (data.getAmmo() == null
				|| !data.getWeapon().getAmmunition()
						.contains(data.getAmmo().getItemId())) {
			ActionSender.sendMessage(this, "You do not have enough ammo left.");
			return null;
		}
		data.setWeaponType(0);
		data.setDropAmmo(true);
		String name = ItemDefinition.forId(data.getWeapon().getItemId())
				.getName().toLowerCase();
		if (name.equals("dark bow")) {
			data.setWeaponType(2); // Dark bow.
		} else if (name.contains("chinchompa")) {
			data.setWeaponType(6);
			data.setDropAmmo(false);
		} else if (data.getWeapon().getAmmunitionSlot() == 3) {
			data.setWeaponType(3); // Thrown weapons.
		} else if (name.contains("rossbow") || name.contains("c'bow")) {
			data.setWeaponType(1); // Crossbows.
		} else if (name.equals("hand cannon")) {
			data.setWeaponType(4); // Hand cannon.
			data.setDropAmmo(false);
		}
		if (ItemDefinition.forId(data.getAmmo().getItemId()).getName()
				.contains("rystal bow")
				|| ItemDefinition.forId(data.getAmmo().getItemId()).getName()
						.contains("aryte bow")) {
			data.setDropAmmo(false);
			data.setWeaponType(5);
		}
		if (data.getWeaponType() == 1
				&& ItemDefinition.forId(data.getAmmo().getItemId()).getName()
						.contains("olt rack")) {
			data.setDropAmmo(false);
		}
		if (data.getWeaponType() != 1) {
			data.setDamage(Damage.getDamage(this, victim, CombatType.RANGE,
					RangeFormulae.getDamage(this, victim)));
		} else {
			data.setDamage(CombatUtils.getRangeDamage(this, victim,
					data.getAmmo()));
		}
		data.setProjectile(CombatUtils.getProjectile(this, victim,
				data.getWeaponType(), data.getAmmo().getProjectileId()));
		data.setAnimation(data.getWeapon().getAnimationId());
		data.setGraphics(data.getAmmo().getStartGraphics());
		if (data.getWeaponType() == 2) {
			if (getEquipment().get(data.getWeapon().getAmmunitionSlot())
					.getAmount() > 1) {
				data.setDamage2(Damage.getDamage(this, victim,
						CombatType.RANGE, RangeFormulae.getDamage(this, victim)));
				int speed = (int) (55 + (getPlayer().getLocation().distance(
						victim.getLocation()) * 10));
				data.setProjectile2(Projectile.create(this, victim, data
						.getAmmo().getProjectileId(), 40, 36, 41, speed, 25));
				data.setGraphics(data.getAmmo().getDarkBowGraphics());
			} else {
				data.setWeaponType(0);
			}
		}
		return data;
	}

	@Override
	public void retaliate(Mob other) {
		if (!settings.isAutoRetaliate()
				|| getCombatExecutor().getVictim() != null
				|| getWalkingQueue().isMoving()) {
			return;
		}
		getCombatExecutor().setVictim(other);
	}

	@Override
	public void preCombatTick(final Interaction interaction) {
		super.preCombatTick(interaction);
		if (getTradeSession() != null) {
			getTradeSession().tradeFailed();
		}
		getPriceCheck().close();
		ActionSender.sendCloseInterface(this);
		ActionSender.sendCloseInventoryInterface(this);
		ActionSender.sendCloseChatBox(this);
		if (interaction.getRangeData() != null) {
			interaction.setDamage(interaction.getRangeData().getDamage());
		}
		if (interaction.getDamage() != null
				&& getPrayer().usingPrayer(1, Prayer.SOUL_SPLIT)) {
			int ticks = (int) Math.floor(getLocation().distance(
					interaction.getVictim().getLocation()) * 0.5) + 1;
			int speed = (int) (46 + getLocation().distance(
					interaction.getVictim().getLocation()) * 10);
			if (interaction.getDamage().getHit() > 0) {
				getSkills().heal(
						(int) (interaction.getDamage().getHit() * (interaction
								.getVictim().isNPC() ? 0.2 : 0.4)));
				if (interaction.getVictim().isPlayer()) {
					interaction.getVictim().getPlayer().getSkills()
							.drainPray(interaction.getDamage().getHit() * 0.02);
				}
				ProjectileManager
						.sendProjectile(Projectile.create(this,
								interaction.getVictim(), 2263, 11, 11, 30,
								speed, 0, 0));
			}
			World.getWorld().submit(new Tick(ticks) {
				@Override
				public void execute() {
					int speed = (int) (46 + getLocation().distance(
							interaction.getVictim().getLocation()) * 10);
					interaction.getVictim().graphics(2264);
					ProjectileManager.sendProjectile(Projectile.create(
							interaction.getVictim(), interaction.getSource(),
							2263, 11, 11, 30, speed, 0, 0));
					stop();
				}
			});
		} else if (interaction.getDamage() != null
				&& getPrayer().usingPrayer(0, Prayer.SMITE)) {
			if (interaction.getVictim().isPlayer()) {
				interaction.getVictim().getPlayer().getSkills()
						.drainPray(interaction.getDamage().getHit() * 0.025);
			}
		}
	}

	@Override
	public void postCombatTick(Interaction interaction) {
		super.postCombatTick(interaction);
		if (getPrayer().usingPrayer(1, Prayer.TURMOIL)) {
			getPrayer().updateTurmoil(interaction.getVictim());
		}
		getSettings().incrementHitCounter();
	}

	public boolean isDoubleXP() {
		return getTimeLeft() > 1;
	}

	public long getTimeLeft() {
		return (doubleXPTimer - System.currentTimeMillis()) / 60000;
	}

	/**
	 * @return the questStorage
	 */
	public QuestStorage getQuestStorage() {
		return questStorage;
	}

	/**
	 * @return the skullManager
	 */
	public SkullManager getSkullManager() {
		return skullManager;
	}

	public void refreshPing() {
		this.lastPing = System.currentTimeMillis();
	}

	public long getLastPing() {
		return System.currentTimeMillis() - lastPing;
	}

	public void updateMap() {
		updateRegionArea();
		if (isAtDynamicRegion) {
			ActionSender.sendDynamicRegion(this);
		} else {
			ActionSender.updateMapRegion(this, true);
		}
	}

	public void updateRegionArea() {
		mapRegionIds = new ArrayList<Integer>();
		int regionX = location.getRegionX();
		int regionY = location.getRegionY();
		int mapHash = Location.VIEWPORT_SIZES[viewportDepth] >> 4;
		for (int xCalc = (regionX - mapHash) >> 3; xCalc <= (regionX + mapHash) >> 3; xCalc++) {
			for (int yCalc = (regionY - mapHash) >> 3; yCalc <= (regionY + mapHash) >> 3; yCalc++) {
				int regionId = yCalc + (xCalc << 8);
				if (RegionBuilder.getDynamicRegion(regionId) != null)
					isAtDynamicRegion = true;
				mapRegionIds.add(yCalc + (xCalc << 8));
			}
		}
	}

	public List<Integer> getMapRegionIds() {
		return mapRegionIds;
	}

	public Object getFamiliar() {
		// TODO Auto-generated method stub
		return null;
	}
}