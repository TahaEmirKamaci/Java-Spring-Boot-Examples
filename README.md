# Java-Spring-Boot-Examples
Spring Framework - IoC ve Dependency Injection Proje Rehberi
Proje Hakkında
Bu proje Spring Framework'ün temel kavramlarını uygulamalı olarak öğrenmek için hazırlanmıştır. IoC (Inversion of Control) yapısı, Bean tanımları, Loose/Tight Coupling kavramları ve farklı Dependency Injection yöntemleri gerçek kod örnekleri ile ele alınmıştır.
Proje Yapısı
src/
├── main/
│   ├── java/
│   │   └── car/
│   │       └── example/
│   │           ├── bean/
│   │           │   ├── App.java
│   │           │   └── MyBean.java
│   │           ├── constructor/
│   │           │   └── injection/
│   │           │       ├── App.java
│   │           │       ├── Car.java
│   │           │       └── Specification.java
│   │           ├── setter/
│   │           │   └── injection/
│   │           │       ├── App.java
│   │           │       ├── Car.java
│   │           │       └── Specification.java
│   │           └── com/
│   │               └── ioc/
│   │                   └── coupling/
│   │                       ├── IoCExample.java
│   │                       ├── NewDatabaseProvider.java
│   │                       ├── UserDatabaseProvider.java
│   │                       ├── UserDataProvider.java
│   │                       ├── UserManager.java
│   │                       └── WebServiceDataProvider.java
│   │                   └── loose/
│   │                       └── coupling/
│   │                           ├── LooseCouplingExample.java
│   │                           ├── NewDatabaseProvider.java
│   │                           ├── UserDatabaseProvider.java
│   │                           ├── UserDataProvider.java
│   │                           ├── UserManager.java
│   │                           └── WebServiceDataProvider.java
│   │                   └── tight/
│   │                       └── couple/
│   │                           ├── TightCouplingExample.java
│   │                           ├── UserDatabase.java
│   │                           └── UserManager.java
│   └── resources/
│       ├── application.properties
│       ├── applicationBeanContext.xml
│       ├── applicationConstructorInjection.xml
│       ├── applicationIoCouplingExample.xml
│       └── applicationSetterInjection.xml
1. IoC (Inversion of Control) Nedir?
Geleneksel Yaklaşım vs IoC
Geleneksel Yaklaşım: Sınıflar kendi bağımlılıklarını kendileri yaratır.
IoC Yaklaşımı: Bağımlılıklar dışarıdan (Spring Container) tarafından sağlanır.
IoC'nin Avantajları:

Loose Coupling: Sınıflar arası gevşek bağlantı
Testability: Kolay test edilebilirlik
Maintainability: Bakım kolaylığı
Flexibility: Esneklik

2. Bean Tanımları
MyBean Sınıfı
Bean'ler Spring Container tarafından yönetilen nesnelerdir. Bu projede MyBean sınıfı temel bir bean örneğidir.
Özellikler:

Spring Container tarafından yaratılır
Lifecycle yönetimi Spring tarafından yapılır
Dependency Injection destekler
Singleton veya Prototype scope'a sahip olabilir

Bean Scope'ları

Singleton: Tek instance (varsayılan)
Prototype: Her istek için yeni instance

3. Constructor Injection
Özellikler:

Bağımlılıklar constructor parametreleri ile sağlanır
Immutable nesneler oluşturulabilir
Zorunlu bağımlılıklar için ideal
Compile-time'da bağımlılık eksiklikleri tespit edilir

Car ve Specification Sınıfları
Car sınıfı, Specification nesnesini constructor injection ile alır. Bu sayede:

Car nesnesi yaratılırken tüm bağımlılıkları hazır olur
Specification olmadan Car nesnesi yaratılamaz
Test sırasında mock objeler kolayca inject edilebilir

4. Setter Injection
Özellikler:

Bağımlılıklar setter methodları ile sağlanır
Optional bağımlılıklar için uygun
Runtime'da bağımlılıklar değiştirilebilir
Partial injection mümkün

