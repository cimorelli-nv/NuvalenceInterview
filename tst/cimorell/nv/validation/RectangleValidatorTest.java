package cimorell.nv.validation;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;
import cimorell.nv.model.ValidationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RectangleValidatorTest {
    @Test
    public void instantiates() {
        Assertions.assertDoesNotThrow(() -> {
            new RectangleValidator();
        });
    }

    @Test
    public void valid_rectangle_has_valid_true_and_no_errors() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(1, 4, 3, 2);

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertTrue(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertTrue(errors == null || errors.isEmpty());
    }

    @Test
    public void rectangle_with_null_points_has_error() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(null, null);

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertFalse(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertEquals(2, errors.size());
        Assertions.assertTrue(errors.contains("Top left point is null"));
        Assertions.assertTrue(errors.contains("Bottom right point is null"));
    }

    @Test
    public void rectangle_with_one_null_point_has_error() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(
            new Point(1, 3),
            null
        );

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertFalse(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertEquals(1, errors.size());
        Assertions.assertTrue(errors.contains("Bottom right point is null"));
    }

    @Test
    public void rectangle_with_identical_points_has_error() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(
            new Point(1, 3),
            new Point(1, 3)
        );

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertFalse(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertEquals(1, errors.size());
        Assertions.assertTrue(errors.get(0).contains("is not above and to the left of bottom right point"));
    }

    @Test
    public void rectangle_with_points_on_same_x_has_error() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(
            new Point(1, 3),
            new Point(1, 1)
        );

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertFalse(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertEquals(1, errors.size());
        Assertions.assertTrue(errors.get(0).contains("is not above and to the left of bottom right point"));
    }

    @Test
    public void rectangle_with_points_on_same_y_has_error() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(
            new Point(1, 1),
            new Point(3, 1)
        );

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertFalse(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertEquals(1, errors.size());
        Assertions.assertTrue(errors.get(0).contains("is not above and to the left of bottom right point"));
    }

    @Test
    public void rectangle_with_switched_points_has_error() {
        // Prepare
        RectangleValidator validator = new RectangleValidator();
        Rectangle rect = new Rectangle(
            new Point(3, 2),
            new Point(1, 4)
        );

        // Test
        ValidationResult valid = validator.validate(rect);

        // Verify
        Assertions.assertFalse(valid.is_valid());
        List<String> errors = valid.get_errors();
        Assertions.assertEquals(1, errors.size());
        Assertions.assertTrue(errors.get(0).contains("is not above and to the left of bottom right point"));
    }
}
