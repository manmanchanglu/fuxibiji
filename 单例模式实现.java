public class Singleton{
	private volatile static Singleton uniqueInstance;
	private Singleton(){
	}
	public static Singleton getUniqueInstance(){
		if(uniqueInstance==null){
			synchronized(Singleton.class){
				if(uniqueInstance==null){
					uniqueInstance=new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}



public class Singleton{
	private Singleton(){
	}
	private static class SingletonHolger
	{
		private static final Singleron INSTANCE=new Singleton();
	}
	public static getUniqueInstance(){
		return SingletonHolger.INSTANCE;
	}
}