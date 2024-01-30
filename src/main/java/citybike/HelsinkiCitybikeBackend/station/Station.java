package citybike.HelsinkiCitybikeBackend.station;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Station {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int fid;
	private String name;
	private String nimi;
	private String namn;
	private String address;
	private String adress;
	private String stad;
	private String operaattor;
	private String kapasiteet;
	private String city;
	private String x;
	private String y;
	private boolean isremovable;
	private boolean editable;
	
	
	
	public Station() {
		super();
		this.name = null;
		this.address = null;
		this.city = null;
		this.x = null;
		this.y = null;
	
	}


	public Station(String name, String address, String city, String x, String y ) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.x = x;
		this.y =y;
	}
	
			

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}


	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getStad() {
		return stad;
	}

	public void setStad(String stad) {
		this.stad = stad;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getOperaattor() {
		return operaattor;
	}

	public void setOperaattor(String operaattor) {
		this.operaattor = operaattor;
	}

	public String getKapasiteet() {
		return kapasiteet;
	}

	public void setKapasiteet(String kapasiteet) {
		this.kapasiteet = kapasiteet;
	}

	public boolean getIsremovable() {
		return isremovable;
	}

	public void setIsremovable(boolean isremovable) {
		this.isremovable = isremovable;
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
