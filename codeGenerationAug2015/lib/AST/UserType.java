package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:12
 */
public class UserType extends Type implements Cloneable {
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
  public UserType clone() throws CloneNotSupportedException {
    UserType node = (UserType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public UserType copy() {
      try {
        UserType node = (UserType)clone();
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
  public UserType fullCopy() {
    UserType res = (UserType)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:477
   */
  public void CS_emitEncoder(CS_env env, String name) {
    if (CS_needInstance()) {
      env.println(getName() + ".encode(e, " + name + ");");
    } else {
      decl().getType().CS_emitEncoder(env, name);
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:587
   */
  public void CS_emitDecoder(CS_env env, String name) {
    if (CS_needInstance()) {
      env.println(name + " = " + getName() + ".decode(d);");
    } else {
      decl().getType().CS_emitDecoder(env, name);
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:608
   */
  public void CS_emitTypePrefix(CS_env env) {
    if (CS_needInstance()) {
      env.print(getName());
    } else {
      decl().getType().CS_emitTypePrefix(env);
    } 
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:627
   */
  public void CS_emitTypeSuffix(CS_env env) {
    if (! CS_needInstance()) {
      decl().getType().CS_emitTypeSuffix(env);
    } 
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:652
   */
  public boolean CS_needInstance() {
    return decl().getType().CS_needInstance();
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:706
   */
  public void CS_emitInstance(CS_env env) {
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:733
   */
  public void CS_emitType(CS_env env) {
    decl().getType().CS_emitType(env);
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:276
   */
  public void C_emitType(C_env env, String name) {
    env.print(env.prefix + getName() + " " + name);
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:485
   */
  public void C_emitDecoder(C_env env) {
    lookupType(getName()).getType().C_emitDecoder(env);
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:565
   */
  public void C_emitDecoderDeallocation(C_env env) {
    if (C_isDynamic()) {
      lookupType(getName()).getType().C_emitDecoderDeallocation(env);
    }
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:750
   */
  public void C_emitEncoder(C_env env) {
    lookupType(getName()).getType().C_emitEncoder(env);
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:937
   */
  public void C_genFlatSignature(C_env env) {
    lookupType(getName()).C_genFlatSignature(env);
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1042
   */
  public int C_fixedSizeof() {
    return lookupType(getName()).getType().C_fixedSizeof();
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1102
   */
  public void C_emitSizeof(C_env env) {
    lookupType(getName()).getType().C_emitSizeof(env);
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:552
   */
  public void Java_emitEncoder(Java_env env, String name) {
    if (Java_needInstance()) {
      env.println(getName() + ".encode(e, " + name + ");");
    } else {
      decl().getType().Java_emitEncoder(env, name);
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:647
   */
  public void Java_emitDecoder(Java_env env, String name) {
    if (Java_needInstance()) {
      env.println(name + " = " + getName() + ".decode(d);");
    } else {
      decl().getType().Java_emitDecoder(env, name);
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:684
   */
  public void Java_emitTypePrefix(Java_env env) {
    if (Java_needInstance()) {
      env.print(getName());
    } else {
      decl().getType().Java_emitTypePrefix(env);
    } 
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:703
   */
  public void Java_emitTypeSuffix(Java_env env) {
    if (! Java_needInstance()) {
      decl().getType().Java_emitTypeSuffix(env);
    } 
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:726
   */
  public boolean Java_needInstance() {
    return decl().getType().Java_needInstance();
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:780
   */
  public void Java_emitInstance(Java_env env) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:806
   */
  public void Java_emitType(Java_env env) {
    decl().getType().Java_emitType(env);
  }
  /**
   * @ast method 
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:58
   */
  public void nameCheck() {
    if (decl() == null) {
      error("Use of undeclared type");
    } 
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:75
   */
  public void ppPrefix(PrintStream out) { 
    out.print(getName());
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:135
   */
  public void Python_genSignature(Python_env env) {
    lookupType(getName()).getType().Python_genSignature(env);
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:124
   */
  public void flatSignature(SignatureList list) {
    lookupType(getName()).flatSignature(list);
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:190
   */
  public String signatureComment() {
    return getName();
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public UserType() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public UserType(String p0) {
    setName(p0);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:10
   */
  public UserType(beaver.Symbol p0) {
    setName(p0);
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
   * Setter for lexeme Name
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setName(String value) {
    tokenString_Name = value;
  }
  /**   * @apilevel internal   * @ast method 
   * @declaredat LabComm.ast:8
   */
  
  /**   * @apilevel internal   */  protected String tokenString_Name;
  /**
   * @ast method 
   * @declaredat LabComm.ast:9
   */
  
  public int Namestart;
  /**
   * @ast method 
   * @declaredat LabComm.ast:10
   */
  
  public int Nameend;
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public void setName(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
      throw new UnsupportedOperationException("setName is only valid for String lexemes");
    tokenString_Name = (String)symbol.value;
    Namestart = symbol.getStart();
    Nameend = symbol.getEnd();
  }
  /**
   * Getter for lexeme Name
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:22
   */
  public String getName() {
    return tokenString_Name != null ? tokenString_Name : "";
  }
  /**
   * @attribute syn
   * @aspect C_IsDynamic
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:133
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
  private boolean C_isDynamic_compute() {  return lookupType(getName()).getType().C_isDynamic();  }
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:37
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDecl decl() {
      ASTNode$State state = state();
    TypeDecl decl_value = decl_compute();
    return decl_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl decl_compute() {  return lookupType(getName());  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:26
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDecl lookupType(String name) {
      ASTNode$State state = state();
    TypeDecl lookupType_String_value = getParent().Define_TypeDecl_lookupType(this, null, name);
    return lookupType_String_value;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
