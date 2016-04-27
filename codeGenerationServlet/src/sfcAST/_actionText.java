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
 * @declaredat sfc.ast:40
 */
public class _actionText extends Attribute implements Cloneable {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
    super.flushCache();
    uris_String_visited = null;
    params_String_visited = null;
    paramValue_String_visited = null;
    actionText_visited = -1;
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
  public _actionText clone() throws CloneNotSupportedException {
    _actionText node = (_actionText)super.clone();
    node.uris_String_visited = null;
    node.params_String_visited = null;
    node.paramValue_String_visited = null;
    node.actionText_visited = -1;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public _actionText copy() {
      try {
        _actionText node = (_actionText)clone();
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
  public _actionText fullCopy() {
    _actionText res = (_actionText)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1485
   */
  public void prettyPrint(String indent, PrintStream pStream) {
    pStream.print(" actionText=");
       getAttrValue().prettyPrint(indent,pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:1
   */
  public _actionText(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:4
   */
  public _actionText(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:8
   */
  public _actionText() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat sfc.ast:14
   */
  public _actionText(AttrValue p0) {
    setChild(p0, 0);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:17
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "_actionText");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:24
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat sfc.ast:28
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat sfc.ast:33
   */
  public void checkChild(Node n, int i) {
    if(i == 0 && !(n instanceof AttrValue))  throw new Error("Child number 0 of Attribute has the type " + n.getClass().getName() + " which is not an instance of AttrValue");
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:40
   */
  public int getNumChild() {
    return 1;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat sfc.ast:46
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for AttrValue
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:5
   */
  public void setAttrValue(AttrValue node) {
    setChild(node, 0);
  }
  /**
   * Getter for AttrValue
   * @apilevel high-level
   * @ast method 
   * @declaredat sfc.ast:12
   */
  public AttrValue getAttrValue() {
    return (AttrValue)getChild(0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat sfc.ast:18
   */
  public AttrValue getAttrValueNoTransform() {
    return (AttrValue)getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  protected java.util.Map uris_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:536
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
		// int uriIx = value().indexOf("uri");
		// uriIx = uriIx < 0 ? 0 : uriIx;
		// int nlIx = value().lastIndexOf("quot;");
		// nlIx = nlIx < 0 ? value().length() : nlIx;
		// // System.out.println(value()+": "+uriIx+" "+nlIx);
		// String uri = value().substring(uriIx,nlIx-1);

		String[] uris = value().split(uriString+"=");
		LinkedList<String> uriList = new LinkedList<String>();
		for (int i=1; i<uris.length; i++) {
			// System.out.println(uris[i]);
			String uri = uris[i].split("&quot;")[1];
			if (!uri.startsWith("http")) {
				if (uri.startsWith("#")) {
					uri = rosettaBaseURI + uri;
				} else {
					uri = rosettaBaseURI + "#" + uri;
				}
			}
			uriList.add(uri);
			// System.out.println(uri);			
		}
		return uriList;
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map params_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:571
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
		String[] params = value().split(paramString+" = ");
		LinkedList<String> paramList = new LinkedList<String>();
		for (int i=1; i<params.length; i++) {
			// System.out.println(params[i]);
			String param = params[i].split("&quot;")[1];
			if (param.contains(".")) {
				param = param.substring(param.indexOf('.')+1,param.length());
			}
			if (!param.startsWith("http")) {
				if (param.startsWith("#")) {
					param = sfcBaseURI + param;
				} else {
					param = sfcBaseURI + "#" + param;
				}
			}
			paramList.add(param);
			// System.out.println(param);			
		}
		return paramList;
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map paramValue_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:602
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
		int startIx = value().indexOf(parName+" =");
		String val = value().substring(value().indexOf("=",startIx)+1,value().indexOf(";",startIx));
		return val;
    }
  /**
   * @apilevel internal
   */
  protected int actionText_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:640
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
  private String actionText_compute() {  return value();  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
