package newExam;
import java.util.*;

public class ExamTimetableInfo {
	private int examDuration;
	private Date startDate;
	private List<Module> module;
	
	public ExamTimetableInfo(int examDuration, Date startDate, List<Module> module) {
		this.examDuration = examDuration;
		this.startDate = startDate;
		this.module = module;
	}
	
	public int getExamDuration() {
		return examDuration;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public List<Module> getModules() {
		return module;
	}

}