import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;

public class Player {
    private Bag bag = new Bag();
    private static MonsterList monsterList = new MonsterList();

	//ユーザがGetしたモンスター一覧
    private List<Monster> caughtMonsterList = new ArrayList<Monster>();

    public void startProcess() {
        this.bag.startProcess();
    }

    public void endProcess() {
        this.bag.endProcess(this);
    }

    public void addCaughtMonsterList(Monster newMonster) {
        this.caughtMonsterList.add(newMonster);
    }

    public void addCarryingEggList() {
        this.bag.addCarryingEggList();
    }

    public boolean hasBalls() {
        return this.bag.hasBalls();
    }

    public void addBalls(Integer addBalls) {
        this.bag.addBalls(addBalls);
    }

    public void addFruits(Integer addFruits) {
        this.bag.addFruits(addFruits);
    }

    public Integer canThrowBalls() {
        return this.bag.canThrowBalls();
    }

    public void throwBall(Monster appearedMonster) {
        this.bag.throwBall(appearedMonster);
    }

    public void useFruit() {
        this.bag.useFruit();
    }

    public void printGetMonsters() {
        this.caughtMonsterList.stream()
            .forEach(m -> m.resultMessage());
    }

    public Rare generatePlayerRare() {
        Rare playerRare = new Rare();
        if(this.bag.hasFruits()) playerRare.useFruit(this);
        return playerRare;
    }
}