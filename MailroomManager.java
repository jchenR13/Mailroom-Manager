	/**
	 * The MailroomManager is a simulation of 6 stacks: Stack (A-G), Stack (H-J)
	 * Stack (K-M), Stack (N-R), Stack (S-Z), and the floor
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class MailroomManager {
	
	/**
	 * 
	 * @param args
	 * Can be used to pass arguments into the main
	 */
	public static void main(String[] args) {
		
		PackageStack Stack1 = new PackageStack(); //Stack for recipients between letters (A-G)
		PackageStack Stack2 = new PackageStack(); //Stack for recipients between letters (H-J)
		PackageStack Stack3 = new PackageStack(); //Stack for recipients between letters (K-M)
		PackageStack Stack4 = new PackageStack(); //Stack for recipients between letters (N-R)
		PackageStack Stack5 = new PackageStack(); //Stack for recipients between letters (S-Z)
		PackageStack floor = new PackageStack(); //Stack for the floor
		
		// Prints out the menu and options below
		System.out.println("Welcome to the Irving Mailroom Manager. You\n"
				+ "can try to make it better, but the odds are\n"
				+ "stacked against you. It is day 0.\n");
		System.out.println("Menu:");
		System.out.println("      D) Deliver a package");
		System.out.println("      G) Get someone's package");
		System.out.println("      T) Make it tomorrow");
		System.out.println("      P) Print the stacks");
		System.out.println("      M) Move a package from one stack to another");
		System.out.println("      F) Find packages in the wrong stack and move to floor");
		System.out.println("      L) List all packages awaiting a user");
		System.out.println("      E) Empty the floor");
		System.out.println("      Q) Quit\n");

		Scanner input = new Scanner(System.in);
		String choice = "";
		String recipient = "";
		double weight = 0;
		int dayTime = 0;
		int firstFloor = 0;
		int secondFloor = 0;
		/**
		 * Keeps running the program until q or Q is entered
		 */
		while(!choice.toUpperCase().equals("Q")) {
			System.out.println("Please select an option:");
			String end = input.nextLine();
			switch(end.toUpperCase()) {
			case "D":
				try {
					/**
					 * Asks the user for a recipient name and stack weight. If both valid
					 *  proceed to adding it to their respective stacks, else asks user
					 *  to try again. When adding to a stack if the intended stack is full
					 *  then checks the closest empty stack and adds it into that stack.
					 */
					System.out.println("Please enter the recipient name: ");
					recipient = input.nextLine();
					if (!recipient.matches(".*\\w.*")) {
						System.out.println("An empty name is not allowed \n");
						break;
					}
					System.out.println("Please enter the weight (lbs): ");
					weight = input.nextDouble();
					Package temp = new Package(recipient, dayTime, weight);
					if(recipient.toUpperCase().substring(0,1).compareTo("A") >= 0 && recipient.toUpperCase().substring(0,1).compareTo("G") <= 0) {
						if(Stack1.isFull() == false) {
							Stack1.pushPackage(temp);
						}
						else if(Stack1.isFull() == true) {
								if(Stack2.isFull() == false) {
									Stack2.pushPackage(temp);
								}
								else if(Stack3.isFull() == false) {
									Stack3.pushPackage(temp);
								}
								else if(Stack4.isFull() == false) {
									Stack4.pushPackage(temp);
								}
								else if(Stack5.isFull() == false) {
									Stack5.pushPackage(temp);
								}
								else {
									System.out.println("Adding cannot be done, all stacks are full\n");
									break;
								}
						}
					}
					else if(recipient.toUpperCase().substring(0,1).compareTo("H") >= 0 && recipient.toUpperCase().substring(0,1).compareTo("J")<=0) {
						if(Stack2.isFull() == false) {
							Stack2.pushPackage(temp);
						}
						else if(Stack2.isFull() == true) {
								if(Stack1.isFull() == false) {
									Stack1.pushPackage(temp);
								}
								else if(Stack3.isFull() == false) {
									Stack3.pushPackage(temp);
								}
								else if(Stack4.isFull() == false) {
									Stack4.pushPackage(temp);
								}
								else if(Stack5.isFull() == false) {
									Stack5.pushPackage(temp);
								}
								else {
									System.out.println("Adding cannot be done, all stacks are full\n");
									break;
								}
						}
					}
					else if(recipient.toUpperCase().substring(0,1).compareTo("K")>=0 && recipient.toUpperCase().substring(0,1).compareTo("M")<=0) {
						if(Stack3.isFull() == false) {
							Stack3.pushPackage(temp);
						}
						else if(Stack3.isFull() == true) {
								if(Stack2.isFull() == false) {
									Stack2.pushPackage(temp);
								}
								else if(Stack4.isFull() == false) {
									Stack4.pushPackage(temp);
								}
								else if(Stack1.isFull() == false) {
									Stack1.pushPackage(temp);
								}
								else if(Stack5.isFull() == false) {
									Stack5.pushPackage(temp);
								}
								else {
									System.out.println("Adding cannot be done, all stacks are full\n");
									break;
								}
						}
					}
					else if(recipient.toUpperCase().substring(0,1).compareTo("N")>=0 && recipient.toUpperCase().substring(0,1).compareTo("R")<=0) {
						if(Stack4.isFull() == false) {
							Stack4.pushPackage(temp);
						}
						else if(Stack4.isFull() == true) {
								if(Stack3.isFull() == false) {
									Stack3.pushPackage(temp);
								}
								else if(Stack5.isFull() == false) {
									Stack5.pushPackage(temp);
								}
								else if(Stack2.isFull() == false) {
									Stack2.pushPackage(temp);
								}
								else if(Stack1.isFull() == false) {
									Stack1.pushPackage(temp);
								}
								else {
									System.out.println("Adding cannot be done, all stacks are full\n");
									break;
								}
						}
					}
					else if(recipient.toUpperCase().substring(0,1).compareTo("S")>=0 && recipient.toUpperCase().substring(0,1).compareTo("Z")<=0) {
						if(Stack5.isFull() == false) {
							Stack5.pushPackage(temp);
						}
						else if(Stack5.isFull() == true) {
								if(Stack4.isFull() == false) {
									Stack4.pushPackage(temp);
								}
								else if(Stack3.isFull() == false) {
									Stack3.pushPackage(temp);
								}
								else if(Stack2.isFull() == false) {
									Stack2.pushPackage(temp);
								}
								else if(Stack1.isFull() == false) {
									Stack1.pushPackage(temp);
								}
								else {
									System.out.println("Adding cannot be done, all stacks are full\n");
									break;
								}
						}
					}
					System.out.println("");
					System.out.println("A " + weight + "lb package is awaiting pickup by " + recipient + "\n");
					input.nextLine();
					break;
				}
				/**
				 * If there is an error one of these exceptions will be printed based on the error
				 * 
				 * InputMismactchExceptionn- if the input is incorrect, prompts the user to try again
				 * 
				 * Catches any possible errors and returns a message about the error
				 */
				catch(InputMismatchException e) {
					System.out.println("Invalid input, try again \n");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "G":
				try {
					int count = 0;
					int floorCounter = floor.getTotalPackages();
					/**
					 * Asks the user for the name of the recipient in order to give them their package. 
					 * First, check the intended stack for the name of the recipient, else go to the
					 * nearest stack and checks if that stack contains the recipient. Keeps doing this
					 * until recipient is found.
					 */
					System.out.println("Please enter the recipient name: ");
					recipient = input.nextLine();
					if(recipient.toUpperCase().substring(0,1).compareTo("A") >= 0 && recipient.toUpperCase().substring(0,1).compareTo("G") <= 0) {
						if(Stack1.isEmpty() == false && Stack1.doesPackageStackContain(recipient) == true) {
							for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack1.get(i).getRecipient())))) {
									Package temp = Stack1.get(i);
									floor.pushFloorPackage(temp);
									Stack1.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack1.get(Stack1.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack1.get(Stack1.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 1 from floor \n");
							Stack1.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack1.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack2.isEmpty() == false && Stack2.doesPackageStackContain(recipient) == true) {
							for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack2.get(i).getRecipient())))) {
									Package temp = Stack2.get(i);
									floor.pushFloorPackage(temp);
									Stack2.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack2.get(Stack2.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack2.get(Stack2.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 2 from floor \n");
							Stack2.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack2.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack3.isEmpty() == false && Stack3.doesPackageStackContain(recipient) == true) {
							for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack3.get(i).getRecipient())))) {
									Package temp = Stack3.get(i);
									floor.pushFloorPackage(temp);
									Stack3.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack3.get(Stack3.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack3.get(Stack3.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 3 from floor \n");
							Stack3.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack3.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack4.isEmpty() == false && Stack4.doesPackageStackContain(recipient) == true) {
							for(int i = count-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack4.get(i).getRecipient())))) {
									Package temp = Stack4.get(i);
									floor.pushFloorPackage(temp);
									Stack4.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack4.get(Stack4.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack4.get(Stack4.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 4 from floor \n");
							Stack4.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack4.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack5.isEmpty() == false && Stack5.doesPackageStackContain(recipient) == true) {
							for(int i = count-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack5.get(i).getRecipient())))) {
									Package temp = Stack5.get(i);
									floor.pushFloorPackage(temp);
									Stack5.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack5.get(Stack5.getTotalPackages()-1).getWeight()
									+ " lb package delivered on day " + Stack5.get(Stack5.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 5 from floor \n");
							Stack5.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack5.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else {
							System.out.println("This person does not exist, try someone else \n");
							break;
						}
					}	
					else if(recipient.toUpperCase().compareTo("H") >= 0 && recipient.toUpperCase().compareTo("J") <= 0) {
						if(Stack2.isEmpty() == false && Stack2.doesPackageStackContain(recipient) == true) {
							for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack2.get(i).getRecipient())))) {
									Package temp = Stack2.get(i);
									floor.pushFloorPackage(temp);
									Stack2.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack2.get(Stack2.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack2.get(Stack2.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 2 from floor \n");
							Stack2.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack2.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack1.isEmpty() == false && Stack1.doesPackageStackContain(recipient) == true) {
							for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack1.get(i).getRecipient())))) {
									Package temp = Stack1.get(i);
									floor.pushFloorPackage(temp);
									Stack1.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack1.get(Stack1.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack1.get(Stack1.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 1 from floor \n");
							Stack1.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack1.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack3.isEmpty() == false && Stack3.doesPackageStackContain(recipient) == true) {
							for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack3.get(i).getRecipient())))) {
									Package temp = Stack3.get(i);
									floor.pushFloorPackage(temp);
									Stack3.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack3.get(Stack3.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack3.get(Stack3.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 3 from floor \n");
							Stack3.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack3.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack4.isEmpty() == false && Stack4.doesPackageStackContain(recipient) == true) {
							for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack4.get(i).getRecipient())))) {
									Package temp = Stack4.get(i);
									floor.pushFloorPackage(temp);
									Stack4.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack4.get(Stack4.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack4.get(Stack4.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 4 from floor \n");
							Stack4.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack4.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack5.isEmpty() == false && Stack5.doesPackageStackContain(recipient) == true) {
							for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack5.get(i).getRecipient())))) {
									Package temp = Stack5.get(i);
									floor.pushFloorPackage(temp);
									Stack5.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack5.get(Stack5.getTotalPackages()-1).getWeight()
									+ " lb package delivered on day " + Stack5.get(Stack5.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 5 from floor \n");
							Stack5.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack5.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else {
							System.out.println("This person does not exist, try someone else \n");
							break;
						}
					}
					else if(recipient.toUpperCase().compareTo("K") >= 0 && recipient.toUpperCase().compareTo("M") <= 0) {
						if(Stack3.isEmpty() == false && Stack3.doesPackageStackContain(recipient) == true) {
							for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack3.get(i).getRecipient())))) {
									Package temp = Stack3.get(i);
									floor.pushFloorPackage(temp);
									Stack3.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack3.get(Stack3.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack3.get(Stack3.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 3 from floor \n");
							Stack3.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack3.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack2.isEmpty() == false && Stack2.doesPackageStackContain(recipient) == true) {
							for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack2.get(i).getRecipient())))) {
									Package temp = Stack2.get(i);
									floor.pushFloorPackage(temp);
									Stack2.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack2.get(Stack2.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack2.get(Stack2.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 2 from floor \n");
							Stack2.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack2.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack4.isEmpty() == false && Stack4.doesPackageStackContain(recipient) == true) {
							for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack4.get(i).getRecipient())))) {
									Package temp = Stack4.get(i);
									floor.pushFloorPackage(temp);
									Stack4.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack4.get(Stack4.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack4.get(Stack4.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 4 from floor \n");
							Stack4.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack4.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack1.isEmpty() == false && Stack1.doesPackageStackContain(recipient) == true) {
							for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack1.get(i).getRecipient())))) {
									Package temp = Stack1.get(i);
									floor.pushFloorPackage(temp);
									Stack1.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack1.get(Stack1.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack1.get(Stack1.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 1 from floor \n");
							Stack1.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack1.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack5.isEmpty() == false && Stack5.doesPackageStackContain(recipient) == true) {
							for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack5.get(i).getRecipient())))) {
									Package temp = Stack5.get(i);
									floor.pushFloorPackage(temp);
									Stack5.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack5.get(Stack5.getTotalPackages()-1).getWeight()
									+ " lb package delivered on day " + Stack5.get(Stack5.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 5 from floor \n");
							Stack5.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack5.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else {
							System.out.println("This person does not exist, try someone else \n");
							break;
						}
					}
					else if(recipient.toUpperCase().compareTo("N") >= 0 && recipient.toUpperCase().compareTo("R") <= 0) {
						if(Stack4.isEmpty() == false && Stack4.doesPackageStackContain(recipient) == true) {
							for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack4.get(i).getRecipient())))) {
									Package temp = Stack4.get(i);
									floor.pushFloorPackage(temp);
									Stack4.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack4.get(Stack4.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack4.get(Stack4.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 4 from floor \n");
							Stack4.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack4.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack3.isEmpty() == false && Stack3.doesPackageStackContain(recipient) == true) {
							for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack3.get(i).getRecipient())))) {
									Package temp = Stack3.get(i);
									floor.pushFloorPackage(temp);
									Stack3.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack3.get(Stack3.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack3.get(Stack3.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 3 from floor \n");
							Stack3.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack3.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack5.isEmpty() == false && Stack5.doesPackageStackContain(recipient) == true) {
							for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack5.get(i).getRecipient())))) {
									Package temp = Stack5.get(i);
									floor.pushFloorPackage(temp);
									Stack5.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack5.get(Stack5.getTotalPackages()-1).getWeight()
									+ " lb package delivered on day " + Stack5.get(Stack5.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 5 from floor \n");
							Stack5.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack5.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack2.isEmpty() == false && Stack2.doesPackageStackContain(recipient) == true) {
							for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack2.get(i).getRecipient())))) {
									Package temp = Stack2.get(i);
									floor.pushFloorPackage(temp);
									Stack2.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack2.get(Stack2.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack2.get(Stack2.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 2 from floor \n");
							Stack2.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack2.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack1.isEmpty() == false && Stack1.doesPackageStackContain(recipient) == true) {
							for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack1.get(i).getRecipient())))) {
									Package temp = Stack1.get(i);
									floor.pushFloorPackage(temp);
									Stack1.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack1.get(Stack1.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack1.get(Stack1.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 1 from floor \n");
							Stack1.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack1.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else {
							System.out.println("This person does not exist, try someone else \n");
							break;
						}
					}
					else if(recipient.toUpperCase().compareTo("S") >= 0 && recipient.toUpperCase().compareTo("Z") <= 0) {
						if(Stack5.isEmpty() == false && Stack5.doesPackageStackContain(recipient) == true) {
							for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack5.get(i).getRecipient())))) {
									Package temp = Stack5.get(i);
									floor.pushFloorPackage(temp);
									Stack5.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack5.get(Stack5.getTotalPackages()-1).getWeight()
									+ " lb package delivered on day " + Stack5.get(Stack5.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 5 from floor \n");
							Stack5.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack5.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack4.isEmpty() == false && Stack4.doesPackageStackContain(recipient) == true) {
							for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack4.get(i).getRecipient())))) {
									Package temp = Stack4.get(i);
									floor.pushFloorPackage(temp);
									Stack4.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack4.get(Stack4.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack4.get(Stack4.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 4 from floor \n");
							Stack4.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack4.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack3.isEmpty() == false && Stack3.doesPackageStackContain(recipient) == true) {
							for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack3.get(i).getRecipient())))) {
									Package temp = Stack3.get(i);
									floor.pushFloorPackage(temp);
									Stack3.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack3.get(Stack3.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack3.get(Stack3.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 3 from floor \n");
							Stack3.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack3.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack2.isEmpty() == false && Stack2.doesPackageStackContain(recipient) == true) {
							for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack2.get(i).getRecipient())))) {
									Package temp = Stack2.get(i);
									floor.pushFloorPackage(temp);
									Stack2.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack2.get(Stack2.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack2.get(Stack2.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 2 from floor \n");
							Stack2.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack2.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else if(Stack1.isEmpty() == false && Stack1.doesPackageStackContain(recipient) == true) {
							for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
								if(!(recipient.equalsIgnoreCase((Stack1.get(i).getRecipient())))) {
									Package temp = Stack1.get(i);
									floor.pushFloorPackage(temp);
									Stack1.popPackage();
									count++;
								}
								else {
									break;
								}
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
							System.out.println("Give " + recipient + " " + Stack1.get(Stack1.getTotalPackages()-1).getWeight()
							+ " lb package delivered on day " + Stack1.get(Stack1.getTotalPackages()-1).getArrivalDate() + "\n");
							System.out.println("Return " + count + " packages to Stack 1 from floor \n");
							Stack1.popPackage();
							for(int i = floor.getTotalPackages()-1; i >= floorCounter; i--) {
								Package temp = floor.get(i);
								Stack1.pushPackage(temp);
								floor.popPackage();
							}
							printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
						}
						else {
							System.out.println("This person does not exist, try someone else \n");
							break;
						}
					}
				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "T":
				try {
					/**
					 * Switches the day time to the next day
					 */
					dayTime++;
					System.out.println("It is now day " + dayTime + "\n");
				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "P":
				try {
					/**
					 * Prints all the stacks in a proper format
					 */
					printAllStacks(Stack1,Stack2,Stack3,Stack4,Stack5,floor);
				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "M":
				try {
					/**
					 * Asks the user for the source stack and the destination stack. If both
					 * are valid then proceed to moving the package accordingly. First, check
					 * the source stack to see if it is empty. Next, check the destination stack
					 * to see if it is full. If both are false then proceed to moving the 
					 * package accordingly. Otherwise, prints a message to prompt user to try again
					 */
					System.out.println("Please enter the source stack (enter 0 for floor): ");
					firstFloor = input.nextInt();
					if(firstFloor < 0 || firstFloor > 5) {
						System.out.println("The input floor number is invalid, try again \n");
						break;
					}
					System.out.println("Please enter the destination stack: ");
					secondFloor = input.nextInt();
					if(secondFloor < 0 || secondFloor > 5 || firstFloor == secondFloor) {
						System.out.println("The input floor number is invalid, try again ");
						break;
					}
					else {
						if(Stack1.isEmpty() == true && Stack2.isEmpty() == true && Stack3.isEmpty() == true && Stack4.isEmpty() == true && Stack5.isEmpty() == true) {
							System.out.println("All stacks are empty, moving cannot be done \n");
							break;
						}
						else if(firstFloor == 1 && Stack1.isEmpty() == false) {
							if(secondFloor == 2 && Stack2.isFull() == false) {
								Package temp = Stack1.peek();
								Stack2.pushPackage(temp);
								Stack1.popPackage();
							}
							else if(secondFloor == 3 && Stack3.isFull() == false) {
								Package temp = Stack1.peek();
								Stack3.pushPackage(temp);
								Stack1.popPackage();
							}
							else if(secondFloor == 4 && Stack4.isFull() == false) {
								Package temp = Stack1.peek();
								Stack4.pushPackage(temp);
								Stack1.popPackage();
							}
							else if(secondFloor == 5 && Stack5.isFull() == false) {
								Package temp = Stack1.peek();
								Stack5.pushPackage(temp);
								Stack1.popPackage();
							}
							else if(secondFloor == 0) {
								Package temp = Stack1.peek();
								floor.pushPackage(temp);
								Stack1.popPackage();
							}
							else {
								System.out.println("Cannot move a package from one stack to\n"
										+ "another because either all stacks are full\nor the"
										+ " source stack is empty");
								break;
							}
							
						}
						else if(firstFloor == 2 && Stack2.isEmpty() == false) {
							if(secondFloor == 1 && Stack1.isFull() == false) {
								Package temp = Stack2.peek();
								Stack1.pushPackage(temp);
								Stack2.popPackage();
							}
							else if(secondFloor == 3 && Stack3.isFull() == false) {
								Package temp = Stack2.peek();
								Stack3.pushPackage(temp);
								Stack2.popPackage();
							}
							else if(secondFloor == 4 && Stack4.isFull() == false) {
								Package temp = Stack2.peek();
								Stack4.pushPackage(temp);
								Stack2.popPackage();
							}
							else if(secondFloor == 5 && Stack5.isFull() == false) {
								Package temp = Stack2.peek();
								Stack5.pushPackage(temp);
								Stack2.popPackage();
							}
							else if(secondFloor == 0) {
								Package temp = Stack2.peek();
								floor.pushPackage(temp);
								Stack2.popPackage();
							}
							else {
								System.out.println("Cannot move a package from one stack to\n"
										+ "another because either all stacks are full\nor the"
										+ " source stack is empty");
								break;
							}
							
						}
						else if(firstFloor == 3 && Stack3.isEmpty() == false) {
							if(secondFloor == 2 && Stack2.isFull() == false) {
								Package temp = Stack3.peek();
								Stack2.pushPackage(temp);
								Stack3.popPackage();
							}
							else if(secondFloor == 4 && Stack4.isFull() == false) {
								Package temp = Stack3.peek();
								Stack4.pushPackage(temp);
								Stack3.popPackage();
							}
							else if(secondFloor == 1 && Stack1.isFull() == false) {
								Package temp = Stack3.peek();
								Stack1.pushPackage(temp);
								Stack3.popPackage();
							}
							else if(secondFloor == 5 && Stack5.isFull() == false) {
								Package temp = Stack3.peek();
								Stack5.pushPackage(temp);
								Stack3.popPackage();
							}
							else if(secondFloor == 0) {
								Package temp = Stack3.peek();
								floor.pushPackage(temp);
								Stack3.popPackage();
							}
							else {
								System.out.println("Cannot move a package from one stack to\n"
										+ "another because either all stacks are full\nor the"
										+ " source stack is empty");
								break;
							}
							
						}
						else if(firstFloor == 4 && Stack4.isEmpty() == false) {
							if(secondFloor == 3 && Stack3.isFull() == false) {
								Package temp = Stack4.peek();
								Stack3.pushPackage(temp);
								Stack4.popPackage();
							}
							else if(secondFloor == 5 && Stack5.isFull() == false) {
								Package temp = Stack4.peek();
								Stack5.pushPackage(temp);
								Stack4.popPackage();
							}
							else if(secondFloor == 2 && Stack2.isFull() == false) {
								Package temp = Stack4.peek();
								Stack2.pushPackage(temp);
								Stack4.popPackage();
							}
							else if(secondFloor == 1 && Stack1.isFull() == false) {
								Package temp = Stack4.peek();
								Stack1.pushPackage(temp);
								Stack4.popPackage();
							}
							else if(secondFloor == 0) {
								Package temp = Stack4.peek();
								floor.pushPackage(temp);
								Stack4.popPackage();
							}
							else {
								System.out.println("Cannot move a package from one stack to\n"
										+ "another because either all stacks are full\nor the"
										+ " source stack is empty");
								break;
							}
							
						}
						else if(firstFloor == 5 && Stack5.isEmpty() == false) {
							if(secondFloor == 4 && Stack4.isFull() == false) {
								Package temp = Stack5.peek();
								Stack4.pushPackage(temp);
								Stack5.popPackage();
							}
							else if(secondFloor == 3 && Stack3.isFull() == false) {
								Package temp = Stack5.peek();
								Stack3.pushPackage(temp);
								Stack5.popPackage();
							}
							else if(secondFloor == 2 && Stack2.isFull() == false) {
								Package temp = Stack5.peek();
								Stack2.pushPackage(temp);
								Stack5.popPackage();
							}
							else if(secondFloor == 1 && Stack1.isFull() == false) {
								Package temp = Stack5.peek();
								Stack1.pushPackage(temp);
								Stack5.popPackage();
							}
							else if(secondFloor == 0) {
								Package temp = Stack5.peek();
								floor.pushPackage(temp);
								Stack5.popPackage();
							}
							else {
								System.out.println("Cannot move a package from one stack to\n"
										+ "another because either all stacks are full\nor the"
										+ " source stack is empty");
								break;
							}
						}
						else {
							System.out.println("All stacks are full or stack is empty. Moving cannot be done \n");
							break;
						}
					}
				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "F":
				try {
					PackageStack tempStack1 = new PackageStack(); // Temporary stack for stack1
					PackageStack tempStack2 = new PackageStack(); // Temporary stack for stack2
					PackageStack tempStack3 = new PackageStack(); // Temporary stack for stack3
					PackageStack tempStack4 = new PackageStack(); // Temporary stack for stack4
					PackageStack tempStack5 = new PackageStack(); // Temporary stack for stack5
					
					/**
					 * If all stacks are empty then prints a message telling the user
					 * that moving cannot be done
					 */
					if(Stack1.isEmpty() == true && Stack2.isEmpty() == true && Stack3.isEmpty() == true && Stack4.isEmpty() == true && Stack5.isEmpty() == true) {
						System.out.println("All stacks are empty, moving cannot be done \n");
						break;
					}
					
					/**
					 * Checks all the stacks to see if there is an incorrect package in a
					 * given stack. If the stack does contain an incorrect package, then moves
					 * it to the floor
					 */
					for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
						if(!(Stack1.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("A") >= 0 && Stack1.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("G") <= 0)) {
							Package temp = Stack1.get(i);
							floor.pushFloorPackage(temp);
							Stack1.popPackage();
						}
						else {
							Package temp = Stack1.get(i);
							tempStack1.pushPackage(temp);
							Stack1.popPackage();
						}
					}
					for(int i =  tempStack1.getTotalPackages()-1; i >= 0; i--) {
						Package temp = tempStack1.get(i);
						Stack1.pushPackage(temp);
					}
					
					for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
						if(!(Stack2.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("H") >= 0 && Stack2.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("J") <= 0)) {
							Package temp = Stack2.get(i);
							floor.pushFloorPackage(temp);
							Stack2.popPackage();
						}
						else {
							Package temp = Stack2.get(i);
							tempStack2.pushPackage(temp);
							Stack2.popPackage();
						}
					}
					for(int i =  tempStack2.getTotalPackages()-1; i >= 0; i--) {
						Package temp = tempStack2.get(i);
						Stack2.pushPackage(temp);
					}
					
					for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
						if(!(Stack3.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("K") >= 0 && Stack3.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("M") <= 0)) {
							Package temp = Stack3.get(i);
							floor.pushFloorPackage(temp);
							Stack3.popPackage();
						}
						else {
							Package temp = Stack3.get(i);
							tempStack3.pushPackage(temp);
							Stack3.popPackage();
						}
					}
					for(int i =  tempStack3.getTotalPackages()-1; i >= 0; i--) {
						Package temp = tempStack3.get(i);
						Stack3.pushPackage(temp);
					}
					
					for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
						if(!(Stack4.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("N") >= 0 && Stack4.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("R") <= 0)) {
							Package temp = Stack4.get(i);
							floor.pushFloorPackage(temp);
							Stack4.popPackage();
						}
						else {
							Package temp = Stack4.get(i);
							tempStack4.pushPackage(temp);
							Stack4.popPackage();
						}
					}
					for(int i =  tempStack4.getTotalPackages()-1; i >= 0; i--) {
						Package temp = tempStack4.get(i);
						Stack4.pushPackage(temp);
					}
					
					for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
						if(!(Stack5.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("N") >= 0 && Stack5.get(i).getRecipient().toUpperCase().substring(0,1).compareTo("R") <= 0)) {
							Package temp = Stack5.get(i);
							floor.pushFloorPackage(temp);
							Stack5.popPackage();
						}
						else {
							Package temp = Stack5.get(i);
							tempStack5.pushPackage(temp);
							Stack5.popPackage();
						}
					}
					for(int i =  tempStack5.getTotalPackages()-1; i >= 0; i--) {
						Package temp = tempStack5.get(i);
						Stack5.pushPackage(temp);
					}
					
					System.out.println("Misplaced packages moved to floor \n");

				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "L":
				try {
					int totalCount = 0;
					int dayCounter = 0;
					int initialCounter = 0;
					int packageCount = 0;
					/**
					 * Asks the user for the recipient name. If the name is valid then proceeds
					 * to add that name onto the list of packages awaiting that recipient, with
					 * information about the packages. Otherwise, tells the user that the name
					 * isn't valid.
					 */
					System.out.println("Please enter the recipient name: ");
					recipient = input.nextLine();
					for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
						if(recipient.equalsIgnoreCase(Stack1.get(i).getRecipient())) {
							if(Stack1.get(i).getArrivalDate() > dayCounter) {
								dayCounter = Stack1.get(i).getArrivalDate();
							}
							totalCount++;
						}
					}
					for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
						if(recipient.equalsIgnoreCase(Stack2.get(i).getRecipient())) {
							if(Stack2.get(i).getArrivalDate() > dayCounter) {
								dayCounter = Stack2.get(i).getArrivalDate();
							}
							totalCount++;
						}
					}
					for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
						if(recipient.equalsIgnoreCase(Stack3.get(i).getRecipient())) {
							if(Stack3.get(i).getArrivalDate() > dayCounter) {
								dayCounter = Stack3.get(i).getArrivalDate();
							}
							totalCount++;
						}
					}
					for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
						if(recipient.equalsIgnoreCase(Stack4.get(i).getRecipient())) {
							if(Stack4.get(i).getArrivalDate() > dayCounter) {
								dayCounter = Stack4.get(i).getArrivalDate();
							}
							totalCount++;
						}
					}
					for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
						if(recipient.equalsIgnoreCase(Stack5.get(i).getRecipient())) {
							if(Stack5.get(i).getArrivalDate() > dayCounter) {
								dayCounter = Stack5.get(i).getArrivalDate();
							}
							totalCount++;
						}
					}
					if(totalCount == 0) {
						System.out.println("There is no package with name " + recipient + ", try again \n");
						break;
					}
					System.out.println(recipient + " has " + totalCount + " packages in total");
					while(initialCounter <= dayCounter) {
						for(int i = Stack1.getTotalPackages()-1; i >= 0; i--) {
							if(recipient.equalsIgnoreCase(Stack1.get(i).getRecipient()) && Stack1.get(i).getArrivalDate() == initialCounter) {
								packageCount++;
								System.out.println("Package " + packageCount + " is in Stack 1, it was delivered on day "
										+ initialCounter + ", and weights " + Stack1.get(i).getWeight() + "lbs");
							}
						}
						for(int i = Stack2.getTotalPackages()-1; i >= 0; i--) {
							if(recipient.equalsIgnoreCase(Stack2.get(i).getRecipient()) && Stack2.get(i).getArrivalDate() == initialCounter) {
								packageCount++;
								System.out.println("Package " + packageCount + " is in Stack 2, it was delivered on day "
										+ initialCounter + ", and weights " + Stack2.get(i).getWeight() + "lbs");
							}
						}
						for(int i = Stack3.getTotalPackages()-1; i >= 0; i--) {
							if(recipient.equalsIgnoreCase(Stack3.get(i).getRecipient()) && Stack3.get(i).getArrivalDate() == initialCounter) {
								packageCount++;
								System.out.println("Package " + packageCount + " is in Stack 3, it was delivered on day "
										+ initialCounter + ", and weights " + Stack3.get(i).getWeight() + "lbs");
							}
						}
						for(int i = Stack4.getTotalPackages()-1; i >= 0; i--) {
							if(recipient.equalsIgnoreCase(Stack4.get(i).getRecipient()) && Stack4.get(i).getArrivalDate() == initialCounter) {
								packageCount++;
								System.out.println("Package " + packageCount + " is in Stack 4, it was delivered on day "
										+ initialCounter + ", and weights " + Stack4.get(i).getWeight() + "lbs");
							}
						}
						for(int i = Stack5.getTotalPackages()-1; i >= 0; i--) {
							if(recipient.equalsIgnoreCase(Stack5.get(i).getRecipient()) && Stack5.get(i).getArrivalDate() == initialCounter) {
								packageCount++;
								System.out.println("Package " + packageCount + " is in Stack 5, it was delivered on day "
										+ initialCounter + ", and weights " + Stack5.get(i).getWeight() + "lbs");
							}
						}
						initialCounter++;
					}
					System.out.println("");
				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "E":
				try {
					/**
					 * If the floor is empty then prints a message for the user, otherwise
					 * print gets rid of all the packages on the floor
					 */
					if(floor.isEmpty() == true) {
						System.out.println("There is nothing in the floor to empty \n");
						break;
					}
					else {
						for(int i = floor.getTotalPackages()-1; i >= 0; i--) {
							floor.popPackage();
						}
						System.out.println("The floor has been emptied. Mr. Trash Can is no longer hungry \n");
					}
				}
				/**
				 * Catches any possible errors and returns a message about the error
				 */
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case "Q":
				/**
				 * Message printed after quitting the program
				 */
				System.out.println("Use Amazon Locker next time. \n");
			default:
				/**
				 * Prints a message if there is an error that the above cases didn't catch
				 */
				input.nextLine();
				System.out.println("Some error had occured or this letter was not an option."
						+ "\nPlease try again.\n");
				break;
			}
		}
	}
	
	/**
	 * This method prints out all the stacks in a proper format
	 * 
	 * @param a
	 * Represents Stack1
	 * @param b
	 * Represents Stack2
	 * @param c
	 * Represents Stack3
	 * @param d
	 * Represents Stack4
	 * @param e
	 * Represents Stack5
	 * @param f
	 * Represents the floor
	 */
	public static void printAllStacks(PackageStack a,PackageStack b,PackageStack c,PackageStack d, PackageStack e, PackageStack f) {
		System.out.println("Current Packages: ");
		System.out.println("--------------------------------");
		System.out.print("Stack 1 (A-G):| ");
		System.out.println(a.packageStackToString());
		System.out.print("Stack 2 (H-J):| ");
		System.out.println(b.packageStackToString());
		System.out.print("Stack 3 (K-M):| ");
		System.out.println(c.packageStackToString());
		System.out.print("Stack 4 (N-R):| ");
		System.out.println(d.packageStackToString());
		System.out.print("Stack 5 (S-Z):| ");
		System.out.println(e.packageStackToString());
		System.out.print("Floor: | ");
		System.out.println(f.packageStackToString());
		System.out.println("");
	}
}
