package example;

import org.eclipse.rdf4j.model.IRI;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.eclipse.rdf4j.repository.manager.RepositoryProvider;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandlerException;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
//import org.eclipse.rdf4j.sail.inferencer.fc.CustomGraphQueryInferencer;

public class Ex01 {

	
	public static void main(String[] args) {
		//String pre1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n",
		//	   pre2 = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n",
		//	   pre3 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n",
		//	   pre4 = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n",
		//	   pre5 = "PREFIX dfs: <http://dfsample.org/dreams#>\n";
		
		// String rule = pre1+pre2+pre3+pre4+pre5+"CONSTRUCT {?s a cnt:Average} WHERE {SELECT ?s (count(?p) AS ?numBrothers) WHERE {  ?s cnt:hasBrother ?p} GROUP BY ?s HAVING (?numBrothers>=3 && ?numBrothers<=4)}";
		// String match = "";//pre1+pre2+pre3+pre4+pre5 + "CONSTRUCT {?s a cnt:Person}";

		// You can get the connection to the existing repository on running rdf4j server
		// But at first you would need to start rdf4j server
		// 0. download and unzip apache-tomcat (apache-tomcat-X.X.X-windows-x64.zip) from https://tomcat.apache.org/
		// 1. download RDF4J SDK (eclipse-rdf4j-3.6.3-sdk.zip) from https://rdf4j.org/download/
		// 2. uznip it and copy two files included in it: rdf4j-server.war and rdf4j-workbench.war
		//    into apache-tomcat-X.X.X\webapps folder
		// 3. run startup.bat script from apache-tomcat-X.X.X\bin folder
		// 4. create repository "repo" with id "repo" using workbench
		// 
		// Please note, that RDF4J server by default will store all the repositories created in the user folder 
	    // C:\Users\...\AppData\Roaming\RDF4J\Server\repositories\
		// and the server will run on the following url				
		String rdf4jServer = "http://localhost:8080/rdf4j-server/";
		String repositoryID = "dfs";
		
		Repository rep1 = new HTTPRepository(rdf4jServer, repositoryID);
		
		// You can get the same connection in other way
		RepositoryManager repositoryManager  = RepositoryProvider.getRepositoryManager("http://localhost:8080/rdf4j-server/");
		Repository rep = repositoryManager.getRepository(repositoryID);
		
		//// But if you are interested in running your own in-memory repository, then it is enough to declare it
		//
		// Repository rep = new SailRepository(new MemoryStore());
		//
		//// or 
		//
		// Repository rep = new CustomGraphQueryInferencer(new MemoryStore(), QueryLanguage.SPARQL, rule, match));
		
		//// and initialize it
		//
		// rep.init();

		// Having repository initialised you can get connection to it
			
			RepositoryConnection conn = rep.getConnection();			
			
			try {		
			// You can upload triples from a file to the repository
			// File file = new File("family.ttl");
			// String baseURI = "http://example.org/ontologies/family#";
			// conn.add(file, baseURI, RDFFormat.TURTLE);

			// You can add new triples to the repository
			// but to create IRI you will need a factory with a proper namespace  
			String namespace = "http://dfsample.org/dreams#";
			ValueFactory f = rep.getValueFactory();
			// now it is possible to create IRI entity 
			//IRI john = f.createIRI(namespace, "john");
			// and add the triples
			//conn.add(john, RDF.TYPE, FOAF.PERSON);
			//conn.add(john, RDFS.LABEL, f.createLiteral("John", XMLSchema.STRING));

			// the query string should be filled in with proper prefixes, 
			// thus add them at the beginning			
			//String queryString = pre5+"SELECT ?x ?y ?z  WHERE { ?x ?y ?z . } ";
			String query1 = "PREFIX dfs: <http://dfsample.org/dreams#>\n" +
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
					"\n" +
					"SELECT ?dream ?label ?duration\n" +
					"WHERE {\n" +
					"  ?dream rdf:type dfs:ServiceDream ;\n" +
					"         dfs:usedBy dfs:alice ;\n" +
					"         rdfs:label ?label ;\n" +
					"         dfs:duration ?duration .\n" +
					"  FILTER (?duration >= 60)\n" +
					"}";

			String query2 = "PREFIX dfs: <http://dfsample.org/dreams#>\n" +
					"\n" +
					"SELECT ?vendor (COUNT(DISTINCT ?business) AS ?businessCount)\n" +
					"WHERE {\n" +
					"  ?business dfs:hasVendor ?vendor .\n" +
					"}\n" +
					"GROUP BY ?vendor\n" +
					"HAVING (COUNT(DISTINCT ?business) > 1)";

			String query3 = "PREFIX dfs: <http://dfsample.org/dreams#>\n" +
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
					"\n" +
					"SELECT ?dream ?label\n" +
					"WHERE {\n" +
					"  ?dream rdf:type dfs:GiftDream ;\n" +
					"         dfs:createdBy dfs:BusinessB ;\n" +
					"         dfs:usedBy dfs:damian ;\n" +
					"         rdfs:label ?label .\n" +
					"}";

			String query4 = "PREFIX dfs: <http://dfsample.org/dreams#>\n" +
					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
					"\n" +
					"SELECT ?dream ?label\n" +
					"WHERE {\n" +
					"  ?dream dfs:usedBy dfs:matthew , dfs:damian ;\n" +
					"         rdfs:label ?label .\n" +
					"}";

			String query5 = "PREFIX dfs: <http://dfsample.org/dreams#>\n" +
					"\n" +
					"SELECT ?business (COUNT(DISTINCT ?client) AS ?clientCount)\n" +
					"WHERE {\n" +
					"  ?dream dfs:createdBy ?business ;\n" +
					"         dfs:usedBy ?client .\n" +
					"  ?client rdf:type dfs:Client .\n" +
					"}\n" +
					"GROUP BY ?business";

			TupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, query5);
			// next, after evaluation, the result set is ready to be processed  
			try (TupleQueryResult result = tupleQuery.evaluate()) {
				while (result.hasNext()) {
					BindingSet bindingSet = result.next();
					for (String name : bindingSet.getBindingNames()) {
						System.out.print(name + ": " + bindingSet.getValue(name) + " | ");
					}
					System.out.println();
				}
			}
            // If you with to have some logging
			//Logger logger = LoggerFactory.getLogger(Ex01.class);
			//logger.info("Hello World");

		} catch (RDFParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
			finally {
			conn.close();
		}
	}
}