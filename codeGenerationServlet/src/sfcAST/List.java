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
 * @declaredat List.ast:0
 */
public class List<T extends ASTNode> extends ASTNode<T> implements Cloneable {
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
  public List<T> clone() throws CloneNotSupportedException {
    List node = (List)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<T> copy() {
      try {
        List node = (List)clone();
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
  public List<T> fullCopy() {
    List res = (List)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @declaredat List.ast:1
   */
  public List(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat List.ast:4
   */
  public List(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat List.ast:8
   */
  public List() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat List.ast:14
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "List");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat List.ast:21
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat List.ast:25
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat List.ast:30
   */
  public void checkChild(Node n, int i) {
    if(!(n instanceof ASTNode)) throw new Error("The node type of child " + i + " must be an instance of ASTNode");
  }
  /**
   * @ast method 
   * @declaredat List.ast:34
   */
  public List<T> add(T node) {
    addChild(node);
    return this;
  }
  /**
   * @ast method 
   * @declaredat List.ast:39
   */
  public void insertChild(ASTNode node, int i) {
    list$touched = true;
    super.insertChild(node, i);
  }
  /**
   * @ast method 
   * @declaredat List.ast:43
   */
  public void addChild(T node) {
    list$touched = true;
    super.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat List.ast:50
   */
  public void removeChild(int i) {
    list$touched = true;
    super.removeChild(i);
  }
  /**
   * @ast method 
   * @declaredat List.ast:54
   */
  public int getNumChild() {
    if(list$touched) {
      for(int i = 0; i < getNumChildNoTransform(); i++)
        getChild(i);
        list$touched = false;
      }
      return getNumChildNoTransform();
  }
  /**
   * @ast method 
   * @declaredat List.ast:62
   */
  
  private boolean list$touched = true;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat List.ast:66
   */
  public boolean mayHaveRewrite() {
    return true;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    if(list$touched) {
      for(int i = 0 ; i < getNumChildNoTransform(); i++)
        getChild(i);
      list$touched = false;
      return this;
    }
    return super.rewriteTo();
  }
}
