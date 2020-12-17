package general;

public class My {
	public static void p(String s)
	{
		System.out.print(s);
	}
	
	public static void skip(int n)
	{		//lets you skip lines My.skip(n)
		for (int x=1; x <= n; x++)
		{
			System.out.println("");
		}
	}

}
