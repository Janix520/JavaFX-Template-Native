package com.rocoplayer.app.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;

/**
 * 
 * @author ZJ
 *
 */
public class NettyServer {

	private SocketInitializer socketInitializer;
	private ChannelFuture bind;

	/**
	 * 初始化netty配置
	 */
	public void init() {

		socketInitializer = new SocketInitializer();

		// 创建两个线程组，bossGroup为接收请求的线程组，一般1-2个就行
		NioEventLoopGroup bossGroup = new NioEventLoopGroup(2);
		// 实际工作的线程组
		NioEventLoopGroup workerGroup = new NioEventLoopGroup(2);
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(bossGroup, workerGroup) // 两个线程组加入进来
				// 该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
//				.option(ChannelOption.TCP_NODELAY, true)
				.childOption(ChannelOption.TCP_NODELAY, true)
				// 设置队列大小
                //				.option(ChannelOption.SO_BACKLOG, 1024)
                // 首选直接内存
                .childOption(ChannelOption.ALLOCATOR, PreferredDirectByteBufAllocator.DEFAULT)
				.channel(NioServerSocketChannel.class) // 配置为nio类型
				 // 两小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true)
				.childHandler(socketInitializer); // 加入自己的初始化器

		try {
			bind = serverBootstrap.bind(18090).sync();
			System.out.println("Port on: 18090");
		} catch (Exception e) {
			e.printStackTrace();
			
//			System.exit(0);
		}

	}

	public void close() {
		if (null != bind) {
			try {
				bind.channel().closeFuture().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
