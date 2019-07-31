package com.philips.action;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

import com.philips.model.Tool;

public class MergeFiles
{
    public boolean mergefiles(ArrayList<Tool> toolobj)
    {
        try
        {
            // File finalOutput = new File("C:/Users/320065418/Downloads/finalOutput.txt");
            File finalOutput = new File("finalOutput.txt");
            finalOutput.createNewFile(); 

            PrintWriter pw = new PrintWriter(finalOutput); 
            int status=0;

            for(int i=0;i<toolobj.size();i++)
            {
                BufferedReader br1 = new BufferedReader(new FileReader(toolobj.get(i).getoutputFile()));

                pw.println("\n");
                pw.println(toolobj.get(i).gettoolName()+" output: ");
                pw.println("\n");

                String line1 = br1.readLine(); 
                while (line1 != null) 
                { 
                    status=1;
                    if(line1 != null) 
                        { 
                                pw.println(line1); 
                               line1 = br1.readLine(); 
                        } 
                } 

                pw.flush(); 
                br1.close(); 
            }

            if(status==1)
            {
                pw.println("\n");
                pw.println("\n");
                pw.println("Program ends with exit code 0. ");
                pw.println("\n");
                pw.println("Please refer to the errors and make corrections.");
                System.err.println("\n\nProgram ends with error code 0. Refer to finalOutput.txt in target folder for details.");
            }
            else
            {
                pw.println("\n");
                pw.println("\n");
                pw.println("Program ends with exit code 1.");
                pw.println("\n");
                pw.println("\n\nThere are no errors or warnings in the code.");
            }
            pw.close(); 
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}