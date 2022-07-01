package com.relsellglobal.uiphonemod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.relsellglobal.progressbarlib.ChildDepedency
import javax.inject.Inject
import android.util.Log
import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.localdblib.entities.CityContentDB
import com.relsellglobal.progressbarlib.ChildFragment
import com.relsellglobal.progressbarlib.MainActivityForProgressBar
import com.relsellglobal.progressbarlib.ProgressBarFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UiPhoneActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var childFragment: ChildFragment

    @Inject
    lateinit var database : CityDatabase

    @Inject
    lateinit var childDepedency : ChildDepedency
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ui_phone)



        supportFragmentManager
            .beginTransaction().replace(R.id.rtlLayout,ProgressBarFragment()).commit()


//        setContentView(R.layout.activity_ui_phone)
//        childDepedency.printMe()
//
//        triggerDBDemoCall()




//        startActivity(Intent(this@UiPhoneActivity,com.relsellglobal.progressbarlib.MainActivity::class.java))
//        supportFragmentManager.beginTransaction().replace(R.id.rtlLayout,ChildFragment()).commit()


       // startActivity(Intent(this@UiPhoneActivity, MainActivityForProgressBar::class.java))

    }

    fun triggerDBDemoCall () {
        CoroutineScope(Dispatchers.IO).launch {
            database.cityContentDao().insertCityContent(CityContentDB(0,"dehradun","{}"))
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}