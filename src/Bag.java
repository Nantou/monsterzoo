import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Bag {
    // private static final Integer MAX_CARRYING_EGG = 10;

    // private static Item items = new Item();
    private Balls balls = new Balls();
    private Fruits fruits = new Fruits();

    private Eggs eggs = new Eggs();

	// //卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	// //移動するたびに,eggDistanceに1.0kmずつ加算される．
	// //3km移動するとランダムでモンスターが孵る
    // private static List<Egg> carryingEggList = new ArrayList<Egg>();

    public void startProcess() {
        this.eggs.updateEggList();
    }

    public void endProcess(Player player) {
        this.eggs.endProcess(player);
        this.outputBagItems();
    }

    public void addCarryingEggList() {
        this.eggs.addCarryingEggList();
    }

    public void addBalls(Integer addBalls) {
        this.balls.addBalls(addBalls);
    }

    public void addFruits(Integer addFruits) {
        this.fruits.addFruits(addFruits);
    }

    public boolean hasBalls() {
        return this.balls.hasBalls();
    }

    public boolean hasFruits() {
        return this.fruits.hasFruits();
    }

    public Integer canThrowBalls() {
        return this.balls.canThrowBalls();
    }

    public void throwBall(Monster appearedMonster) {
        this.balls.throwBall(appearedMonster);
    }

    public void useFruit() {
        this.fruits.useFruit();
    }

    private void outputBagItems() {
        out.println("手持ちのボールは"+this.balls.toString()+"個，フルーツは"+this.fruits+"個");
    }
}