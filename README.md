# URIManager
Neo4j plugin for dealing with strings representing URIs.

## Usage:
This plugin provides functions to extract the namespace or the name of an URI (URIManager.getNamespace(string) and URIManager.getName(string)). For example, from the Gene Ontology URI <http://purl.obolibrary.org/obo/GO_0003904>, the name would be "0003904", and the namespace "http://purl.obolibrary.org/obo/GO".

## Examples
Namespace extraction:
```
WITH "http://purl.obolibrary.org/obo/GO_0003904" as uri
return URIManager.getNamespace(uri)
```

Name extraction:
```
WITH "http://purl.obolibrary.org/obo/GO_0003904" as uri
return URIManager.getName(uri)
```