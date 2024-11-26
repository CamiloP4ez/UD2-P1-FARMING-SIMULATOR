
# Simulación de Granjeros y Clientes en un Restaurante Vegano
## Integranes: Álvaro Negrin y Camilo Paez
Este proyecto simula una interacción entre un **granjero** que produce **verduras** y un **cliente** que las consume en un **restaurante vegano**. Utiliza hilos para manejar las acciones concurrentes de la producción y consumo de verduras, abordando la sincronización de recursos compartidos mediante el uso de métodos sincronizados y el control de la disponibilidad de espacio en el almacén del restaurante.

## Descripción

En este sistema, el **granjero** produce verduras y las coloca en el almacén del restaurante, mientras que el **cliente** consume las verduras disponibles en el almacén. El restaurante tiene una capacidad limitada de verduras, y tanto el granjero como el cliente deben esperar cuando el almacén está lleno o vacío, respectivamente. Los hilos de los granjeros y clientes se gestionan para simular este comportamiento.

## Clases

### `App.java`

Es la clase principal que arranca el programa. Se crean los objetos del restaurante, granjero y cliente, y se ejecutan los hilos correspondientes:

- **Granjero (Farmer)**: Produce verduras y las coloca en el almacén del restaurante.
- **Cliente (Customer)**: Consume las verduras del almacén.

### `Restaurant.java`

Esta clase representa el restaurante donde se almacenan las verduras. Los métodos clave incluyen:

- `addVegetable(String vegetable, String name)`: Método sincronizado que permite al granjero agregar una verdura al almacén. Si no hay espacio, el granjero espera hasta que haya espacio disponible.
- `eatVegetable(String name)`: Método sincronizado que permite al cliente consumir una verdura del almacén. Si el almacén está vacío, el cliente espera hasta que haya verduras disponibles.
- `availableSpace()`: Devuelve el número de espacios vacíos en el almacén del restaurante.

## Flujo del Programa

1. El **restaurante** se inicializa con un tamaño de almacén de 5 espacios.
2. El **granjero Paco** comienza a producir verduras (en este caso, el nombre del granjero es "PACO" y produce 10 verduras).
3. El **cliente Rubén** empieza a consumir las verduras disponibles (el nombre del cliente es "PEPE" y consume 10 verduras).
4. Ambos hilos, el del granjero y el cliente, se inician con diferentes prioridades:
   - El **granjero** tiene la **prioridad mínima** (`Thread.MIN_PRIORITY`).
   - El **cliente** tiene la **prioridad máxima** (`Thread.MAX_PRIORITY`).
5. Los hilos de **granjero** y **cliente** se gestionan mediante `join()` para asegurarse de que ambos terminen antes de que el programa termine.

## Salida Esperada

La salida de este programa depende de la ejecución concurrente de los hilos, pero el comportamiento esperado es el siguiente:

1. El granjero producirá verduras y las almacenará en el restaurante hasta que el almacén esté lleno. Mientras tanto, si no hay espacio en el almacén, el granjero esperará.
2. El cliente intentará consumir las verduras. Si el almacén está vacío, el cliente esperará hasta que haya verduras disponibles.
3. Los mensajes en la consola mostrarán la interacción entre el granjero y el cliente, como por ejemplo:
   - "El granjero PACO espera, no hay espacio disponible"
   - "Se ha producido una nueva verdura [nombre de la verdura] por el granjero PACO"
   - "El cliente PEPE ha consumido [nombre de la verdura]"
   - "El cliente PEPE espera, no hay verduras para consumir"

## Ejemplo de Salida

