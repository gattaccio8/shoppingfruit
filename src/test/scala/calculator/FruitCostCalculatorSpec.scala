package calculator

import model.{Orange, Apple}
import org.scalatest.FunSuite

class FruitCostCalculatorSpec extends FunSuite {

  test("calculate the total fruit cost") {

    val fruit = Apple() :: Apple() :: Orange() :: Apple() :: Nil

    assert(FruitCostCalculator(fruit) == 2.05)
  }
}
