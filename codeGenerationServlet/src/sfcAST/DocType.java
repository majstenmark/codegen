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
 * @declaredat sfc.ast:8
 */
public class DocType extends ASTNode<ASTNode> implements Cloneable {
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
  public DocType clone() throws CloneNotSupportedException {
    DocType node = (DocType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public DocType copy() {
      try {
        DocType node = (DocType)clone();
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
  public DocType fullCopy() {
    DocType res = (DocType)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1344
   */
  public void prettyPrint(String indent, PrintStream pStream) {
    pStream.print("<!");
    pStream.print(getSTRING());
    pStream.println();
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public DocType(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public DocType(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public DocType() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat sfc.ast:14
   */
  public DocType(String p0) {
    setSTRING(p0);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:17
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "DocType"+ "\"" + getSTRING() + "\"");
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
   * Setter for lexeme STRING
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setSTRING(String value) {
    tokenString_STRING = value;
  }
  /**   * @apilevel internal   * @ast method 
   * @declaredat sfc.ast:8
   */
  
  /**   * @apilevel internal   */  protected String tokenString_STRING;
  /**
   * Getter for lexeme STRING
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:13
   */
  public String getSTRING() {
    return tokenString_STRING != null ? tokenString_STRING : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
