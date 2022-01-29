package dbStudy;

public class ClassDTO {
	String name;
	int number;
	int math;
	int eng;
	int kor;
	public ClassDTO(int number,String name, int kor , int eng,int math) {
		super();
		this.name = name;
		this.number = number;
		this.math = math;
		this.eng = eng;
		this.kor = kor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	@Override
	public String toString() {
		return "번호 : " + getNumber()+ "\t" + "이름 : " +getName() +"\n" + "국어 : " +getKor() + "  영어 : " +getEng()+"  수학 : " + getMath();
	}
}
