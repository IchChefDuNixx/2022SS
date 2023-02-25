
public class Triangle extends Shape {
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public Triangle(int cornerX, int cornerY, int x2, int y2, int x3, int y3) {
        super(cornerX, cornerY);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private double len(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public String toString() {
        return "Triangle at (" + startX + ", " + startY + "), (" + x2 + ", " + y2 + ") and (" + x3 + ", " + y3
                + ") with side lengts of " + len(startX, startY, x2, y2) + ", " + len(x2, y2, x3, y3) + " and "
                + len(startX, startY, x3, y3);
    }
}