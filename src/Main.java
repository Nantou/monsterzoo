import java.util.ArrayList;
import java.util.List;

public class Main {	
	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	static MonsterZoo monsterZoo = new MonsterZoo();

	public static void main(String[] args) {
		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while( monsterZoo.continuation() ) turn();
		monsterZoo.result();
	}

	private static void turn(){
		try{ monsterZoo.move(); }
		catch(InterruptedException e){ e.printStackTrace(); }
}
}
