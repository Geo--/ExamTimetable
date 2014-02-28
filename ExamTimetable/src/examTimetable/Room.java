package examTimetable;
import java.util.*;

public class Room implements Rooms {
private final int capacity;
private Boolean available;
private final RoomType type;
private List<Day> days = new ArrayList<Day>();
private List<Exam> exams = new ArrayList<Exam>();

public Room(int capacity, RoomType type, int examPeriodLength){
	this.capacity = capacity;
	this.type = type;
	available = true;
	for(int i=0; i<examPeriodLength; i++) {
		days.add(new Days());
	}
}

public int getCapacity() {
	return capacity;
}

public Boolean isAvailable(){
	return available;
}

public void book(){
	available = false;
}

public RoomType getType() {
	return type;
}

public int timeAvailable(Day day){
	return day.getFreeTime();
}

public List<Day> availableDays() {
	List<Day> availableDays = new ArrayList<Day>();
	for(Day d: days){
		if(d.containsFreeSpace()) {
			availableDays.add(d);
		}
	}
	return availableDays;
}

public void bookRoom(Exam exam) {
	exams.add(exam);
	exam.book();
}

public Boolean isAvailable(int length, Day day){
	if(day.containsFreeSpace()) {
		Iterator<Hours> freeHours = day.getAvailableHours().iterator();
		for(int i=0; i < length ; i++) {
		Hours h = freeHours.next();
		if(length == day.getFirstAvailableTime() - h.getStartTime(h))
		{
			return true;
		}
		}
	}
	return false;
}

}
