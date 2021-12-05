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

    /**
     * Check if this rectangle is valid; requires that both points be set (not null) and that the top left point is
     * above and to the left of the bottom right point.
     */
    public ValidationResult validate() {
        ValidationResult valid = new ValidationResult(true);

        // Make sure both points are set (not null)
        if (_topLeftPoint == null) {
            valid.set_valid(false);
            valid.addError("Top left point is null");
        }
        if (_bottomRightPoint == null) {
            valid.set_valid(false);
            valid.addError("Bottom right point is null");
        }
        if (!valid.is_valid()) {
            return valid;
        }

        // If both points are set, make sure the top left is above and left of the bottom right
        if (_topLeftPoint.get_x() >= _bottomRightPoint.get_x() || _topLeftPoint.get_y() <= _bottomRightPoint.get_y()) {
            valid.set_valid(false);
            valid.addError(
                "Top left point "
                    + _topLeftPoint
                    + " is not above and to the left of bottom right point "
                    + _bottomRightPoint
            );
        }

        return valid;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
            "Top left=" + _topLeftPoint +
            ", Bottom right=" + _bottomRightPoint +
            '}';
    }
}
