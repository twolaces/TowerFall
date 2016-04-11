/**
 * Created by toomeyt0 on 3/11/2016.
 */

// Singleton!!!
public class StateManager {
    private boolean active;
    public enum States {
        Load, Main, Game, Pause, End
    }

    public StateManager(){
        if(!active) init();
        return;
    }

    private void init(){

    }

}
