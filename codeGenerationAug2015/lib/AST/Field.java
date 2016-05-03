package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:7
 */
public class Field extends ASTNode<ASTNode> implements Cloneable {
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
  public Field clone() throws CloneNotSupportedException {
    Field node = (Field)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Field copy() {
      try {
        Field node = (Field)clone();
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
  public Field fullCopy() {
    Field res = (Field)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:709
   */
  public void CS_emitField(CS_env env) {
    env.print("public ");
    getType().CS_emitType(env);
    env.println(" " + getName() + ";");    
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:291
   */
  public void C_emitType(C_env env) {
    getType().C_emitType(env, getName());
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:520
   */
  public void C_emitDecoder(C_env env) {
    getType().C_emitDecoder(env.nestStruct("." + getName()));
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:610
   */
  public void C_emitDecoderDeallocation(C_env env) {
    getType().C_emitDecoderDeallocation(env.nestStruct("." + getName()));
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:784
   */
  public void C_emitEncoder(C_env env) {
    getType().C_emitEncoder(env.nestStruct("." + getName()));
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:963
   */
  public void C_genFlatSignature(C_env env) {
    C_genFlatSignature(env, getName());
    env.println("");
    getType().C_genFlatSignature(env);
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:783
   */
  public void Java_emitField(Java_env env) {
    env.print("public ");
    getType().Java_emitType(env);
    env.println(" " + getName() + ";");    
  }
  /**
   * @ast method 
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:52
   */
  public void nameCheck() {
    if(lookupName(getName()) != null) {
      error(getName() + " multiply declared");
    }
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:40
   */
  public void pp(PrintStream out) {
    out.print(pp_indent());
    getType().ppIdentifier(out, getName());
    out.println(";");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:186
   */
  public void Python_genSignature(Python_env env) {
    env.print("('" + getName() + "', ");
    getType().Python_genSignature(env);
    env.print(")");
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:151
   */
  public void flatSignature(SignatureList list) {
    list.addString(getName(), signatureComment());
    getType().flatSignature(list);
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:182
   */
  public String signatureComment() {
    return getType().signatureComment() + " '" + getName() +"'";
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public Field() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public Field(Type p0, String p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public Field(Type p0, beaver.Symbol p1) {
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
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:14
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String lookupName(String name) {
      ASTNode$State state = state();
    String lookupName_String_value = getParent().Define_String_lookupName(this, null, name);
    return lookupName_String_value;
  }
  /**
   * @attribute inh
   * @aspect PPIndentation
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:6
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
