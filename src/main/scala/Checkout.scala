import UserPrintOutMessages._
import calculator.FruitCostCalculator
import model.{Fruit, Orange, Apple}


object Checkout extends App {

  initialPrompt
  orderInput

  val order = Console.in.readLine()

  private val fruits: List[Fruit] = order.split(",").map(f => {
    if (f.contains("Apple")) Apple() else Orange()
  }).toList

  println(s"You ordered $fruits and the total cost => ${FruitCostCalculator(fruits)}")

  Console.in.close()
  Console.flush()
}
