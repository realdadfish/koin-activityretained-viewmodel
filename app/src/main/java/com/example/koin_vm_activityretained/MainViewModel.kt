package com.example.koin_vm_activityretained

import androidx.lifecycle.ViewModel

class MainViewModel(
    private val regularThing: RegularThing,
    private val retainedThing: RetainedThing
) : ViewModel() {
    fun hello(): String =
        regularThing.hello() + " " +
                retainedThing.hello()
}