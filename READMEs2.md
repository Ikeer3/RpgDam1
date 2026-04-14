# Práctica 1 — Sistema RPG (Listas, Sets y Maps)

## Contexto

Se va a desarrollar un sistema sencillo de juego tipo RPG por turnos.

El jugador controla un personaje que puede explorar, encontrar enemigos, aprender habilidades y gestionar un inventario.

Se proporciona un esqueleto de código que debe ser completado.

Se proporcionan algunas clases de Test para hacer pruebas básicas del funcionamiento del código implementado. 

**La estructura del proyecto, así como las clases de Test, NO es la forma adecuada de codificar; en 3-4 semanas modificaremos eso**

---

## Objetivo

El objetivo de la práctica es trabajar con colecciones en Java:

- List
- Set
- Map

Se evaluará la capacidad de elegir la estructura adecuada y operar correctamente sobre ella.

---

## Parte 1 — Clase Personaje

Completar la clase `Personaje`.

El personaje debe gestionar:

- un conjunto de habilidades (sin duplicados)
- un inventario de objetos con cantidades

### Habilidades

Implementar los métodos:

- `anhadirHabilidad(String habilidad)`
- `mostrarHabilidades()`
- `tieneHabilidad(String habilidad)`

Condiciones:

- No se pueden repetir habilidades

---

### Inventario

Implementar los métodos:

- `anhadirObjeto(String objeto, int cantidad)`
- `mostrarInventario()`
- `tieneObjeto(String objeto)`
- `usarObjeto(String objeto)`

Condiciones:

- Si el objeto ya existe, se incrementa su cantidad
- Al usar un objeto, su cantidad disminuye
- Si la cantidad llega a 0, el objeto debe eliminarse

---

## Parte 2 — Clase Enemigo

Completar la clase `Enemigo`.

Debe tener:

- nombre
- vida
- ataque

Implementar el método:

- `mostrarInfo()`

---

## Parte 3 — Gestión de enemigos

En la clase `Juego`:

Crear una colección para almacenar enemigos encontrados.

### Método `buscarEnemigo()`

Debe:

- generar un enemigo aleatorio
- añadirlo a la colección
- mostrar su información

### Método `mostrarEnemigosEncontrados()`

Debe:

- recorrer la colección
- mostrar todos los enemigos

---

## Parte 4 — Menú

El programa debe tener un menú con las siguientes opciones:

1. Ver estado
2. Buscar enemigo
3. Descansar
4. Ver inventario
5. Ver habilidades
6. Ver enemigos encontrados
0. Salir

---

## Requisitos técnicos

Se debe usar obligatoriamente:

- al menos una `List`
- al menos un `Set`
- al menos un `Map`

No se permite:

- usar arrays para estas funcionalidades
- duplicar código
- concentrar toda la lógica en `main`

Cada clase debe encargarse de su propia lógica.

---

## Salida por consola

El programa debe mostrar mensajes adecuados cuando:

- se añade una habilidad
- se intenta añadir una habilidad repetida
- se añade un objeto
- se usa un objeto
- se elimina un objeto del inventario
- se encuentra un enemigo

---

## Restricciones

- No se implementa combate en esta práctica
- No se usan excepciones
- No se usan herencia ni interfaces

---
responsabilidades