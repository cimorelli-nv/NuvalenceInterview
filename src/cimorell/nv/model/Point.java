package cimorell.nv.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(point._x, _x) == 0 && Double.compare(point._y, _y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y);
    }
}
