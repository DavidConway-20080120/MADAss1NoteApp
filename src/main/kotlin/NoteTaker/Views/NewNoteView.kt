package NoteTaker.Views

import NoteTaker.Data.Group
import NoteTaker.Data.Note
import NoteTaker.Main.Groups
import NoteTaker.Models.CreateModel
import NoteTaker.Models.InputModel

class NewNoteView() : CreateModel {

    override fun display() {
        val input: String?
        val option: Int

        println("Please input New Note data")
        println("")
        input()
    }

    override fun input(){
        println("Titel: ")
        val title = readLine()
        println("Group")
        val group = readLine()
        println("Text")
        val text = readLine()
        val infoIn:Array<String?> = arrayOf(text,group,title)
        create(infoIn)

    }

    override fun create(info: Array<String?>) {
        val text:String? = info[0]
        val group:String? = info[1]
        val title:String? = info[2]

        if(!text.isNullOrBlank() && !title.isNullOrBlank()){
            val newNote: Note = Note(title,text)
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