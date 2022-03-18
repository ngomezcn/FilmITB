package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.*

class LoginUI(var scan: Scanner, val appState : AppState) {

    /**
     * Display login menu and check if is valid
     */
    fun showLoginMenu()
    {
        println("[Sign-In]")

        var name = inputString(scan, "Indicate your username:");
        var user = appState.filmItb.getUserByName(name);

        while (user == null)
        {
            println("Aquest usuari no existeix!")
            println("Torna a indicar el nom de l'usuari que vols utilitzar.")
            name = inputString(scan, "Username:");
            user = appState.filmItb.getUserByName(name);
        }
        AppState.currentUser = user;
    }
}