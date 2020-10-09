import java.util.ArrayList;
import java.util.List;

public class Main {
	static MonsterZoo monsterZoo = new MonsterZoo();

	public static void main(String[] args) {
		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while( monsterZoo.endDecision() ) turn();
		monsterZoo.result();
	}

	private static void turn(){
		try{ monsterZoo.move(); }
		catch(InterruptedException e){ e.printStackTrace(); }
}
}
