package factorymethodpattern_2;

public class ExcelDocumentFactory extends DocumentFactory {
   
    public Document createDocument() {
        return new ExcelDocument();
    }
}
