# 📌 Java Spring Boot IoC & Dependency Injection Examples

This project provides comprehensive examples of Spring Framework's core concepts including IoC (Inversion of Control), Dependency Injection, Loose/Tight Coupling, and various injection methods with detailed practical implementations.

## ⚙️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── car/
│   │   │   └── example/
│   │   │       ├── bean/
│   │   │       │   ├── App.java
│   │   │       │   └── MyBean.java
│   │   │       ├── constructor/
│   │   │       │   └── injection/
│   │   │       │       ├── App.java
│   │   │       │       ├── Car.java
│   │   │       │       └── Specification.java
│   │   │       └── setter/
│   │   │           └── injection/
│   │   │               ├── App.java
│   │   │               ├── Car.java
│   │   │               └── Specification.java
│   │   └── com/
│   │       └── example/
│   │           ├── autowire/
│   │           │   ├── annotation/
│   │           │   │   ├── App.java
│   │           │   │   ├── AppConfig.java
│   │           │   │   ├── Employee.java
│   │           │   │   └── Manager.java
│   │           │   ├── constructor/
│   │           │   │   ├── App.java
│   │           │   │   ├── Car.java
│   │           │   │   └── Specification.java
│   │           │   ├── name/
│   │           │   │   ├── App.java
│   │           │   │   ├── Car.java
│   │           │   │   └── Specification.java
│   │           │   └── type/
│   │           │       ├── App.java
│   │           │       ├── Car.java
│   │           │       └── Specification.java
│   │           ├── componentscan/
│   │           │   └── annotation/
│   │           │       ├── App.java
│   │           │       ├── AppConfig.java
│   │           │       └── Employee.java
│   │           └── coupling/
│   │               ├── ioc/
│   │               │   ├── IoCExample.java
│   │               │   ├── NewDatabaseProvider.java
│   │               │   ├── UserDatabaseProvider.java
│   │               │   ├── UserDataProvider.java
│   │               │   ├── UserManager.java
│   │               │   └── WebServiceDataProvider.java
│   │               ├── loose/
│   │               │   ├── LooseCouplingExample.java
│   │               │   ├── NewDatabaseProvider.java
│   │               │   ├── UserDatabaseProvider.java
│   │               │   ├── UserDataProvider.java
│   │               │   ├── UserManager.java
│   │               │   └── WebServiceDataProvider.java
│   │               └── tight/
│   │                   ├── TightCouplingExample.java
│   │                   ├── UserDatabase.java
│   │                   └── UserManager.java
│
├── resources/
│   ├── application.properties
│   ├── applicationBeanContext.xml
│   ├── applicationConstructorInjection.xml
│   ├── applicationIoCouplingExample.xml
│   ├── applicationSetterInjection.xml
│   ├── autowireByConstructor.xml
│   ├── autowireByName.xml
│   ├── autowireByType.xml
│   └── componentScanDemo.xml
│
├── test/

```

## 🔑 1. IoC (Inversion of Control) Overview

**Traditional Approach**: Classes create their own dependencies internally.

**IoC Approach**: Dependencies are provided externally by the Spring Container.

### Benefits:
- ✅ Loose Coupling
- ✅ Easy testability
- ✅ Easy maintenance
- ✅ Flexibility

## 🧩 2. Bean Definitions

**Bean**: Objects managed by the Spring Container.

**Scope**: Singleton (default) or Prototype.

The `MyBean` class serves as a basic example where lifecycle management is handled by Spring.

## 🏗️ 3. Constructor Injection

Dependencies are provided through the constructor.

- Ideal for creating immutable objects
- Mandatory dependencies are checked at compile-time
- **Example**: The `Car` class receives its `Specification` dependency via constructor

```java
public class Car {
    private final Specification specification;
    
    public Car(Specification specification) {
        this.specification = specification;
    }
}
```

## ⚙️ 4. Setter Injection

Dependencies are provided through setter methods.

- Suitable for optional dependencies
- Dependencies can be changed at runtime
- **Use Case**: Optional dependencies, runtime configuration changes

```java
public class Car {
    private Specification specification;
    
    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
}
```

## 🔒 5. Tight Coupling

Classes are tightly bound to each other.

- Changes and testing are difficult
- Example found in `tight.couple` package

```java
public class UserManager {
    private UserDatabase userDatabase = new UserDatabase(); // Tight coupling
}
```

## 🔑 6. Loose Coupling

Loose coupling is achieved through interface usage.

- Different implementations can be easily integrated
- Testing becomes easier
- **Example**: `UserDataProvider` interface allows different data providers (`UserDatabaseProvider`, `WebServiceDataProvider`, `NewDatabaseProvider`)

```java
public class UserManager {
    private UserDataProvider userDataProvider; // Loose coupling via interface
}
```

## 🗂️ 7. IoC Container with Coupling

The `IoCExample` package demonstrates Spring Container's:

- Bean creation
- Dependency injection
- Lifecycle management
- Scope control

## 🧪 8. Autowiring (Automatic Wiring)

Spring XML configurations allow beans to be automatically wired. There are 3 main approaches:

### 🔹 Autowiring by Name
Matches by bean ID.
```xml
<bean id="specification" class="car.example.Specification"/>
<bean id="car" class="car.example.Car" autowire="byName"/>
```

### 🔹 Autowiring by Type
Matches by bean type.
```xml
<bean class="car.example.Specification"/>
<bean class="car.example.Car" autowire="byType"/>
```

### 🔹 Autowiring by Constructor
Matches based on constructor parameters.
```xml
<bean class="car.example.Specification"/>
<bean class="car.example.Car" autowire="constructor"/>
```

## 🏷️ 9. Introduction to Annotations

Spring can be configured using Java annotations instead of XML configuration. The following annotations are frequently used:

### ✅ Understanding Components & ComponentScan

`@Component` registers a class as a bean in the Spring Container.

```java
@Component
public class MyBean {}
```

`@ComponentScan` specifies which packages to scan for beans:

```java
@Configuration
@ComponentScan(basePackages = "car.example.annotation")
public class AppConfig {}
```

### ✅ Hands on: Component & Component Scan

Practical implementation of component scanning:

```java
@Component("mySpecialBean")
public class Specification {
    // Bean implementation
}

