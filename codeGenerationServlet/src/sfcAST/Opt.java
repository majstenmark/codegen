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
 * @declaredat Opt.ast:0
 */
public class Opt<T extends ASTNode> extends ASTNode<T> implements Cloneable {
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
  public Opt<T> clone() throws CloneNotSupportedException {
    Opt node = (Opt)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Opt<T> copy() {
      try {
        Opt node = (Opt)clone();
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
  public Opt<T> fullCopy() {
    Opt res = (Opt)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @declaredat Opt.ast:1
   */
  public Opt(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat Opt.ast:4
   */
  public Opt(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat Opt.ast:8
   */
  public Opt() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat Opt.ast:14
   */
  public Opt(T opt) {
    setChild(opt, 0);
  }
  /**
   * @ast method 
   * @declaredat Opt.ast:18
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "Opt");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat Opt.ast:25
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat Opt.ast:29
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat Opt.ast:34
   */
  public void checkChild(Node n, int i) {
    if(i > 0) throw new Error("Optional nodes can only have one child");
    if(!(n instanceof ASTNode)) throw new Error("Node type must be an instance of ASTNode");
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat Opt.ast:42
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
