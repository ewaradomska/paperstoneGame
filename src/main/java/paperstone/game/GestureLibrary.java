package paperstone.game;

import java.util.ArrayList;
import java.util.List;

public class GestureLibrary {
    private List<Gestures> gesture = new ArrayList<>();
    private Gestures paper = new Paper("Paper");
    private Gestures scissors = new Scissors("Scissors");
    private Gestures stone = new Stone("Stone");

    public List<Gestures> getListOfGestures(){
        gesture.add(paper);
        gesture.add(scissors);
        gesture.add(stone);

        return gesture;
    }
}
