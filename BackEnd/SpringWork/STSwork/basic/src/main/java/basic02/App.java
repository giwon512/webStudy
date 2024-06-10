package basic02;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageBean bean1 = new MessageBeanKr();
        bean1.sayHello("jiwon");
        
        bean1 = new MessageBeanEn();
        bean1.sayHello("steve");
    }
}
