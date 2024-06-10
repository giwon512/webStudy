package basic07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfigure {
	@Bean
	public MessageBean getMessageKr() {
		FileOutputter out = new FileOutputter();
		out.setFilePath("src/main/java/basic07/resultKor.txt");
		return new MessageBeanKr("steve", "25", out);
	}
	
	@Bean
	public MessageBean getMessageEn() {
		MessageBeanEn en = new MessageBeanEn();
		FileOutputter out = new FileOutputter();
		out.setFilePath("src/main/java/basic07/resultEng.txt");
		en.setName("john");
		en.setAge("30");
		en.setOutputter(out);
		return en;
	}
}
