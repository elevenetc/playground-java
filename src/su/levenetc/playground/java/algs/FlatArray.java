package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by levenetc on 04/02/16.
 */
public class FlatArray {
	public static void run() {
		List notFlat = new ArrayList<>();
		notFlat.add(new ArrayList() {{
			add(1);
			add(2);
			add(new ArrayList() {{
				add(3);
				add(4);
				add(new ArrayList() {{
					add(5);
				}});
			}});
		}});

		Out.pln("in: " + notFlat);
		List list = makeFlat(notFlat, new ArrayList<>());
		Out.pln("out:" + list);
	}

	private static List makeFlat(List notFlat, List target) {
		if (notFlat.isEmpty()) return target;

		Object o = notFlat.remove(0);

		if (o instanceof List) {

			List list = (List) o;
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object val = iterator.next();

				if(val instanceof List){
					target.addAll(makeFlat((List) val, target));
				}else{
					target.add(val);
				}

				iterator.remove();
			}

			return makeFlat(list, target);
		} else {
			target.add(o);
		}

		return target;
	}
}