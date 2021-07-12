package me.screw.javawebprogramming;

import me.screw.javawebprogramming.calculator.StringCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaWebProgrammingApplication {

	public static void main(String[] args) {
		StringCalculator stringCalculator = new StringCalculator();
		System.out.println(stringCalculator.add("1,2,3,4,5"));
//		SpringApplication.run(JavaWebProgrammingApplication.class, args);
	}

}
