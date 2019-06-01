package resasoftware.com.pe.nearme.models

import com.orm.SugarRecord
import java.io.Serializable

data class Preferences (
    val name: String
) : SugarRecord(){
    constructor() : this("")
    companion object {
        fun addPreference(preference: Category, icon: Int): Boolean {
            val pref: Preferences = Preferences(name = preference.name)
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
                SugarRecord.delete(pref)
                return true
            }
            catch (e: Exception){
                return false
            }
        }

        fun allPreferences(): ArrayList<Preferences>{
            val preferences = SugarRecord.findAll(Preferences::class.java)
            return preferences as ArrayList<Preferences>
        }
    }
}
