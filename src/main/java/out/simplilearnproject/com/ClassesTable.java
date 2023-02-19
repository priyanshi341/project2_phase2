package out.simplilearnproject.com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="classtable")
public class ClassesTable {
@Id
@GeneratedValue(strategy=GenerationType. IDENTITY)
private long classid;

private String classname;


public ClassesTable() {
	super();
}

public ClassesTable(String classname) {
	super();
	this.classname = classname;
}

public long getClassid() {
	return classid;
}

public void setClassid(long classid) {
	this.classid = classid;
}

public String getClassname() {
	return classname;
}

public void setClassname(String classname) {
	this.classname = classname;
}

}
