package es.um.dis.neo4juri;

import org.neo4j.procedure.Description;
import org.neo4j.procedure.Name;
import org.neo4j.procedure.UserFunction;

public class URIManager {
	private static final String ANAEE_THES_NAMESPACE = "http://opendata.inra.fr/anaeeThes";
	private static final String AGROVOC_NAMESPACE = "http://aims.fao.org/aos/agrovoc";
	private static final String PO2_DG_NAMESPACE = "http://opendata.inra.fr/PO2_DG";
	private static final String TAXONLD_NAMESPACE = "http://taxref.mnhn.fr/lod/taxon";
	private static final String [] SPECIAL_CASE_PREFIX = {ANAEE_THES_NAMESPACE, AGROVOC_NAMESPACE, PO2_DG_NAMESPACE, TAXONLD_NAMESPACE};
	private static final String[] URI_SEPARATORS = { "#", "/", "_", ":" };

	@UserFunction(name="URIManager.getNamespace")
	@Description("Receives an URI as parameter and return its namespace. For example <http://purl.obolibrary.org/obo/GO_0003904> would return http://purl.obolibrary.org/obo/GO")
	public String getNamespace(@Name("uri")String uri) {
		return splitURI(uri)[0];
	}

	@UserFunction(name="URIManager.getName")
	@Description("Receives an URI as parameter and return its name. For example <http://purl.obolibrary.org/obo/GO_0003904> would return 0003904")
	public String getName(@Name("uri")String uri) {
		return splitURI(uri)[1];
	}

	private String[] splitURI(String uri) {
		String[] uriComponents = new String[2];
		int separatorPos = findSeparatorPos(uri);
		if (separatorPos == -1) {
			throw new RuntimeException(String.format("No separator character found in URI \"%s\"", uri));
		}
		uriComponents[0] = uri.substring(0, separatorPos);
		uriComponents[1] = uri.substring(separatorPos + 1, uri.length());
		return uriComponents;
	}

	private int findSeparatorPos(String uri) {
		for(String specialCasePrefix : SPECIAL_CASE_PREFIX){
			if(uri.contains(specialCasePrefix)){
				return specialCasePrefix.length();
			}
		}
		return findSeparatorPosGeneral(uri);
	}

	private int findSeparatorPosGeneral(String uri) {
		int separatorPosFound = -1;
		for (String separator : URI_SEPARATORS) {
			int separatorPos = uri.lastIndexOf(separator);
			// # and : characters have priority. Example: "http://opendata.inra.fr/resources/hSC9z#chitosan_aqueous_acid_solvent_" should take #
			if((separator.equals("#") || separator.equals(":")) && separatorPos != -1 && separatorPos != 4){
				return separatorPos;
			}
			if (separatorPos > separatorPosFound) {
				separatorPosFound = separatorPos;
			}
		}
		return separatorPosFound;
	}
}
