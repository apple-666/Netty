package com.apple.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Double_apple
 * @Date 2022/2/12 12:47
 * @Version 1.0
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String s = "apple come on ";

        //创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\apple\\a大四\\newapple.txt");

        //创建对应的channel（所以channel和输出流stream绑定了)
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);//1024 byte字节 =  1kb = 0.001 mb

        // 字符放入buffer
        byteBuffer.put(s.getBytes());

        byteBuffer.flip();
        // position 原来等于总字节数
        // 调整limit = position；然后position设为0
        // 这样就可以从buffer开头，对该buffer进行遍历（读取）了。

        // 将buffer写入channel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();

    }
}
