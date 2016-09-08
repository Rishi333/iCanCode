********************************
README I CAN CODE
********************************
This Readme will quickly explain how to get the program up and running in seconds.
CONTENTS
1. Scripts- Automation scripts that run our program in seconds
2. General Structure- Structure of program if you want to run in your own configuration
3. Symbol Table and ParseTree- How to print these structures (Default: Commented out)


********************************
SCRIPTS
********************************

There are two scripts run.sh and jasmin.sh. All Scripts should be run from the main directory of the project in which they are located.

NAME: run.sh
USE: To compile jjtree and javacc and then come back to the local directory
USAGE: Type in->  bash run.sh

NAME: jasmin.sh
USE: To compile the .j file and run the .class file!
USAGE: Type in-> bash jasmin.sh <NameOfProgram>
EXAMPLE: bash jasmin.sh Game
Note that there is not extention!


********************************
GENERAL STRUCTUE
********************************
The General structure of the program is categorized into four parts.
1. The src/ contains all the source code
2. The InputFiles/ contains all the .txt file that will serve as programs
3. The OutputFiles/ contains all the .class that can be run
4. The OutputFiles/InputFiles/ contains all the .j files that can be used to create class files

NOTE: If your are running the program without the scripts, make sure you include all three Jar files
- DataStruct.jar, PascalRTL.jar, Jasmin.jar
All three files are located in the Outfiles/ folder.

********************************
SYMBOLTABLE AND PARSETREE
*******************************

The symboltable and parsetree are by default commented out. If you want to include them as you compile the program, then uncomment lines in calc.jjt file.
 For the SymbolTable uncomment lines 54 and 55 in the calc.jjt file.
 For the ParseTree uncomment lines 67 and 68 in the calc.jjt file.
