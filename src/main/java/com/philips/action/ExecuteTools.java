package com.philips.action;

import com.philips.model.Tool;

public class ExecuteTools
{
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