package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.LineSegment;

/**
 * Analyzer to test if two line segments are adjacent. Two line segments are adjacent if they match exactly, or if they
 * are parallel and overlap, but not if they only share one point.
 * <p>
 * There are three types of adjacency:
 * 1. Proper: The two line segments are equal (both endpoints match).
 * 2. Sub-line: One line segment is contained within the other.
 * 3. Partial: The two line segments overlap for some distance greater than 0 (they don't only share one point).
 */
public class LineSegmentAdjacencyAnalyzer {
    /**
     * Tests if two line segments are adjacent (proper, sub-line, or partial). The two line segments are assumed to be
     * either horizontal or vertical (not diagonal), and to be parallel to one another; this is not validated by this
     * method.
     * @param lineSegment1 The first line segment.
     * @param lineSegment2 The second line segment.
     * @return An AnalysisResult object with meetsCondition indicating whether the two line segments are adjacent. The
     * description property will identify the type of adjacency: proper, sub-line, or partial.
     */
    public AnalysisResult parallelLinesAreAdjacent(LineSegment lineSegment1, LineSegment lineSegment2) {
        // If the two line segments are equivalent, they have proper adjacency. This is simple to test, so start with
        // that to get it out of the way.
        if (lineSegment1.equals(lineSegment2)) {
            return new AnalysisResult(true, RectangleAdjacencyAnalyzer.ADJACENCY_PROPER);
        }

        // The line segments are not equivalent, so check for containment or overlap. Since the lines are horizontal or
        // vertical, and are parallel, we only need to compare one set of coordinates (x or y). Check which orientation
        // the line segments are in and get the relevant coordinates for each.
        double ls1_a, ls1_e1, ls1_e2, ls2_a, ls2_e1, ls2_e2;
        if (lineSegment1.get_lowPoint().get_x() == lineSegment1.get_highPoint().get_x()) {
            // The lines are vertical, so each lines' two endpoints have the same X coordinates
            // Store the X coordinate for each, plus the two Ys
            ls1_a = lineSegment1.get_highPoint().get_x();
            ls1_e1 = lineSegment1.get_lowPoint().get_y();
            ls1_e2 = lineSegment1.get_highPoint().get_y();
            ls2_a = lineSegment2.get_highPoint().get_x();
            ls2_e1 = lineSegment2.get_lowPoint().get_y();
            ls2_e2 = lineSegment2.get_highPoint().get_y();
        } else {
            // The lines are horizontal, so each lines' two endpoints have the same Y coordinates
            // Store the Y coordinate for each, plus the two Xs
            ls1_a = lineSegment1.get_highPoint().get_y();
            ls1_e1 = lineSegment1.get_lowPoint().get_x();
            ls1_e2 = lineSegment1.get_highPoint().get_x();
            ls2_a = lineSegment2.get_highPoint().get_y();
            ls2_e1 = lineSegment2.get_lowPoint().get_x();
            ls2_e2 = lineSegment2.get_highPoint().get_x();
        }

        // If the shared coordinate for the line segments (X for vertical, Y for horizontal) are not equal, then the
        // line segments are not on the same line, and thus cannot be adjacent.
        if (ls1_a != ls2_a) {
            return new AnalysisResult(false);
        }

        // The line segments are on the same line. If the low point of one line is greater than the high point of the
        // other, then there is no overlap in the lines, so they are not adjacent.
        if (ls1_e1 >= ls2_e2 || ls1_e2 <= ls2_e1) {
            return new AnalysisResult(false);
        }

        // There is *some* overlap between the lines. If one line fully contains the other, then the adjacency is
        // sub-line; otherwise it is partial.
        boolean l1ContainsL2 = ls1_e1 <= ls2_e1 && ls1_e2 >= ls2_e2;
        boolean l2ContainsL1 = ls2_e1 <= ls1_e1 && ls2_e2 >= ls1_e2;
        if (l1ContainsL2 || l2ContainsL1) {
            return new AnalysisResult(true, RectangleAdjacencyAnalyzer.ADJACENCY_SUB_LINE);
        }

        // By process of elimination, the two line segments must have partial adjacency.
        return new AnalysisResult(true, RectangleAdjacencyAnalyzer.ADJACENCY_PARTIAL);
    }
}
