package com.demon.netty.chapter3;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 用于对网络事件进行读写操作
 * @author xuliang
 * @since 2017年2月6日 下午3:47:24
 *
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()]; // readableBytes() 获取缓冲区可读的字节数
		buf.readBytes(req);   // readBytes 将缓冲区的字节数组复制到新建的数组中
		String body = new String(req, "UTF-8");
		System.out.println("The time server receive order : "+body);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date().toString() : "BAD ORDER";
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.write(resp); // 只写入缓存，不写入SocketChannel
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush(); // 将消息发送队列中的消息写入到SocketChannel中发送给对方
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}
