package pojo;


public class DataBackups {

	private int id;
	private String type;
	private String name;
	private String content;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getDate(){
		return date;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
}
