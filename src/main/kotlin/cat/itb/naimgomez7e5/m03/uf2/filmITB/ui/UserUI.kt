package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.isCurrentUser
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.isInValidRange
import java.util.*

/**
 * Author: Garsemar & Ngomez
 * Date: 04/02/2022
 *
 * Console interface to....
 */
class UserUI(val scan: Scanner, var appState : AppState) {


    fun showUsersMenu() : AppState {

        while (true) {
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
                5 -> deleteUser()
                6 -> changeUser()
                7 -> showStats()
                0 -> return appState
                else -> {
                    return appState
                }
            }
            showUsersMenu()
        }
    }

    /**
     *  Human interface to add a new user
     */
    private fun addUser() {
        println("[Add User]")
        appState.filmItb.addUser(

            name = inputString(scan, "User name:"),
            lastName = inputString(scan,"User's last name:"),
            age = inputInt(scan,"User's age:"));
        println("Usuari creat amb èxit!")
    }

    /**
     *  Print a formatted list of all users
     */
    private fun displayUsers()
    {
        for(i in appState.filmItb.users.indices){
            val user = appState.filmItb.users[i];

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
                    appState.filmItb.changeName(inputString(scan, "New name:"), user)};
            2 -> {
                    appState.filmItb.changeLastName(inputString(scan, "New last name:"), user)};
            3 -> {
                    appState.filmItb.changeAge(inputInt(scan, "New age:"), user)};
            0 -> return
            else -> {
                return
            }
        }
    }

    private fun selectUserFromMenu(msg : String, allowCurrentUser : Boolean = true, errorMsg : String = msg) : User
    {

        displayUsers();
        val maxRange = appState.filmItb.users.size-1;
        var selectedUser : Int;
        while(true){
            selectedUser = inputInt(scan, "$msg (Number from 0 to $maxRange):")
            if(isInValidRange(0, maxRange, selectedUser))
            {
                if(isCurrentUser(appState.filmItb.users[selectedUser]) && !allowCurrentUser)
                {
                    println("\n$errorMsg")
                }
                else
                {
                    return appState.filmItb.users[selectedUser]
                }
            }
        }
    }

    /**
     * Delete the indicated user
     * */
    private fun deleteUser(){
        println("[Delete User]")

        val user = selectUserFromMenu("Which user do you want to delete?", false,"You can't delete the user that is currently logged in!");
        appState.filmItb.deleteUser(user)
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