package com.philips.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import com.philips.model.Tool;
import java.io.IOException;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files;
import java.nio.file.Paths; 

public class InitializeTools
{
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
}