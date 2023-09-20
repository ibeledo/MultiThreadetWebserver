package httpServerConfig;

public class Configuration {
	private int port;
	private String webroot;
	
	public int getPort() {
		return port;
	}
	public String getWebroot() {
		return webroot;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setWebroot(String webroot) {
		this.webroot = webroot;
	}

}
