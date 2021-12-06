package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;
import cimorell.nv.utility.RectangleUtility;

/**
 * Analyzer to test if two rectangles intersect one another. Intersection is defined as having lines which strictly
 * intersect (cross) one another. Simply touching does not count as intersecting. See "Rectangles Programming
 * Sample.pdf" appendix 1 for details.
 */
public class RectangleIntersectionAnalyzer implements RectangleAnalyzer {
    private final RectangleUtility rectangleUtility;
    private final RectanglePointAnalyzer rectanglePointAnalyzer;

    /**
     * Test if two rectangles intersect one another. Intersection is defined as having lines which strictly
     * intersect (cross) one another. Simply touching does not count as intersecting.
     * @param rectangle1 The first rectangle to test.
     * @param rectangle2 The second rectangle to test.
     * @return An AnalysisResult object with meetsCondition indicating whether the two rectangles intersect. The
     * description property is not set for intersection analysis.
     */
    @Override
    public AnalysisResult analyze(Rectangle rectangle1, Rectangle rectangle2) {
        // Two rectangles intersect if one rectangle contains exactly one or two points of the other rectangle

        // Start by getting all four points of each rectangle
        Point[] r1Points = rectangleUtility.getFourCorners(rectangle1);
        Point[] r2Points = rectangleUtility.getFourCorners(rectangle2);

        // First check how many of rectangle 1's points are contained in rectangle 2
        int r1PointsInR2 = 0;
        for (int i = 0; i < 4; i++) {
            if (rectanglePointAnalyzer.rectangleContainsPoint(rectangle2, r1Points[i])) {
                r1PointsInR2++;
            }
        }
        if (r1PointsInR2 > 0 && r1PointsInR2 < 3) {
            return new AnalysisResult(true);
        }

        // Next check how many of rectangle 2's points are contained in rectangle 1
        int r2PointsInR1 = 0;
        for (int i = 0; i < 4; i++) {
            if (rectanglePointAnalyzer.rectangleContainsPoint(rectangle1, r2Points[i])) {
                r2PointsInR1++;
            }
        }
        if (r2PointsInR1 > 0 && r2PointsInR1 < 3) {
            return new AnalysisResult(true);
        }

        // No intersection
        return new AnalysisResult(false);
    }

    public RectangleIntersectionAnalyzer() {
        this.rectangleUtility = new RectangleUtility();
        this.rectanglePointAnalyzer = new RectanglePointAnalyzer();
    }

    public RectangleIntersectionAnalyzer(
        RectangleUtility rectangleUtility,
        RectanglePointAnalyzer rectanglePointAnalyzer
    ) {
        this.rectangleUtility = rectangleUtility;
        this.rectanglePointAnalyzer = rectanglePointAnalyzer;
    }
}
