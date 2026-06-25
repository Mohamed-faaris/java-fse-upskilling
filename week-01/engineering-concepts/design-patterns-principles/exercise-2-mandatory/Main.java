/*
 * ## Exercise 2: Implementing the Factory Method Pattern
 * Scenario:
 * You are developing a document management system that needs to create different types of documents
 * (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named FactoryMethodPatternExample.
 * Define Document Classes:
 * Create interfaces or abstract classes for different document types such as WordDocument,
 * PdfDocument, and ExcelDocument.
 * Create Concrete Document Classes:
 * Implement concrete classes for each document type that implements or extends the above interfaces or
 * abstract classes.
 * Implement the Factory Method:
 * Create an abstract class DocumentFactory with a method createDocument().
 * Create concrete factory classes for each document type that extends DocumentFactory and implements
 * the createDocument() method.
 * Test the Factory Method Implementation:
 * Create a test class to demonstrate the creation of different document types using the factory
 * method.
 */

interface Document {
    void open();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class Main {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();
        pdf.open();
        excel.open();
    }
}

// ❯ javac Main.java && java Main
// Opening Word Document
// Opening PDF Document
// Opening Excel Document
