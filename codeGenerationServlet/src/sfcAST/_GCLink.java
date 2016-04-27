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
 * @declaredat sfc.ast:42
 */
public class _GCLink extends ComplexElement implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getStroke_visited = -1;
    getStroke_computed = false;
    getStroke_value = null;
    getfromObject_visited = -1;
    getfromObject_computed = false;
    getfromObject_value = null;
    getmanAdj_visited = -1;
    getmanAdj_computed = false;
    getmanAdj_value = null;
    gettoObject_visited = -1;
    gettoObject_computed = false;
    gettoObject_value = null;
    fromObj_visited = -1;
    toObj_visited = -1;
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
  public _GCLink clone() throws CloneNotSupportedException {
    _GCLink node = (_GCLink)super.clone();
    node.getStroke_visited = -1;
    node.getStroke_computed = false;
    node.getStroke_value = null;
    node.getfromObject_visited = -1;
    node.getfromObject_computed = false;
    node.getfromObject_value = null;
    node.getmanAdj_visited = -1;
    node.getmanAdj_computed = false;
    node.getmanAdj_value = null;
    node.gettoObject_visited = -1;
    node.gettoObject_computed = false;
    node.gettoObject_value = null;
    node.fromObj_visited = -1;
    node.toObj_visited = -1;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _GCLink copy() {
      try {
        _GCLink node = (_GCLink)clone();
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
  public _GCLink fullCopy() {
    _GCLink res = (_GCLink)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:498
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con, String from) {
		String toObj = (val.toString().split("#"))[1];
		out.println(ind(ind)+"<GCLink fromObject=\""+from+"\" toObject=\""+toObj+"\">");
		out.println(ind(ind)+"</GCLink>");				
    }
  /**
   * @ast method 
   * @aspect PrettyPrinter
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1495
   */
  public void prettyPrint(String ind, PrintStream pStream) {
    pStream.print(ind+"<GCLink ");
    for (int i=0; i<getNumAttribute(); i++) {
      getAttribute(i).prettyPrint(ind,pStream);
    }
    if (getNumElement() == 0) {
       pStream.println("/> ");
    } else {
       pStream.println("> ");
       String newInd = ind+"  ";
       for (int i=0; i<getNumElement(); i++) {
          getElement(i).prettyPrint(newInd,pStream);
       }
       pStream.println(ind+"</GCLink> ");
    }
  }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:301
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {

		String fromNode = getfromObject().value().substring(0,36); 
		String toNode = gettoObject().value().substring(0,36); 
		// String fromNode = getfromObject().value(); 
		// String toNode = gettoObject().value(); 

		// System.out.println("_GCLink.populateOntology: "+fromNode);

		start().getNode(fromNode).addOutLink(toNode,con,f,context);
		// URI fromURI = f.createURI(getfromObject().value());
		// URI toURI = f.createURI(gettoObject().value());
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _GCLink(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _GCLink(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _GCLink() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public _GCLink(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_GCLink");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:27
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:31
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat sfc.ast:36
   */
  public void checkChild(Node n, int i) {
    if(i == 0) {
      if(!(n instanceof List))
        throw new Error("Child number 0 of ComplexElement has the type " + n.getClass().getName() + " which is not an instance of List");
      for(int k = 0; k < ((List)n).getNumChildNoTransform(); k++)
      if(!(((List)n).getChildNoTransform(k) instanceof Attribute))
        throw new Error("Child number " + k + " in AttributeList has the type " + ((List)n).getChildNoTransform(k).getClass().getName() + " which is not an instance of Attribute");
    }
    if(i == 1) {
      if(!(n instanceof List))
        throw new Error("Child number 1 of ComplexElement has the type " + n.getClass().getName() + " which is not an instance of List");
      for(int k = 0; k < ((List)n).getNumChildNoTransform(); k++)
      if(!(((List)n).getChildNoTransform(k) instanceof Element))
        throw new Error("Child number " + k + " in ElementList has the type " + ((List)n).getChildNoTransform(k).getClass().getName() + " which is not an instance of Element");
    }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:56
   */
  public int getNumChild() {
    return 2;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:62
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for AttributeList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setAttributeList(List<Attribute> list) {
    setChild(list, 0);
  }
  /**
   * @return number of children in AttributeList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public int getNumAttribute() {
    return getAttributeList().getNumChild();
  }
  /**
   * Getter for child in list AttributeList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Attribute getAttribute(int i) {
    return (Attribute)getAttributeList().getChild(i);
  }
  /**
   * Add element to list AttributeList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:27
   */
  public void addAttribute(Attribute node) {
    List<Attribute> list = (parent == null || state == null) ? getAttributeListNoTransform() : getAttributeList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:34
   */
  public void addAttributeNoTransform(Attribute node) {
    List<Attribute> list = getAttributeListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list AttributeList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:42
   */
  public void setAttribute(Attribute node, int i) {
    List<Attribute> list = getAttributeList();
    list.setChild(node, i);
  }
  /**
   * Getter for Attribute list.
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:50
   */
  public List<Attribute> getAttributes() {
    return getAttributeList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:56
   */
  public List<Attribute> getAttributesNoTransform() {
    return getAttributeListNoTransform();
  }
  /**
   * Getter for list AttributeList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Attribute> getAttributeList() {
    List<Attribute> list = (List<Attribute>)getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Attribute> getAttributeListNoTransform() {
    return (List<Attribute>)getChildNoTransform(0);
  }
  /**
   * Setter for ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setElementList(List<Element> list) {
    setChild(list, 1);
  }
  /**
   * @return number of children in ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public int getNumElement() {
    return getElementList().getNumChild();
  }
  /**
   * Getter for child in list ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Element getElement(int i) {
    return (Element)getElementList().getChild(i);
  }
  /**
   * Add element to list ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:27
   */
  public void addElement(Element node) {
    List<Element> list = (parent == null || state == null) ? getElementListNoTransform() : getElementList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:34
   */
  public void addElementNoTransform(Element node) {
    List<Element> list = getElementListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:42
   */
  public void setElement(Element node, int i) {
    List<Element> list = getElementList();
    list.setChild(node, i);
  }
  /**
   * Getter for Element list.
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:50
   */
  public List<Element> getElements() {
    return getElementList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:56
   */
  public List<Element> getElementsNoTransform() {
    return getElementListNoTransform();
  }
  /**
   * Getter for list ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Element> getElementList() {
    List<Element> list = (List<Element>)getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Element> getElementListNoTransform() {
    return (List<Element>)getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  protected int getStroke_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getStroke_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_Stroke> getStroke_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1158
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_Stroke> getStroke() {
    if(getStroke_computed) {
      return getStroke_value;
    }
      ASTNode$State state = state();
    if(getStroke_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getStroke in class: ");
    getStroke_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getStroke_value = getStroke_compute();
    getStroke_value.setParent(this);
    getStroke_value.is$Final = true;
if(true) getStroke_computed = true;
    getStroke_visited = -1;
    return getStroke_value;
  }
  /**
   * @apilevel internal
   */
  private List<_Stroke> getStroke_compute() {
        List<_Stroke> l = new List<_Stroke>();
        for (Element e : getElements()) {
            if (e instanceof _Stroke) {
                l.add((_Stroke)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getfromObject_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getfromObject_computed = false;
  /**
   * @apilevel internal
   */
  protected _fromObject getfromObject_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1167
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _fromObject getfromObject() {
    if(getfromObject_computed) {
      return getfromObject_value;
    }
      ASTNode$State state = state();
    if(getfromObject_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getfromObject in class: ");
    getfromObject_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getfromObject_value = getfromObject_compute();
    getfromObject_value.setParent(this);
    getfromObject_value.is$Final = true;
if(true) getfromObject_computed = true;
    getfromObject_visited = -1;
    return getfromObject_value;
  }
  /**
   * @apilevel internal
   */
  private _fromObject getfromObject_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _fromObject) {
                return (_fromObject) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getmanAdj_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getmanAdj_computed = false;
  /**
   * @apilevel internal
   */
  protected _manAdj getmanAdj_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1175
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _manAdj getmanAdj() {
    if(getmanAdj_computed) {
      return getmanAdj_value;
    }
      ASTNode$State state = state();
    if(getmanAdj_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getmanAdj in class: ");
    getmanAdj_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getmanAdj_value = getmanAdj_compute();
    getmanAdj_value.setParent(this);
    getmanAdj_value.is$Final = true;
if(true) getmanAdj_computed = true;
    getmanAdj_visited = -1;
    return getmanAdj_value;
  }
  /**
   * @apilevel internal
   */
  private _manAdj getmanAdj_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _manAdj) {
                return (_manAdj) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int gettoObject_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean gettoObject_computed = false;
  /**
   * @apilevel internal
   */
  protected _toObject gettoObject_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1183
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _toObject gettoObject() {
    if(gettoObject_computed) {
      return gettoObject_value;
    }
      ASTNode$State state = state();
    if(gettoObject_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: gettoObject in class: ");
    gettoObject_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    gettoObject_value = gettoObject_compute();
    gettoObject_value.setParent(this);
    gettoObject_value.is$Final = true;
if(true) gettoObject_computed = true;
    gettoObject_visited = -1;
    return gettoObject_value;
  }
  /**
   * @apilevel internal
   */
  private _toObject gettoObject_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _toObject) {
                return (_toObject) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int fromObj_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:865
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String fromObj() {
      ASTNode$State state = state();
    if(fromObj_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: fromObj in class: ");
    fromObj_visited = state().boundariesCrossed;
    String fromObj_value = fromObj_compute();
    fromObj_visited = -1;
    return fromObj_value;
  }
  /**
   * @apilevel internal
   */
  private String fromObj_compute() {  return getfromObject().value().substring(0,36);  }
  /**
   * @apilevel internal
   */
  protected int toObj_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:867
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String toObj() {
      ASTNode$State state = state();
    if(toObj_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: toObj in class: ");
    toObj_visited = state().boundariesCrossed;
    String toObj_value = toObj_compute();
    toObj_visited = -1;
    return toObj_value;
  }
  /**
   * @apilevel internal
   */
  private String toObj_compute() {  return gettoObject().value().substring(0,36);  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
