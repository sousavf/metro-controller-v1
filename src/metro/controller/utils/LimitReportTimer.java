package metro.controller.utils;

import java.util.Timer;
import java.util.TimerTask;

import metro.controller.EntranceActivity;
import android.util.Log;

public class LimitReportTimer {
	Timer timer;

	public LimitReportTimer(int seconds) {
		Log.i(this.getClass().toString(),
				"public LimitReportTimer(int seconds)");
		timer = new Timer();
		timer.schedule(new SetBlockingFalse(), seconds * 1000);
	}

	class SetBlockingFalse extends TimerTask {
		public void run() {
			Log.i(this.getClass().toString(),
					"public void run()");
			EntranceActivity.setBlocking(false);
			timer.cancel(); // Terminate the thread
		}
	}
}
