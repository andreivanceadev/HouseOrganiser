package com.andreivanceadev.houseorganiser.viewmodel

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class MainActivityViewModel : ContainerHost<MainActivityState, Nothing>, ViewModel() {

    override val container: Container<MainActivityState, Nothing> = container(
        MainActivityState("")
    )
}

data class MainActivityState(
    val title: String
)