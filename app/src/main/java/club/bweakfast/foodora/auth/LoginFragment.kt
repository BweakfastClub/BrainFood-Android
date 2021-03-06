package club.bweakfast.foodora.auth

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import club.bweakfast.foodora.ErrorDisplay
import club.bweakfast.foodora.Irrelevant
import club.bweakfast.foodora.R
import club.bweakfast.foodora.Validator
import club.bweakfast.foodora.addValidation
import club.bweakfast.foodora.validate
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by Rushil on 8/21/2017.
 */

class LoginFragment : Fragment(), ErrorDisplay {
    private lateinit var inputValidators: Map<EditText, List<Validator>>

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
            email to listOf(Validator.empty(), Validator.emailValid()),
            password to listOf(Validator.empty(), Validator.passwordValid())
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

        val registerText = registerButton.text
        val colorSpan = SpannableString(registerText)
        colorSpan.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.colorAccent)),
            registerText.indexOf("Sign up!"),
            registerText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        registerButton.text = colorSpan
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

    private fun validate(): EditText? {
        var focusView: EditText? = null
        inputValidators.keys.forEach { input ->
            focusView = if (!input.validate()) {
                focusView ?: input
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