@Configuration
@ComponentScan(basePackages = {"car.example.bean", "car.example.constructor"})
public class AppConfig {
    // Configuration class
}
```

### ✅ @Autowired Annotation

Spring automatically injects the required dependency.

```java
@Component
public class Car {
    @Autowired
    private Specification specification;
}
```

### ✅ @Qualifier Annotation

When multiple beans exist, specifies which one to use.

```java
@Autowired
@Qualifier("newDatabaseProvider")
private UserDataProvider provider;
```

### ✅ @Value Annotation

Retrieves values from application.properties file.

```java
@Value("${car.brand}")
private String brand;
```

## 🔁 10. Transition from XML to Annotations in Spring

Spring Framework configuration is gradually moving towards annotation-based structures.

| Classic XML | Annotation Equivalent |
|-------------|----------------------|
| `<bean>` | `@Component` / `@Service` / `@Repository` |
| `<context:component-scan>` | `@ComponentScan` |
| `property name="" ref=""` | `@Autowired` / `@Qualifier` |
| `value="..."` | `@Value` |

### Advantages:
- Cleaner and more readable structure
- IDE support prevents compile-time errors
- Configuration can be controlled directly in Java

## ⚙️ 11. XML Configuration Files

| File | Content |
|------|---------|
| `applicationBeanContext.xml` | Basic bean definitions, scope, property injection |
| `applicationConstructorInjection.xml` | Constructor injection configuration |
| `applicationSetterInjection.xml` | Setter method injection |
| `applicationIoCouplingExample.xml` | IoC coupling example configuration |
| `autowireByName.xml` | Autowiring by name configuration |
| `autowireByType.xml` | Autowiring by type configuration |
| `autowireByConstructor.xml` | Autowiring by constructor configuration |
| `componentScanDemo.xml` | Component scan demonstration |

## ✅ 12. Core Concepts Learned

- **IoC Container**: BeanFactory, ApplicationContext, bean lifecycle
- **DI Types**: Constructor Injection, Setter Injection
- **Coupling Types**: Tight Coupling vs Loose Coupling
- **Autowiring**: byName, byType, constructor
- **Annotations**: @Component, @Autowired, @Qualifier, @Value

## 🚀 13. Running Instructions

### Maven Dependencies
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.21</version>
  </dependency>
</dependencies>
```

### Executable Classes

| Scenario | Class |
|----------|-------|
| Bean example | `car.example.bean.App` |
| Constructor Injection | `car.example.constructor.injection.App` |
| Setter Injection | `car.example.setter.injection.App` |
| Tight Coupling | `car.example.tight.couple.TightCouplingExample` |
| Loose Coupling | `car.example.loose.coupling.LooseCouplingExample` |
| Autowiring by Name | `car.example.autowire.byname.App` |
| Autowiring by Type | `car.example.autowire.bytype.App` |
| Autowiring by Constructor | `car.example.autowire.constructor.App` |
| Component Scan Demo | `car.example.annotation.App` |

## 🎯 14. Real-World Applications

- **Service Layer Design**
- **Repository Pattern**
- **Strategy Pattern**
- **Factory Pattern**
- **Clean Architecture Principles**

## 🧪 15. Best Practices

1. **Prefer Constructor Injection** for mandatory dependencies
2. **Use Setter Injection** for optional dependencies
3. **Implement interfaces** for loose coupling
4. **Use @Qualifier** when multiple beans of same type exist
5. **Leverage @Value** for external configuration
6. **Organize components** with proper package structure

## 📝 16. Common Pitfalls

- **Circular Dependencies**: Avoid circular references between beans
- **Bean Scope Issues**: Understand singleton vs prototype scopes
- **Missing @ComponentScan**: Ensure proper package scanning
- **Ambiguous Bean Resolution**: Use @Qualifier for disambiguation

## 🔧 17. Troubleshooting

- **NoSuchBeanDefinitionException**: Check component scanning or bean definitions
- **BeanCreationException**: Verify constructor parameters and dependencies
- **Circular dependency detected**: Restructure dependencies or use @Lazy

## 📚 18. Further Learning

- Spring Boot Auto-Configuration
- Spring Data JPA
- Spring Security
- Spring MVC
- Microservices with Spring Cloud

---

**Note**: This project serves as a comprehensive learning resource for understanding Spring Framework's dependency injection and IoC concepts through practical examples.
