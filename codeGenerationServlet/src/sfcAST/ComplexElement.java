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
 * @declaredat sfc.ast:11
 */
public class ComplexElement extends Element implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    uris_String_visited = null;
    params_String_visited = null;
    paramValue_String_visited = null;
    id_visited = -1;
    name_visited = -1;
    actionText_visited = -1;
    constant_visited = -1;
    exp_visited = -1;
    initialValue_visited = -1;
    updated_visited = -1;
    value_visited = -1;
    getNode_String_visited = null;
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
  public ComplexElement clone() throws CloneNotSupportedException {
    ComplexElement node = (ComplexElement)super.clone();
    node.uris_String_visited = null;
    node.params_String_visited = null;
    node.paramValue_String_visited = null;
    node.id_visited = -1;
    node.name_visited = -1;
    node.actionText_visited = -1;
    node.constant_visited = -1;
    node.exp_visited = -1;
    node.initialValue_visited = -1;
    node.updated_visited = -1;
    node.value_visited = -1;
    node.getNode_String_visited = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ComplexElement copy() {
      try {
        ComplexElement node = (ComplexElement)clone();
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
  public ComplexElement fullCopy() {
    ComplexElement res = (ComplexElement)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:58
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {
		for (Element e : getElements()) {
			e.generateXML(out,ind,val,con);
		}
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:95
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		for (Element e : getElements()) {
			e.populateOntology(con,f,context);
		}
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:442
   */
  public void addActionText(URI uri, RepositoryConnection con, ValueFactory f, URI context) {
		try {
			con.add(uri,f.createURI(sfcBaseURI+"#actionText"),
					f.createLiteral(actionText()),context);	
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		} 
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public ComplexElement(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public ComplexElement(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public ComplexElement() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public ComplexElement(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "ComplexElement");
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
  protected java.util.Map uris_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:528
   */
  @SuppressWarnings({"unchecked", "cast"})
  public LinkedList<String> uris(String uriString) {
    Object _parameters = uriString;
    if(uris_String_visited == null) uris_String_visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(uris_String_visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: uris in class: ");
    uris_String_visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    LinkedList<String> uris_String_value = uris_compute(uriString);
    uris_String_visited.remove(_parameters);
    return uris_String_value;
  }
  /**
   * @apilevel internal
   */
  private LinkedList<String> uris_compute(String uriString) {
		for (Attribute a : getAttributes()) {
			if (a.uris(uriString) != null) {
				return a.uris(uriString);
			}		   
		}
		return super.uris(uriString);
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map params_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:563
   */
  @SuppressWarnings({"unchecked", "cast"})
  public LinkedList<String> params(String paramString) {
    Object _parameters = paramString;
    if(params_String_visited == null) params_String_visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(params_String_visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: params in class: ");
    params_String_visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    LinkedList<String> params_String_value = params_compute(paramString);
    params_String_visited.remove(_parameters);
    return params_String_value;
  }
  /**
   * @apilevel internal
   */
  private LinkedList<String> params_compute(String paramString) {
		for (Attribute a : getAttributes()) {
			if (a.params(paramString) != null) {
				return a.params(paramString);
			}		   
		}
		return super.params(paramString);
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map paramValue_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:594
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String paramValue(String parName) {
    Object _parameters = parName;
    if(paramValue_String_visited == null) paramValue_String_visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(paramValue_String_visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: paramValue in class: ");
    paramValue_String_visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    String paramValue_String_value = paramValue_compute(parName);
    paramValue_String_visited.remove(_parameters);
    return paramValue_String_value;
  }
  /**
   * @apilevel internal
   */
  private String paramValue_compute(String parName) {
		for (Attribute a : getAttributes()) {
			if (a.paramValue(parName) != null) {
				return a.paramValue(parName);
			}		   
		}
		return super.paramValue(parName);		
    }
  /**
   * @apilevel internal
   */
  protected int id_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:609
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String id() {
      ASTNode$State state = state();
    if(id_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: id in class: ");
    id_visited = state().boundariesCrossed;
    String id_value = id_compute();
    id_visited = -1;
    return id_value;
  }
  /**
   * @apilevel internal
   */
  private String id_compute() {
		for (Attribute a : getAttributes()) {
			if (a.id() != null) {
				//				return a.id().substring(0,35);
				return a.id().substring(0,36);
			}
		}
		return super.id();
    }
  /**
   * @apilevel internal
   */
  protected int name_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:621
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String name() {
      ASTNode$State state = state();
    if(name_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: name in class: ");
    name_visited = state().boundariesCrossed;
    String name_value = name_compute();
    name_visited = -1;
    return name_value;
  }
  /**
   * @apilevel internal
   */
  private String name_compute() {
		for (Attribute a : getAttributes()) {
			if (a.name() != null) {
				return a.name();
			}
		}
		return super.name();
    }
  /**
   * @apilevel internal
   */
  protected int actionText_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:632
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String actionText() {
      ASTNode$State state = state();
    if(actionText_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: actionText in class: ");
    actionText_visited = state().boundariesCrossed;
    String actionText_value = actionText_compute();
    actionText_visited = -1;
    return actionText_value;
  }
  /**
   * @apilevel internal
   */
  private String actionText_compute() {
		for (Attribute a : getAttributes()) {
			if (a.actionText() != null) {
				return a.actionText();
			}
		}
		return super.actionText();
    }
  /**
   * @apilevel internal
   */
  protected int constant_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:643
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String constant() {
      ASTNode$State state = state();
    if(constant_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: constant in class: ");
    constant_visited = state().boundariesCrossed;
    String constant_value = constant_compute();
    constant_visited = -1;
    return constant_value;
  }
  /**
   * @apilevel internal
   */
  private String constant_compute() {
		for (Attribute a : getAttributes()) {
			if (a.constant() != null) {
				return a.constant();
			}
		}
		return super.constant();
    }
  /**
   * @apilevel internal
   */
  protected int exp_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:654
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String exp() {
      ASTNode$State state = state();
    if(exp_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: exp in class: ");
    exp_visited = state().boundariesCrossed;
    String exp_value = exp_compute();
    exp_visited = -1;
    return exp_value;
  }
  /**
   * @apilevel internal
   */
  private String exp_compute() {
		for (Attribute a : getAttributes()) {
			if (a.exp() != null) {
				return a.exp();
			}
		}
		return super.exp();
    }
  /**
   * @apilevel internal
   */
  protected int initialValue_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:665
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String initialValue() {
      ASTNode$State state = state();
    if(initialValue_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: initialValue in class: ");
    initialValue_visited = state().boundariesCrossed;
    String initialValue_value = initialValue_compute();
    initialValue_visited = -1;
    return initialValue_value;
  }
  /**
   * @apilevel internal
   */
  private String initialValue_compute() {
		for (Attribute a : getAttributes()) {
			if (a.initialValue() != null) {
				return a.initialValue();
			}
		}
		return super.initialValue();
    }
  /**
   * @apilevel internal
   */
  protected int updated_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:676
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
  private String updated_compute() {
		for (Attribute a : getAttributes()) {
			if (a.updated() != null) {
				return a.updated();
			}
		}
		return super.updated();
    }
  /**
   * @apilevel internal
   */
  protected int value_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:687
   */
  @SuppressWarnings({"unchecked", "cast"})
  public String value() {
      ASTNode$State state = state();
    if(value_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: value in class: ");
    value_visited = state().boundariesCrossed;
    String value_value = value_compute();
    value_visited = -1;
    return value_value;
  }
  /**
   * @apilevel internal
   */
  private String value_compute() {
		for (Attribute a : getAttributes()) {
			if (a.value() != null) {
				return a.value();
			}
		}
		return super.value();
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map getNode_String_visited;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:744
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
  private ComplexElement getNode_compute(String uid) {
		for (Element e : getElements()) {
			if (e.getNode(uid) != null) {
				return e.getNode(uid);
			}
		}
		return super.getNode(uid);
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
