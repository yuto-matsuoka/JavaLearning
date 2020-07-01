package co.jp.beforward.ojt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class OjtTimeKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(OjtTimeKeeperApplication.class, args);
	}

}
