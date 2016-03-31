import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);

    }
    /**
     * Cuando se invoque debe dibujar un rectángulo sin relleno en la pantalla y tantas bolas como se indiquen como parámetro
     * en la invocación del método dentro de dicho rectángulo.
     *Los objetos bola de esta actividad no serán del tipo BouncingBall: lo que debes hacer es crear una nueva clase denominada BoxBall 
     *(basándote en la clase BouncingBall, evidentemente). Las bolas de tipo BoxBall llevan siempre la misma velocidad (1 pixel cada vez),
     *dirección oblicua (no pueden moverse ni en horizontal ni en vertical) y no les afecta la gravedad. La posición inicial, el color y la
     *direccion de cada bola debe fijarse de manera aleatoria.
     *Finalmente, consigue que las bolas de tipo "BoxBall" reboten cambiando de dirección cuando golpeen las paredes del rectángulo
     */
    public void boxBounce(int numeroBolas)
    {
        myCanvas.setVisible(true);
        myCanvas.fillRectangle(20, 20, 500, 350);
        myCanvas.eraseRectangle(20, 20, 490, 340);

    }

    /**
     * Simulate two bouncing balls
     */

    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line
        bolas = new BouncingBall[numeroBolas];
        myCanvas.setVisible(true);
        Random aleatorio = new Random(30);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for (int index = 0 ; index <numeroBolas ; index++){
            
            int radio = aleatorio.nextInt(20) + 5;
            int red = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            
            Color color = new Color(red, blue, green);
            int posX = aleatorio.nextInt(300);
            
            BouncingBall ball = new BouncingBall(posX , 50,radio, color, ground, myCanvas);
            ball.draw();
            bolas[index] = ball;
        }
        //BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        //ball2.draw();

        // make them bounce
        boolean finished =  false;

        while(!finished) {
            myCanvas.wait(50); 
            for( int i=0 ; i < numeroBolas ; i++) {

                bolas[i].move();

                // stop once ball has travelled a certain distance on x axis
                if(bolas[i].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
