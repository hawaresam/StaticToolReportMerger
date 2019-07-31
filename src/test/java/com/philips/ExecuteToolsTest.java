package com.philips;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.philips.model.Tool;
import com.philips.action.ExecuteTools;
import org.junit.Test;

public class ExecuteToolsTest 
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
        ExecuteTools executeTools=new ExecuteTools();
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
        ExecuteTools executeTools=new ExecuteTools();
        boolean status = executeTools.executetool(toolObj);
        assertFalse("Command not run successfully", status );
        System.out.println("Command not run successfully");
    }
}
