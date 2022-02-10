package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.Film
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL

class FilmManager {



        /**
         * Load data from remote repo
         * */
        fun loadData(url: String)
        {
            val data = AppManager.getCSVFromUrl(URL(url))

            if(data.hasNextLine()) data.nextLine() // Remove header CSV
            while (data.hasNextLine())
            {
                val values = data.nextLine().split(",")
                val sValues = mutableListOf<String>()
                val iValues = mutableListOf<Int>()
                for(i in values)
                {
                    if(i.toIntOrNull() == null)
                    {
                        sValues.add(i);
                    } else {
                        iValues.add(i.toInt())
                    }
                }
                FilmItb.filmsDB.add(Film(sValues, iValues));
            }
        }


        /**
         * Deletes the indicated film from the database
         */
        fun deleteFilm(film: Film) {

            FilmItb.filmsDB.removeAt(
                FilmItb.filmsDB.indexOf(film)
            );
        }

    fun addFilm(title: String, director: String, genere: String, mainActor: String, resume: String, ageRating: Int, duration: Int) {
        val newFilm = FilmItb()
        newFilm.filmsDB.add(title, director, genere, mainActor, resume, ageRating, duration)
    }

}