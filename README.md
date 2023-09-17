# Tutorial de JUnit

URL del proyecto: [https://github.com/yracnet/uagrm-m4-junit-course](https://github.com/yracnet/uagrm-m4-junit-course)

## Requisitos

Este proyecto requiere la configuración del siguiente entorno en Linux o Windows:

- **NetBeans 16** o superior
- **JDK 11** o superior
- **Maven 3.8.X** o superior
- **GIT 2.39.x** o superior

## Ramas

El proyecto tiene las siguientes ramas:

- **main**: Rama principal
- **p1-init**: Rama inicial, donde se encuentra el proyecto sin pruebas unitarias
- **p2-test**: Rama de pruebas, donde se encuentra el proyecto con pruebas unitarias

## Instalación

Ejecute el siguiente comando para construir el proyecto:

```bash
mvn clean install
```

> **NOTA**
> Este comando instalará las dependencias necesarias del proyecto. Se requiere una conexión a Internet.

## Proyecto Biblioteca

### Objetivo

Este proyecto es una implementación de una biblioteca para la venta de libros nuevos y antiguos. Incluye:

- Un catálogo de libros segun ISBN.
- Precios del libro según la edición y el formato.
- Ventas de libros con promociones (descuentos) aplicados a ejemplares de libros en un rango de fechas.

### Descripción

El proyecto incluye los archivos **libro-store.json**, **libro-precio-store.json** y **libro-promocion-store.json**, que almacenan la información de libros, precios y promociones.

### Diseño

#### Tabla de Libros (**libro-store.json**)

| ISBN | Título           | Autor                    | Descripción                                                   |
| ---- | ---------------- | ------------------------ | ------------------------------------------------------------- |
| 1000 | El Principito    | Antoine de Saint-Exupéry | Viaje del Principito por asteroides. Lecciones sobre la vida. |
| 1001 | Hábitos Atómicos | Antoine de Saint-Exupéry | Aprenda a desarrollar buenos hábitos y eliminar malos.        |

#### Tabla de Precios (**libro-precio-store.json**)

| ISBN | Edición | Formato     | Precio Unitario | Moneda |
| ---- | ------- | ----------- | --------------- | ------ |
| 1000 | 2019    | TAPA_DURA   | 350.0           | USD    |
| 1000 | 2005    | TAPA_DURA   | 330.0           | USD    |
| 1000 | 2010    | TAPA_BLANDA | 200.0           | USD    |
| 1001 | 2023    | TAPA_DURA   | 550.0           | USD    |
| 1001 | 2005    | TAPA_BLANDA | 330.0           | USD    |
| 1001 | 1989    | TAPA_BLANDA | 300.0           | BOB    |

#### Tabla de Promociones (**libro-promocion-store.json**)

| id  | tipo    | isbn | edición | formato     | fechaDesde | fechaHasta | descuento | descripción                  |
| --- | ------- | ---- | ------- | ----------- | ---------- | ---------- | --------- | ---------------------------- |
| 1   | NUEVO   | 1000 | 2019    | TAPA_DURA   | 2000-01-01 | 2000-12-31 | 0.01      | Descuento por nueva sucursal |
| 2   | ANTIGUO | 1000 | 2005    | TAPA_DURA   | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 3   | NUEVO   | 1000 | 2010    | TAPA_BLANDA | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 4   | ANTIGUO | 1001 | 2023    | TAPA_DURA   | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 5   | NUEVO   | 1001 | 2005    | TAPA_BLANDA | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |
| 6   | ANTIGUO | 1001 | 1989    | TAPA_BLANDA | 2000-01-01 | 2000-12-31 | 0.01      | Descuento Inicial            |

### Servicio

El proyecto incluye una clase llamada `CarritoCompraManager`, que permite calcular descuentos (**calcularDecuento**) en un libro según el **ISBN**, **EDICIÓN** y **FORMATO**. Realiza lo siguiente:

- Busca el libro por el ISBN.
- Busca el precio por el ISBN, EDICIÓN y FORMATO.
- Busca el descuento por la FECHA de compra.
- Retorna el **Valor de Descuento** del libro.

## Pruebas Unitarias

Las pruebas unitarias se aplicarán al método **calcularDescuento** para verificar que devuelva el precio de un libro con el descuento válido en los siguientes casos:

- Cuando sea un **Libro Nuevo** (cuando el descuento sea por libro nuevo).
- Cuando sea un **Libro Antiguo** (cuando el descuento sea por una edición antigua).
- Cuando sea por un **Precio Diferente** (cuando el libro tenga un formato diferente).

**Ejemplos**:

- Desde el 01 de septiembre de 2023 hasta el 30 de septiembre de 2023, hay un descuento del 5% en un libro por el mes aniversario de la biblioteca.
- Desde el 01 de enero de 2023 hasta el 29 de febrero de 2024, hay un descuento del 2% en un libro debido a la edición 2023 (Libro nuevo).
- A partir del 01 de marzo de 2024, hay un descuento del 10% en un libro debido a la edición 2023 (Libro antiguo, ya que salió la edición 2024).

### Configuraciones

#### Dependencias

Añade las siguientes dependencias a tu proyecto en el archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.6.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.6.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.6.0</version>
    <scope>test</scope>
</dependency>
```

> **NOTA**: Estas dependencias pertenecen a JUnit 5.

#### Plugins

Añade los siguientes plugins a tu proyecto en el archivo `pom.xml`:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0</version>
</plugin>
<plugin>
    <groupId>com.hiskasoft.maven</groupId>
    <artifactId>hiska-maven-plugin</artifactId>
    <version>1.0.3</version>
    <executions>
        <execution>
            <phase>process-resources</phase>
            <goals>
                <goal>process</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <skipLicence>false</skipLicence>
        <skipFormat>false</skipFormat>
        <skipAnalyzer>false</skipAnalyzer>
    </configuration>
</plugin>
```

> **NOTA**:
>
> - `maven-surefire-plugin`: Ejecuta y genera las pruebas unitarias.
> - `hiska-maven-plugin`: Formatea, agrega licencia y analiza el código del proyecto.

### Ejecución

Para ejecutar las pruebas unitarias, utiliza el siguiente comando:

```bash
mvn clean test
```

> **NOTA**: Este comando ejecuta las pruebas unitarias en todo el proyecto.

Para generar un informe de pruebas unitarias en formato HTML, ejecuta el siguiente comando:

```bash
mvn surefire-report:report
```

> **NOTA**: Este comando genera un informe de pruebas unitarias en formato HTML.

## Definiciones

- **ISBN**: Número de identificación internacional asignado a los libros.
- **EDICIÓN**: Una publicación periódica/anual del libro original, con cambios y actualizaciones.
- **FORMATO**: Presentación del libro, considerando solo los formatos TAPA DURA y TAPA BLANDA.
- **PROMOCIONES**: Descuentos válidos entre fechas para un determinado libro.
