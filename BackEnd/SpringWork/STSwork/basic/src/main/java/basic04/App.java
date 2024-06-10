package basic04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ApplicationContext ctx;
    public static void main( String[] args )
    {
    	//resources라는 폴더는 classpath에 이미 지정되어 있다.
        ctx = new ClassPathXmlApplicationContext("config/basic04_config.xml");
    	
    	
        MessageBean bean = ctx.getBean("msgKr", basic04.MessageBeanKr.class);
        bean.sayHello("jiwon");
        
        bean = ctx.getBean("msgEn", basic04.MessageBeanEn.class);
        bean.sayHello("steve");
        
        bean = ctx.getBean("kr", basic04.MessageBeanKr.class);
        bean.sayHello("steve");
        
    }
}
