package workshop

import circt.stage.ChiselStage

import chisel3._

class PAdder(n: Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(n.W))
    val b = Input(UInt(n.W))
    val sum = Output(UInt(n.W))
  })

  io.sum := io.a + io.b
}

object ShowcasePAdder extends App {
  val printHeader = (header: String) => println(s"\u001B[32m${header}\u001B[0m")

  printHeader("32 bit adder System Verilog:")
  ChiselStage.emitSystemVerilogFile(
    new PAdder(32),
    args = Array("--target-dir", "generated/padder-32"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )

  printHeader("64 bit adder System Verilog:")
  ChiselStage.emitSystemVerilogFile(
    new PAdder(64),
    args = Array("--target-dir", "generated/padder-64"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )

  printHeader("128:")
  println(
    ChiselStage.emitSystemVerilogFile(
      new PAdder(128),
      args = Array("--target-dir", "generated/padder-128"),
      firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
    )
  )
}
