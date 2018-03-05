package club.bweakfast.foodora.auth

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import club.bweakfast.foodora.ErrorDisplay
import club.bweakfast.foodora.Irrelevant
import club.bweakfast.foodora.R
import club.bweakfast.foodora.Validator
import club.bweakfast.foodora.addValidation
import club.bweakfast.foodora.validate
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * Created by Rushil on 8/21/2017.
 */
class RegisterFragment : Fragment(), ErrorDisplay {
    private lateinit var inputValidators: Map<TextInputLayout, List<Validator>>

    val loadLoginPage = PublishSubject.create<Irrelevant>()
    val register = PublishSubject.create<Pair<String, String>>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputValidators = mapOf(
            nameInputLayout to listOf(Validator.empty()),
            usernameInputLayout to listOf(Validator.empty()),
            emailInputLayout to listOf(
                Validator.empty(),
                Validator.emailValid()
            ),
            passwordInputLayout to listOf(
                Validator.empty(),
                Validator.passwordValid()
            )
        )

        passwordInputLayout.editText?.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == R.integer.action_register_id || id == EditorInfo.IME_NULL) {
                attemptRegister()
                return@OnEditorActionListener true
            } else {
                false
            }
        })
        loginButton.setOnClickListener { loadLoginPage.onNext(Irrelevant.INSTANCE) }
        registerButton.setOnClickListener { attemptRegister() }
        inputValidators.forEach { (inputLayout, validators) ->
            validators.forEach {
                inputLayout.addValidation(it.validate, it.errorMessage)
            }
        }
    }

    override fun showError(error: String?) {
        if (error == "Username is Null") {
            usernameInputLayout?.error = getString(R.string.error_field_required)
            usernameInputLayout?.requestFocus()
        } else if (error == "Password is Null") {
            passwordInputLayout?.error = getString(R.string.error_field_required)
            passwordInputLayout?.requestFocus()
        }
    }

    private fun attemptRegister() {
        val focusView = validate()

        if (focusView != null) {
            focusView.requestFocus()
        } else {
//            val name = nameInputLayout.editText?.text.toString()
//            val email = emailInputLayout.editText?.text.toString()
            val username = usernameInputLayout.editText?.text.toString()
            val password = passwordInputLayout.editText?.text.toString()
            register.onNext(username to password)
        }
    }

    private fun validate(): TextInputLayout? {
        var focusView: TextInputLayout? = null
        inputValidators.keys.forEach { textInputLayout ->
            focusView = if (!textInputLayout.validate()) {
                focusView ?: textInputLayout
            } else {
                focusView
            }
        }
        return focusView
    }

    companion object {
        fun newInstance(): RegisterFragment = RegisterFragment()
    }
}