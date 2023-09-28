package com.example.missile

class SpyMissile:Missile {
    var isCalled = false
    override fun launch() {
        isCalled = true
    }
}