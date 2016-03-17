import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<>();
       
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        Random aleatorio = new Random(30);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for (int index = 0 ; index <numeroBolas ; index++){
            BouncingBall ball = new BouncingBall(50, 50, aleatorio.nextInt(), Color.BLUE, ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }
        //BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        //ball2.draw();

        // make them bounce
        boolean finished =  false;
       
            
            while(!finished) {
                 for( int i=0 ; i < bolas.size() ; i++) {
                
                bolas.get(i).move();
                
                myCanvas.wait(50);           // small delay
                //ball.move();
                //ball2.move();
                // stop once ball has travelled a certain distance on x axis
                if(bolas.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
