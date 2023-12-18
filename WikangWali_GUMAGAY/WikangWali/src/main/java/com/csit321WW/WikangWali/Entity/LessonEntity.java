package com.csit321WW.WikangWali.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbllesson")
public class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonid;
    private int courseid;

    @Column(name = "lessontitle")
    private String lessontitle;

    @Column(name = "lessoncontent")
    private String lessoncontent;

    @Column(name = "is_completed")
    private boolean isCompleted;

    public LessonEntity() {
        super();
    }

    public LessonEntity(int lessonid, int courseid, String lessontitle, String lessoncontent, boolean isCompleted) {
        super();
        this.lessonid = lessonid;
        this.courseid = courseid;
        this.lessontitle = lessontitle;
        this.lessoncontent = lessoncontent;
        this.isCompleted = isCompleted;
    }

    public int getLessonid() {
        return lessonid;
    }

    public void setLessonid(int lessonid) {
        this.lessonid = lessonid;
    }
  
    public int getCourseid() {
    	return courseid;
    }
    
    public void setCourseid(int courseid) {
    	this.courseid = courseid;
    }
    
    public String getLessontitle() {
        return lessontitle;
    }

    public void setLessontitle(String lessontitle) {
        this.lessontitle = lessontitle;
    }

    public String getLessoncontent() {
        return lessoncontent;
    }

    public void setLessoncontent(String lessoncontent) {
        this.lessoncontent = lessoncontent;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
