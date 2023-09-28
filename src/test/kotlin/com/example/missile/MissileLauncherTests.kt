package com.example.missile

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



class MissileLauncherTests {

	@Test
	fun isSignedがfalseならlaunchを呼ばない() {
		val launcher = MissileLauncher()
		val missile = DummyMissile()
		val launchCode = StubLaunchCode()
		launcher.launchMissile(missile, launchCode)
//		assertEquals(1, 2)
//		assertTrue(false)
//		assertFalse(true)
	}

	@Test
	fun isSignedがtrueならlaunchを呼ぶ(){
		val launcher = MissileLauncher()
		val missile = SpyMissile()
		val launchCode = StubLaunchCodeIsTrue()
		launcher.launchMissile(missile,launchCode)
		assertEquals(missile.isCalled,true)
	}

	@Test
	fun isExpiredがtrueならisSignの値に関わらずlaunchを呼ばない(){
		val launcher = MissileLauncher()
		val missile = SpyMissile()
		val launchCode1 = StubLaunchCodeIsExpiredTrueAndIsSignedTrue()
		val launchCode2 = StubLaunchCodeIsExpiredTrueAndIsSignedFalse()
		launcher.launchMissile(missile,launchCode1)
		assertEquals(missile.isCalled,false)
		launcher.launchMissile(missile,launchCode2)
		assertEquals(missile.isCalled,false)
	}


}
