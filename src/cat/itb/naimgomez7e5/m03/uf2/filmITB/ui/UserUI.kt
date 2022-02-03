package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.UserManager
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*

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

        when (AppManager().inputInt()) {
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
        UserManager.addUser(
            AppManager().inputString("Nom de l'usuari:"),
            AppManager().inputString("Cognom de l'usuari:"),
            AppManager().inputInt("Edat de l'usuari:")
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
        var user = AppManager().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.usersDB.size-1}):")
        while(user > AppState.usersDB.size-1){
            user = AppManager().inputInt("Quin usuari vols modificar(Numero del 0 al ${AppState.usersDB.size-1}):")
        }
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppManager().inputInt()) {
            1 -> UserManager.changeName(AppManager().inputString("Nou nom:"))
            2 -> UserManager.changeLastName(AppManager().inputString("Nou cognom:"))
            3 -> UserManager.changeAge(AppManager().inputInt("Nova edat:"))
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

        var targetName = AppManager().inputString("Quin usuari vols eliminar?")
        var user = UserManager.getUserByName(targetName);

        while (user == null)
        {
            targetName = AppManager().inputString("Usuari inexistent! Torna a indicar l'usuari:")
            user = UserManager.getUserByName(targetName);
        }

        UserManager.deleteUser(user)

        UserUI().showMenu();
    }
    private fun changeUser(){
        var user = AppManager().inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${AppState.usersDB.size-1}):")
        while(user > AppState.usersDB.size-1){
            user = AppManager().inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${AppState.usersDB.size-1}):")
        }
        AppState.currentUser = AppState.usersDB[0]
    }
    private fun showStats(){
        TODO()
    }
}