package cat.itb.naimgomez7e5.m03.uf2.filmITB.model

class FilmItb {

    companion object {
        val filmsDB = mutableListOf<Film>();
        val filmsURL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSfwJrQbPwQX0EAB3O5t_hQ4IwKPaxDr7a4RELng1sMxKT7gSNIi0B-72w9jaRvpUGnvaYuMKuPwfSA/pub?output=csv";

        val usersDB = mutableListOf<User>();
        val usersURL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vQBtQVIUV6oTkkqvlWMpWfUTyLanzsYvApKh860-vClyei8_ZM-4yoYeWgGjMj_HEFpd1XoMxx3y0JX/pub?output=csv";
    }
}