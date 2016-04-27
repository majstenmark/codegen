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
 * @declaredat sfc.ast:19
 */
public class __DefaultAttribute__ extends Attribute implements Cloneable {
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
  public __DefaultAttribute__ clone() throws CloneNotSupportedException {
    __DefaultAttribute__ node = (__DefaultAttribute__)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public __DefaultAttribute__ copy() {
      try {
        __DefaultAttribute__ node = (__DefaultAttribute__)clone();
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
  public __DefaultAttribute__ fullCopy() {
    __DefaultAttribute__ res = (__DefaultAttribute__)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1391
   */
  public void prettyPrint(String indent, PrintStream pStream) {
    pStream.print(" "+getNAME()+"=");
       getAttrValue().prettyPrint(indent,pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public __DefaultAttribute__(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public __DefaultAttribute__(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public __DefaultAttribute__() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat sfc.ast:14
   */
  public __DefaultAttribute__(AttrValue p0, String p1) {
    setChild(p0, 0);
    setNAME(p1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:18
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "__DefaultAttribute__"+ "\"" + getNAME() + "\"");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:25
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:29
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat sfc.ast:34
   */
  public void checkChild(Node n, int i) {
    if(i == 0 && !(n instanceof AttrValue))  throw new Error("Child number 0 of Attribute has the type " + n.getClass().getName() + " which is not an instance of AttrValue");
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:41
   */
  public int getNumChild() {
    return 1;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:47
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
   * Setter for lexeme NAME
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setNAME(String value) {
    tokenString_NAME = value;
  }
  /**   * @apilevel internal   * @ast method 
   * @declaredat sfc.ast:8
   */
  
  /**   * @apilevel internal   */  protected String tokenString_NAME;
  /**
   * Getter for lexeme NAME
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:13
   */
  public String getNAME() {
    return tokenString_NAME != null ? tokenString_NAME : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
