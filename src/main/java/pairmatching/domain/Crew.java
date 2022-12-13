package pairmatching.domain;

public class Crew {

    private Course course;
    private String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean isSameCourse(Course course) {
        return this.course.equals(course);
    }

    public String getName() {
        return name;
    }
}