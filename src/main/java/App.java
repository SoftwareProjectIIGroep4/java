import dataAccess.Cache;

public class App {
	public static void main(String[] args) {
		System.out.println("Invocation #1");
		try {
			System.out.println(Cache.addressCache.get(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Invocation #2");

	}
}