/*
 * ## Exercise 10: Implementing the MVC Pattern
 * Scenario:
 * You are developing a simple web application for managing student records using the MVC pattern.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named MVCPatternExample.
 * Define Model Class:
 * Create a class Student with attributes like name, id, and grade.
 * Define View Class:
 * Create a class StudentView with a method displayStudentDetails().
 * Define Controller Class:
 * Create a class StudentController that handles the communication between the model and the view.
 * Test the MVC Implementation:
 * Create a main class to demonstrate creating a Student, updating its details using StudentController,
 * and displaying them using StudentView.
 */
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Student Details: ");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}
class StudentController {
    private Student model;
    private StudentView view;
    
    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public int getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
public class Main {
    public static void main(String[] args) {
        // TODO: Implement Implementing the MVC Pattern
        Student model = new Student("John Doe", 1, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Jane Doe");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        controller.updateView();
    }
}
