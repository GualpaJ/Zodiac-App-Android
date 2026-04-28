# 🌌 Zodiac App – Android Kotlin

**Descripción:**  
Aplicación nativa de Android desarrollada en Kotlin que muestra información sobre los signos del zodiaco mediante un **RecyclerView**, permitiendo acceder a una pantalla de detalle con información ampliada.

El proyecto ha evolucionado en tres versiones (v1.0–v3.0), incorporando búsqueda, sistema de favoritos persistente y mejoras en la interacción del usuario como acciones de compartir y gestión avanzada de favoritos.

---

## 📌 Funcionalidades

### 🔹 v1.0
- Lista de signos del zodiaco usando **RecyclerView**  
- Navegación a pantalla de detalle al hacer click  
- Envío de datos entre Activities mediante `Intent`  
- Pantalla de detalle con:
  - Nombre  
  - Imagen  
  - Descripción  
- Uso de recursos (`strings.xml`, `drawables`)  
- Modelo de datos `Horoscope`  

### 🔹 v2.0
- 🔍 Búsqueda de signos con **SearchView**  
- ❤️ Sistema de favoritos con persistencia (**SharedPreferences**)  
- ⭐ Indicador visual de favoritos en la lista  
- 🔗 Opción de compartir contenido (Intent ACTION_SEND)  
- 📱 Action Bar con acciones (favorito + compartir)  

### 🔹 v3.0
- ❤️ Sistema de favoritos múltiples (StringSet)
- 💾 Persistencia de lista de favoritos
- 🔄 Mejora de gestión de estado en DetailActivity
- 🧠 Uso de SharedPreferences optimizado
- ⭐ Refactor de lógica de gestión de favoritos usando StringSet

---

## 🛠 Tecnologías utilizadas

- Kotlin  
- Android Studio  
- RecyclerView  
- Intents (Activity Navigation)  
- SharedPreferences  
- SearchView  
- Material Design Components  
- ConstraintLayout  

---

## 📷 Capturas de pantalla

### 🟢 v1.0
<p align="center">
  <img src="list.png" width="250">
  <img src="detail.png" width="250">
</p>

### 🔵 v2.0
<p align="center">
  <img src="list2.png" width="250">
  <img src="detail2.png" width="250">
</p>

---

## 📌 Estado del proyecto

El proyecto evoluciona en tres versiones principales:

- v1.0 → Lista de signos con RecyclerView y detalle
- v2.0 → Búsqueda, favoritos simples y compartir
- v3.0 → Favoritos múltiples y persistencia mejorada

🚧 En desarrollo → Nueva pantalla de lista de favoritos

---

## 📝 Lo que aprendí

- Uso de RecyclerView y Adapters  
- Navegación entre Activities con Intents  
- Paso de datos entre pantallas  
- Gestión de estado con **SharedPreferences**  
- Implementación de **SearchView** para filtrado  
- Manejo del **Action Bar y menús**  
- Mejora de UX con favoritos y compartir  

---

## 🚀 Cómo ejecutar

1. Clona el repositorio:

```bash
git clone https://github.com/GualpaJ/Zodiac-App-Android.git
