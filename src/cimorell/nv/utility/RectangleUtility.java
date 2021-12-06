package cimorell.nv.utility;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;

/**
 * A utility/helper class to add logic to the Rectangle model class.
 */
public class RectangleUtility {
    /**
     * Given a rectangle, return the Points of its four corners, starting from the bottom left (0) and proceeding
     * clockwise (bottom left, top left, top right, bottom right).
     * @param rectangle The rectangle.
     * @return An array of four Point objects for the four corners.
     */
    public Point[] getFourCorners(Rectangle rectangle) {
        Point[] points = new Point[4];
        points[0] = rectangle.get_bottomLeftPoint();
        points[1] = new Point(rectangle.get_bottomLeftPoint().get_x(), rectangle.get_topRightPoint().get_y());
        points[2] = rectangle.get_topRightPoint();
        points[3] = new Point(rectangle.get_topRightPoint().get_x(), rectangle.get_bottomLeftPoint().get_y());
        return points;
    }
}
