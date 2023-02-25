public abstract class Bremse {
	private String manufacturer;
	private String serialNumber

	public Bremse(String manufacturer, String serialNumber) {
		this.manufacturer = manufacturer;
		this.serialNumber = serialNumber;
	}

	public abstract void bremsen();
	public abstract void brauchtService();
}
