package ca.mcit.bigdata.vishesh


case class Route(
                  route_id:Int, agency_id:String, route_short_name:String, route_long_name:String,

                  route_type:String, route_url:String, route_color:String, route_text_color:String
                )

object Route{

               def apply(inputRoute: String):   Route =

                                                        {
                                                                  val z = inputRoute.split(",", -1)
                                                                  new Route(z(0).toInt, z(1), z(2), z(3), z(4),z(5),z(6),z(7))
                                                         }








  def convertRoutecsv(route: Route):String =


  {
    route.route_id+","+
      route.agency_id+","
    route.route_short_name+","+
      route.route_long_name+","+
      route.route_type+","+
      route.route_url+","+
      route.route_color+","+
      route.route_text_color

  }


}
