# Itinerario formativo - nivel avanzado <!-- omit in toc -->

- [Conceptos](#conceptos)
  - [Testing de microservicios](#testing-de-microservicios)
    - [Enfoque monolítico vs microservicios](#enfoque-monol%C3%ADtico-vs-microservicios)
    - [Cómo probar los microservicios](#c%C3%B3mo-probar-los-microservicios)
  - [Arquitectura Hexagonal](#arquitectura-hexagonal)
  - [Contract Testing](#contract-testing)
    - [Consumer-Driven Contract Testing](#consumer-driven-contract-testing)
    - [Contract Testing Bi-direccional](#contract-testing-bi-direccional)
  - [Virtualización de Entornos](#virtualizaci%C3%B3n-de-entornos)
    - [Docker](#docker)
    - [Vagrant](#vagrant)
    - [Comparativa entre Docker y Vagrant](#comparativa-entre-docker-y-vagrant)
  - [Configuración de pipelines para CI y CD](#configuraci%C3%B3n-de-pipelines-para-ci-y-cd)
    - [¿Que es un Pipeline?](#%C2%BFque-es-un-pipeline%3F)
  - [Pruebas de Seguridad](#pruebas-de-seguridad)
  - [Mutation Testing](#mutation-testing)
    - [Ventajas](#ventajas)
    - [Desventajas](#desventajas)
  - [Property Based Testing](#property-based-testing)
- [Herramientas](#herramientas)
  - [Kubernetes](#kubernetes)
  - [Helm](#helm)
  - [Jenkins](#jenkins)
  - [Pact](#pact)
  - [Herramientas para pruebas de seguridad](#herramientas-para-pruebas-de-seguridad)
    - [Metasploit](#%5Bmetasploit%5D%28https%3A%2F%2Fwww.metasploit.com%2F%29)
    - [Acunetix Web Vulnerability Scanner](#%5Bacunetix-web-vulnerability-scanner%5D%28https%3A%2F%2Fwww.acunetix.com%2Fweb-vulnerability-scanner%2F%29)
    - [OWASP ZAP (abr. para Zed Attack Proxy)](#%5Bowasp-zap-%28abr.-para-zed-attack-proxy%29%5D%28https%3A%2F%2Fowasp.org%2Fwww-project-zap%2F%29)
    - [Wireshark](#%5Bwireshark%5D%28https%3A%2F%2Fwww.wireshark.org%2F%29)
- [Ejercicios](#ejercicios)
  - [Instalación y monitorización de un cluster de Kubernetes](#instalaci%C3%B3n-y-monitorizaci%C3%B3n-de-un-cluster-de-kubernetes)
  - [Jenkins y Sonar](#jenkins-y-sonar)
  - [Jenkins y Docker](#jenkins-y-docker)
  - [Consumer-Driven contract testing](#consumer-driven-contract-testing-1)
  - [Contract testing bi-direccional](#contract-testing-bi-direccional-1)
- [Recursos de aprendizaje](#recursos-de-aprendizaje)
  - [Microservicios](#microservicios)
  - [Arquitectura hexagonal](#arquitectura-hexagonal-1)
  - [CI](#ci)
  - [Contract testing](#contract-testing-1)
  - [Pruebas de seguridad](#pruebas-de-seguridad-1)
  - [Virtualización de entornos](#virtualizaci%C3%B3n-de-entornos-1)
- [Artículos del Blog de Sngular](#art%C3%ADculos-del-blog-de-sngular)

---

## Conceptos

### Testing de microservicios

La arquitectura en microservicios busca desarrollar una aplicación dividiéndola en pequeños servicios (cada uno con su lógica de negocio) que corren de forma autónoma y que se comunican entre sí.

[Enlace video explicativo](https://www.youtube.com/watch?v=9R2hFwIPGnQ)

#### Enfoque monolítico vs microservicios

Tradicionalmente el diseño de software se ha realizado con arquitectura monolítica, en la que el software se estructura de forma que todos los aspectos funcionales quedan acoplados y sujetos en un mismo programa. En este tipo de sistema, toda la información está alojada en un servidor, por lo que no hay separación entre módulos y las diferentes partes de un programa están muy acopladas. Esto genera un problema a largo plazo, ya que se trata de un sistema no escalable de manera sencilla. Por eso aparece la arquitectura de microservicios.

Detectada la necesidad por parte de las empresas de realizar cambios en el software e implementarlos de forma fácil y rápida, nacen los microservicios. La idea era dividir los sistemas en partes individuales, permitiendo que se puedan tratar y abordar los problemas de manera independiente sin afectar al resto.

Así, mientras que en una arquitectura monolítica el software se desarrolla como una única unidad, una arquitectura de microservicios funciona con un conjunto de pequeños servicios que se ejecutan de manera autónoma e independiente.

[+ info](https://decidesoluciones.es/arquitectura-de-microservicios/)

![arquitectura_monolitica_vs_microservicios.png](/img/avanzado/arquitectura_monolitica_vs_microservicios.png)

#### Cómo probar los microservicios

- **Pruebas unitarias**: comprueban la funcionalidad de los métodos o módulos de código que creamos necesarios.

- **Pruebas de Componentes**: Típicamente, una aplicación estaría compuesta por un número de Microservicios; por lo tanto, para probar de forma aislada cada uno de ellos, necesitamos *mockear* los otros Microservicios.

- **Pruebas de extremo a extremo**: comprueban que un sistema cumple con los requisitos externos y que alcanza sus objetivos, probando todo el sistema.

- **Pruebas de integración**: verifican las vías de comunicación e interacciones entre los componentes para detectar defectos de interfaz.

- **Pruebas de contrato**: comprueban las interacciones en los límites de un servicio externo, afirmando que cumple con el contrato esperado por un servicio consumidor.

### Arquitectura Hexagonal

La arquitectura hexagonal junto con arquitectura de puertos y adaptadores es muy utilizada hoy en día, sin embargo la gente aún se confunde con el nombre y no conoce muy bien la diferencia entre ellos, cual es su valor añadido.

La arquitectura hexagonal es un estilo de arquitectura que mueve el foco de un programador desde un plano más conceptual hacia la distinción entre el interior y el exterior del software. La parte interior son los casos prácticos y el modelo domain está construido sobre ello. La parte exterior es UI, base de datos, mensajería, etc. La conexión entre el interior y el exterior es mediante puertos, y su implementación equivalente se conocen como adaptadores. Por esta razón, este estilo de arquitectura se conoce habitualmente como Puertos y Adaptadores.

La arquitectura hexagonal promueve la separación de módulos mediante la encapsulación de la lógica en diferentes capas de la aplicación. Esto permite un aislamiento de mayor nivel, testabilidad, y control sobre el código de negocio específico. Cada capa de la aplicación tiene un estricto grupo de responsabilidades y requerimientos. Esto crea separaciones más claras entre la lógica y la funcionalidad, y como esas capas deberían interactuar entre ellas.
Cada parte del hexágono representa un input – puerto, por ejemplo HTTP, que utiliza un adaptador para un tipo específico.

[+ info](https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f)

![arquitectura_hexagonal.png](/img/avanzado/arquitectura_hexagonal.png)

### Contract Testing

Las pruebas de contrato es una metodología para garantizar que dos sistemas separados (como dos microservicios) sean compatibles entre sí. Captura las interacciones que se intercambian entre cada servicio, almacenándolas en un contrato, que luego se puede utilizar para verificar que ambas partes se adhieran a él.

Lo que diferencia esta forma de prueba de otros enfoques que apuntan a lograr lo mismo, es que cada sistema puede probarse independientemente del otro y que el contrato es generado por el propio código, lo que significa que el contrato siempre se mantiene actualizado con la realidad.

[+ info](https://pactflow.io/blog/what-is-contract-testing/)

#### Consumer-Driven Contract Testing

A la hora de realizar cualquier cambio en un sistema donde se sigue una arquitectura de proveedor/consumidor, el eslabón más débil de la cadena siempre será el consumidor y el que, principalmente, sufrirá los efectos de cualquier error. En cualquier sistema orientado a servicios, se debe garantizar en todo momento que los consumidores de éstos siguen operando con normalidad. Es por ello que se debe prestar especial atención a la hora de mantener la compatibilidad entre ambos sistemas y que el formato de las peticiones y respuestas sea el esperado en cada parte respectivamente.

Por ello, en determinados tipos de soluciones tiene más sentido que sea el cliente quién "tome la iniciativa" a la hora definir las reglas de comunicación entre las partes. En la práctica. Este enfoque no implica que sea el cliente el que "dicte" las normas, en todo caso, el pacto debe surgir de una comunicación entre parte y plasmar los acuerdos que se hayan tomado.

![contract_testing.png](/img/avanzado/contract_testing.png)

#### Contract Testing Bi-direccional

Como se ha mencionado anteriormente, la técnica de **Consumer Driven Contract Testing** presenta importantes ventajas y, realmente, sería la opción más recomendable en entornos donde exista una buena coordinación entre equipos. No obstante, este no siempre es el caso y la implementación de este enfoque puede resultar complejo en determinados contextos. Algunos ejemplos podrían ser:

- La parte consumidora no tiene suficiente detalle técnico sobre la implementación del proveedor
- La comunicación en equipos no es del todo fluida
- La parte proveedora no verifica los contratos generados por el consumidor
- El flujo de trabajo y organización está muy centrada en la parte proveedora y los consumidores deben adaptarse a los cambios realizados

Se dan situaciones donde la parte proveedora ya dispone de una especificación Open API generada ó bien ya tiene desarrollada una batería de pruebas del API perfectamente válida y, por tanto, introducir la verificación de contratos en su código, puede resultar redundante.

En estos casos, el enfoque de **contract testing bi-direccional**, otorga gran versatilidad a los equipos para que sigan el flujo de trabajo más conveniente.

![bidirectional_contract.png](/img/avanzado/bidirectional_contract.png)

### Virtualización de Entornos

A la hora de virtualizar entornos de desarrollo o pruebas, las dos tecnologías más conocidas son `Docker` y `Vagrant`

#### Docker

Es una tecnología Open Source para crear contenedores ligeros y portables para cualquier aplicación.

[+ info](https://www.campusmvp.es/recursos/post/Que-es-Docker.aspx)

#### Vagrant

Permite la creación y gestión sencilla de entornos de trabajo "portables" y replicables que funcionan sobre tecnologías de virtualización conocidas, ofreciendo además un modo de trabajo claro para poder transportar dichos entornos y que funcionen sin problemas en otro lugar: nuevamente en un servidor, la nube, etc...

Se podría decir que Vagrant es un gestor de maquinas virtuales que por debajo puede trabajar con las tecnologías de virtualización como: VMWare, VirtualBox, Hyper-V, Amazon web Services, RackSpace Cloud, Google Compute Engine...

Como conclusión, los resultados son parecidos, pero la tecnología para lograrlo es completamente distinta, y no hay que confundirlas.
No son excluyentes entre sí, es decir, es posible utilizar Vagrant para crear un entorno capaz de ejecutar Docker dentro de éste y así desplegar una aplicación. Es más, Vagrant viene "de serie" con un proveedor para generar contenedores Docker directamente en el sistema operativo actual.

#### Comparativa entre Docker y Vagrant

![Diferencias_vs_similitdes_docker_vagrant.png](/img/avanzado/Diferencias_vs_similitdes_docker_vagrant.png)

Ambas herramientas son excelentes para entornos de desarrollo y de pruebas y para pasar a producción entornos completos despreocupándonos por las posibles diferencias o la falta de bibliotecas o servicios necesarios. En ambos casos son mucho más flexibles que una "simple" máquina virtual tradicional, y bien utilizados, pueden suponer un ahorro enorme de problemas y de dificultades de gestión. Es por eso que todos los grandes actores de la industria están apostando por ellos, especialmente por Docker, e incluso Microsoft ofrece soporte para el producto dentro de sus sistemas operativos y dentro de Azure (hay que pensar que originalmente Docker solo funcionaba en Linux).

### Configuración de pipelines para CI y CD

CI/CD consiste en distribuir aplicaciones a los clientes con frecuencia mediante el uso de la automatización en las etapas del desarrollo de aplicaciones. Los principales conceptos que se atribuyen a CI/CD son la integración continua, la distribución continua y la implementación continua. Es una solución para los problemas que puede generar la integración del código nuevo a los equipos de desarrollo y de operaciones.

En concreto, incorpora la automatización continua y el control permanente en todo el ciclo de vida de las aplicaciones, desde las etapas de integración y pruebas hasta las de distribución e implementación. Este conjunto de prácticas se conoce como "canales de CI/CD", y cuenta con el soporte de los equipos de desarrollo y de operaciones que trabajan de forma conjunta y con agilidad.

[+ info](https://www.redhat.com/es/topics/devops/what-is-ci-cd)

#### ¿Que es un Pipeline?

Partiendo de nuestro enfoque (ingeniería del software), es un conjunto de procesos automatizados que permiten a los desarrolladores y profesionales de DevOps compilar, construir e implementar su código de manera confiable y eficiente en sus plataformas de producción.
No existe una regla estricta de como configurar un pipeline y las herramientas que se deben utilizar, pero los componentes más comunes son:

![Etapas_CI.png](/img/avanzado/Etapas_CI.png)

Un ***pipeline*** generalmente consiste en un conjunto de herramientas que normalmente se dividen en las siguientes categorías:

- Fuente de control
- Construir herramientas
- Contenedorización
- Gestión de la configuración
- Supervisión

El objetivo clave de una distribución de software es la automatización sin pasos manuales o cambios necesarios en o entre los pasos de un ***pipeline***. El error humano puede ocurrir y ocurre cuando se llevan a cabo estas tareas aburridas y repetitivas de forma manual y, en última instancia, afecta a la capacidad de cumplir con los entregables y, posiblemente, los SLA debido a implementaciones fallidas.

[+ info](https://www.bmc.com/blogs/deployment-pipeline/)

### Pruebas de Seguridad

Validan los servicios de seguridad de una aplicación e identifican posibles fallos y debilidades.

Muchos proyectos utilizan un enfoque de caja negra para las pruebas de seguridad, lo que permite a los expertos, sin conocimiento del software, probar la aplicación en busca de agujeros, fallos, exploit y debilidades.

### Mutation Testing

La técnica consiste en modificar el código de nuestras implementaciones de forma automática para detectar si las pruebas que hemos realizado identifican cambios y actúan en consecuencia.

#### Ventajas

1. Es un enfoque poderoso para lograr una alta cobertura del programa fuente.
2. Esta prueba es capaz de probar exhaustivamente el programa mutante.
3. Las pruebas de mutación brindan un buen nivel de detección de errores al desarrollador de software.
4. Este método descubre ambigüedades en el código fuente y tiene la capacidad de detectar todas las fallas en el programa.
5. Los clientes se benefician de estas pruebas al obtener un sistema más confiable y estable.

#### Desventajas

1. Las pruebas de mutación son extremadamente costosas y requieren mucho tiempo ya que hay muchos programas mutantes que deben generarse.
2. Como lleva mucho tiempo, es justo decir que esta prueba no se puede hacer sin una herramienta de automatización.
3. Cada mutación tendrá la misma cantidad de casos de prueba que la del programa original. Entonces, una gran cantidad de programas mutantes pueden necesitar ser probados contra el conjunto de pruebas original.
4. Como este método implica cambios en el código fuente, no es aplicable en absoluto para Black Box Testing.

[+ info](https://www.autentia.com/2017/01/30/mutation-testing-who-watches-the-watchmen-por-rafael-vindel-y-jose-luis-rodriguez/)

### Property Based Testing

Es una estrategia de pruebas adoptada inicialmente por el paradigma de la programación funcional. Estas pruebas están diseñadas para probar los aspectos de una propiedad que siempre debe ser "true". Permiten programar y probar una serie de entradas dentro de una sola prueba, en lugar de tener que escribir una prueba diferente para cada valor que se quiera probar. Este tipo de pruebas tiene una serie de peculiaridades:

- No es necesario fijarse tanto en el estado del sistema a probar como en las propiedades que debe cumplir el mismo.
- No se tiene un control absoluto de los datos con los que ejercitamos el sistema.
- Cada uno de los tests se ejecuta múltiples veces con distintos valores.

[+ info](https://www.serch.dev/blog/2019/11/29/introduccion-a-property-based-testing.html)

---

## Herramientas

### Kubernetes

Kubernetes o también llamado `k8s` es un orquestador de dockers/contenedores de software. Decimos que es un orquestador porque es el encargado de dirigir la infraestructura englobando tareas como balanceo de carga, despliegues, escalamiento, recuperación automática, etc.

Mediante este sistema de arquitectura se puede controlar un sistema o aplicación diseñada a través de microservicios alojados en contenedores. Los contenedores son los elementos virtuales donde se alojan las imágenes de docker.

[+ info](./kubernetes/_index.md)

### Helm

Es una herramienta que se utiliza para la gestión de paquetes de Kubernetes. Estos paquetes se denominan `charts` y son una colección de ficheros que describen a un conjunto de recursos del API de Kubernetes.

Con Helm podemos:

- Empaquetar nuestras aplicaciones como charts.
- Interactuar con repositorios de charts (públicos o privados).
- Instalar y desinstalar charts en nuestros clusters de Kubernetes.
- Gestionar el ciclo de vida de despliegue de charts que han sido instaladas con Helm.

[+ info](https://helm.sh/)

### Jenkins

Es un servidor open source escrito en JAVA para la integración continua y despliegue continuo (CI/CD). Se utiliza para compilar y probar proyectos de software de forma continua facilitando a los desarrolladores integrar cambios en un proyecto y entregar nuevas versiones a los usuarios.

Podemos automatizar multitud de tareas que nos ayudarán a reducir el *time to market* de nuestros productos o de las versiones de ellos, entre ellas:

- Automatizar la compilación y testeo de software.
- Notificar a los equipos correspondientes la detección de errores.
- Desplegar los cambios en el código que hayan sido validados.
- Hacer el seguimiento de la calidad del código y de la cobertura de las pruebas.
- Generar la documentación de un proyecto.

Esta herramienta tiene disponibles cientos de [plugins](https://plugins.jenkins.io/) que se puede implementar en diferentes etapas del ciclo de vida del desarrollo, como la compilación, la documentación, el testeo o el despliegue.

### Pact

Es una herramienta de *contract testing* que nos permite probar la mensajería entre aplicaciones (por ejemplo, solicitudes y respuestas HTTP, o mensajes enviados a través de una cola). Esto significa que cada aplicación puede probarse de forma independiente, lo que mejora significativamente el flujo de trabajo de desarrollo y el tiempo de prueba.

[+ info](https://pactflow.io/how-pact-works/?utm_source=ossdocs&utm_campaign=getting_started#slide-1)

### Herramientas para pruebas de seguridad

#### [Metasploit](https://www.metasploit.com/)

Es un proyecto de código abierto para la seguridad informática, que proporciona información acerca de vulnerabilidades de seguridad y ayuda en tests de penetración "Pentesting" y el desarrollo de firmas para sistemas de detección de intrusos.

Su subproyecto más conocido es el ***Metasploit Framework***, una herramienta para desarrollar y ejecutar exploits contra una máquina remota. Otros subproyectos importantes son las bases de datos de opcodes (códigos de operación), un archivo de shellcodes, e investigación sobre seguridad. Inicialmente fue creado utilizando el lenguaje de programación de scripting *Perl* aunque actualmente el Metasploit Framework ha sido escrito de nuevo completamente en el lenguaje Ruby.

#### [Acunetix Web Vulnerability Scanner](https://www.acunetix.com/web-vulnerability-scanner/)

Es una herramienta que será capaz de escanear sitios web en busca de posibles fallos de seguridad que puedan poner en peligro la integridad de la página publicada en Internet. Esta aplicación ejecuta una serie de pruebas, totalmente configurables por el usuario, para identificar las vulnerabilidades tanto en la programación de la página como en la configuración del servidor

#### [OWASP ZAP (abr. para Zed Attack Proxy)](https://owasp.org/www-project-zap/)

Es un escáner de seguridad web de código abierto. Pretende ser utilizado como una aplicación de seguridad y como una herramienta profesional para pruebas de penetración.

Cuándo se usa como servidor proxy permite a los usuarios manipular todo el tráfico que pasa a través de este, incluyendo el tráfico del protocolo seguro HTTPS. La aplicación puede desplegarse en modo demonio que es controlado mediante API REST.

Esta herramientas es multiplataforma, pues se ha escrito en Java y está disponible en sistemas tales como Windows, Linux y macOS.

#### [Wireshark](https://www.wireshark.org/)

Es un analizador de protocolos utilizado para realizar análisis y solucionar problemas en redes de comunicaciones, para desarrollo de software y protocolos, y como una herramienta didáctica. Cuenta con todas las características estándar de un analizador de protocolos.

La funcionalidad que provee es similar a la de *tcpdump*, pero añade una interfaz gráfica y muchas opciones de organización y filtrado de información. Así, permite ver todo el tráfico que pasa a través de una red (usualmente una red Ethernet, aunque es compatible con algunas otras) estableciendo la configuración en modo promiscuo.

Permite examinar datos de un archivo de captura salvado en disco. Se puede analizar la información capturada, a través de los detalles y cabeceras de cada paquete. Wireshark incluye un completo lenguaje para filtrar lo que queremos ver y la habilidad de mostrar el flujo reconstruido de una sesión de TCP.

Es software libre y se ejecuta sobre la mayoría de sistemas operativos Unix y compatibles, incluyendo Linux, Solaris, FreeBSD, NetBSD, OpenBSD, Android, y macOS , así como en Microsoft Windows.

---

## Ejercicios

Debes subir las respuestas de los ejercicios a tu cuenta personal de GitLab.

### Instalación y monitorización de un cluster de Kubernetes

Para familiarizarnos con kubernetes vamos a partir de una aplicación básica que nos devuelve información del host.

*Pasos previos:*

1. **[Clonarse o descargarse el siguiente proyecto](https://github.com/christianhxc/intro-to-kubernetes)**
2. Realizar las instalaciones necesarias para tu sistema operativo y poder trabajar con Kubernetes.
3. Levantar la imagen Docker.
4. Comprobar que la imagen esta levantada y funcionando.

*Pasos a seguir:*

1. Realizamos una consulta de información del **cluster**, otra de los **pods** y por último una de los **nodos**.

    > :bookmark: **Nota**
    >
    > si la versión vía comandos no nos gusta mucho para minukube, hay un dashboard que se ejecuta en el navegador o un plugin llamado [kubernetes](https://marketplace.visualstudio.com/items?itemName=ms-kubernetes-tools.vscode-kubernetes-tools) para Visual Studio Code.
    >

2. Creamos un pod y consultamos los logs para comprobar que se ha creado correctamente.
3. Borramos un pod y comprobamos lo que sucede. Cuando te reúnas con tu compañero para revisar el ejercicio explícale que ha sucedido al borrar el pod.
4. Creamos un deployment y comprobamos que se ha creado correctamente.
5. Creamos un servicio y comprobamos que se ha creado. En el caso, de que el servicio se quede con status “pending”, tendremos que asignarle una ip publica.
6. Creamos un namespace en nuestro cluster. Le asignamos de nombre "replica-default".

    6.1 Desplegamos de nuevo el **deployment.yaml** y el **services.yaml** sobre el nuevo namespace.

    6.2 Una vez que comprobamos que los elementos están operativos y en estado Running, modificamos algunos parametros sobre los archivos de despliegue y aplicamos cambios. Por ejemplo, cambiar los puertos del servicio desplegado, cambiar el número de replicas de pods que queremos, etc.

    El objetivo es observar como los cambios ocurridos en un namespace no afectan en el otro.

### Jenkins y Sonar

Con este ejercicio se pretende conseguir la familiarización con las herramientas de Jenkins y Sonar

> :bookmark: **Nota**
>
> Usa esta [calculadora](/code/calculadora_errores) programada en JAVA para la realización del ejercicio
>

*Pasos a seguir:*

1. Creación de un docker-compose con Jenkins y con Sonar con visibilidad entre ellos.
2. Configurar un pipeline la calculadora JAVA para que envíe resultados. El pipeline deberá tener al menos las siguientes fases:
    - Compilación
    - Análisis estático de código
3. Desde Sonar, analizar los resultados obtenidos y las métricas (deuda técnicas, complejidad, etc.).
4. Cambiar reglas y criticidad de las mismas y ejecutar de nuevo el análisis para ver que resultado se obtiene.

### Jenkins y Docker

Con este ejercicio se pretende conseguir la familiarización con las herramientas de Jenkins y Docker a un nivel un poco más avanzado

> :bookmark: **Nota**
>
> Usa esta [calculadora](/code/calculadora) programada en JAVA para la realización del ejercicio
>

*Pasos a seguir:*

1. Crear una imagen docker con la que poder lanzar un Jenkins y que tenga Docker
2. Crear un pipeline que deje una traza en la línea de comandos (un "echo" por ejemplo)
3. Crear un pipeline que compile y ejecute las pruebas unitarias de la aplicación java.
4. Crear un pipeline con las siguientes fases:
    - Compilación
    - Análisis estático de código
    - Ejecución de pruebas unitarias
    - Publicación de informes
5. Crear un pipeline que ejecute pruebas de Selenium utilizando un Selenium-Grid dockerizado
    - Las pruebas de Selenium deben lanzarse contra un Grid remoto
    - Este grid debe estar dockerizado y gestionado por Jenkins
    - Al arrancar las pruebas, debe poder parametrizarse la URL del Grid
6. Dockerizar el pipeline completo de pruebas
    - El pipeline de Jenkins debe hacer que la fases del punto "4" se ejecuten dentro de un contenedor Docker y recoger los resultados

### Consumer-Driven contract testing

Con este ejercicio se pretende conseguir la familiarización con la técnica de consumer-driven contract testing usando Pact.

> :bookmark: **Nota**
>
> Usa este [productor-consumidor](/code/pact-jvm) programado en JAVA para la realización del ejercicio

*Pasos a seguir:*

1. Crea los tests de contrato de la parte consumidora
2. Crea los tests de contrato de la parte productora
3. Genera los contratos desde la parte consumidora
4. Publica el contrato en el Pact Broker(levantado con un docker en localhost) o en [Pactflow.io](https://pactflow.io/sign-in/)
5. Verifica el contrato
6. Ejecuta la herramienta **can-i-deploy** para comprobar que se puedan realizar despliegues sin problemas.

> :paperclip: **Tip**
>
> puedes encontrar ayuda en los siguientes enlaces:
>
> - [Pact Maven + Springboot + Junit5 workshop](https://github.com/pact-foundation/pact-workshop-Maven-Springboot-JUnit5)
>
> - [Example Spring Boot project for the Pact workshop](https://github.com/pact-foundation/pact-workshop-jvm-spring)
>
> - [Consumer-Driven Contract Testing using Pact Java](https://blog.testproject.io/2020/05/27/consumer-driven-contract-testing-using-pact-java)
>

### Contract testing bi-direccional

Con este ejercicio se pretende conseguir la familiarización con la técnica de contract testing bi-direccional usando Pact.

> :bookmark: **Nota**
>
> Usa este [consumidor](/code/bi-directional_ct) programado en JAVA y la colección de Postman de la parte proveedora para la realización del ejercicio
>

1. Crea los tests de contrato de la parte consumidora usando Pact
2. Publica el contrato del cosumidor en [Pactflow.io](https://pactflow.io/sign-in/)
3. Genera el OpenAPI Specification desde la colección de postman de la parte productora
4. Publica el contrato del productor en Pactflow.io
5. Ejecuta la herramienta **can-i-deploy** para comprobar que se puedan realizar despliegues sin problemas.

> :paperclip: **Tip**
>
> puedes encontrar ayuda en este enlace [Bi-directional contract testing guide](https://docs.pactflow.io/docs/bi-directional-contract-testing/)
>

---

## Recursos de aprendizaje

### Microservicios

- [Testing de microservicios - estrategia](https://qajungle.com/testing-en-microservicios-parte-1-estrategias/)
- [¿Que son los microservicios?](https://www.javiergarzas.com/2015/06/microservicios.html)
- [Video explicativo sobre un ejemplo de microservicios](https://www.youtube.com/watch?v=qAcUGw7HhxM)

### Arquitectura hexagonal

- [¿Que es arquitectura hexagonal?](https://apiumhub.com/es/tech-blog-barcelona/arquitectura-hexagonal/)
- [Video explicativo sobre Arquitectura de Hexagonal y DDD - Domain-Driven Design](https://codely.tv/blog/screencasts/arquitectura-hexagonal-ddd/)
- [Diseño guiado por dominio](https://apiumhub.com/es/tech-blog-barcelona/diseno-guiado-por-el-dominio/)

### CI

- [Branch technique by abstraction](https://martinfowler.com/bliki/BranchByAbstraction.html)
- [Ley de Conway](https://www.javiergarzas.com/2015/06/conway.html)
- [Principios Solid](https://apiumhub.com/es/tech-blog-barcelona/principios-solid/)
- [Integración continua y pipelines con Jenkins](https://sdos.es/blog/la-integracion-continua-actual-pasa-por-pipelines)

### Contract testing

- [Mejora las pruebas de microservicios con contract testing](https://medium.com/@morvader/mejora-las-pruebas-de-microservicios-con-contract-testing-ce6b3c0d9226)

### Pruebas de seguridad

- [Metodología y Frameworks de testeo de la seguridad de las aplicaciones](http://www.juntadeandalucia.es/servicios/madeja/sites/default/files/historico/1.3.0/contenido-recurso-216.html)
- [Curso de Pruebas de Penetración](https://www.udemy.com/course/wifi-hacking-from-a-penetration-testers-perspective/)
- [Pruebas de seguridad informática - Pentest](https://www.iicybersecurity.com/pruebas-de-seguridad-informatica-pentest.html)

### Virtualización de entornos

- [Beneficios de utilizar Docker y contenedores a la hora de programar](https://www.campusmvp.es/recursos/post/los-beneficios-de-utilizar-docker-y-contenedores-a-la-hora-de-programar.aspx)
- [Certificación Kubernetes administrador](https://sngular.udemy.com/course/certified-kubernetes-administrator-with-practice-tests/)
- [Kubernetes desde cero](https://sngular.udemy.com/course/kubernetes-made-easy/)
- [Kubernetes para principiantes](https://sngular.udemy.com/course/learn-kubernetes/)

---

## Artículos del Blog de Sngular

- [Mejora las pruebas de microservicios con Contract Testing](https://www.sngular.com/es/pruebas-contract-testing/)
- [Contract Testing en CI: Uniendo PACT y Jenkins](https://www.sngular.com/es/contract-testing-en-ci-uniendo-pact-y-jenkins/)
- [La manera más sencilla de comenzar con contract testing bi-direccional](https://www.sngular.com/es/manera-sencilla-comenzar-contract-testing-bi-direccional/)
- [Sngular + BrowserStack: una alianza para mejorar los procesos de QA en múltiples dispositivos](https://www.sngular.com/es/sngular-browserstack-una-alianza-para-mejorar-los-procesos-de-qa-en-multiples-dispositivos/)
- [QA + DEVOPS - Dockerizando un pipeline de Jenkins](https://www.sngular.com/es/qa-devops-dockerizando-un-pipeline-de-jenkins/)
