CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    existencia INT NOT NULL,
    precio DOUBLE NOT NULL,
    fecha_ultimo_ingreso DATE NOT NULL,
    disponible BOOLEAN NOT NULL,
    categoria VARCHAR(255) NOT NULL
);
