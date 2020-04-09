/**
 * A class to make rectangles and save their details.
 */
public class Rectangle extends Polygon {
    /**
     * Create a Rectangle.
     * @param sides
     */
    public Rectangle(double... sides) {
        super(sides);
    }

    /**
     * Check if the sides are the same side and therefor the rectangle is a square.
     * @return true if the rectangle is a square and false if it's not.
     */
    public boolean isSquare() {
        double side1 = sides.get(0);
        double side2 = sides.get(1);
        double side3 = sides.get(2);
        double side4 = sides.get(3);
        if (side1 == side2 && side2 == side3 && side3 == side4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculate the perimeter of the rectangle.
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        double perimeter = sides.get(0) + sides.get(1) + sides.get(2) + sides.get(3);
        return perimeter;
    }

    /**
     * Calculate the rectangle's area.
     * @return area
     */
    @Override
    public double calculateArea() {
        double side1 = sides.get(0);
        double side2 = sides.get(1);
        double area = side1 * side2;
        return area;
    }

    /**
     * Draw the shape.(Show the shape's details.)
     */
    @Override
    public void draw() {
        System.out.println("* Rectangle");
        super.draw();
    }

    /**
     * Check if the two objects are equal.
     * @param object
     * @return true if the objects are equal and false if they're not.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || object.getClass() != this.getClass())
            return false;

        Rectangle rectangleToCheck = (Rectangle) object;
        if (sides.get(0) == rectangleToCheck.getSides().get(0) && sides.get(1) == rectangleToCheck.getSides().get(1) &&
                sides.get(2) == rectangleToCheck.getSides().get(2) && sides.get(3) == rectangleToCheck.getSides().get(3)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generate hashCode.
     * @return a hashCode.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + sides.get(0).hashCode();
        result = 37*result + sides.get(1).hashCode();
        result = 37*result + sides.get(2).hashCode();
        result = 37*result + sides.get(3).hashCode();
        return result;
    }

    /**
     * Turn the information into a String.
     * @return detail
     */
    @Override
    public String toString() {
        String detail = "- Rectangle:: " + super.toString() + "\n";
        return detail;
    }
}
