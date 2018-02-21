# Java programming test

## Goal
Build an interactive console application that accepts these online commands:
1. Help.
1. Exit.
1. Add a Shape.
1. And print all the shapes that contains a point and sum its areas.

The Add a Shape command must add a shape in a memory structure given a unique
id. It is important to ensure that the input values, both in number of args as
type of value (all the numeric values must be Double). When a new shape is added
we must print a line with the id, the kind of figure and its params.
The following are valid inputs:

+ circle 1.7 -5.05 6.9
+ square 3.55 4.1 2.77
+ rectangle 3.5 2.0 5.6 7.2
+ triangle 4.5 1 -2.5 -33 23 0.3
+ donut 4.5 7.8 1.5 1.8

Where a circle is defined  by its center x and y and a radius. Square by
its left-lower vertex and a side length. Rectangle by its left-lower vertex
and both side length (lets consider it lays over its longest side). Triangle
by its three vertices x and y. Donut by its center x and y and its two radius.

The "print all shapes that contains a point" command, must do that. Given a
point print all the shapes that contains it as well its area. Finally it
must print the sum of all these shapes.

As additional requirements, we could send a file with figures / commands
when we launch the app that must be processed (there are an example in
resources).


## Solution explained
The solution was designed by applying three design patterns:

1. Singleton pattern. Both in the ShapeId generator as in the shape handler,
to ensure there are only one class instance.
1. Factory pattern. To build the shapes.
1. Command pattern. To launch the different commands the interface accepts.

Taking advantage of java 8 parallel streams I ensure a great performance
with a big number of inputs when perform the command "shapes that contains
a point".

## How run the app
1. Build the jar file with mvn package
2. java -jar javaPatternsArchitecture-jar-with-dependencies.jar [PATH_TO_SHAPE_BULK_FILE]
3. Type help to print a help page.
