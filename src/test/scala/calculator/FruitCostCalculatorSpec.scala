package calculator

import model.{Orange, Apple}
import org.scalatest.FunSuite

class FruitCostCalculatorSpec extends FunSuite {

  test("calculate the total fruit cost") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Nil

    assert(FruitCostCalculator(fruits) == 2.05)
  }
}
