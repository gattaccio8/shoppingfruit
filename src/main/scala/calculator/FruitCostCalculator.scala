package calculator

import calculator.FruitOffer.Offer
import calculator.FruitOffer._
import model.{Orange, Apple, Fruit}

object FruitCostCalculator {

  def apply(fruits: List[Fruit], offers: Seq[Offer]): Double = if(offers.isEmpty) fullPrice(fruits) else applyOffers(fruits)

  def buyOneGetOneFree(fruits: List[Fruit]): Double = fruits match {
    case Nil                               => 0.0
    case a +: _ if(fruits.length % 2 == 0) => halfPrice(fruits)
    case a +: t                            => halfPrice(t) + fullPrice(a :: Nil)
    case _                                 => fullPrice(fruits)
  }

  def buyThreePayTwo(fruits: List[Fruit]): Double = if(fruits.isEmpty) 0.0 else threeForThePriceOfTwo(fruits)

  private def applyOffers(fruits: List[Fruit]): Double =
    orangeOffer(fruits.filter(isAnOrange)) + appleOffer(fruits.filter(isAnApple))

  private def fullPrice(fruits: List[Fruit]): Double = fruits.map(_.price).fold(0.0)(_ + _)

  private def halfPrice(fruits: List[Fruit]): Double = fullPrice(fruits) / 2

  private def threeForThePriceOfTwo(fruits: List[Fruit]): Double =
    fullPrice(fruits) - fullPrice(zipped(fruits).map(_._1))

  private def zipped(fruits: List[Fruit]): List[(Fruit, Int)] =
    fruits.zip(Stream from 1).filter(_._2 % 3 == 0)

  private def isAnApple: Fruit => Boolean = (fruit: Fruit) => fruit == Apple()
  private def isAnOrange: Fruit => Boolean = (fruit: Fruit) => fruit == Orange()
}
