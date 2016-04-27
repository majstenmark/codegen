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


// Generated with JastAdd II (http://jastadd.org) version R20110902

/**
 * @ast node
 * @declaredat ASTNode.ast:0
 */
public class ASTNode<T extends ASTNode> extends SimpleNode  implements Cloneable, Iterable<T> {
  /**
   * @apilevel low-level
   */
  public void flushCache() {
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
    root_visited = -1;
    initialStep_visited = -1;
    fromObj_visited = -1;
    toObj_visited = -1;
  }
  /**
   * @apilevel internal
   */
  public void flushCollectionCache() {
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode)super.clone();
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
    node.root_visited = -1;
    node.initialStep_visited = -1;
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
  public ASTNode<T> copy() {
      try {
        ASTNode node = (ASTNode)clone();
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
  public ASTNode<T> fullCopy() {
    ASTNode res = (ASTNode)copy();
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
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:43
   */
  String ind(int level) {
		StringBuffer ind = new StringBuffer();
		for (int i=0; i<level; i++) {
			ind.append("  ");
		}
		return ind.toString();
    }
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:51
   */
  

    static String qString = null;
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:52
   */
  public static void setQString(String s) {qString = s;}
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:55
   */
  public void generateXML(PrintStream out,int ind,Value val,RepositoryConnection con) {
		System.out.println(getClass().getName()+".generateXML() is not implemented");
    }
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:504
   */
  

   HashSet generatedNodes = new HashSet();
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:506
   */
  void genNextStep(PrintStream out,int ind,Value val,RepositoryConnection con) {
		String id = (val.toString().split("#"))[1];
		
		if (!generatedNodes.contains(id)) {
			generatedNodes.add(id);
			TupleQueryResult result = queryRepo(con,"{sfc:"+id+" owl:Individual ?class}");
			try {
				while (result.hasNext()) {
					BindingSet bindingSet = result.next();
					Value rVal = bindingSet.getValue("class");
					String classId = (rVal.toString().split("#"))[1];
					ComplexElement nextStep = null;
					if (classId.equals("ParallelSplit")) nextStep = new _ParallelSplit();
					if (classId.equals("ParallelJoin")) nextStep = new _ParallelJoin();
					if (classId.equals("GCDocument")) nextStep = new _GCDocument();
					if (classId.equals("MacroStep")) nextStep = new _MacroStep();
					if (classId.equals("Step")) nextStep = new _GCStep();
					if (classId.equals("EnterStep")) nextStep = new _EnterStep();
					if (classId.equals("ExitStep")) nextStep = new _ExitStep();
					if (classId.equals("WorkspaceObject")) nextStep = new _WorkspaceObject();
					if (classId.equals("AnalogIn")) nextStep = new _AnalogIn();
					if (classId.equals("RealVariable")) nextStep = new _RealVariable();
					if (classId.equals("StringVariable")) nextStep = new _StringVariable();
					if (nextStep==null) System.out.println("genNextStep did not find: "+classId);
					nextStep.generateXML(out,ind,val,con);
					// out.print(" actionText="+rVal);
					// _GCInitialStep doc = new _GCInitialStep();
					// addElement(doc);
					// doc.generateXML(out,ind+1,rVal,con);
				}
			} catch (OpenRDFException e) {
				// handle exception
				e.printStackTrace(System.out);
			}		
		}
    }
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:543
   */
  TupleQueryResult queryRepo(RepositoryConnection con, String query) {
		try {
			//System.out.println("Querying ... "+qString+query);
			TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, qString+query);
			TupleQueryResult result = tupleQuery.evaluate();
			return result;
		}
		catch (OpenRDFException e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
		return null;
    }
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:557
   */
  static String trim(String s) {
		if (s.startsWith("\"")) {
			return s.substring(1,s.length()-1);
		}
		return s;
    }
  /**
   * @ast method 
   * @aspect GenerateXML
   * @declaredat /Users/maj/Documents/workspace/sfctest/GenerateXML.jrag:564
   */
  static String setParValue(String aText,String parId,String val) {
		System.out.println("Updating parValue");
		return aText.replaceFirst(parId+" =.*?;",parId+" ="+trim(val)+";");
		// return aText;
    }
  /**
   * @ast method 
   * @aspect PrettyPrinter
   * @declaredat /Users/maj/Documents/workspace/sfctest/GeneratedAspects.jrag:1330
   */
  public void prettyPrint(String indent, PrintStream pStream) {
    for (int i=0; i<getNumChild(); i++) {
      getChild(i).prettyPrint(indent,pStream);
    }
  }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:38
   */
  
    static int skillCount = 0;
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:39
   */
  
    static int paramCount = 0;
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:40
   */
  
    static int aTextCount = 0;
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:41
   */
  
    static int gcDocCount = 0;
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:42
   */
  
    static int varCount = 0;
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:44
   */
  public void populateOntology(RepositoryConnection con, ValueFactory f, URI context) {}
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:391
   */
  public String content() {
		ByteArrayOutputStream content = new ByteArrayOutputStream();
		prettyPrint("",new PrintStream(content));
		return trim(content.toString());
    }
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:397
   */
  public void addNode(URI uri, RepositoryConnection con, ValueFactory f, URI context) {}
  /**
   * @ast method 
   * @aspect PopulateOntology
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:452
   */
  public void addOutLink(String node,RepositoryConnection con, ValueFactory f, URI context) {}
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:697
   */
  

    public static String rosettaBaseURI = "http://kif.cs.lth.se/ontologies/rosetta.owl";
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:698
   */
  
    public static String sfcBaseURI = "http://kif.cs.lth.se/ontologies/sfc.owl";
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:699
   */
  
    public static String shieldCanBaseURI = "http://kif.cs.lth.se/ontologies/shieldcan.owl";
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:700
   */
  
    public static String baseURI = null;
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:701
   */
  public static void setBaseURI(String uri) {
		if (uri.endsWith("#")) {
			uri = uri.substring(0,uri.lastIndexOf('#'));
		}
		baseURI = uri;
    }
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:707
   */
  
    public static String sfcName = null;
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:708
   */
  public static void setName(String name) {
		if (name == null) {
			name = "snapFitSkill";
		}
		sfcName = name;
    }
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:714
   */
 
  public static String controllerType = "ExtCntr";;
 /**
  * @ast method 
  * @aspect SFCtoRDF
  * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:715
  */    
 public static void setController(String cntr) {
		if (cntr == null) {
			cntr = "ExtCntr";
		}
		controllerType = cntr;
   }
  
    public static String sfcType = null;
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:715
   */    
  public static void setType(String type) {
		if (type == null) {
			type = "snapFitSkill";
		}
		sfcType = type;
    }
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:721
   */
  
    public static String sfcDescription = null;
  /**
   * @ast method 
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:722
   */
  public static void setDescription(String description) {
		if (description == null) {
			description = "SFC describing snap-fit skill";
		}
		sfcDescription = description;
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:809
   */
  

    public static Start root = null;
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:818
   */
  public Start start() {
		return getParent().start();
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:825
   */
  public _MacroStep enclMacroStep() {
		return getParent().enclMacroStep();
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:832
   */
  public ASTNode enclosingNode() {
		return getParent().enclosingNode();
    }
  /**
   * @ast method 
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:869
   */
  public List<_GCTransition> getOutTransitions(String id) { return null;}
  /**
   * @ast method 
   * @aspect Misc
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:920
   */
  static String fix(String s) {
		if (s.indexOf('"') == 0) {
			return s.substring(1,s.length()-1);
		}
		return s;
    }
  /**
   * @ast method 
   * @aspect Misc
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:926
   */
  static String unfix(String s) {
		if (s.indexOf('"') != 0) {
			return "\""+s+"\"";
		}
		return s;
    }
  /**
   * @ast method 
   * @aspect Fixes
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:965
   */
  public void fixListParent() {
		for (int i=0; i<getNumChild(); i++) {
			if (getChild(i) instanceof List) {
				// System.out.println("Fixing List: "+getChild(i).getParent());
				getChild(i).setParent(this);
			}
			getChild(i).fixListParent();
		}
    }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:1
   */
  public ASTNode(int i) {
    super(i);
  }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:4
   */
  public ASTNode(XmlParser p, int i) {
    this(i);
    parser = p;
  }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:8
   */
  public ASTNode() {
    this(0);


  }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:14
   */
  public void dumpTree(String indent, java.io.PrintStream pStream) {
    pStream.println(indent + "ASTNode");
        String childIndent = indent + "  ";
    for(int i = 0; i < getNumChild(); i++)
      getChild(i).dumpTree(childIndent, pStream);
  }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:21
   */
  public Object jjtAccept(XmlParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  /**
   * @ast method 
   * @declaredat ASTNode.ast:25
   */
  public void jjtAddChild(Node n, int i) {
    checkChild(n, i);
    if(i >= numChildren) numChildren = i+1;
    super.jjtAddChild(n, i);
}
  /**
   * @ast method 
   * @declaredat ASTNode.ast:31
   */
  public void checkChild(Node n, int i) {
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:37
   */
  

  /**
   * @apilevel internal
   */
  public static final boolean generatedWithCircularEnabled = true;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:41
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithCacheCycle = true;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:45
   */
  
  /**
   * @apilevel internal
   */
  public static final boolean generatedWithComponentCheck = false;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:49
   */
  
  /**
   * @apilevel internal
   */
  protected static ASTNode$State state = new ASTNode$State();
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:53
   */
  public final ASTNode$State state() { return state; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:57
   */
  
  /**
   * @apilevel internal
   */
  public boolean in$Circle = false;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:61
   */
  public boolean in$Circle() { return in$Circle; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:65
   */
  public void in$Circle(boolean b) { in$Circle = b; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:69
   */
  
  /**
   * @apilevel internal
   */
  public boolean is$Final = false;
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:73
   */
  public boolean is$Final() { return is$Final; }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:77
   */
  public void is$Final(boolean b) { is$Final = b; }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:81
   */
  @SuppressWarnings("cast") public T getChild(int i) {
    return (T)ASTNode.getChild(this, i);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:87
   */
  public static ASTNode getChild(ASTNode that, int i) {
    ASTNode node = that.getChildNoTransform(i);
    if(node.is$Final()) return node;
    if(!node.mayHaveRewrite()) {
      node.is$Final(that.is$Final());
      return node;
    }
    if(!node.in$Circle()) {
      int rewriteState;
      int num = that.state().boundariesCrossed;
      do {
        that.state().push(ASTNode$State.REWRITE_CHANGE);
        ASTNode oldNode = node;
        oldNode.in$Circle(true);
        node = node.rewriteTo();
        if(node != oldNode)
          that.setChild(node, i);
        oldNode.in$Circle(false);
        rewriteState = that.state().pop();
      } while(rewriteState == ASTNode$State.REWRITE_CHANGE);
      if(rewriteState == ASTNode$State.REWRITE_NOCHANGE && that.is$Final()) {
        node.is$Final(true);
        that.state().boundariesCrossed = num;
      }
    }
    else if(that.is$Final() != node.is$Final()) that.state().boundariesCrossed++;
    return node;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:118
   */
  
  /**
   * @apilevel internal
   */
  private int childIndex;
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:122
   */
  public int getIndexOfChild(ASTNode node) {
    if(node != null && node.childIndex < getNumChildNoTransform() && node == getChildNoTransform(node.childIndex))
      return node.childIndex;
    for(int i = 0; i < getNumChildNoTransform(); i++)
      if(getChildNoTransform(i) == node) {
        node.childIndex = i;
        return i;
      }
    return -1;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:136
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:142
   */
  @SuppressWarnings("cast")
  public final T getChildNoTransform(int i) {
    return (T)children[i];
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:149
   */
  
  /**
   * @apilevel low-level
   */
  protected int numChildren;
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:153
   */
  protected int numChildren() {
    return numChildren;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:159
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:165
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:171
   */
  public void setChild(ASTNode node, int i) {
  if(children == null) {
      children = new ASTNode[i + 1];
  } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if(i >= numChildren) numChildren = i+1;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:186
   */
  public void insertChild(ASTNode node, int i) {
    if(children == null) {
      children = new ASTNode[i + 1];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if(i < children.length)
        System.arraycopy(children, i, c, i+1, children.length-i);
      children = c;
    }
    numChildren++;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:204
   */
  public void removeChild(int i) {
    if(children != null) {
      ASTNode child = (ASTNode)children[i];
      if(child != null) {
        child.setParent(null);
        child.childIndex = -1;
      }
      System.arraycopy(children, i+1, children, i, children.length-i-1);
      numChildren--;
    }
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:218
   */
  public ASTNode getParent() {
    if(parent != null && ((ASTNode)parent).is$Final() != is$Final()) {
      state().boundariesCrossed++;
    }
    return (ASTNode)parent;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:227
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat ASTNode.ast:243
   */
  public java.util.Iterator<T> iterator() {
  return new java.util.Iterator<T>() {
      private int counter = 0;
      public boolean hasNext() {
        return counter < getNumChild();
      }
      @SuppressWarnings("unchecked") public T next() {
        if(hasNext())
          return (T)getChild(counter++);
        else
          return null;
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
  };
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat ASTNode.ast:263
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   */
  protected java.util.Map uris_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:527
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
  private LinkedList<String> uris_compute(String uriString) {  return null;  }
  /**
   * @apilevel internal
   */
  protected java.util.Map params_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:562
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
  private LinkedList<String> params_compute(String paramString) {  return null;  }
  /**
   * @apilevel internal
   */
  protected java.util.Map paramValue_String_visited;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:593
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
  private String paramValue_compute(String parName) {  return null;  }
  /**
   * @apilevel internal
   */
  protected int id_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:608
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
  private String id_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int name_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:620
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
  private String name_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int actionText_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:631
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
  private String actionText_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int constant_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:642
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
  private String constant_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int exp_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:653
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
  private String exp_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int initialValue_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:664
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
  private String initialValue_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int updated_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:675
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
  private String updated_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int value_visited = -1;
  /**
   * @attribute syn
   * @aspect SFCtoRDF
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:686
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
  private String value_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected java.util.Map getNode_String_visited;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:733
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
  private ComplexElement getNode_compute(String uid) {  return null;  }
  /**
   * @apilevel internal
   */
  protected int root_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:810
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Start root() {
      ASTNode$State state = state();
    if(root_visited == state().boundariesCrossed)
      throw new RuntimeException("Circular definition of attr: root in class: ");
    root_visited = state().boundariesCrossed;
    Start root_value = root_compute();
    root_visited = -1;
    return root_value;
  }
  /**
   * @apilevel internal
   */
  private Start root_compute() {  return root;  }
  /**
   * @apilevel internal
   */
  protected int initialStep_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:843
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
  private _GCInitialStep initialStep_compute() {  return root().initialStep();  }
  /**
   * @apilevel internal
   */
  protected int fromObj_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:864
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
  private String fromObj_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  protected int toObj_visited = -1;
  /**
   * @attribute syn
   * @aspect NavigateSFC
   * @declaredat /Users/maj/Documents/workspace/sfctest/SFCtoRDF.jrag:866
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
  private String toObj_compute() {  return null;  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    if(state().peek() == ASTNode$State.REWRITE_CHANGE) {
      state().pop();
      state().push(ASTNode$State.REWRITE_NOCHANGE);
    }
    return this;
  }
}
