public class Egg {
    public Double distance;

    public Egg() {
        this.distance = 3.0;
    }

    public void move() {
        this.distance += 1.0;
    }

    public boolean extrication_decision() {
        return (this.distance == 3.0);
    }

    public Monster birth() {
        Monster birthMonster = MonsterList.randomFromMonsterList();
        System.out.println("卵が孵った！\n" + birthMonster.name + "が産まれた！");
        return birthMonster;
    }
}

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る

    //卵は移動距離が進むと孵化するため，何km移動したかを更新する