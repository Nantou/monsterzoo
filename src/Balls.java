import static java.lang.System.out;

public class Balls {
    private static final Integer DEFAULT_BALLS = 10;
    private Integer balls = DEFAULT_BALLS;//モンスターを捕まえられるボールの数

    public boolean hasBalls(){
        return (this.balls > 0);
    }

    public void addBalls(Integer addBalls) {
        out.print("ボールを"+addBalls+"個，");
        this.balls += addBalls;
    }

    public void useBall() {
        this.balls -= 1;
    }

    public Integer canThrowBalls() {
        return Math.min(this.balls,new Integer(3));
    }

    public void throwBall(Monster appearedMonster) {
        out.println(appearedMonster.toString()+"にボールを投げた");
        this.useBall();
    }

    @Override
    public String toString() {
        return this.balls.toString();
    }



}