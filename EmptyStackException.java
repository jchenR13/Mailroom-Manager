/**
	 * The EmptyStackException class extends Exception and provides an exception 
	 * when the stack is empty
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class EmptyStackException extends Exception {
	/**
	 * This method allows the parent constructor to provide a new error and message with that error
	 * 
	 * @param t
	 * Message that is printed when an error occurs
	 */
	public EmptyStackException (String t) {
		super(t);
	}

}
