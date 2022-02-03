package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import java.util.*
import cat.itb.naimgomez7e5.m03.uf2.filmITB.model.User

class AppManager {
    private val scan = Scanner(System.`in`)

    /**
     * Interface for integer input
     * */
    fun inputInt(msg: String = "Input:") : Int
    {
        print("$msg ")
        return scan.nextLine().toInt();
    }

    /**
     * Interface for character string input
     * */
    fun inputString(msg: String = "Input:") : String
    {
        print("$msg ");
        return scan.nextLine();
    }
}