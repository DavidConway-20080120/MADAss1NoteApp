package NoteTaker.Views

import NoteTaker.Main.Groups
import NoteTaker.Models.ViewModel

class OpenGroupView() : ViewModel {

    override var back: Boolean = false

    override fun action(input: Int) {
        if(input < Groups.allGroups.size){
            var showGroup:GroupView = GroupView(input)
            showGroup.display()
        }
        else if(input == Groups.allGroups.size){
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

            println("Select Group")
            for (i in Groups.allGroups){
                println(i.title + " ("+ Groups.allGroups.indexOf(i) + ")")
            }
            println("back ("+ Groups.allGroups.size +")")
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