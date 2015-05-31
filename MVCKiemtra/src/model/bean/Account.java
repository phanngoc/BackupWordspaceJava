package model.bean;

public class Account {
	private String fullName;
	private Integer age;
	private boolean isFemale;
	private boolean isUsua;

	public boolean isUsua() {
		return isUsua;
	}

	public void setUsua(boolean isUsua) {
		this.isUsua = isUsua;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public void setFemale(boolean isFemale) {
		this.isFemale = isFemale;
	}

}
