package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:17
 */
public class FixedArrayType extends ArrayType implements Cloneable {
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
  public FixedArrayType clone() throws CloneNotSupportedException {
    FixedArrayType node = (FixedArrayType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public FixedArrayType copy() {
      try {
        FixedArrayType node = (FixedArrayType)clone();
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
  public FixedArrayType fullCopy() {
    FixedArrayType res = (FixedArrayType)copy();
    for(int i = 0; i < getNumChildNoTransform(); i++) {
      ASTNode node = getChildNoTransform(i);
      if(node != null) node = node.fullCopy();
      res.setChild(node, i);
    }
    return res;
    }
  /**
   * @ast method 
   * @aspect C_CodeGenEnv
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:112
   */
  public C_env C_Nest(C_env env) {
    String index = ".a";
    for (int i = 0 ; i < getNumExp() ; i++) {
      index += "[i_" + env.depth + "_" + i + "]";
    }
    return env.nestArray(index);
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:295
   */
  public void C_emitType(C_env env, String name) {
    env.println("struct {");
    env.indent();
    StringBuffer index = new StringBuffer("a");
    for (int i = 0 ; i < getNumExp() ; i++) {
      index.append("[" + getExp(i).C_getValue() + "]");
    }
    getType().C_emitType(env, index.toString());
    env.println(";");
    env.unindent();
    env.print("} " + name);
  }
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:210
   */
  public String RAPID_AddType(RAPID_env env, String name) {
		String typeName = getType().RAPID_AddType(env, name + "_e");
		if (getNumExp() > 1) {
			throw new UnsupportedOperationException();
		}
		ArrayList<String> components = new ArrayList<String>();
		for (int i = 1; i <= getExp(0).RAPID_getValue(); i++) {
			components.add(typeName + " e" + i + ";");
		}
		String completeName = env.addRecord("list_" + name, components);
		return completeName;
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:255
   */
  public void RAPID_AddDecodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		for (int i = 1; i <= getExp(0).RAPID_getValue(); i++) {
			getType().RAPID_AddDecodeInstr(env, instrs,
					var_name + ".e" + i, stream_name);
		}
	}
  /**
   * @ast method 
   * @aspect RAPID_CodeGen
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\RAPID_CodeGen.jrag:309
   */
  public void RAPID_AddEncodeInstr(RAPID_env env,
			java.util.List<String> instrs,
			String var_name, String stream_name) {
		for (int i = 1; i <= getExp(0).RAPID_getValue(); i++) {
			getType().RAPID_AddEncodeInstr(env, instrs,
					var_name + ".e" + i, stream_name);
		}
	}
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public FixedArrayType() {
    super();

    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
   */
  public FixedArrayType(Type p0, List<Exp> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:15
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @ast method 
   * @declaredat LabComm.ast:21
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * Setter for Type
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setType(Type node) {
    setChild(node, 0);
  }
  /**
   * Getter for Type
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public Type getType() {
    return (Type)getChild(0);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:18
   */
  public Type getTypeNoTransform() {
    return (Type)getChildNoTransform(0);
  }
  /**
   * Setter for ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:5
   */
  public void setExpList(List<Exp> list) {
    setChild(list, 1);
  }
  /**
   * @return number of children in ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:12
   */
  public int getNumExp() {
    return getExpList().getNumChild();
  }
  /**
   * Getter for child in list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:19
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Exp getExp(int i) {
    return (Exp)getExpList().getChild(i);
  }
  /**
   * Add element to list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:27
   */
  public void addExp(Exp node) {
    List<Exp> list = (parent == null || state == null) ? getExpListNoTransform() : getExpList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:34
   */
  public void addExpNoTransform(Exp node) {
    List<Exp> list = getExpListNoTransform();
    list.addChild(node);
  }
  /**
   * Setter for child in list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:42
   */
  public void setExp(Exp node, int i) {
    List<Exp> list = getExpList();
    list.setChild(node, i);
  }
  /**
   * Getter for Exp list.
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:50
   */
  public List<Exp> getExps() {
    return getExpList();
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:56
   */
  public List<Exp> getExpsNoTransform() {
    return getExpListNoTransform();
  }
  /**
   * Getter for list ExpList
   * @apilevel high-level
   * @ast method 
   * @declaredat LabComm.ast:63
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Exp> getExpList() {
    List<Exp> list = (List<Exp>)getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * @apilevel low-level
   * @ast method 
   * @declaredat LabComm.ast:72
   */
  @SuppressWarnings({"unchecked", "cast"})
  public List<Exp> getExpListNoTransform() {
    return (List<Exp>)getChildNoTransform(1);
  }
  /**
   * @attribute syn
   * @aspect C_IsDynamic
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:143
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean C_isDynamic() {
      ASTNode$State state = state();
    boolean C_isDynamic_value = C_isDynamic_compute();
    return C_isDynamic_value;
  }
  /**
   * @apilevel internal
   */
  private boolean C_isDynamic_compute() {  return getType().C_isDynamic();  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
