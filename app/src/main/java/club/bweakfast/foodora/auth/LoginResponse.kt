package club.bweakfast.foodora.auth

class LoginResponse(private val token: String) {
    operator fun component1() = token
}