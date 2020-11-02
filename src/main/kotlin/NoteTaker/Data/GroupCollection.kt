package NoteTaker.Data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class GroupCollection {
    var allGroups = ArrayList<Group>()
    init {
        val newGroup:Group = Group("Default")
        addGroup(newGroup)
        try {
            val input: String? = File("src/main/resources/data.json").readText()
            if(input != null){// in file is found treads in and converts to array list
                val myType = object : TypeToken<ArrayList<Group>>() {}.type
                allGroups = Gson().fromJson(input, myType)
            }
        }
        catch (e: Exception) {

        }

    }

    fun addGroup(newGroup :Group){
        allGroups.add(newGroup)
    }

    fun noteSwap(note:Note, from: Group, to:Group){
        from.notes.remove(note)
        to.notes.add(note)
    }

    fun getGroup(id:String?): Group?{
       var found :Group? = allGroups.find { p -> p.title == id}
        return found
    }

    fun save(){
        val saveData = Gson().toJson(allGroups)
        File("src/main/resources/data.json").writeText(saveData) //saves to data on close
    }

}