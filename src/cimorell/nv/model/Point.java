package cimorell.nv.model;

/**
 * A single point on a cartesian plane, described by X and Y coordinates.
 */
public class Point {
    private double _x;
    public double get_x() {
        return _x;
    }
    public void set_x(double val) {
        _x = val;
    }

    private double _y;
    public double get_y() {
        return _y;
    }
    public void set_y(double val) {
        _y = val;
    }

    public Point(double x, double y) {
        this._x = x;
        this._y = y;
    }

    @Override
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }
}
