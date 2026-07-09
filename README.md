# TechLab E-Commerce API 🚀
### Proyecto Final — Back-End Java | Talento Tech Buenos Aires (Comisión 26138)

Este proyecto consiste en el desarrollo de una **API REST robusta** para la gestión de un sistema de comercio electrónico (E-Commerce). Está construida con **Java y Spring Boot**, persistida en una base de datos **MySQL** utilizando **Spring Data JPA**, y configurada para cumplir con los requerimientos del nivel avanzado de la formación.

---

## 🛠️ Tecnologías y Herramientas Utilizadas
* **Java 17**
* **Spring Boot 3.x** (Spring Web, Spring Data JPA, Hibernate Validator)
* **MySQL Server** (Base de datos relacional)
* **Maven** (Gestor de dependencias)
* **Thunder Client / Postman** (Pruebas de endpoints)

---

## 📂 Arquitectura del Proyecto
El código se encuentra estrictamente organizado en paquetes siguiendo las mejores prácticas de diseño:
* `model`: Definición de las entidades espejo de la base de datos (`Producto`, `Pedido`, `LineaPedido`).
* `repository`: Interfaces que extienden de `JpaRepository` para el acceso a datos.
* `service`: Capa lógica de negocio (descuento de stock, validaciones, cálculo de precios).
* `controller`: Exposición de los endpoints REST, control de rutas y manejo global de errores.
* `exception`: Clases para el manejo de errores de negocio personalizados (`StockInsuficienteException`).

---

## 🗄️ Modelo de Datos y Relaciones
El sistema implementa un circuito comercial completo soportado por tres entidades principales:
1. **Producto:** Administra el catálogo (ID, Nombre, Descripción, Precio, Categoría, Imagen URL y Stock).
2. **Pedido:** Registra la compra general, la fecha y el monto total recalculado automáticamente en base a sus líneas.
3. **LineaPedido:** Entidad intermedia con relación `@ManyToOne` hacia `Pedido` y `Producto`, encargada de desglosar las cantidades y subtotales por artículo.

---

## 🚀 Instrucciones para Ejecutar la Aplicación

### 1. Clonar el repositorio
```bash
git clone [https://github.com/Atxuris/ecommerce.git](https://github.com/Atxuris/ecommerce.git)