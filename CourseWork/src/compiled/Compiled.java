package compiled;

import java.util.Scanner;
import general.*;

public class Compiled
{

	public static Scanner Key = new Scanner(System.in);
	
	//Keanan McIntyre
	//Keanan McIntyre
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
				WoodFlooring();
				break;
			case 2: 
				carpet();
				break;
			case 3: 
				Tile();
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
	
	//Keanan McIntyre
	//Keanan McIntyre
	
	
	
	
	
	
	//Odrhan Doherty
	//Odrhan Doherty
	
	public static void Tile() 
	{
		
		int tiletype = 0,menuopt = 0,extras = 0, tile = 0;	
		boolean subspacers = false, fittingcosts = false;
		double L = 0.0, W = 0.0, A = 0.0,totalp = 0.00; 
		
		//Asking for the length and breath and then finding the area
		
		Line();
		
		My.skip(1);
		
		My.p("What is the length of your room?: ");
		L = Key.nextDouble();
		
		My.skip(1);
		
		My.p("What is the Width of your room?: ");
		W = Key.nextDouble();
		
		My.skip(1);
		
		A = Area(L,W);
		My.p(String.format("Area: %.2f", A));
		
		Line();
		
		menuopt = submenu(menuopt);
		
		
		//showing the option that the user entered and adding to the total price
		switch (menuopt)
		{
		case 1: 
			My.p("\n\n\tYou selected: " + menuopt);
			totalp = totalp + 5.99;
		break;
		case 2:
			My.p("\n\n\tYou selected: " + menuopt);
			totalp = totalp + 6.89;
		break;
		case 3:
			My.p("\n\n\tYou selected: " + menuopt);
			totalp = totalp + 3.29;
		break;
		case 4:
			My.p("\n\n\tYou selected: " + menuopt);
			totalp = totalp + 4.67;
		break;
		case 5 :
			My.p("\n\n\t You selected: " + menuopt);
			totalp = totalp + 2.99;
		break;
		case 6 :
			My.p("\n\n\tGoodbye");
			System.exit(0);
		break;
		
			}
		My.p("\n");
			Line();
			My.skip(30);
			
			extras = submenu2(extras);//links extras method to appear here
			
			switch (extras)//switch method for extras
			{
			case 1: 
				My.p("\n\n\tYou selected: " + extras);
				totalp = totalp + 5.99;
			break;
			case 2:
				My.p("\n\n\tYou selected: " + extras);
				totalp = totalp + 6.89;
			break;
			case 3:
				My.p("\n\n\tYou selected: " + extras);
				totalp = totalp + 3.29;
			break;
			case 4 :
				My.p("\n\n\tGoodbye");
				System.exit(0);	
			break;
			}
			
			My.p("\n");
			Line();
			My.skip(30);
			
			subspacers = subspacers(subspacers);//shows subspacers menu
			
			My.p("\n");
			Line();
			My.skip(30);
			
			fittingcosts = submenu3(fittingcosts);//shows submenu3 menu 
			
			Line();
			
			My.p("\n");
			Line();
			My.p("\n");
			
			//tile = Bill(tile); not sure why this wont link
	
	}

	//CALCUATING THE AREA
	public static double Area(double L, double W)
	
	{
		double AreaRESULT;
		AreaRESULT = L*L * W*W;
		AreaRESULT= Math.sqrt(AreaRESULT);
		return AreaRESULT; 
	}
	
	public static int submenu(int menuopt)
	
