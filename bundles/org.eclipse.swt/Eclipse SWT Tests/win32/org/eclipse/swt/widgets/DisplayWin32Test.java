package org.eclipse.swt.widgets;

import static org.junit.jupiter.api.Assertions.*;

import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.win32.*;
import org.junit.jupiter.api.*;

public class DisplayWin32Test {

	private boolean initialMonitorSpecificScaling;

	@BeforeAll
	public static void assumeIsFittingPlatform() {
		PlatformSpecificExecution.assumeIsFittingPlatform();
	}

	@BeforeEach
	public void storeState() {
		initialMonitorSpecificScaling = DPIUtil.isMonitorSpecificScalingActive();
	}

	@AfterEach
	public void restoreState() {
		DPIUtil.setMonitorSpecificScaling(initialMonitorSpecificScaling);
	}

	@Test
	public void monitorSpecificScaling_activate() {
		DPIUtil.setMonitorSpecificScaling(true);
		Display display = new Display();
		try {
			assertTrue(display.isRescalingAtRuntime());
			assertEquals(OS.DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE_V2, OS.GetThreadDpiAwarenessContext());
		} finally {
			display.dispose();
		}
	}

	@Test
	public void monitorSpecificScaling_deactivate() {
		DPIUtil.setMonitorSpecificScaling(false);
		Display display = new Display();
		try {
			assertFalse(display.isRescalingAtRuntime());
		} finally {
			display.dispose();
		}
	}

	@Test
	@SuppressWarnings("removal")
	public void setRescaleAtRuntime_activate() {
		Display display = new Display();
		try {
			display.setRescalingAtRuntime(true);
			assertTrue(display.isRescalingAtRuntime());
			assertEquals(OS.DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE_V2, OS.GetThreadDpiAwarenessContext());
		} finally {
			display.dispose();
		}
	}

	@Test
	@SuppressWarnings("removal")
	public void setRescaleAtRuntime_deactivate() {
		Display display = new Display();
		try {
			display.setRescalingAtRuntime(false);
			assertFalse(display.isRescalingAtRuntime());
			assertEquals(OS.DPI_AWARENESS_CONTEXT_SYSTEM_AWARE, OS.GetThreadDpiAwarenessContext());
		} finally {
			display.dispose();
		}
	}

	@Test
	@SuppressWarnings("removal")
	public void setRescaleAtRuntime_toggling() {
		Display display = new Display();
		try {
			display.setRescalingAtRuntime(false);
			assertFalse(display.isRescalingAtRuntime());
			assertEquals(OS.DPI_AWARENESS_CONTEXT_SYSTEM_AWARE, OS.GetThreadDpiAwarenessContext());
			display.setRescalingAtRuntime(true);
			assertTrue(display.isRescalingAtRuntime());
			assertEquals(OS.DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE_V2, OS.GetThreadDpiAwarenessContext());
			display.setRescalingAtRuntime(false);
			assertFalse(display.isRescalingAtRuntime());
			assertEquals(OS.DPI_AWARENESS_CONTEXT_SYSTEM_AWARE, OS.GetThreadDpiAwarenessContext());
		} finally {
			display.dispose();
		}
	}

}
