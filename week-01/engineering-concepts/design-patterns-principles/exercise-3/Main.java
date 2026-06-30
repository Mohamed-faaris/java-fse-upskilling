/*
 * ## Exercise 3: Implementing the Builder Pattern
 * Scenario:
 * You are developing a system to create complex objects such as a Computer with multiple optional
 * parts. Use the Builder Pattern to manage the construction process.
 * ## Steps:
 * Create a New Java Project:
 * Create a new Java project named BuilderPatternExample.
 * Define a Product Class:
 * Create a class Computer with attributes like CPU, RAM, Storage, etc.
 * Implement the Builder Class:
 * Create a static nested Builder class inside Computer with methods to set each attribute.
 * Provide a build() method in the Builder class that returns an instance of Computer.
 * Implement the Builder Pattern:
 * Ensure that the Computer class has a private constructor that takes the Builder as a parameter.
 * Test the Builder Implementation:
 * Create a test class to demonstrate the creation of different configurations of Computer using the
 * Builder pattern.
 */
class Computer {
    private String Name;
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    
    private Computer(Builder builder) {
        this.Name = builder.Name;
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }

    public static class Builder {
        private String Name;
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;

        Builder(String Name) {
            this.Name = Name;
        }

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [Name=" + Name + ", CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GPU=" + GPU + "]";
    }
}

    

public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Gaming PC")
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .build();
        Computer.Builder officePCBuilder = new Computer.Builder("Office PC")
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD");
        Computer officePC = officePCBuilder.build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}

//  /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /home/faaris/.config/Code/User/workspaceStorage/0d8c552657f13c3f5424512bac630ea5/redhat.java/jdt_ws/jdt.ls-java-project/bin Main
// Computer [Name=Gaming PC, CPU=Intel i9, RAM=32GB, Storage=1TB SSD, GPU=NVIDIA RTX 3080]
// Computer [Name=Office PC, CPU=Intel i5, RAM=16GB, Storage=512GB SSD, GPU=null]