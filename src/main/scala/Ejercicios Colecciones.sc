import scala.util.control._
import scala.annotation.tailrec
import scala.collection.mutable
import scala.util.control.Breaks.break

//Exercise 1
for(i <-0 to 10) println(i)

//Exercise 2
@tailrec
def countDown(n: Int): Unit ={
  if(n == 0){
    println(n)
  }else{
    println(n)
    countDown(n-1)
  }
}
countDown(5)

//Exercise 3
def random (n: Int): Seq[Int] ={
  var a = Seq(scala.util.Random.nextInt(n))

  for(i <- 1 to n){
    println(i)
    a = a:+ scala.util.Random.nextInt(n) //it doesn't modify the colecction, it returns a new one with the changes
    println(a(i-1))
  }
  a
}

var aux = random(10)
aux.foreach(println)
println(s"Aux $aux")
for(it <- aux.indices) println(aux(it)) //3 ways to do the same thing

println(s"Size of aux ${aux.size}")

//Exercise 4
def secPositiveZeroNegative(sec: Seq[Int]): Seq[Int]={
  var positives : Seq[Int] = Nil
  var zeros : Seq[Int] = Nil
  var negatives : Seq[Int] = Nil

  for(i <- sec){
    if(i > 0){
      positives = positives :+ i
    }else{
      if(i < 0){
        negatives = negatives :+ i
      }else{
        zeros = zeros :+ i
      }
    }
  }
  positives.union(zeros.union(negatives)) //the operator ::: is only available for lists
}

println(s"Result: ${secPositiveZeroNegative(Array(5,-2,0,6,9,-3,0,1))}")

//Exercise 5
def meanArray(a: Array[Double]): Double ={
  var res: Double = 0

  for(i <- a){
    res += i
  }
  res/a.length
}
var array = Array[Double](21.5,5.06,2.5,80,21.32,365478)
println(s"The mean of the Array is ${meanArray(array)}")

//Exercise 6
def noDuplicates(a: Array[Int]): Array[Int] = {
  a.distinct
}
var array = Array[Int](1,2,3,4,5,6,1,5,9,8,7,9)
var noR = noDuplicates(array)
println(s"${noR.foreach(print)}")

//Exercise 7
def noZeros(seq: Seq[Int]): Seq[Int] ={
  seq.filter( _ != 0)
}

var seq : Seq[Int] = Seq[Int](1,0,2,3,5,8,0,36)
var noZero = noZeros(seq)
println(s"$noZero")

//Exercise 8
def increment10(m: Map[String, Int]): Map[String, Int] ={
  m.transform((k, v) => (110*v)/100) // Doesn't allow to write 1.1 because that would return a double and it expect an int
}

var map : Map[String, Int] = Map("a" -> 10, "b" -> 20, "c" -> 100, "d" -> 200)
increment10(map)

//Exercise 9
def minmax(values: Array[Int]): (Int, Int) ={
  var aux = values.sorted
  var t = (aux(0), aux(aux.length-1))
  t
}

var array : Array[Int] = Array(4,1,9,42,56,-1,10,25)
minmax(array)

//Exercise 10
def stringToMap(s: String): mutable.Map[Char, Array[Int]] = {
  var map: mutable.Map[Char, Array[Int]] = mutable.Map(s(0) -> Array(0))
   for(i <- 0 until s.length){
     if(!map.keys.exists(_.equals(s(i)))){
       map += (s(i) -> Array(i))
     }else{
       map(s(i)) -> i
     }
   }
  map
}

stringToMap("albacete")