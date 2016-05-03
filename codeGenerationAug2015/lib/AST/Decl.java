package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:3
 */
public abstract class Decl extends ASTNode<ASTNode> implements Cloneable {
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
  public Decl clone() throws CloneNotSupportedException {
    Decl node = (Decl)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @ast method 
   * @aspect CS_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:240
   */
  public void CS_emitTypeRegister(CS_env env) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitTypeRegister(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:258
   */
  public void CS_emitClass(CS_env env) {
    throw new Error(this.getClass().getName() + 
		    ".CS_emitClass(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:485
   */
  public void CS_emitDecoder(CS_env env) {
    env.print("public static ");
    getType().CS_emitType(env);
    env.println(" decode(LabCommDecoder d) {");
    env.indent();
    if (!isVoid()) {
      getType().CS_emitType(env);
      env.println(" result;");
      getType().CS_emitDecoder(env, "result");
      env.println("return result;");
    }
    env.unindent();
    env.println("}");
    env.println();
  }
  /**
   * @ast method 
   * @aspect CS_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:767
   */
  public void CS_info(CS_env env, String namespace) {
    throw new Error(this.getClass().getName() + 
		    ".CS_info(CS_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:230
   */
  public void C_emitType(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitType(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Declarations
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:338
   */
  public void C_emitDecoderDeclaration(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Declarations
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:365
   */
  public void C_emitEncoderDeclaration(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:433
   */
  public void C_emitDecoder(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitDecoder(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:614
   */
  public void C_emitDecoderRegisterHandler(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitDecoderRegisterHandler(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_DecoderIoctl
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:656
   */
  public void C_emitDecoderIoctl(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitDecoderIoctl(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:693
   */
  public void C_emitEncoder(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitEncoder()" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:801
   */
  public void C_emitEncoderRegisterHandler(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitEncoderRegisterHandler(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_EncoderIoctl
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:834
   */
  public void C_emitEncoderIoctl(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitEncoderIoctl()" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:883
   */
  public void C_emitSignature(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1003
   */
  public void C_emitSizeofDeclaration(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1011
   */
  public int C_fixedSizeof() {
    return getType().C_fixedSizeof();
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1063
   */
  public void C_emitSizeof(C_env env) {
  }
  /**
   * @ast method 
   * @aspect C_forAll
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1174
   */
  public String C_forAll(C_env env) {
    return null;
  }
  /**
   * @ast method 
   * @aspect C_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1193
   */
  public void C_info(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_info((C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:298
   */
  public void Java_emitTypeRegister(Java_env env) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitTypeRegister(Java_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:316
   */
  public void Java_emitClass(Java_env env, String pack) {
    throw new Error(this.getClass().getName() + 
		    ".Java_emitClass(Java_env env, String pack)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:560
   */
  public void Java_emitDecoder(Java_env env) {
    env.print("public static ");
    getType().Java_emitType(env);
    env.println(" decode(LabCommDecoder d) throws IOException {");
    env.indent();
    if (!isVoid()) {
      getType().Java_emitType(env);
      env.println(" result;");
      getType().Java_emitDecoder(env, "result");
      env.println("return result;");
    }
    env.unindent();
    env.println("}");
    env.println();
  }
  /**
   * @ast method 
   * @aspect Java_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:832
   */
  public void Java_info(Java_env env) {
    throw new Error(this.getClass().getName() + 
		    ".Java_info(Java_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:46
   */
  public void nameCheck() {
    if (lookupType(getName()) != null || lookupName(getName()) != null) {
      error(getName() + " multiply declared");
    }
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:113
   */
  public void Python_genSignature(Python_env env) {
    throw new Error(this.getClass().getName() + 
                    ".Python_genSignature(Python_env env)" + 
                    " not declared");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:192
   */
  public void Python_genTypedefListEntry(Python_env env) {
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:199
   */
  public void Python_genSampleListEntry(Python_env env) {
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:94
   */
  public void RAPID_gen(RAPID_env env) {
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:95
   */
  public SignatureList signature() {
    SignatureList result = new SignatureList();
    flatSignature(result);
    return result;
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public Decl() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public Decl(Type p0, String p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public Decl(Type p0, beaver.Symbol p1) {
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
   * @attribute syn
   * @aspect CS_Void
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:190
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
  private boolean CS_isVoid_compute() {  return getType().CS_isVoid();  }
  /**
   * @attribute syn
   * @aspect C_IsDynamic
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:130
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
  private boolean C_isDynamic_compute() {  return getType().C_isDynamic();  }
  /**
   * @attribute syn
   * @aspect Java_Void
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:190
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
  private boolean isVoid_compute() {  return getType().isVoid();  }
  /**
   * @attribute inh
   * @aspect CS_StructName
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:172
   */
  @SuppressWarnings({"unchecked", "cast"})
  public int CS_Depth() {
      ASTNode$State state = state();
    int CS_Depth_value = getParent().Define_int_CS_Depth(this, null);
    return CS_Depth_value;
  }
  /**
   * @attribute inh
   * @aspect Java_StructName
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:172
   */
  @SuppressWarnings({"unchecked", "cast"})
  public int Java_Depth() {
      ASTNode$State state = state();
    int Java_Depth_value = getParent().Define_int_Java_Depth(this, null);
    return Java_Depth_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:4
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String lookupName(String name) {
      ASTNode$State state = state();
    String lookupName_String_value = getParent().Define_String_lookupName(this, null, name);
    return lookupName_String_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:25
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
