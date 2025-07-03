/* ============================================================
   1. TABLAS BÁSICAS
   ============================================================ */
CREATE TABLE usuario
(
    id_usuario     SERIAL PRIMARY KEY,
    nombre_usuario VARCHAR(255) UNIQUE NOT NULL,
    contrasena     VARCHAR(255)        NOT NULL,
    rol            VARCHAR(30)         NOT NULL
);

CREATE TABLE hotel
(
    id_hotel  SERIAL PRIMARY KEY,
    nombre    VARCHAR(30)  NOT NULL,
    ciudad    VARCHAR(20)  NOT NULL,
    telefono  VARCHAR(10)  NOT NULL,
    correo    VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);

/* ============================================================
   2. TABLAS PERFIL (1 : 1 con USUARIO)
   ============================================================ */
CREATE TABLE administrador
(
    id_administrador SERIAL PRIMARY KEY,
    primer_nombre    VARCHAR(50)    NOT NULL,
    segundo_nombre   VARCHAR(50),
    primer_apellido  VARCHAR(50)    NOT NULL,
    segundo_apellido VARCHAR(50),
    correo           VARCHAR(100)   NOT NULL,
    telefono         VARCHAR(10)    NOT NULL,
    fk_id_usuario    INTEGER UNIQUE NOT NULL,
    CONSTRAINT administrador_fk_usuario
        FOREIGN KEY (fk_id_usuario)
            REFERENCES usuario (id_usuario)
            ON DELETE CASCADE
);

CREATE TABLE cliente
(
    id_cliente       SERIAL PRIMARY KEY,
    primer_nombre    VARCHAR(50)    NOT NULL,
    segundo_nombre   VARCHAR(50),
    primer_apellido  VARCHAR(50)    NOT NULL,
    segundo_apellido VARCHAR(50),
    cedula           INTEGER UNIQUE NOT NULL,
    direccion        VARCHAR(150)   NOT NULL,
    fk_id_usuario    INTEGER UNIQUE NOT NULL,
    CONSTRAINT cliente_fk_usuario
        FOREIGN KEY (fk_id_usuario)
            REFERENCES usuario (id_usuario)
            ON DELETE CASCADE
);

CREATE TABLE empleado
(
    id_empleado      SERIAL PRIMARY KEY,
    correo           VARCHAR(100),
    telefono         VARCHAR(10)    NOT NULL,
    primer_nombre    VARCHAR(50)    NOT NULL,
    segundo_nombre   VARCHAR(50),
    primer_apellido  VARCHAR(50)    NOT NULL,
    segundo_apellido VARCHAR(50),
    fk_id_usuario    INTEGER UNIQUE NOT NULL,
    CONSTRAINT empleado_fk_usuario
        FOREIGN KEY (fk_id_usuario)
            REFERENCES usuario (id_usuario)
            ON DELETE CASCADE
);

/* ============================================================
   3. DEMÁS ENTIDADES
   ============================================================ */
CREATE TABLE tipo_habitacion
(
    id_tipo_habitacion SERIAL PRIMARY KEY,
    fk_id_hotel        INTEGER NOT NULL,
    nombre             VARCHAR(100),
    cantidad           INTEGER,
    CONSTRAINT tipo_habitacion_fk_hotel
        FOREIGN KEY (fk_id_hotel)
            REFERENCES hotel (id_hotel)
            ON DELETE RESTRICT
);

CREATE TABLE habitacion
(
    id_habitacion         SERIAL PRIMARY KEY,
    numero_habitacion     INTEGER NOT NULL,
    fk_id_tipo_habitacion INTEGER NOT NULL,
    precio_dia            INTEGER NOT NULL,
    disponible            BOOLEAN,
    fk_id_hotel           INTEGER NOT NULL,
    CONSTRAINT habitacion_fk_tipo
        FOREIGN KEY (fk_id_tipo_habitacion)
            REFERENCES tipo_habitacion (id_tipo_habitacion)
            ON DELETE RESTRICT,
    CONSTRAINT habitacion_fk_hotel
        FOREIGN KEY (fk_id_hotel)
            REFERENCES hotel (id_hotel)
            ON DELETE CASCADE,
    /* Unicidad por hotel y número */
    CONSTRAINT habitacion_unique_num
        UNIQUE (fk_id_hotel, numero_habitacion)
);

CREATE TABLE reserva
(
    id_reserva       SERIAL PRIMARY KEY,
    fecha_inicio     TIMESTAMP,
    fecha_final      TIMESTAMP,
    cantidad_dias    INTEGER,
    estado           BOOLEAN,
    fecha_reserva    TIMESTAMP,
    fk_id_habitacion INTEGER NOT NULL,
    fk_id_cliente    INTEGER NOT NULL,
    CONSTRAINT reserva_fk_habitacion
        FOREIGN KEY (fk_id_habitacion)
            REFERENCES habitacion (id_habitacion)
            ON DELETE RESTRICT,
    CONSTRAINT reserva_fk_cliente
        FOREIGN KEY (fk_id_cliente)
            REFERENCES cliente (id_cliente)
            ON DELETE RESTRICT
);

CREATE TABLE pago
(
    id_pago       SERIAL PRIMARY KEY,
    fecha         TIMESTAMP NOT NULL,
    fk_id_reserva INTEGER,
    metodo_pago   VARCHAR(20),
    pago_total    INTEGER,
    CONSTRAINT pago_fk_reserva
        FOREIGN KEY (fk_id_reserva)
            REFERENCES reserva (id_reserva)
            ON DELETE SET NULL
);

CREATE TABLE factura
(
    id_factura    SERIAL PRIMARY KEY,
    fk_id_reserva INTEGER,
    fk_id_pago    INTEGER,
    fecha_emision TIMESTAMP,
    valor_total   INTEGER,
    CONSTRAINT factura_fk_reserva
        FOREIGN KEY (fk_id_reserva)
            REFERENCES reserva (id_reserva)
            ON DELETE SET NULL,
    CONSTRAINT factura_fk_pago
        FOREIGN KEY (fk_id_pago)
            REFERENCES pago (id_pago)
            ON DELETE SET NULL
);
