/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/
package domain;

import java.util.Comparator;

public class PriceComparatorAscending implements Comparator<House>{
	
	public PriceComparatorAscending(){super();}
	
	
	@Override
	public int compare(House house1,House house2){
		return house1.getPrice().compareTo(house2.getPrice());
	}

}
