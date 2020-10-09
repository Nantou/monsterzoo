import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Events{
    private final static Integer MAX_EVENT_FLAG = 10;
    private static List<Event> eventList = new ArrayList<Event>();

    public Events() {
        this.addEventList();
    }

    private static void addEventList() {
        eventList.add(new BattleEvent());
        eventList.add(new StationEvent());
    }
    
    public static void occurrenceEventDecision(Player player) {
        Random randam = new Random();
        fireEvent(player,randam.nextInt(MAX_EVENT_FLAG));
    }

    private static void fireEvent(Player player,Integer flag){
        eventList.stream()
            .filter(e -> e.firingCriteria(flag))
            .forEach(e -> e.fire(player));
    }
}