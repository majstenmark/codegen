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
 * @declaredat sfc.ast:15
 */
public class StringElement extends SimpleElement implements Cloneable {
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
  public StringElement clone() throws CloneNotSupportedException {
    StringElement node = (StringElement)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public StringElement copy() {
      try {
        StringElement node = (StringElement)clone();
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
  public StringElement fullCopy() {
    StringElement res = (StringElement)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public StringElement(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public StringElement(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public StringElement() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat sfc.ast:14
   */
  public StringElement(String p0) {
    setLITERAL(p0);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:17
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "StringElement"+ "\"" + getLITERAL() + "\"");
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
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:39
   */
  public int getNumChild() {
    return 0;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:45
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for lexeme LITERAL
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setLITERAL(String value) {
    tokenString_LITERAL = value;
  }
  /**   * @apilevel internal   * @ast method 
   * @declaredat sfc.ast:8
   */
  
  /**   * @apilevel internal   */  protected String tokenString_LITERAL;
  /**
   * Getter for lexeme LITERAL
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:13
   */
  public String getLITERAL() {
    return tokenString_LITERAL != null ? tokenString_LITERAL : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
