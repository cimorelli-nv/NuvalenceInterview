package cimorell.nv;

import cimorell.nv.analyzer.RectangleAdjacencyAnalyzer;
import cimorell.nv.analyzer.RectangleContainmentAnalyzer;
import cimorell.nv.analyzer.RectangleIntersectionAnalyzer;
import cimorell.nv.model.AnalysisResult;
import cimorell.nv.model.Rectangle;
import cimorell.nv.model.ValidationResult;
import cimorell.nv.validation.RectangleValidator;

/**
 * The main entry point for the Nuvalence Interview package, which is capable of comparing two rectangles to check for
 * intersection, containment, and adjacency.
 */
public class Main {
    private static final String HELP_OUTPUT =
        "This program will accept the coordinates for two rectangles, and output an analysis of their\n" +
        "intersections, containment, and adjacency.\n" +
        "\n" +
        "Args should be passed by providing the coordinates of the bottom left corner and upper right corner of\n" +
        "each rectangle. For example, if you have one rectangle whose bottom left corner is at 0,0 and whose\n" +
        "upper right corner is at 3,3, and a second rectangle at 1,2 and 4,7, then your args would be:\n" +
        "0 0 3 3 1 2 4 7";

    public static void main(String[] args) {
        // Read rectangles' coordinates from args array
        if (args.length != 8) {
            System.out.println(
                "Invalid or missing arguments; please provide the coordinates for two rectangles to compare"
            );
            printHelp();
            return;
        }
        double[] coordinates = new double[8];
        for (int i = 0; i < 8; i++) {
            try {
                coordinates[i] = Double.parseDouble(args[i]);
            } catch (Exception ex) {
                System.out.println("Invalid argument; could not parse " + args[i] + " as a number");
                printHelp();
                return;
            }
        }

        // Build rectangles from coordinates
        Rectangle r1 = new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        Rectangle r2 = new Rectangle(coordinates[4], coordinates[5], coordinates[6], coordinates[7]);

        // Validate rectangles
        RectangleValidator validator = new RectangleValidator();
        ValidationResult r1Valid = validator.validate(r1);
        ValidationResult r2Valid = validator.validate(r2);
        if (!r1Valid.is_valid() || !r2Valid.is_valid()) {
            if (!r1Valid.is_valid()) {
                System.out.println(
                    "Invalid argument: rectangle 1 is not a valid rectangle: " +
                        String.join(", ", r1Valid.get_errors())
                );
            }
            if (!r2Valid.is_valid()) {
                System.out.println(
                    "Invalid argument: rectangle 2 is not a valid rectangle: " +
                        String.join(", ", r2Valid.get_errors())
                );
            }

            printHelp();
            return;
        }

        System.out.println("Comparing two rectangles");
        System.out.println("\tRectangle 1: " + r1);
        System.out.println("\tRectangle 2: " + r2);

        // Compare rectangles:

        //     Intersection
        RectangleIntersectionAnalyzer intersectionAnalyzer = new RectangleIntersectionAnalyzer();
        AnalysisResult intersectionAnalysisResult = intersectionAnalyzer.analyze(r1, r2);
        System.out.println(
            "Intersection: Rectangles do " +
                (intersectionAnalysisResult.get_meetsCondition() ? "" : "not ") +
                "intersect"
        );

        //     Containment
        RectangleContainmentAnalyzer containmentAnalyzer = new RectangleContainmentAnalyzer();
        System.out.println("Containment:");
        AnalysisResult containmentAnalysisResult1 = containmentAnalyzer.analyze(r1, r2);
        System.out.println(
            "\tRectangle 1 does " +
                (containmentAnalysisResult1.get_meetsCondition() ? "" : "not ") +
                "contain rectangle 2"
        );
        AnalysisResult containmentAnalysisResult2 = containmentAnalyzer.analyze(r2, r1);
        System.out.println(
            "\tRectangle 2 does " +
                (containmentAnalysisResult2.get_meetsCondition() ? "" : "not ") +
                "contain rectangle 1"
        );

        //     Adjacency
        RectangleAdjacencyAnalyzer adjacencyAnalyzer = new RectangleAdjacencyAnalyzer();
        AnalysisResult adjacencyAnalysisResult = adjacencyAnalyzer.analyze(r1, r2);
        System.out.println(
            "Adjacency: Rectangles are " +
                (adjacencyAnalysisResult.get_meetsCondition() ? "" : "not ") +
                "adjacent" +
                (adjacencyAnalysisResult.get_meetsCondition()
                    ? (". Adjacency type(s): " + adjacencyAnalysisResult.get_description())
                    : "")
        );
    }

    private static void printHelp() {
        System.out.println();
        System.out.println(HELP_OUTPUT);
    }
}
