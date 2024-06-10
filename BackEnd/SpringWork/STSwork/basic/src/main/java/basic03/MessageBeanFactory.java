package basic03;

public class MessageBeanFactory {
	private static MessageBeanFactory factory = new MessageBeanFactory();
	
	private MessageBeanFactory() {}
	
	public static MessageBeanFactory instanceOf() {
		return factory; 
	}
	
	public MessageBean createMessage(String nation) {
		if(nation.equals("kr")) {
			return new MessageBeanKr();
		}
		else {
			return new MessageBeanEn();
		}
	}
}
