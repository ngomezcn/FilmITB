package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*

class LoginUI(var scan: Scanner, val appState : AppState) {

    fun showLoginMenu()
    {
        println("[Sign-In]")

        var name = readInputString(scan, "Indicate your username:");
        var user = appState.filmItb.getUserByName(name);

        while (user == null)
        {
            println("Aquest usuari no existeix!")
            println("Torna a indicar el nom de l'usuari que vols utilitzar.")
            name = readInputString(scan, "Username:");
            user = appState.filmItb.getUserByName(name);
        }
        AppState.currentUser = user;
    }
}