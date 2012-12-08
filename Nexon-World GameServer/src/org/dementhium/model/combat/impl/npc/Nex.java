package org.dementhium.model.combat.impl.npc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.dementhium.content.skills.Prayer;
import org.dementhium.model.Location;
import org.dementhium.model.Mob;
import org.dementhium.model.World;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.map.ObjectManager;
import org.dementhium.model.map.Region;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.player.Player;
import org.dementhium.net.ActionSender;
import org.dementhium.tickable.Tick;
import org.dementhium.tickable.impl.CountdownTick;
import org.dementhium.tickable.impl.NexVirusTick;
import org.dementhium.util.Misc;
import org.dementhium.util.misc.Sounds;

/**
 *
 * http://runescape.wikia.com/wiki/NEX	
 * Solo basic gameplay -> http://www.youtube.com/watch?v=BLqcYbuNLqg
 * Advanced team gameplay -> http://www.youtube.com/watch?v=K4wxNdm3NK8
 * Further solo gameplay -> http://www.youtube.com/watch?v=3-vxug6HOXU
 * 
 * @author 'Mystic Flow (Wrote the whole class)
 * @author MangiS (Id's)
 * @author cart (Information on attacks)
 * @author Steve (Camera movement)
 * @author Canownueasy (Converted it)
 * 
 * @note THIS IS A FUCKING MESS
 */
public class Nex extends NPC {

	private static final Random r = new Random();

	/*
	1215
	1216
	1217
	1218
	1219
	1271 - clouds ???
	1190
	1189
	2932
	2931
	471
	14 - grapple mithril 354+ interesting stopped at 700
	 */
	//2777+ dungeon emotes
	//wrath gfx 2261
	//2244 = gfx id for projectiles 
	//1214 might be attack
	//2767 - when nex grabs you
	//2870
	/************************************************
	 * The room beyond this point is a prison!
	 * There is no way out other than death or teleport
	 * Only those who can endure dangerous encounters should proceed.
	 * 
	 * There is currently one person (no one) fighting.
	 * Do you wish to join them?
	 * 
	 * Climb Down.
	 * Stay here.
	 * 
	 * -> If you try attack a minion (The avatar is not weak enough to damage this minion.)
	 * 
	 ***********************************************/

	//In red - Nex has marked you as a sacrifice, RUN!
	//You didn't make it far enough in time - Nex fires a punishing attack!


	public static int getLocalPlayersSize() {
		List<Player> localPlayers = Region.getLocalPlayers(Location.locate(2924, 5203, 0), 12);
		return localPlayers.size();
	}

	public static enum NexPhase {
		SPAWNED(null, null, -1, -1), // we can't attack at this stage
		SMOKE("Fill my soul with smoke!", "fumus", Sounds.NexFumus, Sounds.NexFillSmoke), // When we gain powers from Fumus
		SHADOW("Darken my shadow!", "umbra", Sounds.NexUmbra, Sounds.NexEmbraceDarkness), //When we gain powers from Umbra
		BLOOD("Flood my lungs with blood!", "cruor", Sounds.NexCrour, Sounds.NexFloodBlood),  //When we gain powers from Cruor
		ICE("Infuse me with the power of ice!", "glacies", Sounds.NexGlacies, Sounds.NexInfuseMeIce),    //When we gain powers from Glacies
		FINAL("NOW, THE POWER OF ZAROS!", null, -1, Sounds.NexPowerOfZaros);  //The last phase Nex has

		private String initialMessage, minionName;
		private int initialSoundId, soundId;

		private NexPhase(String initialMessage, String minionName, int initialSoundId, int soundId) {
			this.initialMessage = initialMessage;
			this.minionName = minionName;
			this.initialSoundId = initialSoundId;
			this.soundId = soundId;
		}
	}

	public static final int DEFAULT_NEX_ID = 13447, SOUL_SPLIT_NEX = 13448, MELEE_DEFLECT_NEX = 13449, WRATH_NEX = 13450;

	private static final int REAVER_ID = 13458;

	private static final Animation SPAWN_ANIMATION = Animation.create(6355);
	private static final Animation THROW_ANIMATION = Animation.create(6986);
	private static final Animation CAST_ANIMATION = Animation.create(6987);
	private static final Animation ATTACK_ANIMATION = Animation.create(6354);
	private static final Animation FLY_ANIMATION = Animation.create(6321);
	private static final Animation SIPHON_ANIMATION = Animation.create(6948);
	private static final Animation SMASH_ANIMATION = Animation.create(6984);
	private static final Animation TURMOIL_ANIMATION = Animation.create(6326);

	private static final Animation FALL_BACK_ANIMATION = Animation.create(10070);
	private static final Animation DRAG_ANIMATION = Animation.create(14388);

	private static final Graphic PURPLE_SMOKE_GRAPHIC = Graphic.create(1217);
	private static final Graphic FLYING_PURPLE_SMOKE = Graphic.create(1216);
	private static final Graphic CAST_GRAPHICS = Graphic.create(1214);
	private static final Graphic SMASH_SMOKE = Graphic.create(1215);
	private static final Graphic TURMOIL_GRAPHICS = Graphic.create(1204);

	private static final Graphic[] AFTERMATH_GRAPHICS =
		{
		null, Graphic.create(471), null, Graphic.create(376), Graphic.create(362), null
		};

	private static final Location[] NO_ESCAPE_TELEPORTS = 
		{
		Location.locate(2924, 5213, 0), //north, left side from area
		Location.locate(2934, 5202, 0), //east, upwards from area
		Location.locate(2924, 5192, 0), //south, right side from area
		Location.locate(2913, 5202, 0), //west
		};

	public static final int FUMUS = 13451, UMBRA = 13452, CRUOR = 13453, GLACIES = 13454;

