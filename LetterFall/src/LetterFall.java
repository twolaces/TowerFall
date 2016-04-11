/**
 * Created by toomeyt0 on 4/1/2016.
 *
 *
 * Gameplay:
 * 20x10 array of squares with a random letter on the top 5 rows; squares descend with increasing speed.
 * Typing a letter removes all blocks with that letter. Typing an incorrect letter moves the squares
 * down by one. The player entity cannot be controlled by the user but will move one space, left or right,
 * or not at all.
 *
 */


public class LetterFall{
    static final String NAME = "LetterFall";
    GameWindow gameWindow;

    public LetterFall(){
        gameWindow = new GameWindow();
        gameWindow.run();
    }

    public static void main(String[] args){
        LetterFall letterFall = new LetterFall();
    }
}
