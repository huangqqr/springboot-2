package com.hb.springboot;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootHelloApplication.class)
public class JasyptApplicationTests {

    @Autowired
    private StringEncryptor stringEncryptor;

	@Test
	public void contextLoads() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //加密方法
        System.out.println(stringEncryptor.encrypt("root"));
        System.out.println(stringEncryptor.encrypt("123456"));
        //解密方法

        System.out.println(stringEncryptor.decrypt("uaNBj4ZmzCD83uedRYUXqQ=="));
        //System.out.println(stringEncryptor.decrypt("oKBQENfbbQiMyPvECAgPGA=="));
	}

}