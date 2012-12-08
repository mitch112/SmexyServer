package org.dementhium.content.cutscenes;

import org.dementhium.content.cutscenes.actions.DialogueAction;
import org.dementhium.content.cutscenes.actions.DialogueOptionAction;
import org.dementhium.content.cutscenes.actions.ShowTabsAction;
import org.dementhium.model.player.Player;
import org.dementhium.net.ActionSender;
import org.dementhium.tickable.Tick;

/**
 * @author Steve
 */
public class Cutscene {

    private final CutsceneAction[] actions;
    private final Player player;
    int currentActionId;
    int delay;

    public Cutscene(Player p, CutsceneAction[] actions) {
        this.player = p;
        this.actions = actions;
    }

    public void start() {
        ActionSender.sendCloseChatBox(player);
        ActionSender.closeInventoryInterface(player);
        ActionSender.sendCloseInterface(player);
        player.setAttribute("currentScene", this);
        player.getActionManager().stopAction();
        player.getCombatExecutor().reset();
        player.getMask().setFacePosition(null, 1, 1);
        if (player.getMask().getInteractingEntity() != null) {
            player.resetTurnTo();
        }
      player.setAttribute("cantMove", Boolean.TRUE);
        player.submitTick("cutscene", new Tick(1) {

            @Override
            public void execute() {
                if (currentActionId == actions.length) {
                    this.stop();
                }
                if (delay > 0) {
                    if ((!(actions[currentActionId] instanceof DialogueAction) || !((DialogueAction) actions[currentActionId]).isExecuted())) {
                        if ((!(actions[currentActionId] instanceof DialogueOptionAction) || !((DialogueOptionAction) actions[currentActionId]).isExecuted())) {
                        	if ((!(actions[currentActionId] instanceof ShowTabsAction) || !((ShowTabsAction) actions[currentActionId]).isExecuted())) {
                            delay--;
                        }
                        }
                    }
                } else if (currentActionId < actions.length) {
                    CutsceneAction action = actions[currentActionId];
                    player.setAttribute("cutsceneAction", action);
                    action.execute(null);
                    //System.out.println((actions[currentActionId] instanceof DialogueOptionAction));
                    if (!(actions[currentActionId] instanceof DialogueAction) && !(actions[currentActionId] instanceof DialogueOptionAction)) {
                        currentActionId++;
                    }
                    delay = action.getDelay();
                }

            }

            @Override
            public void stop() {
                super.stop();
                player.removeAttribute("cutsceneAction");
                ActionSender.resetCamera(player);
                player.removeAttribute("cantMove");
                if(!player.hasStarter()){
					player.setHasStarter(true);
					player.getInventory().addItem(995, 1000000);
					player.getInventory().addItem(841, 1);
					player.getInventory().addItem(882, 100);
					player.getInventory().addItem(1129, 1);
					player.getInventory().addItem(1095, 1);
					player.getInventory().addItem(579, 1);
					player.getInventory().addItem(577, 1);
					player.getInventory().addItem(1011, 1);
					player.getInventory().addItem(1381, 1);
					player.getInventory().addItem(558, 100);
					player.getInventory().addItem(1323, 1);
					player.getInventory().addItem(1153, 1);
					player.getInventory().addItem(1115, 1);
					player.getInventory().addItem(1067, 1);
					player.getInventory().addItem(1191, 1);
					player.getInventory().addItem(1712, 1);
					player.getInventory().addItem(386, 1000);
					player.getInventory().addItem(15273, 250);
                	player.getInventory().refresh();
                }
            }

        });
    }

    public CutsceneAction[] getActions() {
        return actions;
    }

    public Player getPlayer() {
        return player;
    }

    public void advanceToAction(int advanceAmount) {
        delay = 0;
        currentActionId += advanceAmount;
    }

    public void advanceAction() {
        delay = 0;
        currentActionId++;
    }

}
