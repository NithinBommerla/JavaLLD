package Abstraction;

public class Circle extends Shape {
    // write code here
    private int radius;
    public static final double Pi = 3.14;

    public int getRadius() {
        return this.radius;
    }

    public Circle(int positionX, int positionY, String fillColor, String borderColor, int radius) {
        super(positionX, positionY, fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Pi * this.radius * this.radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2.0 * Pi * this.radius;
    }
}