	private NexPhase phase = NexPhase.SPAWNED;
	private NexCombatAction combatAction;
	private boolean changingPhase;
	private boolean noEscapeAttack;
	private long lastEscapeAttack;
	private long lastDragAttack;
	private long lastShadowAttack;
	private long lastPrayerSwitch;

	private boolean protectingMinion;
	private boolean protectingCruor;

	private boolean castedVirus;
	private boolean castedShadow;
	private boolean siphonMode;

	public Nex(int id) {
		super(id);
		combatAction = new NexCombatAction();
	}

	@Override
	public boolean isNex() {
		return true;
	}

	@Override
	public CombatAction getCombatAction() {
		return combatAction;
	}

	public boolean noEscapeAttack() {
		return noEscapeAttack;
	}

	@Override
	public boolean isAttackable() {
		return phase != NexPhase.SPAWNED && !noEscapeAttack;
	}

	public boolean isProtectingMinion() {
		return protectingMinion;
	}

	public boolean isProtectingCruor() {
		return protectingCruor;
	}

	public boolean isSiphonMode() {
		return siphonMode;
	}

	public NexPhase getPhase() {
		return phase;
	}

	public void playSound(int sound) {
		for(Player player : World.getWorld().getPlayers()) {
			if(player.getLocation().distance(getLocation()) < 18) {
				ActionSender.sendSound(player, sound, 100, 255, true);
			}
		}
	}

	/**
	 * @author 'Mystic Flow
	 */
	public static class NexAreaEvent extends Tick {

		private static final NexAreaEvent INSTANCE = new NexAreaEvent();
		private static final Location AREA_CENTER = Location.locate(2924, 5203, 0);

		public static NexAreaEvent getNexAreaEvent() {
			return INSTANCE;
		}

		private Nex nex;
		private int spawnDelay, minionSpawnDelay, minionSpawnStage;
		private boolean spawned;

		private NPC[] minions = new NPC[4];
		private Random random = new Random();

		private int delay;

		public NexAreaEvent() {
			super(2);
		}

		@Override
		public void execute() {
			if(nex == null) {
				if(delay > 0) {
					delay--;
					return;
				}
				boolean startSpawn = false;
				for(Player player : Region.getLocalPlayers(AREA_CENTER, 12)) {
					if(player.isOnline()) {
						if(World.getWorld().getAreaManager().getAreaByName("Nex").contains(player.getLocation())) {
							startSpawn = true;
							break;
						}
					}
				}
				if(startSpawn) {
					nex = new Nex(DEFAULT_NEX_ID);
					nex.setLocation(AREA_CENTER);
					nex.setOriginalLocation(AREA_CENTER);
					nex.setDoesWalk(false); // custom movements
					nex.loadEntityVariables();
					nex.setUnrespawnable(true);
					spawnDelay = 10; //20 ticks
				}
			} else {
				if(nex.isDead()) {
					nex = null;
					spawned = false;
					minionSpawnStage = 0;
					delay = 75;
					for(NPC minion : minions) {
						if(minion != null) {
							minion.sendDead();
						}
					}
					checkLife();
					return;
				}
				if(spawned) {
					checkLife();
					if(minionSpawnDelay > 0) {
						if(minionSpawnDelay % 4 == 0 && minionSpawnDelay != 20) {
							spawnMinion(NexPhase.values()[++minionSpawnStage]);
						}
						minionSpawnDelay--;
					} else {
						for(NPC minion : minions) {
							if(minion != null) {
								minion.turnTo(nex);
							}
						}
						checkLife();
						if(nex.phase == NexPhase.SPAWNED) {
							changePhase(NexPhase.SMOKE);
						}
						checkLife();
						switch(nex.phase) {
						case SMOKE:
							smokeAttack();
							break;
						case SHADOW:
							shadowAttack();
							break;
						case BLOOD:
							bloodAttack();
							break;
						case ICE:
							iceAttack();
							break;
						case FINAL:
							zarosAttack();
							break;
						}
						checkLife();
						if(!nex.changingPhase && !nex.noEscapeAttack && nex.phase != NexPhase.SPAWNED) {
							int closestDistance = -1;
							Mob closeMob = null;
							for(Player player : World.getWorld().getPlayers()) {
								if(nex.getLocation().distance(player.getLocation()) > 16) {
									continue;
								}
								int distance = Misc.getDistance(nex.getLocation().getX(), nex.getLocation().getY(), player.getLocation().getX(), player.getLocation().getY());
								if(closestDistance == -1 || closestDistance > distance) {
									closestDistance = distance;
									closeMob = player;
								}
							}
							if (closeMob != null) {
								nex.getCombatExecutor().setVictim(closeMob);
							}
						}

						if(nex.phase == NexPhase.SMOKE || nex.phase == NexPhase.FINAL) {
							if(!nex.changingPhase && !nex.noEscapeAttack) {
								if(random.nextInt(100) < (nex.phase == NexPhase.FINAL ? 5 : 30) && dragAttack()) {
									return;
								}
								//noEscapeAttack();
							}
						}
					}
					return;
				}
				if(spawnDelay > 0) {
					spawnDelay--;
				} else {
					spawned = true;
					nex.animate(SPAWN_ANIMATION);
					nex.graphics(PURPLE_SMOKE_GRAPHIC);
					nex.forceText("AT LAST!");
					nex.setAttribute("cantMove", Boolean.TRUE);
					nex.playSound(Sounds.NexAtLast);
					World.getWorld().getNpcs().add(nex);
					minionSpawnDelay = 20;
					setTime(1);
				}
			}
		}

		private void zarosAttack() {
			if(System.currentTimeMillis() - nex.lastPrayerSwitch > 10000 + Misc.random(10000)) {
				int switchId = DEFAULT_NEX_ID + Misc.random(2);
				while(switchId == nex.getId()) { // so we don't see the same phase
					switchId = DEFAULT_NEX_ID + Misc.random(2);
				}
				if(nex.lastPrayerSwitch == 0L) {
					switchId = SOUL_SPLIT_NEX;
				}
				nex.lastPrayerSwitch = System.currentTimeMillis();
				nex.getMask().setSwitchId(switchId);
			}
		}

