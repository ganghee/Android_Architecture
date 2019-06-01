package com.mobitant.android_architecture.Presenter

import com.mobitant.android_architecture.Model.User
import com.mobitant.android_architecture.View.MyLoginView

class LoginPresenter (internal var myLoginView: MyLoginView): MyLoginPresenter{
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val isLoginCode = user.isDataValid()
        if (isLoginCode==0)
            myLoginView.onLoginError("Email must not be null")
        else if(isLoginCode==1)
            myLoginView.onLoginError("Wrong email address")
        else if(isLoginCode==2)
            myLoginView.onLoginError("Password must be greater than 6")
        else
            myLoginView.onLoginSuccess("Login success")
    }
}
