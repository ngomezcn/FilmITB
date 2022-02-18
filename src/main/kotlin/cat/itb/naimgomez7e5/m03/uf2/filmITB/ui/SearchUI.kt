package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui
import java.util.*

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*

class SearchUI(var scan: Scanner, var appState : AppState) {

    fun showSearchMenu() : AppState  {

        while (true) {
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
                0 -> return appState
                else -> {
                    return appState
                }
            }
        }
    }

    private fun searchByTitle() {
        val title = inputString(scan, "Search: ")

        var matchedFilms : List<Film> = appState.filmItb.searchFilmByTitle(title)
        if(matchedFilms.isEmpty())
            println("No matches found!")
        else
            displayFilmList(matchedFilms)
    }

    private fun searchByDirector() {
        val director = inputString(scan, "Search:")

        var matchedFilms : List<Film> = appState.filmItb.searchDirectorByDirectorName(director)
        if(matchedFilms.isEmpty())
            println("No matches found!")
        else
            displayFilmList(matchedFilms)
    }

    private fun searchByMainActor() {
        val mainActor = inputString(scan, "Search:")

        var matchedFilms : List<Film> = appState.filmItb.searchFilmByMainActor(mainActor)
        if(matchedFilms.isEmpty())
            println("No matches found!")
        else
            displayFilmList(matchedFilms)
    }

    private fun searchByGenere() {
        val genere = inputString(scan, "Search:")

        var matchedFilms : List<Film> = appState.filmItb.searchFilmByMainGenere(genere)
        if(matchedFilms.isEmpty())
            println("No matches found!")
        else
            displayFilmList(matchedFilms)
    }

    private fun searchByLength() {
        val duration = inputInt(scan, "Search:")

        var matchedFilms : List<Film> = appState.filmItb.searchFilmByDuration(duration)
        if(matchedFilms.isEmpty())
            println("No matches found!")
        else
            displayFilmList(matchedFilms)
    }

    private fun searchByNotWatched() {
        var matchedFilms : List<Film> = appState.filmItb.searchFilmByNotWatched();
        displayFilmList(matchedFilms)
    }

    private fun searchByRecommended() {

    }

    private fun displayFilmList(list : List<Film>)
    {
        for (film in list)
        {
            displayFilmStats(film)
        }
    }

    private fun displayFilmStats(film : Film)
    {
        println("Title: ${film.title}")
        println("Director: ${film.director}")
        println("Main Actor: ${film.mainActor}")
        println("Genere: ${film.genere}")
        println("Duration: ${film.duration}")
        println("===================")
    }
}



