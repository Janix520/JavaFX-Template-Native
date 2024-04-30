package com.rocoplayer.app.util;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

/**
 * 
 * @author ZJ
 *
 */
public class AppUtil {

	
	/**
	 * 
	 */
	public static void exitApp() {
		Platform.exit(); // 优雅关闭应用程序
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		}, 500);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static File getWorkHome() {
		String property = System.getProperty("user.home");
		File file = new File(property, ".javafx-app");
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
}
