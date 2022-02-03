package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class UserUI {

    fun showMenu() {
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
            2 -> showUser()
            3 -> viewUsers()
            4 -> updateUser()
            0 -> UI().showMainMenu();
            else -> {
                UI().showMainMenu();
            }
        }

    }
    fun addUser() {
        AppState().myUsers.add(
            User(
                AppState().inputString("Nom de l'usuari: "),
                AppState().inputString("Cognom de l'usuari: "),
                AppState().inputInt("Edat de l'usuari: ")
            )
        )
        println("Usuari creat amb èxit!")
    }
    private fun showUser() {
        TODO()
    pero si tiene contrasenya o algo asi suma puntio

    }
    private fun viewUsers(){
        println(User)
    }
    private fun updateUser() {
        TODO("Not yet implemented")
    }
}