package com.philips.model;

public class Tool
{
    String toolName;
    String toolExeFile;
    String inputFile;
    String outputFile;
    String command;

    public String gettoolName() {
        return toolName;
    }

    public void settoolName(String toolName) {
        this.toolName = toolName;
    }

    public String gettoolExeFile() {
        return toolExeFile;
    }

    public void settoolExeFile(String toolExeFile) {
        this.toolExeFile = toolExeFile;
    }

    public String getinputFile() {
        return inputFile;
    }

    public void setinputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getoutputFile() {
        return outputFile;
    }

    public void setoutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    
}