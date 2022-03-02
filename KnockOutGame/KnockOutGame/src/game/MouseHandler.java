package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Checks the mouse's position
 */
public class MouseHandler extends MouseAdapter {

    private WorldView view;

    public MouseHandler(WorldView view) {
        this.view = view;
    }

}
