/**
 * Created by toomeyt0 on 3/11/2016.
 */
public class Player extends Entity  {

    public static volatile Player player;
    private int x,y;

    private Player(){};

    public static Player GetInstance(){
        if(null == player){
            synchronized (Player.class){
                if(null == player){
                    player = new Player();
                }
            }
        }
        return player;
    }

    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }



}
