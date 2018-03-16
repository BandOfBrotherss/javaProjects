/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/
package domain;

import java.util.Comparator;

public class IdComparator implements Comparator<House> {
	
	public IdComparator(){
		
		super();
	}


	
	@Override
	public int compare(House house1,House house2){
		return Integer.valueOf(house1.getID()).compareTo(Integer.valueOf(house2.getID()));
	}
}