		private void iceAttack() {
			boolean attacking = nex.hasTick("ice_attack");
			if(!attacking) {
				nex.getCombatExecutor().setTicks(4);
				if(random.nextInt(100) <= 45) {
					nex.forceText("Contain this!");
					nex.playSound(Sounds.NexContainThis);
					nex.animate(SMASH_ANIMATION);
					nex.graphics(SMASH_SMOKE);
					final Location currentLocation = nex.getLocation().transform(1, 1, 0);
					nex.submitTick("ice_attack", new Tick(3) {
						private boolean done;
						public void execute() {
							if(!done) {
								done = true;
								setTime(25);
								for(int x = -1; x <= 1; x++) {
									for(int y = -1; y <= 1; y++) {
										if(x == y) {
											continue;
										}
										final Location loc = currentLocation.transform(x, y, 0);
										if(loc != currentLocation && !loc.hasObjects()) {
											if(loc.containsPlayers()) {
												for(Player attack : loc.getPlayers()) {
													attack.getDamageManager().damage(nex, random.nextInt(350), 350, DamageType.RED_DAMAGE);
													attack.sendMessage("The icicle spike you to the spot!");
													if(attack.getPrayer().isAncientCurses()) {
														attack.getPrayer().closeOnPrayers(1, new int[] {Prayer.DEFLECT_MAGIC, Prayer.DEFLECT_MELEE, Prayer.DEFLECT_MISSILES, Prayer.DEFLECT_SUMMONING});
													} else {
														attack.getPrayer().closeOnPrayers(0, new int[] {Prayer.PROTECT_FROM_MAGIC, Prayer.PROTECT_FROM_MISSILES, Prayer.PROTECT_FROM_MELEE, Prayer.PROTECT_FROM_SUMMONING});
													}
													attack.getPrayer().recalculatePrayer();
													attack.getMask().setApperanceUpdate(true);
													attack.stun(5, "You've been injured and can't use " + (attack.getPrayer().isAncientCurses() ? "deflect curses" :  "protection prayers ") + "!", false);
													attack.submitTick("nex_drag", new CountdownTick(attack, 15, null)); // only way to prevent prayers :s
												}
											}
											ObjectManager.addCustomObject(57262, loc.getX(), loc.getY(), 0, 10, 0);
											if (nex != null && World.getWorld() != null) {
												World.getWorld().submit(new Tick(5) {
													@Override
													public void execute() {
														stop();
														if (nex != null && nex.getLocation() != null) {
															ObjectManager.clearArea(nex.getLocation(), 25);
														}
													}
												});
											}
										}
									}
								}
								return;
							}
							stop();
						}
					});
				} else {
					//You managed to destroy the icicle!
					nex.forceText("Die now, in a prison of ice!");
					nex.playSound(Sounds.NexDieNowInPrison);
					nex.submitTick("ice_attack", new Tick(2) {
						private boolean done;
						public void execute() {
							if(!done) {
								done = true;
								setTime(25);
								if (nex == null) {
									stop();//osama
									return;
								}
								if (nex.getLocation() == null) {
									stop();
									return;
								}

								List<Player> locPlayers = Region.getLocalPlayers(nex.getLocation(), 14);
								if (locPlayers == null) {
									stop();
									return;
								}
								if(locPlayers.size() > 0) {
									final Player player = locPlayers.get(random.nextInt(locPlayers.size()));
									if(player != null && !player.isDead()) {
										final Location currentLocation = player.getLocation();
										for(int x = -1; x <= 1; x++) {
											for(int y = -1; y <= 1; y++) {
												final Location loc = currentLocation.transform(x, y, 0);
												if(!loc.hasObjects()) {
													ObjectManager.addCustomObject(57263, loc.getX(), loc.getY(), 0, 10, 0);
													player.submitTick("ice_prison", new Tick(4) {

														private boolean remove = false;

														public void execute() {
															if(remove) {
																ObjectManager.removeCustomObject(loc.getX(), loc.getY(), 0, 10, true);
																stop();
															}
															setTime(1);
															remove = true;
															if(player.getLocation() == currentLocation) {
																player.sendMessage("The centre of the ice prison freezes you to the bone!");
																player.getDamageManager().damage(nex, random.nextInt(600), 600, DamageType.RED_DAMAGE);
															}
														}
													});
												}
											}
										}
									}
								}
							}
							stop();
						}
					});
				}
			}
		}

