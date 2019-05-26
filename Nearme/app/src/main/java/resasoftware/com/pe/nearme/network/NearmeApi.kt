package resasoftware.com.pe.nearme.network

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import resasoftware.com.pe.nearme.models.User
import com.androidnetworking.interfaces.JSONObjectRequestListener
import resasoftware.com.pe.nearme.models.Type_User
import org.json.JSONObject


class NearmeApi {
    companion object {
        private val BASE_URL = "https://nearme-api-rest.herokuapp.com"
        private val categoryURL = "$BASE_URL/categories"
        private val commentURL = "$BASE_URL/comments"
        private val enterpriceURL = "$BASE_URL/enterprises"
        private val typeUserURL = "$BASE_URL/type_users"
        private val userURL = "$BASE_URL/users"

        private val TAG = "NearmeApi"


        fun getUserType(id: Int?, responseHandler: (ArrayList<Type_User>?) -> Unit,
                           errorHandler: (ANError) -> Unit) {
            get(typeUserURL, id, responseHandler, errorHandler)

        }

        fun postUser(user: User) {
            val json: JSONObject = user.converToJson()
            post(json, userURL)

        }

        // GET - All
        private inline fun <reified T> get(
            url: String, id: Int?, crossinline responseHandler: (ArrayList<T>?) -> Unit,
            crossinline errorHandler: (ANError) -> Unit
        ) {
            var URL: String = url
            id?.apply {
                URL = "$url/$id"
            }
            AndroidNetworking.get(URL)
                .setTag(TAG)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObjectList(T::class.java,
                    object : ParsedRequestListener<ArrayList<T>> {
                        override fun onResponse(response: ArrayList<T>?) {
                            response?.apply {
                                responseHandler(response)
                            }

                        }

                        override fun onError(anError: ANError?) {
                            anError?.apply {
                                Log.d(TAG, "Error $errorCode: $errorBody $localizedMessage")
                                errorHandler(this)
                            }
                        }

                    }
                )
        }

        // Post - All
        private inline fun  post(obj: JSONObject, url: String) {
            AndroidNetworking.post(url)
                .addHeaders("Content-Type", "application/json")
                .addJSONObjectBody(obj)
                .setTag(TAG)
                .setPriority(Priority.HIGH)
                .build()
        }
    }
}


