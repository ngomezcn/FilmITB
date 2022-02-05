package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.Film
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL

class FilmManager {

    companion object {
        fun addFilm(title: String,
            director: String,
            genere: String,
            ageRating: Int,
            lenght: Int,
            mainActor: String,
            resume: String) {

            Film(title,
                director,
                genere,
                mainActor,
                resume,
                ageRating,
                lenght)
        }

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
    }
}