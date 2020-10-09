

public class Distance implements Comparable<Distance> {
    private Double distance;

    public Distance(Double distance) {
        this.distance = new Double(distance);
    }

    @Override
    public int compareTo(Distance otherDistance){
        return otherDistance.compareTo(otherDistance.distance);
    }

    public int compareTo(double otherDistance) {
        return Double.compare(this.distance,otherDistance);
    }

    public Double getDistance() {
        return this.distance;
    }

    public void add() {
        this.distance += 1.0;
    }

    public void diff() {
        this.distance -= 1.0;
    }
}
