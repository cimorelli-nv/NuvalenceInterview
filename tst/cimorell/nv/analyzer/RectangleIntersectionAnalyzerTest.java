package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleIntersectionAnalyzerTest {
    @Test
    public void no_intersection() {
        // Prepare
        RectangleIntersectionAnalyzer analyzer = new RectangleIntersectionAnalyzer();
        Rectangle r1 = new Rectangle(0, 2, 3, 0);
        Rectangle r2 = new Rectangle(4, 2, 7, 0);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
    }

    @Test
    public void intersection_on_one_edge() {
        // Prepare
        RectangleIntersectionAnalyzer analyzer = new RectangleIntersectionAnalyzer();
        Rectangle r1 = new Rectangle(0, 3, 4, 0);
        Rectangle r2 = new Rectangle(2, 2, 3, 0);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
    }

    @Test
    public void intersection_on_two_edges() {
        // Prepare
        RectangleIntersectionAnalyzer analyzer = new RectangleIntersectionAnalyzer();
        Rectangle r1 = new Rectangle(1, 4, 3, 2);
        Rectangle r2 = new Rectangle(2, 3, 4, 1);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
    }

    @Test
    public void touch_at_corner() {
        // Prepare
        RectangleIntersectionAnalyzer analyzer = new RectangleIntersectionAnalyzer();
        Rectangle r1 = new Rectangle(1, 4, 3, 2);
        Rectangle r2 = new Rectangle(3, 1, 4, 1);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
    }

    @Test
    public void adjacent() {
        // Prepare
        RectangleIntersectionAnalyzer analyzer = new RectangleIntersectionAnalyzer();
        Rectangle r1 = new Rectangle(1, 4, 3, 2);
        Rectangle r2 = new Rectangle(3, 4, 5, 2);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
    }
}
