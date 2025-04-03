package com.example.koin_vm_activityretained

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.scopedOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    scope<MainActivity> {
                        scopedOf(::RetainedThing)
                    }
                    singleOf(::RegularThing)
                    viewModelOf(::MainViewModel)
                }
            )
        }
    }
}