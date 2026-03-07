# Rúbrica de Evaluación

## Distribución general

- **Evaluación teórica:** 20 puntos
- **Evaluación práctica:** 30 puntos
- **Total:** 50 puntos

## 1. Evaluación teórica - 20 puntos

La evaluación teórica se califica con base en la calidad de las respuestas individuales y justificadas sobre los conceptos trabajados en el taller.

### Criterios

- **Comprensión de asignación en software vs conexión en hardware:** 3 puntos
  - 3 puntos: Explica correctamente la diferencia y la relaciona con Chisel.
  - 2 puntos: La explicación es parcialmente correcta, pero incompleta.
  - 1 punto: Presenta una idea general, pero con imprecisiones importantes.
  - 0 puntos: La respuesta es incorrecta o no responde.

- **Comprensión de lógica combinacional vs secuencial:** 3 puntos
  - 3 puntos: Distingue claramente ambas y menciona el papel del estado o memoria.
  - 2 puntos: Diferencia aceptable, pero incompleta.
  - 1 punto: Respuesta vaga o confusa.
  - 0 puntos: Incorrecta o ausente.

- **Papel del reloj y los registros en un acumulador:** 3 puntos
  - 3 puntos: Explica con claridad la actualización por ciclo y el almacenamiento del estado.
  - 2 puntos: Explicación parcialmente correcta.
  - 1 punto: Menciona elementos clave sin relacionarlos bien.
  - 0 puntos: Incorrecta o ausente.

- **Comportamiento temporal de circuitos combinacionales y secuenciales:** 3 puntos
  - 3 puntos: Explica correctamente cuándo cambia la salida en lógica combinacional y cómo se observa una señal registrada.
  - 2 puntos: Respuesta mayormente correcta, con alguna omisión.
  - 1 punto: Respuesta superficial o confusa.
  - 0 puntos: Incorrecta o ausente.

- **Necesidad de memoria de estado en un acumulador:** 2 puntos
  - 2 puntos: Justifica correctamente por qué no basta la lógica combinacional.
  - 1 punto: La idea general es correcta, pero incompleta.
  - 0 puntos: Incorrecta o ausente.

- **Ventaja del diseño paramétrico:** 2 puntos
  - 2 puntos: Explica reutilización, escalabilidad y reducción de duplicación.
  - 1 punto: Menciona parcialmente la ventaja.
  - 0 puntos: Incorrecta o ausente.

- **Importancia del testbench y de la verificación:** 2 puntos
  - 2 puntos: Explica por qué compilar no garantiza funcionamiento correcto.
  - 1 punto: Respuesta parcial.
  - 0 puntos: Incorrecta o ausente.

- **Uso de trazas VCD y análisis de formas de onda:** 2 puntos
  - 2 puntos: Explica claramente su utilidad para depuración y observación temporal de señales.
  - 1 punto: Mención general sin suficiente detalle.
  - 0 puntos: Incorrecta o ausente.

## 2. Evaluación práctica - 30 puntos

La evaluación práctica se califica con base en la implementación funcional del sumador con acumulador, su generalización paramétrica, la composición estructural de una versión de mayor tamaño y la calidad de las pruebas realizadas.

### Parte A. Implementación base de 8 bits - 6 puntos

- **Definición del módulo `AdderAcc8` en `src/AdderAcc.scala`:** 6 puntos
  - 6 puntos: Define correctamente las entradas necesarias, la salida del acumulador y el comportamiento frente al reloj.
  - 4 puntos: La definición es mayormente correcta, con omisiones menores.
  - 2 puntos: La estructura general existe, pero presenta errores importantes.
  - 0 puntos: La definición es incorrecta o está ausente.

### Parte B. Composición de módulos - 8 puntos

- **Implementación de `AdderAcc16` en `src/AdderAcc.scala` y `P2NAdderAcc` en `src/PAdderAcc.scala`:** 6 puntos
  - 6 puntos: Construye correctamente la versión de 16 bits a partir de dos bloques más pequeños y presenta también una variante paramétrica coherente con la composición esperada.
  - 4 puntos: La composición es funcional, con errores menores o detalles de integración.
  - 2 puntos: La estructura existe, pero no refleja con claridad la jerarquía o la composición estructural requerida.
  - 1 punto: Implementación parcial.
  - 0 puntos: No implementado o incorrecto.

- **Uso de jerarquía de hardware y composición estructural:** 2 puntos
  - 2 puntos: El diseño evidencia claramente que el módulo mayor se construye combinando componentes menores, sin reescribir la lógica desde cero.
  - 1 punto: La intención de composición es visible, pero no queda completamente lograda.
  - 0 puntos: No se evidencia composición estructural.

### Parte C. Implementación paramétrica - 6 puntos

- **Implementación de `PAdderAcc` en `src/PAdderAcc.scala`:** 6 puntos
  - 6 puntos: El módulo es funcional, mantiene la misma idea del acumulador de 8 bits y permite configurar correctamente el ancho de palabra mediante un parámetro.
  - 4 puntos: La generalización paramétrica es mayormente correcta, con errores menores.
  - 2 puntos: Existe parametrización, pero la funcionalidad es incompleta o inconsistente.
  - 1 punto: La implementación es deficiente o apenas parcial.
  - 0 puntos: No implementado o no funcional.

### Parte D. Verificación mediante tests - 10 puntos

- **Cobertura mínima de pruebas de ambas implementaciones:** 10 puntos
  - 10 puntos: Los tests validan correctamente, como mínimo, la suma correcta en un ciclo inicial y el cambio de entradas entre ciclos para la versión con acumulador de 8 bits, la composición funcional de la versión de 16 bits, la operación de la versión paramétrica con al menos dos anchos distintos y la versión paramétrica compuesta, además de un caso con overflow donde el bit de acarreo del acumulador es `1` y un caso sin overflow donde el bit de acarreo permanece en `0`.
  - 8 puntos: Los tests cubren la mayoría de los casos mínimos requeridos, con omisiones menores.
  - 5 puntos: Los tests cubren solo una parte relevante de los casos mínimos.
  - 2 puntos: La verificación es muy limitada o superficial.
  - 0 puntos: No incluye pruebas funcionales adecuadas.
