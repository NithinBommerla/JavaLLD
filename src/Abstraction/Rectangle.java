package Abstraction;

public class Rectangle extends Shape {
    // write code here
    private int width;
    private int height;

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    public Rectangle(int positionX, int positionY, String fillColor, String borderColor, int width, int height) {
        super(positionX, positionY, fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }

    @Override
    public double calculatePerimeter() {
        return 2.0 * (this.width + this.height);
    }
}
