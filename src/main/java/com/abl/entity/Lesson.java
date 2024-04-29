/*
 * package com.abl.entity;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.OneToMany; import jakarta.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "classes") public class Lesson {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "id") String id;
 * 
 * @Column(name = "name") String name;
 * 
 * @OneToMany(mappedBy="class") private List<LessonConfig> configs;
 * 
 * 
 * public Lesson(String id, String name) { super(); this.id = id; this.name =
 * name; }
 * 
 * public String getId_clase() { return id; }
 * 
 * public void setId_clase(String id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; } }
 */