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
public class SignatureLine extends java.lang.Object {

  
    private int indent;


    private byte[] data;


    private String comment;



    public SignatureLine(int indent, byte[] data, String comment) {
      this.indent = indent;
      this.data = data;
      this.comment = comment;
    }



    public int getIndent() {
      return indent;
    }



    public byte[] getData() {
      return data;
    }



    public String getComment() {
      return comment;
    }


}
