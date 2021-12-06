package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;

/**
 * Analyzer to test if two rectangles are adjacent. Adjacency is defined as the sharing of at least one side, but where
 * the two rectangles are distinct (they don't have exactly the same corners). See "Rectangles Programming Sample.pdf"
 * appendix 3 for details.
 * <p>
 * There are three types of adjacency:
 * 1. Proper: Two rectangles share one edge exactly (they share the same corners for that edge).
 * 2. Sub-line: One rectangle's edge is contained within another rectangle's edge.
 * 3. Partial: The edges of two rectangles overlap, where each contains a portion of the other.
 */
public class RectangleAdjacencyAnalyzer implements RectangleAnalyzer {
    public static final String ADJACENCY_PROPER = "Proper";
    public static final String ADJACENCY_SUB_LINE = "Sub-line";
    public static final String ADJACENCY_PARTIAL = "Partial";

    /**
     * Test if two rectangles are adjacent (proper, sub-line, or partial). If one of the rectangles is partially
     * contained within the other, there may be multiple types of adjacency present (e.g. proper adjacency on one edge
     * and sub-line adjacency on two others). In this case, all types of adjacency that were found will be returned,
     * as a comma-separated list (e.g. "Proper, Sub-line").
     * @param rectangle1 The first rectangle to test.
     * @param rectangle2 The second rectangle to test.
     * @return An AnalysisResult object with meetsCondition indicating whether the two rectangles are adjacent. The
     * description property will identify the type(s) of adjacency: proper, sub-line, or partial.
     */
    @Override
    public AnalysisResult analyze(Rectangle rectangle1, Rectangle rectangle2) {
        // Check the top and bottom edges of rectangle 1 against the top and bottom of rectangle 2, and then the left
        // and right of each. For each pair of lines, check for any type of adjacency.

        // TODO: Implement line segment class and utility to check adjacency of two segments, then come back

        return null;
    }
}
