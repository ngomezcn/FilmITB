package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class AppState {
    val scan = Scanner(System.`in`)
    val myUsers = mutableListOf<User>();
    val currentUser : User = myUsers[0];

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

