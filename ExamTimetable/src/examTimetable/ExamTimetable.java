package examTimetable;

import java.util.*;

public class ExamTimetable {
	private List<Module> modules = new ArrayList<Module>();
	private List<Rooms> rooms = new ArrayList<Rooms>();
	private List<Module> scheduledModules = new ArrayList<Module>();
	private int EXAM_LENGTH;

	public ExamTimetable(int EXAM_LENGTH, List<Module> modules,
			List<Rooms> rooms) {
		this.EXAM_LENGTH = EXAM_LENGTH;
		this.modules = modules;
		this.rooms = rooms;
	}

	/**
	 * get all the modules which have been scheduled.
	 * 
	 * @return List<Module>
	 */
	public List<Module> getScheduledModules() {
		return scheduledModules;
	}

	/**
	 * check to see if all the Exams have been booked.
	 * 
	 * @param List
	 *            <Module> modules
	 * @return Boolean
	 */
	private Boolean allBooked(List<Module> modules) {
		for (Module m : modules)
			if (m.getExam().isBooked()) {
				if (allBooked(modules)) {
					return true;
				}
			}
		return false;
	}

	public Boolean schedule() {
		if (allBooked(modules))
			return true;
		else {
			for (Iterator<Module> modList = modules.iterator(); modList
					.hasNext();) {
				Module m = modList.next();
				Exam e = m.getExam();
				for (Iterator<Rooms> roomList = rooms.iterator(); roomList
						.hasNext();) {
					Rooms r = roomList.next();
					for (Iterator<Day> dayList = r.availableDays(); roomList
							.hasNext();) {
						Day d = dayList.next();
						if (r.isAvailable(e.getDuration(), d)) {
							if (!e.isBooked()) {
								if (e.hasRelatedExam()) {
									Exam rE = e.getRelatedExam();
									if (rE.isBooked()) {
										return false;
									} else {
										if (r.getCapacity() <= m
												.getStudentsEnrolled().size()) {
											if (r.getType() == e.getRoomType()) {
												int studentSize = 0;
												for (Iterator<Student> studentList = m
														.getStudentsEnrolled()
														.iterator(); studentList
														.hasNext();) {
													Student s = studentList
															.next();
													if (!s.hasExam(
															d.getFirstHour(), d)) {
														studentSize++;
													}
													if (studentSize == m
															.getStudentsEnrolled()
															.size()) {
														e.setExam(r,
																e.getDuration());
														r.bookRoom(e, d);
														modList.remove();
														scheduledModules.add(m);
														if (schedule()) {
															return true;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
