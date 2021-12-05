package cimorell.nv;

import cimorell.nv.model.Point;
import cimorell.nv.model.Rectangle;
import cimorell.nv.model.ValidationResult;

/**
 * The main entry point for the Nuvalence Interview package, which is capable of comparing two rectangles to check for
 * intersection, containment, and adjacency.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Test 1");
        Point test1TL = new Point(1, 8);
        Point test1BR = new Point(3, 4);
        Rectangle test1 = new Rectangle(test1TL, test1BR);

        System.out.println("Top Left Point: " + test1TL);
        System.out.println("Bottom Right Point: " + test1BR);
        System.out.println("Rectangle: " + test1);
        ValidationResult valid1 = test1.validate();
        System.out.println("Validation result: " + valid1);

        test1TL.set_x(2);
        System.out.println("Rectangle after change: " + test1);

        System.out.println();
        System.out.println("Test 2");
        Rectangle test2 = new Rectangle(3, 8, 1, 4);
        System.out.println("Rectangle: " + test2);
        ValidationResult valid2 = test2.validate();
        System.out.println("Validation result: " + valid2);
    }
}
