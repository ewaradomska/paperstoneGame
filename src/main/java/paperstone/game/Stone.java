package paperstone.game;

public class Stone implements Gestures{
 private String name;

    public Stone(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stone)) return false;
        Stone stone = (Stone) o;
        return name.equals(stone.name);
    }

    @Override
    public String computersMove() {
        return "Computer choose STONE.";
    }
}
