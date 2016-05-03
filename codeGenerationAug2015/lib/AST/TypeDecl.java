package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:4
 */
public class TypeDecl extends Decl implements Cloneable {
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
  public TypeDecl clone() throws CloneNotSupportedException {
    TypeDecl node = (TypeDecl)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDecl copy() {
      try {
        TypeDecl node = (TypeDecl)clone();
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
  public TypeDecl fullCopy() {
    TypeDecl res = (TypeDecl)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect CS_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:250
   */
  public void CS_emitTypeRegister(CS_env env) {
    // TODO
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:264
   */
  public void CS_emitClass(CS_env env) {
    if (getType().CS_needInstance()) {
      // Hackish prettyprint preamble
      env.println("/* ");
      pp(env.getPrintStream());
      env.println("*/");
      env.println();
      env.println("public class " + getName() + " : LabCommType {");
      env.println();
      env.indent();
      getType().CS_emitInstance(env);
      CS_emitEncoder(env);
      CS_emitDecoder(env);
      env.unindent();
      env.println("}");
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:376
   */
  public void CS_emitEncoder(CS_env env) {
    env.print("public static void encode(LabCommEncoder e");
    if (!isVoid()) {
      env.print(", ");
      getType().CS_emitType(env);
      env.print(" value");
    }
    env.println(") {");
    env.indent();
    getType().CS_emitEncoder(env, "value");
    env.unindent();
    env.println("}");
    env.println();
  }
  /**
   * @ast method 
   * @aspect CS_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:773
   */
  public void CS_info(CS_env env, String namespace) {
    env.print(";C#;typedef;" + namespace + getName() + ";");
    getType().CS_emitType(env);
    env.println();
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:236
   */
  public void C_emitType(C_env env) {
    env.println("#ifndef PREDEFINED_" + env.prefix + getName());
    env.print("typedef ");
    getType().C_emitType(env, env.prefix + getName());
    env.println(";");
    env.println("#endif");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:439
   */
  public void C_emitDecoder(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:620
   */
  public void C_emitDecoderRegisterHandler(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_DecoderIoctl
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:662
   */
  public void C_emitDecoderIoctl(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:699
   */
  public void C_emitEncoder(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:807
   */
  public void C_emitEncoderRegisterHandler(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_EncoderIoctl
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:840
   */
  public void C_emitEncoderIoctl(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:924
   */
  public void C_genFlatSignature(C_env env) {
    getType().C_genFlatSignature(env);
  }
  /**
   * @ast method 
   * @aspect C_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1199
   */
  public void C_info(C_env env) {
    env.println(",C,typedef," + env.prefix + getName() + "," + 
                 env.prefix + getName());
  }
  /**
   * @ast method 
   * @aspect Java_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:308
   */
  public void Java_emitTypeRegister(Java_env env) {
    // TODO
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:322
   */
  public void Java_emitClass(Java_env env, String pack) {
    if (getType().Java_needInstance()) {
      // Hackish prettyprint preamble
      env.println("/* ");
      pp(env.getPrintStream());
      env.println("*/");

      if (pack != null && pack.length() > 0) {
        env.println("package " + pack + ";");
      }

      env.println("import java.io.IOException;");
      env.println("import se.lth.control.labcomm.LabCommType;");
      env.println("import se.lth.control.labcomm.LabCommEncoder;");
      env.println("import se.lth.control.labcomm.LabCommDecoder;");
      env.println();
      env.println("public class " + getName() + " implements LabCommType {");
      env.println();
      env.indent();
      getType().Java_emitInstance(env);
      Java_emitEncoder(env);
      Java_emitDecoder(env);
      env.unindent();
      env.println("}");
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:455
   */
  public void Java_emitEncoder(Java_env env) {
    env.print("public static void encode(LabCommEncoder e");
    if (!isVoid()) {
      env.print(", ");
      getType().Java_emitType(env);
      env.print(" value");
    }
    env.println(") throws IOException {");
    env.indent();
    getType().Java_emitEncoder(env, "value");
    env.unindent();
    env.println("}");
    env.println();
  }
  /**
   * @ast method 
   * @aspect Java_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:838
   */
  public void Java_info(Java_env env) {
    env.print(",Java,typedef," + getName() + ",");
    getType().Java_emitType(env);
    env.println();
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:28
   */
  public void pp(PrintStream out) {
    out.print("typedef ");
    getType().ppIdentifier(out, getName());
    out.println(";");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:119
   */
  public void Python_genSignature(Python_env env) {
    env.println("signature = labcomm.typedef('" + getName() + "',");
    env.indent();
    getType().Python_genSignature(env);
    env.unindent();
    env.println(")");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:195
   */
  public void Python_genTypedefListEntry(Python_env env) {
    env.println("('" + getName() + "', " + getName() + ".signature),");
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:107
   */
  public void flatSignature(SignatureList list) {
    getType().flatSignature(list);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public TypeDecl() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public TypeDecl(Type p0, String p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public TypeDecl(Type p0, beaver.Symbol p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:18
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:24
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
   * Setter for lexeme Name
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setName(String value) {
    tokenString_Name = value;
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
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
   * @declaredat LabComm.ast:19
   */
  public String getName() {
    return tokenString_Name != null ? tokenString_Name : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
