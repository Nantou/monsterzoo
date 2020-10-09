import static java.lang.System.out;

public class BattleEvent implements Event{
    private final static Integer BATTLE_EVENT_FIRE_RANGE = 7;

    @Override
    public void fire(Player player) {
        Monster appearedMonster = MonsterList.randomFromMonsterList();
        appearedMonster.appearedMessage();
        this.catchLoop(player,appearedMonster);
    }

    private void catchLoop(Player player,Monster appearedMonster){
        Integer limit = player.canThrowBalls();
        for(Integer i=0; limit > i ;i++) if(this.catchChallenge(player,appearedMonster)) break;
    }

    private boolean catchChallenge(Player player,Monster appearedMonster){
        player.throwBall(appearedMonster);
        return appearedMonster.isCatchable(player.generatePlayerRare()) ? whenCaught(player,appearedMonster) : whenEscaped(appearedMonster);
    }

    private boolean whenCaught(Player player,Monster appearedMonster){
        appearedMonster.monsterCatchMessage();
        player.addCaughtMonsterList(appearedMonster);
        return true;
    }

    private boolean whenEscaped(Monster appearedMonster){
        appearedMonster.runawayMessage();
        return false;
    }

    @Override
    public boolean firingCriteria(Integer flag) {
        return (flag >= BATTLE_EVENT_FIRE_RANGE);
    }
}