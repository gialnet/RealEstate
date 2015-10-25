--
-- Tetbury Software Services LTD
--
-- SIC 62012 Business and domestic software development

--

-- CREATE USER zayoser PASSWORD 'a1';
-- CREATE DATABASE inmobiliaria OWNER zayoser;


--
-- Crear una base datos para Demo
--
CREATE TABLE datosper
(
    id                  serial NOT NULL,
    tipo_de_cuenta      integer default 1,
    forma_juridica      varchar(60) references datosper_legal(forma_juridica),
    IBAN                varchar(34), -- los dos primeros digitos indican el país ES codigo para españa
    BIC                 varchar(11), -- puede ser de 8 o de 11 posiciones
    CNAE                varchar(25), -- ejemplo: CNAE J6311: Proceso de datos, hosting y actividades relacionadas o SIC que es el código internacional
    fecha_constitucion  date, -- fecha de constitución de la sociedad
    tipo_actividad      varchar(25) default 'empresarial', -- empresarial o profesional
    carga_impositiva    numeric(4,2) default 20,
    sociedades          varchar(2) default 'NO',
    criterio_de_caja    varchar(2) default 'NO', -- para los autonomos y empresas acogidas al criterio de caja no paga IVA hasta el ingreso
    presupuestos        varchar(2) default 'NO',
    fiscal_year         char(4) default EXTRACT(year FROM now()),
    periodo             char(2) default EXTRACT(QUARTER FROM now()),
    irpf_profesionales  numeric(4,2) default 21,
    irpf_alquileres     numeric(4,2) default 21,
    iva                 numeric(4,2) default 21,
    otras_reglas        json,
    EntidadPresenta     varchar(4), -- para las domiciliaciones
    OficinaPresenta     varchar(4), -- para las domiciliaciones
    Sufijo              varchar(3)  default '000', -- para las domiciliaciones
    periodicidad_er     integer default 12, -- periodicidad de la emisión de recibos 12 uno por mes,6 cada 2 meses,4 cade tres meses, 2 cada semestre
    EmiteRemesas        varchar(2) default 'NO',
    nif                 char(20),
    nombre              varchar(60),
    direccion           varchar(90), -- Avenida Europa, 21
    objeto              varchar(40), -- bloque A 2ºD
    poblacion           varchar(90), -- 18690 Almuñécar Granada
    Pais_ISO3166        varchar(2) default 'ES',
    movil               varchar(10),
    fax                 varchar(10),
    mail                varchar(90),
    url_web             varchar(250),
    url_tsa             text,
    escrituras_consti   bytea,
    cero36              bytea
);


insert into datosper (forma_juridica, fiscal_year, periodo, nombre) 
values ('RETA','2014','1','Su nombre comercial');

--
-- Personal Recursos Humanos, además de Recursos humanos externos y colaboradores
-- También representa la tabla de usuarios de la aplicación
--
CREATE TABLE PersonalRRHH       -- Usuarios de la aplicación
(
    id                  serial NOT NULL,
    tipo                varchar(50),    -- tipo de relación con la empresa empleado, freelance, socio, administrador
    IBAN                varchar(34), -- los dos primeros digitos indican el país ES codigo para españa
    BIC                 varchar(11),
    RedSocial           text,   -- URL del usuario de la red social
    email               varchar(90),
    cargo               varchar(50), -- cargo responsabilidad en la empresa
    estudios            varchar(50), -- nivel de estudios
    categoria           varchar(50), -- categoría profesional
    tipo_contrato       varchar(50), -- tipo de contrato
    SalarioBruto        numeric(8,2), -- salario bruto anual
    NumeroPagas         integer default 14,
    nif                 varchar(20),
    Nombre              varchar(90),
    genero              varchar(10), -- hombre mujer male female
    locale              varchar(2), -- es, uk, etc.
    otros_datos         json,
    servicios           json,
    permisos            json default '{"panel":"yes","clientes":"yes","ventas":"yes","proveedores":"yes","compras":"yes","nominas":"no","bancos":"no","contabilidad":"no"}'::json,
    fecha_nacimiento    date,
    estado_civil        varchar(25),
    fecha_alta          date,
    fecha_baja          date,
    hijos               integer,
    asucargo            integer,
    contrato            bytea,
    certificado         bytea,
    fecha_orden_sepa        date,
    referencia_mandato      varchar(35),
    orden_sepa              bytea, -- orden de domiciliación en formato SEPA
    primary key (id)
);


--INSERT INTO PersonalRRHH (nif, nombre, cargo, tipo, email) 
--    VALUES ('23781553J','Antonio Pérez Caballero','Responsable de producto', 'socio','antonio@redmoon.es');

--INSERT INTO PersonalRRHH (nif, nombre, cargo, tipo, email) 
--    VALUES ('23781554J','Sara Pérez Fajardo','Administración, publicidad y diseño', 'socio','sara@redmoon.es');


INSERT INTO PersonalRRHH (tipo) 
    VALUES ('administrador');

