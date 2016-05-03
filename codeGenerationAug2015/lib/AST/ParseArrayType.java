package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:14
 */
public class ParseArrayType extends Type implements Cloneable {
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
  public ParseArrayType clone() throws CloneNotSupportedException {
    ParseArrayType node = (ParseArrayType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ParseArrayType copy() {
      try {
        ParseArrayType node = (ParseArrayType)clone();
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
  public ParseArrayType fullCopy() {
    ParseArrayType res = (ParseArrayType)copy();
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
  public ParseArrayType() {
    super();

    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
   */
  public ParseArrayType(Type p0, List<Dim> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:15
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:21
   */
  public boolean mayHaveRewrite() {
    return true;
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
   * Setter for DimList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setDimList(List<Dim> list) {
    setChild(list, 1);
  }
  /**
   * @return number of children in DimList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public int getNumDim() {
    return getDimList().getNumChild();
  }
  /**
   * Getter for child in list DimList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Dim getDim(int i) {
    return (Dim)getDimList().getChild(i);
  }
  /**
   * Add element to list DimList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:27
   */
  public void addDim(Dim node) {
    List<Dim> list = (parent == null || state == null) ? getDimListNoTransform() : getDimList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:34
   */
  public void addDimNoTransform(Dim node) {
    List<Dim> list = getDimListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list DimList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:42
   */
  public void setDim(Dim node, int i) {
    List<Dim> list = getDimList();
    list.setChild(node, i);
  }
  /**
   * Getter for Dim list.
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:50
   */
  public List<Dim> getDims() {
    return getDimList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:56
   */
  public List<Dim> getDimsNoTransform() {
    return getDimListNoTransform();
  }
  /**
   * Getter for list DimList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Dim> getDimList() {
    List<Dim> list = (List<Dim>)getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Dim> getDimListNoTransform() {
    return (List<Dim>)getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    // Declared in C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ArrayTypeRewrite.jrag at line 13
    if(! getDim(0).isVariable()) {
      state().duringArrayTypeRewrite++;
      ASTNode result = rewriteRule0();
      state().duringArrayTypeRewrite--;
      return result;
    }

    // Declared in C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ArrayTypeRewrite.jrag at line 27
    if(getDim(0).isVariable()) {
      state().duringArrayTypeRewrite++;
      ASTNode result = rewriteRule1();
      state().duringArrayTypeRewrite--;
      return result;
    }

    return super.rewriteTo();
  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ArrayTypeRewrite.jrag:13
   * @apilevel internal
   */  private FixedArrayType rewriteRule0() {
{ 
      if (getNumDim() == 1) {
        return new FixedArrayType(getType(), 
				  getDim(0).getExpList());
      } else {
        List l = new List();
        for (int i = 1 ; i < getNumDim() ; i++) {
	  l.add(getDim(i));
        }
        return new FixedArrayType(new ParseArrayType(getType(), l), 
				  getDim(0).getExpList());
      }
    }  }
  /**
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\ArrayTypeRewrite.jrag:27
   * @apilevel internal
   */  private VariableArrayType rewriteRule1() {
{ 
      if (getNumDim() == 1) {
        return new VariableArrayType(getType(), 
				     getDim(0).getExpList());
      } else {
        List l = new List();
        for (int i = 1 ; i < getNumDim() ; i++) {
	  l.add(getDim(i));
        }
        return new VariableArrayType(new ParseArrayType(getType(), l), 
				     getDim(0).getExpList());
      }
    }  }
}
