package com.rocoplayer.app.server;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * 序列号工具
 * 
 * 经测试，正常socket传输都是小数据量，使用jdk自带的要比Protostuff速度快，
 * 如果数据量很大，比如传输文件之类，那Protostuff优势体现了，所以基本上传输一些几M的没必要Protostuff
 * 
 * @author ZJ
 *
 */
public class SerializationUtil {

    
    
    /**
     * 对象转数组
     * @param obj
     * @return
     * @throws IOException
     */
    public byte[] toByteArray (Object obj) throws IOException {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            oos.flush();
            return  bos.toByteArray();
        }
    }

    /**
     * 数组转对象
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object toObject (byte[] bytes) throws IOException, ClassNotFoundException {
        try (
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis)) {
            return ois.readObject();
        }
    }
}