/**
 * A class to save a circle's information.
 */
public class Circle {
    // The circle's radius.
    private double radius;

    /**
     * Create a Circle
     * @param radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Get the radius.
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculate the perimeter of the circle.
     * @return perimeter
     */
    public double calculatePerimeter() {
        double perimeter = 2*radius*Math.PI;
        return perimeter;
    }

    /**
     * Calculate the rectangle's area.
     * @return area
     */
    public double calculateArea() {
        double area = radius*radius*Math.PI;
        return area;
    }

    /**
     * Draw the shape.(Show the shape's details.)
     */
    public void draw() {
        System.out.println("* Circle");
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
        System.out.println();
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

        Circle circleToCheck = (Circle) object;
        if (radius == circleToCheck.getRadius()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generate hashCode.
     * @return a hashCode.
     */
    public int hashCode() {
        int result = 17;
        result = (int) (37*result + radius);
        return result;
    }

    /**
     * Turn the information into a String.
     * @return detail
     */
    @Override
    public String toString() {
        String detail = "Circle\n" + "Radius: " + radius + "\n";
        return detail;
    }
}
