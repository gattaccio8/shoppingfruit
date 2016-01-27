package calculator

import calculator.FruitOffer.Offer
import model.{Orange, Apple, Fruit}

object FruitCostCalculator {

  def apply(fruits: List[Fruit], offers: Seq[Offer]) =
    if(offers.size > 0)
      offers.filter(f => isAnOrange(f._1)).head._2(oranges(fruits)) + offers.filter(f => isAnApple(f._1)).head._2(apples(fruits))
    else
      fullPrice(fruits)

  def buyOneGetOneFree(fruits: List[Fruit]): Double = fruits match {
    case Nil                               => 0.0
    case a :+ _ if(fruits.length % 2 == 0) => halfPrice(fruits)
    case a :+ _                            => halfPrice(fruits.drop(1)) + fruits.head.price
    case _                                 => fullPrice(fruits)
  }

  def buyThreePayTwo(fruits: List[Fruit]): Double = if(fruits.isEmpty) 0.0 else threeForThePriceOfTwo(fruits)

  def fullPrice(fruits: List[Fruit]): Double = fruits.map(_.price).fold(0.0)(_ + _)

  private def halfPrice(fruits: List[Fruit]): Double = fullPrice(fruits) / 2

  private def threeForThePriceOfTwo(fruits: List[Fruit]): Double =
    fullPrice(fruits) - fullPrice(fruits.zip (Stream from 1).filter(f => f._2 % 3 == 0).map(_._1))

  private def apples(fruits: List[Fruit]) = fruits.filter(isAnApple)
  private def oranges(fruits: List[Fruit]) = fruits.filter(isAnOrange)

  private def isAnApple(fruit: Fruit) = fruit.name.equals(Apple().name)
  private def isAnOrange(fruit: Fruit) = fruit.name.equals(Orange().name)
}
