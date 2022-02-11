package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*
import java.util.*

class LoginUI(private val scan: Scanner, private val filmItb: FilmItb) {

    fun showMenu()
    {
        println("[Sign-In]")

        var name = readInputString(scan,"Indicate your username:")
        var user = filmItb.getUserByName(name)

        while (user == null)
        {
            println("Aquest usuari no existeix!")
            println("Torna a indicar el nom de l'usuari que vols utilitzar.")
            name = readInputString(scan,"Username:")
            user = filmItb.getUserByName(name)
        }
        filmItb.appState.currentUser = user
    }
}