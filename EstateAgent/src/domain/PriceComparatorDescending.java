/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/
package domain;

import java.util.Comparator;

public class PriceComparatorDescending implements Comparator<House> {
	
	public PriceComparatorDescending(){super();}
	
	@Override
	public int compare(House house1,House house2){
		return house2.getPrice().compareTo(house1.getPrice());
	}
}
