# ☕ Proyecto Java EDD - Gestión de Clientes y Ventas para Cafetería

Este proyecto ha sido desarrollado como parte de la **Evaluación Continua de los módulos de Programación y Entornos de Desarrollo** del ciclo de Desarrollo de Aplicaciones Multiplataforma (DAM).

El objetivo principal es crear una aplicación en Java, con interfaz de consola, que permita llevar la gestión básica de un pequeño negocio (en este caso, una tienda de café), incorporando prácticas profesionales como:

- Control de versiones con Git y GitHub
- Estructura modular y clara del código
- Documentación técnica con Javadoc
- Pruebas unitarias con JUnit
- Gestión de dependencias con Maven

La aplicación está diseñada para gestionar:
- Clientes
- Productos (cafés)
- Ventas asociadas

---

## 📋 Funcionalidades implementadas

A continuación se detallan las funcionalidades obligatorias desarrolladas en este proyecto:

### 👤 Gestión de clientes
- Alta de nuevos clientes
- Baja de clientes existentes
- Modificación de datos de un cliente
- Búsqueda de clientes por DNI
- Listado completo de clientes registrados

### ☕ Gestión de productos (cafés)
- Alta de productos disponibles en la tienda
- Listado general del catálogo de cafés
- Búsqueda de productos por especie

### 💰 Gestión de ventas
- Creación de nuevas ventas:
    - Selección de cliente existente
    - Añadir uno o más cafés del catálogo
- Visualización de todas las ventas realizadas
- Visualización de ventas por cliente
- Cálculo y muestra del importe total de cada venta

---

## 🛠 Requisitos técnicos

- Java JDK 17 o superior
- IntelliJ IDEA (recomendado)
- Git instalado y configurado
- Maven (para gestión de dependencias y testing)

---

## 🗂 Estructura del proyecto

La estructura del repositorio sigue el estándar Maven y mantiene una separación clara entre código, pruebas y configuración:

```text
Proyecto-Java-EDD/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/tiendacafe/... ← Código fuente principal
│   └── test/
│       └── java/
│           └── com/tiendacafe/... ← Pruebas unitarias (JUnit)
├── pom.xml         ← Configuración de Maven
├── README.md       ← Este archivo

## 🌿 Estrategia de ramas Git

Este proyecto sigue una estrategia aplicando el uso de ramas para organizar el desarrollo, evitar conflictos y facilitar la integración de funcionalidades.

### 🔀 Ramas principales

- **`main`**  
  Rama estable. Solo contiene versiones funcionales, probadas y listas para entrega o presentación.

- **`dev`**  
  Rama de desarrollo general. Aquí se integran las funcionalidades completadas y testeadas de las distintas ramas `feature/*` antes de ser fusionadas en `main`.

### 🌱 Ramas por funcionalidad (`feature/*`)

Cada funcionalidad o clase principal se desarrolla en su propia rama `feature`, incluyendo su implementación, Javadoc y pruebas unitarias.

- `feature/cliente`  
  - Clase `Cliente.java`
  - `ClienteTest.java`
  - Javadoc para Cliente

- `feature/cafe`  
  - Clase `Cafe.java`
  - `CafeTest.java`
  - Javadoc para Cafe

- `feature/venta`  
  - Clase `Venta.java`
  - `VentaTest.java`
  - Javadoc para Venta

- `feature/menu`  
  - Clase principal con el menú interactivo
  - Gestión de navegación y llamadas a otras funcionalidades

### 🔁 Flujo de trabajo

1. Se desarrolla una funcionalidad en su rama `feature/*`
2. Cuando está completada y probada, se fusiona con `dev`
3. Cuando `dev` está estable, se fusiona con `main`

Este flujo permite mantener un desarrollo limpio, modular y controlado, cumpliendo con las buenas prácticas de desarrollo colaborativo.


