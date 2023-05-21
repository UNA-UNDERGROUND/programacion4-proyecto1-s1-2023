create schema polizas;
use polizas;

create table credenciales
(
    identificacion varchar(20) not null,
    password       varchar(20) not null
);

create table clientes
(
    identificacion varchar(20) not null,
    nombre         varchar(50) not null,
    apellidos      varchar(50) not null,
    telefono       varchar(20) not null,
    correo         varchar(50) not null
);

create table medio_pago
(
    id                int         not null, -- autoincrement
    id_cliente        varchar(20) not null,
    numero_tarjeta    varchar(20) not null,
    nombre_titular    varchar(50) not null,
    fecha_vencimiento date        not null,
    cvv               varchar(4)  not null
);

create table polizas_vehiculo
(
    id_cliente            varchar(20)    not null,
    id_poliza             int            not null, -- autoincrement
    placa_vehiculo        varchar(20)    not null,
    id_categoria_vehiculo int            not null, -- tabla donde se encuentra la marca, modelo y año del vehiculo
    valor_asegurado       decimal(10, 4) not null,
    fecha_inicio          date           not null,
    plazo_pago            varchar(1)     not null  -- (T) trimestral, (S) semestral, (A) anual
);

create table categoria_vehiculo
(
    id_categoria_vehiculo int         not null, -- autoincrement
    marca                 varchar(50) not null,
    modelo                varchar(50) not null,
    serie                 int         not null  -- año del vehiculo
);

create table categoria_cobertura
(
    id_categoria int          not null, -- autoincrement
    nombre       varchar(50)  not null,
    descripcion  varchar(250) not null
);

create table cobertura
(
    id_cobertura     int            not null, -- autoincrement
    id_categoria     int            not null,
    nombre           varchar(50)    not null,
    descripcion      varchar(250)   not null,
    valor_minimo     decimal(10, 4) not null,
    valor_porcentaje decimal(3, 2)  not null
);

-- tabla muchos a muchos
create table poliza_cobertura
(
    id_poliza    int not null,
    id_cobertura int not null
);


-- restricciones

-- primary keys
alter table credenciales
    add constraint pk_credenciales
        primary key (identificacion);

alter table medio_pago
    add constraint pk_medio_pago
        primary key (id);

alter table clientes
    add constraint pk_clientes
        primary key (identificacion);

alter table polizas_vehiculo
    add constraint pk_polizas_vehiculo
        primary key (id_poliza);

alter table categoria_vehiculo
    add constraint pk_categoria_vehiculo
        primary key (id_categoria_vehiculo);

alter table categoria_cobertura
    add constraint pk_categoria_cobertura
        primary key (id_categoria);

alter table cobertura
    add constraint pk_cobertura
        primary key (id_cobertura);

alter table poliza_cobertura
    add constraint pk_poliza_cobertura
        primary key (id_poliza, id_cobertura);

-- autoincrement
alter table medio_pago
    modify id int auto_increment;

alter table polizas_vehiculo
    modify id_poliza int auto_increment;

alter table categoria_vehiculo
    modify id_categoria_vehiculo int auto_increment;

alter table categoria_cobertura
    modify id_categoria int auto_increment;

alter table cobertura
    modify id_cobertura int auto_increment;


-- unique
-- el medio de pago es unico por cliente, tarjeta, 
-- ya que una tarjeta puede ternerla mas de un cliente
-- pero el cliente no puede tenerla duplicada
alter table medio_pago
    add constraint uk_medio_pago
        unique (id_cliente, numero_tarjeta);

alter table categoria_vehiculo
    add constraint uk_categoria_vehiculo
        unique (marca, modelo, serie);

-- foreign keys

alter table clientes
    add constraint fk_clientes_credenciales
        foreign key (identificacion)
            references credenciales (identificacion);

alter table medio_pago
    add constraint fk_medio_pago_clientes
        foreign key (id_cliente)
            references clientes (identificacion);

alter table polizas_vehiculo
    add constraint fk_polizas_vehiculo_clientes
        foreign key (id_cliente)
            references clientes (identificacion);

alter table polizas_vehiculo
    add constraint fk_polizas_vehiculo_categoria_vehiculo
        foreign key (id_categoria_vehiculo)
            references categoria_vehiculo (id_categoria_vehiculo);

alter table cobertura
    add constraint fk_cobertura_categoria_cobertura
        foreign key (id_categoria)
            references categoria_cobertura (id_categoria);

alter table poliza_cobertura
    add constraint fk_poliza_cobertura_polizas_vehiculo
        foreign key (id_poliza)
            references polizas_vehiculo (id_poliza);

alter table poliza_cobertura
    add constraint fk_poliza_cobertura_cobertura
        foreign key (id_cobertura)
            references cobertura (id_cobertura);
