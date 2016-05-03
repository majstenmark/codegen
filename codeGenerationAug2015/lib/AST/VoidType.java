package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:10
 */
public class VoidType extends Type implements Cloneable {
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
  public VoidType clone() throws CloneNotSupportedException {
    VoidType node = (VoidType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VoidType copy() {
      try {
        VoidType node = (VoidType)clone();
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
  public VoidType fullCopy() {
    VoidType res = (VoidType)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:414
   */
  public void CS_emitEncoder(CS_env env, String name) {
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:507
   */
  public void CS_emitDecoder(CS_env env, String name) {
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:678
   */
  public void CS_emitInstance(CS_env env) {
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:721
   */
  public void CS_emitType(CS_env env) {
    env.print("void");
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:258
   */
  public void C_emitType(C_env env, String name) {
    env.print("char " + name);
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:478
   */
  public void C_emitDecoder(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:740
   */
  public void C_emitEncoder(C_env env) {
    env.println("result = 0;");
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1021
   */
  public int C_fixedSizeof() {
    return 0;
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:493
   */
  public void Java_emitEncoder(Java_env env, String name) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:582
   */
  public void Java_emitDecoder(Java_env env, String name) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:752
   */
  public void Java_emitInstance(Java_env env) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:795
   */
  public void Java_emitType(Java_env env) {
    env.print("void");
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:67
   */
  public void ppPrefix(PrintStream out) { 
    out.print("void");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:182
   */
  public void Python_genSignature(Python_env env) {
    env.println("labcomm.struct([])");
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:115
   */
  public void flatSignature(SignatureList list) {
    list.addInt(LABCOMM_STRUCT, "void");
    list.addInt(0, null);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public VoidType() {
    super();


  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:10
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:16
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @attribute syn
   * @aspect CS_Void
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:192
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean CS_isVoid() {
      ASTNode$State state = state();
    boolean CS_isVoid_value = CS_isVoid_compute();
    return CS_isVoid_value;
  }
  /**
   * @apilevel internal
   */
  private boolean CS_isVoid_compute() {  return true;  }
  /**
   * @attribute syn
   * @aspect Java_Void
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:192
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean isVoid() {
      ASTNode$State state = state();
    boolean isVoid_value = isVoid_compute();
    return isVoid_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isVoid_compute() {  return true;  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
