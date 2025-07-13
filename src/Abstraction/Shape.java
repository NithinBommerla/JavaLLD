package Abstraction;

abstract class Shape  {
    // write code here
    private int positionX;
    private int positionY;
    private String fillColor;
    private String borderColor;

    public Shape(int positionX, int positionY, String fillColor, String borderColor) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public String getfillColor() {
        return this.fillColor;
    }

    public String getborderColor() {
        return this.borderColor;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

}
