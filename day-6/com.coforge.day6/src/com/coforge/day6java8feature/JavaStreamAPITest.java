package com.coforge.day6java8feature;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamAPITest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11,12,13,14,15);
		
		List<Integer> even = list.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println("Even :"+even);
		
		long cnt = list.stream().filter(n->n%2==0).count();
		System.out.println(cnt);
		
		list.stream().filter(n->n%2==0).forEach(System.out::println);
		
		list.stream().filter(n->n%2==0).map(n->n*2).forEach(System.out::println);
		
		List<String> names = Arrays.asList("Bunny","anirudh","leena","hema");
		
		names.stream().filter(name->name.contains("a")).map(name->name.length()).forEach(System.out::println);
		
		LocalDate dat = LocalDate.now();
		System.out.println(dat);
		
		LocalTime da = LocalTime.now();
		System.out.println(da);
		
		
	
	}

}
