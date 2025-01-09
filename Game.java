import java.awt.Color;

public class Game {
    private final int numberOfBlocks = 10;
    private final Block[] blocks;
    private final Platform platform;
    private final Ball ball;
    private boolean gameOver;
    public static final int width = 800;
    public static final int height = 600;

    public Game() {
        // Initialize the game by creating an array of blocks and defining the platform and ball.
        this.gameOver = false;
        this.blocks = new Block[numberOfBlocks];
        for (int i = 0; i < 5; i++) {
            this.blocks[i] = new Block(50, 20, 100 + i * 100, 500, new Color(120, 120, 120));
        }
        
        for (int i = 0; i < 5; i++) {
            this.blocks[5 + i] = new Block(50, 20, 100 + i * 100, 550, new Color(120, 120, 120));
        }

        this.platform = new Platform(100, 10, 300, 100, new Color(120, 120, 120));
        this.ball = new Ball(5, 300, 300, new Color(120, 120, 120), 0, -2);

        // Set canvas size and x and y scales.
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        
        // Draw all the blocks one time as they are static objects.
        for (Block block : this.blocks) {
            block.draw();
        }

        gameLoop();
    }

    private void gameLoop() {

        // Check if the user has pressed a or d and move the platform accordingly.
        if (StdDraw.isKeyPressed(65)) {
            this.platform.moveX(-2);
        }
        if (StdDraw.isKeyPressed(68)) {
            this.platform.moveX(2);
        }

        // Check for collisions with the ball and the walls and bounce the ball.
        this.ball.bounceOffWalls();
        
        // Check for collisions with the platform and blocks and move the ball.
        if (CollisionHandler.checkCollision(this.ball, this.platform)) {
            CollisionHandler.handleCollision(this.ball, this.platform);
            System.out.println("Ball collided with platform.");
        }

        for (Block block : this.blocks) {
            if (CollisionHandler.checkCollision(this.ball, block) && block.exists()) {
                CollisionHandler.handleCollision(this.ball, block);
                System.out.println("Ball collided with block.");
            }
        }
        
        // Draw the platform and ball.
        StdDraw.show(0);
        this.ball.draw();
        this.platform.draw();
        StdDraw.show(0);

        // Check if the ball is out of bounds and end the game if it is.
        if (this.ball.outOfBounds()) {
            this.gameOver = true;
        }

        // Check if all the blocks have been destroyed and end the game if they have.
        boolean allBlocksDestroyed = true;
        for (Block block : this.blocks) {
            if (block.exists()) {
                allBlocksDestroyed = false;
            }
        }
        if (allBlocksDestroyed) {
            this.gameOver = true;
        }

        // Call the game loop again after a short delay if the game is not over.
        try {
            Thread.sleep(12); 
        } catch(InterruptedException e) {
            // Do nothing.
        }
        
        if (!this.gameOver) {
            gameLoop();
        }
    }
}
