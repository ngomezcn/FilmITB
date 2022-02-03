package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*

class AppState {
    val scan = Scanner(System.`in`)

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

