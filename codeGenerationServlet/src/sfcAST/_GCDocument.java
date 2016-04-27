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
 * @declaredat sfc.ast:80
 */
public class _GCDocument extends ComplexElement implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getGCInitialStep_visited = -1;
    getGCInitialStep_computed = false;
    getGCInitialStep_value = null;
    getEnterStep_visited = -1;
    getEnterStep_computed = false;
    getEnterStep_value = null;
    getExceptionTransition_visited = -1;
    getExceptionTransition_computed = false;
    getExceptionTransition_value = null;
    getExitStep_visited = -1;
    getExitStep_computed = false;
    getExitStep_value = null;
    getGCStep_visited = -1;
    getGCStep_computed = false;
    getGCStep_value = null;
    getGCTransition_visited = -1;
    getGCTransition_computed = false;
    getGCTransition_value = null;
    getMacroStep_visited = -1;
    getMacroStep_computed = false;
    getMacroStep_value = null;
    getParallelSplit_visited = -1;
    getParallelSplit_computed = false;
    getParallelSplit_value = null;
    getRealVariable_visited = -1;
    getRealVariable_computed = false;
    getRealVariable_value = null;
    getStringVariable_visited = -1;
    getStringVariable_computed = false;
    getStringVariable_value = null;
    getWorkspaceObject_visited = -1;
    getWorkspaceObject_computed = false;
    getWorkspaceObject_value = null;
    getGCLink_visited = -1;
    getGCLink_computed = false;
    getGCLink_value = null;
    getAnalogOut_visited = -1;
    getAnalogOut_computed = false;
    getAnalogOut_value = null;
    getAnalogIn_visited = -1;
    getAnalogIn_computed = false;
    getAnalogIn_value = null;
    getcolor_visited = -1;
    getcolor_computed = false;
    getcolor_value = null;
    getdimTicks_visited = -1;
    getdimTicks_computed = false;
    getdimTicks_value = null;
    getdpwsInterface_visited = -1;
    getdpwsInterface_computed = false;
    getdpwsInterface_value = null;
    getdpwsPort_visited = -1;
    getdpwsPort_computed = false;
    getdpwsPort_value = null;
    getheight_visited = -1;
    getheight_computed = false;
    getheight_value = null;
    gethorizontalScrollBar_visited = -1;
    gethorizontalScrollBar_computed = false;
    gethorizontalScrollBar_value = null;
    getmodifiable_visited = -1;
    getmodifiable_computed = false;
    getmodifiable_value = null;
    getname_visited = -1;
    getname_computed = false;
    getname_value = null;
    getsaveVersion_visited = -1;
    getsaveVersion_computed = false;
    getsaveVersion_value = null;
    getscale_visited = -1;
    getscale_computed = false;
    getscale_value = null;
    getsimulationMode_visited = -1;
    getsimulationMode_computed = false;
    getsimulationMode_value = null;
    getsocketHost_visited = -1;
    getsocketHost_computed = false;
    getsocketHost_value = null;
    getsocketPort_visited = -1;
    getsocketPort_computed = false;
    getsocketPort_value = null;
    getthreadSpeed_visited = -1;
    getthreadSpeed_computed = false;
    getthreadSpeed_value = null;
    gettokenLuminance_visited = -1;
    gettokenLuminance_computed = false;
    gettokenLuminance_value = null;
    getverticalScrollBar_visited = -1;
    getverticalScrollBar_computed = false;
    getverticalScrollBar_value = null;
    getviewPositionX_visited = -1;
    getviewPositionX_computed = false;
    getviewPositionX_value = null;
    getviewPositionY_visited = -1;
    getviewPositionY_computed = false;
    getviewPositionY_value = null;
    getwidth_visited = -1;
    getwidth_computed = false;
    getwidth_value = null;
    getx_visited = -1;
    getx_computed = false;
    getx_value = null;
    gety_visited = -1;
    gety_computed = false;
    gety_value = null;
    initialStep_visited = -1;
    links_visited = -1;
    getTransition_String_visited = null;
    steps_visited = -1;
    steps_List__GCStep__visited = null;
    transitions_visited = -1;
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
  public _GCDocument clone() throws CloneNotSupportedException {
    _GCDocument node = (_GCDocument)super.clone();
    node.getGCInitialStep_visited = -1;
    node.getGCInitialStep_computed = false;
    node.getGCInitialStep_value = null;
    node.getEnterStep_visited = -1;
    node.getEnterStep_computed = false;
    node.getEnterStep_value = null;
    node.getExceptionTransition_visited = -1;
    node.getExceptionTransition_computed = false;
    node.getExceptionTransition_value = null;
    node.getExitStep_visited = -1;
    node.getExitStep_computed = false;
    node.getExitStep_value = null;
    node.getGCStep_visited = -1;
    node.getGCStep_computed = false;
    node.getGCStep_value = null;
    node.getGCTransition_visited = -1;
    node.getGCTransition_computed = false;
    node.getGCTransition_value = null;
    node.getMacroStep_visited = -1;
    node.getMacroStep_computed = false;
    node.getMacroStep_value = null;
    node.getParallelSplit_visited = -1;
    node.getParallelSplit_computed = false;
    node.getParallelSplit_value = null;
    node.getRealVariable_visited = -1;
    node.getRealVariable_computed = false;
    node.getRealVariable_value = null;
    node.getStringVariable_visited = -1;
    node.getStringVariable_computed = false;
    node.getStringVariable_value = null;
    node.getWorkspaceObject_visited = -1;
    node.getWorkspaceObject_computed = false;
    node.getWorkspaceObject_value = null;
    node.getGCLink_visited = -1;
    node.getGCLink_computed = false;
    node.getGCLink_value = null;
    node.getAnalogOut_visited = -1;
    node.getAnalogOut_computed = false;
    node.getAnalogOut_value = null;
    node.getAnalogIn_visited = -1;
    node.getAnalogIn_computed = false;
    node.getAnalogIn_value = null;
    node.getcolor_visited = -1;
    node.getcolor_computed = false;
    node.getcolor_value = null;
    node.getdimTicks_visited = -1;
    node.getdimTicks_computed = false;
    node.getdimTicks_value = null;
    node.getdpwsInterface_visited = -1;
    node.getdpwsInterface_computed = false;
    node.getdpwsInterface_value = null;
    node.getdpwsPort_visited = -1;
    node.getdpwsPort_computed = false;
    node.getdpwsPort_value = null;
    node.getheight_visited = -1;
    node.getheight_computed = false;
    node.getheight_value = null;
    node.gethorizontalScrollBar_visited = -1;
    node.gethorizontalScrollBar_computed = false;
    node.gethorizontalScrollBar_value = null;
    node.getmodifiable_visited = -1;
    node.getmodifiable_computed = false;
    node.getmodifiable_value = null;
    node.getname_visited = -1;
    node.getname_computed = false;
    node.getname_value = null;
    node.getsaveVersion_visited = -1;
    node.getsaveVersion_computed = false;
    node.getsaveVersion_value = null;
    node.getscale_visited = -1;
    node.getscale_computed = false;
    node.getscale_value = null;
    node.getsimulationMode_visited = -1;
    node.getsimulationMode_computed = false;
    node.getsimulationMode_value = null;
    node.getsocketHost_visited = -1;
    node.getsocketHost_computed = false;
    node.getsocketHost_value = null;
    node.getsocketPort_visited = -1;
    node.getsocketPort_computed = false;
    node.getsocketPort_value = null;
    node.getthreadSpeed_visited = -1;
    node.getthreadSpeed_computed = false;
    node.getthreadSpeed_value = null;
    node.gettokenLuminance_visited = -1;
    node.gettokenLuminance_computed = false;
    node.gettokenLuminance_value = null;
    node.getverticalScrollBar_visited = -1;
    node.getverticalScrollBar_computed = false;
    node.getverticalScrollBar_value = null;
    node.getviewPositionX_visited = -1;
    node.getviewPositionX_computed = false;
    node.getviewPositionX_value = null;
    node.getviewPositionY_visited = -1;
    node.getviewPositionY_computed = false;
    node.getviewPositionY_value = null;
    node.getwidth_visited = -1;
    node.getwidth_computed = false;
    node.getwidth_value = null;
    node.getx_visited = -1;
    node.getx_computed = false;
    node.getx_value = null;
    node.gety_visited = -1;
    node.gety_computed = false;
    node.gety_value = null;
    node.initialStep_visited = -1;
    node.links_visited = -1;
    node.getTransition_String_visited = null;
    node.steps_visited = -1;
    node.steps_List__GCStep__visited = null;
    node.transitions_visited = -1;
    node.transitions_List__GCTransition__visited = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _GCDocument copy() {
      try {
        _GCDocument node = (_GCDocument)clone();
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
  public _GCDocument fullCopy() {
    _GCDocument res = (_GCDocument)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1841
   */
  public void prettyPrint(String ind, PrintStream pStream) {
	  
    pStream.print(ind+"<GCDocument ");
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
       pStream.println(ind+"</GCDocument> ");
    }
    
  }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:43
   */
  
    URI uri = null;
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:82
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		try {
			URI uri = f.createURI(baseURI+"#gcDocument"+gcDocCount);
			this.uri = uri;
			con.add(uri, OWL.INDIVIDUAL ,f.createURI(baseURI+"#GCDocument"), context);
			getParent().enclosingNode().addNode(uri,con,f,context);
			gcDocCount++;
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
		super.populateOntology(con,f,context);
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:407
   */
  public void addNode(URI uri, RepositoryConnection con, ValueFactory f, URI context) {
		try {
			con.add(this.uri,f.createURI(sfcBaseURI+"#node"),uri,context);
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		} 
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:835
   */
  public ASTNode enclosingNode() {
		return this;
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:873
   */
  public List<_GCTransition> getOutTransitions(String id) {
		List<_GCTransition> trList = new List<_GCTransition>();
		System.out.println("Searching for: "+id);
		for (_GCLink l : links()) {
			System.out.println(l.fromObj());
			if (id.equals(l.fromObj())) {
				System.out.println("Found");
				System.out.println(" To: "+l.toObj());
				System.out.println("     "+getTransition(l.toObj()));
				trList.add(getTransition(l.toObj()));
			}
		}
		return trList;
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _GCDocument(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _GCDocument(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _GCDocument() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public _GCDocument(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_GCDocument");
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
  protected int getGCInitialStep_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getGCInitialStep_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_GCInitialStep> getGCInitialStep_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:8
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCInitialStep> getGCInitialStep() {
    if(getGCInitialStep_computed) {
      return getGCInitialStep_value;
    }
      ASTNode$State state = state();
    if(getGCInitialStep_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getGCInitialStep in class: ");
    getGCInitialStep_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getGCInitialStep_value = getGCInitialStep_compute();
    getGCInitialStep_value.setParent(this);
    getGCInitialStep_value.is$Final = true;
if(true) getGCInitialStep_computed = true;
    getGCInitialStep_visited = -1;
    return getGCInitialStep_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCInitialStep> getGCInitialStep_compute() {
        List<_GCInitialStep> l = new List<_GCInitialStep>();
        for (Element e : getElements()) {
            if (e instanceof _GCInitialStep) {
                l.add((_GCInitialStep)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getEnterStep_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getEnterStep_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_EnterStep> getEnterStep_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:17
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_EnterStep> getEnterStep() {
    if(getEnterStep_computed) {
      return getEnterStep_value;
    }
      ASTNode$State state = state();
    if(getEnterStep_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getEnterStep in class: ");
    getEnterStep_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getEnterStep_value = getEnterStep_compute();
    getEnterStep_value.setParent(this);
    getEnterStep_value.is$Final = true;
if(true) getEnterStep_computed = true;
    getEnterStep_visited = -1;
    return getEnterStep_value;
  }
  /**
   * @apilevel internal
   */
  private List<_EnterStep> getEnterStep_compute() {
        List<_EnterStep> l = new List<_EnterStep>();
        for (Element e : getElements()) {
            if (e instanceof _EnterStep) {
                l.add((_EnterStep)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getExceptionTransition_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getExceptionTransition_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_ExceptionTransition> getExceptionTransition_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:26
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_ExceptionTransition> getExceptionTransition() {
    if(getExceptionTransition_computed) {
      return getExceptionTransition_value;
    }
      ASTNode$State state = state();
    if(getExceptionTransition_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getExceptionTransition in class: ");
    getExceptionTransition_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getExceptionTransition_value = getExceptionTransition_compute();
    getExceptionTransition_value.setParent(this);
    getExceptionTransition_value.is$Final = true;
if(true) getExceptionTransition_computed = true;
    getExceptionTransition_visited = -1;
    return getExceptionTransition_value;
  }
  /**
   * @apilevel internal
   */
  private List<_ExceptionTransition> getExceptionTransition_compute() {
        List<_ExceptionTransition> l = new List<_ExceptionTransition>();
        for (Element e : getElements()) {
            if (e instanceof _ExceptionTransition) {
                l.add((_ExceptionTransition)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getExitStep_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getExitStep_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_ExitStep> getExitStep_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:35
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_ExitStep> getExitStep() {
    if(getExitStep_computed) {
      return getExitStep_value;
    }
      ASTNode$State state = state();
    if(getExitStep_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getExitStep in class: ");
    getExitStep_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getExitStep_value = getExitStep_compute();
    getExitStep_value.setParent(this);
    getExitStep_value.is$Final = true;
if(true) getExitStep_computed = true;
    getExitStep_visited = -1;
    return getExitStep_value;
  }
  /**
   * @apilevel internal
   */
  private List<_ExitStep> getExitStep_compute() {
        List<_ExitStep> l = new List<_ExitStep>();
        for (Element e : getElements()) {
            if (e instanceof _ExitStep) {
                l.add((_ExitStep)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getGCStep_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getGCStep_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_GCStep> getGCStep_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:44
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCStep> getGCStep() {
    if(getGCStep_computed) {
      return getGCStep_value;
    }
      ASTNode$State state = state();
    if(getGCStep_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getGCStep in class: ");
    getGCStep_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getGCStep_value = getGCStep_compute();
    getGCStep_value.setParent(this);
    getGCStep_value.is$Final = true;
if(true) getGCStep_computed = true;
    getGCStep_visited = -1;
    return getGCStep_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCStep> getGCStep_compute() {
        List<_GCStep> l = new List<_GCStep>();
        for (Element e : getElements()) {
            if (e instanceof _GCStep) {
                l.add((_GCStep)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getGCTransition_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getGCTransition_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_GCTransition> getGCTransition_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:53
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCTransition> getGCTransition() {
    if(getGCTransition_computed) {
      return getGCTransition_value;
    }
      ASTNode$State state = state();
    if(getGCTransition_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getGCTransition in class: ");
    getGCTransition_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getGCTransition_value = getGCTransition_compute();
    getGCTransition_value.setParent(this);
    getGCTransition_value.is$Final = true;
if(true) getGCTransition_computed = true;
    getGCTransition_visited = -1;
    return getGCTransition_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCTransition> getGCTransition_compute() {
        List<_GCTransition> l = new List<_GCTransition>();
        for (Element e : getElements()) {
            if (e instanceof _GCTransition) {
                l.add((_GCTransition)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getMacroStep_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getMacroStep_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_MacroStep> getMacroStep_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:62
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_MacroStep> getMacroStep() {
    if(getMacroStep_computed) {
      return getMacroStep_value;
    }
      ASTNode$State state = state();
    if(getMacroStep_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getMacroStep in class: ");
    getMacroStep_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getMacroStep_value = getMacroStep_compute();
    getMacroStep_value.setParent(this);
    getMacroStep_value.is$Final = true;
if(true) getMacroStep_computed = true;
    getMacroStep_visited = -1;
    return getMacroStep_value;
  }
  /**
   * @apilevel internal
   */
  private List<_MacroStep> getMacroStep_compute() {
        List<_MacroStep> l = new List<_MacroStep>();
        for (Element e : getElements()) {
            if (e instanceof _MacroStep) {
                l.add((_MacroStep)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getParallelSplit_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getParallelSplit_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_ParallelSplit> getParallelSplit_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:71
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_ParallelSplit> getParallelSplit() {
    if(getParallelSplit_computed) {
      return getParallelSplit_value;
    }
      ASTNode$State state = state();
    if(getParallelSplit_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getParallelSplit in class: ");
    getParallelSplit_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getParallelSplit_value = getParallelSplit_compute();
    getParallelSplit_value.setParent(this);
    getParallelSplit_value.is$Final = true;
if(true) getParallelSplit_computed = true;
    getParallelSplit_visited = -1;
    return getParallelSplit_value;
  }
  /**
   * @apilevel internal
   */
  private List<_ParallelSplit> getParallelSplit_compute() {
        List<_ParallelSplit> l = new List<_ParallelSplit>();
        for (Element e : getElements()) {
            if (e instanceof _ParallelSplit) {
                l.add((_ParallelSplit)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getRealVariable_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getRealVariable_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_RealVariable> getRealVariable_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:80
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_RealVariable> getRealVariable() {
    if(getRealVariable_computed) {
      return getRealVariable_value;
    }
      ASTNode$State state = state();
    if(getRealVariable_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getRealVariable in class: ");
    getRealVariable_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getRealVariable_value = getRealVariable_compute();
    getRealVariable_value.setParent(this);
    getRealVariable_value.is$Final = true;
if(true) getRealVariable_computed = true;
    getRealVariable_visited = -1;
    return getRealVariable_value;
  }
  /**
   * @apilevel internal
   */
  private List<_RealVariable> getRealVariable_compute() {
        List<_RealVariable> l = new List<_RealVariable>();
        for (Element e : getElements()) {
            if (e instanceof _RealVariable) {
                l.add((_RealVariable)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getStringVariable_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getStringVariable_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_StringVariable> getStringVariable_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:89
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_StringVariable> getStringVariable() {
    if(getStringVariable_computed) {
      return getStringVariable_value;
    }
      ASTNode$State state = state();
    if(getStringVariable_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getStringVariable in class: ");
    getStringVariable_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getStringVariable_value = getStringVariable_compute();
    getStringVariable_value.setParent(this);
    getStringVariable_value.is$Final = true;
if(true) getStringVariable_computed = true;
    getStringVariable_visited = -1;
    return getStringVariable_value;
  }
  /**
   * @apilevel internal
   */
  private List<_StringVariable> getStringVariable_compute() {
        List<_StringVariable> l = new List<_StringVariable>();
        for (Element e : getElements()) {
            if (e instanceof _StringVariable) {
                l.add((_StringVariable)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getWorkspaceObject_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getWorkspaceObject_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_WorkspaceObject> getWorkspaceObject_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:98
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_WorkspaceObject> getWorkspaceObject() {
    if(getWorkspaceObject_computed) {
      return getWorkspaceObject_value;
    }
      ASTNode$State state = state();
    if(getWorkspaceObject_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getWorkspaceObject in class: ");
    getWorkspaceObject_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getWorkspaceObject_value = getWorkspaceObject_compute();
    getWorkspaceObject_value.setParent(this);
    getWorkspaceObject_value.is$Final = true;
if(true) getWorkspaceObject_computed = true;
    getWorkspaceObject_visited = -1;
    return getWorkspaceObject_value;
  }
  /**
   * @apilevel internal
   */
  private List<_WorkspaceObject> getWorkspaceObject_compute() {
        List<_WorkspaceObject> l = new List<_WorkspaceObject>();
        for (Element e : getElements()) {
            if (e instanceof _WorkspaceObject) {
                l.add((_WorkspaceObject)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getGCLink_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getGCLink_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_GCLink> getGCLink_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:107
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCLink> getGCLink() {
    if(getGCLink_computed) {
      return getGCLink_value;
    }
      ASTNode$State state = state();
    if(getGCLink_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getGCLink in class: ");
    getGCLink_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getGCLink_value = getGCLink_compute();
    getGCLink_value.setParent(this);
    getGCLink_value.is$Final = true;
if(true) getGCLink_computed = true;
    getGCLink_visited = -1;
    return getGCLink_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCLink> getGCLink_compute() {
        List<_GCLink> l = new List<_GCLink>();
        for (Element e : getElements()) {
            if (e instanceof _GCLink) {
                l.add((_GCLink)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getAnalogOut_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getAnalogOut_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_AnalogOut> getAnalogOut_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:116
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_AnalogOut> getAnalogOut() {
    if(getAnalogOut_computed) {
      return getAnalogOut_value;
    }
      ASTNode$State state = state();
    if(getAnalogOut_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getAnalogOut in class: ");
    getAnalogOut_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getAnalogOut_value = getAnalogOut_compute();
    getAnalogOut_value.setParent(this);
    getAnalogOut_value.is$Final = true;
if(true) getAnalogOut_computed = true;
    getAnalogOut_visited = -1;
    return getAnalogOut_value;
  }
  /**
   * @apilevel internal
   */
  private List<_AnalogOut> getAnalogOut_compute() {
        List<_AnalogOut> l = new List<_AnalogOut>();
        for (Element e : getElements()) {
            if (e instanceof _AnalogOut) {
                l.add((_AnalogOut)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getAnalogIn_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getAnalogIn_computed = false;
  /**
   * @apilevel internal
   */
  protected List<_AnalogIn> getAnalogIn_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:125
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_AnalogIn> getAnalogIn() {
    if(getAnalogIn_computed) {
      return getAnalogIn_value;
    }
      ASTNode$State state = state();
    if(getAnalogIn_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getAnalogIn in class: ");
    getAnalogIn_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getAnalogIn_value = getAnalogIn_compute();
    getAnalogIn_value.setParent(this);
    getAnalogIn_value.is$Final = true;
if(true) getAnalogIn_computed = true;
    getAnalogIn_visited = -1;
    return getAnalogIn_value;
  }
  /**
   * @apilevel internal
   */
  private List<_AnalogIn> getAnalogIn_compute() {
        List<_AnalogIn> l = new List<_AnalogIn>();
        for (Element e : getElements()) {
            if (e instanceof _AnalogIn) {
                l.add((_AnalogIn)e);
            }
        }
        return l;
    }
  /**
   * @apilevel internal
   */
  protected int getcolor_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getcolor_computed = false;
  /**
   * @apilevel internal
   */
  protected _color getcolor_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:134
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _color getcolor() {
    if(getcolor_computed) {
      return getcolor_value;
    }
      ASTNode$State state = state();
    if(getcolor_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getcolor in class: ");
    getcolor_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getcolor_value = getcolor_compute();
    getcolor_value.setParent(this);
    getcolor_value.is$Final = true;
if(true) getcolor_computed = true;
    getcolor_visited = -1;
    return getcolor_value;
  }
  /**
   * @apilevel internal
   */
  private _color getcolor_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _color) {
                return (_color) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getdimTicks_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getdimTicks_computed = false;
  /**
   * @apilevel internal
   */
  protected _dimTicks getdimTicks_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:142
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _dimTicks getdimTicks() {
    if(getdimTicks_computed) {
      return getdimTicks_value;
    }
      ASTNode$State state = state();
    if(getdimTicks_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getdimTicks in class: ");
    getdimTicks_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getdimTicks_value = getdimTicks_compute();
    getdimTicks_value.setParent(this);
    getdimTicks_value.is$Final = true;
if(true) getdimTicks_computed = true;
    getdimTicks_visited = -1;
    return getdimTicks_value;
  }
  /**
   * @apilevel internal
   */
  private _dimTicks getdimTicks_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _dimTicks) {
                return (_dimTicks) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getdpwsInterface_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getdpwsInterface_computed = false;
  /**
   * @apilevel internal
   */
  protected _dpwsInterface getdpwsInterface_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:150
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _dpwsInterface getdpwsInterface() {
    if(getdpwsInterface_computed) {
      return getdpwsInterface_value;
    }
      ASTNode$State state = state();
    if(getdpwsInterface_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getdpwsInterface in class: ");
    getdpwsInterface_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getdpwsInterface_value = getdpwsInterface_compute();
    getdpwsInterface_value.setParent(this);
    getdpwsInterface_value.is$Final = true;
if(true) getdpwsInterface_computed = true;
    getdpwsInterface_visited = -1;
    return getdpwsInterface_value;
  }
  /**
   * @apilevel internal
   */
  private _dpwsInterface getdpwsInterface_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _dpwsInterface) {
                return (_dpwsInterface) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getdpwsPort_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getdpwsPort_computed = false;
  /**
   * @apilevel internal
   */
  protected _dpwsPort getdpwsPort_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:158
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _dpwsPort getdpwsPort() {
    if(getdpwsPort_computed) {
      return getdpwsPort_value;
    }
      ASTNode$State state = state();
    if(getdpwsPort_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getdpwsPort in class: ");
    getdpwsPort_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getdpwsPort_value = getdpwsPort_compute();
    getdpwsPort_value.setParent(this);
    getdpwsPort_value.is$Final = true;
if(true) getdpwsPort_computed = true;
    getdpwsPort_visited = -1;
    return getdpwsPort_value;
  }
  /**
   * @apilevel internal
   */
  private _dpwsPort getdpwsPort_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _dpwsPort) {
                return (_dpwsPort) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:166
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:174
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
  protected int getmodifiable_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getmodifiable_computed = false;
  /**
   * @apilevel internal
   */
  protected _modifiable getmodifiable_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:182
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _modifiable getmodifiable() {
    if(getmodifiable_computed) {
      return getmodifiable_value;
    }
      ASTNode$State state = state();
    if(getmodifiable_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getmodifiable in class: ");
    getmodifiable_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getmodifiable_value = getmodifiable_compute();
    getmodifiable_value.setParent(this);
    getmodifiable_value.is$Final = true;
if(true) getmodifiable_computed = true;
    getmodifiable_visited = -1;
    return getmodifiable_value;
  }
  /**
   * @apilevel internal
   */
  private _modifiable getmodifiable_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _modifiable) {
                return (_modifiable) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:190
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
  protected int getsaveVersion_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getsaveVersion_computed = false;
  /**
   * @apilevel internal
   */
  protected _saveVersion getsaveVersion_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:198
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _saveVersion getsaveVersion() {
    if(getsaveVersion_computed) {
      return getsaveVersion_value;
    }
      ASTNode$State state = state();
    if(getsaveVersion_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getsaveVersion in class: ");
    getsaveVersion_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getsaveVersion_value = getsaveVersion_compute();
    getsaveVersion_value.setParent(this);
    getsaveVersion_value.is$Final = true;
if(true) getsaveVersion_computed = true;
    getsaveVersion_visited = -1;
    return getsaveVersion_value;
  }
  /**
   * @apilevel internal
   */
  private _saveVersion getsaveVersion_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _saveVersion) {
                return (_saveVersion) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getscale_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getscale_computed = false;
  /**
   * @apilevel internal
   */
  protected _scale getscale_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:206
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _scale getscale() {
    if(getscale_computed) {
      return getscale_value;
    }
      ASTNode$State state = state();
    if(getscale_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getscale in class: ");
    getscale_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getscale_value = getscale_compute();
    getscale_value.setParent(this);
    getscale_value.is$Final = true;
if(true) getscale_computed = true;
    getscale_visited = -1;
    return getscale_value;
  }
  /**
   * @apilevel internal
   */
  private _scale getscale_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _scale) {
                return (_scale) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getsimulationMode_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getsimulationMode_computed = false;
  /**
   * @apilevel internal
   */
  protected _simulationMode getsimulationMode_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:214
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _simulationMode getsimulationMode() {
    if(getsimulationMode_computed) {
      return getsimulationMode_value;
    }
      ASTNode$State state = state();
    if(getsimulationMode_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getsimulationMode in class: ");
    getsimulationMode_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getsimulationMode_value = getsimulationMode_compute();
    getsimulationMode_value.setParent(this);
    getsimulationMode_value.is$Final = true;
if(true) getsimulationMode_computed = true;
    getsimulationMode_visited = -1;
    return getsimulationMode_value;
  }
  /**
   * @apilevel internal
   */
  private _simulationMode getsimulationMode_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _simulationMode) {
                return (_simulationMode) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getsocketHost_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getsocketHost_computed = false;
  /**
   * @apilevel internal
   */
  protected _socketHost getsocketHost_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:222
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _socketHost getsocketHost() {
    if(getsocketHost_computed) {
      return getsocketHost_value;
    }
      ASTNode$State state = state();
    if(getsocketHost_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getsocketHost in class: ");
    getsocketHost_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getsocketHost_value = getsocketHost_compute();
    getsocketHost_value.setParent(this);
    getsocketHost_value.is$Final = true;
if(true) getsocketHost_computed = true;
    getsocketHost_visited = -1;
    return getsocketHost_value;
  }
  /**
   * @apilevel internal
   */
  private _socketHost getsocketHost_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _socketHost) {
                return (_socketHost) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getsocketPort_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getsocketPort_computed = false;
  /**
   * @apilevel internal
   */
  protected _socketPort getsocketPort_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:230
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _socketPort getsocketPort() {
    if(getsocketPort_computed) {
      return getsocketPort_value;
    }
      ASTNode$State state = state();
    if(getsocketPort_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getsocketPort in class: ");
    getsocketPort_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getsocketPort_value = getsocketPort_compute();
    getsocketPort_value.setParent(this);
    getsocketPort_value.is$Final = true;
if(true) getsocketPort_computed = true;
    getsocketPort_visited = -1;
    return getsocketPort_value;
  }
  /**
   * @apilevel internal
   */
  private _socketPort getsocketPort_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _socketPort) {
                return (_socketPort) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getthreadSpeed_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getthreadSpeed_computed = false;
  /**
   * @apilevel internal
   */
  protected _threadSpeed getthreadSpeed_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:238
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _threadSpeed getthreadSpeed() {
    if(getthreadSpeed_computed) {
      return getthreadSpeed_value;
    }
      ASTNode$State state = state();
    if(getthreadSpeed_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getthreadSpeed in class: ");
    getthreadSpeed_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getthreadSpeed_value = getthreadSpeed_compute();
    getthreadSpeed_value.setParent(this);
    getthreadSpeed_value.is$Final = true;
if(true) getthreadSpeed_computed = true;
    getthreadSpeed_visited = -1;
    return getthreadSpeed_value;
  }
  /**
   * @apilevel internal
   */
  private _threadSpeed getthreadSpeed_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _threadSpeed) {
                return (_threadSpeed) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int gettokenLuminance_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean gettokenLuminance_computed = false;
  /**
   * @apilevel internal
   */
  protected _tokenLuminance gettokenLuminance_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:246
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _tokenLuminance gettokenLuminance() {
    if(gettokenLuminance_computed) {
      return gettokenLuminance_value;
    }
      ASTNode$State state = state();
    if(gettokenLuminance_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: gettokenLuminance in class: ");
    gettokenLuminance_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    gettokenLuminance_value = gettokenLuminance_compute();
    gettokenLuminance_value.setParent(this);
    gettokenLuminance_value.is$Final = true;
if(true) gettokenLuminance_computed = true;
    gettokenLuminance_visited = -1;
    return gettokenLuminance_value;
  }
  /**
   * @apilevel internal
   */
  private _tokenLuminance gettokenLuminance_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _tokenLuminance) {
                return (_tokenLuminance) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:254
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
  protected int getviewPositionX_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getviewPositionX_computed = false;
  /**
   * @apilevel internal
   */
  protected _viewPositionX getviewPositionX_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:262
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _viewPositionX getviewPositionX() {
    if(getviewPositionX_computed) {
      return getviewPositionX_value;
    }
      ASTNode$State state = state();
    if(getviewPositionX_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getviewPositionX in class: ");
    getviewPositionX_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getviewPositionX_value = getviewPositionX_compute();
    getviewPositionX_value.setParent(this);
    getviewPositionX_value.is$Final = true;
if(true) getviewPositionX_computed = true;
    getviewPositionX_visited = -1;
    return getviewPositionX_value;
  }
  /**
   * @apilevel internal
   */
  private _viewPositionX getviewPositionX_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _viewPositionX) {
                return (_viewPositionX) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getviewPositionY_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getviewPositionY_computed = false;
  /**
   * @apilevel internal
   */
  protected _viewPositionY getviewPositionY_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:270
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _viewPositionY getviewPositionY() {
    if(getviewPositionY_computed) {
      return getviewPositionY_value;
    }
      ASTNode$State state = state();
    if(getviewPositionY_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getviewPositionY in class: ");
    getviewPositionY_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getviewPositionY_value = getviewPositionY_compute();
    getviewPositionY_value.setParent(this);
    getviewPositionY_value.is$Final = true;
if(true) getviewPositionY_computed = true;
    getviewPositionY_visited = -1;
    return getviewPositionY_value;
  }
  /**
   * @apilevel internal
   */
  private _viewPositionY getviewPositionY_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _viewPositionY) {
                return (_viewPositionY) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:278
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:286
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:294
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
  protected int initialStep_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:845
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
  private _GCInitialStep initialStep_compute() {
		for (Element e : getElements()) {
			if (e instanceof _GCInitialStep) {
				return (_GCInitialStep) e;
			}
		}
		return null;
    }
  /**
   * @apilevel internal
   */
  protected int links_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:854
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCLink> links() {
      ASTNode$State state = state();
    if(links_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: links in class: ");
    links_visited = state().boundariesCrossed;
    List<_GCLink> links_value = links_compute();
    links_visited = -1;
    return links_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCLink> links_compute() {
		List<_GCLink> links = new List<_GCLink>();		
		for (Element e : getElements()) {
			if (e instanceof _GCLink) {
				links.add((_GCLink)e);
			}
		}
		return links;
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map getTransition_String_visited;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:895
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _GCTransition getTransition(String uid) {
    Object _parameters = uid;
    if(getTransition_String_visited == null) getTransition_String_visited = new java.util.HashMap(4);
      ASTNode$State state = state();
    if(Integer.valueOf(state().boundariesCrossed).equals(getTransition_String_visited.get(_parameters)))
      throw new RuntimeException("Circular definition of attr: getTransition in class: ");
    getTransition_String_visited.put(_parameters, Integer.valueOf(state().boundariesCrossed));
    _GCTransition getTransition_String_value = getTransition_compute(uid);
    getTransition_String_visited.remove(_parameters);
    return getTransition_String_value;
  }
  /**
   * @apilevel internal
   */
  private _GCTransition getTransition_compute(String uid) {
		for (Element e : getElements()) {
			// System.out.println(e.id()+" == "+uid);
			if (uid.equals(e.id())) {
				// Check so that this isn't a parallel
				// join. In that case, follow next link.
				if (e instanceof _ParallelJoin) {
					for (_GCLink l : links()) {
						if (uid.equals(l.fromObj())) {
							System.out.println("Found");
							System.out.println(" To: "+l.toObj());
							System.out.println("     "+getTransition(l.toObj()));
							return getTransition(l.toObj());
						}
					}					
				} else {
					return (_GCTransition) e;
				}
			}
		}
		return null;
    }
  /**
   * @apilevel internal
   */
  protected int steps_visited = -1;
  /**
   * @attribute syn
   * @aspect Collect
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:936
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCStep> steps() {
      ASTNode$State state = state();
    if(steps_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: steps in class: ");
    steps_visited = state().boundariesCrossed;
    List<_GCStep> steps_value = steps_compute();
    steps_visited = -1;
    return steps_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCStep> steps_compute() {  return steps(new List<_GCStep>());  }
  /**
   * @apilevel internal
   */
  protected java.util.Map steps_List__GCStep__visited;
  /**
   * @attribute syn
   * @aspect Collect
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:938
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
  private List<_GCStep> steps_compute(List<_GCStep> steps) {
		for (Element e : getElements()) {
			e.steps(steps);
		}
		return steps;
    }
  /**
   * @apilevel internal
   */
  protected int transitions_visited = -1;
  /**
   * @attribute syn
   * @aspect Collect
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:949
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<_GCTransition> transitions() {
      ASTNode$State state = state();
    if(transitions_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: transitions in class: ");
    transitions_visited = state().boundariesCrossed;
    List<_GCTransition> transitions_value = transitions_compute();
    transitions_visited = -1;
    return transitions_value;
  }
  /**
   * @apilevel internal
   */
  private List<_GCTransition> transitions_compute() {  return transitions(new List<_GCTransition>());  }
  /**
   * @apilevel internal
   */
  protected java.util.Map transitions_List__GCTransition__visited;
  /**
   * @attribute syn
   * @aspect Collect
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:951
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
  private List<_GCTransition> transitions_compute(List<_GCTransition> transitions) {
		for (Element e : getElements()) {
			e.transitions(transitions);
		}
		return transitions;
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
