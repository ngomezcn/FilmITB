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
            5 -> deleteUser()
            6 -> changeUser()
            7 -> showStats()
            0 -> UI().showMainMenu();
            else -> {
                UI().showMainMenu();
            }
        }

    }
    private fun addUser() {
        User.addUser(
            AppState().inputString("Nom de l'usuari:"),
            AppState().inputString("Cognom de l'usuari:"),
            AppState().inputInt("Edat de l'usuari:")
        )
        showMenu()
    }
    private fun showUser() {
        println(AppState.currentUser)
        showMenu()
    }
    private fun viewUsers(){
        println(AppState.myUsers)
        showMenu()
    }
    private fun updateUser() {
        for(i in AppState.myUsers.indices){
            println(AppState.myUsers[i].name)
        }
        var user = AppState().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.myUsers.size-1}):")
        while(user > AppState.myUsers.size-1){
            user = AppState().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.myUsers.size-1}):")
        }
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppState().inputInt()) {
            1 -> User.changeName(user)
            2 -> User.changeLast(user)
            3 -> User.changeAge(user)
            0 -> showMenu()
            else -> {
                showMenu()
            }
        }
        showMenu()
    }
    private fun deleteUser(){
        for(i in AppState.myUsers.indices){
            println(AppState.myUsers[i].name)
        }
        var user = AppState().inputInt("Quin usuari vols eliminar(Numero del 0 al ${AppState.myUsers.size-1}):")
        while(user > AppState.myUsers.size-1){
            user = AppState().inputInt("Quin usuari vols eliminar(Numero del 0 al ${AppState.myUsers.size-1}):")
        }
        User.deleteUser(user)
    }
    private fun changeUser(){
        var user = AppState().inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${AppState.myUsers.size-1}):")
        while(user > AppState.myUsers.size-1){
            user = AppState().inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${AppState.myUsers.size-1}):")
        }
        AppState.currentUser = AppState.myUsers[0]
    }
    private fun showStats(){
        TODO()
    }
}