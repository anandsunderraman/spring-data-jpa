# Spring Data JPA Sample

This project was setup to be a playground to experiment with:
1. spring-data-jpa
2. Hibernate

## Project Scenario
1. There are 3 tables `user`, `user_department` and `user_address` (Not the ideal way to organize data)
2. Use the `database.sql` to create the tables and insert the related data
3. There is a one to one mapping between  `user` and `user_department`. 
   The `user_id` column on  `user_department` references the `id` column on the `user` table.
4. There is a one to one mapping between  `user` and `user_address`. 
   The `user_id` column on  `user_address` references the `id` column on the `user` table.

## What was accomplished

1. How to set establish `@OneToOne` relationship mapping between objects with lazy loading
2. How to use multiple `NamedEntityGraphs`

## Concepts to be understood

1. Owning side of a relationship in hibernate
   This stackoverflow question: https://stackoverflow.com/questions/2749689/what-is-the-owning-side-in-an-orm-mapping
   helps understand these concepts
   This link in the comment: https://www.javacodegeeks.com/2013/04/jpa-determining-the-owning-side-of-a-relationship.html
   gives a very good explanation
   
2. Lazy loading
   In the example (not an ideal example) in this project.
   We have a `User` class (represents `user` table ) that has a 1-1 mapping with `UserDepartment` class (represent `user_department`)
   When querying for `User` alone, `UserDepartment` entities should not be fetched unless specified.
   To achieve this `fetch = FetchType.LAZY` and `optional=false` need to be specified in the `@OneToOne` annotation that is not on the owning side of the relationship
   By default spring-boot's `ObjectMapper` does not support lazy loading and looks for the related `UserDepartment` object and results in an exception being thrown
   The exception goes like: `could not initialize proxy - no Session (through reference chain:`
   To circumvent this we need to use an `ObjectMapper` that supports lazy loading
   That is where we need to use: https://github.com/FasterXML/jackson-datatype-hibernate
   This helps circumventing this issue.
   
   Include the dependency as:
   
   ```xml
    <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-hibernate5</artifactId>
        <version>2.9.0</version>
    </dependency>
   ```
   
   Inject the `Hibernate5Module` as:
   
   ```java
    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }
   ```
   
   Although the `Hibernate5Module` does not look for the related entities it returns them as `null`.
   
   To get around this `User` class need to be annotated with `@JsonInclude(JsonInclude.Include.NON_EMPTY)`
   
      

 