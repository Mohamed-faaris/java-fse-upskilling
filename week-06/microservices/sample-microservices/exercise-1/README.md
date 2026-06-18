## Exercise 1: Implementing Centralized Authentication with OAuth 2.1/OIDC
## Task: Implement centralized authentication using OAuth 2.1/OIDC in a Spring Boot
application.
Step-by-Step Explanation:
1. Add dependencies for Spring Security and OAuth2 Client in your `pom.xml`.
2. Configure OAuth2 client properties in `application.yml`.
3. Create a security configuration class to set up OAuth2 login.
4. Implement a controller to handle login and display user information.
Solution Code:
**pom.xml**
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
**application.yml**
spring:
security:
oauth2:
client:
registration:
my-client:
client-id: YOUR_CLIENT_ID
client-secret: YOUR_CLIENT_SECRET
scope: openid, profile, email
authorization-grant-type: authorization_code
redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
provider:
my-provider:
authorization-uri: https://accounts.google.com/o/oauth2/auth
token-uri: https://oauth2.googleapis.com/token

user-info-uri: https://openidconnect.googleapis.com/v1/userinfo
user-name-attribute: sub
**SecurityConfig.java**
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
protected void configure(HttpSecurity http) throws Exception {
http
.authorizeRequests()
.anyRequest().authenticated()
.and()
.oauth2Login();
}
}
**UserController.java**
@RestController
public class UserController {
@GetMapping("/user")
public Principal user(Principal principal) {
return principal;
}
}