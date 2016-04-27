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
 * @declaredat sfc.ast:12
 */
public class ValueElement extends ComplexElement implements Cloneable {
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
  public ValueElement clone() throws CloneNotSupportedException {
    ValueElement node = (ValueElement)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ValueElement copy() {
      try {
        ValueElement node = (ValueElement)clone();
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
  public ValueElement fullCopy() {
    ValueElement res = (ValueElement)copy();
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
  public ValueElement(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public ValueElement(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public ValueElement() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public ValueElement(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "ValueElement");
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
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
