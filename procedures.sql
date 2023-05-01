create procedure sp_registrar_usuario(
    IN identificacion varchar(20),
    IN password varchar(20),
    IN nombre varchar(50),
    IN apellidos varchar(50),
    IN telefono varchar(20),
    IN correo varchar(50)
)
BEGIN
    -- disambiguate column names
    DECLARE _identificacion varchar(20) DEFAULT identificacion;
    DECLARE _password varchar(20) DEFAULT password;
    DECLARE _nombre varchar(50) DEFAULT nombre;
    DECLARE _apellidos varchar(50) DEFAULT apellidos;
    DECLARE _telefono varchar(20) DEFAULT telefono;
    DECLARE _correo varchar(50) DEFAULT correo;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
            select FALSE as success;
        END;
    START TRANSACTION;
    INSERT INTO credenciales (identificacion, password)
    VALUES (_identificacion, _password);
    INSERT INTO clientes (identificacion, nombre, apellidos, telefono, correo)
    VALUES (_identificacion, _nombre, _apellidos, _telefono, _correo);
    COMMIT;
    SELECT TRUE as success;
end;