package cat.itb.naimgomez7e5.m03.uf2.filmITB.management

import java.util.*

class AppManager {

    companion object {
        private val scan = Scanner(System.`in`)

        /**
         * Safe interface for string input
         * */
        fun inputInt(msg: String = "Input:"): Int {
            print("$msg ")
            var rawInput = scan.nextLine().replace(" ", "")
            rawInput.lowercase() in 48.toChar()..57.toChar()

            while (rawInput == "" )
            {
                print("$msg ");
                rawInput = scan.nextLine().replace(" ", "")
            }
            return rawInput.toInt()
        }

        /**
         * Safe interface for character string input
         * */
        fun inputString(msg: String = "Input:"): String {
            print("$msg ");
            var input = scan.nextLine();
            while (input == null)
            {
                print("$msg ");
                input = scan.nextLine();
            }
            return input;
        }

        /**
         * Interface to manage exit menu
         * */
        fun awaitEnter(msg: String = "Presione enter para continuar:") {
            print("$msg ");
            scan.nextLine();
        }
    }
}
