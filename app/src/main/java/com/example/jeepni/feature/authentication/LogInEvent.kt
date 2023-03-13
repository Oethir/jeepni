package com.example.jeepni.feature.authentication

sealed class LogInEvent {
    data class OnPhoneNumberChange(val phoneNumber : String) : LogInEvent()
    data class OnPasswordChange (val password : String) : LogInEvent()
    object OnLogInClicked : LogInEvent()
    object OnForgotPasswordClicked : LogInEvent()
    data class OnValidPasswordChange(val isValid : Boolean): LogInEvent()
    data class OnValidPhoneNumberChange(val isValid : Boolean): LogInEvent()
    object OnSignUpClicked : LogInEvent()
    object OnBackPressed : LogInEvent()

}