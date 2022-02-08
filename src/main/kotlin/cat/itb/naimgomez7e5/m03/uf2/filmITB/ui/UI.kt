package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import kotlin.system.exitProcess


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
        println("Loading..... ")
        println("Please wait....")
        AppManager.loadData()
        clearConsole();

        LoginUI().showMenu()
        showMainMenu();
    }

    fun showMainMenu()
    {
        clearConsole();
        println("Welcome ${AppState.currentUser.name} to FilmsITB")
        println("1: User")
        println("2: Films")
        println("3: Search")
        println("0: Exit")

        when (AppManager.inputInt()) {
            1 -> userUI.showMenu();
            2 -> filmUI.showMenu();
            3 -> searchUI.showMenu();
            0 -> return;
            else -> {
                return;
            }
        }
    }

    fun exit(status : Int = 0)
    {
        exitProcess(status);
    }

    fun clearConsole() {
        println("\n\n\n\n\n\n\n\n\n\n\n\r")
    }
}
// https://drive.google.com/drive/folders/1ZlpA5C8LNe2BCB_bIqz1XHsx-nwZm48M?usp=sharing
fun main()
{
    UI().start()
}
