package com.example.missile

class StubLaunchCode : LaunchCode{
    override fun isSigned(): Boolean {
        return false
    }
    override fun isExpired(): Boolean {
        return false
    }
}

class StubLaunchCodeIsTrue:LaunchCode{
    override fun isSigned(): Boolean {
        return true
    }
    override fun isExpired(): Boolean {
        return false
    }
}

class StubLaunchCodeIsExpiredTrueAndIsSignedTrue:LaunchCode{
    override fun isSigned(): Boolean {
        return true
    }
    override fun isExpired(): Boolean {
        return true
    }
}

class StubLaunchCodeIsExpiredTrueAndIsSignedFalse:LaunchCode{
    override fun isSigned(): Boolean {
        return false
    }
    override fun isExpired(): Boolean {
        return true
    }
}

class StubLaunchCodeIsExpiredFalseAndIsSignedFalse:LaunchCode{
    override fun isSigned(): Boolean {
        return false
    }
    override fun isExpired(): Boolean {
        return false
    }
}