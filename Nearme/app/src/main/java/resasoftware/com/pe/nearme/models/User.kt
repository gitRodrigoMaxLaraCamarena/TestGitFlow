package resasoftware.com.pe.nearme.models

import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable

data class User(
    var id: Int,
    var email: String,
    var fullname: String,
    var image: String?,
    var password: String,
    var gender: String,
    var username: String,
    var type_user_id: Type_User
): Serializable{
    constructor(): this(
        0,
        "",
        "",
        "",
        "",
        "",
        "username",
        Type_User()
    )

    fun converToJson(): JSONObject{
        val jsonUser = JSONObject()
        val jsonType = JSONObject()

        jsonType.put("id",type_user_id.id)
        jsonType.put("description",type_user_id.description)
        jsonType.put("name",type_user_id.name)

        jsonUser.put("email",email)
        jsonUser.put("fullname",fullname)
        jsonUser.put("id",id)
        jsonUser.put("image",image)
        jsonUser.put("password",password)
        jsonUser.put("sex",gender)
        jsonUser.put("username",username)
        jsonUser.put("type_user_id",jsonType)

        return jsonUser
    }
}