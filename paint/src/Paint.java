import java.util.ArrayList;

/**
 * A class to paint with.
 */
public class Paint {
    // ArrayLists to save shapes.
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * Create a Paint.
     */
    public Paint() {
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * Add a circle.
     * @param circle
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * Add a triangle.
     * @param triangle
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Add a rectangle.
     * @param rectangle
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Draw the shapes.
     */
    public void drawAll() {
        for (Circle circle : circles) {
            circle.draw();
        }
        for (Triangle triangle : triangles) {
            triangle.draw();
        }
        for (Rectangle rectangle : rectangles) {
            rectangle.draw();
        }
    }

    /**
     * Print all the shape's details.
     */
    public void printAll() {
        for (Circle circle : circles) {
            System.out.println(circle.toString());
        }
        for (Triangle triangle : triangles) {
            System.out.println(triangle.toString());
        }
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.toString());
        }
    }
}
