package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*

class LoginUI {

    fun showMenu()
    {
        println("Welcome to AppManager login")
        println("Indica el nom de l'usuari que vols utilitzar.")

        var name = AppManager.inputString("Username:");
        var user = UserManager.getUserByName(name);

        while (user == null)
        {
            name = AppManager.inputString("Nom:");
            user = UserManager.getUserByName(name);

            println("Aquest usuari no existeix!")
            println("Torna a indicar el nom de l'usuari que vols utilitzar.")
        }

        AppState.currentUser = user;
    }
}