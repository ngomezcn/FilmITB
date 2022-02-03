package cat.itb.naimgomez7e5.m03.uf2.filmITB.ui

import java.util.*

class AppState {
    val scan = Scanner(System.`in`)

    fun inputInt() : Int
    {
        print("Input: ")
        return scan.nextLine().toInt();
    }
}

