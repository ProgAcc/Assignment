package general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyVal 
{
	static Scanner Key = new Scanner (System.in);
	
	/*public static int validInt(int min, int max)

	{
		int num = 0;
		boolean ok;

		do
		{
			try
			{
				ok = true;
				My.p("\n\nEnter Number: ");
				num = Key.nextInt(); 
				Key.nextLine();

				if(num < min  || num > max)
				{
					ok = false;
					My.p(String.format("\n\tError: Range is %2d - %2d.  Please re-enter.", min, max));
				}
			}
			catch(InputMismatchException e)
			{
				My.p("\n\tError:  Illegal character(s) in input - Please re-enter.");	
				Key.nextLine();
				ok = false;
			}
		}
		while(!ok);
		return num;
	} */


	static Scanner key = new Scanner(System.in);
	
	public static int validInt(int Num)
	{
		boolean ok;
		
		do
		{
			try
			{
				ok = true; 
				
			/*	if(num < min  || num > max)
				{
					ok = false;
					My.p(String.format("\n\tError: Range is %2d - %2d.  Please re-enter.", min, max));
				}*/
			}
			catch(InputMismatchException e)
			{
				My.p("\n\tError:  Illegal character(s) in input - Please re-enter.");	
				key.nextLine();
				ok = false;
			}
		
		}while(!ok);

		return Num;
	}
	
	public static double validDouble(int num)
	{
		boolean ok;
		
		do
		{
			try
			{
				ok = true;
			/*	My.p("\n\n\tEnter number:");
				num = key.nextDouble();
				key.nextLine();
				
				if(num < min  || num > max)
				{
					ok = false;
					My.p(String.format("\n\tError: Range is %2d - %2d.  Please re-enter.", min, max));
				}*/
			}
			
			catch(InputMismatchException e)
			{
				My.p("\n\tError:  Illegal character(s) in input - Please re-enter.");	
				key.nextLine();
				ok = false;
			}
		}while(!ok);

		return num;
	}
}