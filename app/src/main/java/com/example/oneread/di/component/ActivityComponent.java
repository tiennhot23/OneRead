package com.example.oneread.di.component;

import com.example.oneread.di.anotation.ActivityScope;
import com.example.oneread.di.module.ActivityModule;
import com.example.oneread.ui.login.LoginActivity;
import com.example.oneread.ui.login.fragment.signin.SignInFragment;
import com.example.oneread.ui.login.fragment.signup.SignUpFragment;
import com.example.oneread.ui.main.MainActivity;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(SignInFragment signInFragment);

    void inject(SignUpFragment signUpFragment);

}
