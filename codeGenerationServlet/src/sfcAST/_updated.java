package sfcAST;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import org.openrdf.OpenRDFException;
import org.openrdf.model.*;
import org.openrdf.model.vocabulary.OWL;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.*;

/**
 * @ast node
 * @declaredat sfc.ast:34
 */
public class _updated extends Attribute implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    updated_visited = -1;
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
  public _updated clone() throws CloneNotSupportedException {
    _updated node = (_updated)super.clone();
    node.updated_visited = -1;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _updated copy() {
      try {
        _updated node = (_updated)clone();
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
  public _updated fullCopy() {
    _updated res = (_updated)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect PrettyPrinter
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1455
   */
  public void prettyPrint(String indent, PrintStream pStream) {
    pStream.print(" updated=");
       getAttrValue().prettyPrint(indent,pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _updated(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _updated(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _updated() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat sfc.ast:14
   */
  public _updated(AttrValue p0) {
    setChild(p0, 0);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:17
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_updated");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:24
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:28
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat sfc.ast:33
   */
  public void checkChild(Node n, int i) {
    if(i == 0 && !(n instanceof AttrValue))  throw new Error("Child number 0 of Attribute has the type " + n.getClass().getName() + " which is not an instance of AttrValue");
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:40
   */
  public int getNumChild() {
    return 1;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:46
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for AttrValue
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setAttrValue(AttrValue node) {
    setChild(node, 0);
  }
  /**
   * Getter for AttrValue
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public AttrValue getAttrValue() {
    return (AttrValue)getChild(0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:18
   */
  public AttrValue getAttrValueNoTransform() {
    return (AttrValue)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected int updated_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:684
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String updated() {
      ASTNode$State state = state();
    if(updated_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: updated in class: ");
    updated_visited = state().boundariesCrossed;
    String updated_value = updated_compute();
    updated_visited = -1;
    return updated_value;
  }
  /**
   * @apilevel internal
   */
  private String updated_compute() {  return value();  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