	{
			My.skip(30);
		//listing the options for tiles
			My.p("\n\n\tWhich off the following tiles would you like: ");
			My.p("\n\n\t1: Quartz Stone Midnight Black: £5.99: Tile size: 300x300mm(M) ");
			My.p("\n\n\t2: Presealed Terracotta: £6.89: Tile size: 300x300mm(M) ");
			My.p("\n\n\t3: Super White Porcelain: £3.29: Tile size: 300x600mm(L) ");
			My.p("\n\n\t4: Coda Grey: £4.67: Tile size: 310x560mm(L) ");
			My.p("\n\n\t5: Grey marbel: £2.99: Tile size: 300x150mm(S)  ");
			My.p("\n\n\t6: EXIT: ");
		
		menuopt = Key.nextInt();
		return menuopt;
		
	}
	//This is for the for the extras 
	public static int submenu2(int extras)
	{
		My.p("\n\n\tWhich off the following tiles would you like: ");
		My.p("\n\n\t1: Grey Grout 5kg: £29.95: 20 square meters ");
		My.p("\n\n\t2: White Grout 2kg: £19.95: 8 square meters ");
		My.p("\n\n\t3: Spaces(Pack of 50): £5.99: undefined ");
		My.p("\n\n\t4: EXIT: ");
		
		extras = Key.nextInt();
		return extras;
	
	}
	public static boolean subspacers(boolean subspacers)//asking do they want spacers
	{
		String input = "";
		char option1=' ';
		My.p("\n\n\tWould you like spacers: Y/N ");
		input = Key.next();
		
		option1 = input.charAt(0);
		if (option1 == 'Y'|| option1 == 'y')
		{
				subspacers=false;
				
		}
		else subspacers = true;
		return subspacers;
	}
	
	public static boolean submenu3(boolean fittingcosts)//asking do they want it fitted
	{
		String input = "";
		char Option = ' ';
		My.p("\n\n\tWould you like it fitted: Y/N ");
		input = Key.next();
		
		Option = input.charAt(0);
		if (Option == 'Y'|| Option == 'y')
		{
				fittingcosts=false;
				
		}
		else fittingcosts = true;
		
		return fittingcosts;
	}
	
