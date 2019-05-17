package resasoftware.com.pe.nearme.controllers.fragments


import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_account.*
import resasoftware.com.pe.nearme.R
import resasoftware.com.pe.nearme.controllers.activities.EditAccountActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AccountFragment : Fragment() {
    var image: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onResume() {
        super.onResume()
        buttonEdit.setOnClickListener {
            val intent = Intent(this.activity, EditAccountActivity::class.java)
            startActivity(intent)
        }

        image_visibilitypassword.setOnClickListener {
            image*=-1

            if(image == -1){
                image_visibilitypassword.setImageResource(R.drawable.ic_visibility_off_black_24dp)
                text_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
            }else if(image == 1){
                image_visibilitypassword.setImageResource(R.drawable.ic_visibility_black_24dp)
                text_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }
}
