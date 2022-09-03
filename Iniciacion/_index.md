# Itinerario formativo - nivel iniciación <!-- omit in toc -->

- [Conceptos](#conceptos)
  - [Pruebas de software](#pruebas-de-software)
  - [Pruebas de Caja Blanca](#pruebas-de-caja-blanca)
    - [Técnicas de pruebas de caja blanca](#t%C3%A9cnicas-de-pruebas-de-caja-blanca)
  - [Pruebas de caja Negra](#pruebas-de-caja-negra)
    - [Técnicas de pruebas de caja negra](#t%C3%A9cnicas-de-pruebas-de-caja-negra)
  - [Cobertura de Código](#cobertura-de-c%C3%B3digo)
  - [Ciclo de vida de software y Agile Testing](#ciclo-de-vida-de-software-y-agile-testing)
    - [Definición Agile Testing](#definici%C3%B3n-agile-testing)
    - [Principios del Context Driven Testing](#principios-del-context-driven-testing)
    - [Shift Left Testing](#shift-left-testing)
  - [Evaluación heurística](#evaluaci%C3%B3n-heur%C3%ADstica)
  - [Redacción de planes de pruebas](#redacci%C3%B3n-de-planes-de-pruebas)
  - [Testing exploratorio](#testing-exploratorio)
  - [Unit Testing](#unit-testing)
  - [API Testing](#api-testing)
  - [E2E Testing](#e2e-testing)
  - [Pruebas de regresión](#pruebas-de-regresi%C3%B3n)
  - [BDD](#bdd)
  - [Pirámide de testing ó Pirámide de Cohn](#pir%C3%A1mide-de-testing-%C3%B3-pir%C3%A1mide-de-cohn)
  - [Tipos de incidencias](#tipos-de-incidencias)
  - [Control y seguimiento de bugs](#control-y-seguimiento-de-bugs)
  - [Control de versiones y Git](#control-de-versiones-y-git)
- [Ejercicios](#ejercicios)
  - [Técnicas de Prueba](#t%C3%A9cnicas-de-prueba)
  - [Pruebas API REST con Postman](#pruebas-api-rest-con-postman)
  - [Pruebas API REST con SoapUI](#pruebas-api-rest-con-soapui)
  - [Depurar con JavaScript en Chrome DevTools](#depurar-con-javascript-en-chrome-devtools)
  - [Redactar plan de pruebas](#redactar-plan-de-pruebas)
  - [Sesión testing exploratorio](#sesi%C3%B3n-testing-exploratorio)
  - [Carga de datos en una web con JMeter](#carga-de-datos-en-una-web-con-jmeter)
  - [Katas utilizando TDD](#katas-utilizando-tdd)
- [Recursos de aprendizaje](#recursos-de-aprendizaje)
- [Artículos del Blog de Sngular](#art%C3%ADculos-del-blog-de-sngular)

---

## Conceptos

### Pruebas de software

Las pruebas de software (Software Testing) comprenden el conjunto de actividades que se realizan para identificar posibles fallos de funcionamiento, configuración o usabilidad de un programa o aplicación, por medio de pruebas sobre el comportamiento del mismo.

[+ info](https://www.guru99.com/software-testing-introduction-importance.html)

![CicloPruebasCalidadSoftware.png](/img/iniciacion/CicloPruebasCalidadSoftware.png)

### Pruebas de Caja Blanca

Las pruebas de caja blanca se centran en los detalles procedimentales del software, por lo que su diseño está fuertemente ligado al **código fuente**. En este tipo de pruebas el código fuente es visible para los testers, de ahí el nombre que reciben (caja blanca o *transparente*).

[+ info](https://www.guru99.com/white-box-testing.html)

#### Técnicas de pruebas de caja blanca

- Cobertura de sentencias. [Video Explicativo](https://www.youtube.com/watch?v=BlmfclxstyQ)
- Cobertura de decisiones. [Video Explicativo](https://www.youtube.com/watch?v=RLAPLRbTV74)

### Pruebas de caja Negra

Las pruebas de caja negra se centran en verificar la funcionalidad sin tener en cuenta la estructura interna del código, detalles de implementación o escenarios de ejecución internos en el software.

Es por esto que reciben el nombre de prueba de caja negra, ya que no podemos ver a través de una caja negra.

[+ info](https://www.guru99.com/black-box-testing.html)

#### Técnicas de pruebas de caja negra

- Clase de Equivalencia. [Video Explicativo](https://www.youtube.com/watch?v=eKHOisGmRiE)
- Valores Límites. [Video Explicativo](https://www.youtube.com/watch?v=bGEyrUPnr2g)
- Tablas de Decisión. [Video Explicativo](https://www.youtube.com/watch?v=Z_IA_prGpp8)

### Cobertura de Código

La cobertura de código es el método de análisis que determina qué partes del software han sido ejecutadas (cubiertas) por las pruebas y qué partes no han sido ejecutadas.

Podemos verlo como el número de líneas de código de "producción" que son ejecutadas por las pruebas automáticas implementadas.

[+ info](https://www.guru99.com/code-coverage.html)

![CodeCoverage.png](/img/iniciacion/CodeCoverage.png)

### Ciclo de vida de software y Agile Testing

Cada vez es más habitual dejar atrás modelos de desarrollo de software basados en el ciclo de vida en cascada para encontrarse con modelos ágiles. En este sentido, el testing también tiene que adaptarse a estos nuevos marcos de trabajo para seguir aportando valor y ajustarse a tiempos de entrega más cortos.

Por ello, resulta fundamental entender el ciclo de vida de desarrollo ágil, principalmente Scrum, y cómo encaja el testing en este framework.

Estos son los principios que formarían la base del **buen** testing, en contraposición a la visión más clásica de mero verificador de requisitos al final del proceso.

![TheTestingManifesto.png](/img/iniciacion/TheTestingManifesto.png)

#### Definición Agile Testing

Es una práctica de testing que sigue las reglas y principios del desarrollo ágil de software. A diferencia del método Waterfall, el Agile Testing puede comenzar al principio del proyecto con una integración continua entre el desarrollo y el testing. Al igual que el desarrollo ágil, las pruebas ágiles son un proceso colaborativo y orientado al equipo, por ello, todos los miembros del equipo comparten la responsabilidad de probar el sistema.

[+ info](https://www.guru99.com/agile-testing-a-beginner-s-guide.html)

#### Principios del Context Driven Testing

El Testing guiado por el contexto, o *Context-Driven Testing*, defiende que la parte humana en el Testing es lo más importante, que un buen Testing es cuestión de habilidad humana, no de procedimientos (y menos de estándares). En definitiva, habla de que no hay "buenas prácticas" en Testing, sino que todo depende del contexto en que se usen.

[+ info](http://context-driven-testing.com/)

#### Shift Left Testing

Lo más habitual ha sido que las pruebas se ejecutasen al final del proceso de construcción del software. Parece que el sentido común aconseja que el testing se realice sobre artefactos terminados o sistemas funcionando.

Esta manera de proceder lleva a que la función del tester sea la de reportar bugs, puesto que las pruebas han quedado relegadas al final del proceso (a la derecha del todo). El enfoque "shift-left" apuesta por la implantación del testing lo antes posible dentro del ciclo de vida del proyecto (a la izquierda).

La idea detrás de este principio es que no es necesario esperar a tener partes del software construidas para reportar errores funcionales, de diseño, UX, de procedimiento, de cumplimiento de leyes, seguridad, estándares, etc. Es por esto que con este enfoque pasaríamos de un modelo de **reportar bugs** a otro de **prevenirlos**, algo obviamente mucho más interesante y efectivo.

[+ info](https://www.federico-toledo.com/que-es-shift-left-testing/)

![ShiftLeftTesting.png](/img/iniciacion/ShiftLeftTesting.png)

### Evaluación heurística

A la hora de enfrentarnos a las pruebas de un proyecto, en cualquiera de las fases del mismo:

- documentación de planes de pruebas
- añadir criterios de aceptación a las historias de usuario
- testing exploratorio
- testing en producción
- automatización

la experiencia del tester aporta mucho valor.

Sobre cada aplicación y situación a probar debemos intentar reconocer patrones y situaciones problemáticas que ya hayamos detectado previamente en otros proyectos para así aumentar la efectividad de las pruebas.

En este [documento](/files/iniciacion/HeurísticasTesting.pdf) se enumeran una serie de "sospechosos habituales", es decir, los aspectos claves que deberían cubrir las pruebas, así como puntos de los sistemas donde históricamente se suelen producir más problemas, ya sea por errores en las especificaciones o por la complejidad técnica que las acompaña.

[+ info](https://www.testbytes.net/blog/heuristic-test-strategy-model/)

### Redacción de planes de pruebas

Un plan de pruebas es un documento que debe recoger toda la información relativa a las pruebas a realizar sobre un sistema. Además de incluir los casos de pruebas en sí mismos, es muy importante que se indique claramente aspectos como:

- Entorno en el que se ejecutarán las pruebas.
- Precondiciones que se tienen que dar para comenzar las pruebas.
- Criterios de parada.
- Funcionalidades a probar y funcionalidad que NO se probará.
- Riesgos del plan de pruebas.
- Responsables de las pruebas.
- Informe de resultados.

[Ejemplo de plantilla plan de pruebas](/files/iniciacion/Informe_plan_de_pruebas.pdf)

### Testing exploratorio

Es la evolución de las pruebas manuales tradicionales. A diferencia de ellas, aquí no hay casos de prueba predefinidos a seguir, ni tampoco hay una serie de pasos predefinidos y escritos que se deban repetir. Las pruebas exploratorias se basan en el conocimiento que el tester va ganando sobre la aplicación a medida que la va probando.

[+ info](https://www.javiergarzas.com/2015/01/testing-exploratorio-10-min.html)

[Ejemplo de sesión de testing exploratorio sobre la aplicación de Spotify](https://www.youtube.com/watch?v=o0MXE8Onkh4)

### Unit Testing

Las pruebas unitarias son la base de la automatización de pruebas. Mediante ellas, podemos verificar el correcto funcionamiento de cada componente (o clase) de nuestro código.

Las pruebas deben centrarse en verificar el comportamiento de las clases, es decir, que nuestro código "haga lo que se espera que haga". Por ello, es importante que a la hora de realizar pruebas unitarias intentemos evitar detalles de implementación y nos centremos en la parte funcional.

Técnicas como [TDD](https://es.wikipedia.org/wiki/Desarrollo_guiado_por_pruebas)(Test Driven Development), pueden ser útiles en este sentido, puesto que al escribir (y pensar) el test en primer lugar, estamos obligados a pensar de qué manera será utilizada nuestra clase y por tanto, cómo se comportará.

### API Testing

Las pruebas de API son un tipo de pruebas de software que implica probar las interfaces de programación de aplicaciones directamente y como parte de las pruebas de integración para determinar si cumplen con las expectativas de funcionalidad, confiabilidad, rendimiento y seguridad.

[+ info](https://www.youtube.com/watch?v=vOBnIR3hNfA)

### E2E Testing

Las pruebas End-2-End (E2E) comprueban el funcionamiento de toda una aplicación desde la interfaz de usuario (ui), de principio a fin, cubriendo así secciones que las pruebas unitarias o de integración no cubren. Este tipo de pruebas nos garantizan que el flujo de una aplicación funciona como se esperaría ante la interacción de un usuario real.

Lo más común es que estas pruebas se automaticen utilizando alguna de las herramientas que existen para ello pero también se suelen realizar manualmente sobre todo si son muy costosas de automatizar en cuanto a tiempo y recursos.

[+ info](https://www.guru99.com/end-to-end-testing.html)

### Pruebas de regresión

Las pruebas de regresión son aquellas que se realizan para asegurarnos de que un cambio o una nueva funcionalidad no rompen la aplicación que estaba funcionando. Al realizar este tipo de pruebas, nos aseguramos de que comprobamos el códidgo que se ha modificado y se comporta como queremos y además que el cambio no rompe nada de lo que anteriormente funcionaba.

Es importante que este tipo de pruebas contengan tests de los errores que se han ido detectando en la aplicación y ya se han corregido para asegurarnos de que no se vuelven a repetir.

Generalmente estas pruebas se suelen automatizar ya que se realizan con una mayor frecuencia, aunque también se pueden realizar manualmente.

[+ info](https://www.qalovers.com/2018/11/pruebas-regresion.html)

### BDD

BDD o Behavior Driven Development es un proceso de desarrollo de software nacido desde el desarrollo guiado por prueba, es decir, es una evolución de TDD. Las pruebas se centran en el usuario y en el comportamiento del sistema.

> *BDD busca un lenguaje común para unir la parte técnica y la de negocio, y que sea desde ese lenguaje común desde donde arranque el Testing y, desde ahí, el desarrollo*.

[+ info](https://www.javiergarzas.com/2014/12/bdd-behavior-driven-development-1.html)

Los requisitos deben convertirse en historias de usuario definiendo ejemplos concretos. A estos ejemplos, los llamaremos **Criterios de Aceptación**. Pueden ser expresados siguiendo el patrón **"Given-When-Then"** o bien el patrón **"Role-Feature-Reason"** (As a “Role” - I want to - “what I need” - So that “feature to fulfill”)

Algunas de la ventajas de este enfoque son:

- todos los participantes en el proyecto, sean técnicos o no, hablan el mismo lenguaje
- los desarrolladores tienen más información sobre lo que deben implementar
- los criterios de aceptación son la base de las pruebas de aceptación para la funcionalidad que se está desarrollando

### Pirámide de testing ó Pirámide de Cohn

En general, cuando hablamos de automatización de pruebas es importarte establecer cierto criterio a la hora de abordarlas. Cuando nos referimos al testing, la distribución de test en forma de pirámide suele ser la más aceptada.

![Pirámide De Testing](/img/iniciacion/PiramideDeTesting.png)

La pirámide estaría distribuida en capas de testing, desde las pruebas unitarias que se situarían en la base, pasando por las de API, a las de interfaz o end to end (e2e). En la cima siempre tendríamos espacio para la parte de pruebas manuales, puesto que el factor humano del testing no puede, ni debe, ser sustituido por ninguna herramienta.

Siguiendo este patrón, deberíamos intentar que el número de pruebas unitarias sea el mayor, mientras que el número de pruebas automatizadas disminuiría a la hora que escalamos en la pirámide.

La ventaja de este enfoque está en que las pruebas unitarias son las más rápidas de implementar, mantener y ejecutar. A medida que avanzamos, por la naturaleza de los sistemas, las pruebas tardan más tiempo en ejecutarse y cuesta más mantenerlas, puesto que se vuelven más **"frágiles"** debido a que están más afectadas por los cambios funcionales de la aplicación y su adaptación, muchas veces no es trivial.

Si que es cierto que es complicado de llevar a cabo si el contexto no es favorable, con ello quiero decir, que sin una base de cultura de testing, conocimiento o estrategia, entre otras, será complicado tener un conjunto adecuado de pruebas automatizadas.

[+ info](https://medium.com/@morvader/testing-iceberg-2cc7501f4e06)

### Tipos de incidencias

A la hora de realizar pruebas de software y detectar incidencias, las hay de 3 tipos:

- **Error:** Acción humana que produce un resultado incorrecto.
- **Defecto:** Presencia de un error en el software
- **Fallo:** Manifestación física o funcional de un defecto.

[+ info](https://testerhouse.com/teoria-testing/error-defecto-bug-fallo/)

### Control y seguimiento de bugs

En función del tipo de proyecto, es necesario establecer un ciclo de reporte y seguimiento de bugs adecuado, que permita conocer el estado del sistema en todo momento.

Es importante que cada bug tenga asignada una **severidad** y un **grado de impacto**. Esto ayudará a conocer el estado real del sistema y priorizar el trabajo a la hora de corregir los bugs.

[Aquí](/files/iniciacion/CicloBugs.pdf) un ejemplo del ciclo de bugs

### Control de versiones y Git

Un sistema de control de versiones es una herramienta capaz de registrar todos los cambios que se realizan en uno o más proyectos, guardando a su vez versiones anteriores del proyecto, versiones a las que podemos acudir en caso de haber metido la pata o al no funcionar de la forma correcta.

---

## Ejercicios

Debes subir las respuestas de los ejercicios a tu cuenta personal de GitLab.

### Técnicas de Prueba

- [Formulario de ejercicios tipo test sobre técnicas de prueba de caja negra y caja blanca](https://forms.gle/WzUBxDyezxb6QRE46)

### Pruebas API REST con Postman

> :bookmark: **Nota**
>
> Usa el API REST [JSON Server](/code/json_server) para la realización del ejercicio
>

*Pasos previos:*

- Instalar [Docker](https://www.docker.com/)
- Instalar [Postman](https://www.getpostman.com/)
- Crear un entorno de Postman que apunte al servidor docker levantado.

*Pruebas a realizar en Postman:*

- Crear una nueva colección para ir guardando las consultas.
- Realizar una consulta al endpoint `/posts` y ver los resultados. El resultado que nos tiene que mostrar es un total de  ***100 ids***.
- Realizar una consulta al endpoint `/comment`. Analizar el resultado y solucionar el error. El número de registros tiene que ser ***500***.
- Realizar una consulta al endpoint `/comment` donde haya una **paginación de 3** y un **límite de 5** elementos por página. Analizar el resultado y comprobar que sea correcto.
- Realizar una consulta al endpoint `/posts` donde ordenes por el campo "id" de manera **ascendente** y filtrando por el texto "alias". El resultado tiene que ser ***9 registros***.
- Realizar una consulta al endpoint `/posts` para crear un nuevo registro. Comprobar que el resultado sea correcto.
- Consulta el registro creado y actualiza alguno de sus campos. Comprueba que el/los campo/s actualizado/s previamente se han modificado correctamente.
- Modifica un registro existente y comprueba que se ha actualizado con éxito.
- Elimina el registro creado. Comprueba que el registro se ha eliminado correctamente.

> :paperclip: **Tip**
>
> [Códigos de estado de respuesta HTTP](https://developer.mozilla.org/es/docs/Web/HTTP/Status)
>

### Pruebas API REST con SoapUI

Realizar una batería de pruebas con SoapUI para peticiones REST.

*Pasos previos:*

- Instalar [SoapUI](https://www.soapui.org/downloads/soapui/)

*Pasos a seguir:*

- Busca una API REST dónde puedas simular la autenticación de un usuario y comprobar por medio de validaciones, que el resultado esperado es el correcto (comprobando el mensaje de salida).
- Con el siguiente API REST de [countries](https://restcountries.com/#api-endpoints-v3-all), realiza lo siguiente:

  1. Crea un proyecto REST
  2. Añade una petición REST
  3. Añade parámetros a la petición anterior
  4. Crea un caso de prueba
  5. Añade asertos
  6. Ejecutaló y valida el resultado

### Depurar con JavaScript en Chrome DevTools

> :bookmark: **Nota**
>
> Con la siguiente [URL de demo](https://googlechrome.github.io/devtools-samples/debug-js/get-started) podrás realizar el ejercicio
>

*Pasos a seguir:*

- Informa los valores de los campos Number 1 y Number 2. A continuación, pulsa el botón **Add Number 1 and Number 2**.
- Analiza el resultado y resuelve el problema que se está dando. Para ello, apóyate en la herramienta DevTools del navegador Chrome. Presiona `Command+Option+I` (Mac) ó `Ctrl+Mays+I` (Windows, Linux) ó `botón derecho del ratón -> inspeccionar`. Investiga un poco y familiarízate con ellas en función de tu SO.
- Para resolver el error puedes usar el método `console.log()` y la otra forma es añadiendo `event listener breakpoints`.

> :paperclip: **Tip**
>
> - Establece un punto de interrupción de línea de código
> - En el panel `Scope` verifica el valor de las variables
> - Apóyate en las expresiones supervisadas que se encuentra en la pestaña `watch`
>

### Redactar plan de pruebas

> :bookmark: **Nota**
>
> Tomar de ejemplo la web de [Amazon](https://www.amazon.es/) para la realización del ejercicio
>

*Pasos a seguir:*

- Entra en la web de Amazon, y si no la conoces, échala un vistazo y sobretodo al proceso de compra.
- Elabora el plan de pruebas y riesgos, en el formato que quieras.
- Estructura bien las secciones y apartados.

### Sesión testing exploratorio

> :bookmark: **Nota**
>
> Tomar de ejemplo la web de [AirBnb](https://www.airbnb.es/) para la realización del ejercicio
>

*Pasos a seguir:*

- Accede a la web AirBnb y realiza un análisis de su funcionalidad.
- Documenta las pruebas en el formato que quieras.
- Recopila bugs, ideas, problemas y posibles mejoras.
- Realiza dichas pruebas en varios navegadores. (Chrome, Firefox y otro más)
- Realiza algunas pruebas exploratorias en la versión responsive.

### Carga de datos en una web con JMeter

> :bookmark: **Nota**
>
> Con la siguiente [web de pruebas](http://demo.guru99.com/test/newtours/register.php) podrás realizar el ejercicio
>

La idea del ejercicio es que rellenes los datos del formulario de manera automatizada con varios juegos de datos de pruebas. De esta manera con una sola ejecución probaras varias casuísticas con diferentes datos.

*Pasos a seguir:*

- Realiza la generación de datos con [Mockaroo](https://www.mockaroo.com/)
- Realiza la inserción de datos en la web con [JMeter](https://jmeter.apache.org/)

### Katas utilizando TDD

Resolver las siguientes Katas utilizando ***TDD (Test driven development)*** con los lenguajes de programación Java, JavaScript y Python.

- [FizzBuzz](http://codingdojo.org/kata/FizzBuzz/)
- [StringCalculator](http://codingdojo.org/kata/StringCalculator/)
- [PokerHands](http://codingdojo.org/kata/PokerHands/)

> :paperclip: **Tip**
>
> - Para JavaScript recomendamos [Jest](https://deltice.github.io/jest/docs/es-ES/getting-started.html)
> - En el caso de Java recomendamos [Junit](https://blog.softtek.com/es/testing-unitario)
> - Y por último, en python recomendamos [Pytest](https://www.guru99.com/pytest-tutorial.html)
>

---

## Recursos de aprendizaje

- [5 técnicas de generación de datos de prueba](https://www.testbytes.net/blog/5-test-data-generation-techniques-to-know/)
- [Tutorial Postman](https://www.guru99.com/postman-tutorial.html)
- [Manual básico de git](https://rogerdudler.github.io/git-guide/index.es.html)
- [Setting a Foundation for Successful Test Automation course](https://testautomationu.applitools.com/setting-a-foundation-for-successful-test-automation/)
- [Curso Unit Testing](https://testautomationu.applitools.com/unit-testing/)
- [Pruebas de API Testing](https://www.guru99.com/api-testing.html)
- [Como empezar a testear un web service](https://www.dataart.com.ar/news/como-comenzar-a-testear-un-web-service/)
- [11 Trucos para la consola de desarrollo de Chrome](https://www.youtube.com/watch?v=EO3CHe7BWuI)
- [Curso Udemy - ISTQB certified tester foundation level (CTFL)](https://sngular.udemy.com/course/istqb-certified-tester-foundation-level-ctfl/)
- [Curso Udemy - ISTQB certified tester foundation level (CTFL) Preparation exam review](https://sngular.udemy.com/course/istqb-certified-tester-foundation-level-ctfl-preparation-exam-review/)
- [Curso Udemy - ISTQB foundation level practice exam](https://sngular.udemy.com/course/istqb-foundation-level-practice-exams/)
- [Curso Udemy - SoapUI](https://sngular.udemy.com/course/webservices-testing-with-soap-ui/)
- [Iniciación API Testing](https://atejeda-qa.medium.com/api-testing-y-no-morir-en-el-intento-1ra-parte-2d37e8929b5a)

---

## Artículos del Blog de Sngular

- [Agile Testing](https://www.sngular.com/es/agile-testing/)
- [Pruebas API con SoapUI](https://www.sngular.com/es/pruebas-api-con-soapui/)
- [Postman I: Explorando la herramienta](https://www.sngular.com/es/postman-i-comenzando-a-explorarlo/)
- [Postman II: Flows y automatización con Newman](https://www.sngular.com/es/postman-ii-flows-y-automatizacion-con-newman/)
