package calculator

import model.{Fruit, Orange, Apple}
import FruitCostCalculator._

object FruitOffer {

  type Offer = (Fruit, (List[Fruit]) => Double)

  private val appleOffer: Offer = (Apple(), buyOneGetOneFree)
  private val orangeOffer: Offer = (Orange(), buyThreePayTwo)
  val offers: Seq[(Fruit, (List[Fruit]) => Double)] = Seq(appleOffer, orangeOffer)
}
