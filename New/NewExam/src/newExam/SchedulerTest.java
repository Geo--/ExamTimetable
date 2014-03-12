package newExam;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class SchedulerTest {

	@Test
	public void test() {
		//Create students, and populate them into a List of there studies.
		Student studenta = new Student("Paul Barber", "1000");
		Student studentb = new Student("Chris Cooper", "A1000");
		Student studentc = new Student("Paul, Barber", "B1000");
		//Create a list of students studing each subject.
		List<Student> studiesHistory = new ArrayList<Student> ();
		studiesHistory.add(studenta);
		studiesHistory.add(studentb);
		studiesHistory.add(studentc);
		
		List<Student> studiesSport = new ArrayList<Student>();
		studiesSport.add(studentb);
		
		List<Student> studiesScience = new ArrayList<Student>();
		studiesScience.add(studenta);
		
		List<Student> studiesEnglish = new ArrayList<Student>();
		studiesEnglish.add(studentc);
		studiesEnglish.add(studenta);
		studiesEnglish.add(studentb);
		
		List<Student> studiesMath = new ArrayList<Student>();
		studiesMath.add(studentc);
		
		List<Student> studiesMusic = new ArrayList<Student>();
		studiesMusic.add(studenta);
		studiesMusic.add(studentb);
		studiesMusic.add(studentc);
		
		List<Student> studiesGeo = new ArrayList<Student>();
		studiesGeo.add(studentc);
		
		List<Student> studiesIT = new ArrayList<Student>();
		studiesIT.add(studenta);
		
		
		//Create exams for the modules.
		Exam historyExam = new Exam(3);
		Exam scienceExam = new Exam(3);
		Exam sportExam = new Exam(2);
		Exam englishExam = new Exam(2);
		Exam mathExam = new Exam(2);
		Exam musicExam = new Exam(1);
		Exam geoExam = new Exam(2);
		Exam itExam = new Exam(1);
		
		//Create the modules with the above date.
		Module module = new Module("HIS100", "History", historyExam, studiesHistory);
		Module sport = new Module("SPO109", "Sport", sportExam, studiesSport);
		Module english = new Module("ENG100", "English", englishExam, studiesEnglish);
		Module science = new Module("SCI11", "Science", scienceExam, studiesScience);
		Module math = new Module("MAT666", "Math", mathExam, studiesMath);
		Module music = new Module("MUS111", "Music", musicExam, studiesMusic);
		Module geo = new Module("Geo121", "Geography", geoExam, studiesGeo);
		Module it = new Module("ICT123", "ICT", itExam, studiesIT);
		
		
		List<Module> allModules = new ArrayList<Module>();
		//add all the modules to an allModules list.
		allModules.add(module);
		allModules.add(sport);
		allModules.add(math);
		allModules.add(science);
		allModules.add(english);
		allModules.add(music);
		allModules.add(geo);
		allModules.add(it);
		
		
		Date date = new Date();
		//Create a exam timetable using the date, for 7 days with the modules created above.
		ExamTimetableInfo examScheduler = new ExamTimetableInfo(2, date, allModules);
		//This example only has one room.
		//create a room.
		Room room = new Room("A100", RoomType.COMPUTER_CLUSTER, 50);
		//set the timetable for the room, given the information from the examScheduler.
		room.setTimetable(examScheduler.getExamDuration(), examScheduler.getStartDate());
	
		
		Scheduler schedule = new Scheduler(allModules, room.getTimetable());
			schedule.scheduleExam(allModules.get(0).getExam());
		for(Module modules : allModules) {
			System.out.println(modules + ": " + modules.getExam() + "\n");
		}
		
	}

}