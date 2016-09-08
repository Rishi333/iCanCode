package wci.frontend;

import wci.frontend.SimpleNode;
import wci.frontend.ASTAssignment;
import wci.frontend.ASTCases;
import wci.frontend.ASTComparisonOperator;
import wci.frontend.ASTDeclaration;
import wci.frontend.ASTDecrementStatement;
import wci.frontend.ASTDivideEqualsStatement;
import wci.frontend.ASTElseIfPart;
import wci.frontend.ASTElsePart;
import wci.frontend.ASTHashmap;
import wci.frontend.ASTIfPart;
import wci.frontend.ASTIncrementStatement;
import wci.frontend.ASTList;
import wci.frontend.ASTMinusEqualsStatement;
import wci.frontend.ASTPlusEqualsStatement;
import wci.frontend.ASTProgram;
import wci.frontend.ASTSet;
import wci.frontend.ASTStarEqualsStatement;
import wci.frontend.ASTStatement;
import wci.frontend.ASTSwitchPart;
import wci.frontend.ExprParserVisitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aishwarya
 */
public class ExprParserVisitorAdapter implements ExprParserVisitor
{

    @Override
    public Object visit(SimpleNode node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTProgram node, Object data)
    {
        return node.childrenAccept(this, data);

    }
/*
    //@Override
    public Object visit(ASTPrimitiveType node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTExpr node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTSimpleExpr node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTTerm node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTFactor node, Object data)
    {
        return node.childrenAccept(this, data);
    }*/

    @Override
    public Object visit(ASTStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTIfPart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTElseIfPart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTElsePart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    /*@Override
    public Object visit(ASTLiteral node, Object data)
    {
        return node.childrenAccept(this, data);
    }*/

    @Override
    public Object visit(ASTSwitchPart node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTComparisonOperator node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTCases node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTAssignment node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDeclaration node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTIncrementStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDecrementStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTPlusEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTMinusEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTStarEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDivideEqualsStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }


    @Override
    public Object visit(ASTHashmap node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTSet node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTList node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTIntegerConst node, Object data)
    {
        return node.childrenAccept(this, data);
    }



    @Override
    public Object visit(ASTStringConst node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTvariable node, Object data)
    {
      return node.childrenAccept(this, data);    
    }

    @Override
    public Object visit(ASThandleError node, Object data) {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTError node, Object data) {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTCommands node, Object data) {
        return node.childrenAccept(this, data);  
    }

    @Override
    public Object visit(ASTFor node, Object data) {
        return node.childrenAccept(this, data);  
    }

    @Override
    public Object visit(ASTWhile node, Object data) {
        return node.childrenAccept(this, data);  
    }

    @Override
    public Object visit(ASTvariableDecl node, Object data)
    {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTadd node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTsubtract node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTor node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTmultiply node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTdivide node, Object data)
    {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTand node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTProcedure node, Object data) {
         return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTDecVar node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTTestCond node, Object data)
    {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTIncrementCond node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTWhileIncrementCond node, Object data)
    {
        return node.childrenAccept(this, data);}




    @Override
    public Object visit(ASTProcedureCall node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTPrintStatement node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTBooleanConst node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTLessThan node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTLessEquals node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTGreaterThan node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTGreaterEquals node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTEquals node, Object data) {
       return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTNegate node, Object data) {
       return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTNotEquals node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTKeyType node, Object data)
    {
       return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTValueType node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTSize node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTSetAdd node, Object data)
    {
      return node.childrenAccept(this, data); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visit(ASTListAdd node, Object data)
    {
       return node.childrenAccept(this, data); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visit(ASTSetDelete node, Object data)
    {
       return node.childrenAccept(this, data); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visit(ASTListDelete node, Object data)
    {
        return node.childrenAccept(this, data);//To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Object visit(ASTListGetVal node, Object data)
    {
        return node.childrenAccept(this, data); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public Object visit(ASTListGetIndex node, Object data)
    {
        return node.childrenAccept(this, data); //To change body of generated methods, choose Tools | Templates.
    }

  



    @Override
    public Object visit(ASTPosition node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTLiteral node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTMapAdd node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTMapDelete node, Object data)
    {
        return node.childrenAccept(this, data);}
    @Override
    public Object visit(ASTMapGetVal node, Object data)
    {
        return node.childrenAccept(this, data);}


    @Override
    public Object visit(ASTListSetVal node, Object data)
    {
        return node.childrenAccept(this, data);}
    @Override
    public Object visit(ASTHashSetVal node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTDoubleConst node, Object data)
    {
          return node.childrenAccept(this, data); }
    
     @Override
    public Object visit(ASTFloatConst node, Object data)
    {
          return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTListGetSize node, Object data)
    {
        return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTSetGetSize node, Object data)
    {
       return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTMapGetSize node, Object data)
    {
       return node.childrenAccept(this, data); }

    @Override
    public Object visit(ASTSetContains node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTvalue node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTStringGetIndex node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTStringGetSize node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTStringSubstring node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTMapContains node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTSetGetString node, Object data)
    {
        return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTMapGetString node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTStringAppend node, Object data)
    {
         return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTParameters node, Object data)
    {
       return node.childrenAccept(this, data);}

    @Override
    public Object visit(ASTValuePass node, Object data)
    {
      return node.childrenAccept(this, data);}


  

   

}
