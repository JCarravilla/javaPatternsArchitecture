package com.jca.javaPatternsArchitecture.commands;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
