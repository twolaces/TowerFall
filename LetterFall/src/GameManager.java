import javax.swing.*;

/**
 * Created by toomeyt0 on 3/11/2016.
 *
 * This class handles all of the game logic including the games
 * internal loop. Code to sync with painting goes in the gameUpdate() method.
 * This class is used as a singleton and only has one instance
 */
public class GameManager implements Runnable {
    private static volatile GameManager gameManager;

    private int FPS = 0, UPS = 0;
    private int CounterM = 0, CounterS = 0;
    private boolean isRunning;

    private Player player;

    private GameManager(){
        isRunning = false;
        player = Player.GetInstance();
    }

    public static GameManager GetInstance(){
        if(null == gameManager){
            synchronized (GameManager.class){
                if(null == gameManager){
                    gameManager = new GameManager();
                }
            }
        }
        return gameManager;
    }

    public void run() {
        isRunning = true;
        gameLoop();
    }
    public void stop() {
        isRunning = false;
    }

    private void gameUpdate(double delta)
    {
        player.move(1,0);
        if(CounterM++ > 1000) {
            CounterM = 0;
            CounterS++;
        }

    }

    public void gameLoop()
    {
        long lastLoopTime = System.nanoTime();
        long lastFpsTime = 0, fps = 0;
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        // keep looping round til the game ends
        while (isRunning())
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: "+fps+")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            gameUpdate(delta);

            // draw everyting

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try{
                Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
            }catch(InterruptedException e){}
        }
    }
    // Getters & Setters
    public boolean isRunning(){
        return true;
    }
    // Static Methods
    static void Message(String s){
        if(s.length() <= 0) return;
        System.out.println(LetterFall.NAME + ": " + s);
    }
}


