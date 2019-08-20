Prerequisites :
	1) Make sure that you have pmd.bat and checkstyle jar file.
	2) Open the config.properties file 
	3) Change the directory of toolExeFile of both the tools (line no 2 and 7). Give the path where the Tool's folder is located in your machine.
	4) Change the directory of toolInputFile according to your choice.
	5) Save the changes.
	6) You can add more static tool analysis tools in this config file.

Instructions for compiling :
	Run the AutoBuildTest.bat batch file.

Output :
	1) Go to the target folder inside the main project folder.
	2) outputPMD.txt consists of the output given by the PMD tool.
	3) outputCheckstylt.txt consists of the output given by the Checkstyle tool.
	4) finalOutput.txt consists of the combined output of both tools. 

About the files :
	1) config.properties is the main properties file which consists of the tool information.
	2) congif1.properties,finalOutput.txt,testingOutputFile.txt,Transpose.txt,Test.txt are dummy files meant for running the test cases.	
	3) In order to run the test cases, go to the test folder in the src folder. Change the paths given in the test class files. Run "mvn test" prior to that.
