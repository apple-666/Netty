package com.apple.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * niofile channel03
 *  通过buffer+channel 实现拷贝文件
 * @Author Double_apple
 * @Date 2022/2/12 14:35
 * @Version 1.0
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception{
        //input 表示读取
        FileInputStream fileInputStream = new FileInputStream("D:\\apple\\a大四\\newapple.txt");
        FileChannel channel1 = fileInputStream.getChannel();

        //output 表示写入
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\apple\\a大四\\newapple2.txt");
        FileChannel channel2 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while(true){
            byteBuffer.clear();
            // 调整position和limit

            //input 读取数据
            int read = channel1.read(byteBuffer);
            System.out.println(read);
            if(read == -1) {
                break;
            }

            //output 写入数据
            byteBuffer.flip();
            channel2.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
