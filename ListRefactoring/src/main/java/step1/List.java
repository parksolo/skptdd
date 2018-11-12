package step1;


public class List {

	public static final int INITIAL_STORE_SIZE = 10;
	public static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elementStore = new Object[INITIAL_STORE_SIZE];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly) {
			return;
		}

		if (isElementStoreFull()) {
			increaseElementStore();
		}

		addElementAtEnd(element);
	}

	private void addElementAtEnd(Object element) {
		elementStore[size] = element;
		size++;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elementStore.length;
	}

	private void increaseElementStore() {
		Object[] newElementStore =
			new Object[elementStore.length + STORE_SIZE_INCREMENT];
		for (int i = 0; i < size; i++) {
			newElementStore[i] = elementStore[i];
		}

		elementStore = newElementStore;
	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		return elementStore[index];
	}
}
