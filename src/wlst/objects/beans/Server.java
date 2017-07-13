package wlst.objects.beans;

public class Server implements Bean{

	private String name;

	public Server(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
