/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.*;

/**
 * Creates the Bumper body
 */
public class Bumper extends StaticBody {
    private static final Shape bumperShape = new PolygonShape(1.24f,2.45f, 2.85f,0.03f, 1.25f,-2.43f, -1.22f,-2.44f, -2.91f,-0.03f, -1.28f,2.45f);

    private static final BodyImage image =
            new BodyImage("data/bumper.png",5f);


    public Bumper(World world) {
        super(world, bumperShape);
        addImage(image);
    }
}