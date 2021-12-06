package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;

/**
 * Analyzer to test if one rectangle contains another. A rectangle must strictly be within another rectangle (not
 * touching) to count as being contained.
 */
public class RectangleContainmentAnalyzer implements RectangleAnalyzer {
    private final RectanglePointAnalyzer rectanglePointAnalyzer;

    /**
     * Test if one rectangle is contained within another rectangle. To be contained, the inner rectangle cannot touch
     * the outer rectangle at any point.
     *
     * @param rectangle1 The outer rectangle, which must contain rectangle2 within it.
     * @param rectangle2 The inner rectangle, which must be contained within rectangle1.
     * @return An AnalysisResult object with meetsCondition indicating whether rectangle1 contains rectangle2. The
     * description property is not set for containment analysis.
     */
    @Override
    public AnalysisResult analyze(Rectangle rectangle1, Rectangle rectangle2) {
        // Rectangle 2 is contained within rectangle 1 if opposite corners (bottom left and top right) of rectangle 2
        // are both contained within rectangle 1.
        boolean
            contained =
                rectanglePointAnalyzer.rectangleContainsPoint(rectangle1, rectangle2.get_bottomLeftPoint()) &&
                rectanglePointAnalyzer.rectangleContainsPoint(rectangle1, rectangle2.get_topRightPoint());

        return new AnalysisResult(contained);
    }

    public RectangleContainmentAnalyzer() {
        this.rectanglePointAnalyzer = new RectanglePointAnalyzer();
    }

    public RectangleContainmentAnalyzer(RectanglePointAnalyzer rectanglePointAnalyzer) {
        this.rectanglePointAnalyzer = rectanglePointAnalyzer;
    }
}
