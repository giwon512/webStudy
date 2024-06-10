class ShopService {
	private static ShopService surviceObject;
	
	private ShopService() {}
	
	public static ShopService getInstance() {
		if(surviceObject == null) {
			surviceObject = new ShopService();
		}
		return surviceObject;
	}
}

class ShopServiceExample {
    public static void main(String[] args){
          ShopService obj1 = ShopService.getInstance();
          ShopService obj2 = ShopService.getInstance();

          if(obj1 == obj2) {
              System.out.println("같은 객체이다.");
          }
          else{
              System.out.println("다른 객체이다.");
          }
    }
}