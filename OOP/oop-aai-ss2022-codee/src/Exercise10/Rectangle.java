
public class Rectangle extends Shape {
    private int lengthX;
    private int lengthY;

    public Rectangle(int cornerX, int cornerY, int lengthX, int lengthY) {
        super(cornerX, cornerY);
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }

    public String toString() {
        return "Rectangle from (" + startX + ", " + startY + ") to (" + (startX + lengthX) + ", " + (startY + lengthY)
                + ") with width " + lengthX + " and height " + lengthY;
    }
}