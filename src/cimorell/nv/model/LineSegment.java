package cimorell.nv.model;

import java.util.Objects;

/**
 * A line segment, defined by the two points at either end.
 */
public class LineSegment {
    private Point _lowPoint;
    public Point get_lowPoint() {
        return _lowPoint;
    }
    public void set_lowPoint(Point val) {
        _lowPoint = val;
    }

    private Point _highPoint;
    public Point get_highPoint() {
        return _highPoint;
    }
    public void set_highPoint(Point val) {
        _highPoint = val;
    }

    public LineSegment(Point lowPoint, Point highPoint) {
        this._lowPoint = lowPoint;
        this._highPoint = highPoint;
    }

    public LineSegment(double lowPointX, double lowPointY, double highPointX, double highPointY) {
        this._lowPoint = new Point(lowPointX, lowPointY);
        this._highPoint = new Point(highPointX, highPointY);
    }

    @Override
    public String toString() {
        return "LineSegment{" +
            "Low=" + _lowPoint +
            ", High=" + _highPoint +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LineSegment)) {
            return false;
        }
        LineSegment lineSegment = (LineSegment) o;
        return Objects.equals(_lowPoint, lineSegment._lowPoint) &&
            Objects.equals(_highPoint, lineSegment._highPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_lowPoint, _highPoint);
    }
}
