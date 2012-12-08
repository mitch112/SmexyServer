package org.dementhium.content.cutscenes.impl;

import org.dementhium.content.DialogueManager;
import org.dementhium.content.cutscenes.Cutscene;
import org.dementhium.content.cutscenes.CutsceneAction;
import org.dementhium.content.cutscenes.actions.*;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.player.Player;

import java.util.ArrayList;

/**
 * @author 'Lumby <lumbyjr@hotmail.com>
 */
public class TutorialScene {

    private Cutscene scene;

    public TutorialScene(Player p) {
        scene = new Cutscene(p, constructActions(p));
    }

    /*
      * tips for making scenes, if you're going to have camera movement and dialogue at the same time,
      * ALWAYS do the camera first, because the next action will not advance until you click the continue button
      * on a dialogue action.
      */
    private CutsceneAction[] constructActions(final Player p) {
        ArrayList<CutsceneAction> actions = new ArrayList<CutsceneAction>();
        actions.add(new AnimationAction(p, 0, Animation.create(4367)));
        actions.add(new InterfaceAction(p, 0, 177));
        actions.add(new InterfaceAction(p, 0, -1));
		return actions.toArray(new CutsceneAction[0]);
    }

    public void start() {
        scene.start();
    }
}