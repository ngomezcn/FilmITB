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
            1 -> {UI().clearConsole(); addUser();    AppManager.awaitEnter(); showMenu();}
            2 -> {UI().clearConsole(); showUser();   AppManager.awaitEnter(); showMenu();}
            3 -> {UI().clearConsole(); viewUsers();  AppManager.awaitEnter(); showMenu();}
            4 -> {UI().clearConsole(); updateUser(); AppManager.awaitEnter(); showMenu();}
            5 -> {UI().clearConsole(); deleteUser(); AppManager.awaitEnter(); showMenu();}
            6 -> {UI().clearConsole(); changeUser(); AppManager.awaitEnter(); showMenu();}
            7 -> {UI().clearConsole(); showStats();  AppManager.awaitEnter(); showMenu();}
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
        val newUser = User(
            name = AppManager.inputString("User name:"),
            lastName = AppManager.inputString("User's last name:"),
            age = AppManager.inputInt("User's age:")
        )
        UserManager.addUser(newUser);
        println("Usuari creat amb èxit!")
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
    }

    /**
     *  Update the selected user
     */
    private fun updateUser() {
        println("[Update Users]")

        val user = selectUserFromMenu("Which user do you want to modify?",);

        println("[Selected: ${user.name} ${user.lastName}]")
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (AppManager.inputInt()) {
            1 -> {
                    UserManager.changeName(
                                AppManager.inputString("New name:"), user)};
            2 -> {
                    UserManager.changeLastName(
                                AppManager.inputString("New last name:"), user)};
            3 -> {
                    UserManager.changeAge(
                                AppManager.inputInt("New age:"), user)};
            0 -> showMenu()
            else -> {
                showMenu()
            }
        }
    }

    private fun selectUserFromMenu(msg : String, allowCurrentUser : Boolean = true, errorMsg : String = msg) : User
    {
        displayUsers();

        val maxRange = FilmItb.usersDB.size-1;

        while(true) {
            var selectedUser = AppManager.inputInt("$msg (Number from 0 to $maxRange):")
            while (!AppManager.isInValidRange(0, maxRange, selectedUser)) {
                selectedUser = AppManager.inputInt("$msg (Number from 0 to $maxRange):")
            }
            if (!AppManager.isCurrentUser(FilmItb.usersDB[selectedUser]) && !allowCurrentUser) {
                return FilmItb.usersDB[selectedUser];
            }
            println("\n$errorMsg")
        }

        /*displayUsers();
        var maxRange = FilmItb.usersDB.size-1;
        var selectedUser : Int;
        while(true){
            selectedUser = AppManager.inputInt("$msg (Number from 0 to $maxRange):")
            if(AppManager.isInValidRange(0, maxRange, selectedUser))
            {
                if(AppManager.isCurrentUser(FilmItb.usersDB[selectedUser]) && !allowCurrentUser)
                {
                    println("\n$errorMsg")
                }
                else
                {
                    return FilmItb.usersDB[selectedUser];
                }
            }
        }*/
    }

    /**
     * Delete the indicated user
     * */
    private fun deleteUser(){
        println("[Delete User]")

        val user = selectUserFromMenu("Which user do you want to delete?", false,"You can't delete the user that is currently logged in!");
        UserManager.deleteUser(user)
        println("Successfully removed!")
    }
    private fun changeUser(){
        println("[Change User]")

        val user = selectUserFromMenu("Select the user to login", false, "You are already logged with this user")
        AppState.currentUser = user

        println("Done!\n Current user: ${AppState.currentUser.name}")
    }
    private fun showStats(){
        println("TODO: showStats()")
        UI().exit()
    }
}