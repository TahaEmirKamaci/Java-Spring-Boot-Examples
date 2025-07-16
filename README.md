📌 Java Spring Boot IoC & Dependency Injection Örnekleri
Bu proje, Spring Framework'ün temel kavramlarını uygulamalı örneklerle öğretmek için hazırlanmıştır.
İçerikte IoC (Inversion of Control), Dependency Injection, Loose/Tight Coupling ve farklı injection yöntemleri detaylıca ele alınmıştır.

⚙️ Proje Yapısı
```
src/
├── main/
│   ├── java/
│   │   └── car/example/
│   │       ├── bean/
│   │       │   ├── App.java
│   │       │   └── MyBean.java
│   │       ├── constructor/injection/
│   │       │   ├── App.java
│   │       │   ├── Car.java
│   │       │   └── Specification.java
│   │       ├── setter/injection/
│   │       │   ├── App.java
│   │       │   ├── Car.java
│   │       │   └── Specification.java
│   │       └── com/ioc/
│   │           ├── coupling/
│   │           │   ├── IoCExample.java
│   │           │   ├── NewDatabaseProvider.java
│   │           │   ├── UserDatabaseProvider.java
│   │           │   ├── UserDataProvider.java
│   │           │   ├── UserManager.java
│   │           │   └── WebServiceDataProvider.java
│   │           ├── loose/coupling/
│   │           │   ├── LooseCouplingExample.java
│   │           │   ├── NewDatabaseProvider.java
│   │           │   ├── UserDatabaseProvider.java
│   │           │   ├── UserDataProvider.java
│   │           │   ├── UserManager.java
│   │           │   └── WebServiceDataProvider.java
│   │           └── tight/couple/
│   │               ├── TightCouplingExample.java
│   │               ├── UserDatabase.java
│   │               └── UserManager.java
│   └── resources/
│       ├── application.properties
│       ├── applicationBeanContext.xml
│       ├── applicationConstructorInjection.xml
│       ├── applicationIoCouplingExample.xml
│       └── applicationSetterInjection.xml
```


🔑 1. IoC (Inversion of Control) Nedir?
Geleneksel Yaklaşım: Sınıflar kendi bağımlılıklarını kendi oluşturur.

IoC Yaklaşımı: Bağımlılıklar dışarıdan (Spring Container) sağlanır.

Avantajları:
✅ Loose Coupling
✅ Kolay test edilebilirlik
✅ Kolay bakım
✅ Esneklik

🧩 2. Bean Tanımları
Bean: Spring Container tarafından yönetilen nesneler.

Scope: Singleton (varsayılan) veya Prototype.

MyBean sınıfı temel bir örnektir. Lifecycle yönetimi Spring’e aittir.

🏗️ 3. Constructor Injection
Bağımlılıklar constructor üzerinden sağlanır.

Immutable nesneler üretmek için idealdir.

Zorunlu bağımlılıklar compile-time’da kontrol edilir.

Örnek: Car sınıfı, Specification bağımlılığını constructor ile alır.

⚙️ 4. Setter Injection
Bağımlılıklar setter metodları ile sağlanır.

Opsiyonel bağımlılıklar için uygundur.

Runtime’da bağımlılık değiştirilebilir.

Kullanım Senaryosu: İsteğe bağlı bağımlılıklar, runtime config değişiklikleri.

🔒 5. Tight Coupling (Sıkı Bağlantı)
Sınıflar birbirine sıkıca bağlıdır.

Değişiklik ve test zordur.

TightCouplingExample paketinde örneği bulunur.

🔑 6. Loose Coupling (Gevşek Bağlantı)
Interface kullanımı ile gevşek bağlantı sağlanır.

Farklı implementasyonlar kolayca entegre edilir.

Test yazımı kolaylaşır.

Örnek: UserDataProvider arayüzü ile farklı veri sağlayıcıları (UserDatabaseProvider, WebServiceDataProvider, NewDatabaseProvider) kullanılabilir.

🗂️ 7. IoC Container ile Coupling
IoCExample paketi Spring Container’ın:

Bean oluşturma

Bağımlılık inject etme

Lifecycle yönetimi

Scope kontrolü

işlevlerini gösterir.

⚙️ 8. XML Configuration
Dosya	İçerik
applicationBeanContext.xml	Temel bean tanımları, scope, property injection
applicationConstructorInjection.xml	Constructor injection konfigürasyonu
applicationSetterInjection.xml	Setter method injection
applicationIoCouplingExample.xml	IoC coupling örnek konfigürasyonu

✅ 9. Öğrenilen Temel Kavramlar
IoC Container: BeanFactory, ApplicationContext, bean lifecycle

DI Türleri: Constructor Injection, Setter Injection

Coupling Türleri: Tight Coupling vs Loose Coupling

🚀 10. Çalıştırma Talimatları
Maven Bağımlılıkları
xml
Copy
Edit
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.21</version>
  </dependency>
</dependencies>
Çalıştırılabilir Sınıflar
Senaryo	Sınıf
Bean örneği	car.example.bean.App
Constructor Injection	car.example.constructor.injection.App
Setter Injection	car.example.setter.injection.App
Tight Coupling	com.ioc.coupling.tight.couple.TightCouplingExample
Loose Coupling	com.ioc.coupling.loose.coupling.LooseCouplingExample
IoC Container	com.ioc.coupling.IoCExample

🎯 11. Gerçek Dünya Uygulamaları
Service Layer Design

Repository Pattern

Strategy Pattern

Factory Pattern

Clean Architecture Principles

