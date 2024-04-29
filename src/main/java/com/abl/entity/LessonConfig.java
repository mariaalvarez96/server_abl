/*
 * package com.abl.entity;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.Id; import jakarta.persistence.ManyToOne; import
 * jakarta.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "lesson") public class LessonConfig {
 * 
 * @Id
 * 
 * @Column(name = "id") String id;
 * 
 * @ManyToOne private Lesson lesson;
 * 
 * @Column(name = "day") String day;
 * 
 * @Column(name = "start_time") String start_time;
 * 
 * @Column(name = "end_time") String end_time;
 * 
 * public LessonConfig(String id, Lesson lesson, String day, String start_time,
 * String end_time) { super(); this.id = id; this.lesson = lesson; this.day =
 * day; this.start_time = start_time; this.end_time = end_time; }
 * 
 * public LessonConfig() { super(); }
 * 
 * public String getId() { return id; }
 * 
 * public void setId(String id) { this.id = id; }
 * 
 * public Lesson sgtLesson() { return lesson; }
 * 
 * public void setLesson(Lesson lesson) { this.lesson = lesson; }
 * 
 * public String getDay() { return day; }
 * 
 * public void setDay(String day) { this.day = day; }
 * 
 * public String getStart_time() { return start_time; }
 * 
 * public void setStart_time(String start_time) { this.start_time = start_time;
 * }
 * 
 * public String getEnd_time() { return end_time; }
 * 
 * public void setEnd_time(String end_time) { this.end_time = end_time; }
 * 
 * 
 * }
 */
