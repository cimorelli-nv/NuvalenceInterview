package cimorell.nv.validation;

import cimorell.nv.model.Rectangle;
import cimorell.nv.model.ValidationResult;

/**
 * Validates Rectangle objects, checking that their points form a valid rectangle.
 */
public class RectangleValidator {
    /**
     * Check if the rectangle is valid; requires that both points be set (not null) and that the bottom left point is
     * below and to the left of the top right point.
     */
    public ValidationResult validate(Rectangle rectangle) {
        ValidationResult valid = new ValidationResult(true);

        // Make sure both points are set (not null)
        if (rectangle.get_bottomLeftPoint() == null) {
            valid.set_valid(false);
            valid.addError("Bottom left point is null");
        }
        if (rectangle.get_topRightPoint() == null) {
            valid.set_valid(false);
            valid.addError("Top right point is null");
        }
        if (!valid.is_valid()) {
            return valid;
        }

        // If both points are set, make sure the bottom left is below and left of the top right
        if (
            rectangle.get_bottomLeftPoint().get_x() >= rectangle.get_topRightPoint().get_x()
                || rectangle.get_bottomLeftPoint().get_y() >= rectangle.get_topRightPoint().get_y()
        ) {
            valid.set_valid(false);
            valid.addError(
                "Bottom left point "
                    + rectangle.get_bottomLeftPoint()
                    + " is not below and to the left of top right point "
                    + rectangle.get_topRightPoint()
            );
        }

        return valid;
    }
}
