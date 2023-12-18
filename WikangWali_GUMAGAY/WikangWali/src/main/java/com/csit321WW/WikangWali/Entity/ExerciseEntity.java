package com.csit321WW.WikangWali.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblexercise")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseid;

    private int lessonid;

    @Column(name = "exercisetype")
    private String exercisetype;

    @Column(name = "exercisecontent")
    private String exercisecontent;

    @Column(name = "is_completed")
    private boolean isCompleted;

	public ExerciseEntity() {
		super();
	}

	public ExerciseEntity(int exerciseid, int lessonid, String exercisetype, String exercisecontent,
			boolean isCompleted) {
		super();
		this.exerciseid = exerciseid;
		this.lessonid = lessonid;
		this.exercisetype = exercisetype;
		this.exercisecontent = exercisecontent;
		this.isCompleted = isCompleted;
	}

	public int getExerciseid() {
		return exerciseid;
	}

	public void setExerciseid(int exerciseid) {
		this.exerciseid = exerciseid;
	}

	public int getLessonid() {
		return lessonid;
	}

	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}

	public String getExercisetype() {
		return exercisetype;
	}

	public void setExercisetype(String exercisetype) {
		this.exercisetype = exercisetype;
	}

	public String getExercisecontent() {
		return exercisecontent;
	}

	public void setExercisecontent(String exercisecontent) {
		this.exercisecontent = exercisecontent;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
    
}