package com.example.missile

import org.junit.jupiter.api.Assertions

class SpyMissile:Missile {
    var isLaunchCalled = false
    var isDisableCalled = false
    override fun launch() {
        isLaunchCalled = true
    }
    override fun disable() {
        isDisableCalled = true
    }
}

class MockMissile:Missile {
    var isLaunchCalled = false
    var isDisableCalled = false
    override fun launch() {
        isLaunchCalled = true
    }
    override fun disable() {
        isDisableCalled = true
    }
    fun checkDisableCalledAndLaunchNotCalled(){
        Assertions.assertEquals(isDisableCalled, true)
        Assertions.assertEquals(isLaunchCalled, false)
    }
}