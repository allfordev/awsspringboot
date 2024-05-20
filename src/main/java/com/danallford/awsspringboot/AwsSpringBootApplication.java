package com.danallford.awsspringboot;

//import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.Bucket;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AwsSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSpringBootApplication.class, args);

//		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
//
//		List<Bucket> buckets = s3.listBuckets();
//
//		buckets.stream().forEach(bucket -> {
//			System.out.println(
//					"Bucket Name : " + bucket.getName()
//							+ ", Bucket Owner : " + bucket.getOwner()
//							+ ", Bucket Creation Date : " + bucket.getCreationDate());
//
//		});
	}

}
