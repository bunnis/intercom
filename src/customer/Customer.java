package customer;

public class Customer implements Comparable<Customer>{
	private double latitude;
	private double longitude;
	private int id;
	private String name;


	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

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
	@Override
	public String toString() {
		return "Customer [latitude=" + latitude + ", longitude=" + longitude + ", id=" + id + ", name=" + name+"]";
	}

	@Override
	public int compareTo(Customer arg0) {
		if(arg0 == null){
			try {
				throw new NullPointerException();
			} catch (NullPointerException e) {
				System.err.println("Null value of customer");
				e.printStackTrace();
			}
		}

		Customer c = (Customer)arg0;

		if(id > c.getId()){
			return 1;
		}
		else if(id == c.getId()){
			return 0;
		} else { //id < o.getId())
			return -1;
		}
	}


}
