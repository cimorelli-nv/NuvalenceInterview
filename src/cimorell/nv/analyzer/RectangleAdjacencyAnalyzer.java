package cimorell.nv.analyzer;

import cimorell.nv.exception.InvalidValueError;
import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.LineSegment;
import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;
import cimorell.nv.utility.RectangleUtility;

import java.util.ArrayList;
import java.util.List;

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

    private final LineSegmentAdjacencyAnalyzer lineSegmentAdjacencyAnalyzer;
    private final RectangleUtility rectangleUtility;

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
        // If the two rectangles are equivalent, they are not adjacent
        if (rectangle1.equals(rectangle2)) {
            return new AnalysisResult(false);
        }

        // Check the bottom and top edges of rectangle 1 against the bottom and top of rectangle 2, and then the left
        // and right of each. For each pair of lines, check for any type of adjacency.
        Point[] rect1_points = rectangleUtility.getFourCorners(rectangle1);
        LineSegment[] rect1_horiz = new LineSegment[2];
        rect1_horiz[0] = new LineSegment(rect1_points[0], rect1_points[3]);
        rect1_horiz[1] = new LineSegment(rect1_points[1], rect1_points[2]);
        LineSegment[] rect1_vert = new LineSegment[2];
        rect1_vert[0] = new LineSegment(rect1_points[0], rect1_points[1]);
        rect1_vert[1] = new LineSegment(rect1_points[3], rect1_points[2]);

        LineSegment[][] rect1 = new LineSegment[2][];
        rect1[0] = rect1_horiz;
        rect1[1] = rect1_vert;

        Point[] rect2_points = rectangleUtility.getFourCorners(rectangle2);
        LineSegment[] rect2_horiz = new LineSegment[2];
        rect2_horiz[0] = new LineSegment(rect2_points[0], rect2_points[3]);
        rect2_horiz[1] = new LineSegment(rect2_points[1], rect2_points[2]);
        LineSegment[] rect2_vert = new LineSegment[2];
        rect2_vert[0] = new LineSegment(rect2_points[0], rect2_points[1]);
        rect2_vert[1] = new LineSegment(rect2_points[3], rect2_points[2]);

        LineSegment[][] rect2 = new LineSegment[2][];
        rect2[0] = rect2_horiz;
        rect2[1] = rect2_vert;

        boolean foundProper = false;
        boolean foundSubLine = false;
        boolean foundPartial = false;

        for (int hv = 0; hv < 2; hv++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    AnalysisResult adjacent = lineSegmentAdjacencyAnalyzer.parallelLinesAreAdjacent(
                        rect1[hv][i],
                        rect2[hv][j]
                    );
                    if (adjacent.get_meetsCondition()) {
                        switch (adjacent.get_description()) {
                            case ADJACENCY_PROPER:
                                foundProper = true;
                                break;
                            case ADJACENCY_SUB_LINE:
                                foundSubLine = true;
                                break;
                            case ADJACENCY_PARTIAL:
                                foundPartial = true;
                                break;
                            default:
                                throw new InvalidValueError(
                                    "Unknown value for line segment adjacency description: " +
                                        adjacent.get_description()
                                );
                        }
                    }
                }
            }
        }

        if (foundProper || foundSubLine || foundPartial) {
            List<String> adjacencyTypes = new ArrayList<>();
            if (foundProper) {
                adjacencyTypes.add(ADJACENCY_PROPER);
            }
            if (foundSubLine) {
                adjacencyTypes.add(ADJACENCY_SUB_LINE);
            }
            if (foundPartial) {
                adjacencyTypes.add(ADJACENCY_PARTIAL);
            }
            return new AnalysisResult(true, String.join(", ", adjacencyTypes));
        } else {
            return new AnalysisResult(false);
        }
    }

    public RectangleAdjacencyAnalyzer() {
        this.rectangleUtility = new RectangleUtility();
        this.lineSegmentAdjacencyAnalyzer = new LineSegmentAdjacencyAnalyzer();
    }

    public RectangleAdjacencyAnalyzer(
        RectangleUtility rectangleUtility,
        LineSegmentAdjacencyAnalyzer lineSegmentAdjacencyAnalyzer
    ) {
        this.rectangleUtility = rectangleUtility;
        this.lineSegmentAdjacencyAnalyzer = lineSegmentAdjacencyAnalyzer;
    }
}
