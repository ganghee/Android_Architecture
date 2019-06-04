package com.mobitant.my_mvvm_login_module_java;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.mobitant.my_mvvm_login_module_java.Interface.LoginResultCallbacks;
import com.mobitant.my_mvvm_login_module_java.databinding.ActivityMainBinding;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(
                this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class
        ));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this,"Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this,"Login error",Toast.LENGTH_SHORT).show();
    }
}
