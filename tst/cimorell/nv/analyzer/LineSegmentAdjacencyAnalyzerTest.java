package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.LineSegment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineSegmentAdjacencyAnalyzerTest {
    @Test
    public void horizontal_segments_with_different_Ys_not_adjacent() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 6, 1);
        LineSegment l2 = new LineSegment(2, 4, 7, 4);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void vertical_segments_with_different_Xs_not_adjacent() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 1, 6);
        LineSegment l2 = new LineSegment(2, 4, 2, 7);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void non_overlapping_segments_not_adjacent() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 1, 6);
        LineSegment l2 = new LineSegment(1, 7, 1, 9);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void segments_touching_at_one_point_not_adjacent() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 1, 6);
        LineSegment l2 = new LineSegment(1, 6, 1, 9);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void overlapping_segments_are_adjacent_partial() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 1, 6);
        LineSegment l2 = new LineSegment(1, 4, 1, 9);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_PARTIAL, result.get_description());
    }

    @Test
    public void segment_contained_in_another_is_adjacent_sub_line() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 6, 1);
        LineSegment l2 = new LineSegment(2, 1, 4, 1);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_SUB_LINE, result.get_description());
    }

    @Test
    public void segment_contained_in_another_with_shared_point_is_adjacent_sub_line() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 6, 1);
        LineSegment l2 = new LineSegment(1, 1, 4, 1);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_SUB_LINE, result.get_description());
    }

    @Test
    public void equivalent_segments_are_adjacent_proper() {
        // Prepare
        LineSegmentAdjacencyAnalyzer analyzer = new LineSegmentAdjacencyAnalyzer();
        LineSegment l1 = new LineSegment(1, 1, 6, 1);
        LineSegment l2 = new LineSegment(1, 1, 6, 1);

        // Test
        AnalysisResult result = analyzer.parallelLinesAreAdjacent(l1, l2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_PROPER, result.get_description());
    }
}
