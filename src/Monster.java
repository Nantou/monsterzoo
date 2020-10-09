import static java.lang.System.out;

public class Monster {
    private Name name;
    private Rare rare;

    public Monster(String name, Integer rare) {
        this.name = new Name(name);
        this.rare = new Rare(rare);
    }

    public void birthMessage() {
        out.println("卵が孵った！\n" + name.toString() + "が産まれた！");
    }

    public void appearedMessage() {
        out.println(name.toString()+"が現れた！");
    }

    public void throwBallMessage() {
        out.println(name.toString()+"にボールを投げた");
    }

    public void monsterCatchMessage() {
        out.println(name.toString()+"を捕まえた！");
    }

    public void runawayMessage() {
        out.println(name.toString()+"に逃げられた！");
    }

    public void resultMessage() {
        out.println(name.toString()+"を捕まえた．");
    }


    public Rare returnRare() {
        return this.rare;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public boolean isCatchable(Rare rare) {
        return (rare.compareTo(this.rare) <= 0);
    }
}