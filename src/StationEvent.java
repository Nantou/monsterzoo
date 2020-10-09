import static java.lang.System.out;
import java.util.Random;

public class StationEvent implements Event{
    private final static Integer STATION_EVENT_FIRE_RANGE = 2;
    private final static Integer GET_EGG = 1;
    @Override
    public void fire(Player player) {
        this.eventMessage();
        this.itemGetEvent(player);
}

    @Override
    public boolean firingCriteria(Integer flag) {
        return (flag < STATION_EVENT_FIRE_RANGE);
    }

    private void itemGetEvent(Player player) {
        player.addBalls(generateRandomItemWithin(2));
        player.addFruits(generateRandomItemWithin(1));
        this.eggGetDecision(player);
    }

    private void eggGetDecision(Player player){
        Integer egg = generateRandomItemWithin(1);
        out.println("卵を"+egg+"個Getした！");
        if(egg >= GET_EGG) player.addCarryingEggList();
    }

    public static Integer generateRandomItemWithin(Integer max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    private void eventMessage() {
        out.println("ズーstationを見つけた！");
    }
}