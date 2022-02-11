package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import java.util.*

class FilmUI(private val scan: Scanner, private val filmItb: FilmItb) {

    fun showMenu()
    {
        while(true) {
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

            when (inputInt(scan)) {
                1 -> addFilm()
                2 -> showFilms()
                3 -> deleteFilms()
                4 -> watchFilms()
                5 -> viewWatchedFilms()
                6 -> addFavorites()
                7 -> showFavorites()
                8 -> showLikesFilm()
                0 -> UI().showMainMenu()
                else -> {
                    UI().showMainMenu()
                }
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

        filmItb.addFilm(title, director,genere,mainActor,resume, ageRating, duration)
    }

    /**
     *  Print a formatted list of all films
     */
    private fun displayFilms()
    {
        for(i in filmItb.films.indices){
            val film = filmItb.films[i]
            println("$i: ${film.title}")
        }
    }

    private fun showFilms() {
        displayFilms()
    }

    private fun selectFilmFromMenu(msg : String) : Film
    {
        displayFilms()

        val maxRange = filmItb.films.size-1
        while(true) {
            var selectedFilm = inputInt(scan,"$msg (Number from 0 to $maxRange):")
            while (!isInValidRange(0, maxRange, selectedFilm)) {
                selectedFilm = inputInt(scan, "$msg (Number from 0 to $maxRange):")
            }
            return filmItb.films[selectedFilm]
        }
    }

    private fun deleteFilms() {
        println("[Delete User]")

        val film = selectFilmFromMenu("Which film do you want to delete?", )
        filmItb.deleteFilm(film)
        println("Successfully removed!")
    }

    private fun watchFilms() {
        println("[Watch films]")
        selectFilmFromMenu("Which movie do you want to watch?")

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

        for(i in filmItb.films.indices){
            val film = filmItb.films[i]
            println("$i: ${film.title}  ${film.likes}")
        }
    }

}