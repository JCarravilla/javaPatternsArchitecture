package com.jca.javaPatternsArchitecture.commands;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ HELP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~ -Type 'help' to print this information.                                                  ~");
        System.out.println("~ -Type 'exit' to stop the program.                                                        ~");
        System.out.println("~ -Type 'areaByPoint x y' to print the shapes that contains the point (x,y) and its areas. ~");
        System.out.println("~ -Type a shape name and its params to add a new shape with this values.                   ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
