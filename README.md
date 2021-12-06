# Nuvalence Interview
Coding exercise - "Rectangles Programming Sample"

## Description
This program will take in two rectangles (see Usage below for details), and will analyze them to check for any
intersections between the two, for either rectangle containing the other, or for any type of adjacency between the two.

## Sample Execution
### Inputs
* Rectangle 1: lower left corner (2,1), upper right (4,3)
* Rectangle 2: lower left corner (3,2), upper right (5,4)

Visualization:
```
           R2
     ┌────┐
   ┌─┼──┐ │
   │ └──┼─┘
   └────┘
 R1
```

### Output
```
Comparing two rectangles
        Rectangle 1: {(2,1) to (4,3)}
        Rectangle 2: {(3,2) to (5,4)}
Intersection: Rectangles do intersect
Containment:
        Rectangle 1 does not contain rectangle 2
        Rectangle 2 does not contain rectangle 1
Adjacency: Rectangles are not adjacent
```

## Usage
Call the Main class (i.e. `java cimorell.nv.Main`) with 8 numerical (double) arguments which describe two rectangles.
The rectangles are each described by two pairs of coordinates; the lower left corner, and the upper right corner. So a
single rectangle whose lower left corner is at (2,1) and whose upper right corner is at (4,3) could be described with
four numbers: 2, 1, 4, 3. In this way, two rectangles can be described with eight numerical arguments.

E.g. `java cimorell.nv.Main 2 1 4 3 3 2 5 4` will run the program for rectangle 1 at (2,1) to (4,3), and rectangle 2 at
(3,2) to (5,4).

## External Libraries
* JUnit 5.7.0 - used for unit testing

## Java Version
* Java 11 (specifically Amazon Corretto 11.0.13)

## Problem Description
You are required to write code in the language of your choice implementing certain algorithms that
analyze rectangles and features that exist among rectangles. Your implementation is required to cover
the following:

1. **Intersection:** You must be able to determine whether two rectangles have one or more intersecting lines and
produce a result identifying the points of intersection. For your convenience, the scenario is diagrammed in
Appendix 1.
2. **Containment:** You must be able to determine whether a rectangle is wholly contained within another rectangle.
For your convenience, the scenario is diagrammed in Appendix 2.
3. **Adjacency:** Implement the ability to detect whether two rectangles are adjacent. Adjacency is defined as the
sharing of at least one side. Side sharing may be proper, sub-line or partial. A sub-line share is a share where one
side of rectangle A is a line that exists as a set of points wholly contained on some other side of rectangle B, where
partial is one where some line segment on a side of rectangle A exists as a set of points on some side of Rectangle B.
For your convenience, these scenarios are diagrammed in Appendix 3.

### Your Submission Must Include
1. An implementation of the rectangle entity as well as implementations for the algorithms that define the operations
listed above.
2. Appropriate documentation
3. Test cases/unit tests

Feel free to expand on this problem as you wish. Document any expansion and provide it as part of your submission. Your
submitted source code must compile (if necessary) and the resulting executable must run on Linux. Please document any
library or framework dependencies.

### Appendices
*See "Rectangles Programming Sample.pdf" for full problem description and appendices*
