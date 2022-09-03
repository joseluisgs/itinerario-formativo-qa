# Documentación ampliada sobre Kubernetes (k8s)

## Elementos de un sistema de kubernetes

### Master

Se trata del nodo que toma las decisiones de orquestación de los workers. Este nodo ejecuta las ordenes de despliegues y se encarga de ordenar a los workers el trabajo a realizar.

Existen distintos tipos de nodo Master.

Para una gestión correcta de nuestro cluster de Kubernetes necesitaríamos:

- **Cluster store (etcd):** Permite almacenar el estado del cluster y su configuración.
- **Kube-controller-manager:** Es un controlador de controladores. Ejecuta hilos que gestionan tareas en el cluster. Cada controlador es un proceso separado. Está compilado como un binario y ejecutado en un solo proceso.
- **Kube-scheduler:** Monitoriza el apiserver por nuevos pods y asigna trabajo a los nuevos pods.

### Worker

También llamados esclavos o minions, son los encargados de ejecutar las tareas ordenadas por los masters. Estos tipos de nodos deben ser controlados mediante los siguientes elementos:

- **Kubelet:** Monitoriza el apiserver del master, instancia los pods e informa al master del estado de los pods.
- **Motor de contenedores:** Permite gestionar los contenedores. Descarga sus imágenes, inicia o para los contenedores...
- **Kube-proxy:** Elemento para definir la red de un pod. Con él, se permite el balance de carga en la red.

### Pods

Un pod es la unidad más pequeña de Kubernetes. Tanto los masters como los workers/nodos están compuestos por pods.
Los pods pueden tener un contenedor por pod (caso más común) o varios contenedores por pod (uso más avanzado).

#### Estados de un pod

Un pod puede tener uno de los siguientes estados:

- **Pending:** Pendiente de iniciar todos sus componentes. El pod ha sido aceptado por el sistema pero alguno de sus contenedores aún no ha sido creado.
- **Succeeded/failed:** Destruido, ya sea correcto o por un fallo, no se intenta reactivar, se crea un
pod nuevo.
- **Running:** En este estado el pod ha sido vinculado exitosamente a un nodo del cluster. El pod se encuentra en ejecución.
- **Unknown:** No se puede obtener la información del pod. Puede deberse a la comunicación del pod con el host.
- **Terminating:** El pod está siendo eliminado.
- **ContainerCreating:** El contenedor del pod está siendo creado.

#### Tipos de pods

Existen varios tipos de pods. En función del tipo de pod que se crea puede realizar unas funciones u otras. Los distintos tipos de pods que pueden crearse son los siguientes:

- **Services:** Permiten gestionar las comunicaciones entre los pods.
- **ReplicationControllers:** Permiten escalar los pods y definir su forma. Son los elementos encargados de la escalabilidad de los pods. Crean, eliminan o modifican el número de replicas.
- **Deployments:** Contiene las funcionalidades de los ReplicationControllers. Se trata de las instrucciones definidas para la gestión de los pods.
- **ReplicaSet:** Son ReplicationCrontollers más avanzados, la única diferencia es el tipo de selector. No solo admite selectores basados en igualdad sino también conjunto, gracias a la opción de etiquetar en función de niveles (matchLabels). Asegura que siempre se ejecute un número de réplicas de un pod determinado. Por lo tanto, nos asegura que un conjunto de pods siempre están funcionando y disponibles.

![Kubernetes_nodos.png](/img/qa/training-plan/avanzado/Kubernetes_nodo.png)

## Instalación

Para gestionar de forma eficaz una arquitectura de kubernetes, los elementos mínimos de los que debemos disponer son tres nodos. Un máster y dos workers.
Para su correcta gestión necesitaremos:

