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
		assertEquals(missile.isLaunchCalled,true)
	}

	@Test
	fun isExpiredがtrueならisSignの値に関わらずlaunchを呼ばずdisableを呼ぶ(){
		val launcher = MissileLauncher()
		val missile1 = MockMissile()
		val missile2 = MockMissile()
		val launchCode1 = StubLaunchCodeIsExpiredTrueAndIsSignedTrue()
		val launchCode2 = StubLaunchCodeIsExpiredTrueAndIsSignedFalse()
		launcher.launchMissile(missile1,launchCode1)
		missile1.checkDisableCalledAndLaunchNotCalled()

		launcher.launchMissile(missile2,launchCode2)
		missile2.checkDisableCalledAndLaunchNotCalled()
	}

	@Test
	fun isSignedがfalseならdisableを呼んでlaunchを呼ばない(){
		val launcher = MissileLauncher()
		val missile1 = MockMissile()
		val missile2 = MockMissile()
		val launchCode1 = StubLaunchCodeIsExpiredFalseAndIsSignedFalse()
		val launchCode2 = StubLaunchCodeIsExpiredTrueAndIsSignedFalse()
		launcher.launchMissile(missile1,launchCode1)
		missile1.checkDisableCalledAndLaunchNotCalled()

		launcher.launchMissile(missile2,launchCode2)
		missile2.checkDisableCalledAndLaunchNotCalled()


	}
}
