package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:19
 */
public class Dim extends ASTNode<ASTNode> implements Cloneable {
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
  public Dim clone() throws CloneNotSupportedException {
    Dim node = (Dim)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Dim copy() {
      try {
        Dim node = (Dim)clone();
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
  public Dim fullCopy() {
    Dim res = (Dim)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public Dim() {
    super();

    setChild(new List(), 0);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
   */
  public Dim(List<Exp> p0) {
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
   * Setter for ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setExpList(List<Exp> list) {
    setChild(list, 0);
  }
  /**
   * @return number of children in ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public int getNumExp() {
    return getExpList().getNumChild();
  }
  /**
   * Getter for child in list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Exp getExp(int i) {
    return (Exp)getExpList().getChild(i);
  }
  /**
   * Add element to list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:27
   */
  public void addExp(Exp node) {
    List<Exp> list = (parent == null || state == null) ? getExpListNoTransform() : getExpList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:34
   */
  public void addExpNoTransform(Exp node) {
    List<Exp> list = getExpListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:42
   */
  public void setExp(Exp node, int i) {
    List<Exp> list = getExpList();
    list.setChild(node, i);
  }
  /**
   * Getter for Exp list.
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:50
   */
  public List<Exp> getExps() {
    return getExpList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:56
   */
  public List<Exp> getExpsNoTransform() {
    return getExpListNoTransform();
  }
  /**
   * Getter for list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Exp> getExpList() {
    List<Exp> list = (List<Exp>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Exp> getExpListNoTransform() {
    return (List<Exp>)getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect ArrayRewrite
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ArrayTypeRewrite.jrag:3
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean isVariable() {
      ASTNode$State state = state();
    boolean isVariable_value = isVariable_compute();
    return isVariable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isVariable_compute() {
    for (int i = 0 ; i < getNumExp() ; i++) {
      if (getExp(i) instanceof VariableSize) {
	return true;
      }	
    }
    return false;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
