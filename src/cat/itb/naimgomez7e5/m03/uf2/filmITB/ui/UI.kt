package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.*
import java.util.*

/**
 *  Coding conventions
 *  https://kotlinlang.org/docs/coding-conventions
 */

class UI {

    private val userUI = UserUI();
    private val filmUI = FilmUI();
    private val searchUI = SearchUI();

    fun start()
    {
        println("Welcome to FilmItb:")
        println("1: User")
        println("2: Films")
        println("3: Search")
        println("0: Exit")

        when (AppState().inputInt()) {
            1 -> userUI.showMenu();
            2 -> filmUI.showMenu();
            3 -> searchUI.showMenu();
            0 -> return;
            else -> {
                return;
            }
        }
    }
}

fun main()
{
    val ui = UI();
    ui.start()
}
