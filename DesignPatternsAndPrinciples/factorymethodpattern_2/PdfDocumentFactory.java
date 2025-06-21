package factorymethodpattern_2;

public class PdfDocumentFactory extends DocumentFactory {
    
    public Document createDocument() {
        return new PdfDocument();
    }
}
