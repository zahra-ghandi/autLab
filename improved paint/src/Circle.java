/**
 * A class to make circles and save their details.
 */
public class Circle extends Shape {
    // Radius
    private double radius;

    /**
     * Create a Circle.
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
     * Calculate the perimeter.
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        double perimeter = 2*radius*Math.PI;
        return perimeter;
    }

    /**
     * Calculate the area.
     * @return area
     */
    @Override
    public double calculateArea() {
        double area = radius*radius*Math.PI;
        return area;
    }

    /**
     * Draw.
     */
    @Override
    public void draw() {
        System.out.println("* Circle");
        super.draw();
    }

    /**
     * Turn the information into a String.
     * @return detail
     */
    @Override
    public String toString() {
        String detail = "Circle:: " + radius + "\n";
        return detail;
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
    @Override
    public int hashCode() {
        int result = 17;
        result = (int) (37*result + radius);
        return result;
    }
}
