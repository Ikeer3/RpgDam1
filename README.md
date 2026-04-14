# Práctica 2 — Sistema RPG (Excepciones y ficheros)

## Contexto

Se continúa el desarrollo del sistema RPG comenzado en la práctica anterior.

El jugador controla un personaje que puede explorar, encontrar enemigos, aprender habilidades y gestionar un inventario.

En esta práctica se añadirá gestión de errores mediante excepciones y persistencia básica mediante lectura y escritura de ficheros.

Se parte del código de la práctica anterior. No hay que rehacer lo ya implementado, sino ampliarlo.

---

## Objetivo

El objetivo de esta práctica es trabajar con:

- excepciones
- lectura de ficheros
- escritura de ficheros

---

## Parte 1 — Excepciones

Debes crear al menos dos excepciones propias para el proyecto.

Ejemplos de situaciones que deben tratarse con excepción:

- intentar usar un objeto que no existe
- intentar usar un objeto cuya cantidad es 0
- intentar descansar cuando la vida ya está al máximo
- intentar atacar o realizar una acción no permitida en ese momento

### Requisitos

1. Debes crear al menos dos clases de excepción propias.
2. Debes usar `throw` en los métodos donde se detecte la situación inválida.
3. Debes usar `try-catch` en la parte del programa donde se invoquen esas acciones.
4. El programa no debe terminar abruptamente al producirse una excepción controlada.

---

## Parte 2 — Combate básico

Se añadirá un sistema de combate simple.

### En la clase `Personaje`

Debes implementar un método que permita atacar a un enemigo.

Ejemplo de método posible:

- `atacar(Enemigo enemigo)`

### En la clase `Enemigo`

Debes añadir al menos:

- un método para recibir daño
- un método para comprobar si sigue vivo

### En la clase `Juego`

Debes modificar `buscarEnemigo()` para que, después de generar un enemigo, el jugador pueda combatir contra él.

No es necesario hacer un sistema complejo. Basta con un combate simple por turnos o una resolución directa.

### Requisitos mínimos del combate

- el personaje debe poder dañar al enemigo
- el enemigo debe poder perder vida
- si el enemigo muere, debe indicarse por consola
- el personaje debe ganar experiencia al derrotar a un enemigo

---

## Parte 3 — Guardar personaje en fichero

Debes implementar un método que permita guardar la información del personaje en un fichero de texto.

La información mínima que debe guardarse es:

- nombre
- vida
- vida máxima
- ataque
- defensa
- nivel
- experiencia

Además, debe guardarse también:

- habilidades
- inventario

### Requisitos

1. El fichero debe generarse desde el propio programa.
2. Debe usarse escritura de ficheros en Java.
3. El formato puede ser libre, pero debe ser legible y suficientemente claro para poder cargarse después.

---

## Parte 4 — Cargar personaje desde fichero

Debes implementar un método que permita reconstruir el personaje a partir de un fichero previamente guardado.

### Requisitos

1. Debe usarse lectura de ficheros en Java.
2. Debe cargarse correctamente toda la información guardada en la parte anterior.
3. Si el fichero no existe o no puede leerse, el error debe tratarse adecuadamente.

---

## Parte 5 — Menú

El menú del programa debe ampliarse con nuevas opciones.

Debe incluir, al menos:

1. Ver estado
2. Buscar enemigo
3. Descansar
4. Ver inventario
5. Ver habilidades
6. Ver enemigos encontrados
7. Guardar personaje
8. Cargar personaje
0. Salir

---

## Requisitos técnicos

- Debes mantener el uso correcto de colecciones de la práctica anterior.
- Debes usar al menos dos excepciones propias.
- Debes usar lectura y escritura de ficheros.
- No se permite rehacer el proyecto desde cero.
- Cada clase debe seguir encargándose de su propia lógica.

---

## Restricciones

- No se usan herencia ni interfaces todavía.
- No se permite eliminar el trabajo de la práctica anterior.
- No se permite concentrar toda la lógica en `main`.

---
