package steams.challenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {

    private static long lastStudentId = 1;
    private final static Random random = new Random();
    private final long studentId;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String geneder;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled, int ageEnrolled, String geneder, boolean programmingExperience, Course... courses) {
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.geneder = geneder;
        this.programmingExperience = programmingExperience;
        this.studentId = lastStudentId++;
        
        for (Course course: courses){
            addCourse(course, LocalDate.of(yearEnrolled, 1, 1));
        }
    }

    public void addCourse(Course course){
        addCourse(course, LocalDate.now());
    }
    public void addCourse(Course course, LocalDate date) {
        engagementMap.put(course.courseCode(),
                new CourseEngagement(course, date, "Enrollment"));
    }

    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGeneder() {
        return geneder;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagementMap() {
        return Map.copyOf(engagementMap);
    }

    public int getYearsSinceEnrolled(){
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge(){
        return ageEnrolled + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String courseCode){
        CourseEngagement info = engagementMap.get(courseCode);
        return  info == null ? 0 : info.getMonthsSinceActive();
    }

    public int getMonthsSinceActive(){
        int inactiveMonths = (LocalDate.now().getYear() - 2014) * 12;
        for(String key: engagementMap.keySet()){
            inactiveMonths = Math.min(inactiveMonths, getMonthsSinceActive(key));
        }
        return inactiveMonths;
    }

//    public double getPercentComplete(String countryCode){
//        var info = engagementMap.get(countryCode);
//        return  info == null ? 0 : info.getPercentcomplete();
//    }
    
}
