package com.philips;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.philips.model.Tool;
import org.junit.Test;
import java.util.ArrayList;

public class ToolTest 
{
    //correct
    @Test
    public void commandRunSuccessfully() {
        String exePath="\"toolExeFile\" -d \"inputFile\" -R rulesets/java/quickstart.xml -f text > outputFile";
        Tool toolObj=new Tool();
        toolObj.settoolName("PMD");
        toolObj.setinputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/testFiles");
        toolObj.setoutputFile("outputPMD.txt");
        toolObj.settoolExeFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/staticAnalysisTools/pmd-bin-6.16.0/bin/pmd.bat");
        toolObj.setCommand(exePath);
        Tool executeTools=new Tool();
        boolean status = executeTools.executetool(toolObj);
        assertTrue("Command run successfully", status );
        System.out.println("Command run successfully");
    }

    @Test
    public void commandNotRunSuccessfully() {
        String exePath="\"toolExeFile\" -d \"inputFile\" -R rulesets/java/quickstart.xml -f text > outputFile";
        Tool toolObj=new Tool();
        toolObj.settoolName("PMD");
        toolObj.setinputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/testFiles");
        toolObj.setoutputFile("outputPMD.txt");
        toolObj.settoolExeFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/staticAnalysisTools/pmd-bin-6.16.0/pmd.bat");
        toolObj.setCommand(exePath);
        Tool executeTools=new Tool();
        boolean status = executeTools.executetool(toolObj);
        assertFalse("Command not run successfully", status );
        System.out.println("Command not run successfully");
    }

    @Test
    public void congifFileIsNotInSpecifiedFormat() {
        Tool initializeToolsObj=new Tool();

        ArrayList<Tool> toolobj=initializeToolsObj.initializetool("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/congif1.properties");
        boolean status=false;

        if(toolobj!=null)
            status=true;

        assertFalse("Congif file is not in correct format", status );
        System.out.println("Config file is not in correct format");
    }

        //correct
        @Test
        public void congifFileIsInSpecifiedFormat() {
            Tool initializeToolsObj=new Tool();
    
            ArrayList<Tool> toolobj=initializeToolsObj.initializetool("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/config.properties");
            boolean status=false;
    
            if(toolobj!=null)
                status=true;
    
            assertTrue("Config file is in correct format", status );
            System.out.println("Config file is in correct format");
        }
}
