package calculator

import model.{Orange, Apple}
import org.scalatest.FunSuite
import FruitOffer._

class FruitCostCalculatorSpec extends FunSuite {

  test("calculate the total fruit cost at full price") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Nil

    assert(FruitCostCalculator(fruits, Seq()) == 2.05)
  }

  test("calculate the total fruit cost when buy one get one free offer is applied") {
    val fruits = Apple() :: Apple() :: Orange() :: Apple() :: Apple() :: Nil
    val unevenFruits1 = Apple() :: Apple() :: Orange() :: Apple() :: Nil
    val unevenFruits2 = Apple() :: Orange() :: Nil

    assert(FruitCostCalculator(fruits, offers) == 1.45)
    assert(FruitCostCalculator(unevenFruits1, offers) == 1.45)
    assert(FruitCostCalculator(unevenFruits2, offers) == 0.85)
  }

  test("calculate the total fruit cost when buy three for the price of two offer is applied") {
    val fruits = Orange() :: Orange() :: Orange() :: Nil
    val unevenFruits1 = Orange() :: Orange() :: Orange() :: Orange() :: Nil
    val unevenFruits2 = Orange() :: Orange() :: Orange() :: Orange() :: Apple() :: Nil
    val unevenFruits3 = Apple() :: Nil

    assert(FruitCostCalculator(fruits, offers) == 0.50)
    assert(FruitCostCalculator(unevenFruits1, offers) == 0.75)
    assert(FruitCostCalculator(unevenFruits2, offers) == 1.35)
    assert(FruitCostCalculator(unevenFruits3, offers) == 0.60)
  }
}
