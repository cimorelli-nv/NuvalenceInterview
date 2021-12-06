package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleAdjacencyAnalyzerTest {
    @Test
    public void proper_adjacency() {
        // Prepare
        RectangleAdjacencyAnalyzer analyzer = new RectangleAdjacencyAnalyzer();
        Rectangle r1 = new Rectangle(0, 3, 3, 0);
        Rectangle r2 = new Rectangle(3, 3, 4, 0);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_PROPER, result.get_description());
    }

    @Test
    public void sub_line_adjacency() {
        // Prepare
        RectangleAdjacencyAnalyzer analyzer = new RectangleAdjacencyAnalyzer();
        Rectangle r1 = new Rectangle(0, 3, 3, 0);
        Rectangle r2 = new Rectangle(3, 2, 4, 1);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_SUB_LINE, result.get_description());
    }

    @Test
    public void partial_adjacency() {
        // Prepare
        RectangleAdjacencyAnalyzer analyzer = new RectangleAdjacencyAnalyzer();
        Rectangle r1 = new Rectangle(0, 3, 3, 0);
        Rectangle r2 = new Rectangle(3, 4, 4, 1);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertEquals(RectangleAdjacencyAnalyzer.ADJACENCY_PARTIAL, result.get_description());
    }

    @Test
    public void no_adjacency() {
        // Prepare
        RectangleAdjacencyAnalyzer analyzer = new RectangleAdjacencyAnalyzer();
        Rectangle r1 = new Rectangle(0, 3, 3, 0);
        Rectangle r2 = new Rectangle(4, 2, 5, 1);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }
}
