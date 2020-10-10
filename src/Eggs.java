import java.util.List;
import java.util.ArrayList;

public class Eggs {
    private static final Integer MAX_CARRYING_EGG = 10;

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
    private static List<Egg> carryingEggList = new ArrayList<Egg>();

    public void endProcess(Player player) {
        this.hatchingVerificationInList(player);
        this.hatchingVerification();
    }

    public void updateEggList(){
        this.carryingEggList.forEach(e -> e.move());
    }

    public void addCarryingEggList() {
        if(carryingEggList.size() < MAX_CARRYING_EGG){
            this.carryingEggList.add(new Egg());
        }
    }

    private void hatchingVerification(){
        this.removeCarryingEggList();
    }

    private void removeCarryingEggList() {
		this.carryingEggList.removeIf(i -> i.extrication_decision());
    }

    private void hatchingVerificationInList(Player player){
		this.carryingEggList.stream()
			.filter(i -> i.extrication_decision())
            .forEach(i -> player.addCaughtMonsterList(i.birth()));
    }



}