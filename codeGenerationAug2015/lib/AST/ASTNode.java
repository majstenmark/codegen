package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;


// Generated with JastAdd II (http://jastadd.org) version R20110902

/**
 * @ast node
 * @declaredat ASTNode.ast:0
 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol  implements Cloneable, Iterable<T> {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
  }
  /**
   * @apilevel internal
   */
  public void flushCollectionCache() {
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ASTNode<T> copy() {
      try {
        ASTNode node = (ASTNode)clone();
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
  public ASTNode<T> fullCopy() {
    ASTNode res = (ASTNode)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:871
   */
  public void C_emitSignature(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_emitSignature(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:918
   */
  public void C_genFlatSignature(C_env env) {
    throw new Error(this.getClass().getName() + 
		    ".C_genFlatSignature(C_env env)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:979
   */
  public void C_genFlatSignature(C_env env, int value) {
    env.print("  ");
    for (int i = 24 ; i >= 0 ; i -= 8) {
      env.print("0x");
      String hex = Integer.toHexString((value >> i) & 0xff);
      if (hex.length() == 1) { env.print("0"); }
      env.print(hex);
      env.print(", ");
    }
  }
  /**
   * @ast method 
   * @aspect C_Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:990
   */
  public void C_genFlatSignature(C_env env, String value) {
    C_genFlatSignature(env, value.length());
    env.println("");
    env.print("  ");
    for (int i = 0 ; i < value.length() ; i++) {
      env.print("'" + value.charAt(i) +"', ");
    }
  }
  /**
   * @ast method 
   * @aspect ErrorCheck
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ErrorCheck.jrag:7
   */
  

	protected String errors = null;
  /**
   * @ast method 
   * @aspect ErrorCheck
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ErrorCheck.jrag:9
   */
  protected void error(String s) {
	    s = "Error at " + lineNumber() + ": " + s;
	    if(errors == null) {
	      errors = s;
	    } else {
	      errors = errors + "\n" + s;
	    }
	}
  /**
   * @ast method 
   * @aspect ErrorCheck
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ErrorCheck.jrag:18
   */
  protected boolean hasErrors() {
		return errors != null;
	}
  /**
   * @ast method 
   * @aspect ErrorCheck
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ErrorCheck.jrag:21
   */
  public void errorCheck(Collection collection) {
	    nameCheck();
	    if(hasErrors())
		collection.add(errors);
	    for(int i = 0; i < getNumChild(); i++) {
		getChild(i).errorCheck(collection);
	    }
	}
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:3
   */
  

  public static final int LABCOMM_TYPEDEF = 0x01;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:4
   */
  
  public static final int LABCOMM_SAMPLE =  0x02;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:6
   */
  

  public static final int LABCOMM_ARRAY =   0x10;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:7
   */
  
  public static final int LABCOMM_STRUCT =  0x11;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:9
   */
  

  public static final int LABCOMM_BOOLEAN = 0x20;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:10
   */
   
  public static final int LABCOMM_BYTE =    0x21;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:11
   */
  
  public static final int LABCOMM_SHORT =   0x22;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:12
   */
  
  public static final int LABCOMM_INT =     0x23;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:13
   */
  
  public static final int LABCOMM_LONG =    0x24;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:14
   */
  
  public static final int LABCOMM_FLOAT =   0x25;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:15
   */
  
  public static final int LABCOMM_DOUBLE =  0x26;
  /**
   * @ast method 
   * @aspect LabCommTokens
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\LabCommmTokens.jrag:16
   */
  
  public static final int LABCOMM_STRING =  0x27;
  /**
   * @ast method 
   * @aspect NameAnalysis
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\NameAnalysis.jrag:40
   */
  public void nameCheck() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).nameCheck();
    }
  }
  /**
   * @ast method 
   * @aspect PrettyPrint
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\PrettyPrint.jrag:15
   */
  public void pp(PrintStream out) {
    throw new Error(this.getClass().getName() + 
		    ".pp(PrintStream out)" + 
		    " not declared");
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:74
   */
  public void RAPID_gen(RAPID_env env) {
		throw new UnsupportedOperationException();
	}
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:101
   */
  public void flatSignature(SignatureList list) {
    throw new Error(this.getClass().getName() + 
                    ".flatSignature(SignatureList list)" + 
                    " not declared");
  }
  /**
   * @ast method 
   * @aspect Signature
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\Signature.jrag:176
   */
  public String signatureComment() {
    throw new Error(this.getClass().getName() + 
                    ".signatureComment()" + 
                    " not declared");
  }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:1
   */
  public ASTNode() {
    super();


  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:10
   */
  

  /**
   * @apilevel internal
   */
  public static final boolean generatedWithCircularEnabled = true;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:14
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithCacheCycle = true;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:18
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithComponentCheck = false;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:22
   */
  
  /**
   * @apilevel internal
   */
  protected static ASTNode$State state = new ASTNode$State();
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:26
   */
  public final ASTNode$State state() { return state; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:30
   */
  
  /**
   * @apilevel internal
   */
  public boolean in$Circle = false;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:34
   */
  public boolean in$Circle() { return in$Circle; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:38
   */
  public void in$Circle(boolean b) { in$Circle = b; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:42
   */
  
  /**
   * @apilevel internal
   */
  public boolean is$Final = false;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:46
   */
  public boolean is$Final() { return is$Final; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:50
   */
  public void is$Final(boolean b) { is$Final = b; }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:54
   */
  @SuppressWarnings("cast") public T getChild(int i) {
    return (T)ASTNode.getChild(this, i);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:60
   */
  public static ASTNode getChild(ASTNode that, int i) {
    ASTNode node = that.getChildNoTransform(i);
    if(node.is$Final()) return node;
    if(!node.mayHaveRewrite()) {
      node.is$Final(that.is$Final());
      return node;
    }
    if(!node.in$Circle()) {
      int rewriteState;
      int num = that.state().boundariesCrossed;
      do {
        that.state().push(ASTNode$State.REWRITE_CHANGE);
        ASTNode oldNode = node;
        oldNode.in$Circle(true);
        node = node.rewriteTo();
        if(node != oldNode)
          that.setChild(node, i);
        oldNode.in$Circle(false);
        rewriteState = that.state().pop();
      } while(rewriteState == ASTNode$State.REWRITE_CHANGE);
      if(rewriteState == ASTNode$State.REWRITE_NOCHANGE && that.is$Final()) {
        node.is$Final(true);
        that.state().boundariesCrossed = num;
      }
    }
    else if(that.is$Final() != node.is$Final()) that.state().boundariesCrossed++;
    return node;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:91
   */
  
  /**
   * @apilevel internal
   */
  private int childIndex;
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:95
   */
  public int getIndexOfChild(ASTNode node) {
    if(node != null && node.childIndex < getNumChildNoTransform() && node == getChildNoTransform(node.childIndex))
      return node.childIndex;
    for(int i = 0; i < getNumChildNoTransform(); i++)
      if(getChildNoTransform(i) == node) {
        node.childIndex = i;
        return i;
      }
    return -1;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:109
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:115
   */
  @SuppressWarnings("cast")
  public final T getChildNoTransform(int i) {
    return (T)children[i];
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:122
   */
  
  /**
   * @apilevel low-level
   */
  protected int numChildren;
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:126
   */
  protected int numChildren() {
    return numChildren;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:132
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:138
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:144
   */
  public void setChild(ASTNode node, int i) {
  if(children == null) {
      children = new ASTNode[i + 1];
  } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if(i >= numChildren) numChildren = i+1;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:159
   */
  public void insertChild(ASTNode node, int i) {
    if(children == null) {
      children = new ASTNode[i + 1];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if(i < children.length)
        System.arraycopy(children, i, c, i+1, children.length-i);
      children = c;
    }
    numChildren++;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:177
   */
  public void removeChild(int i) {
    if(children != null) {
      ASTNode child = (ASTNode)children[i];
      if(child != null) {
        child.setParent(null);
        child.childIndex = -1;
      }
      System.arraycopy(children, i+1, children, i, children.length-i-1);
      numChildren--;
    }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:191
   */
  public ASTNode getParent() {
    if(parent != null && ((ASTNode)parent).is$Final() != is$Final()) {
      state().boundariesCrossed++;
    }
    return (ASTNode)parent;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:200
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:206
   */
  
  /**
   * @apilevel low-level
   */
  protected ASTNode parent;
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:210
   */
  
  /**
   * @apilevel low-level
   */
  protected ASTNode[] children;
  /**
   * @ast method 
   * @declaredat ASTNode.ast:212
   */
  protected boolean duringArrayTypeRewrite() {
    if(state().duringArrayTypeRewrite == 0) {
      return false;
    }
    else {
      state().pop();
      state().push(ASTNode$State.REWRITE_INTERRUPT);
      return true;
    }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:239
   */
  public java.util.Iterator<T> iterator() {
  return new java.util.Iterator<T>() {
      private int counter = 0;
      public boolean hasNext() {
        return counter < getNumChild();
      }
      @SuppressWarnings("unchecked") public T next() {
        if(hasNext())
          return (T)getChild(counter++);
        else
          return null;
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
  };
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:259
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @attribute syn
   * @aspect ErrorCheck
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ErrorCheck.jrag:5
   */
  @SuppressWarnings({"unchecked", "cast"})
  public int lineNumber() {
      ASTNode$State state = state();
    int lineNumber_value = lineNumber_compute();
    return lineNumber_value;
  }
  /**
   * @apilevel internal
   */
  private int lineNumber_compute() {  return getLine(getStart());  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    if(state().peek() == ASTNode$State.REWRITE_CHANGE) {
      state().pop();
      state().push(ASTNode$State.REWRITE_NOCHANGE);
    }
    return this;
  }
  /**
   * @apilevel internal
   */
  public int Define_int_CS_Depth(ASTNode caller, ASTNode child) {
    return getParent().Define_int_CS_Depth(this, caller);
  }
  /**
   * @apilevel internal
   */
  public String Define_String_CS_structName(ASTNode caller, ASTNode child) {
    return getParent().Define_String_CS_structName(this, caller);
  }
  /**
   * @apilevel internal
   */
  public int Define_int_Java_Depth(ASTNode caller, ASTNode child) {
    return getParent().Define_int_Java_Depth(this, caller);
  }
  /**
   * @apilevel internal
   */
  public String Define_String_Java_structName(ASTNode caller, ASTNode child) {
    return getParent().Define_String_Java_structName(this, caller);
  }
  /**
   * @apilevel internal
   */
  public String Define_String_lookupName(ASTNode caller, ASTNode child, String name) {
    return getParent().Define_String_lookupName(this, caller, name);
  }
  /**
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_lookupType(ASTNode caller, ASTNode child, String name) {
    return getParent().Define_TypeDecl_lookupType(this, caller, name);
  }
  /**
   * @apilevel internal
   */
  public String Define_String_pp_indent(ASTNode caller, ASTNode child) {
    return getParent().Define_String_pp_indent(this, caller);
  }
}
