package com.danallford.pigeons.app;

//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.S3ClientOptions;
//import com.amazonaws.services.s3.model.Bucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

@EntityScan("com.danallford.pigeons.app.login")
@EnableJpaRepositories(basePackages = "com.danallford.pigeons.app.login") //, entityManagerFactoryRef = "sessionFactory")
@SpringBootApplication() //exclude = { DataSourceAutoConfiguration.class })
public class PigeonsApplication {

	public static void main(String[] args) throws Exception {

		Class.forName("org.postgresql.Driver");

		String defaultUrl = "jdbc:postgresql://localhost/test";
		Properties props = new Properties();
		props.setProperty("user", "danallford");
		props.setProperty("password", "password");
		props.setProperty("ssl", "false");
		//Connection conn = DriverManager.getConnection(defaultUrl, props);

		String url = "jdbc:postgresql://localhost:5432/danallford?user=danallford&password=password&ssl=false";
		Connection conn = DriverManager.getConnection(url);

		SpringApplication.run(PigeonsApplication.class, args);

		/*final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

		//S3ClientOptions options = S3ClientOptions.builder().build();
		List<Bucket> buckets = s3.listBuckets();

		buckets.stream().forEach(bucket -> {
			System.out.println(
					"Bucket Name : " + bucket.getName()
							+ ", Bucket Owner : " + bucket.getOwner()
							+ ", Bucket Creation Date : " + bucket.getCreationDate());

		});*/
	}

	@Bean
	public AuthenticationEventPublisher authenticationEventPublisher
			(ApplicationEventPublisher applicationEventPublisher) {
		return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
	}
}
