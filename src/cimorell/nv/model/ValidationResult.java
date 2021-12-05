package cimorell.nv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the result of running validation logic. Includes a boolean (valid or not valid), and a list of strings
 * which contains validations errors, if there were any.
 */
public class ValidationResult {
    private boolean _valid;

    public boolean is_valid() {
        return _valid;
    }

    public void set_valid(boolean _valid) {
        this._valid = _valid;
    }

    private List<String> _errors;

    public List<String> get_errors() {
        return _errors;
    }

    public void set_errors(List<String> _errors) {
        this._errors = _errors;
    }

    public ValidationResult(boolean valid, List<String> errors) {
        this._valid = valid;
        this._errors = errors;
    }

    public ValidationResult(boolean valid) {
        this._valid = valid;
        this._errors = new ArrayList<>();
    }

    /**
     * Helper method to add an error message to the list of errors. If the list of errors has not been initialized, will
     * automatically initialize the list and then add the error.
     *
     * @param error The new validation error message to add to the list of errors.
     */
    public void addError(String error) {
        if (_errors == null) {
            _errors = new ArrayList<>(1);
        }
        _errors.add(error);
    }

    @Override
    public String toString() {
        return (_valid ? "Valid" : "Not valid")
            + (
                _errors != null && _errors.size() > 0
                    ? (": [" + String.join("; ", _errors) + "]")
                    : ""
            );
    }
}
