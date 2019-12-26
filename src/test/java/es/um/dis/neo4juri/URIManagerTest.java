package es.um.dis.neo4juri;

import static org.junit.Assert.*;

import org.junit.Test;

public class URIManagerTest {
	URIManager uriManager = new URIManager();
	private static final String[] URIS = { "http://purl.obolibrary.org/obo/GO_0003904",
			"http://purl.obolibrary.org/obo/SO_0002045", "http://purl.obolibrary.org/obo/PR_Q8LLD0",
			"http://semanticscience.org/resource/SIO_000745", "http://id.agrisemantics.org/gacs/C17166",
			"http://lod.nal.usda.gov/nalt/305893", "http://www.yso.fi/onto/afo/p341",
			"http://www.cropontology.org/rdf/CO_340:0000583", "http://biohackathon.org/resource/faldo#Region",
			"http://opendata.inra.fr/resources/Durum_Wheat#region", "https://w3id.org/saref#Light",
			"http://opendata.inra.fr/anaeeThes/c2_2587", "http://aims.fao.org/aos/agrovoc/c_7196",
			"http://purl.obolibrary.org/obo/GO_",
			"http://opendata.inra.fr/resources/hSC9z#chitosan_aqueous_acid_solvent_",
			"http://www.cropontology.org/rdf/CO_357:3000049/5", "http://taxref.mnhn.fr/lod/taxon/210069/10.0",
			"http://opendata.inra.fr/PO2_DG/product/root_exudates" };
	private static final String[] NAMES = { "0003904", "0002045", "Q8LLD0", "000745", "C17166", "305893", "p341",
			"0000583", "Region", "region", "Light", "c2_2587", "c_7196", "", "chitosan_aqueous_acid_solvent_",
			"3000049/5", "210069/10.0", "product/root_exudates" };
	private static final String[] NAMESPACES = { "http://purl.obolibrary.org/obo/GO",
			"http://purl.obolibrary.org/obo/SO", "http://purl.obolibrary.org/obo/PR",
			"http://semanticscience.org/resource/SIO", "http://id.agrisemantics.org/gacs",
			"http://lod.nal.usda.gov/nalt", "http://www.yso.fi/onto/afo", "http://www.cropontology.org/rdf/CO_340",
			"http://biohackathon.org/resource/faldo", "http://opendata.inra.fr/resources/Durum_Wheat",
			"https://w3id.org/saref", "http://opendata.inra.fr/anaeeThes", "http://aims.fao.org/aos/agrovoc",
			"http://purl.obolibrary.org/obo/GO", "http://opendata.inra.fr/resources/hSC9z",
			"http://www.cropontology.org/rdf/CO_357", "http://taxref.mnhn.fr/lod/taxon",
			"http://opendata.inra.fr/PO2_DG" };

	@Test
	public void testGetNamespace() {
		String[] results = new String[URIS.length];
		for (int i = 0; i < URIS.length; i++) {
			results[i] = uriManager.getNamespace(URIS[i]);
		}
		assertArrayEquals(NAMESPACES, results);
	}

	@Test
	public void testGetName() {
		String[] results = new String[URIS.length];
		for (int i = 0; i < URIS.length; i++) {
			results[i] = uriManager.getName(URIS[i]);
		}
		assertArrayEquals(NAMES, results);
	}

}
