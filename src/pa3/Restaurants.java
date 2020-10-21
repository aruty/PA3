package pa3;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurants {

	@SerializedName("data")
	@Expose
	private List<Data> data = null;

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public Integer size() {
		return data.size();
	}

}