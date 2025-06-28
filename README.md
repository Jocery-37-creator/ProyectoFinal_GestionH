# Taller 2 - Desarrollo Web con Java Spring

**Integrantes del grupo:**

- José Jesús Céspedes Rivera - 20211020118  
- Sofía Lozano Martínez - 20211020088  
- Juan Andrés González González - 20191020153


## ENDPOINTS

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


