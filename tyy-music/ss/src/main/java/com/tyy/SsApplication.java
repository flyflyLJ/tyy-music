package com.tyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李咸德、蔡飞飞
 *
 */
@SpringBootApplication
@MapperScan("com.tyy.*.mapper")
public class SsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsApplication.class, args);
	}
}