--INSERT INTO PersonalRRHH (nif, nombre, cargo, tipo, email) 
--    VALUES ('23781555J','�?ngel Luis García Sánchez','Desarrollo Java', 'empleado','angel@redmoon.es');


--
-- Los distintos tipos de clientes en función de su residencia y consideraciones
-- especiales tributarias
--
CREATE TABLE customers_type
(
    id              serial      NOT NULL,
    descripcion     varchar(50),
    cuenta          varchar(4),
    gasto           varchar(4),
    primary key (id)
);

INSERT INTO customers_type (DESCRIPCION,cuenta,gasto) VALUES ('CLIENTES PENINSULA Y BALEARES','4300','7000');
INSERT INTO customers_type (DESCRIPCION,cuenta,gasto) VALUES ('CLIENTES RECARGO EQUIVALENCIA PENINSULA Y BALEARES','4301','7000');
INSERT INTO customers_type (DESCRIPCION,cuenta,gasto) VALUES ('CLIENTES CANARIAS','4302','7000');
INSERT INTO customers_type (DESCRIPCION,cuenta,gasto) VALUES ('CLIENTES CEUTA Y MELILLA','4303','7000');
INSERT INTO customers_type (DESCRIPCION,cuenta,gasto) VALUES ('CLIENTES PAIS MIEMBRO DE LA UE','4303','7000');
INSERT INTO customers_type (DESCRIPCION,cuenta,gasto) VALUES ('CLIENTES PAIS FUERA UE','4304','7000');




--
-- Clientes
--

CREATE TABLE customers
(
   id                      serial      NOT NULL,
   id_customers_type       integer default 1 references customers_type(id),
   IBAN                    varchar(34), -- los dos primeros digitos indican el país ES codigo para españa
   BIC                     varchar(11),
   Domiciliado             varchar(15) default 'domiciliado', -- por defecto domiciliado
   nif                     varchar(20),
   nombre                  varchar(60),
   direccion               varchar(90), -- Avenida Europa, 21
   objeto                  varchar(40), -- bloque A 2ºD
   poblacion               varchar(90), -- 18690 Almuñécar Granada
   Pais_ISO3166            varchar(2) default 'ES',
   movil                   varchar(10),
   mail                    varchar(90),
   saldo                   numeric(5),
   passwd                  varchar(40),
   clase                   varchar(2)  DEFAULT 'SL',
   pertenece_a             integer        DEFAULT 0,
   sip                     varchar(40),
   perfil                  varchar(50),
   digitos                 varchar(16),
   rol                     integer,
   carpeta_digitalizacion  varchar(90),
   tipo                    varchar(40)    DEFAULT 'US'::character varying,
   id_delegacion           integer,
   id_departamento         integer,
   envio_sms               char(1)        DEFAULT 'N'::bpchar,
   databasename            varchar(20),
   passdatabase            varchar(10),
   otros_datos             json,
   CuotaServicio           numeric(8,2) default 0,
   fecha_orden_sepa        date, -- FechaFirmaMandato
   referencia_mandato      varchar(35),
   orden_sepa              bytea, -- orden de domiciliación en formato SEPA
   certificado             bytea,
   primary key (id)
);

create index customers_nombre on customers(nombre);
create index customers_nif on customers(nif);

CREATE TABLE properties_type
(
    id              serial      NOT NULL,
    descripcion     varchar(50),
    primary key (id)
);

INSERT INTO properties_type (descripcion) VALUES ('Piso');
INSERT INTO properties_type (descripcion) VALUES ('Atico');
INSERT INTO properties_type (descripcion) VALUES ('Estudio');
INSERT INTO properties_type (descripcion) VALUES ('Duplex');
INSERT INTO properties_type (descripcion) VALUES ('Casa');
INSERT INTO properties_type (descripcion) VALUES ('Chalet');
INSERT INTO properties_type (descripcion) VALUES ('Cortijo');
INSERT INTO properties_type (descripcion) VALUES ('Solar');
INSERT INTO properties_type (descripcion) VALUES ('Finca');
INSERT INTO properties_type (descripcion) VALUES ('Adosado');

-- earthdistance
-- http://tapoueh.org/blog/2013/08/05-earthdistance
-- create extension cube;
-- create extension earthdistance;
--
-- properties 609 13.05.98 David
--
CREATE TABLE properties_for_sale
(
   id                      serial      NOT NULL, -- referencia
   id_customers_type       integer references customers_type(id),
   owner                   integer, -- propietario
   tipo_vivienda           varchar(20), -- Apartamento, casa, duplex, unifamiliar, etc.
   num_bedrooms            integer default 1, -- dormitorios
   num_kitchens            integer default 1, --cocinas
   num_bathrooms           integer default 1, -- baños
   num_toilets             integer default 0, -- aseos
   num_saloons             integer default 1, -- salones
   garage                  integer default 0, -- cochera
   terrace                 integer default 0, -- terazas
   other_features          json, -- otras caracteristicas
   views                   varchar(50), -- primera linea de playa, beachfront
   zona                    varchar(50),
   urbanization            varchar(50),
   price                   numeric(10,2) default 0,
   meters                  integer, -- metros útiles
   year_built              varchar(4), -- año de construcción
   reformed                varchar(25), -- reformado
   photos                  varchar(90),
   keys                    varchar(2) default 'NO',
   geopos                  point, -- geo posicionamiento
   direccion               varchar(90), -- Avenida Europa, 21
   objeto                  varchar(40), -- bloque A 2ºD
   poblacion               varchar(90) default '18690 Almuñecar Granada', -- 18690 Almuñécar Granada
   Pais_ISO3166            varchar(2) default 'ES',
   rol                     integer,
   carpeta_digitalizacion  varchar(90),
   tipo                    varchar(40)    DEFAULT 'US'::character varying,
   id_delegacion           integer,
   id_departamento         integer,
   remarks                 text, -- comentarios
   nota_simple             bytea,
   estado                  varchar(25) default 'for sale', -- for sale, sold, ...
   primary key (id)
);

