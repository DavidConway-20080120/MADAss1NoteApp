package NoteTaker.Data

class Group(title : String) {

    var title = title

    val notes = ArrayList<Note>()

    fun addNote(noteIn:Note){
        notes.add(noteIn)
    }
}