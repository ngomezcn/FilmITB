package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class AppState {
    private val scan = Scanner(System.`in`)

    companion object {
        val myUsers = mutableListOf<User>(
            User("Juan", "Lopez", 45),
            User("Rosa", "Melano", 70),
        );
        var currentUser = User;
    }

    fun inputInt(msg: String = "Input:") : Int
    {
        print("$msg ")
        return scan.nextLine().toInt();
    }

    fun inputString(msg: String = "Input:") : String
    {
        print("$msg ");
        return scan.nextLine();
    }
}

