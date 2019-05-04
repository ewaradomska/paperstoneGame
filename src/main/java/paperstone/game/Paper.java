package paperstone.game;

public class Paper implements Gestures {
private String name;

    public Paper(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;
        Paper paper = (Paper) o;
        return name.equals(paper.name);
    }

    @Override
    public String computersMove() {
        return "Computer choose PAPER.";
    }

}
