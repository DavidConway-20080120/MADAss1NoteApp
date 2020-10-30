package NoteTaker.Views

import NoteTaker.Main.Groups
import NoteTaker.Models.InputModel

class NewGroupView() : InputModel {

    override fun display() {
        println("Please input New Group data")
        println("")
        input()
    }

    override fun input() {
        println("Titel: ")
        val titel = readLine()

        if(!titel.isNullOrBlank()){
            println("created " + titel)
            println("")
            if(Groups.getGroup(titel) == null) {
                Groups.addGroup(titel)
            }
            else{
                println("Group already exists")
                println("")
            }
        }
        else{
            println("error not created")
            println("")
        }
    }

}