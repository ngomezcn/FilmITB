package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.Film
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.FilmUI
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.SearchUI
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.UserUI
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.getCSVFromUrl
import java.net.URL
import java.util.*


class FilmManager (private val appState: AppState) {

    /**
     * Load data from remote repo
     * */
    private fun loadData(url: String) {
        val data = getCSVFromUrl(URL(url))

        if (data.hasNextLine()) data.nextLine() // Remove header CSV
        while (data.hasNextLine()) {
            val values = data.nextLine().split(",")
            val sValues = mutableListOf<String>()
            val iValues = mutableListOf<Int>()
            for (i in values) {
                if (i.toIntOrNull() == null) {
                    sValues.add(i);
                } else {
                    iValues.add(i.toInt())
                }
            }
            films.add(Film(sValues, iValues));
        }
    }

    /**
     * Deletes the indicated film from the database
     */
    fun deleteFilm(film: Film) {

        films.removeAt(
            films.indexOf(film)
        );
    fun addFilm(
        title: String,
        director: String,
        genere: String,
        mainActor: String,
        resume: String,
        ageRating: Int,
        duration: Int
    ) {


    val newFilm = FilmItb()
        films.add(Film(title, director, genere, mainActor, resume, ageRating, duration))
    }
    }


}