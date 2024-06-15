package org.example.configserver;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

@Configuration
public class JasyptConfig {

    final static String KEY = "testkey";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(KEY);
        config.setPoolSize("1");
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void main(String[] args){

        String plainText = "main";  // 암호화할 문자

        // 설정
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(KEY);
        config.setPoolSize("1");
        encryptor.setConfig(config);

        // 테스트
        String encryptText = encryptor.encrypt(plainText);
        System.out.println(encryptText);
        System.out.println(encryptor.decrypt(encryptText));

    }
}
