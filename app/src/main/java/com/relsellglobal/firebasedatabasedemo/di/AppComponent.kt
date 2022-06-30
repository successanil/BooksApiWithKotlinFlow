package com.relsellglobal.firebasedatabasedemo.di


import com.relsellglobal.firebasedatabasedemo.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=[
    AndroidInjectionModule::class,
    ActivitiesContributerModule::class,
    NetworkModule::class,
    FragmentContributerModule::class])
interface AppComponent {
    fun inject(app: MyApplication)
}