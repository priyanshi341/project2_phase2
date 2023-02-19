package out.simplilearnproject.com;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="studenttable")
public class StudentTable {
@Id
@GeneratedValue(strategy=GenerationType. IDENTITY)
private long studentid;

private String name;
private String fathername;
private LocalDate dateofbirth;
private LocalDate dateofjoining;
private String address;
@OneToOne
private ClassesTable classtable;




public StudentTable()
{
	
}


public StudentTable(String name, String fathername, LocalDate dateofbirth, LocalDate dateofjoining, String address) {
	
	this.name = name;
	this.fathername = fathername;
	this.dateofbirth = dateofbirth;
	this.dateofjoining = dateofjoining;
	this.address = address;
}

public ClassesTable getClasstable() {
	return classtable;
}


public void setClasstable(ClassesTable classtable) {
	this.classtable = classtable;
}

public long getStudentid() {
	return studentid;
}


public void setStudentid(long studentid) {
	this.studentid = studentid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
public LocalDate getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(LocalDate dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public LocalDate getDateofjoining() {
	return dateofjoining;
}
public void setDateofjoining(LocalDate dateofjoining) {
	this.dateofjoining = dateofjoining;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
