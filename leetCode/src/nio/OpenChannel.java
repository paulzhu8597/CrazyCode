package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class OpenChannel {
	public static void main(String[] args) throws IOException {
		String ip = "127.0.0.1";
		int port = 8080;
		SocketChannel sc = SocketChannel.open(); 
		sc.connect(new InetSocketAddress(ip, port)); 
		ServerSocketChannel ssc = ServerSocketChannel.open(); 
		ssc.socket().bind (new InetSocketAddress(port));
		DatagramChannel dc = DatagramChannel.open();
		RandomAccessFile raf = new RandomAccessFile ("somefile", "r");
		FileChannel fc = raf.getChannel();
	}
	
	/**
	 * FileChannel类和三个socket通道类：SocketChannel、ServerSocketChannel和DatagramChannel。
	 */
}
