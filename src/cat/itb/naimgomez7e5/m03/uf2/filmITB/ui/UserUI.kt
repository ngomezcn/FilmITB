package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*

class UserUI {

    fun showMenu() {
        UI().clearConsole();
        println("Users:")
        println("1: Add user")
        println("2: Show my user")
        println("3: View users")
        println("4: Update user")
        println("5: Delete user")
        println("6: Change User")
        println("7: Show statistics")
        println("0: Return to main menu")

        when (AppManager.inputInt()) {
            1 -> {UI().clearConsole(); addUser(); showMenu();}
            2 -> {UI().clearConsole(); showUser(); showMenu();}
            3 -> {UI().clearConsole(); viewUsers(); showMenu();}
            4 -> {UI().clearConsole(); updateUser(); showMenu();}
            5 -> {UI().clearConsole(); deleteUser(); showMenu();}
            6 -> {UI().clearConsole(); changeUser(); showMenu();}
            7 -> {UI().clearConsole(); showStats(); showMenu();}
            0 -> UI().showMainMenu()
            else -> {
                UI().showMainMenu();
            }
        }
    }
    private fun addUser() {
        println("[Add User]")
        UserManager.addUser(
            AppManager.inputString("Nom de l'usuari:"),
            AppManager.inputString("Cognom de l'usuari:"),
            AppManager.inputInt("Edat de l'usuari:")
        )
        AppManager.awaitEnter()
    }

    private fun showUser() {
        println("[Show User]")
        println(AppState.currentUser)
        AppManager.awaitEnter();
    }

    private fun viewUsers(){
        println("[View Users]")
        UserManager.displayUsers();
        AppManager.awaitEnter();
    }

    private fun updateUser() {
        println("[Update Users]")
        UserManager.displayUsers();

        var user = AppManager.inputInt("Quin usuari vols modificar(Numero del 0 al ${FilmItb.usersDB.size-1}):")

        while(user > FilmItb.usersDB.size-1){
            user = AppManager.inputInt("Quin usuari vols modificar(Numero del 0 al ${FilmItb.usersDB.size-1}):")
        }
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppManager.inputInt()) {
            1 -> UserManager.changeName(AppManager.inputString("Nou nom:"))
            2 -> UserManager.changeLastName(AppManager.inputString("Nou cognom:"))
            3 -> UserManager.changeAge(AppManager.inputInt("Nova edat:"))
            0 -> showMenu()
            else -> {
                showMenu()
            }
        }
        AppManager.awaitEnter();
    }
    private fun deleteUser(){
        println("[Delete User]")
        UserManager.displayUsers();

        var targetName = AppManager.inputString("Quin usuari vols eliminar?")
        var user = UserManager.getUserByName(targetName);

        while (user == null)
        {
            targetName = AppManager.inputString("Usuari inexistent! Torna a indicar l'usuari:")
            user = UserManager.getUserByName(targetName);
        }

        AppManager.awaitEnter();
        UserManager.deleteUser(user)
        UserUI().showMenu();
    }
    private fun changeUser(){
        println("Change User")
        UserManager.displayUsers();


        var user = AppManager.inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${FilmItb.usersDB.size-1}):")
        while(user > FilmItb.usersDB.size-1){
            user = AppManager.inputInt("Selecciona l'usuari que iniciar sesio(Numero del 0 al ${FilmItb.usersDB.size-1}):")
        }
        AppState.currentUser = FilmItb.usersDB[user]
        showMenu()
    }
    private fun showStats(){
        TODO()
    }
}