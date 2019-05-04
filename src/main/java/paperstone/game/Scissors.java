package paperstone.game;

public class Scissors implements Gestures {
private String name;

    public Scissors(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scissors)) return false;
        Scissors scissors = (Scissors) o;
        return name.equals(scissors.name);
    }

    @Override
    public String computersMove() {
        return "Computer choose SCISSORS.";
    }
}
