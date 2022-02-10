package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*

class LoginUI {

    fun showMenu()
    {
        println("[Sign-In]")

        var name = AppManager.readInputString("Indicate your username:");
        var user = UserManager.getUserByName(name);

        while (user == null)
        {
            println("Aquest usuari no existeix!")
            println("Torna a indicar el nom de l'usuari que vols utilitzar.")
            name = AppManager.readInputString("Username:");
            user = UserManager.getUserByName(name);
        }
        AppState.currentUser = user;
    }
}