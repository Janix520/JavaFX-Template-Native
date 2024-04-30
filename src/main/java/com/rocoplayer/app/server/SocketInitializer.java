package com.rocoplayer.app.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Socket 初始化器，每一个Channel进来都会调用这里的 InitChannel 方法
 **/
public class SocketInitializer extends ChannelInitializer<SocketChannel> {

//	private String delimiter = "\r\n";

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		ChannelPipeline pipeline = socketChannel.pipeline();
		// 添加对byte数组的编解码，netty提供了很多编解码器，你们可以根据需要选择
//		pipeline.addLast(new DelimiterBasedFrameDecoder(1024 * 8, Unpooled.wrappedBuffer(delimiter.getBytes(Charset.forName("utf-8")))));
//		pipeline.addLast(new ProtostuffDecoder());
//		pipeline.addLast(new ProtostuffEncoder());
		pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(1048576, 0, 4, 0, 4));
//		pipeline.addLast("bytesDecoder", new ByteArrayDecoder());
		pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
//		pipeline.addLast("bytesEncoder", new ByteArrayEncoder());
		// 添加上自己的处理器
		pipeline.addLast(new SocketHandler());
	}
}