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
public class SignatureList extends java.lang.Object {


    private int indent;


    private ArrayList list = new ArrayList();


    
    public void add(byte[] data, String comment) {
      list.add(new SignatureLine(indent, data, comment));
    }



    public void addInt(int value, String comment) {
	byte[] tmp = new byte[5];
 	long v = value & 0xffffffff;
        int i, j;

        for (i = 0 ; i == 0 || v != 0 ; i++, v = (v >> 7)) {
          tmp[i] = (byte)(v & 0x7f);
        }
 	byte[] packed = new byte[i];
        for (i = i - 1, j = 0 ; i >= 0 ; i--, j++) {
	  packed[j] = (byte)(tmp[i] | (i!=0?0x80:0x00));
        }
	add(packed, comment);
    }



    public void addString(String value, String comment) {
      addInt(value.length(), comment);
      byte[] data = new byte[value.length()];
      for (int i = 0 ; i < value.length() ; i++) {
        data[i] = (byte)(value.charAt(i) & 0xff);
      }
      add(data, null);
    }



    public int size() {
      return list.size();
    }



    public String getIndent(int i) {
      StringBuffer result = new StringBuffer();
      int indent = ((SignatureLine)list.get(i)).getIndent();
      for (i = 0 ; i < indent ; i++) {
        result.append("  ");
      }
      return result.toString();
    }



    public byte[] getData(int i) {
      return ((SignatureLine)list.get(i)).getData();
    }



    public String getComment(int i) {
      return ((SignatureLine)list.get(i)).getComment();
    }



    public void indent() {
      indent++;
    }



    public void unindent() {
      indent--;
    }


}
