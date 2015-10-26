package array.utils;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class ArrayFlattener {

	/**
	 * Class to flatten an array of arbitrarily nested arrays of 
	 * integers into a flat array of integers
	 * 
	 * @param  list the list to be sorted.
	 * @throws ClassCastException if the list contains elements that are not
	 *         <i>mutually comparable</i> (for example, strings and integers).
	 * @throws UnsupportedOperationException if the specified list's
	 *         list-iterator does not support the {@code set} operation.
	 * @throws IllegalArgumentException (optional) if the implementation
	 *         detects that the natural ordering of the list elements is
	 *         found to violate the {@link Comparable} contract
	 */
	public static void main(String[] args) {
		//create random object
		Object[] random = new Object[]{ 10, 2, new Object[]{ 32, 3, 5}, 2, 9};

		ArrayFlattener af = new ArrayFlattener();
		LinkedList<Object> flattened = af.flat(random);

		Object[] finalArray = flattened.toArray();

		//print
		for(Object obj: finalArray){
			System.out.println(obj.toString());
		}
	}

	/**
	 * Recursively tries to flatten and array. Checks if any of the objects is an array to decide wheter to call itself or add a value to the results list.
	 * integers into a flat array of integers
	 * 
	 * @param  list the LinkedList to be flattened.
	 * @returns LinkedList<Object> Flattened LinkedList with only objects, not objects[]
	 */
	public LinkedList<Object> flat(Object[] array){
		if (array == null){ 
			return null;
		}

		LinkedList<Object> results= new LinkedList<Object>();

		for(int i=0; i<array.length; i++){
			if(array[i] instanceof Object[]){
				results.addAll(flat((Object[]) array[i]));
			}else{
				results.add(array[i]);
			}
			//results.addAll(flat(array[i]));	
			//no need to use instance of, let java sort if out when picking which flat() to use
			//overloading not working for object and object[]
			//understand why someday
		}
		return results;
	}

	//	public LinkedList<Object> flat(Object value){
	//		LinkedList<Object> a = new LinkedList<Object>();
	//		a.add(value);
	//		return a;
	//	}



}
