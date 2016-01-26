package calculator

import model.Fruit

object FruitCostCalculator {

  def apply(fruits: List[Fruit]) = fruits.foldLeft(0.0)((acc, curr) => acc + curr.price)
}
