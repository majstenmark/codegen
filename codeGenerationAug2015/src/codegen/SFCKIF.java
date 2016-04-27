package codegen;
/* 
 * Copyright (C) 2012,2013  Anders Nilsson <anders.nilsson@control.lth.se>
 *
 * This file is part of SFCKIF.
 *
 * SFCKIF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XMLSchemaCompiler is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SFCKIF.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

import org.openrdf.model.*;
import org.openrdf.model.vocabulary.OWL;
import org.openrdf.query.BindingSet;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.Update;
import org.openrdf.query.resultio.sparqlxml.SPARQLResultsXMLWriter;
import org.openrdf.repository.*;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.repository.sail.*;
import org.openrdf.rio.RDFFormat;
import org.openrdf.sail.inferencer.fc.ForwardChainingRDFSInferencer;
import org.openrdf.sail.memory.MemoryStore;

import sfcAST.Start;
import sfcAST.*;

public class SFCKIF {
	String qFile = null, sfcFile = null;
	String sesameServer = null, repoID = null;
	String sfcName = null, sfcDescription = null;
    String cont = null, sfcType = null;
	String rootURI = "sfc:snapFitSkillSFC";
	String controllerType = "extcntr";
	Repository repository = null; 
	static int nbr = 0;
	
	Repository localRepository = null;
	String SFCBaseURI = "http://kif.cs.lth.se/ontologies/sfc.owl#";
	// String ShieldCanBaseURI = "http://kif.cs.lth.se/ontologies/shieldcan.owl#";
	String RosettaBaseURI = "http://kif.cs.lth.se/ontologies/rosetta.owl#";
	String insertNode = null, firstNode = null, lastNode = null;
	URI context = null;
	
	public SFCKIF(){}
	
	public SFCKIF(String server, String repo, String contextUri){
		repoID = repo;
		sesameServer = server;
		cont = contextUri;
		
	}
	
	public String getSFCXML(){
		
		initSesameConnection();
		String content = sfcToXml();
		closeConnection();
		return content;
	}
	

	String sfcToXml() {
		System.err.println("WTF?");
		try {
			RepositoryConnection con = repository.getConnection();
			// OK, now try to regenerate JGrafchart XML from information stored in Sesame
			String qString = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  "+
				"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "+
				"select distinct ?sfc  where { graph <" + cont + "> {?sfc owl:Individual ?type.} " +
				"?type rdfs:subClassOf sfc:SFC.}";
			String qHead = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix ns: <http://kif.cs.lth.se/ontologies/rosetta.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  "+
				"select distinct *  where ";
				// "select distinct * from <"+context+"> where ";
		//	System.out.println("Query " + qString);

			TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL,qString);
			TupleQueryResult result = tupleQuery.evaluate();
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				Value sfcVal = bindingSet.getValue("sfc");
				System.out.println("SFC: "+sfcVal);
				Start newRoot = new Start();
			//	System.out.println("Query 2" + qHead);
				newRoot.setQString(qHead);
				//ByteArrayOutputStream output = new ByteArrayOutputStream();
				File tmpFile = new File("t"+nbr+  "mp.xml");
				nbr ++;
				PrintStream out = new PrintStream(tmpFile);
				newRoot.generateXML(out,0,sfcVal,con);
				//out.println(); // One extra newline, just for the sake of it.
				
				String wobj = "";
				ReadWriteTextFile rwtf = new ReadWriteTextFile();
				String str = rwtf.getContents(tmpFile);
			
				int wstart = 0, wend = 0;
				while(wstart >=0 && wend >= 0){
					 wstart = str.indexOf("<WorkspaceObject", wend);
					 String s = "</WorkspaceObject>";
					 wend = str.indexOf(s, wstart);
					 if(wstart > 0 && wend >0){
						 String tmp = str.substring(wstart, wend+s.length());
						 wobj += tmp;
						 
						 
					 }
					
				}
				tmpFile.delete();
				System.err.println("FGHHGFGHFG " + str);
				int start = str.indexOf("<MacroStep");
				
				int last = str.indexOf("</GCDocument>", start);
				str = str.substring(start, last);
				str += wobj + "</GCDocument></MacroStep>";
				
				
				return str;
				//
			}				
		}
		catch (Exception e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
		
		return "";
	//	catch (IOException e) {
			// handle exception
		//	e.printStackTrace(System.out);
	//	}
	}
	
	public static void main(String[] args) {
		LinkedList<String> ontoList = new LinkedList<String>();
		String command = null;
		SFCKIF obj = new SFCKIF();
		
		for (int i=0; i<args.length; i++) {
			if (args[i].equals("-q")) { // query
				obj.qFile = args[++i];
			}
			if (args[i].equals("-o")) { // ontology
				ontoList.add(args[++i]);
			}
			if (args[i].equals("-s")) { // sesame server URL
				obj.sesameServer = args[++i];
			}
			if (args[i].equals("-r")) { // repo on sesame server
				obj.repoID = args[++i];
			}
			if (args[i].equals("-q")) { // 
				obj.controllerType = args[++i];
			}
			if (args[i].equals("-n")) { // Explicit SFC name
				obj.sfcName = args[++i];
			}
			if (args[i].equals("-t")) { // Explicit SFC type
				obj.sfcType = args[++i];
			}
			if (args[i].equals("-d")) { // Description string
				obj.sfcDescription = args[++i];
				System.out.println("Description: "+obj.sfcDescription);
			}
			if (args[i].equals("-f")) { // SFC file, both for input and output
				obj.sfcFile = args[++i];
			}
			if (args[i].equals("-x")) { // Context
				obj.cont = args[++i];
			}
			if (args[i].equals("-c")) { // Command
				command = args[++i];
			}
			if (args[i].equals("-nodes")) { // Merge point
				obj.insertNode = args[++i];
				obj.firstNode = args[++i];
				obj.lastNode = args[++i];
			} else {
			}
		}


		obj.initSesameConnection();



		// Add states and transitions from an
		// SFC describing the robot task.

		// System.out.println("Command: "+command);
		switch (command) {
		case "put": obj.loadSFC();
			break;
		case "get": obj.printSFC();
			break;
		case "merge": obj.mergeSFC();
			break;
		}
	}

	void initSesameConnection() {
		if (sesameServer != null) {
			//try {
				System.out.println("Opening Sesame: "+sesameServer+":"+repoID);
				localRepository = new SailRepository(new MemoryStore());
				repository = new HTTPRepository(sesameServer,repoID);
				try {
					localRepository.initialize();

					repository.initialize();
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//	} catch ( e) {
				// handle exception
			//	e.printStackTrace(System.out);
		//	}
		} else {
			System.out.println("Missing repository reference.");
			System.exit(1);
		}
		ValueFactory f = repository.getValueFactory();
		if (cont == null) {
			context = f.createURI("file://" + sfcFile);
		} else {
			context = f.createURI(cont);
		}
		System.out.println("Context: "+context);
	}
	
	void closeConnection(){
	
			if (sesameServer != null) {
				try{
					localRepository.shutDown();
					repository.shutDown();
				}catch(Exception e){
					e.printStackTrace();
				}
		}
	}

	void loadSFC() {
		System.out.println("Import to KIF: "+sfcName);
		ValueFactory f = repository.getValueFactory();
		RepositoryConnection con = null;
		RepositoryConnection remoteCon = null;
		
		try {
			con = localRepository.getConnection();
			remoteCon = repository.getConnection();
			// Prepare for the new file contents
			con.clear(context);
			String[] arg = {sfcFile};
			Start sfc = Parser.parse(arg);

			System.out.println("context: "+context);
			sfc.setBaseURI(SFCBaseURI);
			System.out.println("setName: "+sfcName);
			sfc.setName(sfcName);
			System.out.println("setType: "+sfcType);
			sfc.setType(sfcType);
			System.out.println("setDescription: "+sfcDescription);
			sfc.setDescription(sfcDescription);
			sfc.populateOntology(con,f,context);
			remoteCon.clear(context);

			RepositoryResult<Statement> res = con.getStatements(null, null, null, true);
			remoteCon.add(res, context);
			remoteCon.close();
			con.close();
			
			
			
		}
		catch (RepositoryException e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
	}

	String getControllerType() {
		try {
			RepositoryConnection con = repository.getConnection();
			// OK, now try to regenerate JGrafchart XML from information stored in Sesame
			String qString = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  "+
				"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "+
				"select distinct ?cntr  where { graph <" + cont + "> {?sfc owl:Individual ?type.} " +
				"?type rdfs:subClassOf sfc:SFC. ?sfc sfc:controllerType ?cntr}";
			TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL,qString);
			TupleQueryResult result = tupleQuery.evaluate();
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				Value cntrVal = bindingSet.getValue("cntr");
				if(cntrVal !=null) return cntrVal.toString();
			}				
		}
		catch (Exception e) {
			// handle exception
			e.printStackTrace(System.out);
		}
		return "ExtCntr";
		}

	void printSFC() {
		try {
			RepositoryConnection con = repository.getConnection();
			// OK, now try to regenerate JGrafchart XML from information stored in Sesame
			String qString = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  "+
				"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> "+
				"select distinct ?sfc  where { graph <" + cont + "> {?sfc owl:Individual ?type.} " +
				"?type rdfs:subClassOf sfc:SFC.}";
			String qHead = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix ns: <http://kif.cs.lth.se/ontologies/rosetta.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  "+
				"select distinct * where ";
				// "select distinct * from <"+context+"> where ";
			System.out.println("Query " + qString);

			TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL,qString);
			TupleQueryResult result = tupleQuery.evaluate();
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				Value sfcVal = bindingSet.getValue("sfc");
				//System.out.println("SFC: "+sfcVal);
				Start newRoot = new Start();
				newRoot.setQString(qHead);
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				PrintStream out = new PrintStream(sfcFile);
				newRoot.generateXML(out,0,sfcVal,con);
			//	out.println(); // One extra newline, just for the sake of it.
			//	System.out.println("*** Generated XML ***");
			}				
		}
		catch (Exception e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
	//	catch (IOException e) {
			// handle exception
		//	e.printStackTrace(System.out);
	//	}
	}

	void mergeSFC() {
		try {
			System.out.println("insertNode: "+insertNode);
			System.out.println("firstNode: "+firstNode);
			System.out.println("lastNode: "+lastNode);
			RepositoryConnection con = repository.getConnection();
			String pre = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix ns: <http://kif.cs.lth.se/ontologies/rosetta.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  \n";
			String qHead = "prefix sfc: <http://kif.cs.lth.se/ontologies/sfc.owl#> "+
				"prefix ns: <http://kif.cs.lth.se/ontologies/rosetta.owl#> "+
				"prefix owl: <http://www.w3.org/2002/07/owl#>  "+
				"select distinct * where {";
			String qStepTail = " sfc:hasNextStep ?ans}";
			String qTransTail = " sfc:hasNextTransition ?ans}";
			TupleQuery stepQuery = con.prepareTupleQuery(QueryLanguage.SPARQL,qHead+insertNode+qStepTail);
			System.out.println(qHead+insertNode+qStepTail);
			TupleQueryResult result = stepQuery.evaluate();
			Value stepAfterMerge = null;
			while (result.hasNext()) {
				BindingSet bindingSet = result.next();
				stepAfterMerge = bindingSet.getValue("ans");
				System.out.println("SFC: "+stepAfterMerge);
			}				
			int ix = stepAfterMerge.toString().indexOf('#');
			String afterMergeNode = "sfc:"+stepAfterMerge.toString().substring(ix+1);
			System.out.println(afterMergeNode);
			// First, remove the link where we want to insert a new
			// SFC snippet
			String updateSparql = pre +
				"delete { "+insertNode+" sfc:hasNextStep "+afterMergeNode+"}\n"+
				"where {}\n";
				// "where { "+insertNode+" sfc:hasNextStep ?ans}\n";
			System.out.println();
			System.out.println(updateSparql);
			Update update = con.prepareUpdate(QueryLanguage.SPARQL,updateSparql);
			update.execute();
			// OK, now connect to the start of the merge snippet
			updateSparql = pre +
				"insert { "+insertNode+" sfc:hasNextStep "+firstNode+"  }\n"+
				"where { }\n";
			System.out.println();
			System.out.println(updateSparql);
			update = con.prepareUpdate(QueryLanguage.SPARQL,updateSparql);
			update.execute();
			// Finally, connect the last transition in the snippet to
			// the next step of the original SFC
			updateSparql = pre +
				"insert { "+lastNode+" sfc:hasNextStep "+afterMergeNode+"  }\n"+
				"where { }\n";
			System.out.println();
			System.out.println(updateSparql);
			update = con.prepareUpdate(QueryLanguage.SPARQL,updateSparql);
			update.execute();
		}
		catch (Exception e) {
			// handle exception
			e.printStackTrace(System.out);
		}		
		// catch (IOException e) {
		// 	// handle exception
		// 	e.printStackTrace(System.out);
		// }		
	}

	private static String readFileAsString(String filePath) throws java.io.IOException{
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} finally {
			if (f != null) try { f.close(); } catch (IOException ignored) { }
		}
		return new String(buffer);
	}

}
*/