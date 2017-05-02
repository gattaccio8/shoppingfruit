import model.{Apple, Fruit, Orange}

trait UserInputReaderService {
  def read(): String = scala.io.StdIn.readLine
}


class UserInputReader(userInputReaderService: UserInputReaderService) {

  def fruitOrder: List[Fruit] = userInputReaderService.read().split(",").map(typeOfFruit).toList

  private def typeOfFruit(f: String) = if (f.contains("Apple")) Apple() else Orange()
}
