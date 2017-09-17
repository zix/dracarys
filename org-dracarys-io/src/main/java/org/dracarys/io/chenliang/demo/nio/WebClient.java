package org.dracarys.io.chenliang.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WebClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("hello world".getBytes());
            
            System.out.println("isBlock: "+socketChannel.isBlocking());
            
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            socketChannel.close();
        } catch (IOException e) {
        }
    }
}
