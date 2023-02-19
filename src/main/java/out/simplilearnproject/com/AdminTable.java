package out.simplilearnproject.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admindata")
public class AdminTable {
@Id
private int id;
private String uid;
private String password;

public AdminTable()
{
	
}

public AdminTable(String uid, String password) {
		this.uid = uid;
	this.password = password;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
