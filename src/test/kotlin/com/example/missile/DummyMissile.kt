package com.example.missile

import java.lang.Exception

class DummyMissile:Missile {
    override fun launch() {
        throw Exception()
    }

    override fun disable()
    {
    }
}