package com.philips.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths; 
import java.io.IOException;
import java.util.Iterator;
import java.nio.charset.*;

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


    public ArrayList<Tool> initializetool(String configPath)
    {
        ArrayList<Tool> toolObj=new ArrayList<Tool>();
        List<String> lines = Collections.emptyList(); 

        String delimiter="=";
        int flag=0;

        try
        { 
          lines = Files.readAllLines(Paths.get(configPath), StandardCharsets.UTF_8); 
          Iterator<String> itr = lines.iterator(); 

          while (itr.hasNext()) 
          {
              Tool tObject=new Tool();

              String[] s=itr.next().split(delimiter);
              if(s[0].equals("toolName"))
                tObject.settoolName(s[1]);
              else
              {
                  flag=1;
                  System.out.println("not a toolName");
              }

              s=itr.next().split(delimiter);
              if(s[0].equals("toolExeFile"))
                tObject.settoolExeFile(s[1]);
              else
              {
                  flag=1;
                  System.out.println("not a toolExeFile");
              }

              s=itr.next().split(delimiter);
              if(s[0].equals("toolInputFile"))
                tObject.setinputFile(s[1]);
              else
              {
                flag=1;
                System.out.println("not a toolInputFile");
              }

              s=itr.next().split(delimiter);
              if(s[0].equals("toolOutputFile"))
                tObject.setoutputFile(s[1]);
              else
              {
                  flag=1;
                  System.out.println("not a toolOutputFile");
              }
              
              s=itr.next().split(delimiter);
              if(s[0].equals("toolCommand"))
                tObject.setCommand(s[1]);
              else
              {
                  flag=1;
                  System.out.println("not a toolCommand");
              }

              toolObj.add(tObject);
            }
        } 
        catch (IOException e) 
        { 
          e.printStackTrace(); 
        } 

        if(flag==1)
            return null;
        else
            return toolObj;
    }

    public boolean executetool(Tool toolObj)
    {
        String finalCommand=toolObj.getCommand();

        if(finalCommand.contains("toolExeFile") && toolObj.gettoolExeFile()!=null)
        {
            finalCommand=toolObj.getCommand().replace("toolExeFile", toolObj.gettoolExeFile());
            finalCommand=finalCommand.replace("inputFile", toolObj.getinputFile());
            finalCommand=finalCommand.replace("outputFile", toolObj.getoutputFile());
    
            try
            {
                Process processObj=Runtime.getRuntime().exec(finalCommand);
                System.out.println("\n\nWaiting for process of the tool: "+toolObj.gettoolName());
                processObj.waitFor();
                return true;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return false;
            }
        }
        else
        {
            System.out.println("EXE file not specified in the command");
            return false;
        }
    }
    
}