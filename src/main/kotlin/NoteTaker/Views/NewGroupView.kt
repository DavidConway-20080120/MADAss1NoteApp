package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Main.Groups
import NoteTaker.Models.CreateModel
import NoteTaker.Models.InputModel

class NewGroupView() : CreateModel {
    var newGroup:Group? = null
    override fun display() {
        println("Please input New Group data")
        println("")
        input()
    }

    override fun input() {
        println("Titel: ")
        val title = readLine()
        val infoIn:Array<String?> = arrayOf(title)
        create(infoIn)

    }

    override fun create(info: Array<String?>) {
        val title:String? = info[0]
        if(!title.isNullOrBlank()){
            println("created " + title)
            println("")
            if(Groups.getGroup(title) == null) {
                newGroup = Group(title)
                Groups.addGroup(newGroup!!)
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