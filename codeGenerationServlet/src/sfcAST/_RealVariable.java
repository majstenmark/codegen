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
 * @declaredat sfc.ast:68
 */
public class _RealVariable extends ComplexElement implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    getconstant_visited = -1;
    getconstant_computed = false;
    getconstant_value = null;
    getexp_visited = -1;
    getexp_computed = false;
    getexp_value = null;
    getheight_visited = -1;
    getheight_computed = false;
    getheight_value = null;
    getinitialValue_visited = -1;
    getinitialValue_computed = false;
    getinitialValue_value = null;
    getname_visited = -1;
    getname_computed = false;
    getname_value = null;
    getupdated_visited = -1;
    getupdated_computed = false;
    getupdated_value = null;
    getvalue_visited = -1;
    getvalue_computed = false;
    getvalue_value = null;
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
  public _RealVariable clone() throws CloneNotSupportedException {
    _RealVariable node = (_RealVariable)super.clone();
    node.getconstant_visited = -1;
    node.getconstant_computed = false;
    node.getconstant_value = null;
    node.getexp_visited = -1;
    node.getexp_computed = false;
    node.getexp_value = null;
    node.getheight_visited = -1;
    node.getheight_computed = false;
    node.getheight_value = null;
    node.getinitialValue_visited = -1;
    node.getinitialValue_computed = false;
    node.getinitialValue_value = null;
    node.getname_visited = -1;
    node.getname_computed = false;
    node.getname_value = null;
    node.getupdated_visited = -1;
    node.getupdated_computed = false;
    node.getupdated_value = null;
    node.getvalue_visited = -1;
    node.getvalue_computed = false;
    node.getvalue_value = null;
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
  public _RealVariable copy() {
      try {
        _RealVariable node = (_RealVariable)clone();
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
  public _RealVariable fullCopy() {
    _RealVariable res = (_RealVariable)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:260
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {
		String id = (val.toString().split("#"))[1];
		// System.out.println("  RealVariable");
		// out.println(ind(ind)+"<RealVar id=\""+id+"\" height=\"14\"  width=\"1063\" x=\"143\" y=\"295\"/>");
		// TupleQueryResult result = queryRepo(con,"{sfc:"+id+" sfc:actionText ?aText}");
		TupleQueryResult result = queryRepo(con,"{sfc:"+id+" sfc:content ?content}");
		try {
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				Value rVal = bindingSet.getValue("content");
				out.println(trim(rVal.toString()));
			}
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
    }
  /**
   * @ast method 
   * @aspect PrettyPrinter
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1709
   */
  public void prettyPrint(String ind, PrintStream pStream) {
    pStream.print(ind+"<RealVariable ");
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
       pStream.println(ind+"</RealVariable> ");
    }
  }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:332
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {
		try {
			URI id = f.createURI(sfcBaseURI+"#"+name()+"_"+varCount);
			varCount++;
			con.add(id, OWL.INDIVIDUAL ,f.createURI(sfcBaseURI+"#RealVariable"),context);
			con.add(id,f.createURI(sfcBaseURI+"#constant"),f.createLiteral(constant()),context);
			con.add(id,f.createURI(sfcBaseURI+"#exp"),f.createLiteral(exp()),context);
			con.add(id,f.createURI(sfcBaseURI+"#initialValue"),f.createLiteral(initialValue()),context);
			con.add(id,f.createURI(sfcBaseURI+"#updated"),f.createLiteral(updated()),context);
			con.add(id,f.createURI(sfcBaseURI+"#value"),f.createLiteral(value()),context);
			enclosingNode().addNode(id,con,f,context);
			con.add(id,f.createURI(sfcBaseURI+"#content"),f.createLiteral(content()),context);
		} catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}
    }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _RealVariable(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _RealVariable(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _RealVariable() {
    this(0);

    setChild(new List(), 0);
    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat sfc.ast:16
   */
  public _RealVariable(List<Attribute> p0, List<Element> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:20
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_RealVariable");
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
  protected int getconstant_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getconstant_computed = false;
  /**
   * @apilevel internal
   */
  protected _constant getconstant_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:902
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _constant getconstant() {
    if(getconstant_computed) {
      return getconstant_value;
    }
      ASTNode$State state = state();
    if(getconstant_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getconstant in class: ");
    getconstant_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getconstant_value = getconstant_compute();
    getconstant_value.setParent(this);
    getconstant_value.is$Final = true;
if(true) getconstant_computed = true;
    getconstant_visited = -1;
    return getconstant_value;
  }
  /**
   * @apilevel internal
   */
  private _constant getconstant_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _constant) {
                return (_constant) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getexp_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getexp_computed = false;
  /**
   * @apilevel internal
   */
  protected _exp getexp_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:918
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _exp getexp() {
    if(getexp_computed) {
      return getexp_value;
    }
      ASTNode$State state = state();
    if(getexp_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getexp in class: ");
    getexp_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getexp_value = getexp_compute();
    getexp_value.setParent(this);
    getexp_value.is$Final = true;
if(true) getexp_computed = true;
    getexp_visited = -1;
    return getexp_value;
  }
  /**
   * @apilevel internal
   */
  private _exp getexp_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _exp) {
                return (_exp) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:934
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
  protected int getinitialValue_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getinitialValue_computed = false;
  /**
   * @apilevel internal
   */
  protected _initialValue getinitialValue_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:950
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _initialValue getinitialValue() {
    if(getinitialValue_computed) {
      return getinitialValue_value;
    }
      ASTNode$State state = state();
    if(getinitialValue_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getinitialValue in class: ");
    getinitialValue_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getinitialValue_value = getinitialValue_compute();
    getinitialValue_value.setParent(this);
    getinitialValue_value.is$Final = true;
if(true) getinitialValue_computed = true;
    getinitialValue_visited = -1;
    return getinitialValue_value;
  }
  /**
   * @apilevel internal
   */
  private _initialValue getinitialValue_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _initialValue) {
                return (_initialValue) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:966
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
  protected int getupdated_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getupdated_computed = false;
  /**
   * @apilevel internal
   */
  protected _updated getupdated_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:982
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _updated getupdated() {
    if(getupdated_computed) {
      return getupdated_value;
    }
      ASTNode$State state = state();
    if(getupdated_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getupdated in class: ");
    getupdated_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getupdated_value = getupdated_compute();
    getupdated_value.setParent(this);
    getupdated_value.is$Final = true;
if(true) getupdated_computed = true;
    getupdated_visited = -1;
    return getupdated_value;
  }
  /**
   * @apilevel internal
   */
  private _updated getupdated_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _updated) {
                return (_updated) a;
            }
        }
        return null;
    }
  /**
   * @apilevel internal
   */
  protected int getvalue_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean getvalue_computed = false;
  /**
   * @apilevel internal
   */
  protected _value getvalue_value;
  /**
   * @attribute syn
   * @aspect NTA
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:998
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _value getvalue() {
    if(getvalue_computed) {
      return getvalue_value;
    }
      ASTNode$State state = state();
    if(getvalue_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: getvalue in class: ");
    getvalue_visited = state().boundariesCrossed;
  int num = state.boundariesCrossed;
  boolean isFinal = this.is$Final();
    getvalue_value = getvalue_compute();
    getvalue_value.setParent(this);
    getvalue_value.is$Final = true;
if(true) getvalue_computed = true;
    getvalue_visited = -1;
    return getvalue_value;
  }
  /**
   * @apilevel internal
   */
  private _value getvalue_compute() {
        for (Attribute a : getAttributes()) {
            if (a instanceof _value) {
                return (_value) a;
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1014
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1030
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1046
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
