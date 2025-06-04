# Exámen 2: Observer

## Funcionalidades
- Sistema de consumo de gasolina al avanzar
- Alerta automática cuando la gasolina baja de 10 litros

### Nuevas Características (Observer Pattern)

### Alarma de Gasolina Baja
Se ha implementado un sistema de notificaciones que:
1. Monitoriza el nivel de gasolina de todos los coches
2. Muestra una alerta automática cuando la gasolina baja de 10 litros
3. Identifica el coche afectado por su matrícula

### Estructura del Observer
1. **GasolinaObserver**: Interfaz para los observadores
2. **AlarmaGasolinaBaja**: Implementación concreta que muestra las alertas
3. **Coche**: Clase observable que notifica cambios en la gasolina

## Diagrama de Secuencia
```mermaid
sequenceDiagram
    participant View
    participant Controller
    participant Model
    participant Coche
    participant AlarmaGasolinaBaja
    
    View->>Controller: avanzar(matricula, kilometros)
    Controller->>Model: avanzar(matricula, kilometros)
    Model->>Coche: getCoche(matricula)
    Coche-->>Model: coche
    Model->>Coche: setGasolina(nueva cantidad)
    Coche->>AlarmaGasolinaBaja: actualizar(matricula, gasolina)
    alt gasolina < 10 litros
        AlarmaGasolinaBaja->>View: "Alerta: Repostar"
        View->>Usuario: Muestra alerta
    end
    Model-->>Controller: true/false
    Controller-->>View: true/false
    View-->>Usuario: Muestra resultado
```
## Comprobación:
### Primero creamos un nuevo coche como ejemplo y le añadimos 50L de gasolina
![Comprobacion 1](./1.png)
### Le Pedimos que avance 450km, y teniendo en cuenta que va a 100km/h y tiene un consumo de 10L cada 100km salta la alarma
![Comprobacion 2](./2.png)

---
---
# Examen 1: MVC
### 1. Nuevo Atributo: Gasolina
Añadido gasolina a la clase Coche para controlar el combustible.

Todos los coches nuevos empiezan con 0 litros.

### 2. Funcionalidades Nuevas
Opción 4: Avanzar
Qué hace: Mueve el coche una distancia en metros.

Consumo: Gasta gasolina según la fórmula:

consumo = (metros * velocidad) / 1000  
Ejemplo:

Si avanzas 5000m a 60km/h → gasta 3 litros.

Opción 5: Poner Gasolina
Qué hace: Añade combustible al depósito.

Importante: Solo acepta números positivos.

3. Menú Actualizado
1. Crear coche
2. Cambiar velocidad
3. Mostrar coches
4. Avanzar
5. Poner gasolina
0. Salir

# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```

Diagrama con los metodos y funciones de mi programa

```mermaid
sequenceDiagram
    participant App
    participant View
    participant Controller
    participant Model

    App->>View: menu()
    activate View

    %% Flujo creación de coche (Opción 1)
    View->>Controller: crearCoche("Modelo", "Matrícula")
    activate Controller
    Controller->>Model: crearCoche("Modelo", "Matrícula")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>View: "Coche creado correctamente"
    deactivate Controller

    %% Flujo cambio de velocidad (Opción 2)
    View->>Controller: cambiarVelocidad("Matrícula", 120)
    activate Controller
    Controller->>Model: cambiarVelocidad("Matrícula", 120)
    activate Model
    Model-->>Controller: 120
    deactivate Model
    Controller->>View: muestraVelocidad("Matrícula", 120)
    activate View
    View->>View: System.out.println("Matrícula: 120 km/h")
    deactivate View
    deactivate Controller

    %% Flujo mostrar coches (Opción 3)
    View->>Controller: obtenerCoches()
    activate Controller
    Controller->>Model: obtenerCoches()
    activate Model
    Model-->>Controller: ArrayList<Coche>
    deactivate Model
    Controller->>View: mostrarCoches(ArrayList<Coche>)
    activate View
    View->>View: System.out.println("Matrícula: X | Modelo: Y | Velocidad: Z")
    deactivate View
    deactivate Controller

    deactivate View
```
