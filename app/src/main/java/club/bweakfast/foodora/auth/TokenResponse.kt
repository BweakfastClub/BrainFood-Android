package club.bweakfast.foodora.auth

class TokenResponse(private val token: String) {
    operator fun component1() = token
}