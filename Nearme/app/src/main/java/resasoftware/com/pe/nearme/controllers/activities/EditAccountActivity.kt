package resasoftware.com.pe.nearme.controllers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_edit_account.*
import resasoftware.com.pe.nearme.R

class EditAccountActivity : AppCompatActivity() {

    private var image: Int = 1
    private val fullname_error: String = "invalid fullname"
    private val email_error: String = "invalid email"
    private val password_error: String = "invalid password"

    private var fullname: String = ""
    private var email: String = ""
    private var password: String = ""

    private var pattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_account)
    }

    override fun onResume() {
        super.onResume()

        buttonSave.setOnClickListener {
            if(ValidateInputs()){
                // Guadar la info
            }
        }

        image_edit_visibilitypassword.setOnClickListener {
            image*=-1

            if(image == -1){
                image_edit_visibilitypassword.setImageResource(R.drawable.ic_visibility_off_black_24dp)
                text_edit_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
            }else if(image == 1){
                image_edit_visibilitypassword.setImageResource(R.drawable.ic_visibility_black_24dp)
                text_edit_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }

    private fun ValidateInputs(): Boolean{
        var response: Boolean = true
        fullname = text_edit_fullname.text.toString()
        email = text_edit_email.text.toString()
        password = text_edit_password.text.toString()

        if(fullname.isBlank()){
            response = false
            text_edit_error_fullname.text = fullname_error
        }else{
            text_edit_error_fullname.text = ""
        }

        if(pattern.matcher(email).matches()){
            response = false
            text_edit_error_email.text = email_error
        }else{
            text_edit_error_email.text = ""
        }

        if(password.isBlank()){
            response = false
            text_edit_error_password.text = password_error
        }else{
            text_edit_error_password.text = ""
        }

        return response
    }
}