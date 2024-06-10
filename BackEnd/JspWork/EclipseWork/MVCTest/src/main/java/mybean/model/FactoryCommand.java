package mybean.model;

public class FactoryCommand {
	private FactoryCommand() {}
	
	private static FactoryCommand instance = new FactoryCommand();
	
	public static FactoryCommand newInstance() {
		return instance;
	}
	
	public ICommand createInstance(String cmd) {
		switch(cmd) {
		case "register" :
			return new RegisterCommand();
		case "confirm" :
			return new ConfirmCommand();
		case "complete" :
			return new CompleteCommand();
		default:
			break;
		}
		return null;
	}
}
