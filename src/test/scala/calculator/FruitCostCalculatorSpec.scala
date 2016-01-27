package calculator

import model.{Orange, Apple}
import org.scalatest.FunSuite
import FruitCostCalculator._

class FruitCostCalculatorSpec extends FunSuite {

  test("calculate the total fruit cost at full price") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Nil

    assert(FruitCostCalculator(fruits, fullPrice) == 2.05)
  }

  test("calculate the total fruit cost when buy one get one free offer is applied") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Apple() :: Nil
    val unevenFruits1 = Apple() :: Apple() :: Orange() :: Apple() :: Nil
    val unevenFruits2 = Apple() :: Orange() :: Nil

    assert(FruitCostCalculator(fruits, buyOneGetOneFree) == 1.45)
    assert(FruitCostCalculator(unevenFruits1, buyOneGetOneFree) == 1.45)
    assert(FruitCostCalculator(unevenFruits2, buyOneGetOneFree) == 0.85)
  }
}
