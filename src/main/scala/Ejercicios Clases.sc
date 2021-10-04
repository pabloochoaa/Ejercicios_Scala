import org.w3c.dom.css.Counter

import java.util.function.DoubleToLongFunction

//Exercise 1
//Why if i don't write "var"/"val" before hours/mins it isn't a member value
//Due to the visibility, the default visibility doesn't allow to get or set the param

class Time (var hours: Int, var mins: Int){
  def isSooner(t: Time): Boolean ={
    var anterior: Boolean = false
    if(this.hours > t.hours){
      anterior = true
    }else{
      if(this.hours == t.hours && this.mins > t.mins){
        anterior = true
      }
    }

    anterior
  }
}

var t1 = new Time(18,30)
var t2 = new Time(18, 20)
t1.isSooner(t2)

var t3 = new Time(18,30)
var t4 = new Time(20, 20)
t3.isSooner(t4)

//Exercise 2
class Person(var name: String, var age: Int){
  def print: Unit ={
    println(s"Mi nombre es $name y tengo $age")
  }
}

var p1 = new Person("Pablo", 21)
p1.print

//Exercise 3 y 4
class mCounter(var value: Int){
  def increment: Unit ={
    value = value + 1
  }

  def actual: Int ={
    value
  }

  def isSmall(c: Counter): Boolean = {
    value > c
  }
}

var c1 = new mCounter(5)
c1.increment
c1.actual
//c1.isSmall()

//Exercise 5
object Conversions{
  def inchToCentimetres(p: Double): Double ={
    p*2.54
  }

  def gallonsToLitres(g: Double): Double ={
    g*3.78541
  }

  def milesToKilometres(m: Double): Double ={
    m*1.60934
  }
}

//Exercise 6
abstract class UnitConversor{
  def convert(d: Double): Double
}

object InchToCentimetres extends UnitConversor{
  override def convert(d: Double): Double ={
    d*2.54
  }
}

object MilesToKilometres extends UnitConversor{
  override def convert(d: Double): Double ={
    d*1.60934
  }
}

object GallonsToLitres extends UnitConversor{
  override def convert(d: Double): Double ={
    d*3.78541
  }
}

//Exercise 7
class Point(var x: Int, var y: Int){}

object Point{
  def apply: Point = {
    new Point(3, 4)
  }
}

//Ejercicio 8
object main{
  def main(args: Array[String]): Unit ={
    for(s <- args.length-1 until 0){
      print(s"$s ")
    }
  }
}