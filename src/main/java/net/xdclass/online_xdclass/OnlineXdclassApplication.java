package net.xdclass.online_xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("net.xdclass.online_xdclass.mapper")
@EnableTransactionManagement
@CrossOrigin
public class OnlineXdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdclassApplication.class, args);
	}



	/**
	 *  开启跨域
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//设置允许跨域的路径
				registry.addMapping("/**")
						//设置允许跨域请求的域名
						.allowedOrigins("*")
						//这里：是否允许证书 不再默认开启
						.allowCredentials(true)
						//设置允许的方法
						.allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
						.exposedHeaders("token")
						//跨域允许时间
						.maxAge(3600);

			}
		};
	}



}