		private void bloodAttack() {
			if(!nex.hasTick("siphon")) {
				nex.forceText("A siphon will solve this!");
				nex.playSound(Sounds.NexSiphon);
				nex.siphonMode = true;
				nex.animate(SIPHON_ANIMATION);
				nex.setCanAnimate(false);
				final NPC bloodReaver = World.getWorld().register(Nex.REAVER_ID, nex.getLocation());
				bloodReaver.setUnrespawnable(true);
				nex.submitTick("siphon", new Tick(8) {
					private boolean done = false;
					public void execute() {
						if(done) {
							if(bloodReaver != null && !bloodReaver.isDead()) {
								nex.heal(bloodReaver.getHitPoints());
								bloodReaver.setHidden(true);
								bloodReaver.sendDead();
							}
							stop();
						} else {
							done = true;
							nex.siphonMode = false;
							nex.setCanAnimate(true);
							setTime(35);
						}
					}
				});
				return;
			} 
			if(!nex.siphonMode && !nex.hasTick("blood_sacrifice")) {
				nex.forceText("I demand a blood sacrifice!");
				nex.playSound(Sounds.NexBloodSacrifice);
				nex.submitTick("blood_sacrifice", new Tick(2) {
					private boolean done;
					public void execute() {
						if(!done) {
							done = true;
							List<Player> ps = Region.getLocalPlayers(nex.getLocation(), 3);
							if (ps.size() < 1) {
								return;
							}
							Player p;
							do {
								int idx = Misc.random(ps.size() - 1);
								if (idx >= ps.size()) {
									idx = (ps.size() - 1);
								}
								if (idx < 0) {
									idx = 0;
								}
								p = ps.get(idx);
								if (p == null) continue;
								if (p.isDead()) {
									p = null;//continue the loop
								}
							} while (p == null);
							final Player player = p;
							if(!player.isDead()) {
								player.sendMessage("Nex has marked you as a sacrifice, RUN!");
								final Location currentLocation = player.getLocation();
								World.getWorld().submit(new Tick(2) {
									@Override
									public void execute() {
										stop();
										if(player.getLocation() == currentLocation) {
											player.sendMessage("You didn't make it far enough in time - Nex fires a punishing attack!");
											for(final Player pl : World.getWorld().getPlayers()) {
												if(pl.getLocation().distance(player.getLocation()) < 18) {
													nex.animate(CAST_ANIMATION);
													ProjectileManager.sendDelayedProjectile(nex, pl, 374, false);
													World.getWorld().submit(new Tick(3) {
														@Override
														public void execute() {
															stop();

															int damage = random.nextInt(300);
															pl.getDamageManager().damage(nex, damage, 300, DamageType.MAGE);
															pl.getSkills().drainPray(pl.getSkills().getLevel(5) / 2);

															nex.graphics(377);
															nex.heal(Math.round(damage * 0.15F));
														}
													});
												}
											}
										}
									}
								});
							}
							setTime(10);
							return;
						}
						stop();
					}
				});
			}
		}

		private void smokeAttack() {
			if(nex.castedVirus) {
				boolean noVirus = true;
				for(Player player : World.getWorld().getPlayers()) { // prefer this over region
					if(player.getLocation().distance(AREA_CENTER) < 25) {
						if(player.hasTick("nex_virus")) {
							noVirus = false;
							break;
						}
					}
				}
				if(noVirus) {
					nex.castedVirus = false;
				}
			}
		}

		private void shadowAttack() {
			if(System.currentTimeMillis() - nex.lastShadowAttack >= 5400 && !nex.castedShadow) {
				final List<Player> localPlayers = new ArrayList<Player>();
				for(Player player : World.getWorld().getPlayers()) {
					if(player.getLocation().distance(nex.getLocation()) <= 10) {
						localPlayers.add(player);
					}	
				}
				if(localPlayers.size() == 0) {
					return;
				}
				nex.castedShadow = true;
				nex.lastShadowAttack = System.currentTimeMillis();
				final Location[] locationArray = new Location[localPlayers.size()];
				final boolean distanceAttack = random.nextInt(100) < 75;
				if(distanceAttack) {
					nex.forceText("Embrace darkness!");
					nex.playSound(Sounds.NexEmbraceDarkness);
				} else {
					nex.forceText("Fear the shadow!");
					nex.playSound(Sounds.NexFearTheShadow);
				}
				int index = 0;
				for(Player player : localPlayers) {
					locationArray[index++] = player.getLocation();
					for(Player local : localPlayers) {
						ActionSender.sendObject(local, 57261, player.getLocation().getX(), player.getLocation().getY(), 0, 10, 0);
					}
				}
				localPlayers.clear();
				World.getWorld().submit(new Tick(3) {
					@Override
					public void execute() {
						nex.castedShadow = false;
						stop();
						for(Player player : World.getWorld().getPlayers()) {
							if(player.getLocation().distance(nex.getLocation()) <= 10) {
								localPlayers.add(player);
							}	
						}
						for(Player player : localPlayers) {
							for(Location loc : locationArray) {
								ActionSender.deleteObject(player, 57261, loc.getX(), loc.getY(), 0, 10, 0);
								ActionSender.sendPositionedGraphic(player, loc, 383);
								if(player.getLocation() == loc) {
									int damageInflicted = 200 + Misc.random(distanceAttack ? player.getLocation().distance(nex.getLocation()) * 50 : 400);
									player.getDamageManager().damage(nex, damageInflicted, 1000, DamageType.MAGE);
								}
							}
						}
					}
				});
			}
		}

		public void spawnMinion(NexPhase phase) {
			NPC minion;
			switch(phase) {
			case SMOKE: 
				minion = new NPC(FUMUS, Location.locate(2912, 5216, 0));
				break;
			case SHADOW:
				minion = new NPC(UMBRA, Location.locate(2937, 5216, 0));
				break;
			case BLOOD:
				minion = new NPC(CRUOR, Location.locate(2937, 5190, 0));
				break;
			default:
				minion = new NPC(GLACIES, Location.locate(2912, 5190, 0));
			}
			nex.setAttribute("cantMove", Boolean.TRUE);
			nex.forceText(Misc.upperFirst(phase.minionName) + "!");
			nex.playSound(phase.initialSoundId);
			nex.animate(THROW_ANIMATION);
			nex.getMask().setFacePosition(minion.getLocation(), 1, 1);
			minion.turnTo(nex);
			nex.setAttribute("cantMove", Boolean.TRUE);
			minion.setAttribute("cantMove", Boolean.TRUE);
			World.getWorld().getNpcs().add(minion);
			ProjectileManager.sendGlobalProjectile(2244, minion, nex, 37, 60, 50);
			minions[phase.ordinal() - 1] = minion;
			nex.setDoesWalk(false);
			nex.submitTick("minionDelay", new Tick(22) {

				public void execute() {
					nex.setAttribute("canMove", Boolean.FALSE);
					System.out.println("Done!");
					stop();
				}
			});
		}


