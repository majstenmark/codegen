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
 * @declaredat sfc.ast:64
 */
public class _GCInitialStep extends ComplexElement implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getactionBlockVisible_visited = -1;
    getactionBlockVisible_computed = false;
    getactionBlockVisible_value = null;
    getactionText_visited = -1;
    getactionText_computed = false;
    getactionText_value = null;
    getfileName_visited = -1;
    getfileName_computed = false;
    getfileName_value = null;
    getheight_visited = -1;
    getheight_computed = false;
    getheight_value = null;
    getid_visited = -1;
    getid_computed = false;
    getid_value = null;
    getname_visited = -1;
    getname_computed = false;
    getname_value = null;
    getuseIcon_visited = -1;
    getuseIcon_computed = false;
    getuseIcon_value = null;
    getwidth_visited = -1;
    getwidth_computed = false;
    getwidth_value = null;
    getx_visited = -1;
    getx_computed = false;
    getx_value = null;
    gety_visited = -1;
    gety_computed = false;
    gety_value = null;
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
  public _GCInitialStep clone() throws CloneNotSupportedException {
    _GCInitialStep node = (_GCInitialStep)super.clone();
    node.getactionBlockVisible_visited = -1;
    node.getactionBlockVisible_computed = false;
    node.getactionBlockVisible_value = null;
    node.getactionText_visited = -1;
    node.getactionText_computed = false;
    node.getactionText_value = null;
    node.getfileName_visited = -1;
    node.getfileName_computed = false;
    node.getfileName_value = null;
    node.getheight_visited = -1;
    node.getheight_computed = false;
    node.getheight_value = null;
    node.getid_visited = -1;
    node.getid_computed = false;
    node.getid_value = null;
    node.getname_visited = -1;
    node.getname_computed = false;
    node.getname_value = null;
    node.getuseIcon_visited = -1;
    node.getuseIcon_computed = false;
    node.getuseIcon_value = null;
    node.getwidth_visited = -1;
    node.getwidth_computed = false;
    node.getwidth_value = null;
    node.getx_visited = -1;
    node.getx_computed = false;
    node.getx_value = null;
    node.gety_visited = -1;
    node.gety_computed = false;
    node.gety_value = null;
    node.getNode_String_visited = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _GCInitialStep copy() {
      try {
        _GCInitialStep node = (_GCInitialStep)clone();
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
  public _GCInitialStep fullCopy() {
    _GCInitialStep res = (_GCInitialStep)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:94
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {
		String id = (val.toString().split("#"))[1];
		String name = "\"\"";
		TupleQueryResult result = queryRepo(con,"{sfc:"+id+" sfc:name ?aName}");
		try {
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				name = bindingSet.getValue("aName").toString();
			}
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
		out.print(ind(ind)+"<GCInitialStep id=\""+id+
				  "\" fileName=\"\" height=\"70\"  name="+name+" useIcon=\"0\" width=\"60\" x=\"70\" y=\"25\"");
		result = queryRepo(con,"{sfc:"+id+" sfc:actionText ?aText}");
		try {
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				Value rVal = bindingSet.getValue("aText");
				result = queryRepo(con,"{sfc:"+id+" sfc:hasParameter ?param}");
				while (result.hasNext()) {
					BindingSet bSet = result.next();
					Value p = bSet.getValue("param");
					System.out.println(p);
				}
				out.print(" actionText="+rVal);
			}
			out.println(">");
			out.println(ind(ind)+"</GCInitialStep>");		
			result = queryRepo(con,"{sfc:"+id+" sfc:hasNextTransition ?trans}");
			while (result.hasNext()) {
				BindingSet bSet = result.next();
				Value tr = bSet.getValue("trans");
				_GCLink link = new _GCLink();
				link.generateXML(out,ind,tr,con,id);
				_GCTransition nextTrans = new _GCTransition();
				nextTrans.generateXML(out,ind,tr,con);				
			}
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
    }
  /**
   * @ast method 
   * @aspect PrettyPrinter
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1665
   */
  public void prettyPrint(String ind, PrintStream pStream) {
    pStream.print(ind+"<GCInitialStep ");
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
       pStream.println(ind+"</GCInitialStep> ");
    }
  }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:100
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		URI startStep = f.createURI(baseURI+"#"+id());
		try {
			con.add(startStep, OWL.INDIVIDUAL, f.createURI(sfcBaseURI+"#Step"), context);
			con.add(startStep, f.createURI(baseURI+"#name"), f.createLiteral(name()), context);
			// Add relation from SFC root to this initial step
			con.add(f.createURI(sfcBaseURI+"#"+sfcType+"SFC_0"),
					f.createURI(sfcBaseURI+"#hasInitialStep"),startStep,context);
			for (String uri : uris("skill")) {
				// System.out.println(" Adding skill URI: "+uri);
				URI skillClassURI = f.createURI(uri);
				URI skillURI = f.createURI(uri+"_"+(skillCount++));
				// con.add(skillURI, OWL.INDIVIDUAL, skillClassURI);
				// con.add(stepURI, performSkills, skillURI);
				con.add(skillURI, OWL.INDIVIDUAL, skillClassURI, context);
				con.add(startStep, f.createURI(baseURI+"#performSkills"), skillURI, context);
			}
			for (String param : params("param")) {
				// System.out.println(" Adding param URI: "+param);
				String parShortName = param.substring(param.indexOf('#')+1,param.length());
				// URI paramClassURI = f.createURI(shieldCanBaseURI+"#ShieldCanInsertionParameter");
				URI paramClassURI = f.createURI(shieldCanBaseURI+"#"+
												param.substring(param.indexOf('#')+1,param.length()));
				URI paramURI = f.createURI(param);
				// con.add(paramURI, OWL.INDIVIDUAL, paramClassURI);
				// con.add(stepURI, performParams, paramURI);
				con.add(paramURI, OWL.INDIVIDUAL, paramClassURI, context);
				con.add(startStep, f.createURI(sfcBaseURI+"#hasParameter"), paramURI, context);
				// Get parameter value (if exists)
				String parVal = paramValue(parShortName);
				Literal pVal = f.createLiteral(parVal);
				con.add(paramURI,f.createURI(rosettaBaseURI+"#hasValue"),pVal,context);
			}
			for (Attribute a : getAttributes()) {
				if (a instanceof _actionText) {
					// System.out.println("Adding actionText");
					URI aTextURI = f.createURI(sfcBaseURI+"#actionText_"+aTextCount);
					aTextCount++;
					con.add(startStep,f.createURI(sfcBaseURI+"#actionText"),
							f.createLiteral(a.value()),context);
				}
			}
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:453
   */
  public void addOutLink(String node,RepositoryConnection con, ValueFactory f, URI context) {
		URI fromURI = f.createURI(sfcBaseURI+"#"+id());
		URI toURI = f.createURI(sfcBaseURI+"#"+node);
		try {
			con.add(fromURI,f.createURI(sfcBaseURI+"#hasNextTransition"),toURI,context);
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:891
   */
  public List<_GCTransition> getOutTransitions() {
		return root().getOutTransitions(id());
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _GCInitialStep(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _GCInitialStep(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _GCInitialStep() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public _GCInitialStep(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_GCInitialStep");
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
  protected int getactionBlockVisible_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getactionBlockVisible_computed = false;
  /**
   * @apilevel internal
   */
  protected _actionBlockVisible getactionBlockVisible_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:302
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _actionBlockVisible getactionBlockVisible() {
    if(getactionBlockVisible_computed) {
      return getactionBlockVisible_value;
    }
      ASTNode$State state = state();
    if(getactionBlockVisible_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getactionBlockVisible in class: ");
    getactionBlockVisible_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getactionBlockVisible_value = getactionBlockVisible_compute();
    getactionBlockVisible_value.setParent(this);
    getactionBlockVisible_value.is$Final = true;
if(true) getactionBlockVisible_computed = true;
    getactionBlockVisible_visited = -1;
    return getactionBlockVisible_value;
  }
  /**
   * @apilevel internal
   */
  private _actionBlockVisible getactionBlockVisible_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _actionBlockVisible) {
                return (_actionBlockVisible) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getactionText_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getactionText_computed = false;
  /**
   * @apilevel internal
   */
  protected _actionText getactionText_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:310
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _actionText getactionText() {
    if(getactionText_computed) {
      return getactionText_value;
    }
      ASTNode$State state = state();
    if(getactionText_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getactionText in class: ");
    getactionText_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getactionText_value = getactionText_compute();
    getactionText_value.setParent(this);
    getactionText_value.is$Final = true;
if(true) getactionText_computed = true;
    getactionText_visited = -1;
    return getactionText_value;
  }
  /**
   * @apilevel internal
   */
  private _actionText getactionText_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _actionText) {
                return (_actionText) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:318
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:326
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
  protected int getid_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getid_computed = false;
  /**
   * @apilevel internal
   */
  protected _id getid_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:334
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _id getid() {
    if(getid_computed) {
      return getid_value;
    }
      ASTNode$State state = state();
    if(getid_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getid in class: ");
    getid_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getid_value = getid_compute();
    getid_value.setParent(this);
    getid_value.is$Final = true;
if(true) getid_computed = true;
    getid_visited = -1;
    return getid_value;
  }
  /**
   * @apilevel internal
   */
  private _id getid_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _id) {
                return (_id) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:342
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:350
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:358
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:366
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:374
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
  protected java.util.Map getNode_String_visited;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:752
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
		// System.out.println("   Checking: "+id());
		if (uid.equals(id())) {
			return this;
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
