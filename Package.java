	/**
	 * The Package class represents a package with a recipient, arrival date and weight
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class Package {
	
	private String recipient; // The name of the recipient
	private int arrivalDate = 0; // The arrival date of the package
	private double weight; // The weight of the package
	
	/**
	 * This is the constructor for the Package
	 * 
	 * @param recipient
	 * Name of the recipient
	 * @param arrivalDate
	 * Time of the arrival date
	 * @param weight
	 * Weight of the package
	 */
	public Package(String recipient, int arrivalDate, double weight) {
		this.recipient = recipient;
		this.arrivalDate = arrivalDate;
		this.weight = weight;
	}
	
	/**
	 * This method sets a new name to the recipient
	 * 
	 * @param r
	 * The new name of the recipient
	 */
	public void setRecipient(String r) {
		recipient = r;
	}
	
	/**
	 * This method gets the name of the recipient
	 * 
	 * @return
	 * Returns the name of the recipient
	 */
	public String getRecipient() {
		return recipient;
	}
	
	/**
	 * This method sets a new arrival date
	 * 
	 * @param a
	 * The new arrival date to be set to
	 */
	public void setArrivalDate(int a) {
		arrivalDate = a;
	}
	
	/**
	 * This method gets the arrival date
	 * 
	 * @return
	 * Returns the arrival date
	 */
	public int getArrivalDate() {
		return arrivalDate;
	}
	
	/**
	 * This method sets the package to a new weight
	 * 
	 * @param w
	 * The new weight to be set to
	 */
	public void setWeight(double w) {
		weight = w;
	}
	
	/**
	 * This method returns the weight of the package
	 * 
	 * @return
	 * Returns the weight of the package
	 */
	public double getWeight() {
		return weight;
	}
	
}
