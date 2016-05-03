package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:5
 */
public class SampleDecl extends Decl implements Cloneable {
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
  public SampleDecl clone() throws CloneNotSupportedException {
    SampleDecl node = (SampleDecl)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public SampleDecl copy() {
      try {
        SampleDecl node = (SampleDecl)clone();
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
  public SampleDecl fullCopy() {
    SampleDecl res = (SampleDecl)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:246
   */
  public void CS_emitTypeRegister(CS_env env) {
    env.println(getName() + ".register(c);");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:282
   */
  public void CS_emitClass(CS_env env) {
    env.println("/* ");
    pp(env.getPrintStream());
    env.println("*/");
    env.println();
    env.println("public class " + getName() + " : LabCommSample {");
    env.println();
    env.indent();
    getType().CS_emitInstance(env);
    env.println("public interface Handler : LabCommHandler {");
    env.print("  void handle(");
    if (!isVoid()) {
      getType().CS_emitType(env);
      env.print(" value");
    }
    env.println(");");
    env.println("}");
    env.println();
    env.println("public static void register(LabCommDecoder d, Handler h) {");
    env.indent();
    env.println("d.register(new Dispatcher(), h);");
    env.unindent();
    env.println("}");
    env.println();

    env.println("public static void register(LabCommEncoder e) {");
    env.indent();
    env.println("e.register(new Dispatcher());");
    env.unindent();
    env.println("}");
    env.println(); 

    env.println("private class Dispatcher : LabCommDispatcher {");
    env.indent();
    env.println(); 
    env.println("public Type getSampleClass() {");
    env.indent();
    env.println("return typeof(" + getName() + ");");
    env.unindent();
    env.println("}");
    env.println(); 
    env.println("public String getName() {");
    env.indent();
    env.println("return \"" + getName() + "\";");
    env.unindent();
    env.println("}");
    env.println(); 
    env.println("public byte[] getSignature() {");
    env.indent();
    env.println("return signature;");
    env.unindent();
    env.println("}");
    env.println(); 
    env.println("public void decodeAndHandle(LabCommDecoder d, LabCommHandler h) {");
    env.indent();
    if (isVoid()) {
      env.println(getName() + ".decode(d);");
      env.println("((Handler)h).handle();"); 
    } else {
      env.println("((Handler)h).handle(" + getName() + ".decode(d));"); 
    }
    env.unindent();
    env.println("}");
    env.println("");
    env.unindent();
    env.println("}");
    env.println("");

    CS_emitEncoder(env);
    CS_emitDecoder(env);
    env.println("private static byte[] signature = new byte[] {");
    env.indent();
    SignatureList signature = signature();
    for (int i = 0 ; i < signature.size() ; i++) {
      String comment = signature.getComment(i);
      if (comment != null) {
        env.println(signature.getIndent(i) + "// " + comment);
      }
      byte[] data = signature.getData(i);
      if (data != null) {
        env.print(signature.getIndent(i));
        for (int j = 0 ; j < data.length ; j++) {
	  env.print(data[j] + ", ");
        }
        env.println();
      }
    }
    env.unindent();
    env.println("};");
    env.unindent();
    env.println();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect CS_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:391
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
    env.println("e.begin(typeof(" + getName() + "));");
    getType().CS_emitEncoder(env, "value");
    env.println("e.end(typeof(" + getName() + "));");
    env.unindent();
    env.println("}");
    env.println();
  }
  /**
   * @ast method 
   * @aspect CS_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\CS_CodeGen.jrag:779
   */
  public void CS_info(CS_env env, String namespace) {
    env.print(";C#;sample;" + namespace + getName() + ";");
    getType().CS_emitType(env);
    env.println();
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:244
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
   * @aspect C_Declarations
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:341
   */
  public void C_emitDecoderDeclaration(C_env env) {
    env.println("int labcomm_decoder_register_" + 
		env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_decoder *d,");
    env.println("void (*handler)(");
    env.indent();
    env.println(env.prefix + getName() + " *v,");
    env.println("void *context");
    env.unindent();
    env.println("),");
    env.println("void *context");
    env.unindent();
    env.println(");");

    env.println("int labcomm_decoder_ioctl_" + env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_decoder *d,");
    env.println("int ioctl_action,");
    env.println("...");
    env.unindent();
    env.println(");");
  }
  /**
   * @ast method 
   * @aspect C_Declarations
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:368
   */
  public void C_emitEncoderDeclaration(C_env env) {
    env.println("int labcomm_encoder_register_" + 
		env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_encoder *e);");
    env.unindent();

    env.println("int labcomm_encode_" + env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_encoder *e,");
    env.println(env.prefix + getName() + " *v");
    env.unindent();
    env.println(");");

    env.println("int labcomm_encoder_ioctl_" + env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_encoder *e,");
    env.println("int ioctl_action,");
    env.println("...");
    env.unindent();
    env.println(");");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:442
   */
  public void C_emitDecoder(C_env env) {
    env = env.nestStruct("v");
    env.println("static void decode_" + getName() + "(");
    env.indent();
    env.println("struct labcomm_reader *r,");
    env.println("void (*handle)(");
    env.indent();
    env.println(env.prefix + getName() + " *v,");
    env.println("void *context");
    env.unindent();
    env.println("),");
    env.println("void *context");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println(env.prefix + getName() + " v;");
    getType().C_emitDecoder(env);
    env.println("handle(&v, context);");
    if (C_isDynamic()) {
      env.println("{");
      env.indent();
      getType().C_emitDecoderDeallocation(env);
      env.unindent();
      env.println("}");
    }
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:623
   */
  public void C_emitDecoderRegisterHandler(C_env env) {
    env.println("int labcomm_decoder_register_" + 
		env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_decoder *d,");
    env.println("void (*handler)(");
    env.indent();
    env.println(env.prefix + getName() + " *v,");
    env.println("void *context");
    env.unindent();
    env.println("),");
    env.println("void *context");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println("return labcomm_internal_decoder_register(");
    env.indent();
    env.println("d,");
    env.println("&labcomm_signature_" + env.prefix + getName() + ",");
    env.println("(labcomm_decoder_function)decode_" + getName() + ",");
    env.println("(labcomm_handler_function)handler,");
    env.println("context");
    env.unindent();
    env.println(");");
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_DecoderIoctl
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:665
   */
  public void C_emitDecoderIoctl(C_env env) {
    env.println("int labcomm_decoder_ioctl_" + env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_decoder *d,");
    env.println("int ioctl_action,");
    env.println("...");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println("int result;");
    env.println("va_list va;");
    env.println("va_start(va, ioctl_action);");
    env.println("result = labcomm_internal_decoder_ioctl(");
    env.indent();
    env.println("d, &labcomm_signature_" + env.prefix + getName() + ", ");
    env.println("ioctl_action, va);");
    env.unindent();
    env.println("va_end(va);");
    env.println("return result;");
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:702
   */
  public void C_emitEncoder(C_env env) {
    env = env.nestStruct("(*v)");
    env.println("static int encode_" + getName() + "(");
    env.indent();
    env.println("struct labcomm_writer *w,");
    env.println(env.prefix + getName() + " *v");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println("int result = 0;");
    getType().C_emitEncoder(env);
    env.println("return result;");
    env.unindent();
    env.println("}");

    // Typesafe encode wrapper
    env.println("int labcomm_encode_" + env.prefix + getName() + "(");
    env.println("struct labcomm_encoder *e,");
    env.println(env.prefix + getName() + " *v");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println("return labcomm_internal_encode(e, &labcomm_signature_" + 
		env.prefix + getName() + 
		", (labcomm_encoder_function)encode_" + getName() +
		", v);");
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_Encoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:810
   */
  public void C_emitEncoderRegisterHandler(C_env env) {
    env.println("int labcomm_encoder_register_" + 
		env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_encoder *e");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println("return labcomm_internal_encoder_register(");
    env.indent();
    env.println("e,");
    env.println("&labcomm_signature_" + env.prefix + getName() + ",");
    env.println("(labcomm_encoder_function)encode_" + getName());
    env.unindent();
    env.println(");");
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_EncoderIoctl
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:843
   */
  public void C_emitEncoderIoctl(C_env env) {
    env.println("int labcomm_encoder_ioctl_" + env.prefix + getName() + "(");
    env.indent();
    env.println("struct labcomm_encoder *e,");
    env.println("int ioctl_action,");
    env.println("...");
    env.unindent();
    env.println(")");
    env.println("{");
    env.indent();
    env.println("int result;");
    env.println("va_list va;");
    env.println("va_start(va, ioctl_action);");
    env.println("result = labcomm_internal_encoder_ioctl(");
    env.indent();
    env.println("e, &labcomm_signature_" + env.prefix + getName() + ", ");
    env.println("ioctl_action, va);");
    env.unindent();
    env.println("va_end(va);");
    env.println("return result;");
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:886
   */
  public void C_emitSignature(C_env env) {
    env.println("static unsigned char signature_bytes_" + 
		       getName() + "[] = {");
//    C_genFlatSignature(env);
    SignatureList signature = signature();
    for (int i = 0 ; i < signature.size() ; i++) {
      String comment = signature.getComment(i);
      if (comment != null) {
        env.println(signature.getIndent(i) + "// " + comment);
      }
      byte[] data = signature.getData(i);
      if (data != null) {
        env.print(signature.getIndent(i));
        for (int j = 0 ; j < data.length ; j++) {
          env.print(data[j] + ", ");
        }
        env.println("");
      }
    }
    env.println("};");
    env.println("LABCOMM_DECLARE_SIGNATURE(labcomm_signature_" + 
		env.prefix + getName() + ") = {");
    env.indent();
    env.println("LABCOMM_SAMPLE, \"" + getName() + "\",");
    env.println("(int (*)(struct labcomm_signature *, void *))labcomm_sizeof_" + 
		env.prefix + getName() + ",");
    env.println("sizeof(signature_bytes_" + getName() + "),");
    env.println("signature_bytes_"+ getName());
    env.unindent();
    env.println(" };");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:928
   */
  public void C_genFlatSignature(C_env env) {
    getType().C_genFlatSignature(env);
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1006
   */
  public void C_emitSizeofDeclaration(C_env env) {
    env.println("extern int labcomm_sizeof_" + env.prefix + getName() +
		"(struct labcomm_signature *sig, " + env.prefix + getName() + " *v);");
  }
  /**
   * @ast method 
   * @aspect C_Sizeof
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1066
   */
  public void C_emitSizeof(C_env env) {
    env = env.nestStruct("(*v)");
    env.println("int labcomm_sizeof_" + env.prefix + getName() +
		"(struct labcomm_signature *sig, " + env.prefix + getName() + " *v)");
    env.println("{");
    env.indent();
    if (C_isDynamic()) {
      env.println("int result = 0;");
      getType().C_emitSizeof(env);
      env.println("return result;");
    } else {
      env.println("return " + (0 + C_fixedSizeof()) + ";");
    }    
    env.unindent();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect C_forAll
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1178
   */
  public String C_forAll(C_env env) {
    return "func(" + getName() + ", " + env.prefix + getName() + ")";
  }
  /**
   * @ast method 
   * @aspect C_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:1204
   */
  public void C_info(C_env env) {
    env.println(",C,sample," + env.prefix + getName() + "," + 
                env.prefix + getName());
  }
  /**
   * @ast method 
   * @aspect Java_Register
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:304
   */
  public void Java_emitTypeRegister(Java_env env) {
    env.println(getName() + ".register(c);");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:349
   */
  public void Java_emitClass(Java_env env, String pack) {
    env.println("/* ");
    pp(env.getPrintStream());
    env.println("*/");

    if (pack != null && pack.length() > 0) {
      env.println("package " + pack + ";");
    }

    env.println("import java.io.IOException;");
    env.println("import se.lth.control.labcomm.LabCommDecoder;");
    env.println("import se.lth.control.labcomm.LabCommDispatcher;");
    env.println("import se.lth.control.labcomm.LabCommEncoder;");
    env.println("import se.lth.control.labcomm.LabCommHandler;");
    env.println("import se.lth.control.labcomm.LabCommSample;");
    env.println();
    env.println("public class " + getName() + " implements LabCommSample {");
    env.println();
    env.indent();
    getType().Java_emitInstance(env);
    env.println("public interface Handler extends LabCommHandler {");
    env.print("  public void handle_" + getName() + "(");
    if (!isVoid()) {
      getType().Java_emitType(env);
      env.print(" value");
    }
    env.println(") throws Exception;");
    env.println("}");
    env.println();
    env.println("public static void register(LabCommDecoder d, Handler h) throws IOException {");
    env.indent();
    env.println("d.register(new Dispatcher(), h);");
    env.unindent();
    env.println("}");
    env.println();

    env.println("public static void register(LabCommEncoder e) throws IOException {");
    env.indent();
    env.println("e.register(new Dispatcher());");
    env.unindent();
    env.println("}");
    env.println(); 

    env.println("private static class Dispatcher implements LabCommDispatcher {");
    env.indent();
    env.println(); 
    env.println("public Class getSampleClass() {");
    env.indent();
    env.println("return " + getName() + ".class;");
    env.unindent();
    env.println("}");
    env.println(); 
    env.println("public String getName() {");
    env.indent();
    env.println("return \"" + getName() + "\";");
    env.unindent();
    env.println("}");
    env.println(); 
    env.println("public byte[] getSignature() {");
    env.indent();
    env.println("return signature;");
    env.unindent();
    env.println("}");
    env.println(); 
    env.println("public void decodeAndHandle(LabCommDecoder d,");
    env.println("                            LabCommHandler h) throws Exception {");
    env.indent();
    if (isVoid()) {
      env.println(getName() + ".decode(d);");
      env.println("((Handler)h).handle_" + getName() + "();"); 
    } else {
      env.println("((Handler)h).handle_" + getName() + "(" + getName() + ".decode(d));"); 
    }
    env.unindent();
    env.println("}");
    env.println("");
    env.unindent();
    env.println("}");
    env.println("");

    Java_emitEncoder(env);
    Java_emitDecoder(env);
    env.println("private static byte[] signature = new byte[] {");
    env.indent();
    SignatureList signature = signature();
    for (int i = 0 ; i < signature.size() ; i++) {
      String comment = signature.getComment(i);
      if (comment != null) {
        env.println(signature.getIndent(i) + "// " + comment);
      }
      byte[] data = signature.getData(i);
      if (data != null) {
        env.print(signature.getIndent(i));
        for (int j = 0 ; j < data.length ; j++) {
	  env.print(data[j] + ", ");
        }
        env.println();
      }
    }
    env.unindent();
    env.println("};");
    env.unindent();
    env.println();
    env.println("}");
  }
  /**
   * @ast method 
   * @aspect Java_Class
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:470
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
    env.println("e.begin(" + getName() + ".class);");
    getType().Java_emitEncoder(env, "value");
    env.println("e.end(" + getName() + ".class);");
    env.unindent();
    env.println("}");
    env.println();
  }
  /**
   * @ast method 
   * @aspect Java_Info
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Java_CodeGen.jrag:844
   */
  public void Java_info(Java_env env) {
    env.print(",Java,sample," + getName() + ",");
    getType().Java_emitType(env);
    env.println();
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:34
   */
  public void pp(PrintStream out) {
    out.print("sample ");
    getType().ppIdentifier(out, getName());
    out.println(";");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:127
   */
  public void Python_genSignature(Python_env env) {
    env.println("signature = labcomm.sample('" + getName() + "', ");
    env.indent();
    getType().Python_genSignature(env);
    env.unindent();
    env.println(")");
  }
  /**
   * @ast method 
   * @aspect PythonTypes
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Python_CodeGen.jrag:202
   */
  public void Python_genSampleListEntry(Python_env env) {
    env.println("('" + getName() + "', " + getName() + ".signature),");
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:98
   */
  public void RAPID_gen(RAPID_env env) {
		// Add type declarations
		String fullName = getType().RAPID_AddType(env, getName());
		// Add signature constants
		String sig_len_name = "signature_len_" + getName();
		String sig_name = "signature_" + getName();
		SignatureList sig = signature();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		byte[] d = null;
		int sig_len = 0;
		for (int i = 0; i < sig.size(); i++) {
			d = sig.getData(i);
			for (int j = 0; d != null && j < d.length; j++) {
				sb.append(d[j] + ",");
				sig_len++;
			}
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		env.addConstant("num", sig_len_name, "" + sig_len);
		env.addConstant("byte", sig_name + "{" + sig_len_name + "}",
			sb.toString());
		
		// Add decode procedures
		ArrayList<String> params = new ArrayList<String>();
		ArrayList<String> stmts = new ArrayList<String>();
		params.add("VAR LabComm_Decoder_Sample s");
		params.add("string handler");
		stmts.add("s.prefix := prefix;");
		stmts.add("s.name := \"" + getName() + "\";");
		stmts.add("s.handler := handler;");
		env.addProc("Dec_Reg_" + getName(), params, stmts);	

		params.clear();
		stmts.clear();
		params.add("VAR LabComm_Decoder_Sample s");
		params.add("VAR rawbytes sig");
		params.add("num user_id");
		stmts.add("VAR byte tmp_sig{" + sig_len_name + "};");
		stmts.add("IF RawBytesLen(sig)<>" + sig_len_name + " THEN");
		stmts.add("\tRETURN;");
		stmts.add("ENDIF");
		stmts.add("FOR i FROM 1 TO " + sig_len_name + " DO");
		stmts.add("\tUnpackRawBytes sig, i, tmp_sig{i}, \\Hex1;");
		stmts.add("ENDFOR");
		stmts.add("IF tmp_sig<>" + sig_name + " THEN");
		stmts.add("\tRETURN;");
		stmts.add("ENDIF");
		stmts.add("s.user_id := user_id;");
		env.addProc("Reg_If_Signature_Of_" + getName(), params, stmts);

		params.clear();
		stmts.clear();
		params.add("VAR Decoder d");
		params.add("VAR LabComm_Stream st");
		params.add("VAR LabComm_Decoder_Sample s");
		stmts.add("VAR " + fullName + " tmp;");
		getType().RAPID_AddDecodeInstr(env, stmts, "tmp", "st");
		stmts.add("% s.handler % tmp;");
		env.addProc("Decode_And_Handle_" + getName(), params, stmts);

		params.clear();
		stmts.clear();
		params.add("VAR Encoder e");
		params.add("VAR LabComm_Stream st");
		params.add("VAR LabComm_Encoder_Sample s");
		stmts.add("s.prefix := prefix;");
		stmts.add("s.name := \"" + getName() + "\";");
		stmts.add("Encoder_Register_Sample e, st, s;");
		env.addProc("Enc_Reg_" + getName(), params, stmts);

		params.clear();
		stmts.clear();
		params.add("VAR Encoder e");
		params.add("VAR LabComm_Stream s");
		stmts.add("VAR rawbytes buffer;");
		stmts.add("FOR i FROM 1 TO " + sig_len_name + " DO");
		stmts.add("\tPackRawBytes " + sig_name +
					"{i}, buffer, \\Network, i, \\Hex1;");
		stmts.add("ENDFOR");
		stmts.add("SocketSend s.soc, \\RawData:=buffer, \\NoOfBytes:=" +
					sig_len_name + ";");
		env.addProc("Encode_Signature_" + getName(), params, stmts);

		params.clear();
		stmts.clear();
		params.add("VAR Encoder e");
		params.add("VAR LabComm_Stream st");
		params.add("VAR LabComm_Encoder_Sample s");
		params.add("VAR " + fullName + " val");
		stmts.add("Encode_Packed st, s.user_id;");
		getType().RAPID_AddEncodeInstr(env, stmts, "val", "st");
		env.addProc("Encode_" + getName(), params, stmts);
	}
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:111
   */
  public void flatSignature(SignatureList list) {
    getType().flatSignature(list);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public SampleDecl() {
    super();


  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:7
   */
  public SampleDecl(Type p0, String p1) {
    setChild(p0, 0);
    setName(p1);
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:11
   */
  public SampleDecl(Type p0, beaver.Symbol p1) {
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
