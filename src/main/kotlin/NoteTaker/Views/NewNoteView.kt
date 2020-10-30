package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Data.Note
import NoteTaker.Main.Groups
import NoteTaker.Models.InputModel

class NewNoteView() : InputModel {

    override fun display() {
        val input: String?
        val option: Int

        println("Please input New Note data")
        println("")
        input()
    }

    override fun input(){
        println("Titel: ")
        val titel = readLine()
        println("Group")
        val group = readLine()
        println("Text")
        val text = readLine()

        if(!text.isNullOrBlank() && !titel.isNullOrBlank()){
            val newNote: Note = Note(titel,text)
            newNote.updateDate()
            val useGroup: Group? = Groups.getGroup(group)
            if(useGroup != null ){
                println("created in Group " + useGroup?.title)
                println("")
                useGroup.addNote(newNote)

            }
            else{
                println("created in Default Group")
                println("")
                val useGroup: Group? = Groups.allGroups.get(0)
                useGroup?.addNote(newNote)
            }
        }
        else{
            println("error not created")
            println("")
        }
    }



}