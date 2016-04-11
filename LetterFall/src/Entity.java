import java.awt.*;

/**
 * Created by toomeyt0 on 3/11/2016.
 */
public class Entity {
    public static final int DEFAULT_X = 0, DEFAULT_Y = 0;
    public static final boolean DEFAULT_ACTIVE = false;

    private double x, y;
    private boolean active;

    public Entity(){
        x = DEFAULT_X;
        y = DEFAULT_Y;
        active = DEFAULT_ACTIVE;
    }

    public Entity(int x, int y){
        if(!validPoint(x,y)) return;
        this.x = x;
        this.y = y;
        active = DEFAULT_ACTIVE;
    }

    public Entity(Point p){
        if(!validPoint((int)p.getX(),(int)p.getY()));
        x = p.getX();
        y = p.getY();
        active = DEFAULT_ACTIVE;
    }

    public Entity(boolean active){
        x = DEFAULT_X;
        y = DEFAULT_Y;
        this.active = active;
    }

    private boolean validPoint(int x, int y){
        return ((x > 0 && x < GameManager.WIDTH) &&
                ((y > 0 && y < GameManager.HEIGHT)));
    }

}
