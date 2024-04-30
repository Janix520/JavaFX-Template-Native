package com.rocoplayer.app.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author ZJ
 *
 */
public class NetWorkUtil {

	/**
	 * 获取当前活动的ip
	 * 
	 * @return
	 */
	public static String getCurrentIP() {

		String ip = "";

		try {
			// 获取所有网络接口
			List<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

			for (NetworkInterface networkInterface : networkInterfaces) {
				if (!networkInterface.isUp()) {
					continue;
				}

//				System.out.println("Interface Name: " + networkInterface.getName());

				// 获取网络接口的所有IP地址
				Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
				while (inetAddresses.hasMoreElements()) {
					InetAddress inetAddress = inetAddresses.nextElement();

					if (inetAddress.isLoopbackAddress()) {// 回路地址，如127.0.0.1
//	                    System.out.println("loop addr:" + inetAddress);
					} else if (inetAddress.isLinkLocalAddress()) {// 169.254.x.x
//	                    System.out.println("link addr:" + inetAddress);
					} else if (inetAddress.isSiteLocalAddress()) {
						// 如果是内网IP（site-local address），则打印
//						System.out.println("IP Address: " + inetAddress.getHostAddress());
						ip = inetAddress.getHostAddress();
						break;
					}

//					if (inetAddress.isLoopbackAddress()) {// 回路地址，如127.0.0.1
////                      System.out.println("loop addr:" + inetAddress);
//					} else if (inetAddress.isLinkLocalAddress()) {// 169.254.x.x
////                      System.out.println("link addr:" + inetAddress);
//					} else {
//						// 非链接和回路真实ip
//						String localname = inetAddress.getHostName();
//						String localip = inetAddress.getHostAddress();
//						ipList.add(localip);
//						System.err.println("localname:" + localname);
//						System.err.println("localip:" + localip);
//					}
				}

			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		if (StringUtils.isBlank(ip)) {
			ip = getLoclIp();
		}

		return ip;
	}

	/**
	 * 
	 * @return
	 */
	private static String getLoclIp() {
		String hostAddress = "Your local LAN IP address";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return hostAddress;
	}
}
