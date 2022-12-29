/**
	 * The PackageStack class represents an organized stack for one of the 6 choice: A-G, H-J, K-M, N-R, S-Z, and floor
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.ArrayList;

public class PackageStack {

	private ArrayList<Package> packageList = new ArrayList<Package>(); // Package Stack for each package to be inserted to accordingly
	private final int CAPACITY = 7; // Max capacity of a stack
	int totalPackages = 0; // Total packages
	
	/**
	 * This method pushes the package onto the top of the backing data structure.
	 * 
	 * @param x
	 * Package to be inserted into the stack
	 * @throws FullStackException
	 * Gives an error if the stack is at capacity
	 */
	public void pushPackage(Package x) throws FullStackException {
		if(totalPackages == CAPACITY) {
			throw new FullStackException("This stack is at capacity, push cannot be done");
		}
		else {
			packageList.add(x);
			totalPackages++;
		}
	}
	
	/**
	 * This method pushes the package onto the top of the backing data structure
	 * for the floor specifically 
	 * 
	 * @param x
	 * Package to be inserted into the floor
	 */
	public void pushFloorPackage(Package x) {
		packageList.add(x);
		totalPackages++;
	}
	
	/**
	 * This method gets the data of the package in a stack
	 * 
	 * @param i
	 * Position at which the package is located in the stack
	 * @return
	 * Returns the data of the package in a stack
	 */
	public Package get(int i) {
		return packageList.get(i);
	}
	
	/**
	 * This method gets the total number of packages in a stack
	 * 
	 * @return
	 * Returns the total number of packages in a stack
	 */
	public int getTotalPackages() {
		return totalPackages;
	}
	
	/**
	 * This method removes the topmost package from the stack and returns it
	 * 
	 * @return
	 * Returns the removed stack
	 * @throws EmptyStackException
	 * Gives an error if the stack is empty
	 */
	public Package popPackage() throws EmptyStackException {
		if(totalPackages == 0) {
			throw new EmptyStackException("The stack is empty, pop cannot be done");
		}
		else {
			Package temp = packageList.get(totalPackages-1);
			packageList.remove(totalPackages-1);
			totalPackages--;
			return temp;
		}
	}
	
	/**
	 * This method gets the topmost package from the stack
	 * 
	 * @return
	 * Returns the topmost package from the stack
	 * @throws EmptyStackException
	 * Give an error if the stack is empty
	 */
	public Package peek() throws EmptyStackException {
		if(totalPackages == 0) {
			throw new EmptyStackException("The stack is empty, pop cannot be done");
		}
		else {
			return packageList.get(totalPackages-1);
		}
	}
	
	/**
	 * This method checks if a stack is full
	 * 
	 * @return
	 * Returns true if the stack is full, false otherwise
	 */
	public boolean isFull() {
		if(totalPackages == 7) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if the stack is empty
	 * 
	 * @return
	 * Returns true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		if(totalPackages == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if a stack contains a recipient
	 * 
	 * @param recipient
	 * Name of the person being checked for
	 * @return
	 * Returns true if the stack contains the recipient, false otherwise
	 */
	public boolean doesPackageStackContain(String recipient) {
		for(int i = totalPackages-1; i >= 0; i--) {
			if(this.get(i).getRecipient().equalsIgnoreCase(recipient)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * This method prints out a string representation of a stack
	 * 
	 * @return
	 * Returns a string representation of a stack
	 */
	public String packageStackToString() {
		if(this.isEmpty() == true) {
			System.out.print("[ EMTPTY ]");
		}
		else {
			for(int i = 0; i < totalPackages; i++) {
				System.out.print("[" + this.get(i).getRecipient() + "  " + this.get(i).getArrivalDate() + "] ");
			}
		}
		return "";
		
	}
}
