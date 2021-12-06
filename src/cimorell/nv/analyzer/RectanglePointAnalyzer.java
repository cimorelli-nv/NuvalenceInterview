package cimorell.nv.analyzer;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;

/**
 * Analyzer to test if a given point is contained within a given rectangle.
 */
public class RectanglePointAnalyzer {
    /**
     * Check if the given point is contained within the given rectangle. If a point is on the perimeter of the
     * rectangle, then the point is not considered to be within the rectangle.
     *
     * @param rectangle The rectangle.
     * @param point     The point.
     * @return True if the point is within (but not on the perimeter of) the rectangle, else false.
     */
    public boolean rectangleContainsPoint(Rectangle rectangle, Point point) {
        // A point is within a rectangle if its x-coordinate is between the x-coordinates of opposite corners of the
        // rectangle, and if its y-coordinate is between the y-coordinates of opposite corners.
        return point.get_x() > rectangle.get_topLeftPoint().get_x() &&
            point.get_x() < rectangle.get_bottomRightPoint().get_x() &&
            point.get_y() < rectangle.get_topLeftPoint().get_y() &&
            point.get_y() > rectangle.get_bottomRightPoint().get_y();
    }
}
