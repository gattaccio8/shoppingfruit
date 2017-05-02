package calculator

import calculator.FruitCostCalculator._
import model.Fruit

object FruitOffer {

  type Offer = List[Fruit] => Double

  val appleOffer: Offer = buyOneGetOneFree
  val orangeOffer: Offer = buyThreePayTwo

  val offers: Seq[List[Fruit] => Double] = Seq(appleOffer, orangeOffer)
}
