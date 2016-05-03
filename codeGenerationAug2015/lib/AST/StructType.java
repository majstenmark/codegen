package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:13
 */
public class StructType extends Type implements Cloneable {
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
  public StructType clone() throws CloneNotSupportedException {
    StructType node = (StructType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public StructType copy() {
      try {
        StructType node = (StructType)clone();
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
  public StructType fullCopy() {
    StructType res = (StructType)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:470
   */
  public void CS_emitEncoder(CS_env env, String name) {
    for (int i = 0 ; i < getNumField() ; i++) {
      Field f = getField(i);
      f.getType().CS_emitEncoder(env, name + "." + f.getName());
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:577
   */
  public void CS_emitDecoder(CS_env env, String name) {
    env.print(name + " = new ");
    CS_emitType(env);
    env.println("();");
    for (int i = 0 ; i < getNumField() ; i++) {
      Field f = getField(i);
      f.getType().CS_emitDecoder(env, name + "." + f.getName());
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:620
   */
  public void CS_emitTypePrefix(CS_env env){
    env.print(CS_structName());
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:656
   */
  public boolean CS_needInstance() {
    return true;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:688
   */
  public void CS_emitInstance(CS_env env) {
    if (CS_Depth() > 0) {
      env.println("public class " + CS_structName() + " {");
      env.indent();
    }
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).getType().CS_emitInstance(env);
    }
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).CS_emitField(env);
    }
    if (CS_Depth() > 0) {
      env.unindent();
      env.println("}");
    }
    env.println();
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:747
   */
  public void CS_emitType(CS_env env){
    env.print(CS_structName());
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:280
   */
  public void C_emitType(C_env env, String name) {
    env.println("struct {");
    env.indent();
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).C_emitType(env);
      env.println(";");
    }
    env.unindent();
    env.print("} " + name);
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:489
   */
  public void C_emitDecoder(C_env env) {
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).C_emitDecoder(env);
    }
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:571
   */
  public void C_emitDecoderDeallocation(C_env env) {
    if (C_isDynamic()) {
      for (int i = 0 ; i < getNumField() ; i++) {
	getField(i).C_emitDecoderDeallocation(env);
      }
    }
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:754
   */
  public void C_emitEncoder(C_env env) {
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).C_emitEncoder(env);
    }
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:953
   */
  public void C_genFlatSignature(C_env env) {
    C_genFlatSignature(env, LABCOMM_STRUCT);
    env.println("// LABCOMM_STRUCT");
    C_genFlatSignature(env, getNumField());
    env.println("// # of fields");
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).C_genFlatSignature(env);
    }
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1046
   */
  public int C_fixedSizeof() {
    int result = 0;
    for (int i = 0 ; i < getNumField() ; i++) {
      result += getField(i).getType().C_fixedSizeof();
    }
    return result;
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1106
   */
  public void C_emitSizeof(C_env env) {
    int fixed = 0;
    for (int i = 0 ; i < getNumField() ; i++) {
      if (getField(i).getType().C_isDynamic()) {
	getField(i).getType().C_emitSizeof(
	  env.nestStruct("." + getField(i).getName()));
      } else {
	fixed += getField(i).getType().C_fixedSizeof();
      }
    }
    if (fixed > 0) {
      env.println("result += " + fixed + ";");
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:545
   */
  public void Java_emitEncoder(Java_env env, String name) {
    for (int i = 0 ; i < getNumField() ; i++) {
      Field f = getField(i);
      f.getType().Java_emitEncoder(env, name + "." + f.getName());
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:637
   */
  public void Java_emitDecoder(Java_env env, String name) {
    env.print(name + " = new ");
    Java_emitType(env);
    env.println("();");
    for (int i = 0 ; i < getNumField() ; i++) {
      Field f = getField(i);
      f.getType().Java_emitDecoder(env, name + "." + f.getName());
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:696
   */
  public void Java_emitTypePrefix(Java_env env){
    env.print(Java_structName());
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:730
   */
  public boolean Java_needInstance() {
    return true;
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:762
   */
  public void Java_emitInstance(Java_env env) {
    if (Java_Depth() > 0) {
      env.println("public static class " + Java_structName() + " {");
      env.indent();
    }
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).getType().Java_emitInstance(env);
    }
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).Java_emitField(env);
    }
    if (Java_Depth() > 0) {
      env.unindent();
      env.println("}");
    }
    env.println();
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:817
   */
  public void Java_emitType(Java_env env){
    env.print(Java_structName());
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:83
   */
  public void ppPrefix(PrintStream out) {
    out.println("struct {");
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).pp(out);
    }
    out.print(pp_indent());
    out.print("}");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:171
   */
  public void Python_genSignature(Python_env env) {
    env.println("labcomm.struct([");
    env.indent();
    for (int i = 0 ; i < getNumField() ; i++) {
      if (i > 0) { env.println(","); }
      getField(i).Python_genSignature(env);
    }
    env.print("])");
    env.unindent();
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:198
   */
  public String RAPID_AddType(RAPID_env env, String name) {
		ArrayList<String> components = new ArrayList<String>();
		for (int i = 0; i < getNumField(); i++) {
			Field f = getField(i);
			components.add(
					f.getType().RAPID_AddType(env, name + "_" + f.getName()) +
					" " + f.getName() + ";");
		}
		String typeName = env.addRecord(name, components);
		return typeName;
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:246
   */
  public void RAPID_AddDecodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		for (int i = 0; i < getNumField(); i++) {
			getField(i).getType().RAPID_AddDecodeInstr(env, instrs,
					var_name + "." + getField(i).getName(), stream_name);
		}
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:300
   */
  public void RAPID_AddEncodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		for (int i = 0; i < getNumField(); i++) {
			getField(i).getType().RAPID_AddEncodeInstr(env, instrs,
					var_name + "." + getField(i).getName(), stream_name);
		}
	}
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:140
   */
  public void flatSignature(SignatureList list) {
    list.addInt(LABCOMM_STRUCT, "struct { " + getNumField() + " fields");
    list.indent();
    list.addInt(getNumField(), null);
    for (int i = 0 ; i < getNumField() ; i++) {
      getField(i).flatSignature(list);
    }
    list.unindent();
    list.add(null, "}");
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:194
   */
  public String signatureComment() {
    return "struct";
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public StructType() {
    super();

    setChild(new List(), 0);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
   */
  public StructType(List<Field> p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:14
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:20
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for FieldList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setFieldList(List<Field> list) {
    setChild(list, 0);
  }
  /**
   * @return number of children in FieldList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public int getNumField() {
    return getFieldList().getNumChild();
  }
  /**
   * Getter for child in list FieldList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Field getField(int i) {
    return (Field)getFieldList().getChild(i);
  }
  /**
   * Add element to list FieldList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:27
   */
  public void addField(Field node) {
    List<Field> list = (parent == null || state == null) ? getFieldListNoTransform() : getFieldList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:34
   */
  public void addFieldNoTransform(Field node) {
    List<Field> list = getFieldListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list FieldList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:42
   */
  public void setField(Field node, int i) {
    List<Field> list = getFieldList();
    list.setChild(node, i);
  }
  /**
   * Getter for Field list.
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:50
   */
  public List<Field> getFields() {
    return getFieldList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:56
   */
  public List<Field> getFieldsNoTransform() {
    return getFieldListNoTransform();
  }
  /**
   * Getter for list FieldList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Field> getFieldList() {
    List<Field> list = (List<Field>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Field> getFieldListNoTransform() {
    return (List<Field>)getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect C_IsDynamic
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:135
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
  private boolean C_isDynamic_compute() {
    for (int i = 0 ; i < getNumField() ; i++) {
      if (getField(i).getType().C_isDynamic()) {
	return true;
      }
    }
    return false;
  }
  /**
   * @attribute inh
   * @aspect PPIndentation
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:7
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String pp_indent() {
      ASTNode$State state = state();
    String pp_indent_value = getParent().Define_String_pp_indent(this, null);
    return pp_indent_value;
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:175
   * @apilevel internal
   */
  public int Define_int_CS_Depth(ASTNode caller, ASTNode child) {
    if(caller == getFieldListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return CS_Depth() + 1;
    }
    return getParent().Define_int_CS_Depth(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:179
   * @apilevel internal
   */
  public String Define_String_CS_structName(ASTNode caller, ASTNode child) {
    if(caller == getFieldListNoTransform()) { 
   int i = caller.getIndexOfChild(child);
{
    if (CS_Depth() == 0) {
      return "struct_" + getField(i).getName();
    } else {
      return CS_structName() + "_" + getField(i).getName();
    }
  }
}
    return getParent().Define_String_CS_structName(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:175
   * @apilevel internal
   */
  public int Define_int_Java_Depth(ASTNode caller, ASTNode child) {
    if(caller == getFieldListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return Java_Depth() + 1;
    }
    return getParent().Define_int_Java_Depth(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:179
   * @apilevel internal
   */
  public String Define_String_Java_structName(ASTNode caller, ASTNode child) {
    if(caller == getFieldListNoTransform()) { 
   int i = caller.getIndexOfChild(child);
{
    if (Java_Depth() == 0) {
      return "struct_" + getField(i).getName();
    } else {
      return Java_structName() + "_" + getField(i).getName();
    }
  }
}
    return getParent().Define_String_Java_structName(this, caller);
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:15
   * @apilevel internal
   */
  public String Define_String_lookupName(ASTNode caller, ASTNode child, String name) {
    if(caller == getFieldListNoTransform()) { 
   int index = caller.getIndexOfChild(child);
{
    for (int i = 0; i < index; i++) {
      String s = getField(i).getName();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:8
   * @apilevel internal
   */
  public String Define_String_pp_indent(ASTNode caller, ASTNode child) {
    if(caller == getFieldListNoTransform()) {
      int index = caller.getIndexOfChild(child);
      return pp_indent() + "  ";
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
