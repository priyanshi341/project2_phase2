package out.simplilearnproject.com;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="teachertable")
public class TeacherTable {
@Id
@GeneratedValue(strategy=GenerationType. IDENTITY)
private long teacherid;

private String name;
private String email;
private String gender;
private LocalDate dateofbirth;
private String address;
private String mobile;
@OneToMany(mappedBy="y")
private List<SubjectTable> t;

public List<SubjectTable> getT() {
	return t;
}

public void setT(List<SubjectTable> t) {
	this.t = t;
}

public TeacherTable()
{}

public TeacherTable(String name, String email, String gender, LocalDate dateofbirth, String address, String mobile) {
	super();
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.dateofbirth = dateofbirth;
	this.address = address;
	this.mobile = mobile;
}

public long getTeacherid() {
	return teacherid;
}

public void setTeacherid(long teacherid) {
	this.teacherid = teacherid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



public String getGender() {
	return gender;
}




public void setGender(String gender) {
	this.gender = gender;
}




public LocalDate getDateofbirth() {
	return dateofbirth;
}

public void setDateofbirth(LocalDate dateofbirth) {
	this.dateofbirth = dateofbirth;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}


}
