package out.simplilearnproject.com;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subjecttable")
public class SubjectTable {
@Id
@GeneratedValue(strategy=GenerationType. IDENTITY)
private long subjectid;

private String subjectname;
private String subjectcode;
private String subjectclass;
@ManyToOne
private TeacherTable y;


public TeacherTable getY() {
	return y;
}
public void setY(TeacherTable y) {
	this.y = y;
}
public SubjectTable() {
	
}
public SubjectTable(String subjectname, String subjectcode, String subjectclass) {
	super();
	this.subjectname = subjectname;
	this.subjectcode = subjectcode;
	this.subjectclass = subjectclass;
}
public long getSubjectid() {
	return subjectid;
}
public void setSubjectid(long subjectid) {
	this.subjectid = subjectid;
}
public String getSubjectname() {
	return subjectname;
}
public void setSubjectname(String subjectname) {
	this.subjectname = subjectname;
}
public String getSubjectcode() {
	return subjectcode;
}
public void setSubjectcode(String subjectcode) {
	this.subjectcode = subjectcode;
}
public String getSubjectclass() {
	return subjectclass;
}
public void setSubjectclass(String subjectclass) {
	this.subjectclass = subjectclass;
}

}