Kullanım Senaryoları:

İsteğe bağlı bağımlılıklar
Circular dependency durumları
Runtime'da configuration değişiklikleri

5. Tight Coupling (Sıkı Bağlantı)
Sorunlar:

Sınıflar birbirine sıkıca bağlı
Test etmek zor
Değişiklik yapmak maliyetli
Esneklik yok

TightCouplingExample Paketi:
UserManager sınıfı doğrudan UserDatabase sınıfına bağımlı. Bu durum:

UserManager'ı test etmeyi zorlaştırır
Farklı veri kaynağı kullanmak için kod değişikliği gerektirir
Maintenance maliyetini artırır

6. Loose Coupling (Gevşek Bağlantı)
Avantajlar:

Interface'lere bağımlılık
Kolay test edilebilirlik
Farklı implementasyonlar kullanılabilir
Maintenance kolaylığı

LooseCouplingExample Paketi:
UserDataProvider interface'i sayesinde:

UserDatabaseProvider
WebServiceDataProvider
NewDatabaseProvider

farklı implementasyonlar kolayca kullanılabilir.
7. IoC Container ile Coupling
IoCExample Paketi:
Spring Container'ın bağımlılıkları nasıl yönettiğini gösterir. Container:

Bean'leri yaratır
Bağımlılıkları inject eder
Lifecycle'ı yönetir
Scope'ları kontrol eder

8. XML Configuration Dosyaları
applicationBeanContext.xml

Temel bean tanımları
Scope ayarları
Property injection

applicationConstructorInjection.xml

Constructor-arg tanımları
Nesne referansları
Primitive değer injection

applicationSetterInjection.xml

Property tanımları
Setter method injection
Nesne referansları

applicationIoCouplingExample.xml

IoC container konfigürasyonu
Coupling örnekleri için bean tanımları

9. Öğrenilen Temel Kavramlar
IoC Container

Bean factory
Application context
Bean lifecycle
Dependency resolution

Dependency Injection Types

Constructor Injection

Avantajlar: Immutable, compile-time check
Dezavantajlar: Circular dependency problemi


Setter Injection

Avantajlar: Optional dependencies, flexibility
Dezavantajlar: Mutable, runtime errors


Field Injection

Kullanılmadı (önerilmez)
Avantajlar: Kod kısalığı
Dezavantajlar: Test zorluğu, reflection kullanımı



Coupling Types

Tight Coupling

Sınıflar arası sıkı bağlantı
Maintenance zorluğu
Test zorluğu


Loose Coupling

Interface kullanımı
Esneklik
Test kolaylığı



10. Çalıştırma Talimatları
Maven Dependencies
xml<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.21</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>5.3.21</version>
    </dependency>
</dependencies>
Çalıştırma Adımları:

Bean örneği: car.example.bean.App
Constructor Injection: car.example.constructor.injection.App
Setter Injection: car.example.setter.injection.App
Tight Coupling: com.ioc.coupling.tight.couple.TightCouplingExample
Loose Coupling: com.ioc.coupling.loose.coupling.LooseCouplingExample
IoC Container: com.ioc.coupling.IoCExample

11. Öğrenme Çıktıları
Pratik Kazanımlar:

Spring Framework temel kavramları
IoC Container kullanımı
XML configuration
Dependency Injection pattern'leri
Coupling türleri ve farkları
Bean lifecycle yönetimi
Interface-based programming

Gerçek Dünya Uygulamaları:

Service layer design
Repository pattern
Strategy pattern
Factory pattern
Clean architecture principles

Bu proje Spring Framework'ün temel taşlarını oluşturan IoC ve Dependency Injection kavramlarını pratikte nasıl kullanacağınızı gösterir. Her örnek, real-world senaryolarda karşılaşacağınız durumları simüle eder ve Spring'in gücünü ortaya koyar.RetryClaude does not have the ability to run the code it generates yet.Claude can make mistakes. Please double-check responses.
