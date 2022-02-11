package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.FilmItb
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.AppState
import java.net.URL
import java.net.URLConnection
import java.util.*


class AppManager(private val appState: AppState) {

    /**
     * Main func to load data
     * */
    fun loadData() {
        loadData(filmsURL);
        loadData(usersURL);
    }
}

