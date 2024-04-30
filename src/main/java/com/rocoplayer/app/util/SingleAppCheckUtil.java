package com.rocoplayer.app.util;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 单个实例程序检测
 * @author ZJ
 *
 */
public class SingleAppCheckUtil {

	/**
	 * 检测是否有其他实例在运行
	 */
	@SuppressWarnings("resource")
	public static void check() {
		try {
			File file = new File(System.getProperty("java.io.tmpdir") + "Javafx-APP.lock");
			if(!file.exists()) {
				file.createNewFile();
			}

			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			FileLock lock = channel.tryLock();
			if(lock == null) {
//				System.out.println("程序已运行，退出");
				System.exit(0);
			}
//			System.out.println("文件锁上了");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		check();
		
		try {
			Thread.sleep(1000 * 60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
