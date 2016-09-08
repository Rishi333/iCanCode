package wci.backend.compiler;

import java.util.ArrayList;
import java.io.*;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;
import wci.backend.*;

import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.symtabimpl.DefinitionImpl.*;
import wci.intermediate.typeimpl.TypeFormImpl;

/**
 * <p>
 * The code generator for a compiler back end.</p>
 *
 * <p>
 * Copyright (c) 2008 by Ronald Mak</p>
 * <p>
 * For instructional purposes only. No warranties.</p>
 */
public class CodeGenerator extends Backend
{

    private static final int STACK_LIMIT = 16;

    static ICode iCode;
    static SymTabStack symTabStack;
    static PrintWriter objectFile;

    /**
     * Process the intermediate code and the symbol table generated by the
     * parser to generate machine-language instructions.
     *
     * @param iCode the intermediate code.
     * @param symTabStack the symbol table stack.
     * @param objectFile the object file path for the generated code.
     * @throws Exception if an error occurred.
     */
    public void process(ICode iCode, SymTabStack symTabStack,
            String objectFilePath)
            throws Exception
    {
        //try{
        CodeGenerator.iCode = iCode;
        CodeGenerator.symTabStack = symTabStack;
        CodeGenerator.objectFile = new PrintWriter(objectFilePath);

        objectFilePath = objectFilePath.
                substring(0, objectFilePath.length() - 2);
        // Make the program and method names.
        int start = objectFilePath.lastIndexOf("/") + 1;
        String programName = objectFilePath.substring(start);
        int end = programName.indexOf(".");
        if (end > -1)
        {
            programName = programName.substring(0, end);
        }
        programName = programName.substring(0, 1).toUpperCase() + programName.
                substring(1);
        String methodName = programName.substring(0, 1).toLowerCase()
                + programName.substring(1);

        SymTabEntry programId = symTabStack.getProgramId();
        int localsCount = 7;
        //(Integer) programId.getAttribute(7);
        SymTab routineSymTab = (SymTab) programId.getAttribute(ROUTINE_SYMTAB);
        ArrayList<SymTabEntry> locals = routineSymTab.sortedEntries();

        // Generate the program header.
        objectFile.println(".class public " + programName);
        objectFile.println(".super java/lang/Object");
        objectFile.println();

        // Generate code for the timer and standard input fields.
        objectFile.println(".field private static _runTimer LRunTimer;");
        objectFile.println(".field private static _standardIn LPascalTextIn;");
        objectFile.println();

        // Generate code for fields.
        for (SymTabEntry id : locals)
        {// this is the loop for field methods
            Definition defn = id.getDefinition();
            
            if (defn == VARIABLE || defn == TYPE)
            {

                String fieldName = id.getName();
                TypeSpec type = id.getTypeSpec();
                
                
                String typeCode = "";
                if (type == Predefined.integerType)
                {
                    typeCode = "I";
                } else if (type == Predefined.realType || type
                        == Predefined.floatType | type == Predefined.doubleType)
                {
                    typeCode = "F";
                } else if (type == Predefined.stringType)
                {
                    typeCode = "Ljava/lang/String;";
                } else if (type == Predefined.booleanType)
                {
                    typeCode = "Z";
                    
                }
                 TypeForm form = type.getForm();
        //System.out.println("Form is " + form);
        switch ((TypeFormImpl) form) {
            case LIST:
                {
                    typeCode = "Ljava/util/ArrayList;";
                    break;
                }
            case SET:
                
                {
                    typeCode = "Ljava/util/HashSet;";
                    break;
                } 
            case MAP : 
                {
                    typeCode = "Ljava/util/HashMap;";

                }
        }
                //System.out.println("Type I found: " + type);
                objectFile.println(".field private static " + fieldName + " "
                        + typeCode);
            }
        }
        objectFile.println();

        // Generate the class constructor.
        objectFile.println(".method public <init>()V");
        objectFile.println();
        objectFile.println("	aload_0");
        objectFile.println("	invokenonvirtual	java/lang/Object/<init>()V");
        objectFile.println("	return");
        objectFile.println();
        objectFile.println(".limit locals 1");
        objectFile.println(".limit stack 1");
        objectFile.println(".end method");
        objectFile.println();

        // Visit the parse tree nodes to generate code 
        // for the  method's compound statement.
        //add local variables to the stack.
        // provide code for actual execution.
        
        CodeGeneratorVisitor codeVisitor = new CodeGeneratorVisitor();
        Node rootNode = iCode.getRoot();
        rootNode.jjtAccept(codeVisitor, programName);

        // Generate the main method header.
        objectFile.println(".method public static main([Ljava/lang/String;)V");
        objectFile.println();

        // Generate the main method prologue.
        objectFile.println("    new	 RunTimer");
        objectFile.println("    dup");
        objectFile.println("    invokenonvirtual	RunTimer/<init>()V");
        objectFile.println("    putstatic	" + programName
                + "/_runTimer LRunTimer;");
        objectFile.println("    new	 PascalTextIn");
        objectFile.println("    dup");
        objectFile.println("    invokenonvirtual	PascalTextIn/<init>()V");
        objectFile.println("    putstatic	" + programName
                + "/_standardIn LPascalTextIn;");
        objectFile.println();
        objectFile.flush();

        //Call to main method
        // Change the name main to whatever you want to run first
        objectFile.println(" new " + programName + "\n" + "    dup\n"
                + "    invokespecial " + programName + "/<init>()V\n"
                + "    invokevirtual " + programName + "/main()V");
        objectFile.println();

        // Generate the main method epilogue.
        objectFile.println("    getstatic	" + programName
                + "/_runTimer LRunTimer;");
        objectFile.println("    invokevirtual	RunTimer.printElapsedTime()V");
        objectFile.println();
        objectFile.println("    return");
        objectFile.println();
        objectFile.println(".limit locals " + localsCount);
        objectFile.println(".limit stack  " + STACK_LIMIT);
        objectFile.println(".end method");
        objectFile.flush();

       // }
       //  catch(Exception e)
        //{
          //  System.out.println("Dear user, There has been an exception. Please re-check your program. ");
           
        //}
        //finally
        //{
        CodeGenerator.objectFile.close();
    //    }
    }
}
