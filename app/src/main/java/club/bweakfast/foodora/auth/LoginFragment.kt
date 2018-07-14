package club.bweakfast.foodora.auth

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import club.bweakfast.foodora.*
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by Rushil on 8/21/2017.
 */

class LoginFragment : Fragment(), ErrorDisplay {
    private lateinit var inputValidators: Map<TextInputLayout, List<Validator>>

    val login: PublishSubject<Pair<String, String>> = PublishSubject.create()
    val loadRegisterPage: PublishSubject<Irrelevant> = PublishSubject.create()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputValidators = mapOf(
            emailInputLayout to listOf(Validator.empty()),
            passwordInputLayout to listOf(Validator.empty(), Validator.passwordValid())
        )

        passwordInputLayout.editText?.setOnEditorActionListener { _, id, _ ->
            if (id == R.integer.action_login_id || id == EditorInfo.IME_ACTION_UNSPECIFIED) {
                attemptLogin()
                return@setOnEditorActionListener true
            } else {
                false
            }
        }
        loginButton.setOnClickListener { attemptLogin() }
        registerButton.setOnClickListener { loadRegisterPage.onNext(Irrelevant.INSTANCE) }
        inputValidators.forEach { (inputLayout, validators) ->
            validators.forEach {
                inputLayout.addValidation(it.validate, it.errorMessage)
            }
        }
    }

    override fun showError(error: String?) {
        if (error == "Email is Null") {
            emailInputLayout.error = getString(R.string.error_field_required)
            emailInputLayout.requestFocus()
        } else if (error == "Password is Null") {
            passwordInputLayout.error = getString(R.string.error_field_required)
            passwordInputLayout.requestFocus()
        }
    }

    private fun attemptLogin() {
        val focusView = validate()

        if (focusView != null) {
            focusView.requestFocus()
        } else {
            val email = emailInputLayout.editText?.text.toString()
            val password = passwordInputLayout.editText?.text.toString()
            login.onNext(email to password)
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
        fun newInstance(): LoginFragment = LoginFragment()
    }
}