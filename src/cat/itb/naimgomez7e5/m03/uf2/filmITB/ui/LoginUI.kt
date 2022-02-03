package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class LoginUI {

    fun showMenu()
    {
        println("Welcome to FilmItb login")
        println("Indica el nom de l'usuari que vols utilitzar.")

        var name = AppState().inputString("Username:");
        var user = User.getUserByName(name);

        while (user == null)
        {
            name = AppState().inputString("Nom:");
            user = User.getUserByName(name);

            println("Aquest usuari no existeix!")
            println("Torna a indicar el nom de l'usuari que vols utilitzar.")
        }

        AppState.currentUser = user;
    }
}