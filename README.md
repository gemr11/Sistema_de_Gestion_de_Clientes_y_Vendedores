# 🏢 Sistema de Gestión de Clientes y Vendedores

Este proyecto es una aplicación **Java con interfaz gráfica** para gestionar clientes y vendedores de una empresa, conectada a una **base de datos MySQL** con generación de reportes usando **JasperReports**.

---

## 📋 Enunciado del Problema

Desarrollar un sistema de gestión empresarial que permita:

- Administrar información de clientes y vendedores  
- Realizar operaciones CRUD completas  
- Generar reportes ordenados por diferentes criterios  
- Mantener integridad referencial entre tablas  
- Proporcionar una interfaz intuitiva con validaciones  

---

## 🛠️ Características Principales

### 📚 Base de Datos

- **Cliente**: Gestión de información personal y compras  
- **Vendedor**: Registro de empleados y desempeño comercial  
- **Provincia**: Catálogo de provincias  
- **Departamento**: Catálogo de departamentos empresariales  

### 💻 Interfaz Gráfica

- Menú principal con opciones:
  - Inicio/Presentación  
  - Mantenimiento (Clientes/Vendedores)  
  - Reportes  
  - Salir  
- Validaciones de campos y estados de botones  
- Combobox para selección de provincias/departamentos  

### 🔄 Funcionalidades CRUD

- Crear nuevos registros  
- Leer/Buscar información existente  
- Actualizar datos  
- Eliminar registros  
- Listar todos los registros en tablas  

### 📊 Reportes

- **Clientes**: Ordenados por apellido, cédula o compra anual  
- **Vendedores**: Ordenados por apellido, código o departamento  
- Generados con **JasperReports**  

---

## 🚀 Estructura del Proyecto

**Carpeta raíz del proyecto:**

- `src/` → Código fuente Java   
    - `Cliente.java`  
    - `Vendedor.java`  
    - `Persona.java`  
    - `Provincia.java`  
    - `Departamento.java`  
    - `DB.java` (conexión a la base de datos)  
    - `MantenimientoCliente.java`  
    - `MantenimientoVendedor.java`  
    - `ReporteCliente.java`  
    - `ReporteVendedor.java`  
    - `Presentacion.java`  
  - `ProyFinal.java` (clase principal)

- `reportes/` → Archivos de JasperReports  
  - `reporte_clientes.jasper`  
  - `reporte_vendedores.jasper`

- `lib/` → Librerías necesarias (JasperReports, MySQL Connector)

- `script_bd.sql` → Script SQL para crear la base de datos

- `compilar_ejecutar.bat` → Script de compilación y ejecución (Windows)

---

## 💻 Tecnologías Utilizadas

- Java 17  
- Java Swing (GUI)  
- MySQL 8.0  
- JasperReports 6.17.0  
- MySQL Connector/J 8.0  

---

## ✅ Requisitos Cumplidos

- Base de datos completa con 4 tablas relacionadas  
- 12+ clases Java bien organizadas  
- Interfaz gráfica con menú `JMenuBar`  
- CRUD completo con validaciones  
- Reportes generados con JasperReports  
- Uso de herencia (Cliente/Vendedor → Persona)  
- Estados de botones y entradas validados  
- Combobox funcional para selección de códigos/descripciones  

---

## 🎥 Sustentación

La presentación del proyecto incluirá:

- Estructura de la base de datos  
- Visualización de registros existentes  
- Recorrido por el código y clases Java  
- Demostración de:
  - Mantenimiento de clientes  
  - Mantenimiento de vendedores  
  - Generación de reportes  
  - Validación de todos los requisitos  

---

## 🚀 Cómo Ejecutarlo

### 🔧 Requisitos

- Java JDK 17+  
- MySQL 8.0+  
- Librerías JasperReports (colocadas en `/lib`)  

### ⚙️ Configuración y Ejecución

1. Ejecuta el script `proyecto_3_DB.sql` en tu servidor MySQL  
2. Configura la conexión en `DB.java`  
3. Compila el proyecto:

```bash
SET CLASSPATH=./lib/*;.
javac -encoding UTF-8 src/ProyFinal.java

