# Proyecto Final - Desarrollo Web con Java Spring

**Integrantes del grupo:**

- José Jesús Céspedes Rivera - 20211020118  
- Sofía Lozano Martínez - 20211020088  
- Juan Andrés González González - 20191020153

Este proyecto corresponde a una aplicación backend desarrollada con **Spring Boot**, orientada a la gestión de un sistema hotelero. Contiene múltiples entidades que representan diferentes aspectos del sistema, como clientes, reservas, hoteles, facturas, entre otros.

Se hicieron cambios en la base de datos considerando errores posibles de diseños. Los cambios se hicieron para mentener la cohesion de las entidades del problema. 
Se eliminaron tres claves foráneas mal definidas en la tabla usuario. En su lugar, se establecieron correctamente relaciones de dependencia desde las tablas administrador, cliente y empleado hacia usuario.

## Entidades y Rutas Base de los Controladores

A continuación se listan las rutas base (URL) correspondientes a cada controlador de entidad:

| Entidad              | URL Base del Controlador         |
|----------------------|----------------------------------|
| Administrador        | `/administradores`              |
| Reserva              | `/reservas`                     |
| Cliente              | `/clientes`                     |
| Empleado             | `/empleado`                     |
| Factura              | `/facturas`                     |
| Habitación           | `/habitaciones`                 |
| Hotel                | `/hoteles`                      |
| Pago                 | `/pagos`                        |
| Tipo de Habitación   | `/tipos-habitacion`             |
| Usuario              | `/usuario`                      |

Cada uno de estos endpoints es manejado por su respectivo controlador dentro del paquete de controladores de la aplicación.


# Algunos Endpoints

## 📚 Endpoints - Cliente

### ➤ Listar todos los clientes

- **Método:** GET  
- **URL:** `/clientes`  
- **Descripción:** Devuelve la lista de todos los clientes registrados.  
- **Ejemplo de respuesta:**

```json
[
  {
    "idCliente": 1,
    ...
  },
  {
    "idCliente": 2,
    ...
  }
]
```

---

### ➤ Obtener cliente por ID

- **Método:** GET  
- **URL:** `/clientes/{id}`  
- **Descripción:** Devuelve el cliente con el ID especificado.  
- **Ejemplo de respuesta:**

```json
{
  "idCliente": 1,
  "primerNombre": "Pedro",
  "segundoNombre": "Luis",
  "primerApellido": "García",
  "segundoApellido": "Rodríguez",
  "cedula": 123456789,
  "direccion": "Calle 10 #5-20"
}
```

---

### ➤ Crear un nuevo cliente

- **Método:** POST  
- **URL:** `/clientes`  
- **Descripción:** Registra un nuevo cliente.  
- **Ejemplo de request body:**

```json
{
  "idCliente": 2,
  "primerNombre": "Laura",
  "segundoNombre": "Marcela",
  "primerApellido": "López",
  "segundoApellido": "Martínez",
  "cedula": 987654321,
  "direccion": "Carrera 15 #45-12"
}
```

---

### ➤ Actualizar un cliente

- **Método:** PUT  
- **URL:** `/clientes/{id}`  
- **Descripción:** Actualiza la información de un cliente existente.  
- **Ejemplo de request body:**

```json
{
  "primerNombre": "Laura",
  "segundoNombre": "Marcela",
  "primerApellido": "López",
  "segundoApellido": "Martínez",
  "cedula": 987654321,
  "direccion": "Carrera 15 #99-88"
}
```

---

### ➤ Eliminar un cliente

- **Método:** DELETE  
- **URL:** `/clientes/{id}`  
- **Descripción:** Elimina el cliente con el ID especificado.  
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

## 📚 Endpoints - Administrador

### ➤ Listar todos los administradores

- **Método:** GET  
- **URL:** `/administradores`  
- **Descripción:** Devuelve la lista de todos los administradores registrados.  
- **Ejemplo de respuesta:**

```json
[
  {
    "idAdministrador": 1,
    ...
  },
  {
    "idAdministrador": 2,
    ...
  }
]
```

---

### ➤ Obtener administrador por ID

- **Método:** GET  
- **URL:** `/administradores/{id}`  
- **Descripción:** Devuelve el administrador con el ID especificado.  
- **Ejemplo de respuesta:**

```json
{
  "idAdministrador": 1,
  "primerNombre": "Juan",
  "segundoNombre": "Carlos",
  "primerApellido": "Pérez",
  "segundoApellido": "Gómez",
  "correo": "juan.perez@hotel.com",
  "telefono": "1234567890"
}
```

---

### ➤ Crear un nuevo administrador

- **Método:** POST  
- **URL:** `/administradores`  
- **Descripción:** Registra un nuevo administrador.  
- **Ejemplo de request body:**

```json
{
  "idAdministrador": 2,
  "primerNombre": "Ana",
  "segundoNombre": "María",
  "primerApellido": "Ramírez",
  "segundoApellido": "López",
  "correo": "ana.ramirez@hotel.com",
  "telefono": "0987654321"
}
```

---

### ➤ Actualizar un administrador

- **Método:** PUT  
- **URL:** `/administradores/{id}`  
- **Descripción:** Actualiza la información de un administrador existente.  
- **Ejemplo de request body:**

```json
{
  "primerNombre": "Ana",
  "segundoNombre": "María",
  "primerApellido": "Ramírez",
  "segundoApellido": "López",
  "correo": "ana.ramirez@hotel.com",
  "telefono": "0987654321"
}
```

---

### ➤ Eliminar un administrador

- **Método:** DELETE  
- **URL:** `/administradores/{id}`  
- **Descripción:** Elimina el administrador con el ID especificado.  
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

## 📚 Endpoints - TipoHabitacion

### ➤ Listar todos los tipos de habitación

- **Método:** GET  
- **URL:** `/tipos-habitacion`  
- **Descripción:** Devuelve la lista de todos los tipos de habitación registrados.  
- **Ejemplo de respuesta:**

```json
[
  {
    "idTipoHabitacion": 1,
    ...
  },
  {
    "idTipoHabitacion": 2,
    ...
  }
]
```

---

### ➤ Obtener tipo de habitación por ID

- **Método:** GET  
- **URL:** `/tipos-habitacion/{id}`  
- **Descripción:** Devuelve el tipo de habitación con el ID especificado.  
- **Ejemplo de respuesta:**

```json
{
  "idTipoHabitacion": 1,
  "hotel": {
    "idHotel": 1,
    ...
  },
  "nombre": "Suite",
  "cantidad": 10
}
```

---

### ➤ Crear un nuevo tipo de habitación

- **Método:** POST  
- **URL:** `/tipos-habitacion`  
- **Descripción:** Registra un nuevo tipo de habitación.  
- **Ejemplo de request body:**

```json
{
  "idTipoHabitacion": 2,
  "hotel": {
    "idHotel": 1
  },
  "nombre": "Habitación Doble",
  "cantidad": 20
}
```

---

### ➤ Actualizar un tipo de habitación

- **Método:** PUT  
- **URL:** `/tipos-habitacion/{id}`  
- **Descripción:** Actualiza la información de un tipo de habitación existente.  
- **Ejemplo de request body:**

```json
{
  "hotel": {
    "idHotel": 1
  },
  "nombre": "Habitación Doble",
  "cantidad": 25
}
```

---

### ➤ Eliminar un tipo de habitación

- **Método:** DELETE  
- **URL:** `/tipos-habitacion/{id}`  
- **Descripción:** Elimina el tipo de habitación con el ID especificado.  
- **Respuesta:** `204 No Content` si se elimina correctamente.

---


