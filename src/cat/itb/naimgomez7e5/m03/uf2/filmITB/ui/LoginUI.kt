package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class LoginUI {
    fun showMenu()
    {
        println("==[ FilmItb Login Page ]==")
        while (AppState.currentUser == null)
        {
            println("Indica el nom del usuari que vols utilitzar:")

            val name = AppState().inputString("Nom: ")
            val validate = getUserIfExists(name);
            if(validate != null)
            {
                AppState.currentUser = validate;
            }
            println("Usuari no valid")
        }
    }

    private fun getUserIfExists(indicatedName : String) : User?
    {
        for (user in AppState.myUsers)
        {
            if(user.name.lowercase() == indicatedName.lowercase())
            {
                return user;
            }
        }
        return null;
    }
}