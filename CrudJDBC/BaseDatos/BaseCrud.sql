-- mysql

-- creo la base de datos
create database empresa;

-- uso la base de datos
use empresa;

-- creo la tabla empleado
create table empleado(
	id_empleado int primary key,
    nombre_empleado varchar(50),
    apellido_empleado varchar(60),
    edad_empleado int
)

-- inserto datos a la tabla empleado
insert into empleado(
	id_empleado,
    nombre_empleado,
    apellido_empleado,
    edad_empleado
) values (
	1,
    'jairo',
    'aguirre',
    22
)