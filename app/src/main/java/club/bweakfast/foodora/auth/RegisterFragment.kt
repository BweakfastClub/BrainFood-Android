package club.bweakfast.foodora.auth

import android.os.Bundle
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
import android.widget.TextView
import club.bweakfast.foodora.ErrorDisplay
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.Irrelevant
import club.bweakfast.foodora.R
import club.bweakfast.foodora.Validator
import club.bweakfast.foodora.addValidation
import club.bweakfast.foodora.setup.SetupViewModel
import club.bweakfast.foodora.util.listenForChanges
import club.bweakfast.foodora.util.logError
import club.bweakfast.foodora.validate
import com.crashlytics.android.Crashlytics
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_register.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Rushil on 8/21/2017.
 */
class RegisterFragment : Fragment(), ErrorDisplay {
    private lateinit var inputValidators: Map<EditText, List<Validator>>

    val loadLoginPage = PublishSubject.create<Irrelevant>()
    val register = PublishSubject.create<Triple<String, String, String>>()

    @Inject
    lateinit var setupViewModel: SetupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
    }

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
            name to listOf(Validator.empty()),
            email to listOf(
                Validator.empty(),
                Validator.emailValid()
            ),
            password to listOf(
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

        val loginText = loginButton.text
        val colorSpan = SpannableString(loginText)
        colorSpan.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.colorAccent)),
            loginText.indexOf("Login!"),
            loginText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        loginButton.text = colorSpan

        name.listenForChanges()
            .subscribeOn(Schedulers.trampoline())
            .debounce(250, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ setupViewModel.name = it }, {
                logError(it)
                Crashlytics.logException(it)
            })
    }

    override fun showError(error: String?) {
        if (error == "Password is Null") {
            passwordInputLayout?.error = getString(R.string.error_field_required)
            passwordInputLayout?.requestFocus()
        }
    }

    private fun attemptRegister() {
        val focusView = validate()

        if (focusView != null) {
            focusView.requestFocus()
        } else {
            val name = nameInputLayout.editText?.text.toString()
            val email = emailInputLayout.editText?.text.toString()
            val password = passwordInputLayout.editText?.text.toString()
            register.onNext(Triple(name, email, password))
        }
    }

    private fun validate(): EditText? {
        var focusView: EditText? = null
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