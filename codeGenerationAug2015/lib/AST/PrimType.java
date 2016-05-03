package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:11
 */
public class PrimType extends Type implements Cloneable {
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
  public PrimType clone() throws CloneNotSupportedException {
    PrimType node = (PrimType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public PrimType copy() {
      try {
        PrimType node = (PrimType)clone();
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
  public PrimType fullCopy() {
    PrimType res = (PrimType)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:417
   */
  public void CS_emitEncoder(CS_env env, String name) {
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { env.print("e.encodeBoolean"); } break;
      case LABCOMM_BYTE: { env.print("e.encodeByte"); } break;
      case LABCOMM_SHORT: { env.print("e.encodeShort"); } break;
      case LABCOMM_INT: { env.print("e.encodeInt"); } break;
      case LABCOMM_LONG: { env.print("e.encodeLong"); } break;
      case LABCOMM_FLOAT: { env.print("e.encodeFloat"); } break;
      case LABCOMM_DOUBLE: { env.print("e.encodeDouble"); } break;
      case LABCOMM_STRING: { env.print("e.encodeString"); } break;
    }
    env.println("(" + name + ");");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:510
   */
  public void CS_emitDecoder(CS_env env, String name) {
    env.print(name + " = ");
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { env.println("d.decodeBoolean();"); } break;
      case LABCOMM_BYTE: { env.println("d.decodeByte();"); } break;
      case LABCOMM_SHORT: { env.println("d.decodeShort();"); } break;
      case LABCOMM_INT: { env.println("d.decodeInt();"); } break;
      case LABCOMM_LONG: { env.println("d.decodeLong();"); } break;
      case LABCOMM_FLOAT: { env.println("d.decodeFloat();"); } break;
      case LABCOMM_DOUBLE: { env.println("d.decodeDouble();"); } break;
      case LABCOMM_STRING: { env.println("d.decodeString();"); } break;
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:601
   */
  public void CS_emitTypePrefix(CS_env env) {
    switch (getToken()) {
      case LABCOMM_STRING: { env.print("String"); } break;
      default: { env.print(getName()); } break;
    }
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:648
   */
  public boolean CS_needInstance() {
    return false;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:668
   */
  public boolean CS_isPrimitive() {
    return true;
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:681
   */
  public void CS_emitInstance(CS_env env) {
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:725
   */
  public void CS_emitType(CS_env env) {
    switch (getToken()) {
      case LABCOMM_STRING: { env.print("String"); } break;
      case LABCOMM_BOOLEAN: { env.print("bool"); } break;
      default: { env.print(getName()); } break;
    }
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:262
   */
  public void C_emitType(C_env env, String name) {
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { env.print("uint8_t"); } break;
      case LABCOMM_BYTE: { env.print("uint8_t"); } break;
      case LABCOMM_SHORT: { env.print("int16_t"); } break;
      case LABCOMM_INT: { env.print("int32_t"); } break;
      case LABCOMM_LONG: { env.print("int64_t"); } break;
      case LABCOMM_FLOAT: { env.print("float"); } break;
      case LABCOMM_DOUBLE: { env.print("double"); } break;
      case LABCOMM_STRING: { env.print("char*"); } break;
    }
    env.print(" " + name);
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:481
   */
  public void C_emitDecoder(C_env env) {
    env.println(env.qualid + " = labcomm_read_" + getName() + "(r);");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:558
   */
  public void C_emitDecoderDeallocation(C_env env) {
    if (C_isDynamic()) {
      env.println("labcomm_memory_free(r->memory, 1, " + 
                  env.qualid + ");");
    }
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:744
   */
  public void C_emitEncoder(C_env env) {
    env.println("result = labcomm_write_" + getName() + 
                "(w, " + env.qualid + ");");
    env.println("if (result != 0) { return result; }");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:932
   */
  public void C_genFlatSignature(C_env env) {
    C_genFlatSignature(env, getToken());
    env.println("// " + getName());
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1025
   */
  public int C_fixedSizeof() {
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { return 1; } 
      case LABCOMM_BYTE: { return 1; } 
      case LABCOMM_SHORT: { return 2; } 
      case LABCOMM_INT: { return 4; } 
      case LABCOMM_LONG: { return 8; }
      case LABCOMM_FLOAT: { return 4; }
      case LABCOMM_DOUBLE: { return 8; }
      default: { 
	throw new Error(this.getClass().getName() + 
			".C_fixedSizeof()" + 
			" unknown size (" + getName() + ")"); 
      } 
    }
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1089
   */
  public void C_emitSizeof(C_env env) {
    switch (getToken()) {
      case LABCOMM_STRING: { 
	env.println("result += 0 + strlen(" + env.qualid + ");"); 
      } break;
      default: { 
	throw new Error(this.getClass().getName() + 
			".C_emitSizeof(C_env env)" + 
			" known size (" + getName() + ")"); 
      } 
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:496
   */
  public void Java_emitEncoder(Java_env env, String name) {
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { env.print("e.encodeBoolean"); } break;
      case LABCOMM_BYTE: { env.print("e.encodeByte"); } break;
      case LABCOMM_SHORT: { env.print("e.encodeShort"); } break;
      case LABCOMM_INT: { env.print("e.encodeInt"); } break;
      case LABCOMM_LONG: { env.print("e.encodeLong"); } break;
      case LABCOMM_FLOAT: { env.print("e.encodeFloat"); } break;
      case LABCOMM_DOUBLE: { env.print("e.encodeDouble"); } break;
      case LABCOMM_STRING: { env.print("e.encodeString"); } break;
    }
    env.println("(" + name + ");");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:585
   */
  public void Java_emitDecoder(Java_env env, String name) {
    env.print(name + " = ");
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { env.println("d.decodeBoolean();"); } break;
      case LABCOMM_BYTE: { env.println("d.decodeByte();"); } break;
      case LABCOMM_SHORT: { env.println("d.decodeShort();"); } break;
      case LABCOMM_INT: { env.println("d.decodeInt();"); } break;
      case LABCOMM_LONG: { env.println("d.decodeLong();"); } break;
      case LABCOMM_FLOAT: { env.println("d.decodeFloat();"); } break;
      case LABCOMM_DOUBLE: { env.println("d.decodeDouble();"); } break;
      case LABCOMM_STRING: { env.println("d.decodeString();"); } break;
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:677
   */
  public void Java_emitTypePrefix(Java_env env) {
    switch (getToken()) {
      case LABCOMM_STRING: { env.print("String"); } break;
      default: { env.print(getName()); } break;
    }
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:722
   */
  public boolean Java_needInstance() {
    return false;
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:742
   */
  public boolean Java_isPrimitive() {
    return true;
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:755
   */
  public void Java_emitInstance(Java_env env) {
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:799
   */
  public void Java_emitType(Java_env env) {
    switch (getToken()) {
      case LABCOMM_STRING: { env.print("String"); } break;
      default: { env.print(getName()); } break;
    }
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:71
   */
  public void ppPrefix(PrintStream out) { 
    out.print(getName());
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:145
   */
  public void Python_genSignature(Python_env env) {
    switch (getToken()) {
      case LABCOMM_BOOLEAN: { env.print("labcomm.BOOLEAN()"); } break;
      case LABCOMM_BYTE: { env.print("labcomm.BYTE()"); } break;
      case LABCOMM_SHORT: { env.print("labcomm.SHORT()"); } break;
      case LABCOMM_INT: { env.print("labcomm.INTEGER()"); } break;
      case LABCOMM_LONG: { env.print("labcomm.LONG()"); } break;
      case LABCOMM_FLOAT: { env.print("labcomm.FLOAT()"); } break;
      case LABCOMM_DOUBLE: { env.print("labcomm.DOUBLE()"); } break;
      case LABCOMM_STRING: { env.print("labcomm.STRING()"); } break;
    }
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:223
   */
  public String RAPID_AddType(RAPID_env env, String name) {
		if (getToken() == LABCOMM_SHORT ||
			getToken() == LABCOMM_FLOAT ||
			getToken() == LABCOMM_INT) {
			return "num";
		} else if (getToken() == LABCOMM_LONG) {
			return "dnum";
		} else if (getToken() == LABCOMM_STRING) {
			return "string";
		} else if (getToken() == LABCOMM_BOOLEAN) {
			return "bool";
		} else if (getToken() == LABCOMM_BYTE) {
			return "byte";
		}
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:264
   */
  public void RAPID_AddDecodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		switch(getToken()) {
			case LABCOMM_BYTE:
				instrs.add("Decode_Byte " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_BOOLEAN:
				instrs.add("Decode_Bool " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_SHORT:
				instrs.add("Decode_Short " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_INT:
				instrs.add("Decode_Int " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_LONG:
				instrs.add("Decode_Long " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_FLOAT:
				instrs.add("Decode_Float " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_STRING:
				instrs.add("Decode_String " + stream_name + "," + var_name + ";");
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:318
   */
  public void RAPID_AddEncodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		switch(getToken()) {
			case LABCOMM_BYTE:
				instrs.add("Encode_Byte " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_BOOLEAN:
				instrs.add("Encode_Bool " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_SHORT:
				instrs.add("Encode_Short " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_INT:
				instrs.add("Encode_Int " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_LONG:
				instrs.add("Encode_Long " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_FLOAT:
				instrs.add("Encode_Float " + stream_name + "," + var_name + ";");
				break;
			case LABCOMM_STRING:
				instrs.add("Encode_String " + stream_name + "," + var_name + ";");
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:120
   */
  public void flatSignature(SignatureList list) {
    list.addInt(getToken(), null);
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:186
   */
  public String signatureComment() {
    return getName();
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public PrimType() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public PrimType(String p0, int p1) {
    setName(p0);
    setToken(p1);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public PrimType(beaver.Symbol p0, int p1) {
    setName(p0);
    setToken(p1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:18
   */
  protected int numChildren() {
    return 0;
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
   * Setter for lexeme Token
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setToken(int value) {
    tokenint_Token = value;
  }
  /**   * @apilevel internal   * @ast method 
   * @declaredat LabComm.ast:8
   */
  
  /**   * @apilevel internal   */  protected int tokenint_Token;
  /**
   * Getter for lexeme Token
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:13
   */
  public int getToken() {
    return tokenint_Token;
  }
  /**
   * @attribute syn
   * @aspect C_IsDynamic
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:132
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
  private boolean C_isDynamic_compute() {  return getToken() == LABCOMM_STRING;  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
