package packer;

/**
 * @author Anthony Taite
 */
public class Coordinates {

    private final double x;
    private final double y;

    /**
     *
     * @param x enter the x coordinate
     * @param y enter the y coordinate
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return the x value of the coordinate
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return the y value of the coordinate
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param other enter the destination coordinates
     * @return the euclidean distance to the destination
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff), 0.5);
        return dist;
    }

    /**
     *
     * @param other enter the destination coordinates
     * @return the manhattan distance to the destination
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }

    /**
     *
     * @param other enter the destination coordinates
     * @return the average of the euclidean and manhattan distance to the
     * destination
     */
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1), 0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2) / 2;
    }

}
