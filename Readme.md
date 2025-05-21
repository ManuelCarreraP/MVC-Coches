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