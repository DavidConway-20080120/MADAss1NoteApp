package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Data.Note
import NoteTaker.Main.Groups
import NoteTaker.Models.InputModel

class ChangeGroup(oldGroup: Group, thisNote:Note) : InputModel {
    val oldGroup = oldGroup
    val thisNote = thisNote
    var newGroup:Group? = null
    override fun display(){
        val input: String?
        val option: Int

        println("Please input group to change to")
        println("")
        input()
    }

    override fun input(){
        println("Group: ")
        val group = readLine()

        newGroup = Groups.getGroup(group)
        if(newGroup != null){
            Groups.noteSwap(thisNote,oldGroup, newGroup!!)
            thisNote.updateDate()
            println("note Changed")
        }
        else{
            println("error no group found")
            println("")
            newGroup = oldGroup
        }
    }



}