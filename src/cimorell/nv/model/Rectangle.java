package cimorell.nv.model;

import java.util.Objects;

/**
 * Represents a rectangle on a cartesian plane, described by two Points: the bottom left Point and the top right Point.
 */
public class Rectangle {
    private Point _bottomLeftPoint;
    public Point get_bottomLeftPoint() {
        return _bottomLeftPoint;
    }
    public void set_bottomLeftPoint(Point val) {
        _bottomLeftPoint = val;
    }

    private Point _topRightPoint;
    public Point get_topRightPoint() {
        return _topRightPoint;
    }
    public void set_topRightPoint(Point val) {
        _topRightPoint = val;
    }

    public Rectangle(Point bottomLeftPoint, Point topRightPoint) {
        this._bottomLeftPoint = bottomLeftPoint;
        this._topRightPoint = topRightPoint;
    }

    public Rectangle(double bottomLeftX, double bottomLeftY, double topRightX, double topRightY) {
        this._bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);
        this._topRightPoint = new Point(topRightX, topRightY);
    }

    @Override
    public String toString() {
        return "{" + _bottomLeftPoint + " to " + _topRightPoint + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(_bottomLeftPoint, rectangle._bottomLeftPoint) &&
            Objects.equals(_topRightPoint, rectangle._topRightPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_bottomLeftPoint, _topRightPoint);
    }
}
