package workshop

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import chisel3._
import chisel3.simulator.scalatest.ChiselSim

class AdderTest extends AnyFunSpec with ChiselSim {
  describe("8 bit simple adder") {
    it("should add") {
      simulate(new Adder8()) { c =>
        c.io.a.poke(1.U)
        c.io.b.poke(2.U)
        c.clock.step()
        c.io.sum.expect(3.U)

        c.io.a.poke(255.U)
        c.io.b.poke(1.U)
        c.clock.step()
        c.io.sum.expect(0.U)
      }
    }
  }
}
