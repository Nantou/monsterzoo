import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;

public class MonsterZoo {
	private static Player player;
	private static Distance distance;//歩いた距離
	private static Events events;


	public MonsterZoo() {
		this.player = new Player();
		this.distance = new Distance(0.0);
		this.events = new Events();
	}

	public void move() throws InterruptedException{
		this.startProcess();
		this.events();
		this.endProcess();
	}

    private void startProcess() throws InterruptedException{
		Thread.sleep(1000);
		this.distance.add();
        this.player.startProcess();
	}

	private void events() {
		Events.occurrenceEventDecision(player);
	}

	private void endProcess() {
		this.player.endProcess();
		out.println(this.distance.toDouble()+"km歩いた．");
	}

	public void result() {
		out.println("ボールがなくなった！");
		this.player.printGetMonsters();
	}

	public boolean continuation() {
		return this.player.hasBalls();
	}
}
