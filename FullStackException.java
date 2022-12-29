	/**
	 * The FullStackException class extends Exception and provides an exception 
	 * when the stack is full
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class FullStackException extends Exception{
	
	/**
	 * This method allows the parent constructor to provide a new error and message with that error
	 * 
	 * @param t
	 * Message that is printed when an error occurs
	 */
	public FullStackException(String t) {
		super(t);
	}
}