		private void checkLife() {
			/*			if(nex.protectingMinion) {
				int index = nex.phase.ordinal() - 1;
				if(minions[index] != null) {
					if(minions[index].isDead() || minions[index].destroyed()) {
						changePhase(NexPhase.values()[index + 2]);
						minions[index] = null;
					}
				}
				return;
			}*/
			if ( nex == null) {
				return;
			}
			int hitpoints = nex.getHitPoints();
			int maxHitpoints = nex.getMaximumHitPoints();
			//System.out.println("[NEX] HP: " + hitpoints + "   MAX HP: " + maxHitpoints);
			//System.out.println("Phase: " + nex.phase.name());
			if (!nex.changingPhase) {
				if(hitpoints <= (maxHitpoints * 0.2) && NexPhase.ICE.ordinal() > nex.phase.ordinal()) {
					changePhase(NexPhase.ICE);
					//System.out.println("ICE");
					nex.protectingMinion = true;
					nex.forceText("Glacies, don't fail me!");
					nex.playSound(Sounds.NexGlaciesDontFail);
				}
				else if(hitpoints <= (maxHitpoints * 0.4) && NexPhase.BLOOD.ordinal() > nex.phase.ordinal()) {
					changePhase(NexPhase.BLOOD);
					//System.out.println("BLOOD");
					nex.protectingCruor = true;
					nex.protectingMinion = true;
					nex.forceText("Cruor, don't fail me!");
					nex.playSound(Sounds.NexCrourDontFail);
				}
				else if(hitpoints <= (maxHitpoints * 0.6) && NexPhase.SHADOW.ordinal() > nex.phase.ordinal()) {
					changePhase(NexPhase.SHADOW);
					//System.out.println("SHADOW");
					nex.protectingMinion = true;
					nex.forceText("Umbra, don't fail me!");
					nex.playSound(Sounds.NexUmbraDontFail);
				}
				else if(hitpoints <= (maxHitpoints * 0.8) && NexPhase.SMOKE.ordinal() > nex.phase.ordinal()) {
					//System.out.println("SMOKE");
					nex.protectingMinion = true;
					nex.forceText("Fumus, don't fail me!");
					nex.playSound(Sounds.NexFumusDontFail);
				}
			}
		}

		public boolean isSpawned() {
			return nex != null;
		}

		public boolean ableToAttack() {
			return nex.phase != NexPhase.SPAWNED;
		}

		public void changePhase(final NexPhase phase) {
			int ticks = 5;
			if(nex.phase == NexPhase.SPAWNED) {
				ticks = 2;
			}
			if (nex.phase != phase && !nex.changingPhase) {
				nex.changingPhase = true;
				World.getWorld().submit(new Tick(ticks) {
					@Override
					public void execute() {
						stop();
						if(nex.phase != phase) {
							nex.changingPhase = true;
							nex.forceText(phase.initialMessage);
							nex.playSound(phase.soundId);
							if(phase != NexPhase.FINAL) {
								ProjectileManager.sendGlobalProjectile(2244, minions[phase.ordinal() - 1], nex, 46, 60, 50);
							} else {
								nex.heal(6000);
								nex.animate(TURMOIL_ANIMATION);
								nex.graphics(TURMOIL_GRAPHICS);
							}
							ObjectManager.clearArea(nex.getLocation(), 25);
							World.getWorld().submit(new Tick(3) {
								@Override
								public void execute() {
									stop();
									nex.changingPhase = false;
									nex.phase = phase;
									nex.protectingMinion = false;
								}
							});
						} else {
							nex.changingPhase = false;
						}
					}
				});
			}
		}

		private boolean dragAttack() {
			if(System.currentTimeMillis() - nex.lastDragAttack > 5000 && !nex.isAnimating() && nex.getCombatExecutor().getTicks() < 2) {
				nex.lastDragAttack = System.currentTimeMillis();
				List<Player> locPlayers = Region.getLocalPlayers(nex.getLocation(), 14);
				if(locPlayers.size() > 0) {
					int attempts = locPlayers.size();
					while(--attempts != -1) {
						if(drag(locPlayers.get(random.nextInt(locPlayers.size())))) {
							return true;
						}
					}
				}
			}
			return false;
		}

