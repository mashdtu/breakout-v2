public class CollisionHandler {
    public static boolean checkCollision(Object2D obj1, Object2D obj2) {
        // Check if two objects are colliding by comparing their x and y coordinates.
        return obj1.x - obj1.getWidth() / 2 < obj2.x + obj2.getWidth() / 2 &&
               obj1.x + obj1.getWidth() / 2 > obj2.x - obj2.getWidth() / 2 &&
               obj1.y - obj1.getHeight() / 2 < obj2.y + obj2.getHeight() / 2 &&
               obj1.y + obj1.getHeight() / 2 > obj2.y - obj2.getHeight() / 2;
    }

    public static void handleCollision (Ball ball, Object2D obj) {
        // Handle the collision between the ball and obj.
        if (ball.x - ball.getWidth() / 2 < obj.x + obj.getWidth() / 2 &&
            ball.x + ball.getWidth() / 2 > obj.x - obj.getWidth() / 2 &&
            ball.y - ball.getHeight() / 2 < obj.y + obj.getHeight() / 2 &&
            ball.y + ball.getHeight() / 2 > obj.y - obj.getHeight() / 2) {
            // If the ball is colliding with the object, bounce the ball in the x or y direction.
            if (ball.x - ball.getWidth() < obj.x + obj.getWidth() / 2 &&
                ball.x + ball.getWidth() > obj.x - obj.getWidth() / 2) {
                ball.bounceY();
                if (obj instanceof Platform platform) {
                    ball.setVx(ball.getVx() + platform.getVelocity() * platform.getWeight() * 0.3);
                } else {
                    ((Block) obj).destroy();
                }
            } else {
                ball.bounceX();
            }
        }
    }
}
