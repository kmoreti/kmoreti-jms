package com.kmoreti.kmoretijms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KmoretiJmsApplication {

	public static void main(String[] args) throws Exception {
//		ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
//		.setPersistenceEnabled(false)
//		.setJournalDirectory("target/data/journal")
//		.setSecurityEnabled(false)
//		.addAcceptorConfiguration("invm", "vm://0"));
//		server.start();

		ApplicationContext applicationContext = SpringApplication.run(KmoretiJmsApplication.class, args);
	}

}
