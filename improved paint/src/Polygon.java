import java.util.ArrayList;

/**
 * A class to save polygons' details.
 */
public abstract class Polygon extends Shape {
    // An ArrayList to save sides' size.
    protected ArrayList<Double> sides;

    /**
     * Create a Polygon.
     */
    public Polygon(double... sides) {
        this.sides = new ArrayList<Double>();
        for (double side : sides) {
            this.sides.add(side);
        }
    }

    /**
     * Get the sides's size.
     * @return sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * Turn the information into a String.
     * @return detail
     */
    @Override
    public String toString() {
        String string = null;
        int i = 0;
        for (double side : sides) {
            string += "Side" + ++i + ":" + side + ",   ";
        }
        return string;
    }
}
