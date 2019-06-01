package com.mobitant.android_architecture.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mobitant.android_architecture.Presenter.LoginPresenter
import com.mobitant.android_architecture.Presenter.MyLoginPresenter
import com.mobitant.android_architecture.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MyLoginView {
    override fun onLoginSuccess(message: String) {
        Toasty.success(this,message,Toast.LENGTH_SHORT).show()
    }
    override fun onLoginError(message: String) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show()
         }

    internal lateinit var loginPresenter: MyLoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginPresenter = LoginPresenter(this)

        btn_login.setOnClickListener {
            loginPresenter.onLogin(edt_email.text.toString(),edt_password.text.toString())
        }
    }
}
