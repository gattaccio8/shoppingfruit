import java.io.InputStream

object UserInputReader {
  def read(inputStream: InputStream = System.in): String = scala.io.StdIn.readLine
}
