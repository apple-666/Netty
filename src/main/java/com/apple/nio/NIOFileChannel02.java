package com.apple.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Double_apple
 * @Date 2022/2/12 14:23
 * @Version 1.0
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\apple\\a大四\\newapple.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 将channel中的数据读入到buffer中
        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
