import java.util.ArrayList;
import java.util.List;

public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {
		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.getBalls()>0){
					pz.turn();
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pz.result();
	}
}
