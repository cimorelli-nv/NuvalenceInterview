package cimorell.nv.model;

/**
 * Represents the result of running analysis logic. Includes a boolean (meets or does not meet conditions), and a string
 * which describes the result, if applicable.
 */
public class AnalysisResult {
    private boolean _meetsCondition;
    public boolean get_meetsCondition() {
        return _meetsCondition;
    }
    public void set_meetsCondition(boolean _meetsCondition) {
        this._meetsCondition = _meetsCondition;
    }

    private String _description;
    public String get_description() {
        return _description;
    }
    public void set_description(String _description) {
        this._description = _description;
    }

    public AnalysisResult(boolean meetsCondition, String description) {
        this._meetsCondition = meetsCondition;
        this._description = description;
    }

    public AnalysisResult(boolean meetsCondition) {
        this._meetsCondition = meetsCondition;
        this._description = null;
    }
}
