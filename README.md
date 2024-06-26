
Invex Empleados Project


## Compilation

```bash
  mvn clean install
```

## Deployment

To deploy this project run

```bash
  java -jar invex-rest-apí\target\invex-rest-apí.jar
```

## Endpoints

Endpoint encargado de listar todos los empleados

```bash
  http://localhost:8080/api/empleados/getEmpleados

  For example:
    curl --location --request GET 'http://localhost:8080/api/empleados/getEmpleados'
```

Endpoint encargado elimnar empleados por id

```bash
  http://localhost:8080/api/empleados/borrar/{idEmpleado}

  For example:
    curl --location --request PUT 'http://localhost:8080/api/empleados/borrar/2'
```

Endpoint encargado de actualizar el empleado

```bash
  http://localhost:8080/api/empleados/update


  For example:
    curl --location --request PUT 'http://localhost:8080/api/empleados/update' \
--header 'Content-Type: application/json' \
--data '{
        "idEmpleado": 2,
        "primerNombre": "Luis",
        "segundoNombre": null,
        "apellidoPaterno": "Prieto",
        "apellidoMaterno": null,
        "edad": 30,
        "sexo": null,
        "fechaNacimiento": "09-09-1988",
        "puesto": null
    }'
```

Endpoint encargado de realizar la inserccion de empleados

```bash
  http://localhost:8080/api/empleados/create

  For exmample:
    curl --location --request POST 'http://localhost:8080/api/empleados/create' \
--header 'Content-Type: application/json' \
--data '[
    {
        "primerNombre": "Manuel",
        "segundoNombre": null,
        "apellidoPaterno": null,
        "apellidoMaterno": "Jimenez",
        "edad": 31,
        "sexo": null,
        "fechaNacimiento": "10-09-1988",
        "puesto": "Developer"
    },
    {
        "primerNombre": "Luis",
        "segundoNombre": null,
        "apellidoPaterno": "Pato",
        "apellidoMaterno": "Jimenez",
        "edad": 38,
        "sexo": "H",
        "fechaNacimiento": "10-09-1988",
        "puesto": "Developer Jr"
    }
]'
```

## Database - Postgres

```bash
  Script

  CREATE TABLE IF NOT EXISTS public.empleado (
    id_empleado integer NOT NULL DEFAULT nextval('seq_empleado_id'::regclass),
    prime_nombre character varying(50) COLLATE pg_catalog."default",
    segundo_nombre character varying(50) COLLATE pg_catalog."default",
    apellido_paterno character varying(50) COLLATE pg_catalog."default",
    apellido_materno character varying(50) COLLATE pg_catalog."default",
    edad integer,
    sexo character varying(2) COLLATE pg_catalog."default",
    fecha_nac date,
    puesto character varying(50) COLLATE pg_catalog."default",
    visible integer DEFAULT 0,
    CONSTRAINT empleado_pkey PRIMARY KEY (id_empleado))

    CREATE SEQUENCE IF NOT EXISTS public.seq_empleado_id
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
```

## Authors

- Manuel Prieto

