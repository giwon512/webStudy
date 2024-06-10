package basic06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	private static ApplicationContext ctx;
    public static void main( String[] args )
    {
    	//resources라는 폴더는 classpath에 이미 지정되어 있다.
        ctx = new ClassPathXmlApplicationContext("config/basic06_config.xml");
    	//ctx = new AnnotationConfigApplicationContext("basic06");
    	
        MessageBean bean = ctx.getBean("messageBeanKr", basic06.MessageBeanKr.class);
        bean.sayHello();
        
        bean = ctx.getBean("msgEn", MessageBeanEn.class);
        bean.sayHello();
    }
}
