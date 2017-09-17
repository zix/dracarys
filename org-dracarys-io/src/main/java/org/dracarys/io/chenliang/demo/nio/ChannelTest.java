package org.dracarys.io.chenliang.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

	public static void main(String[] args) throws IOException {
	    RandomAccessFile aFile = new RandomAccessFile("src/main/java/org/dracarys/io/chenliang/demo/nio/nio-data.txt", "rw");
	    FileChannel inChannel = aFile.getChannel();

	    ByteBuffer buf = ByteBuffer.allocate(48);

	    int bytesRead = inChannel.read(buf);
	    while (bytesRead != -1) {

	      System.out.println("Read " + bytesRead);
	      buf.flip();

	      while(buf.hasRemaining()){
	          System.out.print((char) buf.get());
	      }

	      buf.clear();
	      bytesRead = inChannel.read(buf);
	    }
	    aFile.close();
	}

}
