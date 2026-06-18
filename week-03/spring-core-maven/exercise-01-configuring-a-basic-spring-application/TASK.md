# Exercise 1: Configuring a Basic Spring Application

**Source:** Spring Core and Maven/Spring Core_Maven.docx

## Goal
Set up a Spring Framework project for library management with XML configuration.

## Steps
1. Create a Maven project named `LibraryManagement`
2. Add Spring Core dependencies in the `pom.xml` file
3. Create an XML configuration file `applicationContext.xml` in `src/main/resources`
4. Define beans for `BookService` and `BookRepository` in the XML file
5. Create `com.library.service` package with `BookService` class
6. Create `com.library.repository` package with `BookRepository` class
7. Create a main class to load Spring context and test the configuration