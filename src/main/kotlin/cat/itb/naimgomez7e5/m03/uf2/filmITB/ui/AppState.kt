package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*

class AppState {

    val filmItb = FilmItb();

    companion object {
        lateinit var currentUser : User;
    }
}

