package calculator

import model.{Apple, Fruit}

object FruitCostCalculator {

  def apply(fruits: List[Fruit], offer: (List[Fruit]) => Double) = fullPrice(fruits.filterNot(isAnApple)) + offer(apples(fruits))

  def buyOneGetOneFree(fruits: List[Fruit]): Double = fruits match {
    case Nil                               => 0.0
    case a :+ _ if(fruits.length % 2 == 0) => halfPrice(fruits)
    case a1 :+ a2 :+ _                     => halfPrice(fruits.drop(1)) + fruits.head.price
    case _                                 => fullPrice(fruits)
  }

  def fullPrice(fruits: List[Fruit]): Double = fruits.map(_.price).fold(0.0)(_ + _)

  private def halfPrice(fruits: List[Fruit]): Double = fullPrice(fruits) / 2

  private def apples(fruits: List[Fruit]) = fruits.filter(isAnApple)

  private def isAnApple(fruit: Fruit) = fruit.name.equals(Apple().name)
}
