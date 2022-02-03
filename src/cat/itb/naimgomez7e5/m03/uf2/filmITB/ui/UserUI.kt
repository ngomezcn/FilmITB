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
        println(AppState.usersDB)
        showMenu()
    }

    private fun updateUser() {
        for(i in AppState.usersDB.indices){
            println(AppState.usersDB[i].name)
        }
        var user = AppState().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.usersDB.size-1}):")
        while(user > AppState.usersDB.size-1){
            user = AppState().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.usersDB.size-1}):")
        }
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppState().inputInt()) {
            1 -> User.changeName(AppState().inputString("Nou nom:"))
            2 -> User.changeLastName(AppState().inputString("Nou cognom:"))
            3 -> User.changeAge(AppState().inputInt("Nova edat:"))
            0 -> showMenu()
            else -> {
                showMenu()
            }
        }
        showMenu()
    }
    private fun deleteUser(){

        for(i in AppState.usersDB.indices){
            println("$i: ${AppState.usersDB[i].name}")
        }

        var targetName = AppState().inputString("Quin usuari vols eliminar?")
        var user = User.getUserByName(targetName);

        while (user == null)
        {
            targetName = AppState().inputString("Usuari inexistent! Torna a indicar l'usuari:")
            user = User.getUserByName(targetName);
        }

        User.deleteUser(user)

        UserUI().showMenu();
    }
    private fun changeUser(){
        var user = AppState().inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${AppState.usersDB.size-1}):")
        while(user > AppState.usersDB.size-1){
            user = AppState().inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${AppState.usersDB.size-1}):")
        }
        AppState.currentUser = AppState.usersDB[0]
    }
    private fun showStats(){
        TODO()
    }
}