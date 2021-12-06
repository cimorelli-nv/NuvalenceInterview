package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleContainmentAnalyzerTest {
    @Test
    public void contained() {
        // Prepare
        RectangleContainmentAnalyzer analyzer = new RectangleContainmentAnalyzer();
        Rectangle r1 = new Rectangle(0, 0, 4, 4);
        Rectangle r2 = new Rectangle(1, 2, 2, 3);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertTrue(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void no_containment_not_touching() {
        // Prepare
        RectangleContainmentAnalyzer analyzer = new RectangleContainmentAnalyzer();
        Rectangle r1 = new Rectangle(0, 0, 3, 3);
        Rectangle r2 = new Rectangle(4, 1, 6, 2);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void intersecting_on_one_edge() {
        // Prepare
        RectangleContainmentAnalyzer analyzer = new RectangleContainmentAnalyzer();
        Rectangle r1 = new Rectangle(0, 0, 4, 3);
        Rectangle r2 = new Rectangle(2, 0, 3, 2);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }

    @Test
    public void nearly_contained_but_touching_on_one_edge() {
        // Prepare
        RectangleContainmentAnalyzer analyzer = new RectangleContainmentAnalyzer();
        Rectangle r1 = new Rectangle(0, 0, 4, 4);
        Rectangle r2 = new Rectangle(1, 2, 3, 4);

        // Test
        AnalysisResult result = analyzer.analyze(r1, r2);

        // Verify
        Assertions.assertFalse(result.get_meetsCondition());
        Assertions.assertNull(result.get_description());
    }
}
