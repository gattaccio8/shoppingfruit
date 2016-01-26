package model

trait Fruit

case class Apple(val price: Double = 0.60) extends Fruit
case class Orange(val price: Double = 0.25) extends Fruit


