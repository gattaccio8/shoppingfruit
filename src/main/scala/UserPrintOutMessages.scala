
object UserPrintOutMessages {

  private val welcomeMessage = s"In this shop we only sell apples and oranges\n"
  private val orderMessage = s"Enter your fruit order in a format like: Apple, Apple, Orange, Apple\n"

  def initialPrompt = println(welcomeMessage)
  def orderInput = println(orderMessage)
}
