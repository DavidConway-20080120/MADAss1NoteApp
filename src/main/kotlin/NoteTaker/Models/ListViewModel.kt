package NoteTaker.Models

interface ListViewModel{
    val index : Int
    var back :Boolean // used to check the menue should stop looping and continue the last menue
    fun display() //desplays the given menu
    fun action(input : Int) // how the menue reacts to option
    fun edit(text:String) :String
}
