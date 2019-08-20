package com.philips;

import java.util.ArrayList;

import com.philips.model.Tool;
import com.philips.action.HelperClass;

public class App 
{
    public static void main( String[] args )
    {
        String configPath=args[0];

        ArrayList<Tool> toolobj;
        Tool toolobject=new Tool();

        toolobj=toolobject.initializetool(configPath);

        if(toolobj!=null)
        {
            for(int i=0;i<toolobj.size();i++)
            {
                boolean valid=HelperClass.validate(toolobj.get(i));

                
                if(valid==true)
                {
                    toolobject.executetool(toolobj.get(i));
                }
                else
                {
                    System.out.println("There is something wrong with the instructions in your config file");
                }
            }
    
            HelperClass.mergefiles(toolobj);
        }
        else
        {
            System.out.println("The config file is not in the proper format. Check the sample format for reference.");
        }

    }
}