		@SuppressWarnings("unused")
		private void noEscapeAttack() {
			long currentTime = System.currentTimeMillis();
			if(currentTime - nex.lastEscapeAttack >= 8000 && random.nextInt(15) == 0) {
				nex.lastEscapeAttack = currentTime + 3600;
				nex.noEscapeAttack = true;
				nex.getCombatExecutor().setVictim(null);
				nex.getWalkingQueue().reset();
				nex.forceText("There is...");
				nex.playSound(Sounds.NexThereIs);
				nex.setLocation(AREA_CENTER);
				World.getWorld().submit(new Tick(2) {
					@Override
					public void execute() {
						stop();
						nex.animate(FLY_ANIMATION);
						nex.graphics(FLYING_PURPLE_SMOKE);

						World.getWorld().submit(new Tick(2) {
							@Override
							public void execute() {
								stop();
								final int index = random.nextInt(NO_ESCAPE_TELEPORTS.length);
								final Location noEscapePosition = NO_ESCAPE_TELEPORTS[index];

								nex.teleport(noEscapePosition);
								//squid, below was commented out?
								nex.forceMovement(null, noEscapePosition.getX(), noEscapePosition.getY(), 1, 2, -1, 2, true, false);
								nex.forceText("NO ESCAPE!");
								nex.playSound(Sounds.NexNoEscape);
								nex.getMask().setFacePosition(AREA_CENTER, 1, 1);
								World.getWorld().submit(new Tick(2) {

									private List<Player> playersToHit;

									private int countdown = 3;

									@Override
									public void execute() {
										countdown--;
										if(countdown == 2) {
											nex.forceMovement(null, 2924, 5203, 0, 60, -1, 2, true, true);
											for(Player attack : playersToHit = attackablePlayers(index)) {
												attack.getMask().setFacePosition(noEscapePosition, 1, 1);
												attack.setAttribute("cantMove", Boolean.TRUE);
												doCamera(attack, index);
											}
										} else if(countdown == 1) {
											for(Player attack : playersToHit) {
												int movementX = attack.getLocation().getX();
												int movementY = attack.getLocation().getY();

												switch(index) {
												case 0:
													movementY -= 2;
													break;
												case 1:
													movementX -= 2;
													break;
												case 2:
													movementY += 2;
													break;
												case 3:
													movementX += 2;
													break;
												}
												int dir = 0;
												if (attack.getLocation().getX() > noEscapePosition.getX())
													dir = 3;
												if (attack.getLocation().getX() < noEscapePosition.getX())
													dir = 1;
												if (attack.getLocation().getY() > noEscapePosition.getY())
													dir = 2;
												if (attack.getLocation().getY() < noEscapePosition.getY())
													dir = 0;


												int maxDamage = nex.phase == NexPhase.FINAL ? 550 : 400;
												int damage = r.nextInt(maxDamage);
												attack.removeAttribute("cantMove");
												attack.getDamageManager().damage(nex, damage, maxDamage, DamageType.RED_DAMAGE);
												attack.forceMovement(FALL_BACK_ANIMATION, movementX, movementY, 30, 60, dir, 1, true);
											}
										} else if(countdown == 0) {
											nex.noEscapeAttack = false;
											stop();
										}
									}

									private void doCamera(final Player attack, int dir) {
										/*										switch (dir) {
										case 3:
											rotateY -= 8;
											movementY += 9;
											break;
										case 2:
											rotateY -= 8;
											movementY += 9;
											break;
										case 1:
											rotateX += 8;
											movementX -= 9;
											break;
										case 0:
											rotateY += 8;
											movementY -= 9;
											break;
										}*/
										//World.getWorld().getGroundItemManager().sendGlobalGroundItem(World.getWorld().getGroundItemManager().create(attack, new Item(391, 1), Location.locate(rotateX, rotateY, 0)), false);
										World.getWorld().submit(new Tick(3) {
											int counter = 0;
											@Override
											public void execute() {
												int movementX = AREA_CENTER.getX();
												int movementY = AREA_CENTER.getY();
												int rotateX = AREA_CENTER.getX();
												int rotateY = AREA_CENTER.getY();
												if (counter == 0) {
													movementX = (movementX - (attack.getLocation().getRegionX() - 6) * 8);
													movementY = (movementY - (attack.getLocation().getRegionY() - 6) * 8);
													rotateX = (rotateX - (attack.getLocation().getRegionX() - 6) * 8);
													rotateY = (rotateY - (attack.getLocation().getRegionY() - 6) * 8);
													ActionSender.moveCamera(attack, 100, movementX, movementY, 3, 2);
													ActionSender.rotateCamera(attack, rotateX, rotateY, 100, 50);
													counter++;
												} else if (counter == 1) {
													ActionSender.resetCamera(attack);
													stop();
												}
											}

										});
										/*											}
										movementX = (movementX - (attack.getLocation().getRegionX() - 6) * 8);
										movementY = (movementY - (attack.getLocation().getRegionY() - 6) * 8);
										rotateX = (rotateX - (attack.getLocation().getRegionX() - 6) * 8);
										rotateY = (rotateY - (attack.getLocation().getRegionY() - 6) * 8);
										ActionSender.moveCamera(attack, 100, movementX, movementY, 3, 2);
										ActionSender.rotateCamera(attack, rotateX, rotateY, 100, 50);
										//ActionSender.moveCamera(attack, 100, movementX, movementY, 3, 2);
										//ActionSender.rotateCamera(attack, rotateX, rotateY, 100, 50);
										World.getWorld().submit(new Tick(3) {
											int counter = 0;
											@Override
											public void execute() {
												if (counter == 0) {
													Location loc = Location.locate(attack.getLocation().getX(), attack.getLocation().getY() - 4, 0);
													//ActionSender.moveCamera(attack, 5, loc.getLocalY(), loc.getLocalX(), 3, 5);
													//ActionSender.rotateCamera(attack, attack.getLocation().getLocalX(), attack.getLocation().getLocalY(), 7, 50);
													counter++;
												} else if (counter == 1) {
													//ActionSender.resetCamera(attack);
													stop();
												}
											}

										});*/
									}
								});
							}
						});
					}
				});
			}
		}

		private List<Player> attackablePlayers(int direction) {
			if(direction < 0 || direction > 3) {
				return null;
			}
			List<Player> players = new ArrayList<Player>();
			int startX = -1, endX = -1;
			int startY = -1, endY = -1;
			switch(direction) {
			case 0:
				startX = 2924;
				endX = 2926;
				startY = 5202;
				endY = 5211;
				break;
			case 1:
				startX = 2924;
				endX = 2933;
				startY = 5202;
				endY = 5204;
				break;
			case 2:
				startX = 2924;
				endX = 2926;
				startY = 5195;
				endY = 5204;
				break;
			case 3:
				startX = 2916;
				endX = 2923;
				startY = 5202;
				endY = 5204;
				break;
			}
			for(int x = startX; x <= endX; x++) {
				for(int y = startY; y <= endY; y++) {
					Location loc = Location.locate(x, y, 0);
					if(loc.containsPlayers()) {
						players.addAll(loc.getPlayers());
					}
				}
			}
			return players;
		}

