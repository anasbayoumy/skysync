package skysync.core;

public class plane {
	
	private int id;
	private String model;
	private String Fclass;
	private String premium;
	private String economy;
	
	public plane() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFclass() {
		return Fclass;
	}

	public void setFclass(String fclass) {
		Fclass = fclass;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getEconomy() {
		return economy;
	}

	public void setEconomy(String economy) {
		this.economy = economy;
	}
	
	
}
