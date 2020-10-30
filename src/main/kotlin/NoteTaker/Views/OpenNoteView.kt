package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Data.Note
import NoteTaker.Models.ViewModel

class OpenNoteView(group: Group) : ViewModel {

    override var back: Boolean = false
    var group:Group = group

    override fun action(input: Int) {
        if(input < group.notes.size){
            var showNote:NoteView = NoteView(input,group)
            showNote.display()
        }
        else if(input == group.notes.size){
            back = true
        }
        else{
            println("invaled option")
        }
    }


    override fun display() {
        while(!back) {
            val input: String?
            val option: Int

            println("Select Note")
            for (i in group.notes){
                println(i.title + " ("+ group.notes.indexOf(i) + ")")
            }
            println("back ("+ group.notes.size +")")
            println("")
            println("Selection: ")
            input = readLine()!!
            option = if (input.toIntOrNull() != null && !input.isEmpty())
                input.toInt()
            else
                -1

            if (option != -1) {
                this.action(option)
            } else {
                println("Error invaled imput")
            }
        }
    }

}