import java.io.InputStream

import model.{Fruit, Orange, Apple}

object UserInputReader {
  private def read(inputStream: InputStream = System.in): String = scala.io.StdIn.readLine

  private def typeOfFruit(f: String) = if (f.contains("Apple")) Apple() else Orange()

  def fruits(input: String = read()): List[Fruit] = input.split(",").map(typeOfFruit).toList
}
