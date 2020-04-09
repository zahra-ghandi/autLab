/**
 * A class to make triangles and save their details.
 */
public class Triangle extends Polygon {
    /**
     * Create a Triangle.
     * @param sides
     */
    public Triangle(double... sides) {
        super(sides);
    }

    /**
     * Check if the sides are the same side and therefor the triangle is equilateral.
     * @return true if the triangle is equilaterale and false if it's not.
     */
    public boolean isEquilateral() {
        double side1 = sides.get(0);
        double side2 = sides.get(1);
        double side3 = sides.get(2);
        if (side1 == side2 && side2 == side3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculate the perimeter of the triangle.
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        double perimeter = sides.get(0) + sides.get(1) + sides.get(2);
        return perimeter;
    }

    /**
     * Calculate the Triangle's area.
     * @return area
     */
    @Override
    public double calculateArea() {
        double side1 = sides.get(0);
        double side2 = sides.get(1);
        double side3 = sides.get(2);
        double semiPerimeter = (side1 + side2 + side3)/(double)2;
        double area = Math.sqrt(semiPerimeter*(semiPerimeter-side1)*(semiPerimeter-side2)*(semiPerimeter-side3));
        return area;
    }

    /**
     * Draw the shape.(Show the shape's details.)
     */
    @Override
    public void draw() {
        System.out.println("* Triangle");
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

        Triangle triangleToCheck = (Triangle) object;
        if (sides.get(0) == triangleToCheck.getSides().get(0) && sides.get(1) == triangleToCheck.getSides().get(1) && sides.get(2) == triangleToCheck.getSides().get(2)) {
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
        return result;
    }

    /**
     * Turn the information into a String.
     * @return detail
     */
    @Override
    public String toString() {
        String detail = "- Triangle:: " + super.toString() + "\n";
        return detail;
    }
}
