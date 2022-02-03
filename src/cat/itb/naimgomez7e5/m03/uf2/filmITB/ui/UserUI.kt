package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

class UserUI {

    fun showMenu()
    {
        println("Users:")
        println("1: Add user")
        println("2: Show my user")
        println("3: View users")
        println("4: Update user")
        println("5: Delete user")
        println("6: Change User")
        println("7: Show statistics")
        println("0: Return to main menu")

        when (AppState().inputInt()) {
            1 -> addUser()
            // TODO: Pon aqui las funciones que vayas creando

            0 -> UI().showMainMenu();
            else -> {
                UI().showMainMenu();
            }
        }

    }

    fun addUser()
    {
        // Mete las opciones que creas
    }
}