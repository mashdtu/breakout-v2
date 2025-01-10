// Purpose: This class is used to create a platform object that the player can move left and right.

import java.awt.*;

public class Platform extends Object2D {
    private double velocity;
    private final double weight = 1.5;
    private final double topSpeed = 20.0;

    public Platform (int width, int height, int x, int y, Color color) {
        // Initialize a platform using the given parameters, inhereting from the Block class.
        super(width, height, x, y, color);
        this.velocity = 0;
    }

    public void moveX (int dx) {
        // Increase the platform velocity by dx.
        if (this.velocity + dx <= this.topSpeed && this.velocity + dx >= -this.topSpeed) {
            this.velocity += dx;
        }
    }

    public void draw() {
        // Draw a white rectangle over the platform to erase it.
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(this.x - 1, this.y - 1, (double) this.getWidth() / 2 - 1, (double) this.getHeight() / 2 - 1);

        // Move the platform by adding the velocity to the x coordinate.
        this.x += this.velocity;
        this.velocity /= this.weight;
        if (Math.abs(this.velocity) < this.weight / 2) {
            this.velocity = 0;
        }
        
        // Draw the platform at its new position.
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledRectangle(this.x - 1, this.y - 1, (double) this.getWidth() / 2 - 1, (double) this.getHeight() / 2 - 1);
    }

    public boolean outOfBounds () {
        // Check if the platform is out of bounds.
        return this.x - this.getWidth() / 2 < 0 || this.x + this.getWidth() / 2 > Game.width;
    }

    public double getVelocity() {
        // Return the velocity of the platform.
        return this.velocity;
    }

    public double getWeight() {
        // Return the weight of the platform.
        return this.weight;
    }
}
