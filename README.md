# JUnit Tutorial

URL: https://github.com/yracnet/uagrm-m4-junit-course

## Requerimentos

Este proyecto requiere el siguiente entorno configurado en Linux o Windows.

- **Netbeans 16** _o Superior_
- **JDK 11** _o Superior_
- **Maven 3.8.X** _o Superior_
- **GIT 2.39.x** _o Superior_

## Ramas

El proyecto cuenta con las siguientes ramas:

- **main**: Rama principal
- **p1-init**: Rama inicial, donde se encuentra el proyecto sin pruebas unitarias
- **p2-test**: Rema pruebas, donde se encuentra el proyecto con pruebas unitarias

## Instalación

Ejecute el comando

```
mvn clean build
```

> **NOTA**
> Este comando instalara las dependencias necesarias del proyecto, requiere **internet**.

## Proyecto Biblioteca

### Objetivo

El proyecto es una implementacion de una biblioteca para la venta de libros nuevo o antiguos, donde:

- Se tiene un catalogo de libros, un conjunto de precios del libro segun la **edicion** y el **formato**.

  - **Edicion**: Una publicacion periodica/anual del libro original, con cambio y actualizaciones.
  - **Formato**: Presentacion del libro, para este proyecto se considera solo los formasto TAPA DURA y TAPA BLANDA

- La venta de libros puede realizar con promociones (descuentos) aplicados a un ejemplar de un libro (edicion y formato) el cual es un procentaje y es valido entre fechas.

  - Desde el **01/Sep/2023** hasta **30/Sep/2023**, se tiene un descuento a un libro del 5% por el mes aniversario de la biblioteca.
  - Desde el **01/Ene/2023** hasta **29/Feb/2024**, se tiene un descuento a un libro del 2% por ser edicion 2023 **(Libro nuevo)**
  - A partir del 01/Mar/2024, se tiene un descuento a un libro del 10% por ser edicion 2023 **(Libro antiguo por que ya salio la edicion 2024)**

### Descripcion

El proyecto cuento con los archivos **libro-store.json**, **libro-precio-store.json** y **libro-promocion-store.json** los cuales alamacen la informacion de libros, precion y promociones.

### Diseño

Se tiene la siguiente tabla para los libros (**libro-store.json**)
| ISBN | Título | Autor | Descripción |
|-------|-----------------|--------------------------|-------------------------------------------------|
| 1000 | El Principito | Antoine de Saint-Exupéry | Viaje del Principito por asteroides. Lecciones sobre la vida. |
| 1001 | Hábitos Atómicos | Antoine de Saint-Exupéry | Aprenda a desarrollar buenos hábitos y eliminar malos. |

Se tiene la siguiente tabla para los precios (**libro-precio-store.json** )

| ISBN | Edición | Formato     | Precio Unitario | Moneda |
| ---- | ------- | ----------- | --------------- | ------ |
| 1000 | 2019    | TAPA_DURA   | 350.0           | USD    |
| 1000 | 2005    | TAPA_DURA   | 330.0           | USD    |
| 1000 | 2010    | TAPA_BLANDA | 200.0           | USD    |
| 1001 | 2023    | TAPA_DURA   | 550.0           | USD    |
| 1001 | 2005    | TAPA_BLANDA | 330.0           | USD    |
| 1001 | 1989    | TAPA_BLANDA | 300.0           | BOB    |

Se tiene la siguiente tabla para las promociones (**libro-promocion-store.json** )

| id  | tipo    | isbn | edicion | formato     | fechaDesde | fechaHasta | descuento | descripcion                  |
| --- | ------- | ---- | ------- | ----------- | ---------- | ---------- | --------- | ---------------------------- |
| 1   | NUEVO   | 1000 | 2019    | TAPA_DURA   | 2000-01-01 | 2000-12-31 | 0.01      | Descuento por nueva sucursal |
| 2   | ANTIGUO | 1000 | 2005    | TAPA_DURA   | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 3   | NUEVO   | 1000 | 2010    | TAPA_BLANDA | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 4   | ANTIGUO | 1001 | 2023    | TAPA_DURA   | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 5   | NUEVO   | 1001 | 2005    | TAPA_BLANDA | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 6   | ANTIGUO | 1001 | 1989    | TAPA_BLANDA | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |

### Servicio

Se tiene una clase llamada CarritoCompraManager, que permite **calcularDecuento** de un libro por el **ISBN**, **EDICION** y **FORMATO**, el cual:

- Buscara el libro por el ISBN
- Buscara el precio por el ISBN, EDICION y FORMATO
- Buscara el decuento por la FECHA de compra
- Retornara el **ValorDescuento** del Libro

## Pruebas Unitarias
