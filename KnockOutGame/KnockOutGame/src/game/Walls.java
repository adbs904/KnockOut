/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.*;

//this class creates a new static body that can be used to make new blastzones

/**
 * A Static body class for creating blastzones
 */
public class Walls extends StaticBody {

    public Walls(World w, Shape s) {
        super(w, s);
    }
}
