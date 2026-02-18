package workshop

import org.scalatest.funspec.AnyFunSpec

import chisel3._
import chisel3.simulator.scalatest.ChiselSim

class PAdderTest extends AnyFunSpec with ChiselSim {
  describe("32 bit simple adder") {
    it("should add") {
      simulate(new PAdder(32)) { c =>
        c.io.a.poke(1.U)
        c.io.b.poke(2.U)
        c.clock.step()
        c.io.sum.expect(3.U)

        c.io.a.poke("hFFFFFFFF".U)
        c.io.b.poke(1.U)
        c.clock.step()
        c.io.sum.expect(0.U)
      }
    }
  }

  describe("64 bit simple adder") {
    it("should add") {
      simulate(new PAdder(64)) { c =>
        c.io.a.poke(1.U)
        c.io.b.poke(2.U)
        c.clock.step()
        c.io.sum.expect(3.U)

        c.io.a.poke("hFFFFFFFFFFFFFFFF".U)
        c.io.b.poke(1.U)
        c.clock.step()
        c.io.sum.expect(0.U)
      }
    }
  }

  describe("128 bit simple adder") {
    it("should add") {
      simulate(new PAdder(128)) { c =>
        c.io.a.poke(1.U)
        c.io.b.poke(2.U)
        c.clock.step()
        c.io.sum.expect(3.U)

        c.io.a.poke("hFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF".U)
        c.io.b.poke(1.U)
        c.clock.step()
        c.io.sum.expect(0.U)
      }
    }
  }
}
