import model.{Apple, Orange}
import org.scalatest.FunSuite

class UserInputReaderSpec extends FunSuite {

  test("return a list of fruit for a given user input") {
    val fruits = "Apple, Apple, Orange, Apple"
    val expected = List(Apple(price = 0.6), Apple(price = 0.6), Orange(price = 0.25), Apple(price = 0.6))

    assert(UserInputReader.fruits(fruits) == expected)
  }
}
