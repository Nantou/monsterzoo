import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Player {

    private static final Integer MAX_CARRYING_EGG = 10;
    private static final Integer DEFAULT_BALLS = 10;
    private static final Integer DEFAULT_FRUITS = 0;

	private Integer balls = DEFAULT_BALLS;//モンスターを捕まえられるボールの数
	private Integer fruits= DEFAULT_FRUITS;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	private static List<Egg> carryingEggList = new ArrayList<Egg>();

	//ユーザがGetしたモンスター一覧
    private static List<Monster> caughtMonsterList = new ArrayList<Monster>();

    //モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
    private  static MonsterList monsterList = new MonsterList();

    public void startProcess() {
        this.updateEggList();
    }

    public void endProcess() {
        this.hatchingVerification();
        this.outputBagItems();
    }

    public void addCaughtMonsterList(Monster newMonster) {
        this.caughtMonsterList.add(newMonster);
    }

    public void addCarryingEggList() {
        if(carryingEggList.size() < MAX_CARRYING_EGG){
            this.carryingEggList.add(new Egg());
        }
    }

    public boolean hasBalls() {
        return (this.balls > 0);
    }

    public boolean hasFruits() {
        return (this.fruits > 0);
    }

    public void addBalls(Integer addBalls) {
        out.print("ボールを"+addBalls+"個，");
        this.balls += addBalls;
    }

    public void addFruits(Integer addFruits) {
        out.print("フルーツを"+addFruits+"個，");
        this.fruits += addFruits;
    }

    public Integer canThrowBalls() {
        return Math.min(this.balls,new Integer(3));
    }

    public void throwBall(Monster appearedMonster) {
        out.println(appearedMonster.toString()+"にボールを投げた");
        this.useBall();
    }

    public void useBall() {
        this.balls -= 1;
    }


    public void useFruit() {
        this.fruits -= 1;
    }

    public void printGetMonsters() {
        this.caughtMonsterList.stream()
            .forEach(m -> m.resultMessage());
    }

    public Rare generatePlayerRare() {
        Rare playerRare = new Rare();
        if(this.hasFruits()) playerRare.useFruit(this);
        return playerRare;
    }

    public boolean isBallEmpty() {
        return (this.balls == 0);
    }

    private void outputBagItems() {
        out.println("手持ちのボールは"+this.balls+"個，フルーツは"+this.fruits+"個");
    }

    private void updateEggList() {
        this.carryingEggList.forEach(e -> e.move());
    }

    private void hatchingVerification(){
        this.hatchingVerificationInList();
        this.removeCarryingEggList();
    }

    private void hatchingVerificationInList(){
		this.carryingEggList.stream()
			.filter(i -> i.extrication_decision())
            .forEach(i -> this.addCaughtMonsterList(i.birth()));
    }

    private void removeCarryingEggList() {
		this.carryingEggList.removeIf(i -> i.extrication_decision());
    }
}