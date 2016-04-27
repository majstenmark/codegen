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
 * @declaredat sfc.ast:5
 */
public class Start extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getNode_String_visited = null;
    root_visited = -1;
    initialStep_visited = -1;
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
  public Start clone() throws CloneNotSupportedException {
    Start node = (Start)super.clone();
    node.getNode_String_visited = null;
    node.root_visited = -1;
    node.initialStep_visited = -1;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Start copy() {
      try {
        Start node = (Start)clone();
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
  public Start fullCopy() {
    Start res = (Start)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:63
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {
		setSpecification(new Specification());
		getSpecification().generateXML(out,ind,val,con);
  }

  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:45
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		getSpecification().populateOntology(con, f, context);
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:821
   */
  public Start start() {
		return this;
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:870
   */
  public List<_GCTransition> getOutTransitions(String id) {
		return getSpecification().getElement(0).getOutTransitions(id);
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public Start(int i) {
    super(i);
    is$Final(true);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public Start(XmlParser p, int i) {
    this(i);
    parser = p;
    is$Final(true);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:10
   */
  public Start() {
    this(0);

    is$Final(true);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:17
   */
  public Start(Specification p0) {
    setChild(p0, 0);
    is$Final(true);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:21
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "Start");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:28
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:32
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat sfc.ast:37
   */
  public void checkChild(Node n, int i) {
    if(i == 0 && !(n instanceof Specification))  throw new Error("Child number 0 of Start has the type " + n.getClass().getName() + " which is not an instance of Specification");
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:44
   */
  public int getNumChild() {
    return 1;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:50
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for Specification
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setSpecification(Specification node) {
    setChild(node, 0);
  }
  /**
   * Getter for Specification
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public Specification getSpecification() {
    return (Specification)getChild(0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:18
   */
  public Specification getSpecificationNoTransform() {
    return (Specification)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected java.util.Map getNode_String_visited;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:734
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ComplexElement getNode(String uid) {
    Object _parameters = uid;
    if(getNode_String_visited == null) getNode_String_visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(getNode_String_visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: getNode in class: ");
    getNode_String_visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    ComplexElement getNode_String_value = getNode_compute(uid);
    getNode_String_visited.remove(_parameters);
    return getNode_String_value;
  }
  /**
   * @apilevel internal
   */
  private ComplexElement getNode_compute(String uid) {  return getSpecification().getNode(uid);  }
  /**
   * @apilevel internal
   */
  protected int root_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:811
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Start root() {
      ASTNode$State state = state();
    if(root_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: root in class: ");
    root_visited = state().boundariesCrossed;
    Start root_value = root_compute();
    root_visited = -1;
    return root_value;
  }
  /**
   * @apilevel internal
   */
  private Start root_compute() {
		root = this;
		return super.root();
    }
  /**
   * @apilevel internal
   */
  protected int initialStep_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:844
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _GCInitialStep initialStep() {
      ASTNode$State state = state();
    if(initialStep_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: initialStep in class: ");
    initialStep_visited = state().boundariesCrossed;
    _GCInitialStep initialStep_value = initialStep_compute();
    initialStep_visited = -1;
    return initialStep_value;
  }
  /**
   * @apilevel internal
   */
  private _GCInitialStep initialStep_compute() {  return getSpecification().getElement(0).initialStep();  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
