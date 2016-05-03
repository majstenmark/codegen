package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast node
 * @declaredat LabComm.ast:16
 */
public class VariableArrayType extends ArrayType implements Cloneable {
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
  public VariableArrayType clone() throws CloneNotSupportedException {
    VariableArrayType node = (VariableArrayType)super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  @SuppressWarnings({"unchecked", "cast"})
  public VariableArrayType copy() {
      try {
        VariableArrayType node = (VariableArrayType)clone();
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
  public VariableArrayType fullCopy() {
    VariableArrayType res = (VariableArrayType)copy();
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:120
   */
  public C_env C_Nest(C_env env) {
    return env.nestArray(".a[i_" + env.depth + "]");
  }
  /**
   * @ast method 
   * @aspect C_Type
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:308
   */
  public void C_emitType(C_env env, String name) {
    env.println("struct {");
    env.indent();
    for (int i = 0 ; i < getNumExp() ; i++) {
      if (getExp(i) instanceof VariableSize) {
	env.println("int n_" + i + ";");
      } else {
	env.println("// n_" + i + "=" + getExp(i).C_getValue());
      }
    }
    getType().C_emitType(env, "*a");
    env.println(";");
    env.unindent();
    env.print("} " + name);
  }
  /**
   * @ast method 
   * @aspect C_Index
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:416
   */
  public void C_emitCalcIndex(C_env env) {
    env.print("int i_" + env.depth + " = ");

    String i_prefix = "i_" + env.depth + "_";
    String expr = i_prefix + "0";
    for (int i = 1 ; i < getNumExp() ; i++) {
      expr = "(" + expr + ") * " +
	getExp(i).C_getLimit(env, i) + " + " + 
	i_prefix + i;
    }
    env.println(expr + ";");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:540
   */
  public void C_emitDecoderArrayAllocate(C_env env) {
    env.print(env.qualid + 
              ".a = labcomm_memory_alloc(r->memory, 1, sizeof(" + 
	      env.qualid + ".a[0])");
    for (int i = 0 ; i < getNumExp() ; i++) {
      env.print(" * " + getExp(i).C_getLimit(env, i));
    }
    env.println(");");
  }
  /**
   * @ast method 
   * @aspect C_Decoder
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:604
   */
  public void C_emitDecoderDeallocation(C_env env) {
    super.C_emitDecoderDeallocation(env);
    env.println("labcomm_memory_free(r->memory, 1, " + 
                env.qualid + ".a);");
  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:1
   */
  public VariableArrayType() {
    super();

    setChild(new List(), 1);

  }
  /**
   * @ast method 
   * @declaredat LabComm.ast:8
   */
  public VariableArrayType(Type p0, List<Exp> p1) {
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
   * @declaredat C:\Users\Maj\Documents\Stuff\labcomm.git\compiler\C_CodeGen.jrag:144
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
  private boolean C_isDynamic_compute() {  return true;  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
}
