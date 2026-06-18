## Exercise 2: Implementing the Factory Method Pattern
Scenario:
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
## Steps:
Create a New Java Project:
Create a new Java project named FactoryMethodPatternExample.
Define Document Classes:
Create interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.
Create Concrete Document Classes:
Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.
Implement the Factory Method:
Create an abstract class DocumentFactory with a method createDocument().
Create concrete factory classes for each document type that extends DocumentFactory and implements the createDocument() method.
Test the Factory Method Implementation:
Create a test class to demonstrate the creation of different document types using the factory method.