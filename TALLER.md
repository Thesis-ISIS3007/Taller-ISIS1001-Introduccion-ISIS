# 1. Descripción del Taller

En este taller los estudiantes aprenderán cómo se diseñan circuitos digitales usando código, cómo funciona el diseño a nivel RTL (Register Transfer Level) y cómo estos diseños pueden ejecutarse en hardware real mediante FPGAs.

Trabajaremos con:

- Chisel (Hardware Description Language embebido en Scala)
- Visualización de señales con: `VaporView` o `GTKWave`

# 2. Objetivos del Taller

Al finalizar el taller, el estudiante será capaz de:

Entender la diferencia entre programación de software y descripción de hardware.

Explicar qué significa RTL.

Comprender qué es una FPGA y cómo funciona.

Escribir módulos simples en Chisel.

Simular circuitos digitales.

Visualizar señales digitales en un visor de formas de onda (`waveform`).

# 3. Conceptos Fundamentales

## 3.1 ¿Qué es RTL?

RTL (Register Transfer Level) es una forma de describir sistemas digitales basada en:

Registros (almacenamiento)

Lógica combinacional

Reloj (`clock`)

Transferencia de datos entre registros

En hardware, todo ocurre en paralelo, no secuencialmente como en software.

## 3.2 ¿Qué es una FPGA?

Una FPGA (Field-Programmable Gate Array):

Es un dispositivo hardware reconfigurable.

Permite implementar circuitos digitales personalizados.

No ejecuta instrucciones como una CPU.

Implementa directamente lógica digital.

Comparación:

| CPU                   | FPGA                  |
|-----------------------|-----------------------|
| Ejecuta instrucciones | Implementa circuitos  |
| Secuencial            | Paralelo              |
| Software              | Hardware configurable |

## 3.3 ¿Qué es Chisel?

Chisel es:

Un lenguaje de descripción de hardware moderno.

Genera Verilog.

Desarrollado bajo el ecosistema de CHIPS Alliance.

Utilizado en proyectos académicos e industriales.

# 4. Entorno de Trabajo

devcontainer github

# 5. Actividad Inicial: Pensando en Hardware

Pregunta 1

Si escribimos:

```
a = b + c
```

En software:

¿Cuándo se ejecuta?

¿Cuántas veces?

En hardware:

¿Está siempre activo?

¿Qué pasa si cambia b?

Pregunta 2

¿Cuál es la diferencia entre:

Una variable en Python/Java?

Un registro en hardware?

🧪 6. Primer Ejemplo en Chisel: Sumador


```
import chisel3._

class Adder extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val sum = Output(UInt(8.W))
  })

  io.sum := io.a + io.b
}
```

Preguntas para analizar

¿Es lógica combinacional o secuencial?

¿Dónde está el reloj?

¿Qué ocurre si cambian las entradas?

# 7. Simulación y Visualización de Señales
## 7.1 Generación de archivo VCD

Durante la simulación se puede generar un archivo .vcd (Value Change Dump), que almacena los cambios de señal en el tiempo.

7.2 Visualización con GTKWave

GTKWave permite:

Abrir archivos .vcd

Ver evolución temporal de señales

Analizar transiciones

Detectar errores lógicos

Actividad

Ejecutar simulación.

Generar archivo .vcd.

Abrir en GTKWave.

Identificar:

Señales de entrada

Señal de salida

Cambios temporales

Preguntas:

¿Cuándo cambia sum?

¿Existe retardo observable?

¿Qué ocurre si cambian ambas entradas simultáneamente?

## 7.3 Visualización con VaporView

Alternativamente, usar:

VaporView

Ventajas:

Interfaz moderna

Visualización clara de transiciones

Fácil navegación temporal

Actividad:

Comparar la visualización en GTKWave vs VaporView.

¿Cuál resulta más intuitivo?

¿Qué información es más clara en cada uno?

# 8. Ejercicios para el Estudiante

Ejercicio 1 – Puerta AND

Diseñar un módulo que:

Reciba dos entradas de 1 bit.

Genere la salida AND.

Simular y visualizar la señal en GTKWave o VaporView.

Preguntas:

¿Qué ocurre cuando ambas entradas son 1?

¿Cómo se ve esto en el diagrama temporal?

Ejercicio 2 – Registro de 8 bits

Diseñar un módulo que:

Almacene un valor de 8 bits.

Se actualice con el flanco de reloj.

Tenga señal de habilitación (enable).

Simular y observar:

¿Cuándo cambia realmente la salida?

¿Qué ocurre si enable está en 0?

Ejercicio 3 – Contador

Diseñar un contador que:

Cuente de 0 a 15.

Reinicie en 0.

Incremente en cada ciclo.

Visualizar:

Señal de reloj.

Señal del contador.

Señal de reset.

Preguntas:

¿Cuántos bits se necesitan?

¿Cómo se observa el overflow en la forma de onda?

# 9. Desafío de Programación
🔥 MiniALU

Diseñar un módulo MiniALU con:

Entradas:

a (8 bits)

b (8 bits)

op (2 bits)

Salida:

result (8 bits)

Operaciones:

op	Operación
00	Suma
01	Resta
10	AND
11	OR
Requisitos

Usar switch o Mux.

Crear testbench.

Generar archivo VCD.

Visualizar en GTKWave o VaporView.

Preguntas a responder

¿Cómo se ve cada operación en la forma de onda?

¿Cómo cambia la salida cuando cambia op?

¿Existe diferencia temporal entre operaciones?

Bonus

Agregar:

Bandera Zero.

Detección de overflow.

🧠 10. Preguntas de Reflexión

¿Por qué depurar hardware es más complejo que software?

¿Qué significa paralelismo en hardware?

¿Cuándo conviene usar FPGA en lugar de CPU?

¿Qué aplicaciones podrían acelerarse en hardware?

🏗️ 11. Implementación Opcional en FPGA

Si se dispone de placa FPGA:

Generar Verilog desde Chisel.

Sintetizar con herramienta del fabricante.

Cargar bitstream.

Conectar salidas a LEDs.

Actividad sugerida:

Mostrar contador en LEDs.

Observar frecuencia y comportamiento real.

📚 12. Referencias

Chisel
https://github.com/chipsalliance/chisel

CHIPS Alliance
https://chipsalliance.org/

GTKWave

VaporView

Harris & Harris – Digital Design and Computer Architecture

🎉 Resultados Esperados

Al finalizar el taller, el estudiante:

Entiende qué es RTL.

Comprende cómo se describe hardware con código.

Puede escribir módulos básicos en Chisel.

Sabe simular y visualizar señales digitales.

Tiene intuición inicial sobre diseño digital y FPGAs.

Si se desea, este taller puede ampliarse a:

Curso completo de diseño digital.

Proyecto semestral de CPU simple.

Introducción a arquitecturas RISC-V.

Laboratorio práctico con FPGA.