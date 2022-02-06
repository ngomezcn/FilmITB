package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.*
import java.net.URL

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
         * By default, changes the field name of the currentUser
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
        fun deleteUser(user: User){

            FilmItb.usersDB.removeAt(
                FilmItb.usersDB.indexOf(user)
            );

            println("Usuari eliminat amb èxit.")
        }

        /**
         * Find user by name.
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

        /**
         * Load data from remote repo
         * */
        fun loadData(url: String)
        {
            val data = AppManager.getCSVFromUrl(URL(url))

            if(data.hasNextLine()) data.nextLine() // Remove header CSV
            while (data.hasNextLine())
            {
                val values = data.nextLine().split(",")
                val sValues = mutableListOf<String>()
                val iValues = mutableListOf<Int>()
                for(i in values)
                {
                    if(i.toIntOrNull() == null)
                    {
                        sValues.add(i);
                    } else {
                        iValues.add(i.toInt())
                    }
                }
                FilmItb.usersDB.add(User(sValues, iValues));
            }
        }
    }
}
// xmllint --shell hol.xml
