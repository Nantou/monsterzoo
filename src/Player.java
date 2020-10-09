import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;

public class Player {

    private static final Integer MAX_CARRYING_EGG = 10;
    private static final Integer DEFAULT_BALLS = 10;
    private static final Integer DEFAULT_FRUITS = 10;

	private Integer balls = DEFAULT_BALLS;//モンスターを捕まえられるボールの数
	private Integer fruits= DEFAULT_FRUITS;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	private List<Egg> carryingEggList = new ArrayList<Egg>();

	//ユーザがGetしたモンスター一覧
    private List<Monster> caughtMonsterList = new ArrayList<Monster>();

    //モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
    private MonsterList monsterList = new MonsterList();

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

    public Integer getBalls() {
        return this.balls;
    }

    public Integer getFruits() {
        return this.fruits;
    }

    public void addBalls(Integer addBalls) {
        this.balls += addBalls;
    }

    public void addFruits(Integer addFruits) {
        this.fruits += addFruits;
    }

    public void useBall() {
        this.balls -= 1;
    }

    public void useFruit() {
        this.fruits -= 1;
    }

    public void printGetMonsters() {
        this.caughtMonsterList.stream()
        .forEach(m -> out.println(m.name+"を捕まえた．"));
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
            .forEach(i -> {
                Monster birthMonster = i.birth(this.monsterList);
                this.addCaughtMonsterList(birthMonster);
            });
    }

    private void removeCarryingEggList() {
		this.carryingEggList.removeIf(i -> i.extrication_decision());
    }
}