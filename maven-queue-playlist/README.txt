

 Descripción General

Este proyecto implementa un sistema de reproducción de canciones utilizando una **estructura de datos de cola propia**, desarrollada manualmente sin usar estructuras del JDK como `Queue`, `LinkedList` o `ArrayDeque`.

El sistema está organizado como un **proyecto Maven multi-módulo**, compuesto por:

* **umg.edu.gt.data-structure.queue** → Librería de cola personalizada
* **queueHandler** → Aplicación que simula la reproducción de canciones





# 🧱 Cómo compilar el proyecto desde consola (PASO A PASO)

## 1️⃣ Abrir la consola (CMD)

Ir a la carpeta raíz del proyecto:


cd C:\Users\TU_USUARIO\eclipse-workspace\maven-queue-playlist
```

 Compilar todo el proyecto (multi-módulo)


mvn clean install
```

Este comando realiza:

* Limpieza de compilaciones anteriores
* Compilación de la librería
* Compilación del handler
* Creación de archivos `.jar`
* Instalación en el repositorio Maven local

Si todo está correcto, aparecerá:

```text
BUILD SUCCESS
```

---

Cómo instalar la librería en local

La instalación se hace automáticamente con:

```bash
mvn clean install
```

Después de ejecutar, la librería queda disponible en:

```text
C:\Users\TU_USUARIO\.m2\repository\
```

Esto permite que otros proyectos Maven puedan usarla como dependencia.

---

 Cómo compilar solo el handler

mvn -pl queueHandler -am clean package
```

Parámetros:

* `-pl` → módulo específico
* `-am` → compila dependencias necesarias automáticamente

---

# 🚀 Cómo ejecutar desde consola

Primero compilar:


mvn clean install
```

Luego ejecutar desde Eclipse:

```text
Main.java → Run As → Java Application
```



 Explicación del Diseño

El sistema fue diseñado siguiendo principios de:

* Encapsulamiento
* Separación de responsabilidades
* Programación orientada a objetos
* Complejidad temporal eficiente O(1)



* `Queue<T>`
* `LinkedQueue<T>`
* `Node<T>`
* `EmptyQueueException`



Clases principales:

* `Song`
* `PlaylistPlayer`
* `Main`

Responsabilidades:

* Gestión de canciones
* Sistema de prioridad
* Simulación de reproducción
* Estadísticas de ejecución

---

Decisiones Técnicas que hice:

1. **Uso de nodos enlazados**

   * Permite operaciones O(1)
   * Cumple restricciones del proyecto

2. **Separación en módulos Maven**

   * Librería reutilizable
   * Handler independiente

3. **Colas internas para prioridad**

   * Evita uso de PriorityQueue
   * Mantiene FIFO interno

4. **Simulación con Thread.sleep**

   * Permite reproducción realista segundo a segundo

5. **Contadores internos**

   * Permiten estadísticas del sistema

---

Cómo implementé la prioridad:

La prioridad se implementó utilizando **dos colas internas independientes**:

```
highQueue   → prioridad 1 (alta)
normalQueue → prioridad 2 (normal)
```

Algoritmo:

```
Si highQueue NO está vacía:
    reproducir de highQueue
Sino:
    reproducir de normalQueue
```

Garantiza:

✔ Prioridad correcta
✔ FIFO dentro de cada prioridad
✔ Complejidad O(1)
✔ Sin uso de PriorityQueue

---

# ⏱️ Cómo manejé la simulación de duración

La reproducción se simuló utilizando:

```java
Thread.sleep(1000);
```

Por cada segundo:

1. Se imprime progreso
2. Se actualiza contador de tiempo
3. Se muestra barra de progreso visual



Esto genera una simulación realista del paso del tiempo.

---

Extensiones Implementadas

* Barra de progreso visual
* Contador total de canciones reproducidas
* Tiempo total acumulado reproducido




