package com.philips.action;

import java.io.File;

public class ValidateCommand
{
    public boolean validateFileIsPresent(String filename)
    {
        File tempFile=new File(filename);
        boolean exists = tempFile.exists();
        return exists;
    }
    public boolean validateFileShouldBeSpecified(String filename)
    {
        if(filename.equals(null) || filename.equals("")){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean validateFileFormatIsCorrect(String filename)
    {
        File tempFile = new File(filename);
        if(tempFile.getName().toLowerCase().endsWith(".txt"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}