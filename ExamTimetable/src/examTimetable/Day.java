package examTimetable;
import java.util.*;

public interface Day {
public int getFreeTime();
public int getFirstAvailableTime();
public List<Hours> getAvailableHours();
public Hours getFirstHour();
public List<Hours> getAllHours();
public Boolean containsFreeSpace();
public void setHourBooked(Hours hour);
public Boolean hourCheck(Hours hour);
}
