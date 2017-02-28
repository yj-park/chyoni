package network.xml;
// 연관된 정보가 있네? -> VO로 묶어야겠다 하고 습관적으로 만들기
public class FamilyVO {
	private String father;
	private String mother;
	private String me;
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getMe() {
		return me;
	}
	public void setMe(String me) {
		this.me = me;
	}
	
}
