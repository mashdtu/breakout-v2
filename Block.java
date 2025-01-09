// Purpose: This class is used to create a breakable/killable block in the game.

import java.awt.*;

public class Block extends Object2D {
    private boolean exists;
    // Whether the block exists or not (true by default).

    public Block (int width, int height, int x, int y, Color color) {
        // Initialize a platform using the given parameters, inhereting from the Block class.
        super(width, height, x, y, color);
        this.exists = true;
    }

    public void destroy () {
        // Kill the block by setting exists to false and drawing a white rectangle over it.
        this.exists = false;
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(this.x - 1, this.y - 1, (double) this.getWidth() / 2, (double) this.getHeight() / 2);
    }

    public void revive () {
        // Revive the block by setting exists to true and drawing a colored rectangle over it.
        this.exists = true;
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledRectangle(this.x - 1, this.y - 1, (double) this.getWidth() / 2 - 1, (double) this.getHeight() / 2 - 1);
    }

    public boolean exists () {
        // Return whether the block exists or not.
        return this.exists;
    }
}
