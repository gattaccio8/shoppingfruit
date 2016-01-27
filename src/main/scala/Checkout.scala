import UserPrintOutMessages._
import calculator.FruitCostCalculator
import calculator.FruitCostCalculator._
import UserInputReader._
import model.Fruit

object Checkout extends App {

  initialPrompt
  orderInput

  private val order: List[Fruit] = fruits()
  private val orderList = order.mkString("[ ", ", ", " ]")

  println(s"You ordered ${orderList} and the total cost => ${FruitCostCalculator(order, buyOneGetOneFree)}")

  Console.in.close()
  Console.flush()
}
