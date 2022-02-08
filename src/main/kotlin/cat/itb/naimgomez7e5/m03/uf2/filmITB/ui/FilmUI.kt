package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.AppManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.FilmManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.UserManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.Film
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class FilmUI {
    fun showMenu()
    {
        UI().clearConsole();
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
            1 -> {UI().clearConsole(); addFilm(); AppManager.awaitEnter(); showMenu();}
            2 -> {UI().clearConsole(); showFilms(); AppManager.awaitEnter(); showMenu();}
            3 -> {UI().clearConsole(); deleteFilms(); AppManager.awaitEnter(); showMenu();}
            4 -> {UI().clearConsole(); watchFilms(); AppManager.awaitEnter(); showMenu();}
            5 -> {UI().clearConsole(); viewWatchedFilms(); AppManager.awaitEnter(); showMenu();}
            6 -> {UI().clearConsole(); addFavorites(); AppManager.awaitEnter(); showMenu();}
            7 -> {UI().clearConsole(); showFavorites(); AppManager.awaitEnter(); showMenu();}
            8 -> {UI().clearConsole(); showLikesFilm(); AppManager.awaitEnter(); showMenu();}
            0 -> UI().showMainMenu()
            else -> {
                UI().showMainMenu()
            }
        }
    }

    private fun addFilm() {
        println("[Add film]")
        val newFilm = Film(
        title = AppManager.inputString("Titel: "),
        director = AppManager.inputString("Nombre y apellido del director:"),
        genere = AppManager.inputString("Genero de la pelicula:"),
        mainActor = AppManager.inputString("Actor principal de la pelicula:"),
        resume = AppManager.inputString("Resumen de la pelicula:"),
        ageRating = AppManager.inputInt("Edad recomendada:"),
        duration = AppManager.inputInt("Duracion de la pelicula:"))

        FilmManager.addFilm(newFilm)
    }

    /**
     *  Print a formatted list of all users
     */
    private fun displayUsers()
    {
        for(i in FilmItb.filmsDB.indices){
            val film = FilmItb.filmsDB[i];
            println("$i: ${film.title}")
        }
    }

    private fun showFilms() {
        displayUsers();
    }

    private fun selectFilmFromMenu(msg : String) : Film
    {
        displayUsers();

        val maxRange = FilmItb.filmsDB.size-1;
        var selectedFilm = AppManager.inputInt("$msg (Number from 0 to $maxRange):")

        while (!AppManager.isInValidRange(0, maxRange, selectedFilm)) {
            selectedFilm = AppManager.inputInt("$msg (Number from 0 to $maxRange):")
        }

        return FilmItb.filmsDB[selectedFilm]
    }

    private fun deleteFilms() {
        println("[Delete User]")

        val film = selectFilmFromMenu("Which film do you want to delete?", );
        FilmManager.deleteFilm(film)
        println("Successfully removed!")
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

        for(i in FilmItb.filmsDB.indices){
            val film = FilmItb.filmsDB[i];
            println("$i: ${film.title}  ${film.likes}")
        }
    }

}