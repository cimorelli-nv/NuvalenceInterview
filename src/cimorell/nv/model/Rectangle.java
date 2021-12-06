package cimorell.nv.model;

/**
 * Represents a rectangle on a cartesian plane, described by two Points: the top left Point and the bottom right Point.
 */
public class Rectangle {
    private Point _topLeftPoint;
    public Point get_topLeftPoint() {
        return _topLeftPoint;
    }
    public void set_topLeftPoint(Point val) {
        _topLeftPoint = val;
    }

    private Point _bottomRightPoint;
    public Point get_bottomRightPoint() {
        return _bottomRightPoint;
    }
    public void set_bottomRightPoint(Point val) {
        _bottomRightPoint = val;
    }

    public Rectangle(Point topLeftPoint, Point bottomRightPoint) {
        this._topLeftPoint = topLeftPoint;
        this._bottomRightPoint = bottomRightPoint;
    }

    public Rectangle(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        this._topLeftPoint = new Point(topLeftX, topLeftY);
        this._bottomRightPoint = new Point(bottomRightX, bottomRightY);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
            "Top left=" + _topLeftPoint +
            ", Bottom right=" + _bottomRightPoint +
            '}';
    }
}
