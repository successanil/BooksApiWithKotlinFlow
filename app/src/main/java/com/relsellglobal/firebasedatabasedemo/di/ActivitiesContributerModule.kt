package com.relsellglobal.firebasedatabasedemo.di

import com.relsellglobal.firebasedatabasedemo.MainActivityWithNavBar
import com.relsellglobal.firebasedatabasedemo.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesContributerModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity() : HomeActivity


    @ContributesAndroidInjector
    abstract fun contributeWeatherDataWithNavbar() : MainActivityWithNavBar
}