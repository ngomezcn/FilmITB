package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.utils.getCSVFromUrl
import java.net.URL

data class UserManager (private val appState: AppState) {
    /**
     * Creates a new user, all the fields of the User(...) constructor will be passed
     */

    /**
     * By default, changes the field name of the currentUser
     */
    fun changeName(newName: String, user: User = appState.currentUser) {
        user.name = newName
    }

    /**
     * By default, changes the field name of the currentUser
     */
    fun changeLastName(newLastName: String, user: User = appState.currentUser) {
        user.lastName = newLastName
    }

    /**
     * By default, changes the field age of the currentUser
     */
    fun changeAge(newAge: Int, user: User = appState.currentUser) {
        user.age = newAge
    }

    /**
     * Deletes the indicated user from the database
     */
    fun deleteUser(user: User) {

        appState.users.removeAt(
            appState.users.indexOf(user)
        )
    }

    /**
     * Find user by name.
     */
    fun getUserByName(indicatedName: String): User? {
        for (user in users) {
            if (user.name.lowercase() == indicatedName.lowercase()) {
                return user
            }
        }
        return null
    }

    /**
     * Creates a new user, all the fields of the User(...) constructor will be passed
     */
    fun addUser(name: String, lastName: String, age: Int) {
        users.add(User(name, lastName, age))
    }

    /**
     * Load data from remote repo
     * */
    private fun loadDataUsers(url: String) {
        val data = getCSVFromUrl(URL(url))

        if (data.hasNextLine()) data.nextLine() // Remove header CSV
        while (data.hasNextLine()) {
            val values = data.nextLine().split(",")
            val sValues = mutableListOf<String>()
            val iValues = mutableListOf<Int>()
            for (i in values) {
                if (i.toIntOrNull() == null) {
                    sValues.add(i)
                } else {
                    iValues.add(i.toInt())
                }
            }
            users.add(User(sValues, iValues))
        }
    }

    fun isCurrentUser(user: User): Boolean {
        if (appState.currentUser == user) {
            return true
        }
        return false

    }
}

