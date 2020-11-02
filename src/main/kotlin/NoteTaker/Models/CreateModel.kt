package NoteTaker.Models

interface CreateModel{
    fun display() //desplays the given menu
    fun input() // how the menue reacts to option
    fun create(info:Array<String?>)
}
