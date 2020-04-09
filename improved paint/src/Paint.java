import java.util.ArrayList;

/**
 * A class to paint with.
 */
public class Paint {
    // An ArrayList to save shapes.
    private ArrayList<Shape>  shapes;

    /**
     * Create a Paint.
     */
    public Paint() {
        shapes = new ArrayList<>();
    }

    /**
     * Add a shape.
     * @param shape
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Draw the shapes.
     */
    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    /**
     * Print all the shape's details.
     */
    public void printAll() {
        for (Shape shape : shapes) {
            System.out.print(shape.toString());
        }
    }

    /**
     * Print shapes with equal sides.
     */
    public void describeEqualSides() {
        for (Shape shape : shapes) {
            if (shape instanceof Triangle) {
                if (((Triangle) shape).isEquilateral()) {
                    System.out.print(shape);
                }
            } else if (shape instanceof Rectangle) {
                if (((Rectangle) shape).isSquare()) {
                    System.out.print(shape);
                }
            }
        }
    }
}
