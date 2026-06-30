/*
 * ## Exercise 6: Implementing the Proxy Pattern
 * Scenario:
 * You are developing an image viewer application that loads images from a remote server. Use the Proxy
 * Pattern to add lazy initialization and caching.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named ProxyPatternExample.
 * Define Subject Interface:
 * Create an interface Image with a method display().
 * Implement Real Subject Class:
 * Create a class RealImage that implements Image and loads an image from a remote server.
 * Implement Proxy Class:
 * Create a class ProxyImage that implements Image and holds a reference to RealImage.
 * Implement lazy initialization and caching in ProxyImage.
 * Test the Proxy Implementation:
 * Create a test class to demonstrate the use of ProxyImage to load and display images.
 */
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
        Thread.sleep(2000); 
        System.out.println("Image " + filename + " loaded from disk.");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        // TODO: Implement Implementing the Proxy Pattern
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display(); 
        image1.display();      
        image2.display(); 
        image2.display(); 
    }
}
