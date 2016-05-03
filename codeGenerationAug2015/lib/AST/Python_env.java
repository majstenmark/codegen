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
public class Python_env extends java.lang.Object {


    final private class Python_printer {
      
      private boolean newline = true;
      private PrintStream out;

      public Python_printer(PrintStream out) {
        this.out = out;
      }

      public void print(Python_env env, String s) {
        if (newline) {
          newline = false;
          for (int i = 0 ; i < env.indent ; i++) {
            out.print("    ");
          }
        }
        out.print(s);
      }

      public void println(Python_env env, String s) {
        print(env, s);
        out.println();
        newline = true;
      }

      public void println(Python_env env) {
        out.println();
        newline = true;
      }

    }



    private int indent;


    private Python_printer printer;



    public Python_env(PrintStream out) {
      this.indent = 0;
      this.printer = new Python_printer(out);
    }



    public void indent() {
      indent++;
    }



    public void unindent() {
      indent--;
    }



    public void print(String s) {
      printer.print(this, s);
    }



    public void println(String s) {
      printer.println(this, s);
    }



    public void println() {
      printer.println(this);
    }


}
