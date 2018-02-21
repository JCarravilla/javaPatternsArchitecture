package com.jca.javaPatternsArchitecture;

import com.jca.javaPatternsArchitecture.utils.OperationException;
import com.jca.javaPatternsArchitecture.utils.ShapeCreationException;
import com.jca.javaPatternsArchitecture.commands.*;

import java.io.*;

public class JavaArchitectureApp {
    private static CommandInvoker cmdInvoker;

    public static void main(String[] args) throws IOException {
        System.out.println("==> Loading Java Architecture Test");
        cmdInvoker = new CommandInvoker();

        if(args.length > 0){
            System.out.println("==> Loading file of shapes");
            System.out.println(String.format("==> %d shapes loaded", loadShapesFile(args[0])));
        }

        System.out.println("==> Waiting for commands:");
        executeInterfaceLoop();
    }

    private static long loadShapesFile(String file){
        if(!file.equals("")){
            long count = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    processLine(line);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Error: The file doesn't exists.");
            } catch (IOException e) {
                System.out.println("Error: Can't load the file.");
            } finally {
                return count;
            }
        } else {
            return 0;
        }

    }

    private static void executeInterfaceLoop() throws IOException {
        boolean exit = false;
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        while(!exit){
            String line = bufferedReader.readLine();
            processLine(line);
        }
    }

    private static void processLine(String line){
        String[] input = line.split(" ");
        if(input.length == 0){
            System.out.println("==> Empty lines not allowed.");
        }  else {
            if(input[0].equals("exit")){
                executeCommand(new ExitCommand());
            }else if(input[0].equals("help")){
                executeCommand(new HelpCommand());
            }else if(input[0].equals("areaByPoint")){
                try {
                    executeCommand(new AreasByPointCommand(input));
                } catch (OperationException e) {
                    System.out.println(e.getMessage());
                }
            }else {
                try {
                    executeCommand(new AddShapeCommand(input));
                } catch (ShapeCreationException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void executeCommand(Command command){
        try{
            cmdInvoker.addCommand(command);
            cmdInvoker.executeCommand();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
