import java.util.Random;
import static java.lang.System.out;

public class Rare implements Comparable<Rare>{
    private static final Integer MAX_RARITY = 6;
    private Integer rare;

    public Rare(Integer rare) {
        this.rare = rare;
    }

    public Rare() {
        this.rare = randomGenerationRare();
    }

    @Override
    public int compareTo(Rare otherRare){
        return otherRare.compareTo(this.rare);
    }

    private int compareTo(Integer otherRare) {
        return Integer.compare(this.rare,otherRare);
    }

    public void useFruit(Player player) {
        player.useFruit();
        out.println("フルーツを投げた！捕まえやすさが倍になる！");
        this.rare *= 2;
    }

    private static Integer randomGenerationRare(){
        Random random = new Random();
        return random.nextInt(MAX_RARITY);
    }
}