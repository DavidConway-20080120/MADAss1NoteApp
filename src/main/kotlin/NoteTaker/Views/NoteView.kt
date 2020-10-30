package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Data.Note
import NoteTaker.Main.Groups
import NoteTaker.Models.ListViewModel

class NoteView(override val index: Int, fromGroup:Group) : ListViewModel {

    override var back: Boolean = false
    var fromGroup = fromGroup
    val showNote: Note = fromGroup.notes.get(index)

    override fun action(input: Int) {
        when (input) {
            1 -> {
                print("new Title:")
                val newTitle:String? = readLine()
                if(newTitle != null){
                    println("Title updated")
                    println("")
                    showNote.title = newTitle
                    showNote.updateDate()
                }
                else{
                    print("invaled titel")
                }
            }
            2->{
                print("new Text:")
                val newText:String? = readLine()
                if(newText != null){
                    println("Text updated")
                    println("")
                    showNote.text = newText
                    showNote.updateDate()
                }
                else{
                    print("invaled Text")
                }

            }
            3->{
                val swap:ChangeGroup = ChangeGroup(fromGroup,showNote)
                swap.display()
                fromGroup = swap.newGroup!!
            }
            4 -> {
                fromGroup.notes.remove(showNote)
                println("Delited" + showNote.title)
                println("")
                back = true
            }
            5->{back =true}
            else -> println("no option exists")
        }
    }


    override fun display() {
        while(!back) {
            val input: String?
            val option: Int

            println("Note: "+showNote.title)
            println("Text: "+showNote.text)
            println("Group: "+fromGroup.title)
            println("Last Edit: "+showNote.date)
            println("")
            println("Edit Title (1)")
            println("Edit Text (2)")
            println("Change Group(3)")
            println("Delete (4)")
            println("Back (5)")
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

    override fun edit(text: String): String {
        TODO("Not yet implemented")
    }
}