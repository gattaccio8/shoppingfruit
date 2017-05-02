import UserPrintOutMessages._
import calculator.FruitCostCalculator
import calculator.FruitOffer._
import model.Fruit

object Checkout extends App {

  initialPrompt
  orderInput

  private val userInputReaderService: UserInputReaderService = new UserInputReaderService {}
  private val userInputService: UserInputReader = new UserInputReader(userInputReaderService)
  private val order: List[Fruit] = userInputService.fruitOrder

  println(s"You ordered ${order.map(_.name).mkString("[ ", ", ", " ]")} and the total cost is => ${FruitCostCalculator(order, offers)}")

  Console.in.close()
  Console.flush()
}