		public boolean drag(final Player victim) {
			if(victim.hasTick("nex_drag") || victim.getHitPoints() < 100) {
				return false;
			}
			if(victim.getLocation().distance(AREA_CENTER) < 15) {
				return false;
			}
			nex.getCombatExecutor().setVictim(victim);

			victim.sendMessage("Nex draws you in...");
			victim.forceMovement(DRAG_ANIMATION, nex.getLocation().getX(), nex.getLocation().getY(), 0, 80, -1, 2, true);
			victim.submitTick("nex_drag", new Tick(3) {
				private int cycles = 0;
				@Override
				public void execute() {
					if(cycles == 15) {
						stop();
					}
					if(cycles == 0) {
						if(victim.getPrayer().isAncientCurses()) {
							victim.getPrayer().closeOnPrayers(1, new int[] {Prayer.DEFLECT_MAGIC, Prayer.DEFLECT_MELEE, Prayer.DEFLECT_MISSILES, Prayer.DEFLECT_SUMMONING});
						} else {
							victim.getPrayer().closeOnPrayers(0, new int[] {Prayer.PROTECT_FROM_MAGIC, Prayer.PROTECT_FROM_MISSILES, Prayer.PROTECT_FROM_MELEE, Prayer.PROTECT_FROM_SUMMONING});
						}
						victim.getPrayer().recalculatePrayer();
						victim.getMask().setApperanceUpdate(true);
						victim.stun(5, "You've been injured and can't use " + (victim.getPrayer().isAncientCurses() ? "deflect curses" :  "protection prayers ") + "!", false);
					}
					cycles++;
				}
			});
			return true;
		}

		public Nex getNex() {
			return nex;
		}

	}

	private final class NexCombatAction extends CombatAction {

		public NexCombatAction() {
			super(true);
		}

