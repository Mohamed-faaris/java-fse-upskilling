/*
 * ## Hands on 5
 * Spring Core – Demonstration of Singleton Scope and Prototype Scope The Country bean done in the
 * previous hands on will be used to demonstrate the scopes in Spring. Implement the steps below.Follow
 * steps below to demonstrate Singleton Scope
 * Include a line in displayCountry() to get country bean reference one more time from the same
 * application context. Only the third line of the below code snippet should be copied and pasted.
 * ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
 * Country country = context.getBean("country", Country.class);
 * Country anotherCountry = context.getBean("country", Country.class);
 * The constructor will be called only once, which means that only one instance of Country bean is
 * created
 * Follow steps below to demonstrate Prototype Scope
 * Include scope="prototype" attribute in bean definition xml.
 * <bean id="country" class="com.cognizant.springlearn.Country" scope="prototype">
 *
 * Run the application
 * Constructor will be called twice, which means that two instances of country is created.
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Implement Exercise 5
    }
}
