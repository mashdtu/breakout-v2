// Purpose: Define the Object2D class, which represents any object within the game.

import java.awt.*;

public class Object2D {
    private int width, height;
    // Width and height of the object within the game space.

    public int x, y;
    // Position of the center point of the object.
    
    public double vx, vy;
    // Velocity of the object in the x and y directions.

    private Color color;
    // Color of the object.

    private double mass = 1;
    // Mass of the object.

    public Object2D(int width, int height, int x, int y, Color color) {
        // Initialize a block using the given parameters.
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw() {
        // Draw the object at its current position.
        StdDraw.setPenColor(this.color);
        StdDraw.filledRectangle(this.x + 1, this.y + 1, (double) this.width / 2 - 2, (double) this.height / 2 - 2);
    }

    public int getY() {
        // Return the y coordinate of the object.
        return 0;
    }

    public int getX() {
        // Return the x coordinate of the object.
        return 0;
    }

    public int getWidth() {
        // Return the width of the block.
        return width;
    }

    public int getHeight() {
        // Return the height of the block.
        return height;
    }

    public Color getColor() {
        // Return the color of the block.
        return color;
    }

    public double getMass() {
        // Return the mass of the block.
        return mass;
    }

    public void setMass(double mass) {
        // Set the mass of the block.
        this.mass = mass;
    }
}
