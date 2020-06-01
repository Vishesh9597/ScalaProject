package ca.mcit.bigdata.vishesh
import scala.io.Source
import java.io.{BufferedWriter, FileWriter}


object Stm_Enrichment extends App {



                                  val output= new BufferedWriter(new FileWriter("/home/bd-user/Documents/final.csv"))

                                  val sTmtrip: List[Trip] = Source.fromFile("/home/bd-user/Downloads/trips.txt").getLines()
                                                        .toList.tail.map(Trip(_))


                                   val sTmroute: List[Route] = Source.fromFile("/home/bd-user/Downloads/routes.txt")
                                                             .getLines().toList.tail.map(Route(_))


                                  val sTmcalender: List[Calender] = Source.fromFile("/home/bd-user/Downloads/calendar.txt")
                                                                   .getLines().toList.tail.map(Calender(_))





                                  val tripRou: List[JoinValue] = new MapJoin[Trip, Route]((x)
                                               => x.route_id.toString)((y) => y.route_id.toString).join(sTmtrip, sTmroute)


                                   val enriched = new GenericNestedLoopJoin[Calender, JoinValue]((x, y)

                                   => x.service_id == y.left.asInstanceOf[Trip].service_id).join(sTmcalender, tripRou)


    val pt = enriched.map(joinOutput => {
                                         val tri = Trip.convertTripcsv(joinOutput.right.getOrElse("")
                                           .asInstanceOf[JoinValue].left.asInstanceOf[Trip])

                                         val rou = Route.convertRoutecsv(joinOutput.right.getOrElse("")
                                           .asInstanceOf[JoinValue].right.getOrElse("").asInstanceOf[Route])
                                         val cal = Calender.convertCalnedercsv(joinOutput.left.asInstanceOf[Calender])
                                         tri + "," + rou + "," + cal
                                       })
       for (i <- pt) {
                       output.newLine()

                        output.write(i)
     }
                         output.close()
   }

