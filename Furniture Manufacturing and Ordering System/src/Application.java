import java.util.Random;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Random random_choice = new Random();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of random request cycles: ");
		int cycle_number = scanner.nextInt();
		int counter = 0 ;
		String[] products = {"Sofa", "Bed", "Chair", "Dresser", "Table", "Bookcase"};
		String product;
		FactoryLine<Object>  MarketingAnalyst = new FactoryLine<Object>(cycle_number);
		Warehouses<Object> StorageChief = new Warehouses<Object>(cycle_number );
		SoldProducts<Object> Customer = new SoldProducts<Object>(cycle_number);
		Sofa sofa = new Sofa(MarketingAnalyst,StorageChief,Customer);
		Bed bed = new Bed(MarketingAnalyst,StorageChief,Customer);
		Chair chair = new Chair(MarketingAnalyst,StorageChief,Customer);
		Dresser dresser = new Dresser(MarketingAnalyst,StorageChief,Customer);
		Bookcase bookcase = new Bookcase(MarketingAnalyst,StorageChief,Customer);
		Table table = new Table(MarketingAnalyst,StorageChief,Customer);

		while( counter != cycle_number) {
			
			int activity = random_choice.nextInt(3);
			
			if (activity == 0) {
				int types_of_furniture = random_choice.nextInt(6);
				product = products[types_of_furniture];
				if(product.equals("Sofa")) {
					MarketingAnalyst.enqueue(sofa);
				}
				else if(product.equals("Bed")) {
					MarketingAnalyst.enqueue(bed);
				}
				else if(product.equals("Chair")) {
					MarketingAnalyst.enqueue(chair);
				}
				else if(product.equals("Dresser")) {
					MarketingAnalyst.enqueue(dresser);
				}
				else if(product.equals("Bookcase")) {
					MarketingAnalyst.enqueue(bookcase);
				}
				else {
					MarketingAnalyst.enqueue(table);
				}
				System.out.println("Marketing Analyst requesting "+product+", SUCCESS, "+product+" manufactured");
			}
			
			else if(activity == 1) {
				if(sofa.isManufactured(sofa)) {
					StorageChief.push(StorageChief.getSofa_warehouse(), StorageChief.getTop_sofa_warehouse(), sofa);
					StorageChief.setTop_sofa_warehouse(StorageChief.getTop_sofa_warehouse() + 1);
					System.out.println("Storage Chief storing Sofa, SUCCESS, Sofa stored in Sofa warehouse");
					MarketingAnalyst.dequeue();
				}
				else if(bed.isManufactured(bed)){
					StorageChief.push(StorageChief.getBed_warehouse(), StorageChief.getTop_bed_warehouse(), bed);
					StorageChief.setTop_bed_warehouse(StorageChief.getTop_bed_warehouse() + 1);
					System.out.println("Storage Chief storing Bed, SUCCESS, Bed stored in Bed warehouse");
					MarketingAnalyst.dequeue();
				}
				else if(chair.isManufactured(chair)) {
					StorageChief.push(StorageChief.getChair_warehouse(), StorageChief.getTop_chair_warehouse(), chair);
					StorageChief.setTop_chair_warehouse(StorageChief.getTop_chair_warehouse() + 1);
					System.out.println("Storage Chief storing Chair, SUCCESS, Chair stored in Chair warehouse");
					MarketingAnalyst.dequeue();
				}
				else if(dresser.isManufactured(dresser)) {
					StorageChief.push(StorageChief.getDresser_warehouse(), StorageChief.getTop_dresser_warehouse(), dresser);
					StorageChief.setTop_dresser_warehouse(StorageChief.getTop_dresser_warehouse() + 1);
					System.out.println("Storage Chief storing Dresser, SUCCESS, Dresser stored in Dresser warehouse");
					MarketingAnalyst.dequeue();
				}
				else if(table.isManufactured(table)) {
					StorageChief.push(StorageChief.getTable_warehouse(), StorageChief.getTop_table_warehouse(), table);
					StorageChief.setTop_table_warehouse(StorageChief.getTop_table_warehouse() + 1);
					System.out.println("Storage Chief storing Table, SUCCESS, Table stored in Table warehouse");
					MarketingAnalyst.dequeue();
				}
				else if(bookcase.isManufactured(bookcase)) {
					StorageChief.push(StorageChief.getBookcase_warehouse(), StorageChief.getTop_bookcase_warehouse(), bookcase);
					StorageChief.setTop_bookcase_warehouse(StorageChief.getTop_bookcase_warehouse() + 1);
					System.out.println("Storage Chief storing Bookcase, SUCCESS, Bookcase stored in Bookcase warehouse");
					MarketingAnalyst.dequeue();
				}
				else {
					System.out.println("Storage Chief can not stored products, FAIL, no product manufactured");
				}

				
			}
			
			else if(activity == 2) {
				int types_of_furniture = random_choice.nextInt(6);
				product = products[types_of_furniture];
				if(product.equals("Sofa")) {
					if(sofa.isStored(sofa)) {
						Customer.add(sofa);
						System.out.println("Customer buying Sofa, SUCCESS, Customer bought Sofa");
						StorageChief.pop(StorageChief.getSofa_warehouse(), StorageChief.getTop_sofa_warehouse());
						StorageChief.setTop_sofa_warehouse(StorageChief.getTop_sofa_warehouse() - 1);
					}
					else {
						System.out.println("Customer buying Sofa, FAIL, Sofa warehouse empty");
					}
				}
				else if(product.equals("Bed")) {
					if(bed.isStored(bed)) {
						Customer.add(bed);
						System.out.println("Customer buying Bed, SUCCESS, Customer bought Bed");
						StorageChief.pop(StorageChief.getBed_warehouse(), StorageChief.getTop_bed_warehouse());
						StorageChief.setTop_bed_warehouse(StorageChief.getTop_bed_warehouse() - 1);
					}
					else {
						System.out.println("Customer buying Bed, FAIL, Bed warehouse empty");
					}
				}
				else if(product.equals("Chair")) {
					if(chair.isStored(chair)) {
						Customer.add(chair);
						System.out.println("Customer buying Chair, SUCCESS, Customer bought Chair");
						StorageChief.pop(StorageChief.getChair_warehouse(), StorageChief.getTop_chair_warehouse());
						StorageChief.setTop_chair_warehouse(StorageChief.getTop_chair_warehouse() - 1);
					}
					else {
						System.out.println("Customer buying Chair, FAIL, Chair warehouse empty");
					}
				}
				else if(product.equals("Dresser")) {
					if(dresser.isStored(dresser)) {
						Customer.add(dresser);
						System.out.println("Customer buying Dresser, SUCCESS, Customer bought Dresser");
						StorageChief.pop(StorageChief.getDresser_warehouse(), StorageChief.getTop_dresser_warehouse());
						StorageChief.setTop_dresser_warehouse(StorageChief.getTop_dresser_warehouse() - 1);
					}
					else {
						System.out.println("Customer buying Dresser, FAIL, Dresser warehouse empty");
					}
				}
				else if(product.equals("Bookcase")) {
					if(bookcase.isStored(bookcase)) {
						Customer.add(bookcase);
						System.out.println("Customer buying Bookcase, SUCCESS, Customer bought Bookcase");
						StorageChief.pop(StorageChief.getBookcase_warehouse(), StorageChief.getTop_bookcase_warehouse());
						StorageChief.setTop_bookcase_warehouse(StorageChief.getTop_bookcase_warehouse() - 1);
					}
					else {
						System.out.println("Customer buying Bookcase, FAIL, Bookcase warehouse empty");
					}
				}
				else {
					if(table.isStored(table)) {
						Customer.add(table);
						System.out.println("Customer buying Table, SUCCESS, Customer bought Table");
						StorageChief.pop(StorageChief.getTable_warehouse(), StorageChief.getTop_table_warehouse());
						StorageChief.setTop_table_warehouse(StorageChief.getTop_table_warehouse() - 1);
					}
					else {
						System.out.println("Customer buying Table, FAIL, Table warehouse empty");
					}
					
			    }
			}
			
			product = null;
			counter++;
		    
		}
		
		System.out.println("");
		System.out.println("Amount of Bed in Factory Line: " + MarketingAnalyst.getProductCount(bed));
		System.out.println("Amount of Sofa in Factory Line: " + MarketingAnalyst.getProductCount(sofa));
		System.out.println("Amount of Dresser in Factory Line: " + MarketingAnalyst.getProductCount(dresser));
		System.out.println("Amount of Table in Factory Line: " + MarketingAnalyst.getProductCount(table));
		System.out.println("Amount of Chair in Factory Line: " + MarketingAnalyst.getProductCount(chair));
		System.out.println("Amount of Bookcase in Factory Line: " + MarketingAnalyst.getProductCount(bookcase));
		System.out.println("");
		
		System.out.println("Amount of Bed in Bed Warehouse: " + StorageChief.getProductCount(StorageChief.getTop_bed_warehouse()));
		System.out.println("Amount of Sofa in Sofa Warehouse: " + StorageChief.getProductCount(StorageChief.getTop_sofa_warehouse()));
		System.out.println("Amount of Dresser in Dresser Warehouse: " + StorageChief.getProductCount(StorageChief.getTop_dresser_warehouse()));
		System.out.println("Amount of Table in Table Warehouse: " + StorageChief.getProductCount(StorageChief.getTop_table_warehouse()));
		System.out.println("Amount of Chair in Chair Warehouse: " + StorageChief.getProductCount(StorageChief.getTop_chair_warehouse()));
		System.out.println("Amount of Bookcase in Bookcase Warehouse: " + StorageChief.getProductCount(StorageChief.getTop_bookcase_warehouse()));
		System.out.println("");
		
		System.out.println("Amount of Bed Sold: " + Customer.getProductCount(bed));
		System.out.println("Amount of Sofa Sold: " + Customer.getProductCount(sofa));
		System.out.println("Amount of Dresser Sold: " + Customer.getProductCount(dresser));
		System.out.println("Amount of Table Sold: " + Customer.getProductCount(table));
		System.out.println("Amount of Chair Sold: " + Customer.getProductCount(chair));
		System.out.println("Amount of Bookcase Sold: " + Customer.getProductCount(bookcase));

	   
	}
}