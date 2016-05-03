package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:22
 */
public class IntegerLiteral extends Exp implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
  }
  /**
   * @apilevel internal
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public IntegerLiteral clone() throws CloneNotSupportedException {
    IntegerLiteral node = (IntegerLiteral)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public IntegerLiteral copy() {
      try {
        IntegerLiteral node = (IntegerLiteral)clone();
        if(children != null) node.children = (ASTNode[])children.clone();
        return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
  }
  /**
   * @apilevel low-level
   */
  @SuppressWarnings({"unchecked", "cast"})
  public IntegerLiteral fullCopy() {
    IntegerLiteral res = (IntegerLiteral)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:461
   */
  public String CS_emitEncoder(CS_env env, String name) {
    return getValue();
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:569
   */
  public void CS_emitDecoder(CS_env env) {
    env.print(getValue());
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:330
   */
  public String C_getValue() {
    return getValue();
  }
  /**
   * @ast method 
   * @aspect C_Limit
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:401
   */
  public String C_getLimit(C_env env, int i) {
    return getValue();
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:969
   */
  public void C_genFlatSignature(C_env env) {
    C_genFlatSignature(env, Integer.parseInt(getValue()));
    env.print("// " + getValue());
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:536
   */
  public String Java_emitEncoder(Java_env env, String name) {
    return getValue();
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:629
   */
  public void Java_emitDecoder(Java_env env) {
    env.print(getValue());
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:105
   */
  public void pp(PrintStream out) {
    out.print(getValue());
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:212
   */
  public String Python_getValue() {
    return getValue();
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:352
   */
  public int RAPID_getValue() {
		return Integer.parseInt(getValue());
	}
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:156
   */
  public void flatSignature(SignatureList list) {
    list.addInt(Integer.parseInt(getValue()), null);
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:198
   */
  public String signatureComment() {
    return getValue();
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public IntegerLiteral() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public IntegerLiteral(String p0) {
    setValue(p0);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:10
   */
  public IntegerLiteral(beaver.Symbol p0) {
    setValue(p0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:16
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:22
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for lexeme Value
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setValue(String value) {
    tokenString_Value = value;
  }
  /**   * @apilevel internal   * @ast method 
   * @declaredat LabComm.ast:8
   */
  
  /**   * @apilevel internal   */  protected String tokenString_Value;
  /**
   * @ast method 
   * @declaredat LabComm.ast:9
   */
  
  public int Valuestart;
  /**
   * @ast method 
   * @declaredat LabComm.ast:10
   */
  
  public int Valueend;
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public void setValue(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
      throw new UnsupportedOperationException("setValue is only valid for String lexemes");
    tokenString_Value = (String)symbol.value;
    Valuestart = symbol.getStart();
    Valueend = symbol.getEnd();
  }
  /**
   * Getter for lexeme Value
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:22
   */
  public String getValue() {
    return tokenString_Value != null ? tokenString_Value : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
