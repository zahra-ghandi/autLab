/**
 * A class for shape behaviour.
 */
public abstract class Shape {
    /**
     * Calculate the perimeter.
     * @return perimeter
     */
    public abstract double calculatePerimeter();

    /**
     * Calculate the are.
     * @return area
     */
    public abstract double calculateArea();

    /**
     * Draw the shape.
     */
    public void draw() {
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
        System.out.println();
    }

    @Override
    public abstract String toString();
}
