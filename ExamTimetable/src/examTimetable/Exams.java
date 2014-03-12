package examTimetable;
import java.util.*;

public class Exams implements Exam {
	private int duration;
	private Boolean booked;
	private RoomType type;
	private Rooms room;
	private Exam relatedExam;
	private Day day;
	private List<Hours> time;
	
	public Exams(int duration, RoomType type) {
		this.duration = duration;
		booked = false;
		this.type = type;
	}
	
	public void setDay(Day day) {
		this.day = day;
	}
	

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public Boolean isBooked() {
		return booked;
	}

	@Override
	public void book() {
		booked = true;
	}

	@Override
	public RoomType getRoomType() {
		return type;
	}

	@Override
	public void setExam(Rooms room) {
		this.room = room;
		this.book();
	}

	@Override
	public void removeBooking() {
		booked = false;
	}

	@Override
	public Boolean hasRelatedExam() {
		return (relatedExam != null) ? true : false;
	}

	@Override
	public Exam getRelatedExam() {
		return relatedExam;
	}
	
	public String toString() {
		String r =  "" + duration + " " + room;
				/*if(!time.isEmpty()) {
				r += time.get(0) + " " + time.get(time.size() -1);
				}*/
		return r;
	}
	
	public List<Hours> examTime() {
		List<Hours> hour= new ArrayList<Hours>();
		for(Hours h : day.getAllHours()) {
			if(h.getExam() == this) {
				hour.add(h);
			}
		}
		return hour;
	}

}