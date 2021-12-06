package cimorell.nv.analyzer;

import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;

/**
 * Interface for rectangle analyzers, which can analyze two rectangles to test if they meet various conditions.
 */
public interface RectangleAnalyzer {
    AnalysisResult analyze(Rectangle rectangle1, Rectangle rectangle2);
}
