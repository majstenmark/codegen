package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;


/**
 * @ast class
 * @declaredat :0
 */
public class C_env extends java.lang.Object {


    final private class C_printer {
      
      private boolean newline = true;
      private PrintStream out;

      public C_printer(PrintStream out) {
	this.out = out;
      }

      public void print(C_env env, String s) {
	if (newline) {
	  newline = false;
	  for (int i = 0 ; i < env.indent ; i++) {
	    out.print("  ");
	  }
	}
	out.print(s);
      }
      public void println(C_env env, String s) {
	print(env, s);
	out.println();
	newline = true;
      }
    }



    public final String qualid;


    public final String lcName;


    public final String rawPrefix;


    public final String prefix;


    private int indent;


    public final int depth;


    private C_printer printer;



    private C_env(String qualid, String lcName, String rawPrefix, 
		  int indent, int depth, C_printer printer) {
      this.qualid = qualid;
      this.lcName = lcName;
      this.rawPrefix = rawPrefix;
      if (rawPrefix.equals("")) {
        this.prefix = rawPrefix;
      } else {
        this.prefix = rawPrefix + "_";
      }
      this.indent = indent;
      this.depth = depth;
      this.printer = printer;
    }



    public C_env(String qualid, String lcName, String rawPrefix, 
		 PrintStream out) {
      this.qualid = qualid;
      this.lcName = lcName;
      this.rawPrefix = rawPrefix;
      if (rawPrefix.equals("")) {
        this.prefix = rawPrefix;
      } else {
        this.prefix = rawPrefix + "_";
      }
      this.depth = 0;
      this.indent = 0;
      this.printer = new C_printer(out);
    }



    public C_env nestArray(String suffix) {
      return new C_env(qualid + suffix, lcName, rawPrefix, 
		       indent, depth + 1, printer);
    }



    public C_env nestStruct(String suffix) {
      return new C_env(qualid + suffix, lcName, rawPrefix, 
		       indent, depth, printer);
    }



    public void indent() {
      indent++;
    }



    public void unindent() {
      indent--;
    }



    public String prefix() {
      return rawPrefix;
    }



    public void print(String s) {
      printer.print(this, s);
    }



    public void println(String s) {
      printer.println(this, s);
    }


}
