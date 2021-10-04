import scala.util.control._
import scala.annotation.tailrec
import scala.collection.mutable
import scala.util.control.Breaks.break
//Ejercicio 1
for(i <-0 to 10) println(i)

//Ejercicio 2
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

//Ejercicio 3
def aleatorio (n: Int): Seq[Int] ={
  var a = Seq(scala.util.Random.nextInt(n))

  for(i <- 1 to n){
    println(i)
    a = a:+ scala.util.Random.nextInt(n) //ya que no modifica la colección, devuelve una colección con el cambio
    println(a(i-1))
  }
  a
}

var aux = aleatorio(10)
aux.foreach(println)
println(s"Aux $aux")
for(it <- aux.indices) println(aux(it)) //las 3 formas hacen lo mismo

println(s"Tamaño de aux ${aux.size}")

//Ejercicio 4
def secPositivosCerosNegativos(sec: Seq[Int]): Seq[Int]={
  var positivos : Seq[Int] = Nil
  var ceros : Seq[Int] = Nil
  var negativos : Seq[Int] = Nil

  for(i <- sec){
    if(i > 0){
      positivos = positivos :+ i
    }else{
      if(i < 0){
        negativos = negativos :+ i
      }else{
        ceros = ceros :+ i
      }
    }
  }
  positivos.union(ceros.union(negativos)) //el operador ::: sólo disponible para listas
}

println(s"Resultado: ${secPositivosCerosNegativos(Array(5,-2,0,6,9,-3,0,1))}")

//Ejercicio 5
def mediaArray(a: Array[Double]): Double ={
  var res: Double = 0

  for(i <- a){
    res += i
  }
  res/a.length
}
var array = Array[Double](21.5,5.06,2.5,80,21.32,365478)
println(s"La media del vector es ${mediaArray(array)}")

//Ejercicio 6
def noDuplicados(a: Array[Int]): Array[Int] = {
  a.distinct
  a
}
var array = Array[Int](1,2,3,4,5,6,1,5,9,8,7,9)
var noR = noDuplicados(array)
println(s"${noR.foreach(print)}")

//Ejercicio 7
def noCeros(seq: Seq[Int]): Seq[Int] ={
  seq.filter( _ != 0)
}

var seq : Seq[Int] = Seq[Int](1,0,2,3,5,8,0,36)
var noCero = noCeros(seq)
println(s"$noCero")

//Ejercicio 8
def incremento10(m: Map[String, Int]): Map[String, Int] ={
  m.transform((k, v) => (110*v)/100) //no permitía poner 1.1 porque eso devolvía un double y esperaba un Int
}

var map : Map[String, Int] = Map("a" -> 10, "b" -> 20, "c" -> 100, "d" -> 200)
incremento10(map)

//Ejercicio 9
def minmax(values: Array[Int]): (Int, Int) ={
  var aux = values.sorted
  var t = (aux(0), aux(aux.length-1))
  t
}

var array : Array[Int] = Array(4,1,9,42,56,-1,10,25)
minmax(array)

//Ejercicio 10
def stringToMap(s: String): mutable.Map[Char, List[Int]] = {
  var map: mutable.Map[Char, List[Int]] = mutable.Map(s(0) -> List(0))
   for(i <- 0 until s.length){
     if(!map.keys.exists(_.equals(s(i)))){
       map += (s(i) -> List(i))
     }else{
       map(s(i)) -> i
     }
   }
  map
}

stringToMap("albacete")