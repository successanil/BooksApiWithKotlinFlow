package com.relsellglobal.firebasedatabasedemo.di

import com.relsellglobal.firebasedatabasedemo.DetailFragment
import com.relsellglobal.firebasedatabasedemo.FrontListFragment
import com.relsellglobal.firebasedatabasedemo.ui.addcity.AddCityFragment
import com.relsellglobal.firebasedatabasedemo.ui.home.HomeFragment
import com.relsellglobal.progressbarlib.ChildFragment
import com.relsellglobal.progressbarlib.ProgressBarFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentContributerModule {
    @ContributesAndroidInjector
    abstract fun contributesHomeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesFrontListFragment() : FrontListFragment

    @ContributesAndroidInjector
    abstract fun contributesAddcityFragment() : AddCityFragment


    @ContributesAndroidInjector
    abstract fun contributesDetailFragment() : DetailFragment

    @ContributesAndroidInjector
    abstract fun contributesProgressBarFragment() : ProgressBarFragment
}