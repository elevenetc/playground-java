package su.levenetc.algorithms.rxjava;

/**
 * Created by elevenetc on 21/06/15.
 */
public class BaseResponse {

	public final String result;
	public final Throwable error;
	public final String data;

	public BaseResponse(String result, String data) {
		this.result = result;
		this.data = data;
		error = null;
	}

	public BaseResponse(String result, String data, Throwable error) {
		this.result = result;
		this.error = error;
		this.data = data;
	}

	@Override public String toString() {
		return "BaseResponse{" +
				"result='" + result + '\'' +
				"data='" + data + '\'' +
				'}';
	}
}
