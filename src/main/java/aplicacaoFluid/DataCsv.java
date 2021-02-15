package aplicacaoFluid;

import java.sql.Time;
import java.util.Date;

public class DataCsv {
	 private String date;
	    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
		private String cases;
	    private String deaths;
	    private String uf;
	    private String time;
	    public String toString() {
	        return "DataCsv{date='" + date + "\', cases=" + cases + "\', deaths=\" + deaths + \", time='" + time + "\'}";
	    }
}