		@Override
		public boolean executeSession() {
			if(noEscapeAttack || changingPhase || siphonMode) {
				return false;
			}

			if(phase == NexPhase.SMOKE) {
				if(!castedVirus || (r.nextInt(100) < 10 && r.nextBoolean())) {
					castedVirus = true;
					castVirus(interaction.getVictim());
					return false;
				}
			}

			boolean close = interaction.getSource().getLocation().withinDistance(interaction.getVictim().getLocation(), size());
			boolean usingMagic = !close;

			@SuppressWarnings("unused")
			int cycles = 1;
			int damage = 0;
			int maxDamage = 0;

			if(!usingMagic && (r.nextInt(phase == NexPhase.FINAL ? 10 : 3) == 0 || phase == NexPhase.SHADOW)) {
				usingMagic = true;
			}
			if(getCombatExecutor().getTicks() != 0) {
				usingMagic = false;
			}

			if(usingMagic) {
				cycles = 3;
				getCombatExecutor().setTicks(5);
				animate(CAST_ANIMATION);
				turnTo(interaction.getVictim());
				int projectileId = -1;
				switch(phase) {
				case FINAL:
				case SMOKE:
					projectileId = 306;
					graphics(CAST_GRAPHICS);
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = (phase == NexPhase.FINAL ? 350 : 251));
					break;
				case SHADOW:
					projectileId = 380;
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = 301);
					break;
				case BLOOD:
					projectileId = 374;
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = 301);
					break;
				case ICE:
					projectileId = 362;
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = 301);
					break;
				}
				if(projectileId != -1) {
					ProjectileManager.sendDelayedProjectile(Nex.this, interaction.getVictim(), projectileId, false);
				}
				final int fMaxDamage = maxDamage, fProjectileId = projectileId;
				World.getWorld().submit(new Tick(3) {
					private int attacked;
					@Override
					public void execute() {
						stop();
						for(Player other : Region.getLocalPlayers(getLocation(), 13)) {
							if(attacked > 20) {
								break;
							}
							if(other == interaction.getVictim()) {
								continue;
							}
							int castedDamage = MagicFormulae.getDamage(Nex.this, other, fMaxDamage);
							ProjectileManager.sendDelayedProjectile(Nex.this, other, fProjectileId, false);
							other.getDamageManager().damage(Nex.this, castedDamage, fMaxDamage, phase == NexPhase.SHADOW ? DamageType.RANGE : DamageType.MAGE);
							attacked++;
							switch(phase) {
							case SMOKE:
								boolean poison = r.nextInt(100) <= 25;
								if(poison) {
									other.getPoisonManager().poison(Nex.this, 60 + r.nextInt(50));
									other.graphics(AFTERMATH_GRAPHICS[phase.ordinal()]);
								}
								break;
							case BLOOD:
								heal(Math.round(castedDamage * 0.10F));
								other.graphics(AFTERMATH_GRAPHICS[phase.ordinal()]);
								break;
							case ICE:
								if(other.getAttribute("freezeImmunity", -1) < World.getTicks() && castedDamage > 0) {
									/*other.getCombatExecutor().setFrozenTime(5000);*/
									other.getWalkingQueue().reset();
									other.submitTick("freeze_immunity", new CountdownTick(other, 10, null));
									other.graphics(AFTERMATH_GRAPHICS[phase.ordinal()]);
								}
								break;
							}
						}
					}
				});
			} else {
				if(close) {
					if(getCombatExecutor().getTicks() > 2) {
						return false;
					}
					animate(ATTACK_ANIMATION);
					getCombatExecutor().setTicks(4);
					damage = MeleeFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = (phase == NexPhase.FINAL ? 550 : 370));
				} else {
					return false;
				}
			}
			switch(phase) {
			case SMOKE:
				boolean poison = r.nextInt(100) <= 25;
				if(poison) {
					interaction.getVictim().getPoisonManager().poison(Nex.this, 60 + r.nextInt(50));
				}
				break;
			case BLOOD:
				heal(Math.round(damage * 0.15F));
				break;
			case ICE:
				if(!interaction.getVictim().hasTick("freeze_immunity") && interaction.getVictim().getAttribute("freezeImmunity", -1) < World.getTicks() && damage > 0) {
					interaction.getVictim().getWalkingQueue().reset();
					interaction.getVictim().submitTick("freeze_immunity", new CountdownTick(interaction.getVictim().getPlayer(), 20, null));
				}
				break;
			}

			//CombatType type = usingMagic ? phase == NexPhase.SHADOW ? CombatType.RANGE : CombatType.MAGIC : CombatType.MELEE;
			interaction.setDamage(new Damage(damage));
			return false;
		}

		public void castVirus(Mob victim) {
			animate(CAST_ANIMATION);
			getCombatExecutor().setTicks(3);
			forceText("Let the virus flow through you!");
			playSound(Sounds.NexVirus);
			if(interaction.getVictim().hasTick("nex_virus")) {
				interaction.getVictim().removeTick("nex_virus");
			}
			interaction.getVictim().submitTick("nex_virus", new NexVirusTick(interaction.getVictim().getPlayer()));
		}

		/*		@Override
		public boolean canAttack(Mob mob, Mob victim) {
			if(noEscapeAttack || changingPhase || siphonMode) {
				return false;
			}
			if(mob.getLocation().distance(interaction.getVictim().getLocation()) > interaction.getVictim().size() && r.nextBoolean() && r.nextBoolean()) {
				Following.combatFollow(mob, victim);
				return false;
			}
			return true;
		}*/

		@Override
		public boolean commenceSession() {
			if(noEscapeAttack || changingPhase || siphonMode) {
				return false;
			}

			if(phase == NexPhase.SMOKE) {
				if(!castedVirus || (r.nextInt(100) < 10 && r.nextBoolean())) {
					castedVirus = true;
					castVirus(interaction.getVictim());
					return false;
				}
			}

			boolean close = interaction.getSource().getLocation().withinDistance(interaction.getVictim().getLocation(), size());
			boolean usingMagic = !close;

			@SuppressWarnings("unused")
			int cycles = 1;
			int damage = 0;
			int maxDamage = 0;

			if(!usingMagic && (r.nextInt(phase == NexPhase.FINAL ? 10 : 3) == 0 || phase == NexPhase.SHADOW)) {
				usingMagic = true;
			}
			if(getCombatExecutor().getTicks() != 0) {
				usingMagic = false;
			}

			if(usingMagic) {
				cycles = 3;
				getCombatExecutor().setTicks(5);
				animate(CAST_ANIMATION);
				turnTo(interaction.getVictim());
				int projectileId = -1;
				switch(phase) {
				case FINAL:
				case SMOKE:
					projectileId = 306;
					graphics(CAST_GRAPHICS);
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = (phase == NexPhase.FINAL ? 350 : 251));
					break;
				case SHADOW:
					projectileId = 380;
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = 301);
					break;
				case BLOOD:
					projectileId = 374;
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = 301);
					break;
				case ICE:
					projectileId = 362;
					damage = MagicFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = 301);
					break;
				}
				if(projectileId != -1) {
					ProjectileManager.sendDelayedProjectile(Nex.this, interaction.getVictim(), projectileId, false);
				}
				final int fMaxDamage = maxDamage, fProjectileId = projectileId;
				World.getWorld().submit(new Tick(3) {
					private int attacked;
					@Override
					public void execute() {
						stop();
						for(Player other : Region.getLocalPlayers(getLocation(), 13)) {
							if(attacked > 20) {
								break;
							}
							if(other == interaction.getVictim()) {
								continue;
							}
							int castedDamage = MagicFormulae.getDamage(Nex.this, other, fMaxDamage);
							ProjectileManager.sendDelayedProjectile(Nex.this, other, fProjectileId, false);
							other.getDamageManager().damage(Nex.this, castedDamage, fMaxDamage, phase == NexPhase.SHADOW ? DamageType.RANGE : DamageType.MAGE);
							attacked++;
							switch(phase) {
							case SMOKE:
								boolean poison = r.nextInt(100) <= 25;
								if(poison) {
									other.getPoisonManager().poison(Nex.this, 60 + r.nextInt(50));
									other.graphics(AFTERMATH_GRAPHICS[phase.ordinal()]);
								}
								break;
							case BLOOD:
								heal(Math.round(castedDamage * 0.10F));
								other.graphics(AFTERMATH_GRAPHICS[phase.ordinal()]);
								break;
							case ICE:
								if(other.getAttribute("freezeImmunity", -1) < World.getTicks() && castedDamage > 0) {
									/*other.getCombatExecutor().setFrozenTime(5000);*/
									other.getWalkingQueue().reset();
									other.submitTick("freeze_immunity", new CountdownTick(other, 10, null));
									other.graphics(AFTERMATH_GRAPHICS[phase.ordinal()]);
								}
								break;
							}
						}
					}
				});
			} else {
				if(close) {
					if(getCombatExecutor().getTicks() > 2) {
						return false;
					}
					animate(ATTACK_ANIMATION);
					getCombatExecutor().setTicks(4);
					damage = MeleeFormulae.getDamage(Nex.this, interaction.getVictim(), maxDamage = (phase == NexPhase.FINAL ? 550 : 370));
				} else {
					return false;
				}
			}
			switch(phase) {
			case SMOKE:
				boolean poison = r.nextInt(100) <= 25;
				if(poison) {
					interaction.getVictim().getPoisonManager().poison(Nex.this, 60 + r.nextInt(50));
				}
				break;
			case BLOOD:
				heal(Math.round(damage * 0.15F));
				break;
			case ICE:
				if(!interaction.getVictim().hasTick("freeze_immunity") && interaction.getVictim().getAttribute("freezeImmunity", -1) < World.getTicks() && damage > 0) {
					interaction.getVictim().getWalkingQueue().reset();
					interaction.getVictim().submitTick("freeze_immunity", new CountdownTick(interaction.getVictim().getPlayer(), 20, null));
				}
				break;
			}

			//CombatType type = usingMagic ? phase == NexPhase.SHADOW ? CombatType.RANGE : CombatType.MAGIC : CombatType.MELEE;
			interaction.setDamage(new Damage(damage));
			return false;
		}

		@Override
		public boolean endSession() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public CombatType getCombatType() {
			return CombatType.MELEE;
		}

	}

}