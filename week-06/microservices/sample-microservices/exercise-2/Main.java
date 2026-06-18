/*
 * ## Exercise 2: Configuring Authorization Servers and Resource Servers
 * ## Task: Configure Authorization Servers and Resource Servers in a Spring Boot application.
 * Step-by-Step Explanation:
 * 1. Add dependencies for Spring Security and OAuth2 Resource Server in your `pom.xml`.
 * 2. Configure the Authorization Server properties in `application.yml`.
 * 3. Create a security configuration class for the Resource Server.
 * 4. Implement a controller to secure endpoints.
 * Solution Code:
 * **pom.xml**
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-security</artifactId>
 * </dependency>
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 *
 * <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
 * </dependency>
 * **application.yml**
 * spring:
 * security:
 * oauth2:
 * resourceserver:
 * jwt:
 * issuer-uri: https://issuer.example.com
 * **ResourceServerConfig.java**
 * @EnableWebSecurity
 * public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
 * @Override
 * protected void configure(HttpSecurity http) throws Exception {
 * http
 * .authorizeRequests()
 * .anyRequest().authenticated()
 * .and()
 * .oauth2ResourceServer()
 * .jwt();
 * }
 * }
 * **SecureController.java**
 * @RestController
 * public class SecureController {
 * @GetMapping("/secure")
 * public String secure() {
 * return "This is a secure endpoint";
 * }
 * }
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Implement Configuring Authorization Servers and Resource Servers
    }
}
