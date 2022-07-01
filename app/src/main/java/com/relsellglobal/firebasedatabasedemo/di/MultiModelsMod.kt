package com.relsellglobal.firebasedatabasedemo.di

import android.content.Context
import com.relsellglobal.firebasedatabasedemo.MyApplication
import com.relsellglobal.interfacesgateway.network.IGApiService
import com.relsellglobal.modelslib.CityContent
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MultiModelsMod {

    @Provides
    fun providesCityContent() : CityContent {
        return CityContent()
    }

    @Provides
    fun providesCityContentDetailNetwork() : CityContentDetailNetwork {
        return CityContentDetailNetwork()
    }

    @Provides
    fun providesCityContentNetwork() : CityContentNetwork {
        return CityContentNetwork()
    }

    @Provides
    @Singleton
    fun providesApplicationContext() : Context {
        return MyApplication.getMyApplicationObj()
    }

}