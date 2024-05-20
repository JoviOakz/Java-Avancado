
package Files;

public class Spring {
    private Mass mass1;
    private Mass mass2;
    private double restLength;
    private double k;

    public Spring(Mass mass1, Mass mass2, double restLength, double k) {
        this.mass1 = mass1;
        this.mass2 = mass2;
        this.restLength = restLength;
        this.k = k;
    }

    public void applyForce() {
        double dx = mass2.getPosX() - mass1.getPosX();
        double dy = mass2.getPosY() - mass1.getPosY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        double forceMagnitude = k * (distance - restLength);

        double forceX = (dx / distance) * forceMagnitude;
        double forceY = (dy / distance) * forceMagnitude;

        mass1.addForce(forceX, forceY);
        mass2.addForce(-forceX, -forceY);
    }

    public Mass getMass1() {
        return this.mass1;
    }

    public Mass getMass2() {
        return this.mass2;
    }
}