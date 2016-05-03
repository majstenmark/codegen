package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:15
 */
public abstract class ArrayType extends Type implements Cloneable {
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
  public ArrayType clone() throws CloneNotSupportedException {
    ArrayType node = (ArrayType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:431
   */
  public void CS_emitEncoder(CS_env env, String name) {
    env.print_block_begin();
    int baseDepth = env.getDepth();
    for (int i = 0 ; i < getNumExp() ; i++) {
      String limit = getExp(i).CS_emitEncoder(env, 
					      name + ".GetLength(" + i + ")");
      env.println("int i_" + (baseDepth + i) + "_max = " + limit + ";");
    }
    String index = null;
    for (int i = 0 ; i < getNumExp() ; i++) {
      String limit = "i_" + (baseDepth + i) + "_max";
      if (i == 0) {
        index = env.print_for_begin(limit);
      } else {
        index = index + ", " + env.print_for_begin(limit);
      }
    }
    getType().CS_emitEncoder(env, name + "[" + index + "]");
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print_for_end();
    }
    env.print_block_end();
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:524
   */
  public void CS_emitDecoder(CS_env env, String name) {
    env.println("{");
    env.indent();
    int baseDepth = env.getDepth();
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print("int i_" + (baseDepth + i) + "_max = ");
      getExp(i).CS_emitDecoder(env);
      env.println(";");
    }
    env.print(name + " = new "); 
    getType().CS_emitTypePrefix(env);
    env.print("[");
    for (int i = 0 ; i < getNumExp() ; i++) {
      if (i > 0) {
	env.print(", ");
      }
      env.print("i_" + (baseDepth + i) + "_max");
    }
    env.print("]");
    getType().CS_emitTypeSuffix(env);
    env.println(";");
    
    String index = null;
    for (int i = 0 ; i < getNumExp() ; i++) {
      String limit = "i_" + (baseDepth + i) + "_max";
      if (i == 0) {
        index = env.print_for_begin(limit);
      } else {
        index = index + ", " + env.print_for_begin(limit);
      }
    }
    getType().CS_emitDecoder(env, name + "[" + index + "]");
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print_for_end();
    }
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:616
   */
  public void CS_emitTypePrefix(CS_env env){
    getType().CS_emitTypePrefix(env);
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:633
   */
  public void CS_emitTypeSuffix(CS_env env){
    env.print("[");
    for (int i = 1 ; i < getNumExp() ; i++) {
      env.print(",");
    }
    env.print("]");
    getType().CS_emitTypeSuffix(env);
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:660
   */
  public boolean CS_needInstance() {
    return getType().CS_needInstance();
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:684
   */
  public void CS_emitInstance(CS_env env) {
    getType().CS_emitInstance(env);
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:737
   */
  public void CS_emitType(CS_env env){
    getType().CS_emitTypePrefix(env);
    env.print("[");
    for (int i = 1 ; i < getNumExp() ; i++) {
      env.print(",");
    }
    env.print("]");
    getType().CS_emitTypeSuffix(env);
  }
  /**
   * @ast method 
   * @aspect C_CodeGenEnv
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:106
   */
  public C_env C_Nest(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_Nest(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Common
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:220
   */
  public void C_emitLoopVariables(C_env env) {
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.println("int i_" + env.depth + "_" + i + ";");
    }
  }
  /**
   * @ast method 
   * @aspect C_Index
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:413
   */
  public void C_emitCalcIndex(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:495
   */
  public void C_emitDecoder(C_env env) {
    C_emitDecoderDecodeLimit(env);
    C_emitDecoderArrayAllocate(env);
    env.println("{");
    env.indent();
    C_emitLoopVariables(env);
    for (int i = 0 ; i < getNumExp() ; i++) {
      String iterator = "i_" + env.depth + "_" + i;
      env.println("for (" + iterator + " = 0" +
		  " ; " +
		  iterator + " < " + getExp(i).C_getLimit(env, i) +
		  " ; " +
		  iterator + "++) {");
      env.indent();
    }
    C_emitCalcIndex(env);
    getType().C_emitDecoder(C_Nest(env));
    for (int i = getNumExp() - 1 ; i >= 0 ; i--) {
      env.unindent();
      env.println("}");
    }
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:531
   */
  public void C_emitDecoderDecodeLimit(C_env env) {
    for (int i = 0 ; i < getNumExp() ; i++) {
      getExp(i).C_emitDecoderDecodeLimit(env, i);
    }
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:537
   */
  public void C_emitDecoderArrayAllocate(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:579
   */
  public void C_emitDecoderDeallocation(C_env env) {
    if (getType().C_isDynamic()) {
      env.println("{");
      env.indent();
      C_emitLoopVariables(env);
      for (int i = 0 ; i < getNumExp() ; i++) {
	String iterator = "i_" + env.depth + "_" + i;
	env.println("for (" + iterator + " = 0" +
		    " ; " +
		    iterator + " < " + getExp(i).C_getLimit(env, i) +
		    " ; " +
		    iterator + "++) {");
	env.indent();
      }
      C_emitCalcIndex(env);
      getType().C_emitDecoderDeallocation(C_Nest(env));
      for (int i = 0 ; i < getNumExp() ; i++) {
	env.unindent();
	env.println("}");
      }
      env.unindent();
      env.println("}");
    }
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:760
   */
  public void C_emitEncoder(C_env env) {
    C_emitEncoderEncodeLimit(env);
    env.println("{");
    env.indent();
    C_emitLoopVariables(env);
    for (int i = 0 ; i < getNumExp() ; i++) {
      String iterator = "i_" + env.depth + "_" + i;
      env.println("for (" + iterator + " = 0" +
		  " ; " +
		  iterator + " < " + getExp(i).C_getLimit(env, i) +
		  " ; " +
		  iterator + "++) {");
      env.indent();
    }
    C_emitCalcIndex(env);
    getType().C_emitEncoder(C_Nest(env));
    for (int i = getNumExp() - 1 ; i >= 0 ; i--) {
      env.unindent();
      env.println("}");
    }
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:795
   */
  public void C_emitEncoderEncodeLimit(C_env env) {
    for (int i = 0 ; i < getNumExp() ; i++) {
      getExp(i).C_emitEncoderEncodeLimit(env, i);
    }
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:941
   */
  public void C_genFlatSignature(C_env env) {
    C_genFlatSignature(env, LABCOMM_ARRAY);
    env.println("// LABCOMM_ARRAY");
    C_genFlatSignature(env, getNumExp());
    env.println("// # of dimensions");
    for (int i = 0 ; i < getNumExp() ; i++) {
      getExp(i).C_genFlatSignature(env);
      env.println("");
    }
    getType().C_genFlatSignature(env);
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1054
   */
  public int C_fixedSizeof() {
    int elements = 1;
    for (int i = 0 ; i < getNumExp() ; i++) {
      int n = Integer.parseInt(((IntegerLiteral)getExp(i)).getValue());
      elements = elements * n;
    }
    return getType().C_fixedSizeof() * elements;
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1121
   */
  public void C_emitSizeof(C_env env) {
    if (getType().C_isDynamic()) {
      env.println("{");
      env.indent();
      C_emitLoopVariables(env);
      for (int i = 0 ; i < getNumExp() ; i++) {
	String iterator = "i_" + env.depth + "_" + i;
	env.println("for (" + iterator + " = 0" +
		    " ; " +
		    iterator + " < " + getExp(i).C_getLimit(env, i) +
		    " ; " +
		    iterator + "++) {");
	env.indent();
      }
      C_emitCalcIndex(env);
      getType().C_emitSizeof(C_Nest(env));
      for (int i = 0 ; i < getNumExp() ; i++) {
	env.unindent();
	env.println("}");
      }
      env.unindent();
      env.println("}");
    } else {
      env.print("result += " + getType().C_fixedSizeof());
      for (int i = 0 ; i < getNumExp() ; i++) {
	env.print(" * " + getExp(i).C_getLimit(env, i));
      }
      env.println(";");      
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:510
   */
  public void Java_emitEncoder(Java_env env, String name) {
    int baseDepth = env.getDepth();
    String prefix = "";
    for (int i = 0 ; i < getNumExp() ; i++) {
      String limit = getExp(i).Java_emitEncoder(env, name + prefix);
      env.print_block_begin();
      env.println("int i_" + (baseDepth + i) + "_max = " + limit + ";");
      prefix = prefix + "[0]";
    }
    for (int i = 0 ; i < getNumExp() ; i++) {
      String limit = "i_" + (baseDepth + i) + "_max";
      name = name + env.print_for_begin(limit);
    }
    getType().Java_emitEncoder(env, name);
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print_for_end();
      env.print_block_end();
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:599
   */
  public void Java_emitDecoder(Java_env env, String name) {
    env.println("{");
    env.indent();
    int baseDepth = env.getDepth();
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print("int i_" + (baseDepth + i) + "_max = ");
      getExp(i).Java_emitDecoder(env);
      env.println(";");
    }
    for (int i = 0 ; i < getNumExp() ; i++) {
      String limit = "i_" + (baseDepth + i) + "_max";
      env.print(name + " = "); 
      Java_emitNew(env, limit, getNumExp() - i);
      env.println(";");
      name = name + env.print_for_begin(limit);
    }
    getType().Java_emitDecoder(env, name);
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print_for_end();
    }
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:661
   */
  public void Java_emitNew(Java_env env, String size, int depth) {
    env.print("new ");
    getType().Java_emitTypePrefix(env);
    env.print("[" + size + "]");
    getType().Java_emitTypeSuffix(env);
    for (int i = 1 ; i < depth ; i++) {
      env.print("[]");
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:692
   */
  public void Java_emitTypePrefix(Java_env env){
    getType().Java_emitTypePrefix(env);
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:709
   */
  public void Java_emitTypeSuffix(Java_env env){
    getType().Java_emitTypeSuffix(env);
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print("[]");
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:734
   */
  public boolean Java_needInstance() {
    return getType().Java_needInstance();
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:758
   */
  public void Java_emitInstance(Java_env env) {
    getType().Java_emitInstance(env);
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:810
   */
  public void Java_emitType(Java_env env){
    getType().Java_emitType(env);
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print("[]");
    }
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:53
   */
  public void ppIdentifier(PrintStream out, String id) {
    ppPrefix(out);
    out.print(" ");
    out.print(id);
    ppSuffix(out);
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:79
   */
  public void ppPrefix(PrintStream out) {
    getType().ppPrefix(out);
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:95
   */
  public void ppSuffix(PrintStream out) { 
    out.print("[");
    for (int i = 0 ; i < getNumExp() ; i++) {
      if (i > 0) { out.print(", "); }
      getExp(i).pp(out);
    }
    out.print("]");
    getType().ppSuffix(out);
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:158
   */
  public void Python_genSignature(Python_env env) {
    env.print("labcomm.array([");
    for (int i = 0 ; i < getNumExp() ; i++) {
      if (i > 0) { env.print(", "); }
      env.print(getExp(i).Python_getValue());
    }
    env.println("],");
    env.indent();
    getType().Python_genSignature(env);
    env.print(")");
    env.unindent();
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:128
   */
  public void flatSignature(SignatureList list) {
    list.addInt(LABCOMM_ARRAY, signatureComment());
    list.indent();
    list.addInt(getNumExp(), null);
    for (int i = 0 ; i < getNumExp() ; i++) {
      getExp(i).flatSignature(list);
    }
    getType().flatSignature(list);
    list.unindent();
    list.add(null, "}");
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:164
   */
  public String signatureComment() {
    StringBuffer result = new StringBuffer("array [");
    for (int i = 0 ; i < getNumExp() ; i++) {
      if (i > 0) {
	result.append(", ");
      }
      result.append(getExp(i).signatureComment());
    }
    result.append("]");
    return result.toString();
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public ArrayType() {
    super();

    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
   */
  public ArrayType(Type p0, List<Exp> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:15
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:21
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for Type
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setType(Type node) {
    setChild(node, 0);
  }
  /**
   * Getter for Type
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public Type getType() {
    return (Type)getChild(0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:18
   */
  public Type getTypeNoTransform() {
    return (Type)getChildNoTransform(0);
  }
  /**
   * Setter for ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setExpList(List<Exp> list) {
    setChild(list, 1);
  }
  /**
   * @return number of children in ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public int getNumExp() {
    return getExpList().getNumChild();
  }
  /**
   * Getter for child in list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Exp getExp(int i) {
    return (Exp)getExpList().getChild(i);
  }
  /**
   * Add element to list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:27
   */
  public void addExp(Exp node) {
    List<Exp> list = (parent == null || state == null) ? getExpListNoTransform() : getExpList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:34
   */
  public void addExpNoTransform(Exp node) {
    List<Exp> list = getExpListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:42
   */
  public void setExp(Exp node, int i) {
    List<Exp> list = getExpList();
    list.setChild(node, i);
  }
  /**
   * Getter for Exp list.
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:50
   */
  public List<Exp> getExps() {
    return getExpList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:56
   */
  public List<Exp> getExpsNoTransform() {
    return getExpListNoTransform();
  }
  /**
   * Getter for list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Exp> getExpList() {
    List<Exp> list = (List<Exp>)getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Exp> getExpListNoTransform() {
    return (List<Exp>)getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
