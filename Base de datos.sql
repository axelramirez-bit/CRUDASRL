CREATE DATABASE ejemplo1;
USE ejemplo1;

CREATE TABLE usuarios(
    id INT,
    usuario VARCHAR(30),
    pass VARCHAR(30)
);

INSERT INTO usuarios (id, usuario, pass) VALUES (1, 'dilan', '123');
INSERT INTO usuarios (id, usuario, pass) VALUES (2, 'suy', '12345');

SELECT * FROM usuarios;