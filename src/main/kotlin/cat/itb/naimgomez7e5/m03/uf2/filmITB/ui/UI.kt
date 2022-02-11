package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import java.util.*

/**
 *  Coding conventions
 *  https://kotlinlang.org/docs/coding-conventions
 */

class UI {

    private val scan = Scanner(System.`in`)
    private val filmITB = FilmItb()

    private val userUI = UserUI(scan, filmITB)
    private val filmUI = FilmUI(scan, filmITB)
    private val searchUI = SearchUI(scan, filmITB)
    private val loginUI = LoginUI(scan, filmITB)

    fun start()
    {
        println("Loading..... ")
        println("Please wait....")
        filmITB.loadData()

        loginUI.showMenu()
        showMainMenu()
    }

    fun showMainMenu()
    {
        println("Welcome ${filmITB.appState.currentUser.name} to FilmsITB")
        println("1: User")
        println("2: Films")
        println("3: Search")
        println("0: Exit")

        when (inputInt(scan)) {
            1 -> userUI.showMenu()
            2 -> filmUI.showMenu()
            3 -> searchUI.showMenu()
            0 -> exit()
            else -> {
                return
            }
        }
    }

}

// https://drive.google.com/drive/folders/1ZlpA5C8LNe2BCB_bIqz1XHsx-nwZm48M?usp=sharing
fun main()
{
    UI().start()


}
