
public class Circle extends Shape {
    private int radius;

    public Circle(int centerX, int centerY, int radius) {
        super(centerX, centerY);
        this.radius = radius;
    }

    public String toString() {
        return "Circle around (" + startX + ", " + startY + ") with radius " + radius;
    }
}