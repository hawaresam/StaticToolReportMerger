package com.philips;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

import com.philips.action.MergeFiles;
import com.philips.model.Tool;
import org.junit.Test;

public class MergeFilesTest 
{
    //correct
    @Test
    public void mergeFilesSuccessfully() {
        ArrayList<Tool> toolarray=new ArrayList<Tool>();
        MergeFiles mergeFilesObj=new MergeFiles();
        String exePath="\"toolExeFile\" -d \"inputFile\" -R rulesets/java/quickstart.xml -f text > outputFile";
        Tool toolObj=new Tool();
        toolObj.settoolName("PMD");
        toolObj.setinputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/testFiles");
        toolObj.setoutputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/Test.java");
        toolObj.settoolExeFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/staticAnalysisTools/pmd-bin-6.16.0/bin/pmd.bat");
        toolObj.setCommand(exePath);

        toolarray.add(toolObj);

        toolObj=new Tool();
        toolObj.settoolName("Checkstyle");
        toolObj.setinputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/testFiles");
        toolObj.setoutputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/Transpose.java");
        toolObj.settoolExeFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/staticAnalysisTools/checkstyle-8.22-all.jar");
        toolObj.setCommand("cmd /c \"java -jar \"toolExeFile\" -c /sun_checks.xml \"inputFile\" > outputFile\"");

        toolarray.add(toolObj);

        boolean existsfile=mergeFilesObj.mergefiles(toolarray);

        assertTrue("Merged files successfully", existsfile );
        System.out.println("Merged files successfully");
    }


    public void mergeFilesNotSuccessfully() {
        ArrayList<Tool> toolarray=new ArrayList<Tool>();
        MergeFiles mergeFilesObj=new MergeFiles();
        String exePath="\"toolExeFile\" -d \"inputFile\" -R rulesets/java/quickstart.xml -f text > outputFile";
        Tool toolObj=new Tool();
        toolObj.settoolName("PMD");
        toolObj.setinputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/testFiles");
        toolObj.setoutputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/Test123.java");
        toolObj.settoolExeFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/staticAnalysisTools/pmd-bin-6.16.0/bin/pmd.bat");
        toolObj.setCommand(exePath);

        toolarray.add(toolObj);

        toolObj=new Tool();
        toolObj.settoolName("Checkstyle");
        toolObj.setinputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/testFiles");
        toolObj.setoutputFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/Transpose123.java");
        toolObj.settoolExeFile("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/staticAnalysisTools/checkstyle-8.22-all.jar");
        toolObj.setCommand("cmd /c \"java -jar \"toolExeFile\" -c /sun_checks.xml \"inputFile\" > outputFile\"");

        toolarray.add(toolObj);

        boolean existsfile=mergeFilesObj.mergefiles(toolarray);

        assertFalse("Merged files not successfully", existsfile );
        System.out.println("Merged files not successfully");
    }

}
