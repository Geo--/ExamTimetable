package newExam;
import java.util.*;

public class Room {
	private String roomNumber;
	private RoomType type;
	private int capacity;
	//each room has it's own array of days
	//to act as a timetable for each room.
	private List<Day> timetable = new ArrayList<Day>();
	
	public Room(String roomNumber, RoomType type, int capacity) {
		this.roomNumber = roomNumber;
		this.type = type;
		this.capacity = capacity;
	}
	
	public void setTimetable(int examDuration, Date startDate) {
		for(int i = 0; i < examDuration; i++) {
			timetable.add(new Day(startDate));
			//increment the date.
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			int day = c.get(Calendar.DATE);
			day++;
			c.set(Calendar.DATE, day);
			startDate = c.getTime();
		}
	}
	
	public List<Day> getTimetable() {
		return timetable;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public RoomType getType() {
		return type;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}

}