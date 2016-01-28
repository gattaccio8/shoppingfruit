package calculator

import calculator.FruitOffer.Offer
import model.{Orange, Apple, Fruit}

object FruitCostCalculator {

  def apply(fruits: List[Fruit], offers: Seq[Offer]): Double = applyOffers(fruits, offers).fold(fullPrice(fruits))(identity)

  def applyOffers(fruits: List[Fruit], offers: Seq[Offer]): Option[Double] = for {
    orange <- offers.find(f => isAnOrange(f._1))
    apple <- offers.find(f => isAnApple(f._1))
  } yield orange._2(pickFruit(fruits, isAnOrange)) + apple._2(pickFruit(fruits, isAnApple))


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

  private def pickFruit: (List[Fruit], (Fruit) => Boolean) => List[Fruit] =
    (fruits: List[Fruit], ft: (Fruit) => Boolean) => fruits.filter(ft)

  private def isAnApple: (Fruit) => Boolean = (f: Fruit) => f == Apple()
  private def isAnOrange: (Fruit) => Boolean = (f: Fruit) => f == Orange()
}
