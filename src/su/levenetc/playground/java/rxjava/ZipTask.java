package su.levenetc.playground.java.rxjava;

import rx.Observable;
import su.levenetc.playground.java.RetrofitConfig;

/**
 * Created by elevenetc on 21/06/15.
 */
public class ZipTask {
	public Observable<ZipObject> execute() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		Observable<BaseResponse> objectA = api.getObjectA();
		Observable<BaseResponse> objectB = api.getObjectB();

		return Observable.zip(objectA, objectB,
				(objectA1, objectB1) -> new ZipObject(new SomeObject(objectA1.data), new SomeObject(objectB1.data))
		);
	}
}
