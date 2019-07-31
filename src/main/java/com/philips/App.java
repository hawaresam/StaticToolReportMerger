package com.philips;

import java.util.ArrayList;

import com.philips.model.Tool;
import com.philips.action.InitializeTools;
import com.philips.action.ExecuteTools;
import com.philips.action.ValidateCommand;
import com.philips.action.MergeFiles;

public class App 
{
    public static void main( String[] args )
    {
        String configPath=args[0];

        ArrayList<Tool> toolobj;
        InitializeTools initializeobj=new InitializeTools();
        ExecuteTools executeobj=new ExecuteTools();
        ValidateCommand validateobj=new ValidateCommand();

        //initializing the arraylist which contains all the tools
        toolobj=initializeobj.initializetool(configPath);

        if(toolobj!=null)
        {
            for(int i=0;i<toolobj.size();i++)
            {
                boolean statusOfExeFile=validateobj.validateFileIsPresent(toolobj.get(i).gettoolExeFile());
                boolean inputFolderIsPresent=validateobj.validateFileIsPresent(toolobj.get(i).getinputFile());
                boolean outputFileShouldBeSpecified=validateobj.validateFileShouldBeSpecified(toolobj.get(i).getoutputFile());
                boolean outputFileFormat=validateobj.validateFileFormatIsCorrect(toolobj.get(i).getoutputFile());
                
                if(statusOfExeFile==true && inputFolderIsPresent==true && outputFileShouldBeSpecified==true && outputFileFormat==true)
                {
                    boolean processStatus = executeobj.executetool(toolobj.get(i));
                }
                else
                {
                    System.out.println("There is something wrong with the instructions in your config file");
                }
            }
    
            //merging the files
            MergeFiles mergeobject=new MergeFiles();
            boolean mergeStatus = mergeobject.mergefiles(toolobj);
        }
        else
        {
            System.out.println("The config file is not in the proper format. Check the sample format for reference.");
        }

    }
}
