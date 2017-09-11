/*
 * Copyright (C), 2013-2017, 上海赛可电子商务有限公司
 * FileName: Client.java
 * Author:   chenliang
 * Date:     2017年9月11日 上午10:34:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dracarys.io.chenliang.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author chenliang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Client {
    public static void main(String[] args) {
        Client c = new Client();

        // 种20个线程发起Socket客户端连接请求
//        for (int i = 0; i < 5; i++) {
            new Thread(c.new Worker()).start();
//        }
    }

    private class Worker implements Runnable {

        @Override
        public void run() {
            Socket socket = null;
            BufferedReader reader = null;
            PrintWriter writer = null;

            try {
                // 创建一个Socket并连接到指定的目标服务器
                socket = new Socket("localhost", 8383);

                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());

                writer.println("who");
                writer.println("what");
                writer.println("where");
                writer.println("OVER");// OVER作为操作完成暗号
                writer.flush();

                String answer = reader.readLine(); // 没有内容会阻塞
                while (!answer.equals("OVER")) {
                    System.out.println(Thread.currentThread().getId() + "---Message from server:" + answer);
                    answer = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }

                    if (reader != null) {
                        reader.close();
                    }

                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
