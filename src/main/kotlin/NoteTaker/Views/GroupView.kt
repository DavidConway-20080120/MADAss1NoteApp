package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Main.Groups
import NoteTaker.Models.ListViewModel

class GroupView(override val index: Int) : ListViewModel {

    override var back: Boolean = false
    val showGroup:Group = Groups.allGroups.get(index)

    override fun action(input: Int) {
        when (input) {
            1 -> {
                val notes:OpenNoteView = OpenNoteView(showGroup)
                notes.display()
            }
            2 -> {
                print("new Title:")
                val newTitle:String? = readLine()
                if(newTitle != null){
                    println("Title updated")
                    println("")
                    showGroup.title = newTitle
                }
                else{
                    print("invaled titel")
                }
            }
            3 -> {
                Groups.allGroups.remove(showGroup)
                println("Delited" + showGroup.title)
                println("")
                back = true
            }
            4-> {
                back = true
            }
            else -> println("no option exists")
        }
    }


    override fun display() {
        while(!back) {
            val input: String?
            val option: Int

            println("Group: "+showGroup.title)
            println("Open note (1)")
            println("Edit Title (2)")
            println("Delete (3)")
            println("Back (4)")
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