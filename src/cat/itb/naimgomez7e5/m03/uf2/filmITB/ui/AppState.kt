package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class AppState {

    companion object {
        val usersDB = mutableListOf<User>(
            User("Juan", "Lopez", 45),  // Predefined test data
            User("Rosa", "Melano", 70), // Predefined test data
        );
        lateinit var currentUser : User;
    }

}

