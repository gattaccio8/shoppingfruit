import UserPrintOutMessages._
import calculator.FruitCostCalculator
import UserInputReader._
import model.Fruit

object Checkout extends App {

  initialPrompt
  orderInput

  private val order: List[Fruit] = fruits()

  println(s"You ordered ${order.mkString("[ ", ", ", " ]")} and the total cost => ${FruitCostCalculator(order)}")

  Console.in.close()
  Console.flush()
}
