package com.bollywood;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		Film f1 = (Film)ctx.getBean("film1");
		List<String> actors = f1.getActors();
		List<Song> songs = f1.getSongs();
		Map<String, String> details = f1.getDetails();
		System.out.println(actors);
		System.out.println(songs);
		System.out.println(details);
	}

}
