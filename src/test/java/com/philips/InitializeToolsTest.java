package com.philips;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;

import com.philips.model.Tool;
import com.philips.action.InitializeTools;
import org.junit.Test;

public class InitializeToolsTest 
{
    //correct
    @Test
    public void congifFileIsNotInSpecifiedFormat() {
        InitializeTools initializeToolsObj=new InitializeTools();

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
            InitializeTools initializeToolsObj=new InitializeTools();
    
            ArrayList<Tool> toolobj=initializeToolsObj.initializetool("C:/Users/320065418/OneDrive - Philips/Desktop/Case Study/FirstProject/config.properties");
            boolean status=false;
    
            if(toolobj!=null)
                status=true;
    
            assertTrue("Congif file is in correct format", status );
            System.out.println("Config file is in correct format");
        }

}