create index for_sale_num_bedrooms on properties_for_sale(num_bedrooms);
create index for_sale_price on properties_for_sale(price);
create index for_sale_zona on properties_for_sale(zona);
create index for_sale_urbanization on properties_for_sale(urbanization);
create index for_sale_poblacion on properties_for_sale(poblacion);
create index for_sale_id_delegacion on properties_for_sale(id_delegacion);
create index for_sale_estado on properties_for_sale(estado);
create index for_sale_views on properties_for_sale(views);
create index for_sale_geopos on properties_for_sale using gist(geopos);
--
-- Vista de propiedades a la venta
--

create or replace view vw_properties (id,owner,tipo_vivienda,num_bedrooms,num_bathrooms,num_toilets,num_kitchens,num_saloons,garage,terrace,
other_features,views,zona,urbanization,price,meters,year_built,reformed,photos,keys,geopos,direccion,objeto,poblacion,remarks,nota_simple,estado)
as select id,owner,tipo_vivienda,num_bedrooms,num_bathrooms,num_toilets,num_kitchens,num_saloons,garage,terrace,
other_features,views,zona,urbanization,price,meters,year_built,reformed,photos,keys,direccion,objeto,geopos,poblacion,remarks,nota_simple,estado
from properties_for_sale where estado ='for sale';

--
-- Datos de prueba
--
insert into properties_for_sale (id_customers_type,tipo_vivienda,num_bedrooms,zona,price,geopos) 
values (1,'apartamento',2,'Centro',150000,POINT(-71.060316, 48.432044));

insert into properties_for_sale (id_customers_type,tipo_vivienda,num_bedrooms,zona,price,geopos) 
values (1,'apartamento',3,'San Cristobal',355000,POINT(-71.660316, 48.452044));

insert into properties_for_sale (id_customers_type,tipo_vivienda,num_bedrooms,zona,price,geopos) 
values (1,'casa',3,'Casco Antiguo',115000,POINT(-72.660316, 42.452044));

--
-- Posibles consultas
--
-- Por número de dormitorios
-- Por número de dormitorios en un rango de precios
-- Por tipo de vivienda
-- Por tipo de vivienda en un rango de precios
-- Por tipo de vivienda y número de dormitorios
-- con garaje

select * from vw_properties where tipo_vivienda='flat' and num_bedrooms=3 and price < 300 mil and views='beachfront'


--
-- Clientes
--

CREATE TABLE AddressBook
(
   id                      serial      NOT NULL,
   id_customers_type       integer references customers_type(id),
   IBAN                    varchar(34), -- los dos primeros digitos indican el país ES codigo para españa
   BIC                     varchar(11),
   Domiciliado             varchar(15) default 'domiciliado', -- por defecto domiciliado
   nif                     varchar(20),
   nombre                  varchar(60),
   direccion               varchar(90), -- Avenida Europa, 21
   objeto                  varchar(40), -- bloque A 2ºD
   poblacion               varchar(90), -- 18690 Almuñécar Granada
   Pais_ISO3166            varchar(2) default 'ES',
   movil                   varchar(10),
   mail                    varchar(90),
   saldo                   numeric(5),
   passwd                  varchar(40),
   clase                   varchar(2)  DEFAULT 'SL',
   pertenece_a             integer        DEFAULT 0,
   sip                     varchar(40),
   perfil                  varchar(50),
   digitos                 varchar(16),
   rol                     integer,
   carpeta_digitalizacion  varchar(90),
   tipo                    varchar(40)    DEFAULT 'US'::character varying,
   id_delegacion           integer,
   id_departamento         integer,
   envio_sms               char(1)        DEFAULT 'N'::bpchar,
   databasename            varchar(20),
   passdatabase            varchar(10),
   otros_datos             json,
   CuotaServicio           numeric(8,2) default 0,
   fecha_orden_sepa        date, -- FechaFirmaMandato
   referencia_mandato      varchar(35),
   orden_sepa              bytea, -- orden de domiciliación en formato SEPA
   certificado             bytea,
   primary key (id)
);

create index customers_nombre on customers(nombre);
create index customers_nif on customers(nif);
