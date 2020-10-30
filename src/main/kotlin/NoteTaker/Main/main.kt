package NoteTaker.Main

import NoteTaker.Data.GroupCollection
import NoteTaker.Views.MainView

val Groups = GroupCollection()
fun main(args: Array<String>) {
    val mainMenu = MainView()
    mainMenu.display()
}