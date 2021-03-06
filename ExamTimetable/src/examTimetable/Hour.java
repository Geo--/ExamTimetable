package examTimetable;

public enum Hour implements Hours {
	A,B,C,D,E,F,G, H;
	private Boolean booked;
	private Exam exam;
 
	private Hour() {
		booked = false;
	}
 
public void setExam(Exam exam) {
	this.exam = exam;
}

public Exam getExam() {
	return exam;
}
	
 public Boolean isBooked() {
	 return booked;
 }
 
 public void unreseve() {
	 booked = false;
 }
 
 public void book() {
	 booked = true;
 }
 
 public int getTime(Hours hour) {
			if(hour instanceof Hour) {
				switch((Hour)hour){
				 case A: return 9;
				 case B: return 10;
				 case C: return 11;
				 case D: return 12;
				 case E: return 13;
				 case F: return 14;
				 case G: return 15;
				 case H: return 16;
				 default: return -1;
		}
	}
		return -1;
	}
}
