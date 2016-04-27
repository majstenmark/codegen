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
 * @declaredat sfc.ast:74
 */
public class _WorkspaceObject extends ComplexElement implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getenabled_visited = -1;
    getenabled_computed = false;
    getenabled_value = null;
    getfileName_visited = -1;
    getfileName_computed = false;
    getfileName_value = null;
    getheight_visited = -1;
    getheight_computed = false;
    getheight_value = null;
    gethorizontalScrollBar_visited = -1;
    gethorizontalScrollBar_computed = false;
    gethorizontalScrollBar_value = null;
    getname_visited = -1;
    getname_computed = false;
    getname_value = null;
    getownerClass_visited = -1;
    getownerClass_computed = false;
    getownerClass_value = null;
    getscanCycle_visited = -1;
    getscanCycle_computed = false;
    getscanCycle_value = null;
    getuseIcon_visited = -1;
    getuseIcon_computed = false;
    getuseIcon_value = null;
    getverticalScrollBar_visited = -1;
    getverticalScrollBar_computed = false;
    getverticalScrollBar_value = null;
    getwidth_visited = -1;
    getwidth_computed = false;
    getwidth_value = null;
    getx_visited = -1;
    getx_computed = false;
    getx_value = null;
    gety_visited = -1;
    gety_computed = false;
    gety_value = null;
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
  public _WorkspaceObject clone() throws CloneNotSupportedException {
    _WorkspaceObject node = (_WorkspaceObject)super.clone();
    node.getenabled_visited = -1;
    node.getenabled_computed = false;
    node.getenabled_value = null;
    node.getfileName_visited = -1;
    node.getfileName_computed = false;
    node.getfileName_value = null;
    node.getheight_visited = -1;
    node.getheight_computed = false;
    node.getheight_value = null;
    node.gethorizontalScrollBar_visited = -1;
    node.gethorizontalScrollBar_computed = false;
    node.gethorizontalScrollBar_value = null;
    node.getname_visited = -1;
    node.getname_computed = false;
    node.getname_value = null;
    node.getownerClass_visited = -1;
    node.getownerClass_computed = false;
    node.getownerClass_value = null;
    node.getscanCycle_visited = -1;
    node.getscanCycle_computed = false;
    node.getscanCycle_value = null;
    node.getuseIcon_visited = -1;
    node.getuseIcon_computed = false;
    node.getuseIcon_value = null;
    node.getverticalScrollBar_visited = -1;
    node.getverticalScrollBar_computed = false;
    node.getverticalScrollBar_value = null;
    node.getwidth_visited = -1;
    node.getwidth_computed = false;
    node.getwidth_value = null;
    node.getx_visited = -1;
    node.getx_computed = false;
    node.getx_value = null;
    node.gety_visited = -1;
    node.gety_computed = false;
    node.gety_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _WorkspaceObject copy() {
      try {
        _WorkspaceObject node = (_WorkspaceObject)clone();
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
  public _WorkspaceObject fullCopy() {
    _WorkspaceObject res = (_WorkspaceObject)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:404
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {
		String id = (val.toString().split("#"))[1];
		TupleQueryResult result = queryRepo(con,"{sfc:"+id+" sfc:content ?content}");
		try {
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				Value rVal = bindingSet.getValue("content");
				out.println(trim(rVal.toString()));
			}
			
			// System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX  WorkspaceObject");
			// out.print(ind(ind)+"<WorkspaceObject name=\""+id+"\" enabled=\"1\" fileName=\"\" height=\"60\" horizontalScrollBar=\"1\"  ownerClass=\"\" scanCycle=\"1\" useIcon=\"0\" verticalScrollBar=\"1\" width=\"60\" x=\"410\" y=\"40\">");
			// out.println(ind(ind+1)+"<GCDocument color=\"-1\" height=\"600\" scale=\"1.0\" viewPositionX=\"36\" viewPositionY=\"0\" width=\"543\" x=\"95\" y=\"78\">");
			// try {
			//     TupleQueryResult result = queryRepo(con,"{sfc:"+id+" sfc:node ?node}");
			//     while (result.hasNext()) {
			// 	BindingSet bSet = result.next();
			// 	Value p = bSet.getValue("node");
			// 	genNextStep(out,ind+2,p,con);
			// 	System.out.println(p);
			//     }
			//     out.println(ind(ind+1)+"</GCDocument>");
			//     out.println(ind(ind)+"</WorkspaceObject>");
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
    }
  /**
   * @ast method 
   * @aspect PrettyPrinter
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1775
   */
  public void prettyPrint(String ind, PrintStream pStream) {
    pStream.print(ind+"<WorkspaceObject ");
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
       pStream.println(ind+"</WorkspaceObject> ");
    }
  }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:176
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		try {
			System.out.println("Adding: WorkspaceObject");
			URI uri = f.createURI(baseURI+"#"+name());
			Literal stepName = f.createLiteral(name());
			// con.add(stepURI,OWL.INDIVIDUAL, state);
			con.add(uri,OWL.INDIVIDUAL, f.createURI(sfcBaseURI+"#WorkspaceObject"), context);
			con.add(uri, f.createURI(baseURI+"#name"), stepName, context);
			// con.add(stepURI,f.createURI(sfcBaseURI+"#content"),f.createLiteral(content()),context);
			// addActionText(stepURI,con,f,context);
			con.add(uri,f.createURI(sfcBaseURI+"#content"),f.createLiteral(content()),context);
			getParent().enclosingNode().addNode(uri,con,f,context);
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
		// We should iterate over subnodes, but for now we just use content instead
		// super.populateOntology(con,f,context);
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:415
   */
  public void addNode(URI uri, RepositoryConnection con, ValueFactory f, URI context) {
		try {
			con.add(f.createURI(sfcBaseURI+"#"+name()),f.createURI(sfcBaseURI+"#node"),uri,context);
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		} 
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _WorkspaceObject(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _WorkspaceObject(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _WorkspaceObject() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public _WorkspaceObject(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_WorkspaceObject");
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
  protected int getenabled_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getenabled_computed = false;
  /**
   * @apilevel internal
   */
  protected _enabled getenabled_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1062
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _enabled getenabled() {
    if(getenabled_computed) {
      return getenabled_value;
    }
      ASTNode$State state = state();
    if(getenabled_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getenabled in class: ");
    getenabled_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getenabled_value = getenabled_compute();
    getenabled_value.setParent(this);
    getenabled_value.is$Final = true;
if(true) getenabled_computed = true;
    getenabled_visited = -1;
    return getenabled_value;
  }
  /**
   * @apilevel internal
   */
  private _enabled getenabled_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _enabled) {
                return (_enabled) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getfileName_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getfileName_computed = false;
  /**
   * @apilevel internal
   */
  protected _fileName getfileName_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1070
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _fileName getfileName() {
    if(getfileName_computed) {
      return getfileName_value;
    }
      ASTNode$State state = state();
    if(getfileName_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getfileName in class: ");
    getfileName_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getfileName_value = getfileName_compute();
    getfileName_value.setParent(this);
    getfileName_value.is$Final = true;
if(true) getfileName_computed = true;
    getfileName_visited = -1;
    return getfileName_value;
  }
  /**
   * @apilevel internal
   */
  private _fileName getfileName_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _fileName) {
                return (_fileName) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getheight_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getheight_computed = false;
  /**
   * @apilevel internal
   */
  protected _height getheight_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1078
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _height getheight() {
    if(getheight_computed) {
      return getheight_value;
    }
      ASTNode$State state = state();
    if(getheight_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getheight in class: ");
    getheight_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getheight_value = getheight_compute();
    getheight_value.setParent(this);
    getheight_value.is$Final = true;
if(true) getheight_computed = true;
    getheight_visited = -1;
    return getheight_value;
  }
  /**
   * @apilevel internal
   */
  private _height getheight_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _height) {
                return (_height) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int gethorizontalScrollBar_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean gethorizontalScrollBar_computed = false;
  /**
   * @apilevel internal
   */
  protected _horizontalScrollBar gethorizontalScrollBar_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1086
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _horizontalScrollBar gethorizontalScrollBar() {
    if(gethorizontalScrollBar_computed) {
      return gethorizontalScrollBar_value;
    }
      ASTNode$State state = state();
    if(gethorizontalScrollBar_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: gethorizontalScrollBar in class: ");
    gethorizontalScrollBar_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    gethorizontalScrollBar_value = gethorizontalScrollBar_compute();
    gethorizontalScrollBar_value.setParent(this);
    gethorizontalScrollBar_value.is$Final = true;
if(true) gethorizontalScrollBar_computed = true;
    gethorizontalScrollBar_visited = -1;
    return gethorizontalScrollBar_value;
  }
  /**
   * @apilevel internal
   */
  private _horizontalScrollBar gethorizontalScrollBar_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _horizontalScrollBar) {
                return (_horizontalScrollBar) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getname_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getname_computed = false;
  /**
   * @apilevel internal
   */
  protected _name getname_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1094
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _name getname() {
    if(getname_computed) {
      return getname_value;
    }
      ASTNode$State state = state();
    if(getname_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getname in class: ");
    getname_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getname_value = getname_compute();
    getname_value.setParent(this);
    getname_value.is$Final = true;
if(true) getname_computed = true;
    getname_visited = -1;
    return getname_value;
  }
  /**
   * @apilevel internal
   */
  private _name getname_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _name) {
                return (_name) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getownerClass_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getownerClass_computed = false;
  /**
   * @apilevel internal
   */
  protected _ownerClass getownerClass_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1102
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _ownerClass getownerClass() {
    if(getownerClass_computed) {
      return getownerClass_value;
    }
      ASTNode$State state = state();
    if(getownerClass_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getownerClass in class: ");
    getownerClass_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getownerClass_value = getownerClass_compute();
    getownerClass_value.setParent(this);
    getownerClass_value.is$Final = true;
if(true) getownerClass_computed = true;
    getownerClass_visited = -1;
    return getownerClass_value;
  }
  /**
   * @apilevel internal
   */
  private _ownerClass getownerClass_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _ownerClass) {
                return (_ownerClass) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getscanCycle_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getscanCycle_computed = false;
  /**
   * @apilevel internal
   */
  protected _scanCycle getscanCycle_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1110
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _scanCycle getscanCycle() {
    if(getscanCycle_computed) {
      return getscanCycle_value;
    }
      ASTNode$State state = state();
    if(getscanCycle_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getscanCycle in class: ");
    getscanCycle_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getscanCycle_value = getscanCycle_compute();
    getscanCycle_value.setParent(this);
    getscanCycle_value.is$Final = true;
if(true) getscanCycle_computed = true;
    getscanCycle_visited = -1;
    return getscanCycle_value;
  }
  /**
   * @apilevel internal
   */
  private _scanCycle getscanCycle_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _scanCycle) {
                return (_scanCycle) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getuseIcon_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getuseIcon_computed = false;
  /**
   * @apilevel internal
   */
  protected _useIcon getuseIcon_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1118
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _useIcon getuseIcon() {
    if(getuseIcon_computed) {
      return getuseIcon_value;
    }
      ASTNode$State state = state();
    if(getuseIcon_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getuseIcon in class: ");
    getuseIcon_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getuseIcon_value = getuseIcon_compute();
    getuseIcon_value.setParent(this);
    getuseIcon_value.is$Final = true;
if(true) getuseIcon_computed = true;
    getuseIcon_visited = -1;
    return getuseIcon_value;
  }
  /**
   * @apilevel internal
   */
  private _useIcon getuseIcon_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _useIcon) {
                return (_useIcon) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getverticalScrollBar_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getverticalScrollBar_computed = false;
  /**
   * @apilevel internal
   */
  protected _verticalScrollBar getverticalScrollBar_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1126
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _verticalScrollBar getverticalScrollBar() {
    if(getverticalScrollBar_computed) {
      return getverticalScrollBar_value;
    }
      ASTNode$State state = state();
    if(getverticalScrollBar_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getverticalScrollBar in class: ");
    getverticalScrollBar_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getverticalScrollBar_value = getverticalScrollBar_compute();
    getverticalScrollBar_value.setParent(this);
    getverticalScrollBar_value.is$Final = true;
if(true) getverticalScrollBar_computed = true;
    getverticalScrollBar_visited = -1;
    return getverticalScrollBar_value;
  }
  /**
   * @apilevel internal
   */
  private _verticalScrollBar getverticalScrollBar_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _verticalScrollBar) {
                return (_verticalScrollBar) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getwidth_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getwidth_computed = false;
  /**
   * @apilevel internal
   */
  protected _width getwidth_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1134
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _width getwidth() {
    if(getwidth_computed) {
      return getwidth_value;
    }
      ASTNode$State state = state();
    if(getwidth_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getwidth in class: ");
    getwidth_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getwidth_value = getwidth_compute();
    getwidth_value.setParent(this);
    getwidth_value.is$Final = true;
if(true) getwidth_computed = true;
    getwidth_visited = -1;
    return getwidth_value;
  }
  /**
   * @apilevel internal
   */
  private _width getwidth_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _width) {
                return (_width) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getx_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getx_computed = false;
  /**
   * @apilevel internal
   */
  protected _x getx_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1142
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _x getx() {
    if(getx_computed) {
      return getx_value;
    }
      ASTNode$State state = state();
    if(getx_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getx in class: ");
    getx_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getx_value = getx_compute();
    getx_value.setParent(this);
    getx_value.is$Final = true;
if(true) getx_computed = true;
    getx_visited = -1;
    return getx_value;
  }
  /**
   * @apilevel internal
   */
  private _x getx_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _x) {
                return (_x) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int gety_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean gety_computed = false;
  /**
   * @apilevel internal
   */
  protected _y gety_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1150
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _y gety() {
    if(gety_computed) {
      return gety_value;
    }
      ASTNode$State state = state();
    if(gety_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: gety in class: ");
    gety_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    gety_value = gety_compute();
    gety_value.setParent(this);
    gety_value.is$Final = true;
if(true) gety_computed = true;
    gety_visited = -1;
    return gety_value;
  }
  /**
   * @apilevel internal
   */
  private _y gety_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _y) {
                return (_y) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
