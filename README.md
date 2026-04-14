# 🌌 Zodiac App – Android Kotlin

**Descripción:**  
Aplicación nativa de Android desarrollada en Kotlin que muestra información sobre los signos del zodiaco. La app presenta una lista de horóscopos mediante un **RecyclerView** y permite navegar a una pantalla de detalle donde se muestra el nombre, imagen y descripción de cada signo. Es un proyecto práctico para aprender navegación entre Activities, manejo de datos con modelos y uso de recursos en Android.

---

## 📌 Funcionalidades

- Lista de signos del zodiaco usando **RecyclerView**.  
- Navegación a pantalla de detalle al hacer click en un signo.  
- Envío de datos entre Activities mediante `Intent`.  
- Pantalla de detalle con:
  - Nombre del signo  
  - Imagen representativa  
  - Descripción del horóscopo  
- Uso de recursos de Android (`strings.xml`, `drawables`).  
- Modelo de datos centralizado con clase `Horoscope`.  

---

## 🛠 Tecnologías utilizadas

- Kotlin  
- Android Studio  
- RecyclerView  
- Intent (Navigation entre Activities)  
- Material Design Components  
- Recursos Android: `strings.xml`, `drawables`  
- Layouts: `ConstraintLayout`, `LinearLayout`

---

## 📷 Capturas de pantalla

<img src="list.png" width="300"/>

*Pantalla principal con el RecyclerView mostrando los signos del zodiaco.*

<br/>

<img src="detail.png" width="300"/>

*Pantalla de detalle con la información del horóscopo seleccionado.*

---

## 📝 Lo que aprendí

- Uso de RecyclerView y Adapters para listas dinámicas.  
- Navegación entre Activities usando Intents.  
- Paso de datos entre pantallas (`putExtra`, `getStringExtra`).  
- Creación de modelos de datos en Kotlin (`Horoscope`).  
- Uso correcto de recursos Android (`R.string`, `R.drawable`).  
- Separación de lógica y UI en arquitectura básica de Android.  

---

## 🚀 Cómo ejecutar

1. Clona el repositorio:

```bash
git clone https://github.com/tuusuario/zodiac_app.git
