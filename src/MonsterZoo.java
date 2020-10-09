import java.util.List;
import java.util.ArrayList;

public class MonsterZoo {

	private Distance distance = new Distance(0.0);//歩いた距離
	private Integer balls = 10;//モンスターを捕まえられるボールの数
	private Integer fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	List<Egg> carryingEggList = new ArrayList<Egg>();

	//ユーザがGetしたモンスター一覧
	List<Monster> caughtMonsterList = new ArrayList<Monster>();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	private MonsterList monsterList = new MonsterList();

	//呼び出すと1km distanceが増える
	public void move(){
		this.distance.add();
		this.turn();
		carryingEggList.forEach(e -> e.move());

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			System.out.println("ズーstationを見つけた！");
			int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
			int f=(int)(Math.random()*2);
			int e=(int)(Math.random()*2);
			System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
			this.balls=this.balls+b;
			this.fruits=this.fruits+f;
			if(e>=1){//卵を1つ以上Getしたら
				//egg[]に10個以上卵がない場合は新しい卵データをセットする
				if(carryingEggList.size()<10){
					carryingEggList.add(new Egg());
				}
			}
		}else if(flg1>=7){
			Monster appearedMonster = MonsterList.randomFromMonsterList();
			System.out.println(appearedMonster.name+"が現れた！");
			for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
				int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
				if(this.fruits>0){
					System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
					this.fruits--;
					r = r * 2;
				}
				System.out.println(appearedMonster.name+"にボールを投げた");
				this.balls--;
				if(appearedMonster.rate <= r){//monsterRare[m]の値がr以下の場合
					System.out.println(appearedMonster.name+"を捕まえた！");
					caughtMonsterList.add(appearedMonster);
					break;//ボール投げ終了
				}else{
					System.out.println(appearedMonster.name+"に逃げられた！");
				}
			}
		}
		carryingEggList.stream()
			.filter(i -> i.extrication_decision())
			.forEach(i -> caughtMonsterList.add(i.birth(this.monsterList)));
		carryingEggList.removeIf(i -> i.extrication_decision());
	}

	public void turn() {
		System.out.println("手持ちのボールは"+this.getBalls()+"個，フルーツは"+this.getFruits()+"個");
		System.out.println(this.distance.getDistance()+"km歩いた．");
	}

	public void result() {
		System.out.println("ボールがなくなった！");
		caughtMonsterList.stream().forEach(m -> System.out.println(m.name+"を捕まえた．"));
	}

	public int getBalls() {
		return balls;
	}

	public int getFruits() {
		return fruits;
	}

}
