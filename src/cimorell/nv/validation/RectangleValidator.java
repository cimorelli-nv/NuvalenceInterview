package cimorell.nv.validation;

import cimorell.nv.model.Rectangle;
import cimorell.nv.model.ValidationResult;

/**
 * Validates Rectangle objects, checking that their points form a valid rectangle.
 */
public class RectangleValidator {
    /**
     * Check if the rectangle is valid; requires that both points be set (not null) and that the top left point is
     * above and to the left of the bottom right point.
     */
    public ValidationResult validate(Rectangle rectangle) {
        ValidationResult valid = new ValidationResult(true);

        // Make sure both points are set (not null)
        if (rectangle.get_topLeftPoint() == null) {
            valid.set_valid(false);
            valid.addError("Top left point is null");
        }
        if (rectangle.get_bottomRightPoint() == null) {
            valid.set_valid(false);
            valid.addError("Bottom right point is null");
        }
        if (!valid.is_valid()) {
            return valid;
        }

        // If both points are set, make sure the top left is above and left of the bottom right
        if (
            rectangle.get_topLeftPoint().get_x() >= rectangle.get_bottomRightPoint().get_x()
                || rectangle.get_topLeftPoint().get_y() <= rectangle.get_bottomRightPoint().get_y()
        ) {
            valid.set_valid(false);
            valid.addError(
                "Top left point "
                    + rectangle.get_topLeftPoint()
                    + " is not above and to the left of bottom right point "
                    + rectangle.get_bottomRightPoint()
            );
        }

        return valid;
    }
}
