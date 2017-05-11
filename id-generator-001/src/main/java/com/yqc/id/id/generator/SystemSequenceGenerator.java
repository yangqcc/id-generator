package com.yqc.id.id.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangqc on 2017/5/11.
 */
@Component
@Slf4j
public class SystemSequenceGenerator implements CommandLineRunner, DisposableBean {

    public static final String FILE_NAME = "SystemSequenceMapping.properties";
    private static final Map<String, Integer> map;

    static {
        map = new HashMap<>();
        try {
            Properties pro = getProperties();
            Enumeration en = getProperties().propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                int property = Integer.parseInt(pro.get(key).toString());
                map.put(key, property);
                System.out.println(key + "." + property);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties getProperties() throws IOException {
        Properties pro = new Properties();
        InputStream in = new ClassPathResource(FILE_NAME).getInputStream();
        pro.load(in);
        return pro;
    }

    public synchronized static int getSequence(String key) {
        Integer result;
        if ((result = map.get(key)) == null) {
            Integer[] keys = map.values().toArray(new Integer[0]);
            Arrays.sort(keys, (x, y) -> y - x);
            result = keys[0];
            map.put(key, ++result);
        }
        return result;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void destroy() throws Exception {
        try {
            Properties pro = getProperties();
            OutputStream fos = new FileOutputStream(new ClassPathResource(FILE_NAME).getFile());
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pro.setProperty(entry.getKey(), String.valueOf(entry.getValue()));
            }
            pro.store(fos, "Update '" + "SystemSequenceMapping" + "' value");
        } catch (IOException e) {
            log.error("销毁失败!");
        }
    }
}
