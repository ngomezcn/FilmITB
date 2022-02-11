package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import java.util.*

class SearchUI(private val scan: Scanner, private val filmItb: FilmItb) {

    fun showMenu() {

        println("Search methods:")
        println("1: By title")
        println("2: By director")
        println("3: By main actor")
        println("4: By genere")
        println("5: By length")
        println("6: Not watched")
        println("7: Recomended")
        println("0: Return to main menu")


        when (inputInt(scan)) {
            1 -> searchByTitle()
            2 -> searchByDirector()
            3 -> searchByMainActor()
            4 -> searchByGenere()
            5 -> searchByLength()
            6 -> searchByNotWatched()
            7 -> searchByRecommended()
            0 -> UI().showMainMenu();
            else -> {
                UI().showMainMenu();
            }
        }
    }

    private fun searchByTitle() {

    }
    private fun searchByDirector() {

    }
    private fun searchByMainActor() {

    }
    private fun searchByGenere() {

    }
    private fun searchByLength() {

    }
    private fun searchByNotWatched() {

    }
    private fun searchByRecommended() {
    }
}



