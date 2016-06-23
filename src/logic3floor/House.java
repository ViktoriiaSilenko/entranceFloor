package logic3floor;

import java.util.HashMap;
import java.util.Map;

public class House {
	
	private final int FLOOR_NUMBER = 9; // кол-во этажей
	private final int FLATS_ON_FLOOR = 4; // квартир на этаже
	
	private int flatNumber;

	public House(int flatNumber) {
		this.flatNumber = flatNumber;
	}


	public Map<String, Integer> findFloorAndEntrance () {
		Map <String, Integer> map = new HashMap<String, Integer>();
		int entrance = 0; // подъезд
		
		
		/*int sum = 0;
		while (flatNumber > sum) {
			entrance++;
			sum += FLOOR_NUMBER*FLATS_ON_FLOOR;
		}*/
		int temp = flatNumber / (FLOOR_NUMBER*FLATS_ON_FLOOR);
		if(flatNumber % (FLOOR_NUMBER*FLATS_ON_FLOOR) == 0) {
			entrance = temp;
		} else {
			entrance = ++temp;
		}
		
		map.put("entrance", entrance);
		
		if (flatNumber % FLOOR_NUMBER == 0) {
			map.put("floor", 9);
		} else {
			map.put("floor", (flatNumber%(FLATS_ON_FLOOR*FLOOR_NUMBER)+9)%9);
		}
		
		return map;
		
		
	}
	
	@Override
	public String toString() {
		return "flatNumber: " + flatNumber + " , entrance: " + findFloorAndEntrance().get("entrance") + " , floor: " + findFloorAndEntrance().get("floor");
	};

	public static void main(String[] args) {
		
		System.out.println(new House(36));
		System.out.println(new House(37));
		
		System.out.println(new House(3));
		
		System.out.println(new House(72));
		System.out.println(new House(75));

	}

}
