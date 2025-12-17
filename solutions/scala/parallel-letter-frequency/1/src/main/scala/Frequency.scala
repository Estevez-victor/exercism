import scala.runtime.stdLibPatches.language.future
import java.util.concurrent.Executors
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext

object Frequency {

  
  def frequency(numWorkers: Int, texts: Seq[String]): Map[Char, Int] = {
    implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(numWorkers))
    val listOfFutureMaps = texts.map( s=> Future { s.filter(_.isLetter).toLowerCase.groupBy(a=>a).map((c,s)=>(c,s.length)) })
    if listOfFutureMaps.isEmpty then Map() 
    else 
      val listOfMaps= listOfFutureMaps.map(Await.result(_, 1000.milli))
      listOfMaps.reduce(mergeMaps(_, _))
      
  }
  
  def mergeMaps(map1 : Map[Char, Int], map2 : Map[Char, Int]): Map[Char, Int] = {
    (map1.toList++map2.toList).groupBy(a=>a._1).map(x=>(x._1,x._2.map(_._2).sum))
  }
  
}