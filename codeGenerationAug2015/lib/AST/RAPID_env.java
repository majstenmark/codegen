package AST;

import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Collection;
import java.io.PrintStream;

/**
 * @ast class
 * @declaredat :0
 */
public class RAPID_env extends java.lang.Object {

		private String prefix;


		private StringBuilder types;


		private StringBuilder constants;


		private StringBuilder procedures;


		private PrintStream ps;



		public RAPID_env(PrintStream ps, String prefix)
		{
			this.types = new StringBuilder();
			this.constants = new StringBuilder();
			this.procedures = new StringBuilder();
			this.prefix = prefix;
			this.ps = ps;
		}



		public String prefix() { return this.prefix; }



		public String addRecord(String name, java.util.List<String> components)
		{
			String recordName = this.prefix + "_" + name;
			types.append("\tRECORD " + recordName);
			types.append("\n");
			for (String c : components) {
				types.append("\t\t" + c + "\n");
			}
			types.append("\tENDRECORD");
			types.append("\n\n");
			return recordName;
		}



		public void addConstant(String type, String name, String value) {
			this.constants.append("\tLOCAL CONST " + type + " " + name +
					" := " + value + ";\n");
		}



		public void addProc(String name, java.util.List<String> params,
					java.util.List<String> stmts)
		{
			this.procedures.append("\tLOCAL PROC " + name + "(");
			for (int i = 0; i < params.size(); i++) {
				this.procedures.append(params.get(i));
				if (i < params.size() - 1) {
					this.procedures.append(", ");
				}
			}
			this.procedures.append(")\n");
			for (String stmt : stmts) {
				this.procedures.append("\t\t" + stmt + "\n");
			}
			this.procedures.append("\tERROR\n\t\tRAISE ;\n\tENDPROC\n\n");
		}



		public void flush()
		{
			ps.println("MODULE " + prefix() + "(SYSMODULE)");
			ps.println();
			ps.print(types.toString());
			ps.println();
			ps.println("\tLOCAL CONST string prefix:=\"" + this.prefix + "\";");
			ps.print(constants.toString());
			ps.println();
			ps.print(procedures.toString());
			ps.println();
			ps.print("ENDMODULE");
		}


}
