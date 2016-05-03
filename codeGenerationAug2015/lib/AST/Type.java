package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:9
 */
public abstract class Type extends ASTNode<ASTNode> implements Cloneable {
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
  public Type clone() throws CloneNotSupportedException {
    Type node = (Type)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:408
   */
  public void CS_emitEncoder(CS_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitEncoder(CS_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:501
   */
  public void CS_emitDecoder(CS_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitDecoder(CS_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:595
   */
  public void CS_emitTypePrefix(CS_env env) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitTypePrefix(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:624
   */
  public void CS_emitTypeSuffix(CS_env env) {
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:642
   */
  public boolean CS_needInstance() {
    throw new Error(this.getClass().getName() + 
		    ".CS_needInstance()" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:664
   */
  public boolean CS_isPrimitive() {
    return false;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:672
   */
  public void CS_emitInstance(CS_env env) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitInstance(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:715
   */
  public void CS_emitType(CS_env env) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitType(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:252
   */
  public void C_emitType(C_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitType(C_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:472
   */
  public void C_emitDecoder(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitDecoder(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:552
   */
  public void C_emitDecoderDeallocation(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitDecoderDeallocation(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:734
   */
  public void C_emitEncoder(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitEncoder(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1015
   */
  public int C_fixedSizeof() {
    throw new Error(this.getClass().getName() + 
		    ".C_fixedSizeof()" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1083
   */
  public void C_emitSizeof(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitSizeof(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:487
   */
  public void Java_emitEncoder(Java_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitEncoder(Java_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:576
   */
  public void Java_emitDecoder(Java_env env, String name) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitDecoder(Java_env env, String name)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:655
   */
  public void Java_emitNew(Java_env env, String size) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitNew(Java_env env, String size)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:671
   */
  public void Java_emitTypePrefix(Java_env env) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitTypePrefix(Java_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:700
   */
  public void Java_emitTypeSuffix(Java_env env) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:716
   */
  public boolean Java_needInstance() {
    throw new Error(this.getClass().getName() + 
		    ".Java_needInstance()" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:738
   */
  public boolean Java_isPrimitive() {
    return false;
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:746
   */
  public void Java_emitInstance(Java_env env) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitInstance(Java_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:789
   */
  public void Java_emitType(Java_env env) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitType(Java_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:47
   */
  public void ppIdentifier(PrintStream out, String id) { 
    ppPrefix(out);
    out.print(" ");
    out.print(id);
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:61
   */
  public void ppPrefix(PrintStream out) {
    throw new Error(this.getClass().getName() + 
		    ".ppPrefix(PrintStream out)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:93
   */
  public void ppSuffix(PrintStream out) { }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:139
   */
  public void Python_genSignature(Python_env env) {
    throw new Error(this.getClass().getName() + 
                    ".Python_genSignature(Python_env env)" + 
                    " not declared");
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:194
   */
  public String RAPID_AddType(RAPID_env env, String name) {
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:240
   */
  public void RAPID_AddDecodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:294
   */
  public void RAPID_AddEncodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public Type() {
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:191
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
  private boolean CS_isVoid_compute() {  return false;  }
  /**
   * @attribute syn
   * @aspect C_IsDynamic
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:131
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean C_isDynamic() {
      ASTNode$State state = state();
    boolean C_isDynamic_value = C_isDynamic_compute();
    return C_isDynamic_value;
  }
  /**
   * @apilevel internal
   */
  private boolean C_isDynamic_compute() {  return false;  }
  /**
   * @attribute syn
   * @aspect Java_Void
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:191
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
  private boolean isVoid_compute() {  return false;  }
  /**
   * @attribute inh
   * @aspect CS_StructName
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:173
   */
  @SuppressWarnings({"unchecked", "cast"})
  public int CS_Depth() {
      ASTNode$State state = state();
    int CS_Depth_value = getParent().Define_int_CS_Depth(this, null);
    return CS_Depth_value;
  }
  /**
   * @attribute inh
   * @aspect CS_StructName
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:177
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String CS_structName() {
      ASTNode$State state = state();
    String CS_structName_value = getParent().Define_String_CS_structName(this, null);
    return CS_structName_value;
  }
  /**
   * @attribute inh
   * @aspect Java_StructName
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:173
   */
  @SuppressWarnings({"unchecked", "cast"})
  public int Java_Depth() {
      ASTNode$State state = state();
    int Java_Depth_value = getParent().Define_int_Java_Depth(this, null);
    return Java_Depth_value;
  }
  /**
   * @attribute inh
   * @aspect Java_StructName
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:177
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String Java_structName() {
      ASTNode$State state = state();
    String Java_structName_value = getParent().Define_String_Java_structName(this, null);
    return Java_structName_value;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
