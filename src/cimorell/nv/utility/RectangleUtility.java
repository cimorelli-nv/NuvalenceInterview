package cimorell.nv.utility;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;

/**
 * A utility/helper class to add logic to the Rectangle model class.
 */
public class RectangleUtility {
    /**
     * Given a rectangle, return the Points of its four corners, starting from the top left (0) and proceeding
     * clockwise (top left, top right, bottom right, bottom left).
     * @param rectangle The rectangle.
     * @return An array of four Point objects for the four corners.
     */
    public Point[] getFourCorners(Rectangle rectangle) {
        Point[] points = new Point[4];
        points[0] = rectangle.get_topLeftPoint();
        points[1] = new Point(rectangle.get_bottomRightPoint().get_x(), rectangle.get_topLeftPoint().get_y());
        points[2] = rectangle.get_bottomRightPoint();
        points[3] = new Point(rectangle.get_topLeftPoint().get_x(), rectangle.get_bottomRightPoint().get_y());
        return points;
    }
}
