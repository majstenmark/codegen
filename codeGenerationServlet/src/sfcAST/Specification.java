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
 * @declaredat sfc.ast:6
 */
public class Specification extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
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
  public Specification clone() throws CloneNotSupportedException {
    Specification node = (Specification)super.clone();
    node.getNode_String_visited = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Specification copy() {
      try {
        Specification node = (Specification)clone();
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
  public Specification fullCopy() {
    Specification res = (Specification)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:67
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {	
	 out.println(ind(ind)+"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
	 out.println(ind(ind)+"<GCDocument name=\""+val+"\" color=\"-1\" dimTicks=\"25\" dpwsInterface=\"\" dpwsPort=\"-1\" height=\"778\" horizontalScrollBar=\"1\" modifiable=\"1\"  saveVersion=\"4\" scale=\"0.66\" simulationMode=\"0\" socketHost=\"\" socketPort=\"-1\" threadSpeed=\"20\" tokenLuminance=\"0\" verticalScrollBar=\"1\" viewPositionX=\"918\" viewPositionY=\"250\" width=\"860\" x=\"15\" y=\"17\">");
	try {
		TupleQueryResult result = queryRepo(con,"{?s sfc:hasInitialStep ?step}");
		while (result.hasNext()) {
			BindingSet bindingSet = result.next();
			Value stepVal = bindingSet.getValue("step");
			_GCInitialStep doc = new _GCInitialStep();
			addElement(doc);
			doc.generateXML(out,ind+1,stepVal,con);
		}
		result = queryRepo(con,"{?s sfc:node ?node}");
		while (result.hasNext()) {
			BindingSet bindingSet = result.next();
			Value v = bindingSet.getValue("node");
			// _WorkspaceObject wso = new _WorkspaceObject();
			// addElement(wso);
			// wso.generateXML(out,ind+1,stepVal,con);
			genNextStep(out,ind,v,con);
		}
	} catch (OpenRDFException e) {
		// handle exception
		e.printStackTrace(System.out);
	}		
	out.print(ind(ind));
	out.print("</GCDocument>");
}
  
 
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:48
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		// Real ugly hack for demo purpose!
		// URI sfcSuperClassURI = f.createURI(sfcBaseURI+"#SFC");
		URI sfcClassURI = f.createURI(sfcBaseURI+"#"+sfcType+"SFC");
		URI sfcURI = f.createURI(sfcBaseURI+"#"+sfcType+"SFC_0");
		URI sfcSkillClassURI = f.createURI(shieldCanBaseURI+"#"+sfcType);
		URI sfcSkillURI = f.createURI(shieldCanBaseURI+"#"+sfcType+"_0");
		String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
		URI sfcOntologyType = f.createURI(sfcBaseURI + "#SFC");
		// Literal name = f.createLiteral("shieldCanInsertion");
		// Literal description = f.createLiteral("SFC controlling insertion of shield can on cell phone");
		Literal name = f.createLiteral(sfcName);
		Literal type = f.createLiteral(sfcType);
		System.out.println("COntroller " + controllerType);
		
		Literal controller = f.createLiteral(controllerType);
		System.out.println("COntroller " + controller.toString());
		Literal description = f.createLiteral(sfcDescription);
		//System.out.println("sfcDescr. "+sfcDescription);
		try {
			//System.out.println(" Adding SFC URI: "+sfcURI);
			con.add(sfcURI,OWL.INDIVIDUAL,sfcClassURI,context);
			con.add(sfcSkillURI,OWL.INDIVIDUAL,sfcSkillClassURI,context);
			con.add(sfcURI,f.createURI(sfcBaseURI+"#performSkills"),sfcSkillURI,context);
			con.add(sfcURI,f.createURI(sfcBaseURI+"#describesSkill"),sfcSkillURI,context);
			con.add(sfcURI,f.createURI(sfcBaseURI+"#name"),name,context);
			con.add(sfcURI,f.createURI(sfcBaseURI+"#type"),type,context);
			con.add(sfcURI,f.createURI(sfcBaseURI+"#controllerType"),controller,context);
			con.add(sfcURI,f.createURI(sfcBaseURI+"#sfcDescription"),description,context);
			con.add(sfcClassURI,f.createURI(rdfs + "subClassOf"), sfcOntologyType); // not in context, in ontology

			for (Element e : getElements()) {
				e.populateOntology(con,f,context);
			}
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:398
   */
  public void addNode(URI uri, RepositoryConnection con, ValueFactory f, URI context) {
		URI sfcURI = f.createURI(sfcBaseURI+"#snapFitSFC_0");
		try {
			con.add(sfcURI,f.createURI(sfcBaseURI+"#node"),uri,context);
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		} 
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:838
   */
  public ASTNode enclosingNode() {
		return this;
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public Specification(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public Specification(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public Specification() {
    this(0);

    setChild(new Opt(), 1);
    setChild(new List(), 2);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public Specification(XmlHeader p0, Opt<DocType> p1, List<Element> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:21
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "Specification");
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
    if(i == 0 && !(n instanceof XmlHeader))  throw new Error("Child number 0 of Specification has the type " + n.getClass().getName() + " which is not an instance of XmlHeader");
    if(i == 1) {
      if(!(n instanceof Opt))
        throw new Error("Child number 1 of Specification has the type " + n.getClass().getName() + " which is not an instance of Opt");
      if(((Opt)n).getNumChildNoTransform() != 0 && !(((Opt)n).getChildNoTransform(0) instanceof DocType))
        throw new Error("Optional DocType has the type " + ((Opt)n).getChildNoTransform(0).getClass().getName() + " which is not an instance of DocType");
    }
    if(i == 2) {
      if(!(n instanceof List))
        throw new Error("Child number 2 of Specification has the type " + n.getClass().getName() + " which is not an instance of List");
      for(int k = 0; k < ((List)n).getNumChildNoTransform(); k++)
      if(!(((List)n).getChildNoTransform(k) instanceof Element))
        throw new Error("Child number " + k + " in ElementList has the type " + ((List)n).getChildNoTransform(k).getClass().getName() + " which is not an instance of Element");
    }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:57
   */
  public int getNumChild() {
    return 3;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:63
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for XmlHeader
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setXmlHeader(XmlHeader node) {
    setChild(node, 0);
  }
  /**
   * Getter for XmlHeader
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public XmlHeader getXmlHeader() {
    return (XmlHeader)getChild(0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:18
   */
  public XmlHeader getXmlHeaderNoTransform() {
    return (XmlHeader)getChildNoTransform(0);
  }
  /**
   * Setter for DocTypeOpt
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setDocTypeOpt(Opt<DocType> opt) {
    setChild(opt, 1);
  }
  /**
   * Does this node have a DocType child?
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public boolean hasDocType() {
    return getDocTypeOpt().getNumChild() != 0;
  }
  /**
   * Getter for optional child DocType
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public DocType getDocType() {
    return (DocType)getDocTypeOpt().getChild(0);
  }
  /**
   * Setter for optional child DocType
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:27
   */
  public void setDocType(DocType node) {
    getDocTypeOpt().setChild(node, 0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:37
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Opt<DocType> getDocTypeOpt() {
    return (Opt<DocType>)getChild(1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:44
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Opt<DocType> getDocTypeOptNoTransform() {
    return (Opt<DocType>)getChildNoTransform(1);
  }
  /**
   * Setter for ElementList
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setElementList(List<Element> list) {
    setChild(list, 2);
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
    List<Element> list = (List<Element>)getChild(2);
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
    return (List<Element>)getChildNoTransform(2);
  }
  /**
   * @apilevel internal
   */
  protected java.util.Map getNode_String_visited;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:735
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
		// System.out.println("Specification.getNode("+uid+")");
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
