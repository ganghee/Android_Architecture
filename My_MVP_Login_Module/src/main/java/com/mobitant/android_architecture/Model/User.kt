package com.mobitant.android_architecture.Model

import android.text.TextUtils
import android.util.Patterns

class User (override val email:String, override val password:String):MyUser{
    override fun isDataValid(): Int {
        if (TextUtils.isEmpty(email)) return 0
        else return if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            1
        else if(password.length <= 6)
            2
        else
            -1
    }
}
