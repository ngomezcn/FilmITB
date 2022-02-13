package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*
import kotlin.system.exitProcess

/**
 *  Coding conventions
 *  https://kotlinlang.org/docs/coding-conventions
 */

class UI {
    private val appState = AppState();


    private val scan = Scanner(System.`in`);
    private val userUI = UserUI(scan, appState);
    private val filmUI = FilmUI(scan, appState);
    private val searchUI = SearchUI(scan, appState);
    private val loginUI = LoginUI(scan, appState);


    fun start()
    {
        println("Loading..... ")
        println("Please wait....")
        appState.filmItb.loadData()

        loginUI.showLoginMenu()
        showMainMenu();
    }

    fun showMainMenu()
    {
        println("Welcome ${AppState.currentUser.name} to FilmsITB")
        println("1: User")
        println("2: Films")
        println("3: Search")
        println("0: Exit")

        when (inputInt(scan)) {
            1 -> userUI.showUsersMenu();
            2 -> filmUI.showFilmMenu();
            3 -> searchUI.showSearchMenu();
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
}
// https://drive.google.com/drive/folders/1ZlpA5C8LNe2BCB_bIqz1XHsx-nwZm48M?usp=sharing
fun main()
{
    UI().start()
}
