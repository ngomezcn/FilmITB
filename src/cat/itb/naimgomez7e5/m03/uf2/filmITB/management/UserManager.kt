package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.*

class UserManager {
    companion object {
        /**
         * Creates a new user, all the fields of the User(...) constructor will be passed
         */
        fun addUser(name: String, lastName: String, age: Int) {
            FilmItb.usersDB.add(
                User(name, lastName, age)
            )
            println("Usuari creat amb èxit!")
        }

        /**
         * By default, changes the field name of the currentUser
         */
        fun changeName(newName: String, user: User = AppState.currentUser) {
            user.name = newName;
        }

        /**
         * By default, changes the field name of the currentUser the field lastName of the currentUser
         */
        fun changeLastName(newLastName: String, user: User = AppState.currentUser) {
            user.lastName = newLastName;
        }

        /**
         * By default, changes the field age of the currentUser
         */
        fun changeAge(newAge: Int, user: User = AppState.currentUser) {
            user.age = newAge;
        }

        /**
         * Deletes the indicated user from the database
         */
        fun deleteUser(user: User = AppState.currentUser){

            FilmItb.usersDB.removeAt(
                FilmItb.usersDB.indexOf(user)
            );

            if(AppState.currentUser == user)
            {
                println("Actualment, estàs utilitzant aquest usuari, no el pots eliminar.")
            }
            else
            {
                FilmItb.usersDB.removeAt(
                    FilmItb.usersDB.indexOf(user)
                );
            }

            println("Usuari eliminat amb èxit.")
        }

        /**
         * Return a User(...) obtained by iterating the DB.
         */
        fun getUserByName(indicatedName : String) : User?
        {
            for (user in FilmItb.usersDB)
            {
                if(user.name.lowercase() == indicatedName.lowercase())
                {
                    return user;
                }
            }
            return null;
        }

    }
}
// xmllint --shell hol.xml
