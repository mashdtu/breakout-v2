// Purpose: This class is used to define the ball moving around the game colliding with other objects.

import java.awt.*;

public class Ball extends Object2D{
    private double minSpeed = 0.2;
    public Ball(int radius, int x, int y, Color color, double vx, double vy) {
        // Initialize a ball using the given parameters, inhereting from the Object2D class.
        super(radius, radius, x, y, color);
        this.vx = vx;
        this.vy = vy;
        this.setMass(1.3);
    }

    public void draw() {
        // Draw a white circle over the ball to erase it.
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(this.x, this.y, (double) this.getWidth());

        // Move the ball by adding the velocity to the x and y coordinates.
        this.x += this.vx;
        this.y += this.vy;

        
        if (this.x == 1) {
            this.vx = this.vx < 1 ? 1 : this.vx;
            this.x = -this.x + 1;
        }

        
        // Draw the ball at its new position.
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledCircle(this.x, this.y, (double) this.getWidth() - 1);
    }

    public boolean outOfBounds() {
        // Check if the ball is out of bounds.
        return this.y < 0;
    }

    public void bounceOffWalls() {
        // Bounce the ball off the walls by reversing the x or y velocity.
        if (this.x <= 0) {
            this.bounceX();
        }
        if (this.x >= Game.width) {
            this.bounceX();
            this.x = Game.width - 1;
        }
        if (this.y >= Game.height) {
            this.bounceY();
            this.y = Game.height - 1;
        }
    }

    public void bounceX() {
        // Bounce the ball in the x direction by reversing the x velocity.
        this.vx = -this.vx;
    }

    public void bounceY() {
        // Bounce the ball in the y direction by reversing the y velocity.
        this.vy = -this.vy;
    }

    public double getVx() {
        // Return the x velocity of the ball.
        return this.vx;
    }

    public double getVy() {
        // Return the y velocity of the ball.
        return this.vy;
    }

    public void setVx(double vx) {
        // Set the x velocity of the ball.
        this.vx = vx;
    }

    public void setVy(double vy) {
        // Set the y velocity of the ball.
        this.vy = vy;
    }

    public void setX(int x) {
        // Set the x coordinate of the ball.
        this.x = x;
    }

    public void setY(int y) {
        // Set the y coordinate of the ball.
        this.y = y;
    }
}
