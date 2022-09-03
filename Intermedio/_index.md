# Itinerario formativo - nivel intermedio <!-- omit in toc -->

- [Conceptos](#conceptos)
  - [Patrones de diseño para automatizar pruebas](#patrones-de-dise%C3%B1o-para-automatizar-pruebas)
    - [Page Object Model](#page-object-model)
    - [Page Factory](#page-factory)
    - [Screenplay](#screenplay)
  - [Arquitectura de microservicios](#arquitectura-de-microservicios)
  - [Mocks](#mocks)
    - [Tipos de Mocks](#tipos-de-mocks)
      - [Dummy](#dummy)
      - [Stub](#stub)
      - [Spy](#spy)
      - [Mock](#mock)
      - [Fake](#fake)
  - [Gestión de datos de pruebas](#gesti%C3%B3n-de-datos-de-pruebas)
  - [Pruebas móviles](#pruebas-m%C3%B3viles)
  - [Pruebas de rendimiento](#pruebas-de-rendimiento)
- [Herramientas](#herramientas)
  - [Frameworks para hacer mocking](#frameworks-para-hacer-mocking)
  - [Herramientas para pruebas de backend](#herramientas-para-pruebas-de-backend)
    - [RestAssured](#restassured)
    - [KarateDSL](#karatedsl)
  - [Herramientas para pruebas web (e2e)](#herramientas-para-pruebas-web-%28e2e%29)
    - [Selenium](#selenium)
    - [Cypress](#cypress)
    - [TestCafé](#testcaf%C3%A9)
    - [Playwright](#playwright)
    - [Protractor (Deprecada)](#protractor-%28deprecada%29)
  - [Herramientas para pruebas de móviles](#herramientas-para-pruebas-de-m%C3%B3viles)
    - [Appium](#appium)
    - [Espresso](#espresso)
    - [XCUITest](#xcuitest)
  - [Herramientas para pruebas de carga](#herramientas-para-pruebas-de-carga)
    - [JMeter](#jmeter)
    - [Gatling](#gatling)
    - [LoadRunner](#loadrunner)
    - [NeoLoad](#neoload)
    - [Taurus](#taurus)
    - [K6](#k6)
  - [Otras herramientas](#otras-herramientas)
    - [Cucumber](#cucumber)
    - [Gauge](#gauge)
    - [SonarQube](#sonarqube)
    - [BrowserStack](#browserstack)
- [Ejercicios](#ejercicios)
  - [Pruebas End-2-End de Front](#pruebas-end-2-end-de-front)
  - [Pruebas API REST con Postman](#pruebas-api-rest-con-postman)
  - [Pruebas API REST con RestAssured](#pruebas-api-rest-con-restassured)
  - [Pruebas API REST con framework Javascript](#pruebas-api-rest-con-framework-javascript)
  - [Pruebas de rendimiento con JMeter sobre API REST](#pruebas-de-rendimiento-con-jmeter-sobre-api-rest)
  - [Pruebas de rendimiento con JMeter sobre aplicación web](#pruebas-de-rendimiento-con-jmeter-sobre-aplicaci%C3%B3n-web)
  - [Pruebas sobre aplicación móvil usando Appium](#pruebas-sobre-aplicaci%C3%B3n-m%C3%B3vil-usando-appium)
  - [Ejercicio práctico base de datos MongoDB](#ejercicio-pr%C3%A1ctico-base-de-datos-mongodb)
  - [Ejercicio práctico base de datos MySQL](#ejercicio-pr%C3%A1ctico-base-de-datos-mysql)
  - [Análisis código estático con SonarQube](#an%C3%A1lisis-c%C3%B3digo-est%C3%A1tico-con-sonarqube)
- [Recursos de aprendizaje](#recursos-de-aprendizaje)
  - [Test automation strategy](#test-automation-strategy)
  - [Unit Testing](#unit-testing)
  - [API Testing](#api-testing)
  - [UI Testing](#ui-testing)
  - [Mobile Testing](#mobile-testing)
  - [DevOps](#devops)
  - [Enlaces de interés](#enlaces-de-inter%C3%A9s)
- [Artículos del Blog de Sngular](#art%C3%ADculos-del-blog-de-sngular)

---

## Conceptos

### Patrones de diseño para automatizar pruebas

#### Page Object Model

Este patrón nos permite realizar la representación de páginas webs en clases del lenguaje de programación usado. Los métodos bien nombrados en las clases nos facilitan su lectura e implementar rutinas que son más fáciles de mantener ya que reutilizamos código de las clases page objects en los tests.

Usando este patrón estamos creando una capa de abstracción entre el *"¿Qué podemos hacer/ver en la página?"* y el *"¿Cómo se realiza esta acción?"*. Si se produce algún cambio a nivel de UI únicamente afectará al PageObject y no a los tests ya implementados.

Un test no tiene que manipular directamente elementos de la página, ese manejo se debe realizar a través del PageObject que representa dicha página. En definitiva, podemos entender el PageObject como una API con la que podemos encontrar y manipular los datos de la página.

#### Page Factory

Es una extensión del patrón Page Object Model. Utilizaremos el patrón Page Factory para inicializar los elementos web con lo que vamos a interactuar en las clases de página web o clases page object.

Nos permite escribir código más mantenible y evitar repetir código. En lugar de tener que repetir esta línea cada vez que sea necesario:

```java
WebElement searchInput = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
```

Podemos crear un atributo de clase que será reutilizado en otros puntos del código:

```java
@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
private WebElement searchInput;
```

En definitiva, éstos dos patrones están muy relacionados y se pueden utilizar conjuntamente. Puedes ir a los siguientes links para tener más información:

[Patrones de diseño en automatización: Page Object](https://qanewsblog.com/2014/08/07/patrones-de-diseno-en-automatizacion-page-objects/)
  
[Page Object Model (POM) & Page Factory in Selenium Tutorial](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)

#### Screenplay

A diferencia de los anteriores, este patrón usa algunos de los buenos principios en desarrollo software como es el caso de SOLID. Este patrón se basa en el Principio de Responsabilidad Única (SRP) y el Principio de Abierto-Cerrado (OCP), es decir, la S y la O de SOLID, entendiendo que cada letra hace referencia a un principio distinto.

[+ info](https://serenity-js.org/handbook/design/screenplay-pattern.html)

[Screenplay Tutorial](http://serenity-bdd.info/docs/articles/screenplay-tutorial.html)

### Arquitectura de microservicios

Es la evolución de la arquitectura monolítica o monolito donde el software se estructura de forma que todos los aspectos funcionales del mismo queden acoplados y sujetos en un mismo programa.

La arquitectura de microservicios viene para solucionar los problemas inherentes a los sistemas monolíticos.

1. Servicios pequeños e independientes (principio de responsabilidad única).
2. Unidades de despliegue pequeñas. Nos permite desplegar con más frecuencia. Con monolito es necesario tener el 'si' de un mayor número de personas.
3. Agilidad en hot fixes (consecuencia de la anterior).
4. Multitecnología.
5. Conexión con otros microservicios.

[+ info](https://medium.com/@goodrebels/microservicios-ventajas-y-contras-de-la-arquitectura-descentralizada-a3b7fc814422)

### Mocks

¿Qué es un mock?

Es un objeto que imita el comportamiento de un objeto real de una forma controlada. Se usan generalmente en las pruebas unitarias que esperan mensajes de una clase particular para sus métodos.

¿Para qué sirven los Mocks?

Un mock deberá implementar el mismo interfaz del objeto que queremos simular. En la clase que define la prueba deberemos definir qué métodos del objeto real queremos que simule el mock, indicando para cada uno de ellos cual es la respuesta esperada cuando reciba unos parámetros predeterminados. Esa respuesta debe ser la misma que esperamos que devuelva el objeto real cuando esté disponible.

Al ejecutar la prueba, cuando el código que queremos probar llame a un objeto que todavía no esté disponible y que hemos simulado con el mock, esa llamada será "interceptada" por el objeto **“mock”** que hayamos definido y este devolverá la respuesta que hayamos definido y que se deberá corresponder con la que esperamos que sea devuelta por el objeto real cuando esté construido.

La utilización de mocks nos permite independizar el desarrollo de unas partes de la solución de otras. Podemos desarrollar una parte y verificar que funciona correctamente con independencia del resto de partes con las que tenga relación. De esta manera el responsable de cada parte de código puede centrarse en probar que el código que está desarrollando funcione correctamente con independencia del estado de otras partes de la aplicación con las que tenga relación.

[+ info](https://uniwebsidad.com/libros/tdd/capitulo-6/cuando-usar-un-objeto-real-un-stub-o-un-mock?from=librosweb)

#### Tipos de Mocks

##### Dummy

Son objetos que se envían, pero nunca se utilizan en el test.
Por ejemplo, imaginemos que tenemos un objeto de la clase GestorDeTareas, que gestiona objetos Tarea, que necesita una lista de parámetros Tarea para funcionar. Si en el test solo queremos comprobar que uno de sus métodos me devuelva el número de Tareas que contiene ese gestor de tareas, podemos utilizar dummies para rellenar el gestor de tareas. Muchas veces los dummies se rellenan con valores NULL.

##### Stub

Es un objeto en el que configuras que cuando llames a un método devuelva un valor determinado. Por ejemplo, si tienes un objeto con un método que suma dos números, un stub sería un objeto que independientemente de los valores que le pases al método suma, devuelva 5.

##### Spy

Estos objetos guardan las acciones que se hacen sobre ellos. Hace una especie de seguimiento sobre qué métodos se han llamado y con qué parámetros.
Cuando para que un test sea un éxito no es suficiente ver el estado de los objetos disponibles, podemos usar un spy y comprobar cosas como cuántas veces se ha llamado a un método, qué valores han devuelto, etc.

##### Mock

Muy similar a un spy, pero no solo guardan las acciones que se hacen sobre ellos, también es necesario configurar qué comportamiento esperas cuando alguien llame a alguno de sus métodos.

##### Fake

Es un objeto implementado completamente y que funciona, como un objeto normal sin ser simulado, pero se diferencia en que está falseando algo para hacer alguna cosa más fácil de probar. Un ejemplo de esto podría ser un objeto que utiliza una base de datos en memoria en lugar de acceder a consultar la base de datos de producción.

[+ info](https://www.javiergarzas.com/2015/09/dummies-vs-stubs-vs-mocks-vs-spies-vs-fakes.html)

### Gestión de datos de pruebas

En algunos casos, nos encontraremos que la base de datos de nuestro entorno de pruebas no tiene datos, incluso, podría darse el caso, que no existan las tablas.

Como condición para poder lanzar nuestras baterías de pruebas, tendremos que tener un paso previo para poblar de datos nuestro entorno.

### Pruebas móviles

En los últimos años han cobrado mucha importancia las aplicaciones móviles y el testing de apps se ha convertido en otra tarea necesaria en la calidad del software.

Disponemos de muchas herramientas, como podría ser la pionera *Appium* o *Detox*, entre otras, que nos permiten lanzar las pruebas en un dispositivo real o bien en dispositivos virtuales que nos permiten probar en diferentes modelos con diferentes versiones del sistema operativo del teléfono.

### Pruebas de rendimiento

Las pruebas de rendimiento son aquellas pruebas que someten a un sistema a una carga de trabajo con el fin de medir su velocidad, fiabilidad y estabilidad en esas condiciones de trabajo. Los tipos más importantes son: carga, estres y estabilidad.

[+ info](https://openwebinars.net/blog/que-es-prueba-de-rendimiento-software/)

---

## Herramientas

### Frameworks para hacer mocking

Nos permiten simular comportamientos dentro de nuestras pruebas unitarias. Vamos a destacar algunos:

- [Java - Mockito](https://www.arquitecturajava.com/java-mockito-y-los-mock-objects/)
- [Javascript - Jest](https://medium.com/canariasjs/jest-manual-mocking-con-m%C3%B3dulos-propios-fuera-del-archivo-de-testing-9bdc3767088d)
- [Python - Pytest](https://medium.com/@bfortuner/python-unit-testing-with-pytest-and-mock-197499c4623c)

### Herramientas para pruebas de backend

#### RestAssured

Framework para testear y validar servicios rest en java. Al igual que Postman o SoapUI, RestAssured es una herramienta para el testing de servicios REST. En este caso es necesario, tener conocimientos en Java, ya que se trata de una librería que nos proporciona lo necesario para hacer peticiones.

[Web oficial](http://rest-assured.io/)

[+ info](https://www.genbeta.com/desarrollo/rest-assured-framework-para-testear-y-validar-nuestros-servicios-rest)  

#### KarateDSL

En el caso de KarateDSL, es una herramienta de código abierto que nos permite escribir tests donde se realizan peticiones HTTP y se comprueban que la respuesta es la esperada. En su core tiene todo lo necesario y no tenemos que crear nuevos steps, además se apoya en Cucumber para escribir nuestras pruebas en un lenguaje pseudo técnico donde podemos aplicar un enfoque de desarrollo guiado por comportamiento (BDD).

[Web oficial](https://github.com/intuit/karate)

### Herramientas para pruebas web (e2e)

#### Selenium

Selenium es posiblemente la herramienta más extendida en la automatización de pruebas. En su versión WebDriver, el sucesor del original Selenium RC, acepta comandos y los envía a un navegador. Es usado para automatizar pruebas e2e sobre aplicaciones web, simulando las acciones que un usuario hace en la aplicación.

[Web oficial](https://selenium.dev/)  

#### Cypress

Cypress es una herramienta de testing construida para la web moderna y que no usa Selenium para controlar el navegador. Nos permite escribir todo tipo de tests: e2e, de integración, unitarios, etc. Esta herramienta está diseñada especialmente para manejar frameworks de JavaScript modernos, *React, Angular, Vue, Elm, etc.* Pero, también funciona igual de bien en páginas o aplicaciones renderizadas en servidor.

[Web oficial](https://www.cypress.io)

#### TestCafé

TestCafé es una herramienta de node.js para probar aplicaciones web. No necesita complementos para el navegador y funciona en todos los navegadores modernos.

[Web oficial](https://testcafe.io/)

#### Playwright

Playwright es una biblioteca de node.js para automatizar pruebas e2e en los principales navegadores del mercado. También permite realizar pruebas en los navegadores de dispositivos móviles. Soporta varios lenguajes de programación (TypeScript, JavaScript, Python, .NET y JAVA)

[Web oficial](https://playwright.dev/)

#### Protractor (Deprecada)

Protractor utiliza WebDriver para controlar el navegador y está escrita en NodeJS. Se utiliza el lenguaje JavaScript para escribir los test. Se trata de un framework para pruebas e2e sobre aplicaciones escritas en AngularJS, aunque no está limitado solo a este framework en particular.

[Web oficial](https://www.protractortest.org/#/)

### Herramientas para pruebas de móviles

#### Appium

Appium es un framework open source que nos permite automatizar pruebas de aplicaciones móviles. Pueden ser aplicaciones nativas, web mobile o aplicaciones híbridas. Implementa Selenium WebDriver.

[Web oficial](http://appium.io/)  

#### Espresso

Espresso por su parte fue desarrollada por Google. Permite instalar el fichero APK en los dispositivos donde se van a realizar las pruebas y tener acceso al código. Ofrece un modo síncrono de ejecución, aumentando la estabilidad de los tests mediante un mecanismo que comprueba antes de pasar al siguiente paso que el elemento con el que se va a interactuar está en la pantalla. Con respecto a Appium, las ejecuciones de los tests son mucho más rápidas. Se ejecutan directamente en la aplicación instalada en el dispositivo sin necesidad de un servidor de comunicación como funciona Appium. Además de todo eso, Espresso nos permite usar mocks e inyección de depedencias.

[Web oficial](https://developer.android.com/training/testing/espresso)

[Hoja de referencia de Espresso](https://developer.android.com/training/testing/espresso/cheat-sheet)  

[Espresso android tutorial](https://www.youtube.com/watch?v=KZeU3tOKHp0)  

#### XCUITest

El soporte principal de Appium para automatizar aplicaciones iOS es a través del driver XCUITest. Se utiliza para realizar pruebas de interfaz de usuario para apps IOS.

[+ info](http://appium.io/docs/en/drivers/ios-xcuitest/)  

[Tutorial XCUITest](https://www.adictosaltrabajo.com/2019/02/28/empezando-con-xcode-ui-testing/)  

### Herramientas para pruebas de carga

#### JMeter

Es una herramienta de código abierto para analizar y medir una variedad de servicios, con énfasis en aplicaciones web. Además, se puede usar para realizar pruebas unitarias para conexiones de base de datos JDBC, FTO, LDAP, servicios web, JMS, HTTP y conexiones TCP genéricas. Recomendable para perfiles menos técnicos.

[Web oficial](http://jmeter.apache.org/)

#### Gatling

Es un marco de prueba de carga y rendimiento de código abierto. Su uso es para analizar y medir una variedad de servicios web. Recomendable para perfiles más técnicos.

[Web oficial](https://gatling.io/)

[Gatling vs Jmeter](https://flood.io/blog/when-should-i-use-gatling-vs-jmeter-a-tale-of-two-tools/)

#### LoadRunner

Se utiliza para probar aplicaciones, medir el comportamiento del sistema y el rendimiento bajo carga. Es una herramienta multiprotocolo, multilenguaje y no openSource.

[Web oficial](https://www.microfocus.com/es-es/products/loadrunner-professional/overview)

#### NeoLoad

Es una de las plataformas de prueba de rendimiento más innovadoras. Está desarrollada para automatizar el diseño, el mantenimiento y el análisis de pruebas para cumplir con los nuevos requisitos de las pruebas de carga Agile y DevOps. NeoLoad se integra con pipelines de CD, para soportar pruebas continuas de rendimiento de pruebas de componentes, pruebas de API, pruebas de preproducción y pruebas de carga de todo el sistema.

[Web oficial](https://www.neotys.com/)

[NeoLoad Demos](https://www.youtube.com/watch?v=x-pH5S9r9-o&list=PLdITSV_zl58pQo7rztV2j5Ccs7kEA1GPE)

#### Taurus

Herramienta gratuita y de código abierto. Taurus amplía las capacidades de los populares marcos de pruebas funcionales y de rendimiento como JMeter, Gatling o Selenium. También es fácil de usar para la configuración, ejecución y análisis de resultados de pruebas.

[Web oficial](https://gettaurus.org/)

[+ info](https://www.blazemeter.com/blog/taurus-new-star-test-automation-tools-constellation/)

#### K6

Grafana K6 es una herramienta de pruebas de carga de código libre que facilita el testeo del rendimiento de las aplicaciones. Con esta herramienta se puede probar la fiabilidad y rendimiento de aplicaciones e identificar regresiones y errores más tempranamente.

[Web oficial](https://k6.io/docs/es/)

### Otras herramientas

#### Cucumber

Cucumber es una herramienta que nos permite escribir los tests usando el lenguaje natural, de forma que todas las personas del proyecto, ya sean técnicas o no, puedan entenderlos. Se utiliza en un modelo de desarrollo de software con metodología BDD (Desarrollo guiado por comportamiento) con ayuda del patrón Given-When-Then.

[Web oficial](https://cucumber.io/docs/cucumber/)

#### Gauge

Gauge es una herramienta ligera de automatización de pruebas multiplataforma. Utiliza Markdown para crear casos de prueba y escenarios. Su arquitectura modular lo hace flexible y escalable.

[Web oficial](https://docs.gauge.org/index.html)

#### SonarQube

SonarQube es una herramienta que nos permite realizar un análisis estático de código fuente con el fin de obtener métricas que ayuden a mejorar la calidad del código.

Algunos de los puntos que podemos detectar son: código duplicado, código que no se utiliza o la complejidad ciclomática que no es más que el cálculo del número de caminos independientes que tiene nuestro código.

[Definición de métricas en Sonarqube](/files/intermedio/KPIs-calidad.pdf)

[+ info sobre definición de métricas](https://sonarqubehispano.org/pages/viewpage.action?pageId=4980840)  

[Más conceptos sobre terminos de SonarQube](https://www.paradigmadigital.com/dev/evalua-la-calidad-de-tu-codigo-con-sonarqube/)

#### BrowserStack

BrowserStack es una plataforma de pruebas multinavegador que permite integrar herramientas para realizar pruebas automáticas, visuales y en vivo en aplicaciones móviles y webs.

Los usuarios pueden escoger entre infinidad de dispositivos móviles, navegadores, sistemas operativos y confiar en una infraestructura segura, fiable y escalable para soportar miles de tests manuales y automáticos de forma concurrente reduciendo el tiempo, el coste y el mantenimiento asociado al proceso de pruebas.

[Web oficial](https://www.browserstack.com/)

---

## Ejercicios

Debes subir las respuestas de los ejercicios a tu cuenta personal de GitLab.

### Pruebas End-2-End de Front

> :bookmark: **Nota**
>
> Usa la versión AngularJS de la aplicación [ToDo](http://todomvc.com/) para la realización del ejercicio
>

*Pasos a seguir:*

1. Añadir tres elementos
2. Cambiar el texto en uno de ellos
3. Cambiar a la vista 'Active' y comprobar número de elementos
4. Marca uno de ellos como Completed
5. Cambiar a la vista 'Completed' y comprobar que el texto del elemento es el esperado

Automatizar esas pruebas usando:

- Selenium + Cucumber
- Cypress
- Protractor
- Selenium con JavaScript usando [WebdriverIO](https://webdriver.io/)

### Pruebas API REST con Postman

> :bookmark: **Nota**
>
> Usa el API REST [JSON Server](/code/json_server) para la realización del ejercicio
>

*Pasos a seguir:*

- Crear en Postman una colección que cree un nuevo post, recupere sus datos, los actualice, los borre y compruebe que fue borrado.
  - Introducir pruebas automáticas que comprueben: códigos de respuesta, tiempos de respuesta y que el contenido de los datos es el adecuado.
- [Instalar Newman](https://learning.getpostman.com/docs/postman/collection-runs/command-line-integration-with-newman/)
- Describir los pasos necesarios para ejecutar la colección creada en Postman desde línea de comando.

### Pruebas API REST con RestAssured

Realizar una batería de pruebas sobre una API REST usando RestAssured y Cucumber

> :bookmark: **Nota**
>
> Usa el API REST [JSON Server](/code/json_server) para la realización del ejercicio
>

*Pasos a seguir:*

- Crear un proyecto Maven en Java, e incluir las dependencias necesarias de rest assured y cucumber.
- Hacer uso de TestNG para las anotaciones y la ejecución de las pruebas.
- Introducir los asertos necesarios en cada caso para comprobar códigos de respuesta, cabeceras correctas y que el contenido de los datos es el adecuado.

### Pruebas API REST con framework Javascript

Realizar una batería de pruebas sobre una API REST usando algún framework JavaScript o NodeJS como puede ser [Axios](https://github.com/axios/axios)

*Pasos a seguir:*

- Crear un proyecto usando la librería elegida, y al igual que en el ejercicio anterior, realizar las mimas peticiones a los distintos endpoints para la gestión de posts.
- Documentar los pasos necesarios para ejecutar el código con las pruebas.

### Pruebas de rendimiento con JMeter sobre API REST

> :bookmark: **Nota**
>
> Usa el API REST [JSON Server](/code/json_server) para la realización del ejercicio
>

*Pasos a seguir:*

- Crear una prueba de rendimiento sobre el endpoint <http://localhost:3000/users/1> que simule 100 peticiones durante 10 segundos.
- Crear informes para ver los resultados de las pruebas.
- Probar con otra cantidad de usuarios simultáneos y comparar los resultados.
- Adjuntar el fichero de pruebas generado por JMeter.

### Pruebas de rendimiento con JMeter sobre aplicación web

> :bookmark: **Nota**
>
> Tomar de ejemplo la web de [AirBnb](https://www.airbnb.es/) para la realización del ejercicio
>

*Pasos a seguir:*

- Realizar una grabación que busque alojamiento en Madrid, Sevilla, Barcelona y Valencia con distintos valores para el campo Adultos y Niños en diferentes fechas del año actual. Utilizar función random de JMeter.
- Lanzar la prueba simulando que hay 20 usuarios simultáneos realizando esa misma búsqueda.
- Probar con otra cantidad de usuarios simultáneos (>20) y comparar los resultados.
- Adjuntar el script generado y explicar los pasos realizados para generar el test y ejecutarlo.

### Pruebas sobre aplicación móvil usando Appium

> :bookmark: **Nota**
>
> Descargar la aplicación [login](https://github.com/KimMatt/APPIUM_INTRO/tree/master/app) de prueba para la realización del ejercicio
>

*Pasos previos:*

- [Instalar Appium](https://github.com/appium/appium/blob/master/docs/en/about-appium/getting-started.md)
- Instalar Java JDK y Android SDK. Configurar las correspondientes variables de entorno.

*Pasos a seguir:*

- [Aquí](https://code.tutsplus.com/tutorials/an-introduction-to-appium--cms-23861) puedes encontrar una guía usando Python. También se puede encontrar los credenciales para hacer login.
- Automatizar dos pruebas
  1. Hacer el login correctamente
  2. No se realiza el login y se comprueba el mensaje de error obtenido.
- Repetir las pruebas utilizando JAVA.

### Ejercicio práctico base de datos MongoDB

> :bookmark: **Nota**
>
> Levantar un contenedor con MongoDB usando docker-compose como se explica [aquí](/code/MongoDB/)
>

Realizar unas consultas para obtener los siguientes datos:

- Recuperar todos los registros donde el campo `gender` es igual a **Female**
- Recuperar todos los registros donde el campo `country` es igual a **China**
- Recuperar todos los registros donde el campo `gender` es **Male** y el campo `country` es **France**
- Obtener el número de personas de cada país
- Añadir un nuevo usuario
- Modificar el usuario creado en el paso anterior
- Borrar el usuario creado

Realizar las queries usando la consola desde dentro del contenedor y crear un documento con las consultas ejecutadas.

### Ejercicio práctico base de datos MySQL

> :bookmark: **Nota**
>
> Levantar un contenedor con MySQL usando docker-compose como se explica [aquí](/code/MySQL)
>

Realizar unas consultas para obtener los siguientes datos:

- Obtener los datos de los `actores` que aparecen en la película **ACADEMY DINOSAUR**
- Obtener los datos de las `películas` en las que participa el **actor con id = 1**
- Obtener las `ciudades` de **Argentina**
- Obtener el **número de ciudades** que tiene cada `país`
- Añadir un nueva película en la tabla `film`. *Nota: hay que hacer insert en más de una tabla*
- Añadir dos actores/actrices a la película insertada. *Nota: hay que hacer insert en más de una tabla*
- Cambia el `last_name` del actor con **id igual a 3**

Realizar las queries usando la consola desde dentro del contenedor y crear un documento con las consultas ejecutadas.

### Análisis código estático con SonarQube

*Pasos previos:*

- Instalar SonarQube usando contenedores. Puedes usar las siguientes [instrucciones](https://medium.com/linagora-engineering/using-sonarqube-to-analyze-a-java-project-abeee15e3779)

*Pasos a seguir:*

- En el link anterior puedes encontrar un proyecto de ejemplo. Puedes usar otro proyecto si lo ves conveniente.
- Realizar un análisis estático de código.
- Justificar que métricas has usado y los resultados obtenidos.

---

## Recursos de aprendizaje

### Test automation strategy

[Setting a foundation for a successful test automation](https://testautomationu.applitools.com/setting-a-foundation-for-successful-test-automation/) - Consideraciones a tener en cuenta a la hora de definir la estrategia de automatización de pruebas.

[Cucumber with Java](https://testautomationu.applitools.com/cucumber-java-tutorial/index.html) - Aprender conceptos de Cucumber y cómo llevárlos a la práctica en proyectos Java.

### Unit Testing

[Fundamentos de unit testing](https://testautomationu.applitools.com/unit-testing/) - Fundamentos de unit testing.

[Testing spring boot beginner to guru](https://sngular.udemy.com/course/testing-spring-boot-beginner-to-guru/) - Aprender conceptos de TDD y automatizar pruebas en proyectos Spring Boot integrando JUnit con Mockito

[MSTest unit testing tutorial for beginners](https://sngular.udemy.com/course/mstest-unit-testing-tutorial-for-beginners/) - Entender los conceptos de mstest unit test.

### API Testing

[Postman The complete guide](https://sngular.udemy.com/course/postman-the-complete-guide/) - Como usar Postman para crear pruebas sobre API REST y ejecutarlas a través de Newman para integrarlas en una herramienta de integración continua.

[API automation testing with RestAssured](https://sngular.udemy.com/course/rest-api-automation-testing-rest-assured/) - Como escribir tests de API REST usando la librería Rest Assured.

[Webservices testing with SoapUI](https://sngular.udemy.com/course/webservices-testing-with-soap-ui/) - Webservices and Rest API testing con SoapUI. Construcción de un framework end2end usando Java como lenguaje de programación.

[Automate API tests with RestAssured](https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/) - Aprende a utilizar la librería Rest Assured. Como parametrizar y crear tests, verificar códigos y payload de respuesta y cabeceras. Serializar y deserializar jsons de respuesta.

### UI Testing

[Selenium WebDriver tutorial JAVA](https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/) - Aprende a instalar Selenium y todas sus dependencias dentro de un proyecto Java. Como interactuar con los distintos elementos que nos podemos encontrar en una aplicación web. Escribir código usando el patrón de diseño Page Object Model.

[Cypress tutorial](https://testautomationu.applitools.com/cypress-tutorial/) - Escribe tests end2end usando esta herramienta basada en Javascript.

[Web element locator strategies](https://testautomationu.applitools.com/web-element-locator-strategies/) - Como interactuar con botones, etiquetas, dropdowns y demás elementos de una web usando diferentes técnicas como xpath o id.

[Testing Angular apps](https://sngular.udemy.com/course/testing-angular-apps/learn/lecture/7052082#overview) - Como testar aplicaciones Angular usando la librería Jasmine.

[AngularJS Protractor tutorial](https://sngular.udemy.com/course/angularjs-protractor-tutorial/) - Aprende a escribir pruebas end2end sobre aplicaciones AngularJS usando Protractor. También puede ser usado para aplicaciones que no están implementadas con AngularJS. También aprenderás como localizar elementos y a usar promesas en tus tests.

### Mobile Testing

[Introduction to iOS Test Automation with XCUITest](https://testautomationu.applitools.com/introduction-to-ios-test-automation-with-xcuitest/index.html) - Aprende a escribir tu primer test con XCUITest aplicando BDD.

[Android Test Automation with Espresso](https://testautomationu.applitools.com/espresso-mobile-testing-tutorial/index.html) - Aprende como testar aplicaciones móviles con Espresso

[Appium Mobile Testing (Android/IOS) from Scratch+Frameworkds](https://sngular.udemy.com/course/mobile-automation-using-appiumselenium-3) - Aprende desde cero a configurar y programar pruebas para aplicaciones móviles con Appium

### DevOps

[Scaling tests with Docker](https://testautomationu.applitools.com/scaling-tests-with-docker/) - Conoce Docker y como nos puede ayudar a solucionar problemas. Instala Docker y crea un contenedor con Selenium grid y diferentes navegadores para lanzar tus tests.

### Enlaces de interés

- [Tips para una buena revisión de código](https://www.youtube.com/watch?v=L3LkZ57gwgI&feature=youtu.be)
- [Que estoy probando y cuales son mis dependencias en testing](https://www.javiergarzas.com/2015/09/que-estoy-probando-y-cuales-son-mis-dependencias-en-testing.html)
- [Code review todo lo que debes saber](https://slashmobility.com/blog/2017/01/code-review-todo-lo-que-debes-saber/)
- [Ejemplo de prueba con Rest Assured](https://www.adictosaltrabajo.com/2017/05/11/prueba-tus-api-rest-con-rest-assured/)
- [Comparativa Karate vs Rest Assured](https://gorillalogic.com/blog/karate-vs-rest-assured-comparing-powerful-api-testing-frameworks/)
- [Explicacion extendida sobre appium](https://www.clubdetecnologia.net/blog/2017/que-es-appium-automatizacion-de-aplicaciones-nativas-web-e-hibridas/)
- [Comparativa de Gatling vs Jmeter](https://dzone.com/articles/gatling-vs-jmeter)
- [Sonar y el concepto de Deuda Técnica](https://www.paradigmadigital.com/dev/evalua-la-calidad-de-tu-codigo-con-sonarqube/)
- [Kit Selenium + Cucumber + Docker](https://www.youtube.com/watch?v=htL2jD-cwwA)

---

## Artículos del Blog de Sngular

- [Automatización de pruebas con Karate (I)](https://www.sngular.com/es/automatizacion-de-pruebas-con-karate-i/)
- [Automatización de pruebas con Karate (II)](https://www.sngular.com/es/automatizacion-de-pruebas-con-karate-ii/)
- [Pruebas de APIs utilizando Approval Testing](https://www.sngular.com/es/pruebas-apis-utilizando-approval-testing/)
- [Optimización de pruebas en Cypress](https://www.sngular.com/es/optimizacion-de-pruebas-en-cypress/)
- [Automatización de pruebas con Visual Testing](https://www.sngular.com/es/automatizacion-de-pruebas-con-visual-testing/)
- [Entrevista a Francisco Moreno sobre Docker, Cucumber y Selenium](https://www.sngular.com/es/entrevista-docker-cucumber-selenium/)
