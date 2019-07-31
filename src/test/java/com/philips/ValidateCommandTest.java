package com.philips;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.philips.action.ValidateCommand;
import com.philips.model.Tool;
import org.junit.Test;

public class ValidateCommandTest 
{
    //correct
    @Test
    public void outputFileShouldBeInSpecifiedFormat() {
        Tool tobject=new Tool();
        ValidateCommand vobject=new ValidateCommand();

        tobject.setoutputFile("testingOutputFile.txt");
        boolean existsfile=vobject.validateFileFormatIsCorrect(tobject.getoutputFile());

        assertTrue("Output file is in correct format", existsfile );
        System.out.println("Output is in correct format");
    }
        //correct
        @Test
        public void outputFileIsNotBeInSpecifiedFormat() {
            Tool tobject=new Tool();
            ValidateCommand vobject=new ValidateCommand();
    
            tobject.setoutputFile("testingOutputFile.java");
            boolean existsfile=vobject.validateFileFormatIsCorrect(tobject.getoutputFile());
    
            assertFalse("Output file is not in correct format", existsfile );
            System.out.println("Output is not in correct format");
        }

    //correct
    @Test
    public void inputFileShouldBePresent() {
        Tool tobject=new Tool();
        ValidateCommand vobject=new ValidateCommand();

        tobject.setinputFile("Transpose.java");
        boolean exists=vobject.validateFileIsPresent(tobject.getinputFile());

        assertTrue("Input folder is present", exists );
        System.out.println("Input folder is present");
    }
        //correct
        @Test
        public void inputFileIsNotPresent() {
            Tool tobject=new Tool();
            ValidateCommand vobject=new ValidateCommand();
    
            tobject.setinputFile("Transpose123.java");
            boolean exists=vobject.validateFileIsPresent(tobject.getinputFile());
    
            assertFalse("Input folder is not present", exists );
            System.out.println("Input folder is not present");
        }

    //correct
    @Test
    public void outputFileShouldBeSpecified() {
        Tool tobject=new Tool();
        ValidateCommand vobject=new ValidateCommand();

        tobject.setoutputFile("outputPMD.txt");
        boolean status=vobject.validateFileShouldBeSpecified(tobject.getoutputFile());

        assertTrue("Output file specified ", status );
        System.out.println("Output file specified");
    }
    @Test
    public void outputFileIsNotSpecified() {
        Tool tobject=new Tool();
        ValidateCommand vobject=new ValidateCommand();

        tobject.setoutputFile("");
        boolean status=vobject.validateFileShouldBeSpecified(tobject.getoutputFile());

        assertFalse("Output file is not specified ", status );
        System.out.println("Output file is not specified");
    }

    //correct
    @Test
    public void exeFileShouldBePresent() {
        Tool tobject=new Tool();
        ValidateCommand vobject=new ValidateCommand();

        tobject.settoolExeFile("C:/Users/320065418/Downloads/pmd-bin-6.16.0/pmd-bin-6.16.0/bin/pmd.bat");
        boolean exists=vobject.validateFileIsPresent(tobject.gettoolExeFile());

        assertTrue("Exe file present ", exists );
        System.out.println("Exe file present");
    }

    @Test
    public void exeFileIsNotPresent() {
        Tool tobject=new Tool();
        ValidateCommand vobject=new ValidateCommand();

        tobject.settoolExeFile("C:/Users/320065418/Downloads/pmd-bin-6.16.0/pmd-bin-6.16.0/pmd.bat");
        boolean exists=vobject.validateFileIsPresent(tobject.gettoolExeFile());

        assertFalse("Exe file is not present ", exists );
        System.out.println("Exe file is not present");
    }

}
