import javax.swing.*;
import java.awt.*;

/**
 * Created by toomeyt0 on 3/11/2016.
 */
public class GameWindow extends JFrame implements Runnable{
    private static int DEFAULT_WIDTH = 500, DEFAULT_HEIGHT = 900, MAX_HEIGHT = 1600, MAX_WIDTH = 900;
    private static float WINDOW_SCALE = 1f; // Scale of window with respect to the 16 : 9 aspect ratio

    private GraphicsDriver graphicsDriver;
    private GameManager gameManager;

    public static int WIDTH = DEFAULT_WIDTH, HEIGHT = DEFAULT_HEIGHT;
    public boolean isRunning;
    private Player player;

    public GameWindow(){
        init(DEFAULT_HEIGHT);
    }

    // Size is height of window (Width applied relative to 16:9)
    private boolean init(int size){
        isRunning = false;
        if(size > 0 && size <= MAX_HEIGHT) {
            HEIGHT = (int)(size * WINDOW_SCALE);
            WIDTH = (int) ((9f / 16 * (float) HEIGHT));

            // Setup the window frame
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(WIDTH, HEIGHT);
            setResizable(false);
            setLocationRelativeTo(null); // Centering to screen
            setTitle(LetterFall.NAME);

            player = Player.GetInstance();

            gameManager = GameManager.GetInstance();
            graphicsDriver = new GraphicsDriver();

            add(graphicsDriver);
            setVisible(true);

            gameManager.run();
            return true;
        }
        return false;
    }
    public void updateGraphics(double delta){
        graphicsDriver.update(delta);
    }
    // Initialize the game window and
    public void run(){
        isRunning = true;
    }
    public void stop(){
        isRunning = false;
    }
    public boolean isRunning(){
        return isRunning;
    }

    public class GraphicsDriver extends JPanel{
        public GraphicsDriver(){
            setDoubleBuffered(true);
            setVisible(true);
        }

        public void paint(Graphics g2){
            Graphics2D g = (Graphics2D) g2;
            super.paintComponent(g);
            g.setColor(Color.black);
        }

        public void update(double deltaTime){
            repaint();
        }
    }

}
