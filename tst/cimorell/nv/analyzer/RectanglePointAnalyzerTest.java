package cimorell.nv.analyzer;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectanglePointAnalyzerTest {
    @Test
    public void instantiates() {
        Assertions.assertDoesNotThrow(() -> {
            new RectanglePointAnalyzer();
        });
    }

    @Test
    public void point_inside_rectangle_returns_true() {
        // Prepare
        RectanglePointAnalyzer analyzer = new RectanglePointAnalyzer();
        Point point = new Point(2, 2);
        Rectangle rectangle = new Rectangle(1, 1, 3, 3);

        // Test
        boolean result = analyzer.rectangleContainsPoint(rectangle, point);

        // Verify
        Assertions.assertTrue(result);
    }

    @Test
    public void point_outside_rectangle_returns_false() {
        // Prepare
        RectanglePointAnalyzer analyzer = new RectanglePointAnalyzer();
        Point point = new Point(1, 4);
        Rectangle rectangle = new Rectangle(1, 1, 3, 3);

        // Test
        boolean result = analyzer.rectangleContainsPoint(rectangle, point);

        // Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void point_on_perimeter_of_rectangle_returns_false() {
        // Prepare
        RectanglePointAnalyzer analyzer = new RectanglePointAnalyzer();
        Point point = new Point(1, 2);
        Rectangle rectangle = new Rectangle(1, 1, 3, 3);

        // Test
        boolean result = analyzer.rectangleContainsPoint(rectangle, point);

        // Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void point_on_corner_of_rectangle_returns_false() {
        // Prepare
        RectanglePointAnalyzer analyzer = new RectanglePointAnalyzer();
        Point point = new Point(1, 3);
        Rectangle rectangle = new Rectangle(1, 1, 3, 3);

        // Test
        boolean result = analyzer.rectangleContainsPoint(rectangle, point);

        // Verify
        Assertions.assertFalse(result);
    }
}
