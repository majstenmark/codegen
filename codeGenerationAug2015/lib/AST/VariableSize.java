package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:23
 */
public class VariableSize extends Exp implements Cloneable {
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
  public VariableSize clone() throws CloneNotSupportedException {
    VariableSize node = (VariableSize)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VariableSize copy() {
      try {
        VariableSize node = (VariableSize)clone();
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
  public VariableSize fullCopy() {
    VariableSize res = (VariableSize)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:465
   */
  public String CS_emitEncoder(CS_env env, String name) {
    env.println("e.encodePacked32(" + name + ");");
    return name;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:573
   */
  public void CS_emitDecoder(CS_env env) {
    env.print("d.decodePacked32()");
  }
  /**
   * @ast method 
   * @aspect C_Limit
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:405
   */
  public String C_getLimit(C_env env, int i) {
    return env.qualid + ".n_" + i;
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:527
   */
  public void C_emitDecoderDecodeLimit(C_env env, int i) {
    env.println(env.qualid + ".n_" + i + " = labcomm_read_packed32(r);");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:791
   */
  public void C_emitEncoderEncodeLimit(C_env env, int i) {
    env.println("labcomm_write_packed32(w, " + env.qualid + ".n_" + i + ");");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:974
   */
  public void C_genFlatSignature(C_env env) {
    C_genFlatSignature(env, 0);
    env.print("// _");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:540
   */
  public String Java_emitEncoder(Java_env env, String name) {
    env.println("e.encodePacked32(" + name + ".length);");
    return name + ".length";
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:633
   */
  public void Java_emitDecoder(Java_env env) {
    env.print("d.decodePacked32()");
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:109
   */
  public void pp(PrintStream out) {
    out.print("_");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:216
   */
  public String Python_getValue() {
    return "0";
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:160
   */
  public void flatSignature(SignatureList list) {
    list.addInt(0, null);
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:202
   */
  public String signatureComment() {
    return "_";
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public VariableSize() {
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
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
