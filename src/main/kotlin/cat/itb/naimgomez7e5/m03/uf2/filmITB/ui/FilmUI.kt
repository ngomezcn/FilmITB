package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.AppManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.FilmManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.Film
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import java.util.*

class FilmUI(val scan: Scanner) {

    var filmManager = FilmManager()

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

        val title = readInputString(scan, "Titel: ")
        val director = readInputString(scan, "Nombre y apellido del director:")
        val genere = readInputString(scan, "Genero de la pelicula:")
        val mainActor = readInputString(scan, "Actor principal de la pelicula:")
        val resume = readInputString(scan, "Resumen de la pelicula:")
        val ageRating = inputInt(scan, "Edad recomendada:")
        val duration = inputInt(scan, "Duracion de la pelicula:")

        filmManager.addFilm(title, director,genere,mainActor,resume, ageRating, duration)
    }

    /**
     *  Print a formatted list of all films
     */
    private fun displayFilms()
    {
        for(i in FilmItb.filmsDB.indices){
            val film = FilmItb.filmsDB[i];
            println("$i: ${film.title}")
        }
    }

    private fun showFilms() {
        displayFilms();
    }

    private fun selectFilmFromMenu(msg : String) : Film
    {
        displayFilms();

        val maxRange = FilmItb.filmsDB.size-1;
        while(true) {
            var selectedFilm = AppManager.inputInt("$msg (Number from 0 to $maxRange):")
            while (!AppManager.isInValidRange(0, maxRange, selectedFilm)) {
                selectedFilm = AppManager.inputInt("$msg (Number from 0 to $maxRange):")
            }
            return FilmItb.filmsDB[selectedFilm]
        }
    }

    private fun deleteFilms() {
        println("[Delete User]")

        val film = selectFilmFromMenu("Which film do you want to delete?", );
        filmManager.deleteFilm(film)
        println("Successfully removed!")
    }

    private fun watchFilms() {
        println("[Delete User]")

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