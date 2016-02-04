package su.levenetc.playground.java.datastructures;

/**
 * Created by elevenetc on 01/08/15.
 */
public class HMap<K, V> {

	private Entry<K, V>[] table;

	public HMap(int size) {
		table = new Entry[size];
	}

	public HMap() {
		this(16);
	}

	private static int indexFor(int hash, int tableSize) {
		return hash & (tableSize - 1);
	}

	private static int hash(int hashCode) {
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}

	public void put(K key, V value) {
		if (key == null) {

		} else {
			int hash = hash(key.hashCode());
			int index = indexFor(hash, table.length);

			Entry<K, V> firstEntry = table[index];

			if (firstEntry == null) {
				addEntry(index, hash, key, value);
			} else {

				Entry<K, V> newEntry = new Entry<>(key, value, hash);
				Entry<K, V> entry = firstEntry;
				while (entry != null) {

					if (entry.key == newEntry.key || entry.key.equals(newEntry.key)) {
						//newEntry
					}

					entry = entry.next;
				}
			}
		}
	}

	private void checkAndSet(Entry<K, V> lastEntry, Entry<K, V> newEntry) {

	}

	private void addEntry(int index, int hash, K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value, hash);
		table[index] = entry;
	}

	private static class Entry<K, V> {
		K key;
		V value;
		int hash;
		Entry<K, V> next;

		public Entry(K key, V value, int hash) {
			this.key = key;
			this.value = value;
			this.hash = hash;
		}
	}
}
