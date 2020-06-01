package ca.mcit.bigdata.vishesh

case class Calender (
  service_id:String, monday :Int, tuesday :Int, wednesday:Int,
  thursday:Int, friday:Int, saturday:Int, sunday:Int, start_date:String,
  end_date:String
  )

  object Calender {
                 def apply(datainputc: String): Calender = {
                                                     val n = datainputc.split(",", -1)


                                                     new Calender(n(0), n(1).toInt, n(2).toInt, n(3).toInt, n(4).toInt,
                                                      n(5).toInt, n(6).toInt, n(7).toInt, n(8), n(9))
                       }


    def convertCalnedercsv(calender: Calender): String = {
      calender.service_id + "," +
        calender.monday + "," +
        calender.tuesday + "," +
        calender.wednesday + "," +
        calender.thursday + "," +
        calender.friday + "," +
        calender.saturday + "," +
        calender.sunday + "," +
        calender.start_date + "," +
        calender.end_date

    }

}
