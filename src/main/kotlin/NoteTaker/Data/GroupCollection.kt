package NoteTaker.Data

class GroupCollection {
    val allGroups = ArrayList<Group>()

    init {
        addGroup("Default")
        addGroup("test")
    }

    fun addGroup(titel :String){
        val newGroup = Group(titel)
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

}