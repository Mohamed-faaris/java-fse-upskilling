## Hands on 6
Spring Core – Load list of countries from Spring Configuration XML Our main objective was to retrieve the list of four countries for the airlines website. Refer steps below to get this incorporated.
Create a separate bean for each of the four country in country.xml.
Create an ArrayList of Country in country.xml. Refer code below.
<bean id="countryList" class="java.util.ArrayList">
<constructor-arg>
<list>
<ref bean="in"></ref>
<ref bean="us"></ref>
<ref bean="de"></ref>
<ref bean="jp"></ref>
</list>
</constructor-arg>
</bean>
Include new method displayCountries() in SpringLearnApplication.java
In displayCountries() read the country list created above
Display the list of countries as debug log.
SME to provide detailing on below aspects:
<list>
<ref>
bean attribute
IMPORTANT NOTE: Do not forget to include the start and end logs in this new method.