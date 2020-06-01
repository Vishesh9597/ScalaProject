package ca.mcit.bigdata.vishesh


  case class Trip(
                   route_id:Int, service_id:String, trip_id:String, trip_headsign:String, direction_id:Int, shape_id:Int
                   , wheelchair_accessible:Int


                 )

  object Trip {
            def apply(datainput: String): Trip = {
             val m = datainput.split(",", -1)

            new Trip(m(0).toInt, m(1), m(2), m(3), m(4).toInt,

             m(5).toInt, m(6).toInt)
     }

    def convertTripcsv(trip: Trip): String =

    {
      trip.route_id + "," +
        trip.service_id + "," +
        trip.trip_id + "," +
        trip.direction_id + "," +
        trip.shape_id + "," +
        trip.wheelchair_accessible

    }




}
