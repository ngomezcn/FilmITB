package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.AppManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.FilmManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.UserManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb

class FilmUI {
    fun showMenu()
    {
        println("Films:")
        println("1: Add film")
        println("2: Show films")
        println("3: Delete films")
        println("4: Watch films")
        println("5: View watched films")
        println("6: Add film to favorites")
        println("7: Show favorites")
        println("8: Show likes per film")
        println("0: Return to main menu")

        when (AppManager.inputInt()) {
            1 -> {UI().clearConsole(); addFilm(); showMenu();}
            2 -> {UI().clearConsole(); showFilm(); showMenu();}
            3 -> {UI().clearConsole(); deleteFilms(); showMenu();}
            4 -> {UI().clearConsole(); watchFilms(); showMenu();}
            5 -> {UI().clearConsole(); viewWatchedFilms(); showMenu();}
            6 -> {UI().clearConsole(); addFavorites(); showMenu();}
            7 -> {UI().clearConsole(); showFavorites(); showMenu();}
            8 -> {UI().clearConsole(); showLikesFilm(); showMenu();}
            0 -> UI().showMainMenu()
            else -> {
                UI().showMainMenu()
            }
        }
    }

    private fun addFilm() {
        println("[Add film]")
        val fullNameDirector = AppManager.inputString("Nombre y apellido del director:");
        val genere = AppManager.inputString("Generos de la pelicula:")
        val age = AppManager.inputInt("Edad recomendada:")
        val length = AppManager.inputInt("Duracion de la pelicula:")
        val actor = AppManager.inputString("Actor principal de la pelicula:")
        val resume = AppManager.inputString("e de la pelicula:")

    }

    private fun showFilm() {
        TODO("Not yet implemented")
    }

    private fun deleteFilms() {
        TODO("Not yet implemented")
    }

    private fun watchFilms() {
        TODO("Not yet implemented")
    }

    private fun viewWatchedFilms() {
        TODO("Not yet implemented")
    }

    private fun addFavorites() {
        TODO("Not yet implemented")
    }

    private fun showFavorites() {
        TODO("Not yet implemented")
    }

    private fun showLikesFilm() {
        TODO("Not yet implemented")
    }
}