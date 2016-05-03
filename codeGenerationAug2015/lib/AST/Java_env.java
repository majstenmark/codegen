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
public class Java_env extends java.lang.Object {


    private int indent;


    private int depth;


    private Java_printer printer;


    private HashMap unique = new HashMap();



    final private class Java_printer {
      
      private boolean newline = true;
      private File file;
      private PrintStream out;
      private IOException exception;
      

      public Java_printer(File f) {
  	file = f;
        File parentFile = f.getParentFile();
        if(parentFile != null) {
            parentFile.mkdirs();
        }
      }

     public Java_printer(PrintStream out) {
        this.out = out;
      }

      public void close() throws IOException {
	if (out != null) {
  	  out.close();
        }
	if (exception != null) {
	  throw exception;
        }
      }

      public PrintStream getPrintStream() {
	return(out);
      }

      public void checkOpen() {
	if (out == null && exception == null) {
          try {
    	    out = new PrintStream(new FileOutputStream(file));
          } catch (IOException e) {
	    exception = e;
          }
        }
      }

      public void print(Java_env env, String s) {
	checkOpen();
        if (newline) {
          newline = false;
          for (int i = 0 ; i < env.indent ; i++) {
            out.print("  ");
          }
        }
        out.print(s);
      }

      public void println(Java_env env, String s) {
	checkOpen();
        print(env, s);
        out.println();
        newline = true;
      }
    }



    private Java_env(int indent, Java_printer printer) {
      this.indent = indent;
      this.printer = printer;
    }



    public Java_env(File f) {
      this.indent = 0;
      this.printer = new Java_printer(f);
    }



    public Java_env(PrintStream out) {
      this.indent = 0;
      this.printer = new Java_printer(out);
    }



    public void close() throws IOException {
      printer.close();
    }



    public PrintStream getPrintStream() {
      return printer.getPrintStream();
    }


    public void indent(int amount) {
      indent += amount;
    }



    public void indent() {
      indent(1);
    }



    public void unindent(int amount) {
      indent -= amount;
    }



    public void unindent() {
      unindent(1);
    }



    public void print(String s) {
      printer.print(this, s);
    }



    public void println(String s) {
      printer.println(this, s);
    }



    public void println() {
      printer.println(this, "");
    }



    public int getDepth() {
      return depth;
    }



    public String print_for_begin(String limit) {
      print("for (int i_" + depth + " = 0 ; ");
      print("i_" + depth + " < " + limit + " ; ");
      println("i_" + depth + "++) {");
      indent();
      depth++;
      return "[i_" + (depth - 1) + "]";
    }



    public void print_for_end() {
      depth--;
      unindent();
      println("}");
    }



    public void print_block_begin() {
      println("{");
      indent();
    }



    public void print_block_end() {
      unindent();
      println("}");
    }



    public String getUnique(Object o) {
      String result = (String)unique.get(o);
      if (result == null) {
   	result = "_" + (unique.size() + 1) + "_";
      }
      unique.put(o, result);
      return result;
    }


}
