package courseWork;

import java.util.Scanner;
import general.*;

public class CourseWork 
{
	public static Scanner Key = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int MenuOpt = 0;

		do
		{
			menu();
			My.p("\n\n\tSelect Floor Type: ");
			My.p("\n\t1. Wood");
			My.p("\n\t2. Carpet");
			My.p("\n\t3. Tile\n");
			MenuOpt = Key.nextInt();
			menu();
			
			switch (MenuOpt)
			{
			case 1:
				break;
			case 2: 
				carpet();
				break;
			case 3: 
				break;
			default: 
				MenuOpt=0;
			}	
		}
		while (MenuOpt==0);
	}//end of main
	

	public static void carpet()
	{
		String[] Carpet = {"Vienna Sandstone","Chicago Thunderstorm","Seattle Latte",
				"Cairo Brushed Cotton","Toronto Lavastone"};	// used fot bill
		String[] UnderLay = {"Super 8mm Roll","High Density 11mm Roll"};
		double[] SqMPrice = {12.59, 14.39, 17.59, 19.59, 20.99}; //per m^2
		double[] UnderLayPrc = {49.99, 89.99}; //per roll 15 SqM
		double Length=0.00, Width=0.00, Area=0.00, Perm=0.00;
		double FittingCost = 0.00, GripperCost = 9.95;
		double UnderlayCost =0.00, CarpetPrice=0.00, GripCost=0.00, DeliveryFee=0.00, Total = 0.00;
		boolean Gripper = true, Fitted = true;
		String GSelected = "No", FSelected = "No";
		int x =0, y=0; //used to get values from arrays
		int RollArea=0, NoRolls=0, NoGrip=0, GripLng=0, Over=0, SqM = 0;
		
		
		menu();
		My.p("\n\n\tEnter Length of Room In Metres: ");	//getting length of room
		Length = Key.nextDouble();
		
		My.p("\n\n\tEnter Width of Room In Metres: "); //getting width of room
		Width = Key.nextDouble();
		Area = Length*Width;
		Perm = (Length+Width)*2;
		My.p("\n");
		menu();
		
		
		while (SqM < Area) //calculates m^2 of carpet needed
		{
			SqM += 1;
		}
		RollArea = SqM; //roll area of underlay
		
		x = carpetType(x) - 1; //redirects to carpet type method
		CarpetPrice = SqM*SqMPrice[x];
		Total+=CarpetPrice;
		
		y = underlay(y)-1; //redirects to underlay method
		while (RollArea%15>0) // calculates how much underlay is needed
		{
			RollArea+=1;
		}
		NoRolls = RollArea/15;
		
		UnderlayCost = NoRolls*UnderLayPrc[y];
		Total+=UnderlayCost;
		
		Gripper = grippers(Gripper); //redirects to grippers method
		if (Gripper = true)
		{
			GSelected = "Yes";
			GripLng = (int)Perm; //calculates how much grippers are needed
			while (GripLng%15 >0)
			{
				GripLng +=1;
			}
			NoGrip = GripLng/15;
			GripCost = NoGrip*GripperCost; 
		}
		Total +=GripCost;
		
		Fitted = fitting(Fitted); //calculate fitting cost
		if (Fitted == true)
		{
			FSelected = "Yes";
			if (SqM <=20)
			{
				FittingCost = 125.00;
			}
			else if (SqM >20 && SqM <=40)
			{
				FittingCost=200.00;
			}
			else
			{
				Over = SqM-40;
				FittingCost=200.00;
				while (Over>0)
				{
					FittingCost+=4.00;
					Over--;
				}
			}
		}
		Total+=FittingCost;
		if (Total>=1000.00) //calculate delivery fee
		{
			DeliveryFee=0.00;
		}
		else
		{
			DeliveryFee=40.00;
		}
		
		
		My.skip(25);
		menu(); //printing the bill
		My.p("\n\n\tBill");
		My.p("\n\n\tCarpet Type: " + Carpet[x]);
		My.p("\n\tCost per Square Metre: " + SqMPrice[x]);
		My.p("\n\tArea of Carpet Needed: " + SqM + "M^2");
		My.p("\n\tPrice of Carpet: " + CarpetPrice);
		My.p("\n\n\tUnderLay Chosen: " + UnderLay[y]);
		My.p("\n\tPrice of UnderLay per Roll: " + UnderLayPrc[y]);
		My.p("\n\tNumber of Rolls needed: " + NoRolls);
		My.p("\n\tCost of UnderLay: " + UnderlayCost);
		My.p("\n\n\tGripers Selected: " + GSelected);
		if (Gripper ==true)
		{
			My.p("\n\tPrice of Grippers per 15m Strip: " + GripperCost);
			My.p("\n\tNumber of Strips: " + NoGrip);
			My.p(String.format("\n\tCost of Grippers: £%.2f", GripCost));
		}
		My.p("\n\n\tFitting Selected: " + FSelected);
		if (Fitted==true) 
		{
			My.p("\n\tFitting Cost: £" + FittingCost);
		}
		My.p(String.format("\n\n\tTotal cost: £%.2f", Total));
		My.p("\n\tDelivery Fee: £" + DeliveryFee + "\n");
		//end of bill
		menu(); 
		
	}// end of carpet
	
	
	public static void menu() //just for lines used in menus
	{
		String menu = "-";
		for (int i=0; i<50; i++)
		{
			My.p(menu);
		}
	}// end of menu
	
	// end of main menu
	
	public static int carpetType(int MenuOpt) //carpet type submenu
	{
		My.skip(25);
		menu();
		My.p("\n\n\tSelect Carpet Type: ");
		My.p("\n\t1. Vienna Sandstone");
		My.p("\n\t2. Chicago Thunderstorm");
		My.p("\n\t3. Seattle Latte");
		My.p("\n\t4. Cairo Brushed Cotton");
		My.p("\n\t5. Toronto Lavastone\n");
		MenuOpt = Key.nextInt();
		menu();
		
		return MenuOpt;
	}// end of carpet type menu
	
	public static int underlay(int MenuOpt) //underlay submenu
	{
		My.skip(25);
		menu();
		My.p("\n\n\tSelect Underlay option: ");
		My.p("\n\t1. Super 8mm Roll");
		My.p("\n\t2. High Density 11mm Roll\n");
		MenuOpt = Key.nextInt();
		menu();
		
		return MenuOpt;
	} // end of underlay menu
	
	public static boolean grippers(boolean MenuOpt) //grippers submenu
	{
		String input="";
		char Option=' ';
		
		My.skip(25);
		menu();
		My.p("\n\n\tDo You Want Grippers (Y/N)\n");
		input = Key.next();
		menu();
		
		Option = input.charAt(0);
		if (Option== 'Y' || Option =='y')
		{
			MenuOpt=true;
		}
		else MenuOpt = false;
		
		
		return MenuOpt;
	} // end of gripper menu
	
	public static boolean fitting (boolean MenuOpt) //fitting submenu
	{
		String input="";
		char Option=' ';
		
		My.skip(25);
		menu();
		My.p("\n\n\tDo You Want It Fitted? (Y/N)\n");
		input = Key.next();
		menu();
		
		Option = input.charAt(0);
		if (Option== 'Y' || Option =='y')
		{
			MenuOpt=true;
		}
		else MenuOpt = false;
		
		
		return MenuOpt;
	} //end of fitting menu
}
