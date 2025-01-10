import java.awt.Color;

public class GameSetup 
{
    private int width = 60;
    private int height = 16;

    private int[] pos = new int[] {152, 500};

    private int xSize = 9;
    private int ySize = 4; 
    //private int walls = 3;

    //objects
    //private Block[][] nrOfTargets = new Block[xSize][ySize];
    private Block[] block = new Block[xSize*ySize];
    private Platform platform;
    private Ball ball;
    //private Block[] wall = new Block[3];


    

    public void drawStartGame()
    {
        /*
        StdDraw.setCanvasSize(800,600);
        StdDraw.setXscale(0,800);
        StdDraw.setYscale(0,600);
        */

        drawBlocks();
        //drawWalls();
        drawPlatform();
        drawBall();
    }


    private void drawBlocks()
    {
        int counter = 0;
        for(int i = 0; i < ySize; i++)
        {
            //System.out.println(j+i);
            for(int j = 0; j < xSize; j++)
            {
                System.out.println(j+i);
                block[counter] = new Block(width , height , pos[0] + j * 62 , pos[1] - i * 35, 
                new Color(120, 120, 120));
                counter++;
            }
        }
    }
    
    /*
    private void drawWalls()
    {  
        StdDraw.setPenColor(StdDraw.BLACK);
        block[xSize*ySize-1] = new Block(5, 200, 100, 350, new Color(0,0,0));
        block[xSize*ySize-1+1] = new Block(5, 200, 700, 350,new Color(0,0,0));
        block[xSize*ySize-1+2] = new Block(300, 5, 400, 545,new Color(0,0,0));


       
        for(int i = 0; i < wall.length; i++)
        {
            wall[i].drawWall();
        }
        

        //StdDraw.filledRectangle(90, 350, 5, 200);
        //StdDraw.filledRectangle(740, 350, 5, 200);
        //StdDraw.filledRectangle(410, 545, 325, 5);
    }
    */

    private void drawPlatform()
    {
        //x, y, w, h, speed
        //platform = new Platform(400, 150, 50, 5, 5);
        platform = new Platform(100, 10, 300, 100, new Color(120, 120, 120));
    }

    private void drawBall()
    {
        ball = new Ball(5, 300, 300, new Color(120, 120, 120), 0, -2);
    }

    public Block[] getBlocks()
    {
        return block;
    }
    /* 
    public Block[] getWalls()
    {
        return wall;
    }
    */
    public Platform getPlatform()
    {
        return platform;
    }

    public Ball getBall()
    {
        return ball;
    }
    


}
