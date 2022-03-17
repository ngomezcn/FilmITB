package cat.itb.naimgomez7e5.m03.uf2.filmITB.model
import kotlinx.serialization.Serializable

import cat.itb.naimgomez7e5.m03.uf2.filmITB.ui.UI

/**
 * The main model of films *Film*.
 *
 * This class has only has the attributes of a film
 *
 * @author Mgarcia & Ngomez
 * @property likes: By default it is instantiated at 0
 */
@Serializable
class Film(
    val title: String,
    val director: String,
    val genere: String,
    val mainActor: String,
    val resume: String,
    val ageRating: Int,
    val duration: Int,
    var likes: Int = 0,
){
    /**
     * Allow load data from csv more easy
     */
    constructor(sValues: List<String>, iValues: List<Int>) :
            this(
                title = sValues[0], director = sValues[1], genere = sValues[2], mainActor = sValues[3], resume =  sValues[4],
                ageRating = iValues[0], duration = iValues[1], likes= iValues[2]);
}
