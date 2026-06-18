## Exercise 2: Load Balancing in an API Gateway
**Task:** Implement load balancing in an API Gateway using Spring Boot 3 and Spring
Cloud.
**Step-by-Step Explanation:**
1. Create a new Spring Boot project with the necessary dependencies for Spring Cloud
Gateway and Spring Cloud LoadBalancer.
2. Configure the application properties for load balancing.
3. Implement a custom load balancing configuration.
4. Test the load balancing functionality.
**Solution Code:**
**pom.xml:**
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
**application.properties:**
spring.cloud.gateway.routes[0].id=load_balanced_route
spring.cloud.gateway.routes[0].uri=lb://example-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/loadbalanced/**
**Load Balancer Configuration:**
@Configuration
public class LoadBalancerConfiguration {
@Bean
public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment
environment, LoadBalancerClientFactory loadBalancerClientFactory) {
String name =
environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name,
ServiceInstanceListSupplier.class), name);
}
}