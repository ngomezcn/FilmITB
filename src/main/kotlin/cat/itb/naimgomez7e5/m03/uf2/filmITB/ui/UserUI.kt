package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.management.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import java.util.*

/**
 * Author: Garsemar & Ngomez
 * Date: 04/02/2022
 *
 * Console interface to....
 */
class UserUI(var scan: Scanner) {

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

        when (inputInt(scan)) {
            1 -> addUser()
            2 -> showUser()
            3 -> viewUsers()
            4 -> updateUser()
            5 ->  deleteUser()
            6 ->  changeUser()
            7 ->  showStats()
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
            name = readInputString(scan, "User name:"),
            lastName = readInputString(scan,"User's last name:"),
            //age = inputInt("User's age:")
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

        val user = selectUserFromMenu("Which user do you want to moaadify?",);

        println("[Selected: ${user.name} ${user.lastName}]")
        println("1: Change name")
        println("2: Change last name")
        println("3: Change age")
        println("0: Back to menu")

        when (inputInt(scan)) {
            1 -> {
                    UserManager.changeName(
                                readInputString(scan, "New name:"), user)};
            2 -> {
                    UserManager.changeLastName(
                                readInputString(scan, "New last name:"), user)};
            3 -> {
                    UserManager.changeAge(
                                inputInt(scan, "New age:"), user)};
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
            var selectedUser = inputInt(scan, "$msg (Number from 0 to $maxRange):")
            while (!AppManager.isInValidRange(0, maxRange, selectedUser)) {
                selectedUser = inputInt(scan, "$msg (Number from 0 to $maxRange):")
            }
            if (!AppManager.isCurrentUser(FilmItb.usersDB[selectedUser]) && allowCurrentUser) {
                return FilmItb.usersDB[selectedUser]
            }
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