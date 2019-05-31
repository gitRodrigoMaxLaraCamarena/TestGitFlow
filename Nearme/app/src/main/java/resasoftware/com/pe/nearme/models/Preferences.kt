package resasoftware.com.pe.nearme.models

import com.orm.SugarRecord
import java.io.Serializable

data class Preferences (
    val name: String,
    val description: String,
    val icon: Int
): SugarRecord(), Serializable {
    constructor() : this(
        "",
        "",
        0
    )
    companion object {
        fun addPreference(preference: Category, icon: Int): Boolean {
            val pref: Preferences = Preferences(name = preference.name, description = preference.description, icon = icon)
            try{
                SugarRecord.save(pref)
                return true
            }catch (e: Exception){
                return false
            }
        }

        fun removePreference(preference: Preferences): Boolean{
            try {
                val pref = SugarRecord.find(Preferences::class.java, "name = ?", preference.name)
                return true
            }
            catch (e: Exception){
                return false
            }
        }

        fun allPreferences(): ArrayList<Preferences> {
            var preferences: ArrayList<Preferences> = ArrayList<Preferences>()
            preferences = SugarRecord.findAll(Preferences::class.java) as ArrayList<Preferences>
            return preferences
        }
    }
}
