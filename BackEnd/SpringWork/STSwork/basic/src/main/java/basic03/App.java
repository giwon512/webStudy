package basic03;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageBeanFactory factory = MessageBeanFactory.instanceOf();
        
        MessageBean bean = factory.createMessage("kr");
        bean.sayHello("jiwon");
        
        bean = factory.createMessage("null");
        bean.sayHello("steve");
    }
}
