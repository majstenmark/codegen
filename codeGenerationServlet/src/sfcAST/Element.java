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
 * @declaredat sfc.ast:10
 */
public abstract class Element extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    steps_List__GCStep__visited = null;
    transitions_List__GCTransition__visited = null;
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
  public Element clone() throws CloneNotSupportedException {
    Element node = (Element)super.clone();
    node.steps_List__GCStep__visited = null;
    node.transitions_List__GCTransition__visited = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public Element(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public Element(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public Element() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat sfc.ast:14
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "Element");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:21
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:25
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat sfc.ast:30
   */
  public void checkChild(Node n, int i) {
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:36
   */
  public int getNumChild() {
    return 0;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:42
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Map steps_List__GCStep__visited;
  /**
   * @attribute syn
   * @aspect Collect
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:937
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCStep> steps(List<_GCStep> steps) {
    Object _parameters = steps;
    if(steps_List__GCStep__visited == null) steps_List__GCStep__visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(steps_List__GCStep__visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: steps in class: ");
    steps_List__GCStep__visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    List<_GCStep> steps_List__GCStep__value = steps_compute(steps);
    steps_List__GCStep__visited.remove(_parameters);
    return steps_List__GCStep__value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCStep> steps_compute(List<_GCStep> steps) {  return steps;  }
  /**
   * @apilevel internal
   */
  protected java.util.Map transitions_List__GCTransition__visited;
  /**
   * @attribute syn
   * @aspect Collect
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:950
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCTransition> transitions(List<_GCTransition> transitions) {
    Object _parameters = transitions;
    if(transitions_List__GCTransition__visited == null) transitions_List__GCTransition__visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(transitions_List__GCTransition__visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: transitions in class: ");
    transitions_List__GCTransition__visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    List<_GCTransition> transitions_List__GCTransition__value = transitions_compute(transitions);
    transitions_List__GCTransition__visited.remove(_parameters);
    return transitions_List__GCTransition__value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCTransition> transitions_compute(List<_GCTransition> transitions) {  return transitions;  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