- ***Docker***: Gestor de contenedores. Es necesario tener instalado docker para poder instalar Kubernetes.
- ***Virtual Box***: Es necesario disponer de un driver de virtualización. Virtual Box nos ofrece enlazar la virtualización del anfitrión con el sistema operativo en el que queramos instalar Kubernetes.
- ***Kubectl***: Es un cliente de kubernetes. Sirve para interactuar con él. Mediante este recurso creamos, eliminamos, monitorizamos... nuestro cluster. [Como instalar Kubectl.](https://kubernetes.io/es/docs/tasks/tools/install-kubectl/)
- ***Minikube***: Es una versión reducida de Kubernetes, corriendo en una única máquina virtual, la cual actúa de maestro y esclavos a la vez. En caso de no querer instalar Minikube, existe ***kubeadm***. [Como instalar Minikube.](https://kubernetes.io/es/docs/tasks/tools/install-minikube)

Se recomienda la instalación a través de los binarios y no mediante repositorios, ya que con los binarios especificamos y controlamos la versión que vamos a instalar.

En función del sistema operativo en el que alojemos Kubernetes, necesitaremos un driver de virtualización u otro. Para Linux, podemos utilizar KVM, para Mac Catalina existe HyperKit y para Windows Hyper-V (en caso de venir deshabilitado habilitar en Características de Windows). También podemos utilizar como drivers programas como Virtual Box, VMWare, etc.

Creación de un pod con un contenedor
En este caso, se trata de alojar una imagen de nginx en uno de los pods de kubernetes.
A través del archivo deployment (también llamado archivo de manifiesto) establecemos la configuración que adoptará nuestro pod.

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-pod-inside-namespace
spec:
  containers:
    - name: nginx-my-pod-inside-namespace
      image: nginx:latest
      ports:
        - containerPort: 80
```

Para aplicar la configuración de un deployment:

```bash
kubectl apply -f <deployment.yaml>
```

Una vez creado el pod, para listarlo:

```bash
kubectl get <pods>
```

Para disponer de la información asociada a un elemento en kubernetes:

```bash
kubectl describe <pod>
```

Para observar lo que ocurre dentro de un pod:

```bash
kubectl logs <pod>
```

Para mantenernos a la escucha de lo que ocurre dentro de un pod:

```bash
kubectl attach <pod>
kubectl logs -f <pod>
```

Podemos conectar y redireccionar un pod con nuestro equipo a través de los puertos disponibles por nuestro sistema. Esto se realiza mediante:

```bash
kubectl port-forward <pod> <puerto>:<puerto>
```

Para eliminar cualquier elemento de Kubernetes, en este caso un pod:

```bash
kubectl delete pod <pod>
```

## Namespace

Un namespace es un cluster virtual que puede compartir espacio dentro de un cluster general con otros namespaces. Las replicas entre namespaces pueden ser distintas o similares. Son utilizadas para aislar entornos dentro de una misma distribución de Kubernetes.

El objetivo de los namespaces es separar entornos y poder replicarlos de forma independiente.

La iteración con este tipo de elementos es similar a la anterior vista para los pods. Se crean, modifican, listan o eliminan con los mismos comandos cambiando el tipo de elemento (en este caso cambiar pod por namespace).

Para listar nuestros namespaces se realiza con el siguiente comando:

```bash
kubectl get ns <namespace>
```

Y para comprobar el yaml de configuración de uno de ellos:

```bash
kubectl get ns <namespace> -o yaml
```

Yaml de un namespace:

```yaml
apiVersion: v1
kind: Namespace
metadata:
  creationTimestamp: "2020-02-14T08:57:40Z"
  name: test-qa
  resourceVersion: "150"
  selfLink: /api/v1/namespaces/default
  uid: cfc25194-dbcb-4b10-abfa-90c40278af99
spec:
  finalizers:
    - kubernetes
status:
  phase: Active
```

## Secrets

Los secrets en kubernetes son elementos donde podemos almacenar información sensible al usuario, como contraseñas, tokens, claves ssh, etc.
Para que un Pod pueda utilizar un secret, este debe de hacerle referencia al mismo.
Un secrets puede utilizarse a través de kubelet, cuando inicia la secuencia de descarga para crear los Pods que a su vez tendrán dentro contenedores donde se alojan los secrets.

Por ejemplo, imaginemos que queremos poner como valor de la clave la siguiente secuencia de caracteres "S!B\*d$zDsb".
Se realizaría de la siguiente forma:

```bash
kubectl create secret generic <name-secret> –from-literal=password=S\!B\\*d\$zDsb
```

[Como añadir información a un secret.](https://kubernetes.io/docs/concepts/configuration/secret/#using-secrets)

Y a continuación, creamos el secret ligado a la anterior clave (en Base64):

```bash
kubectl create secret generic <name-secret> --from-file=./username.txt --from-file=./password.txt
```

Los parámetros ***`<from-file>`*** son las rutas de los archivos que queremos introducir al secret.
Para cargar varios pares clave-valor en un objeto secret, debes almacenar los pares clave-valor en uno o más archivos de texto sin formato y cargarlos con ***`<--from-env-file>`***, en lugar de ***`<--from-file>`***. [Más información sobre los secrets.](https://cloud.google.com/kubernetes-engine/docs/concepts/secret?hl=es-419)

Los secrets también pueden ser listados o descritos como los demas elementos de Kubernetes (nodos, namespaces, pods, ....)

```bash
kubectl get secrets
kubectl describe secrets
```

Ejemplo de Secret:

```yaml
apiVersion: v1
kind: Secret
metadata:
  name: mysecret
type: Opaque
data:
  username: YWRtaW4=
  pasword: MWYyZDFlMmU2N2Rm
```
