package com.shade.levels;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.shade.controls.DayPhaseTimer;
import com.shade.entities.Basket;
import com.shade.entities.MockPlayer;
import com.shade.entities.mushroom.MushroomFactory;
import com.shade.lighting.GlobalLight;
import com.shade.lighting.LuminousEntity;

public class Level0 extends Model {

    private static final int SECONDS_PER_DAY = 60000;
    private int timer;
    public DayPhaseTimer dayTimer;
    private GlobalLight light;

    public Level0(int w, int h, int c) throws SlickException {
        super(w, h, c);
        dayTimer = new DayPhaseTimer(SECONDS_PER_DAY);
        light = new GlobalLight(12, (float) (4 * Math.PI / 3),
                SECONDS_PER_DAY,dayTimer);

        add(new MockPlayer(450, 300));
        add(new Basket(400, 250, 65, 40));

        LevelSerial l = new LevelSerial();
        for (LuminousEntity e : l.deserialize("levels/level-0.xml")) {
            add(e);
        }
    }

    @Override
    public void update(StateBasedGame game, int delta) {
        super.update(game, delta);
        timer += delta;
    }

    @Override
    public GlobalLight getGlobalLight() {
        return light;
    }

    @Override
    public MushroomFactory getMushroomFactory() {
        return new MushroomFactory(16, .002);
    }

    @Override
    public boolean levelClear() {
        return timer > SECONDS_PER_DAY;
    }

}
