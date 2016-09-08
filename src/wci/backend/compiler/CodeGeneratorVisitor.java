package wci.backend.compiler;

import wci.frontend.*;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.Predefined;

import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;
import static wci.intermediate.typeimpl.TypeKeyImpl.LIST_INDEX_TYPE;
import static wci.intermediate.typeimpl.TypeKeyImpl.MAP_KEY_TYPE;
import static wci.intermediate.typeimpl.TypeKeyImpl.MAP_VALUE_TYPE;
import static wci.intermediate.typeimpl.TypeKeyImpl.SET_INDEX_TYPE;

public class CodeGeneratorVisitor
        extends ExprParserVisitorAdapter
        implements ExprParserTreeConstants
{

    public Object visit(ASTProcedure node, Object data)
    {
        if (node.jjtGetNumChildren() != 1)
        {
            //Got in here
            
            SimpleNode param = (SimpleNode) node.jjtGetChild(0);

            //remember to append all the types.
            String methodHeader = ".method public " + node.getAttribute(
                    VALUE) + "(" + "" ;
            String loaders = "";
            for (int i = 0; i < param.jjtGetNumChildren(); i++)
            {


                //load the parameters.

                String programName = (String) data;
                SimpleNode variableNode = (SimpleNode) param.jjtGetChild(i);
                SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
                String fieldName = id.getName();
                TypeSpec type = id.getTypeSpec();
                String typePrefix = getTypePrefix(type);
                String prefix = getPrimitiveTypePrefix(type);
                
                methodHeader = methodHeader + typePrefix;
                
                loaders = loaders + "    " + prefix + "load_" + (i + 1) + "\n";
                loaders = loaders + "    putstatic " + programName + "/"
                    + fieldName + " " + typePrefix + "\n";
                System.out.println(loaders);
                // Emit the appropriate store instruction.

            }
            CodeGenerator.objectFile.print(methodHeader +")V");
            CodeGenerator.objectFile.println();
            CodeGenerator.objectFile.println(loaders);
            CodeGenerator.objectFile.println();

            SimpleNode commandsNode = (SimpleNode) node.jjtGetChild(1);
            commandsNode.jjtAccept(this, data);

        } else //no parameters.
        {
            // Generating method call
            CodeGenerator.objectFile.print(".method public " + node.
                    getAttribute(
                            VALUE) + "()V");
            CodeGenerator.objectFile.println();
            // create stuff inside
            SimpleNode commandsNode = (SimpleNode) node.jjtGetChild(0);
            commandsNode.jjtAccept(this, data);

        }

        //create end
        CodeGenerator.objectFile.println();
        CodeGenerator.objectFile.println("return\n" + ".limit locals 32\n"
                + ".limit stack 40\n" + ".end method" + "\n");
        return data;
    }

    public Object visit(ASTPrintStatement node, Object data)
    {
        Node commandsNode[] = new Node[node.jjtGetNumChildren()];
        String input[][] = new String[node.jjtGetNumChildren()][2];
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
        {
            commandsNode[i] = node.jjtGetChild(i);
            input[i] = (String[]) (commandsNode[i].jjtAccept(this, data));
        }

        CodeGenerator.objectFile.println("\n"
                + "    getstatic     java/lang/System/out Ljava/io/PrintStream; \n"
                + "    new       java/lang/StringBuilder \n" + "    dup \n" + ""
                + input[0][1] + "\n" + "    "
                + "invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V");
        for (int i = 0; i < node.jjtGetNumChildren() - 1; i++)
        {
            CodeGenerator.objectFile.println(input[i + 1][0] + "\n"
                    + "    invokevirtual java/lang/StringBuilder/append("
                    + input[i + 1][1] + ")Ljava/lang/StringBuilder;");
        }
        CodeGenerator.objectFile.println(
                "    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\n"
                + "    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");

        //Delete garbage on stack
        for (int i = 0; i < node.jjtGetNumChildren(); i++)
        {
            CodeGenerator.objectFile.println("    pop");
        }
        return data;
    }

    public Object visit(ASTProcedureCall node, Object data)
    {
        String programName = (String) data;
        if (node.jjtGetNumChildren() != 0)
        {
            SimpleNode passByValList = (SimpleNode) node.jjtGetChild(0);
            //determine call type and call.
            CodeGenerator.objectFile.println("    new " + programName);
            CodeGenerator.objectFile.flush();
            CodeGenerator.objectFile.println("    dup");
            CodeGenerator.objectFile.flush();
            CodeGenerator.objectFile.println("    invokespecial " + programName
                    + "/<init>()V");
            CodeGenerator.objectFile.flush();
            
            String AllTypePrefix = "";
            for (int i = 0; i< passByValList.jjtGetNumChildren();i++)
            {
                SimpleNode param = (SimpleNode) passByValList.jjtGetChild(i);
            //System.out.println(param);
            TypeSpec type = param.getTypeSpec();
            String typePrefix = getTypePrefix(type);
            param.jjtAccept(this, data);
            AllTypePrefix = AllTypePrefix + typePrefix;
            }
            //process all the children and append them 
            //set the typePrefix properly by going through all the children.
            CodeGenerator.objectFile.println("    invokevirtual " + programName
                    + "/" + node.getAttribute(VALUE) + "(" + AllTypePrefix + ")V");
            CodeGenerator.objectFile.flush();
        } else
        {
            CodeGenerator.objectFile.println("    new " + programName + "\n"
                    + "    dup\n"
                    + "    invokespecial " + programName + "/<init>()V\n"
                    + "    invokevirtual " + programName + "/" + node.
                    getAttribute(VALUE) + "()V");
            CodeGenerator.objectFile.flush();
        }
        return data;
    }

    public Object visit(ASTDeclaration node, Object data)
    {

        String programName = (String) data;
        SimpleNode variableNode = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();
        //System.out.println(node.getAttribute(VALUE));
        if (node.getAttribute(VALUE) != "Local")
        {

            // Convert an integer value to float if necessary.
            if (((targetType == Predefined.doubleType) || (targetType
                    == Predefined.floatType)) && (expressionType
                    == Predefined.integerType))
            {
                CodeGenerator.objectFile.println("    i2f");
                CodeGenerator.objectFile.flush();
            }

            SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
            String fieldName = id.getName();
            TypeSpec type = id.getTypeSpec();
            String typeCode = getTypePrefix(type);
            // Emit the appropriate store instruction.

            CodeGenerator.objectFile.println("    putstatic " + programName
                    + "/"
                    + fieldName + " " + typeCode);
        } else
        {// local variable
            CodeGenerator.objectFile.println("");
        }
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTAssignment node, Object data)
    {
        String programName = (String) data;
        SimpleNode variableNode = (SimpleNode) node.jjtGetChild(0);
        SimpleNode expressionNode = (SimpleNode) node.jjtGetChild(1);

        // Emit code for the expression.
        expressionNode.jjtAccept(this, data);
        TypeSpec expressionType = expressionNode.getTypeSpec();

        // Get the assignment target type.
        TypeSpec targetType = node.getTypeSpec();

        // Convert an integer value to float if necessary.
        if (((targetType == Predefined.doubleType) || (targetType
                == Predefined.floatType)) && (expressionType
                == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        SymTabEntry id = (SymTabEntry) variableNode.getAttribute(ID);
        //System.out.println("ID : "+variableNode);
        String fieldName = id.getName();
        TypeSpec type = id.getTypeSpec();
        String typeCode = getTypePrefix(type);

        // Emit the appropriate store instruction.
        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTvariable node, Object data)
    {

       
        String programName = (String) data;
        SymTabEntry id = (SymTabEntry) node.getAttribute(ID);
        // System.out.println(node.jjtGetValue());
        String fieldName = id.getName();

        TypeSpec type = id.getTypeSpec();
        String result[] = new String[2];
        String typeCode = getTypePrefix(type);
        // Emit the appropriate load instruction.
        CodeGenerator.objectFile.println("    getstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        result[0] = "    getstatic " + programName + "/"
                + fieldName + " " + typeCode;
        result[1] = typeCode;
        return result;

    }

    public Object visit(ASTBooleanConst node, Object data)
    {
        boolean bool = (boolean) node.getAttribute(VALUE);
        int value = 0;// false by default
        if (bool == true)
        {
            value = 1;
        }
        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc " + value;
        result[1] = "    ldc " + value;
        return result;

    }

    public Object visit(ASTIntegerConst node, Object data)
    {

        String result[] = new String[2];

        if (node.getAttribute(VALUE).getClass() == Integer.class)
        {
            int value = (Integer) node.getAttribute(VALUE);
            // Emit a load constant instruction.
            CodeGenerator.objectFile.println("    ldc " + value);
            CodeGenerator.objectFile.flush();
            result[0] = "    ldc \"" + value + "\"";
            result[1] = "    ldc \"" + value + "\"";
        } else
        {// take input
            String programName = (String) data;
            CodeGenerator.objectFile.println("    getstatic " + programName
                    + "/"
                    + "_standardIn LPascalTextIn;");
            CodeGenerator.objectFile.println(
                    "    invokevirtual PascalTextIn.readInteger()I");
        }
        return result;
    }

    public Object visit(ASTFloatConst node, Object data)
    {
        float value = (Float) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
    }

    public Object visit(ASTDoubleConst node, Object data)
    {
        double value = (Double) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc " + value);
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
    }

    public Object visit(ASTStringConst node, Object data)
    {
        String value = (String) node.getAttribute(VALUE);

        // Emit a load constant instruction.
        CodeGenerator.objectFile.println("    ldc \"" + value + "\"");
        CodeGenerator.objectFile.flush();
        String result[] = new String[2];
        result[0] = "    ldc \"" + value + "\"";
        result[1] = "    ldc \"" + value + "\"";
        return result;
    }

    public Object visit(ASTPlusEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        //assign the value to itself.

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTMinusEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();
        //assign the result value [data] to the initial variable.

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTStarEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        //System.out.println("StaREquals:" + (type == Predefined.integerType));
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTDivideEqualsStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTadd node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        //System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        //System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;

    }

    public Object visit(ASTsubtract node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        //System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        //System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;
    }

    public Object visit(ASTmultiply node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        //System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        //System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "mul");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;
    }

    public Object visit(ASTdivide node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();
        //System.out.println(type0 + " " + type1);
        // Get the addition type.
        TypeSpec type = Predefined.integerType;
        if (type0 == Predefined.doubleType || type1 == Predefined.doubleType)
        {
            type = Predefined.doubleType;
        } else if (type0 == Predefined.floatType || type1
                == Predefined.floatType)
        {
            type = Predefined.floatType;
        }

        String typePrefix = (type == Predefined.integerType) ? "i" : "f";
        //System.out.println(typePrefix);
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type1 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "div");
        CodeGenerator.objectFile.flush();
        /*
         String typeCode = type == Predefined.integerType ? "I" : "F";
         String programName = (String) data;

         SymTabEntry id = (SymTabEntry) ( (SimpleNode)node.jjtGetChild(0)).getAttribute(ID);
         String fieldName = id.getName();
        
         //System.out.println("Node " + node.getAttribute(VALUE));
         //CodeGenerator.objectFile.println("    putstatic " + programName + "/"+ node.getAttribute(VALUE) + " " + typeCode);
        
         CodeGenerator.objectFile.flush();*/

        return data;
    }

    public Object visit(ASTGreaterThan node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpgt L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTLessThan node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmplt L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpeq L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTGreaterEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpge L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTLessEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmple L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTNotEquals node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + "if_icmpne L00"
                + labelGenerator);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "iconst_0"); //push false i hope
        CodeGenerator.objectFile.println("    " + "goto L00" + labelGenerator);
        labelGenerator--;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.println("    " + "iconst_1");
        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        CodeGenerator.objectFile.flush();
        labelGenerator++;
        return data;
    }

    public Object visit(ASTIfPart node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);

        SimpleNode insideCommands = (SimpleNode) node.jjtGetChild(1);

        String operation = "";

        TypeSpec type = node.getTypeSpec();

        //String typePrefix = (type == Predefined.booleanType) ? "i" : "f";
        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        labelGenerator++;
        CodeGenerator.objectFile.println("    " + "ifeq L00" + labelGenerator);//if false
        insideCommands.jjtAccept(this, data); //CS153 NOTE: Loop through these if there are multiple statements
        //labelGenerator++;
        CodeGenerator.objectFile.println("    " + "goto L00"
                + finallabelGenerator);
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        labelGenerator++;
        for (int i = 0; i < node.jjtGetNumChildren() - 2; i++)
        {
            SimpleNode nextPart = (SimpleNode) node.jjtGetChild(i + 2);
            nextPart.jjtAccept(this, data);
        }
        //elseif.jjtAccept(this, data);
        //node.jjtGetChild(3).jjtGetChild(0).jjtAccept(this, data);
        //System.out.println(elseif.toString());
        //elsez.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type0 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit code for the second expression
        // with type conversion if necessary.
        //addend1Node.jjtAccept(this, data);
        /*
         if ((type == Predefined.realType) && (type1 == Predefined.integerType))
         {
         CodeGenerator.objectFile.println("    i2f");
         CodeGenerator.objectFile.flush();
         }
         */
        // Emit the appropriate add instruction.

        labelGenerator++;
        CodeGenerator.objectFile.println("L00" + finallabelGenerator + ":");
        finallabelGenerator++;
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTElseIfPart node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode insideCommands = (SimpleNode) node.jjtGetChild(1);
        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("    " + "ifeq L00" + labelGenerator);//if false
        insideCommands.jjtAccept(this, data); //CS153 NOTE: Loop through these if there are multiple statements
        CodeGenerator.objectFile.println("    " + "goto L00"
                + finallabelGenerator);
        //labelGenerator++;
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        labelGenerator++;
        return data;
    }

    public Object visit(ASTElsePart node, Object data)
    {
        SimpleNode insideCommands = (SimpleNode) node.jjtGetChild(0);
        CodeGenerator.objectFile.println("    " + "iconst_1");
        CodeGenerator.objectFile.println("    " + "ifeq L00" + labelGenerator);//if false
        insideCommands.jjtAccept(this, data); //CS153 NOTE: Loop through these if there are multiple statements
        CodeGenerator.objectFile.println("L00" + labelGenerator + ":");
        labelGenerator++;
        return data;
    }

    public Object visit(ASTFor node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);//variable decl
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);
        SimpleNode addend2Node = (SimpleNode) node.jjtGetChild(2);
        SimpleNode addend3Node = (SimpleNode) node.jjtGetChild(3);

        TypeSpec type0 = addend0Node.getTypeSpec();
        TypeSpec type1 = addend1Node.getTypeSpec();

        // Get the boolean type.
        TypeSpec type = node.getTypeSpec();

        addend0Node.jjtAccept(this, data);// accept the variable i

        // Emit code for the second expression
        // with type conversion if necessary.
        int currentLoopValue = looplabelGenerator;
        looplabelGenerator++;
        CodeGenerator.objectFile.println("L" + currentLoopValue + "0:"
        );
        addend1Node.jjtAccept(this, data);// accept the other variable
        // Emit the appropriate add instruction.
        int basiclabel = labelGenerator;
        labelGenerator += 20;
        CodeGenerator.objectFile.println("    " + "ifne L00"
                + basiclabel);
        basiclabel++;
        CodeGenerator.objectFile.println("    " + "goto L00" + basiclabel);
        basiclabel--;
        CodeGenerator.objectFile.println("L00" + basiclabel + ":");
        //CodeGenerator.objectFile.println("    " + "iconst_1");
        basiclabel++;
        addend3Node.jjtAccept(this, data);
        addend2Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println("    " + "goto L" + currentLoopValue
                + "0");
        CodeGenerator.objectFile.println("L00" + basiclabel + ":");
        CodeGenerator.objectFile.flush();
        basiclabel++;
        return data;
    }

    public Object visit(ASTWhile node, Object data)
    {

        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);//variable decl
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);

        int currentLoopValue = looplabelGenerator;
        looplabelGenerator++;
        CodeGenerator.objectFile.println("L" + currentLoopValue + "0:"
        );
        addend0Node.jjtAccept(this, data);// accept the variable i
        // Emit the appropriate add instruction.

        int basiclabel = labelGenerator;
        labelGenerator += 10;
        CodeGenerator.objectFile.println("    " + "ifne L00"
                + basiclabel);
        basiclabel++;
        CodeGenerator.objectFile.println("    " + "goto L00" + basiclabel);
        basiclabel--;
        CodeGenerator.objectFile.println("L00" + basiclabel + ":");
        basiclabel++;
        addend1Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("    " + "goto L" + currentLoopValue
                + "0");
        CodeGenerator.objectFile.println("L00" + basiclabel + ":");
        CodeGenerator.objectFile.flush();
        basiclabel++;
        return data;
    }

    private int labelGenerator = 3;
    private int finallabelGenerator = 100;
    private int looplabelGenerator = 1;

    public Object visit(ASTIncrementStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println();

        TypeSpec type0 = addend0Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        CodeGenerator.objectFile.println("    ldc 1");

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "add");
        CodeGenerator.objectFile.flush();
        //assign the value to itself.

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTDecrementStatement node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println();

        TypeSpec type0 = addend0Node.getTypeSpec();

        // Get the addition type.
        TypeSpec type = node.getTypeSpec();
        String typePrefix = (type == Predefined.integerType) ? "i" : "f";

        // Emit code for the first expression
        // with type conversion if necessary.
        addend0Node.jjtAccept(this, data);
        if (((type == Predefined.doubleType) || (type == Predefined.floatType))
                && (type0 == Predefined.integerType))
        {
            CodeGenerator.objectFile.println("    i2f");
            CodeGenerator.objectFile.flush();
        }

        CodeGenerator.objectFile.println("ldc 1");

        // Emit the appropriate add instruction.
        CodeGenerator.objectFile.println("    " + typePrefix + "sub");
        CodeGenerator.objectFile.flush();
        //assign the value to itself.

        String typeCode = type == Predefined.integerType ? "I" : "F";
        String programName = (String) data;

        SymTabEntry id = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName = id.getName();

        CodeGenerator.objectFile.println("    putstatic " + programName + "/"
                + fieldName + " " + typeCode);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTList node, Object data)
    {
        String programName = (String) data;

        SimpleNode key = (SimpleNode) node;
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(LIST_INDEX_TYPE);
        String fieldName = id.getName();

        //System.out.println("TYPE" + type0 );
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);
        String methodName = getMethodName(type0);

        CodeGenerator.objectFile.println("new  List");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("dup");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("astore_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("aload_" + +id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokespecial List.<init>()V");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokevirtual List/List" + methodName
                + "()Ljava/util/ArrayList;");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("putstatic " + programName + "/"
                + fieldName + " Ljava/util/ArrayList;");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTListAdd node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(LIST_INDEX_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        SimpleNode val = addend0Node;
        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual List/add(" + typePrefix
                + ")V");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTListGetVal node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(LIST_INDEX_TYPE);

        //System.out.println("TYPE" + type0 );
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);
        String methodName = getMethodName(type0);

        //System.out.println("TYPE Prefix " + typePrefix);
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        addend0Node.jjtAccept(this, data);
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/getVal"
                + methodName + "(I)" + typePrefix);
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTListDelete node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(LIST_INDEX_TYPE);
        // Get the addition type.

        String typePrefix = getTypePrefix(type0);

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        SimpleNode val = addend0Node;
        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual List/remove("
                + typePrefix + ")V");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTListGetIndex node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(LIST_INDEX_TYPE);

        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        //get the base type to get the type of the identifier
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        SimpleNode val = addend0Node;
        addend0Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println("invokevirtual List/getIndex("
                + typePrefix + ")I");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTListSetVal node, Object data)
    {
        SimpleNode pos = (SimpleNode) node.jjtGetChild(1);
        pos = (SimpleNode) pos.jjtGetChild(0);
        //System.out.println(pos);

        SimpleNode val = (SimpleNode) node.jjtGetChild(2);
        val = (SimpleNode) val.jjtGetChild(0);
        //System.out.println(val);

        //TypeSpec type0 = val.getTypeSpec();
        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(LIST_INDEX_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();

        pos.jjtAccept(this, data);
        val.jjtAccept(this, data);
        CodeGenerator.objectFile.println("invokevirtual List/setVal(I"
                + typePrefix + ")V");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTListGetSize node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) addend0Node.getAttribute(ID);

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual List/getSize()I");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTSet node, Object data)
    {
        String programName = (String) data;
        SimpleNode addend0Node = (SimpleNode) node;
        SymTabEntry id = (SymTabEntry) (addend0Node).
                getAttribute(ID);
        String fieldName = id.getName();
        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(SET_INDEX_TYPE);

        SimpleNode size = (SimpleNode) node.jjtGetChild(0);

        //System.out.println("TYPE" + type0 );
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);
        String methodName = getMethodName(type0);

        CodeGenerator.objectFile.println("new Set");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("dup");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("astore_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("aload_" + +id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokespecial Set.<init>()V");
        size.jjtAccept(this, data);
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokevirtual Set/Set" + methodName + "(I)Ljava/util/HashSet;");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("putstatic " + programName + "/"
                + fieldName + " Ljava/util/HashSet;");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTSetAdd node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);

        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(SET_INDEX_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();

        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual Set/add(" + typePrefix
                + ")V");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTSetDelete node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.
                getAttribute(ID);

        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(SET_INDEX_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual Set/remove("
                + typePrefix + ")V");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTSetGetSize node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SymTabEntry id = (SymTabEntry) addend0Node.getAttribute(ID);

        TypeSpec type0 = addend0Node.getTypeSpec();

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        //addend0Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println("invokevirtual Set/getSize()I");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTSetGetString node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SymTabEntry id = (SymTabEntry) addend0Node.getAttribute(ID);

        TypeSpec type0 = addend0Node.getTypeSpec();

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        //addend0Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println(
                "invokevirtual Set/getString()Ljava/lang/String;");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTSetContains node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);

        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(SET_INDEX_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        //get the base type to get the type of the identifier
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        addend0Node.jjtAccept(this, data);
        SimpleNode val = addend0Node;
        CodeGenerator.objectFile.println("invokevirtual Set/contains("
                + typePrefix + ")Z");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTMapContains node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry id = (SymTabEntry) key.getAttribute(ID);

        TypeSpec type0 = id.getTypeSpec();
        type0 = (TypeSpec) type0.getAttribute(MAP_KEY_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        //get the base type to get the type of the identifier
        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        addend0Node.jjtAccept(this, data);
        SimpleNode val = addend0Node;
        CodeGenerator.objectFile.println("invokevirtual Map/contains("
                + typePrefix + ")Z");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTHashmap node, Object data)
    {
        String programName = (String) data;
        SimpleNode key = (SimpleNode) node;
        SymTabEntry keyID = (SymTabEntry) (key).getAttribute(ID);
        String fieldName = keyID.getName();
        TypeSpec type = keyID.getTypeSpec();
        TypeSpec type0 = (TypeSpec) type.getAttribute(MAP_KEY_TYPE);
        //return type depends on variable's types.

        TypeSpec type1 = (TypeSpec) type.getAttribute(MAP_VALUE_TYPE);

        // Get the addition type.
        String typePrefix0 = getTypePrefix(type0);
        String typePrefix1 = getTypePrefix(type1);
        String typeMethod0 = getMethodName(type0);
        String typeMethod1 = getMethodName(type1);
        //System.out.println("TYPE" + type0 );
        // Get the addition type.

        CodeGenerator.objectFile.println("new Map");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("dup");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("astore_" + keyID.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("aload_" + +keyID.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokespecial Map.<init>()V");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokevirtual Map/" + typeMethod0 + typeMethod1
                + "Map()Ljava/util/HashMap;");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("putstatic " + programName + "/"
                + fieldName + " Ljava/util/HashMap;");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTMapAdd node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);

        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(2);
        addend1Node = (SimpleNode) addend1Node.jjtGetChild(0);

        //return type depends on variable's types.
        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry keyID = (SymTabEntry) (key).getAttribute(ID);
        TypeSpec type = keyID.getTypeSpec();
        TypeSpec type0 = (TypeSpec) type.getAttribute(MAP_KEY_TYPE);
        //return type depends on variable's types.

        TypeSpec type1 = (TypeSpec) type.getAttribute(MAP_VALUE_TYPE);

        // Get the addition type.
        String typePrefix0 = getTypePrefix(type0);
        String typePrefix1 = getTypePrefix(type1);
        String typeMethod0 = getMethodName(type0);
        String typeMethod1 = getMethodName(type1);

        CodeGenerator.objectFile.println("aload_" + keyID.getIndex());
        CodeGenerator.objectFile.flush();
        addend0Node.jjtAccept(this, data);
        addend1Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual Map/add" + typeMethod0
                + typeMethod1 + "(" + typePrefix0
                + typePrefix1 + ")V");
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTMapDelete node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry keyID = (SymTabEntry) (key).getAttribute(ID);
        TypeSpec type = keyID.getTypeSpec();
        TypeSpec type0 = (TypeSpec) type.getAttribute(MAP_KEY_TYPE);
        //return type depends on variable's types.

        TypeSpec type1 = (TypeSpec) type.getAttribute(MAP_VALUE_TYPE);

        //System.out.println("TYPE" + type0);
        // Get the addition type.
        String typePrefix = getTypePrefix(type0);

        CodeGenerator.objectFile.println("aload_" + keyID.getIndex());
        CodeGenerator.objectFile.flush();
        SimpleNode val = addend0Node;
        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual Map/remove("
                + typePrefix + ")V");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTMapGetSize node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SymTabEntry id = (SymTabEntry) addend0Node.getAttribute(ID);
        String fieldName = id.getName();

        TypeSpec type0 = addend0Node.getTypeSpec();

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("invokevirtual Map/getSize()I");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTMapGetString node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println(addend0Node);

        SymTabEntry id = (SymTabEntry) addend0Node.getAttribute(ID);
        String fieldName = id.getName();

        TypeSpec type0 = addend0Node.getTypeSpec();

        CodeGenerator.objectFile.println("aload_" + id.getIndex());
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokevirtual Map/getString()Ljava/lang/String;");
        CodeGenerator.objectFile.flush();
        return data;
    }

    private String getTypePrefix(TypeSpec type0)
    {
        String typePrefix = "";
        if (type0 == Predefined.integerType)
        {
            typePrefix = "I";
        } else if (type0 == Predefined.stringType)
        {
            typePrefix = "Ljava/lang/String;";
        } else if (type0 == Predefined.doubleType || type0
                == Predefined.floatType)
        {
            typePrefix = "F";
        } else if (type0 == Predefined.booleanType)
        {
            typePrefix = "Z";
        }
        return typePrefix;
    }

    private String getMethodName(TypeSpec type0)
    {
        String typePrefix = "";
        if (type0 == Predefined.integerType)
        {
            typePrefix = "Integer";
        } else if (type0 == Predefined.stringType)
        {
            typePrefix = "String";
        } else if (type0 == Predefined.doubleType || type0
                == Predefined.floatType)
        {
            typePrefix = "Float";
        } else if (type0 == Predefined.booleanType)
        {
            typePrefix = "Boolean";
        }
        return typePrefix;
    }

    public Object visit(ASTMapGetVal node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(1);
        addend0Node = (SimpleNode) addend0Node.jjtGetChild(0);

        SymTabEntry id0 = (SymTabEntry) ((SimpleNode) node.jjtGetChild(0)).
                getAttribute(ID);
        String fieldName0 = id0.getName();

        //return type depends on variable's types.
        SimpleNode key = (SimpleNode) node.jjtGetChild(0);
        SymTabEntry keyID = (SymTabEntry) (key).getAttribute(ID);
        TypeSpec type = keyID.getTypeSpec();
        TypeSpec type0 = (TypeSpec) type.getAttribute(MAP_KEY_TYPE);
        //return type depends on variable's types.

        TypeSpec type1 = (TypeSpec) type.getAttribute(MAP_VALUE_TYPE);

        // Get the addition type.
        String typePrefix0 = getTypePrefix(type0);
        String typePrefix1 = getTypePrefix(type1);
        String typeMethod0 = getMethodName(type0);
        String typeMethod1 = getMethodName(type1);

        CodeGenerator.objectFile.println("aload_" + id0.getIndex());
        CodeGenerator.objectFile.flush();

        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println("invokevirtual Map/getVal"
                + typeMethod0 + typeMethod1 + "(" + typePrefix0
                + ")" + typePrefix1);
        CodeGenerator.objectFile.flush();

        return data;
    }

    public Object visit(ASTStringGetSize node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        //System.out.println(addend0Node);

        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println(
                "invokevirtual java/lang/String.length()I");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTStringGetIndex node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);
        addend1Node = (SimpleNode) addend1Node.jjtGetChild(0);
        //System.out.println(addend0Node);
        // Get the addition type.
        String typePrefix = "Ljava/lang/String";

        //get the base type to get the type of the identifier
        addend0Node.jjtAccept(this, data);
        addend1Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println(
                "invokevirtual java/lang/String.indexOf("
                + "Ljava/lang/String;" + ")I");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTStringSubstring node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);
        SimpleNode addend2Node = (SimpleNode) node.jjtGetChild(2);
        //System.out.println(addend0Node);
        // Get the addition type.

        //get the base type to get the type of the identifier
        addend0Node.jjtAccept(this, data);
        addend1Node.jjtAccept(this, data);
        addend2Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println(
                "invokevirtual java/lang/String.substring(II)Ljava/lang/String;");
        CodeGenerator.objectFile.flush();
        return data;
    }

    public Object visit(ASTStringAppend node, Object data)
    {
        SimpleNode addend0Node = (SimpleNode) node.jjtGetChild(0);
        SimpleNode addend1Node = (SimpleNode) node.jjtGetChild(1);
        addend1Node = (SimpleNode) addend1Node.jjtGetChild(0);
        //System.out.println(addend0Node);
        // Get the addition type.
        String typePrefix = "Ljava/lang/String";

        //get the base type to get the type of the identifier
        addend0Node.jjtAccept(this, data);

        CodeGenerator.objectFile.println(
                "getstatic     java/lang/System/out Ljava/io/PrintStream;");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "    new       java/lang/StringBuilder ");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println("dup");
        CodeGenerator.objectFile.flush();
        CodeGenerator.objectFile.println(
                "invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V");
        CodeGenerator.objectFile.flush();
        addend1Node.jjtAccept(this, data);
        CodeGenerator.objectFile.println(
                "invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/String;");
        CodeGenerator.objectFile.flush();
        return data;
    }

    private String getPrimitiveTypePrefix(TypeSpec type0)
    {
        String typePrefix = "";
        if (type0 == Predefined.integerType)
        {
            typePrefix = "i";

        } else if (type0 == Predefined.doubleType || type0
                == Predefined.floatType)
        {
            typePrefix = "f";
        } else if (type0 == Predefined.booleanType)
        {
            typePrefix = "z";
        } else
        {
            typePrefix = "a";
        }
        return typePrefix;
    }
}
