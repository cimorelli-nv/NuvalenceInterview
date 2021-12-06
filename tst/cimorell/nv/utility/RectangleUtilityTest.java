package cimorell.nv.utility;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleUtilityTest {
    @Test
    public void getFourCorners_returns_four_corners() {
        // Prepare
        RectangleUtility utility = new RectangleUtility();
        Rectangle rectangle = new Rectangle(1, 4, 2, 3);
        Point[] expectedPoints = new Point[4];
        expectedPoints[0] = new Point(1, 4);
        expectedPoints[1] = new Point(2, 4);
        expectedPoints[2] = new Point(2, 3);
        expectedPoints[3] = new Point(1, 3);

        // Test
        Point[] actualPoints = utility.getFourCorners(rectangle);

        // Verify
        Assertions.assertArrayEquals(expectedPoints, actualPoints);
    }
}
