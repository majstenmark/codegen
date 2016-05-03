package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:1
 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
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
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Program copy() {
      try {
        Program node = (Program)clone();
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
  public Program fullCopy() {
    Program res = (Program)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect CS_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:198
   */
  public void CS_gen(String file, 
			     String namespace) throws IOException {
    // Registration class
    CS_env env = new CS_env(new File(file));
    if (namespace != null && namespace.length() > 0) {
      env.println("namespace " + namespace + "{");
      env.indent();
    }
    env.println("using System;");
    env.println("using se.lth.control.labcomm;");
    for (int i = 0; i < getNumDecl(); i++) {
      Decl d = getDecl(i);
      try {
        d.CS_emitClass(env);
      } catch (Error e) {
	System.err.println(d.getName());
	throw e;
      }
    }
    if (namespace != null && namespace.length() > 0) {
      env.unindent();
      env.println("}");
    }
  }
  /**
   * @ast method 
   * @aspect CS_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:227
   */
  public void CS_emitTypeRegister(CS_env env) {
    /*
    env.println("static void register(LabCommChannel c) {");
    env.indent();
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).CS_emitTypeRegister(env);
    }
    env.unindent();
    env.println("}");
*/

  }
  /**
   * @ast method 
   * @aspect CS_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:755
   */
  public void CS_info(PrintStream out, String namespace) {
    CS_env env = new CS_env(out);
    if (namespace == null) {
      namespace = ""; 
    } else {
      namespace = namespace + "."; 
    }
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).CS_info(env, namespace);
    }
  }
  /**
   * @ast method 
   * @aspect C_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:149
   */
  public void C_genH(PrintStream out, Vector includes, 
			     String lcName, String prefix) {
    C_env env = new C_env("", lcName, prefix, out);

    // Hackish prettyprint preamble
    out.println("/* LabComm declarations:");
    pp(out);
    out.println("*/");
    env.println("");
    env.println("");
    env.println("#ifndef __LABCOMM_" + env.lcName + "_H__"); 
    env.println("#define __LABCOMM_" + env.lcName + "_H__");
    env.println("");

    // Include
    env.println("#include <stdint.h>");
    env.println("#include \"labcomm.h\"");
    for (int i = 0 ; i < includes.size() ; i++) {
      env.println("#include \"" + includes.get(i) + "\"");
    }
    env.println("");

    C_emitH(env);

    env.println("#endif");
  }
  /**
   * @ast method 
   * @aspect C_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:176
   */
  public void C_genC(PrintStream out, Vector includes, 
			     String lcName, String prefix) {
    C_env env = new C_env("", lcName, prefix, out);

    // Include
    env.println("#include \"labcomm.h\"");
    env.println("#include \"labcomm_private.h\"");
    for (int i = 0 ; i < includes.size() ; i++) {
      env.println("#include \"" + includes.get(i) + "\"");
    }
    env.println("");
    
    // Method Implementations
    C_emitC(env);
  }
  /**
   * @ast method 
   * @aspect C_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:192
   */
  public void C_emitH(C_env env) {
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).C_emitType(env);
      getDecl(i).C_emitDecoderDeclaration(env);
      getDecl(i).C_emitEncoderDeclaration(env);
      getDecl(i).C_emitSizeofDeclaration(env);
      env.println("");
    }
    C_emitForAll(env);
  }
  /**
   * @ast method 
   * @aspect C_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:203
   */
  public void C_emitC(C_env env) {
    C_emitSignature(env);
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).C_emitDecoder(env);
      getDecl(i).C_emitDecoderRegisterHandler(env);
      getDecl(i).C_emitDecoderIoctl(env);
      getDecl(i).C_emitEncoder(env);
      getDecl(i).C_emitEncoderRegisterHandler(env);
      getDecl(i).C_emitEncoderIoctl(env);
      getDecl(i).C_emitSizeof(env);
    }
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:877
   */
  public void C_emitSignature(C_env env) {
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).C_emitSignature(env);
    }
  }
  /**
   * @ast method 
   * @aspect C_forAll
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1156
   */
  public void C_emitForAll(C_env env) {
    env.print("#define LABCOMM_FORALL_SAMPLES_" + env.lcName + 
		"(func, sep)");
    env.indent();
    boolean needSeparator = false;
    for (int i = 0; i < getNumDecl(); i++) {
      String s = getDecl(i).C_forAll(env);
      if (s != null) {
	if (needSeparator) { env.print(" sep"); }
	env.println(" \\");
	env.print(s);
	needSeparator = true;
      }
    }
    env.println("");
    env.unindent();
  }
  /**
   * @ast method 
   * @aspect C_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1186
   */
  public void C_info(PrintStream out, String prefix) {
    C_env env = new C_env("", "", prefix, out);
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).C_info(env);
    }
  }
  /**
   * @ast method 
   * @aspect Java_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:198
   */
  public void J_gen(PrintStream ps, String pack) throws IOException {
    Java_env env;
/*
    // Registration class
    env = new Java_env(ps);
    if (pack != null && pack.length() > 0) {
      env.println("package " + pack + ";");
    }
    env.println("public class LabCommRegister {");
    env.println();
    env.indent();
    Java_emitTypeRegister(env);
    env.unindent();
    env.println();
    env.println("}");
//    env.close();
*/
    env = new Java_env(ps);
    for (int i = 0; i < getNumDecl(); i++) {
      Decl d = getDecl(i);
      try {
        d.Java_emitClass(env, pack);
      } catch (Error e) {
	System.err.println(d.getName());
	throw e;
      }
    }
    env.close();
  }
  /**
   * @ast method 
   * @aspect Java_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:228
   */
  public void J_gen(String dir, String pack) throws IOException {
    Java_env env;
/*
    // Registration class
    env = new Java_env(new File(dir, "LabCommRegister.java"));
    if (pack != null && pack.length() > 0) {
      env.println("package " + pack + ";");
    }
    env.println("public class LabCommRegister {");
    env.println();
    env.indent();
    Java_emitTypeRegister(env);
    env.unindent();
    env.println();
    env.println("}");
    env.close();
*/
    for (int i = 0; i < getNumDecl(); i++) {
      Decl d = getDecl(i);
      try {
        env = new Java_env(new File(dir, d.getName() + ".java"));
        d.Java_emitClass(env, pack);
        env.close();
      } catch (Error e) {
	System.err.println(d.getName());
	throw e;
      }
    }
  }
  /** Experimental method for generating code to a map <classname, source> 
    * @ast method 
   * @aspect Java_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:260
   */
  public void J_gen(Map<String,String> src, String pack) throws IOException {
    Java_env env;
/*
    // Registration class was commented out, so got removed in this copy
*/
    for (int i = 0; i < getNumDecl(); i++) {
      Decl d = getDecl(i);
      try {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bs);
        env = new Java_env(out);
        d.Java_emitClass(env, pack);
        env.close();
        src.put(d.getName(), bs.toString());
      } catch (Error e) {
	System.err.println(d.getName());
	throw e;
      }
    }
  }
  /**
   * @ast method 
   * @aspect Java_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:285
   */
  public void Java_emitTypeRegister(Java_env env) {
    /*
    env.println("static void register(LabCommChannel c) {");
    env.indent();
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).Java_emitTypeRegister(env);
    }
    env.unindent();
    env.println("}");
*/

  }
  /**
   * @ast method 
   * @aspect Java_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:825
   */
  public void Java_info(PrintStream out) {
    Java_env env = new Java_env(out);
    for (int i = 0; i < getNumDecl(); i++) {
      getDecl(i).Java_info(env);
    }
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:21
   */
  public void pp(PrintStream out) {
    for(int i = 0; i < getNumDecl(); i++) {
    	getDecl(i).pp(out);
    }
  }
  /**
   * @ast method 
   * @aspect Python_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:75
   */
  public void Python_gen(PrintStream out, String baseName) {
    Python_env env = new Python_env(out);
    env.println("#!/usr/bin/python");
    env.println("# Auto generated " + baseName);
    env.println();
    env.println("import labcomm");
    env.println();
    Python_genTypes(env);
    env.println("typedef = [");
    env.indent();
    for (int i = 0 ; i < getNumDecl() ; i++) {
      getDecl(i).Python_genTypedefListEntry(env);
    }
    env.unindent();
    env.println("]");
    env.println("sample = [");
    env.indent();
    for (int i = 0 ; i < getNumDecl() ; i++) {
      getDecl(i).Python_genSampleListEntry(env);
    }
    env.unindent();
    env.println("]");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:103
   */
  public void Python_genTypes(Python_env env) {
    for (int i = 0 ; i < getNumDecl() ; i++) {
      env.println("class " + getDecl(i).getName() + "(object):");
      env.indent();
      getDecl(i).Python_genSignature(env);
      env.unindent();
      env.println();
    }
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:78
   */
  public void RAPID_gen(String file, String prefix)
			throws IOException
	{
		PrintStream ps = new PrintStream(new FileOutputStream(new File(file)));
		RAPID_env env = new RAPID_env(ps, prefix);
		RAPID_gen(env);
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:86
   */
  public void RAPID_gen(RAPID_env env)
	{
		for (int i = 0; i < getNumDecl(); i++) {
			getDecl(i).RAPID_gen(env);
		}
		env.flush();
	}
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public Program() {
    super();

    setChild(new List(), 0);
    is$Final(true);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:9
   */
  public Program(List<Decl> p0) {
    setChild(p0, 0);
    is$Final(true);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:16
   */
  protected int numChildren() {
    return 1;
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
   * Setter for DeclList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setDeclList(List<Decl> list) {
    setChild(list, 0);
  }
  /**
   * @return number of children in DeclList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public int getNumDecl() {
    return getDeclList().getNumChild();
  }
  /**
   * Getter for child in list DeclList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Decl getDecl(int i) {
    return (Decl)getDeclList().getChild(i);
  }
  /**
   * Add element to list DeclList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:27
   */
  public void addDecl(Decl node) {
    List<Decl> list = (parent == null || state == null) ? getDeclListNoTransform() : getDeclList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:34
   */
  public void addDeclNoTransform(Decl node) {
    List<Decl> list = getDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list DeclList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:42
   */
  public void setDecl(Decl node, int i) {
    List<Decl> list = getDeclList();
    list.setChild(node, i);
  }
  /**
   * Getter for Decl list.
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:50
   */
  public List<Decl> getDecls() {
    return getDeclList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:56
   */
  public List<Decl> getDeclsNoTransform() {
    return getDeclListNoTransform();
  }
  /**
   * Getter for list DeclList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Decl> getDeclList() {
    List<Decl> list = (List<Decl>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Decl> getDeclListNoTransform() {
    return (List<Decl>)getChildNoTransform(0);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:174
   * @apilevel internal
   */
  public int Define_int_CS_Depth(ASTNode caller, ASTNode child) {
    if(caller == getDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return 0;
    }
    return getParent().Define_int_CS_Depth(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:178
   * @apilevel internal
   */
  public String Define_String_CS_structName(ASTNode caller, ASTNode child) {
    if(caller == getDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return getDecl(i).getName();
    }
    return getParent().Define_String_CS_structName(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:174
   * @apilevel internal
   */
  public int Define_int_Java_Depth(ASTNode caller, ASTNode child) {
    if(caller == getDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return 0;
    }
    return getParent().Define_int_Java_Depth(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:178
   * @apilevel internal
   */
  public String Define_String_Java_structName(ASTNode caller, ASTNode child) {
    if(caller == getDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return getDecl(i).getName();
    }
    return getParent().Define_String_Java_structName(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:5
   * @apilevel internal
   */
  public String Define_String_lookupName(ASTNode caller, ASTNode child, String name) {
    if(caller == getDeclListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
{
    for (int i = 0; i < index; i++) {
      String s = getDecl(i).getName();
      if (s.equals(name)) {
      	return s;
      }
    }
    return null;
  }
}
    return getParent().Define_String_lookupName(this, caller, name);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:27
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_lookupType(ASTNode caller, ASTNode child, String name) {
    if(caller == getDeclListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
{
    for(int i = 0; i < index; i++) {
      Decl d = getDecl(i);  
      if(d instanceof TypeDecl && d.getName().equals(name)) {
	return (TypeDecl)d;
      }
    }
    return null;
  }
}
    return getParent().Define_TypeDecl_lookupType(this, caller, name);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:9
   * @apilevel internal
   */
  public String Define_String_pp_indent(ASTNode caller, ASTNode child) {
    if(caller == getDeclListNoTransform()) {
      int index = caller.getIndexOfChild(child);
      return "";
    }
    return getParent().Define_String_pp_indent(this, caller);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
