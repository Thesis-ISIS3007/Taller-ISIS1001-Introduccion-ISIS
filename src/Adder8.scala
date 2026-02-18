package workshop

import circt.stage.ChiselStage

import chisel3._

class Adder8 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val sum = Output(UInt(8.W))
  })

  io.sum := io.a + io.b
}

object ShowcaseAdder extends App {
  val printHeader = (header: String) => println(s"\u001B[32m${header}\u001B[0m")

  printHeader("System Verilog:")
  ChiselStage.emitSystemVerilogFile(
    new Adder8(),
    args = Array("--target-dir", "generated/adder"),
    firtoolOpts = Array(
      "-disable-all-randomization",
      "-strip-debug-info"
    )
  )
}
