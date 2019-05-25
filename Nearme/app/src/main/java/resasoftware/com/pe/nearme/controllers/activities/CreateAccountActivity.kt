package resasoftware.com.pe.nearme.controllers.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_create_account.*
import resasoftware.com.pe.nearme.R
import android.widget.RadioGroup



class CreateAccountActivity : AppCompatActivity() {
    private var email: String = ""
    private var password: String = ""
    private var name: String = ""
    private var sex: String = ""

    private val pattern = Patterns.EMAIL_ADDRESS
    private val passwordError = "password can't be null or empty"
    private var emailError = "invalid email address"
    private val nameError = "password can't be null or empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        radioButton_male.isChecked = true
        sex = "Male"

        buttonSave.setOnClickListener {
            email = input_create_email.text.toString()
            password = input_create_password.text.toString()
            name = input_create_fullname.text.toString()

            email.apply {
                if (!validateEmail(this)){
                    text_create_error_email.text = emailError
                }else{
                    text_create_error_email.text = ""
                }
            }

            password.apply {
                if(this.isBlank()) {
                    text_create_error_password.text = passwordError
                }else{
                    text_create_error_password.text = ""
                }
            }

            name.apply {
                if(this.isBlank()) {
                    text_create_error_fullname.text = nameError
                }else{
                    text_create_error_fullname.text = ""
                }
            }
        }
        select_create_gender.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton_male -> sex = "Male"
                R.id.radioButton_female -> sex = "Female"
                R.id.radioButton_other -> sex = "I don't Know"
            }
        })
        /*
        radioButton_male.setOnCheckedChangeListener { _, isChecked -> sex = "Male" }
        radioButton_female.setOnCheckedChangeListener { _, isChecked -> sex = "Female" }
        radioButton_other.setOnCheckedChangeListener { _, isChecked -> sex = "I don't Know" }

        if(radioButton_male.isChecked){
            sex = "Male"
        }else if(radioButton_female.isChecked){
            sex = "Female"
        }else if(radioButton_other.isChecked){
            sex = "I don\'t Know"
        }
        */
    }

    private fun validateEmail(value: String): Boolean{
        return pattern.matcher(value).matches()
    }

    private fun create(){

        //val intent: Intent = Intent(this, LoginActivity::class.java)
       // startActivity(intent)
    }
}
