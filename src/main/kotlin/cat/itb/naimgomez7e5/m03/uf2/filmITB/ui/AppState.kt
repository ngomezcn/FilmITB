package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import java.util.*

class AppState(){

    var currentUser : User = User("guest", "guest", -1)
    val films = mutableListOf<Film>()
    val users = mutableListOf<User>()

    private val filmITB = FilmItb()

}

