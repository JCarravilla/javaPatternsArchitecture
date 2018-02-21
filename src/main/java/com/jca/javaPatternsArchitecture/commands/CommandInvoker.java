package com.jca.javaPatternsArchitecture.commands;

public final class CommandInvoker {
    private Command command;

    public void addCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}
