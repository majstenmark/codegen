package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:21
 */
public abstract class Exp extends ASTNode<ASTNode> implements Cloneable {
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
  public Exp clone() throws CloneNotSupportedException {
    Exp node = (Exp)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:455
   */
  public String CS_emitEncoder(CS_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitEncoder(CS_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:563
   */
  public void CS_emitDecoder(CS_env env) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitDecoder(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:324
   */
  public String C_getValue() {
   throw new Error(this.getClass().getName() + 
		    ".C_getValue()" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Limit
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:395
   */
  public String C_getLimit(C_env env, int i) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitDecoderLimit(C_env env, int i)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:524
   */
  public void C_emitDecoderDecodeLimit(C_env env, int i) {
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:788
   */
  public void C_emitEncoderEncodeLimit(C_env env, int i) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:530
   */
  public String Java_emitEncoder(Java_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitEncoder(Java_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:623
   */
  public void Java_emitDecoder(Java_env env) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitDecoder(Java_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:206
   */
  public String Python_getValue() {
   throw new Error(this.getClass().getName() + 
                    ".Python_getValue()" + 
                    " not declared");
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:348
   */
  public int RAPID_getValue() {
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public Exp() {
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
   * @attribute inh
   * @aspect PPIndentation
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:5
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String pp_indent() {
      ASTNode$State state = state();
    String pp_indent_value = getParent().Define_String_pp_indent(this, null);
    return pp_indent_value;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
