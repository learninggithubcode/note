package demo.mybatis.MyBatis03_02.domain;

public class Student {

	private Integer id;//主键
	private String name; //姓名
	private String gender;//性别
	private String major;//专业
	private String grade;//年级
	private Teacher supervisor; //学生的指导教师
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Teacher getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Teacher supervisor) {
		this.supervisor = supervisor;
	}
}
