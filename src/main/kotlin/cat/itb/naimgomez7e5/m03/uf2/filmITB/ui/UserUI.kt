package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*

/**
 * Author: Garsemar & Ngomez
 * Date: 04/02/2022
 *
 * Console interface to....
 */
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
            1 -> {UI().clearConsole(); addUser();    showMenu();}
            2 -> {UI().clearConsole(); showUser();   showMenu();}
            3 -> {UI().clearConsole(); viewUsers();  showMenu();}
            4 -> {UI().clearConsole(); updateUser(); showMenu();}
            5 -> {UI().clearConsole(); deleteUser(); showMenu();}
            6 -> {UI().clearConsole(); changeUser(); showMenu();}
            7 -> {UI().clearConsole(); showStats();  showMenu();}
            0 -> UI().showMainMenu()
            else -> {
                UI().showMainMenu()
            }
        }
    }

    /**
     *  Human interface to add a new user
     */
    private fun addUser() {
        println("[Add User]")
        UserManager.addUser(
            AppManager.inputString("User name:"),
            AppManager.inputString("User's last name:"),
            AppManager.inputInt("User's age:")
        )
        AppManager.awaitEnter()
    }

    /**
     *  Print a formatted list of all users
     */
    private fun displayUsers()
    {
        for(i in FilmItb.usersDB.indices){
            val user = FilmItb.usersDB[i];

            if(user == AppState.currentUser)
            {
                println("$i: ${user.name} ${user.lastName} (Current logged)")
            } else
            {
                println("$i: ${user.name} ${user.lastName}")
            }
        }
    }

    /**
     *  Show your current user
     */
    private fun showUser() {
        println("[Show User]")
        println("Name: ${AppState.currentUser.name}")
        println("Last name: ${AppState.currentUser.lastName}")
        println("Age: ${AppState.currentUser.age}")
        AppManager.awaitEnter();
    }

    /**
     *  List all current users of the usersDB
     */
    private fun viewUsers(){
        println("[View Users]")
        displayUsers();
        AppManager.awaitEnter();
    }

    /**
     *  Update the selected user
     */
    private fun updateUser() {
        println("[Update Users]")
        displayUsers();

        var userIndex = AppManager.inputInt("Which user would you like to modify (Number from 0 to ${FilmItb.usersDB.size-1}):")

        while(userIndex > FilmItb.usersDB.size-1){
            userIndex = AppManager.inputInt("Which user would you like to modify (Number from 0 to ${FilmItb.usersDB.size-1}):")
        }
        println("[Selected: ${FilmItb.usersDB[userIndex].name} ${FilmItb.usersDB[userIndex].lastName}]")
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppManager.inputInt()) {
            1 -> {
                    UserManager.changeName(
                                AppManager.inputString("New name:"),
                                FilmItb.usersDB[userIndex])};
            2 -> {
                    UserManager.changeLastName(
                                AppManager.inputString("New last name:"),
                                FilmItb.usersDB[userIndex])};
            3 -> {
                    UserManager.changeAge(
                                AppManager.inputInt("New age:"),
                                FilmItb.usersDB[userIndex])};
            0 -> showMenu()
            else -> {
                showMenu()
            }
        }
        AppManager.awaitEnter();
    }

    /**
     * Delete the indicated user
     * */
    private fun deleteUser(){
        println("[Delete User]")
        displayUsers();

        var userIndex = AppManager.inputInt("Which user do you want to delete? (Number from 0 to ${FilmItb.usersDB.size-1}):")
        while(userIndex > FilmItb.usersDB.size-1){
            userIndex = AppManager.inputInt("Which user do you want to delete? (Number from 0 to ${FilmItb.usersDB.size-1}):")
        }

        AppManager.awaitEnter();
        UserManager.deleteUser(FilmItb.usersDB[userIndex])
        println("Successfully removed!")
        UserUI().showMenu();
    }
    private fun changeUser(){
        println("Change User")
        displayUsers();

        var user = AppManager.inputInt("Select the user to login (Number from 0 to ${FilmItb.usersDB.size-1}):")
        while(user > FilmItb.usersDB.size-1){
            user = AppManager.inputInt("Select the user to login (Number from 0 to ${FilmItb.usersDB.size-1}):")
        }
        AppState.currentUser = FilmItb.usersDB[user]

        println("Done!")
        println("Current user: ${AppState.currentUser.name}")
        AppManager.awaitEnter();
    }
    private fun showStats(){
        println("TODO: showStats()")
        UI().exit()
    }
}