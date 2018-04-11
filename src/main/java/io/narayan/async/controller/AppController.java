package io.narayan.async.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author narayana
 *
 */
@RestController
public class AppController {

	@GetMapping
	public String hello(@RequestParam String name) throws Exception {
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("yea " + name);
			}
		}).start();
		return "Hello!";
	}
}
