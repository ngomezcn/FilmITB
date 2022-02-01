package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui


import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.util.*

class UI {

    fun start()
    {
        println("Welcome to FilmItb:")
        println("1: User")
        println("2: Films")
        println("3: Search")
        println("0: Exit")

        AppState().inputInt()
    }
}

fun main()
{
    val ui = UI();
    ui.start()
}
