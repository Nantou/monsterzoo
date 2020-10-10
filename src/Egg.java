public class Egg {
    private static final Double DEFAULT_DISTANCE = 3.0;
    public Distance distance;

    public Egg() {
        this.distance = new Distance(3.0);
    }

    public void move() {
        this.distance.add();
    }

    public boolean extrication_decision() {
        return (this.distance.compareTo(3.0) == 0);
    }

    public Monster birth() {
        Monster birthMonster = MonsterList.randomFromMonsterList();
        birthMonster.birthMessage();
        return birthMonster;
    }
}

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る

    //卵は移動距離が進むと孵化するため，何km移動したかを更新する