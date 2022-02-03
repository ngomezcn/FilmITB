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
    private fun addUser() {// i entonces donde creo el usuario
        User.addUser(
            AppState().inputString("Nom de l'usuari:"),
            AppState().inputString("Cognom de l'usuari:"),
            AppState().inputInt("Edat de l'usuari:")
        )
    }
    private fun showUser() {
        println(AppState.currentUser)
    }
    private fun viewUsers(){
        println(AppState.myUsers)
    }
    private fun updateUser() {
        val user = AppState.myUsers[AppState().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.myUsers.size}): ")].name
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppState().inputInt()) {
            1 -> changeName(user)
            2 -> changeLast(user)
            3 -> changeAge(user)
            0 -> showMenu()
            else -> {
                showMenu()
            }
        }
    }
    private fun changeAge(user: String) {
        TODO("Not yet implemented")
    }
    private fun changeLast(user: String) {
        TODO("Not yet implemented")
    }
    private fun changeName(user: String) {
        TODO("Not yet implemented")
    }
}