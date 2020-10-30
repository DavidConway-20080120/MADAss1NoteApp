package NoteTaker.Views

import NoteTaker.Main.Groups
import NoteTaker.Models.ViewModel

import kotlin.system.exitProcess

class MainView() : ViewModel{
    override var back: Boolean = false

    override fun display() {
        while(!back) {
            val input: String?
            val option: Int

            println("Select option")
            println("New Note (1)")
            println("New Group (2)")
            println("Open Group (3)")
            println("Exit (4)")
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
        Groups.save()
    }

    override fun action(input : Int) {
        when(input) {
            1 -> {
                val newNote = NewNoteView()
                newNote.display()
            }
            2 -> {val newGroup = NewGroupView()
                newGroup.display()
            }
            3 -> {val openGroup = OpenGroupView()
                openGroup.display()
            }
            4 -> back = true
            else -> println("no option exists")
        }
    }
}