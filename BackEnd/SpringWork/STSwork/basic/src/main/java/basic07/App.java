package basic07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
	private static ApplicationContext ctx;
    public static void main( String[] args )
    {
    	ctx = new AnnotationConfigApplicationContext(ApplicationContextConfigure.class);
    	
    	MessageBean bean = ctx.getBean("getMessageKr", MessageBean.class);
    	bean.sayHello();
    	
    	bean = ctx.getBean("getMessageEn", MessageBean.class);
    	bean.sayHello();
    }
}