	public static int Bill(int tile, double tileprice, double fittingcost, double extra,int x,int y, int z, int w, int menuopt, int extras,boolean fittingcosts, boolean subspacers, double totalp,double A, int bill, int extras1)
	{
		{
			int x1 = 0, y1 = 0; 	// used to hold different parts off extra,menuopt etc
			boolean z1 , w1;	// used to hold different parts off extra,menuopt etc
			double[] tileprice1 = {5.99, 6.89, 3.29, 4.67, 2.99};
			double fittingcost1 = 0.00;
			double[] extra1 = {29.95,19.95};
			String[] Tiles = {"Quartz Stone Midnight Black","Presealed Terracotta", "Super White porclain","Coda Grey", "Grey Marble Split Mosaic" };
			String[] extra11 = {"Grey Grout 5kg", "White Grout 2 kg"};
			int sqm = 0, tileA=0;
			
			
			
			
			
			//helping figuring the number of tiles needed for the area
			while (sqm < A)
			{
				sqm +=1;
			}
			tileA = sqm; 
			
			
		//this links to the user input that has been given from submenu	
			x1 = submenu(x1) - 1; // this is the linking x to the menuopt
			menuopt = submenu(x1) - 1;
			y1 = submenu2(y1) - 1;
		   
			z1 = fittingcosts;
			w1 = subspacers;
			
			//BIll
			
			My.p("Bill");
			My.p("Tiles selected: :" + menuopt );
			
			
		return tile;
		}
		
	}
	public static void Line()//this is a for loop for doing the spaces between different parts off the code
	{
	
		for (int i=0;i<50;i++)
		{
			My.p("-");
		}
	}
	//Odrhan Doherty
	//Odrhan Doherty
	
	
	
	
	
	
	//Ethan Thompson
	//Ethan Thompson
	
	
	public static void WoodFlooring() {
	
	int userinput = 0, userinput2 = 0, userinput3 = 0, flooring = 0, underlayamount = 1 ;
	double price1 = 0.00, price2 = 0.00, price3 = 0.00, sqm1 = 0.00, sqm2 = 0.00, temp = 0.00, length = 0.00, width = 0.00, overall = 0.00
			,temp2 =0.00, temp3=0.00;
	
	//menu code
	My.p(String.format("\n\n\t %-15s %15s %15s %s %15s", "Name", "|","Price per sq m", "|", "Other details"));
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "1.Rustic Oak", "|", "£33.98", "|", " "));
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "2.Natural Oak", "|", "£27.99", "|", " "));
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "3.Golden Oak", "|", "£39.99", "|", " "));
	My.p(String.format("\n\t %-15s %14s %15s %s %15s", "4.Mayfair Walnut", "|", "£99.00", "|", " "));
	My.p("\n\t");
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "Extras:", "|", "", "|", " "));
	My.p(String.format("\n\t %-15s %4s %15s %s %15s", "5.Underlay- Vapour barrier", "|", "£19.99", "|", "Roll of 20 sq m "));
	My.p(String.format("\n\t %-15s %2s %15s %s %15s", "6.Underlay- Timberlay Silver", "|", "£49.99", "|", "Roll of 10 sq m "));
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "7.No extras", "|", " ", "|", " "));
	My.p("\n\t");
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "Fitting Costs:", "|", " ", "|", " "));
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "8.Up to 20 sq m", "|", "£200.00", "|", " "));
	My.p(String.format("\n\t %-15s %8s %15s %s %15s", "9.Between 20 - 40 sq m", "|", "£350.00", "|", " "));
	My.p(String.format("\n\t %-15s %15s %15s %s %15s", "10.Over 40 sq m", "|", "£350.00", "|", "+ £7 per sq m over 40 "));
	My.p("\n\t-------------------------------------------------------------------------");
	//first choice
	My.p("\n\n\t Please choose an option from the first table number 1 - 4.");
	//user input
	userinput = MyVal.validInt();
	My.p("\n\n\t Please choose an option from the second table number 5 - 7.");
	userinput2 = MyVal.validInt();
	My.p("\n\n\t Please enter the width of the room.");
	width = MyVal.validDouble();
	My.p("\n\n\t Please enter the length of the room.");
	length = MyVal.validDouble();
	//calculation for sq m
	sqm1 = length * width;
	My.p("\n\n\t Would you like us to fit your flooring enter 1.yes 2.No");
	flooring = MyVal.validInt();
	
	//if statement for userinput of flooring
	if (userinput == 1) {
		price1 = sqm1 * 33.98;
	}else if (userinput == 2) {
		price1 = sqm1 * 27.99;
	}else if (userinput == 3) {
		price1 = sqm1 * 39.99;
	}else if (userinput == 4) {
		price1 = sqm1 * 99.00;
	}else {
		My.p("\n\n\t Invalid input.");
	}
	
	//if statement for userinput of underlay
	if (userinput2 == 5) {
		underlayamount = (int) (sqm1 / 20);
		if (sqm1 % 20 != 0) {
			underlayamount = underlayamount + 1;
			price2 = underlayamount * 19.99;
		}
		}else if (userinput2 == 6) {
		underlayamount = (int) (sqm1 / 10);
		if (sqm1 % 10 != 0) {
			underlayamount = underlayamount + 1;
			price2 = underlayamount * 49.99;
		}
		}else if (userinput2 == 7){
			price2 = 0.00;
		}else {
		
			My.p("\n\n\t Invalid input.");
		}
	//userinput of fitting.
	if (flooring == 1) {
		if (sqm1 <= 20) {
			price3 = 200.00;
		}else if (sqm1 >= 21 && sqm1 <= 40) {
			price3 = 350.00;
		}else if (sqm1 >= 41) {
			temp = sqm1 - 40;
			price3 = 350.00;
			temp = temp * 7;
			price3 = price3 + temp;
		}
	}
	overall = price3 + price2 + price1;
	
	//if statement to work out if delivery fee is required
	if (overall <= 1000) {
		overall = overall + 40.00;
	}
	
	//receipt for the final screen where user will see all the prices
	My.p("\n\n\t *********Reciept**********");
	My.p(String.format("\n\n\t %15s %.2f", "Your flooring price is £", price1));
	My.p("\n\n\t Your extra costs are £" + price2);
	My.p("\n\n\t Your fitting cost is £" + price3);
	My.p("\n\n\t********************************");
	My.p("\n\n\t Your overall price for your wood flooring is £" + overall);
	}
	
	//Ethan Thompson
	//Ethan Thompson
}
