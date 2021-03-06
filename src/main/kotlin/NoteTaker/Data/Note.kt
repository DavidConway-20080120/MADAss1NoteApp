package NoteTaker.Data

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Note(title:String, text:String) {
    var title = title
    var text = text
    var date = updateDate()

    fun updateDate(): String{ //returns the curent date time
        val current = LocalDateTime.now()
        val format = current.format(DateTimeFormatter.ofPattern("yyy-MM-DD HH:mm:ss"))
        return ("$format")
    }
}