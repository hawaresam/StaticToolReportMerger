package com.philips;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

import com.philips.action.HelperClass;
import com.philips.model.Tool;
import org.junit.Test;

public class HelperClassTest 
{
    @Test
    public void mergeFilesSuccessfully() {
        ArrayList<Tool> toolarray=new ArrayList<Tool>();
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

        boolean existsfile=HelperClass.mergefiles(toolarray);

        assertTrue("Merged files successfully", existsfile );
        System.out.println("Merged files successfully");
    }

    @Test
    public void mergeFilesNotSuccessfully() {
        ArrayList<Tool> toolarray=new ArrayList<Tool>();
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

        boolean existsfile=HelperClass.mergefiles(toolarray);

        assertFalse("Merged files not successfully", existsfile );
        System.out.println("Merged files not successfully");
    }

    @Test
    public void outputFileShouldBeInSpecifiedFormat() {
        Tool tobject=new Tool();

        tobject.setoutputFile("testingOutputFile.txt");
        boolean existsfile=HelperClass.validateFileFormatIsCorrect(tobject.getoutputFile());

        assertTrue("Output file is in correct format", existsfile );
        System.out.println("Output is in correct format");
    }
        //correct
        @Test
        public void outputFileIsNotBeInSpecifiedFormat() {
            Tool tobject=new Tool();
    
            tobject.setoutputFile("testingOutputFile.java");
            boolean existsfile=HelperClass.validateFileFormatIsCorrect(tobject.getoutputFile());
    
            assertFalse("Output file is not in correct format", existsfile );
            System.out.println("Output is not in correct format");
        }

    //correct
    @Test
    public void inputFileShouldBePresent() {
        Tool tobject=new Tool();

        tobject.setinputFile("Transpose.java");
        boolean exists=HelperClass.validateFileIsPresent(tobject.getinputFile());

        assertTrue("Input folder is present", exists );
        System.out.println("Input folder is present");
    }
        //correct
        @Test
        public void inputFileIsNotPresent() {
            Tool tobject=new Tool();
    
            tobject.setinputFile("Transpose123.java");
            boolean exists=HelperClass.validateFileIsPresent(tobject.getinputFile());
    
            assertFalse("Input folder is not present", exists );
            System.out.println("Input folder is not present");
        }

    //correct
    @Test
    public void outputFileShouldBeSpecified() {
        Tool tobject=new Tool();

        tobject.setoutputFile("outputPMD.txt");
        boolean status=HelperClass.validateFileShouldBeSpecified(tobject.getoutputFile());

        assertTrue("Output file specified ", status );
        System.out.println("Output file specified");
    }
    @Test
    public void outputFileIsNotSpecified() {
        Tool tobject=new Tool();

        tobject.setoutputFile("");
        boolean status=HelperClass.validateFileShouldBeSpecified(tobject.getoutputFile());

        assertFalse("Output file is not specified ", status );
        System.out.println("Output file is not specified");
    }

    //correct
    @Test
    public void exeFileShouldBePresent() {
        Tool tobject=new Tool();

        tobject.settoolExeFile("C:/Users/320065418/Downloads/pmd-bin-6.16.0/pmd-bin-6.16.0/bin/pmd.bat");
        boolean exists=HelperClass.validateFileIsPresent(tobject.gettoolExeFile());

        assertTrue("Exe file present ", exists );
        System.out.println("Exe file present");
    }

    @Test
    public void exeFileIsNotPresent() {
        Tool tobject=new Tool();

        tobject.settoolExeFile("C:/Users/320065418/Downloads/pmd-bin-6.16.0/pmd-bin-6.16.0/pmd.bat");
        boolean exists=HelperClass.validateFileIsPresent(tobject.gettoolExeFile());

        assertFalse("Exe file is not present ", exists );
        System.out.println("Exe file is not present");
    }

}
