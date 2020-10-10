import static java.lang.System.out;

public class Fruits {
    private static final Integer DEFAULT_FRUITS = 0;
    private Integer fruits = DEFAULT_FRUITS;//ぶつけるとモンスターが捕まえやすくなるフルーツ

    public boolean hasFruits(){
        return (this.fruits > 0);
    }

    public void addFruits(Integer addFruits) {
        out.print("フルーツを"+addFruits+"個，");
        this.fruits += addFruits;
    }

    public void useFruit() {
        this.fruits -= 1;
    }

    @Override
    public String toString() {
        return this.fruits.toString();
    }
}