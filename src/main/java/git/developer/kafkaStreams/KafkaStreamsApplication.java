package git.developer.kafkaStreams;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class KafkaStreamsApplication {

	@Bean
	NewTopic topic(){
		return new NewTopic("test",1,(short)3);
	}
//	@Bean
//	NewTopic topic2(){
//		return new NewTopic("quickstart-topic",1,(short)3);
//	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamsApplication.class, args);
	}

}
