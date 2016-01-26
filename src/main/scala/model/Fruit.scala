package model

trait Fruit {
  val price: Double
}

case class Apple(price: Double = 0.60) extends Fruit
case class Orange(price: Double = 0.25) extends Fruit


