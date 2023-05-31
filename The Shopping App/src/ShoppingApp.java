import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ShoppingApp {
	
	public static int find_itemweight(String array) { //gives the name of the item weight to 
		String[] temp_array = array.split(",");        //be added to the shopping bag.
		return Integer.parseInt(temp_array[2]);
	}
	
	public static String find_itemname(String array) { //gives the name of the item  to
		String[] temp_array = array.split(",");         // be added to the shopping bag.
		return temp_array[0];
	}
	
	public static String find_itemcomp_gotothefridge(String name,String[] item) {
		for ( int i = 0 ; i < item.length ; i++) {
			String[] temp_array = item[i].split(","); //gives the name of the item compartment  to
			if (temp_array[0].equals(name)) {         // be added to the fridge.
				return temp_array[1];
			}
		}
		return null;
	}
	
	public static int find_itemweight_gotothefridge(String name,String[] item) {
		for ( int i = 0 ; i < item.length ; i++) {
			String[] temp_array = item[i].split(",");   //gives the name of the item weight to
			if (temp_array[0].equals(name)) {           //be added to the fridge.
				return Integer.parseInt(temp_array[2]);
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		String[] item = new String[14];
		try(Scanner scanner = new Scanner(new FileReader("inventory.txt"))){
			int i = 0;
			while(scanner.hasNextLine()) {
				item[i] = scanner.nextLine();
				i++;
			}
	    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mainmenu = "[1]Go to shopping\n"+
		                  "[2]See the status of the fridge\n"+
		                  "[3]Exit";
		String shopping_mainmenu = "[1]Add an item to the basket\n"+
		                           "[2]See the basket\n"+
				                   "[3]Finish shopping";
		String foods = "[1]tomato\n"
				+ "[2]potato\n"
				+ "[3]onion\n"
				+ "[4]banana\n"
				+ "[5]strawberry\n"
				+ "[6]chicken\n"
				+ "[7]beef\n"
				+ "[8]fish\n"
				+ "[9]coffee\n"
				+ "[10]coke\n"
				+ "[11]juice\n"
				+ "[12]chocolate\n"
				+ "[13]cake\n"
				+ "[14]nuts";
		MeatsCompartment<String> meats = new MeatsCompartment<String>();
		VegetablesFruitsCompartment<String> vegefruit = new VegetablesFruitsCompartment<String>();
		BevaragesCompartment<String> bevarages = new BevaragesCompartment<String>();
		ShoppingBasket<String> shoppingbasket = new ShoppingBasket<String>();
		SnacksCompartment<String> snacks = new SnacksCompartment<String>();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to The Shopping App!");
		while(true) {
			
			if(!meats.checkCapacity() && !vegefruit.checkCapacity() && !bevarages.checkCapacity() && !snacks.checkCapacity()) {
				System.out.println("You cannot add any more items to the fridge.");
				break; // checks if all compartments have size left.
			}
			
			System.out.println("Please select an option:");
			System.out.println(mainmenu);
			int choice = scanner.nextInt();
			
			
			if(choice == 1) {
				
				while(true) {
					
					System.out.println("Please select an option:");
					System.out.println(shopping_mainmenu);
					int shopping_choice = scanner.nextInt();
					
					if(shopping_choice == 1) {
						
						System.out.println("Please select an item:");
						System.out.println(foods);
						int item_choice = scanner.nextInt();
						int item_weight = find_itemweight(item[item_choice - 1]);
						String item_name = find_itemname(item[item_choice - 1]);
						if(shoppingbasket.decreaseCapacity(item_weight) ) {
							shoppingbasket.add(item_name);
							System.out.println(item_name + " is added to the basket.");
						}
						else {
							System.out.println(item_name + " couldn’t be added to the basket."); 
						}
						
						if(!shoppingbasket.checkCapacity()) {
							if(shoppingbasket.isFull()) {
								System.out.println("Basket is full now.");
								shopping_choice = 3 ;
							}
							else {
								System.out.println("You cannot add any more items to the basket.");
								shopping_choice = 3 ;
							}
						}
						
						
					}
					
					else if(shopping_choice == 2) {
						
						shoppingbasket.displayItems();
						
					}
					
					
					 if(shopping_choice == 3 ) {
						
						System.out.println("Shopping is finished and going to fill the fridge.");
						String [] items_go_to_fridge = shoppingbasket.copyarray();
						for(int i = 0 ; i < items_go_to_fridge.length ; i++ ) {
							
							
							if(find_itemcomp_gotothefridge(items_go_to_fridge[i],item).equals("vegetables and fruits")){
								if(vegefruit.decreaseCapacity(find_itemweight_gotothefridge(items_go_to_fridge[i],item)) ) {
									vegefruit.add(items_go_to_fridge[i]);
								}
								else {
									System.out.println(items_go_to_fridge[i] + " couldn’t be added to the fridge."); 
								}
							}
							
							else if(find_itemcomp_gotothefridge(items_go_to_fridge[i],item).equals("meats")){
								if(meats.decreaseCapacity(find_itemweight_gotothefridge(items_go_to_fridge[i],item)) ) {
									meats.add(items_go_to_fridge[i]);
								}
								else {
									System.out.println(items_go_to_fridge[i] + " couldn’t be added to the fridge."); 
								}
							}
							
							else if(find_itemcomp_gotothefridge(items_go_to_fridge[i],item).equals("beverages")){
								if(bevarages.decreaseCapacity(find_itemweight_gotothefridge(items_go_to_fridge[i],item)) ) {
									bevarages.add(items_go_to_fridge[i]);
								}
								else {
									System.out.println(items_go_to_fridge[i] + " couldn’t be added to the fridge."); 
								}
							}
							
							else {
								if(snacks.decreaseCapacity(find_itemweight_gotothefridge(items_go_to_fridge[i],item)) ) {
									snacks.add(items_go_to_fridge[i]);
								}
								else {
									System.out.println(items_go_to_fridge[i] + " couldn’t be added to the fridge."); 
								}
							}
						}
						shoppingbasket.dump();
						System.out.println("The fridge is filled.");
						break;
						
					}
					
				}
				
			}
			
			else if(choice == 2) {
				
				System.out.println("Remaining capacities of each compartments:");
				vegefruit.displayCapacity();
				meats.displayCapacity();
				bevarages.displayCapacity();
				snacks.displayCapacity();
				
			}
			
			else if(choice == 3) {
				
				break;
				
			}
			
			else {
				System.out.println("Wrong Input...");
			}
			
		}
		

		
		
		
		

	}

}
