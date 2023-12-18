package com.csit321WW.WikangWali.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblcourse")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "coursedescription")
    private String coursedescription;

    @Column(name = "courselevel")
    private int courselevel;

    @Column(name = "is_completed")
    private boolean isCompleted;

    public CourseEntity() {
        super();
    }

    public CourseEntity(int courseid, String coursename, String coursedescription, int courselevel,
                        boolean isCompleted) {
        super();
        this.courseid = courseid;
        this.coursename = coursename;
        this.coursedescription = coursedescription;
        this.courselevel = courselevel;
        this.isCompleted = isCompleted;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }

    public int getCourselevel() {
        return courselevel;
    }

    public void setCourselevel(int courselevel) {
        this.courselevel = courselevel;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
