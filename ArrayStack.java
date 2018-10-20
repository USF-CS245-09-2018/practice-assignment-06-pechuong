public class ArrayStack implements Stack {

	private Object[] arr;
	private int tail;

	public ArrayStack() {
		this.arr = new Object[10];
		this.tail = 0;
	}

	public void push(Object item) {
		if (this.tail + 1 < this.arr.length) {
			this.arr[this.tail++] = item;	
		} else {	
			growArray();
			push(item);
		}	
	}

	public Object pop() {
		if (!isEmpty()) {
			return this.arr[--this.tail];
		}
		return null;	
	}
	
	public Object peek() {
		if (!isEmpty()) {
			return this.arr[this.tail - 1];
		}
		return null;
	}	

	public boolean empty() {
		if (this.tail == 0) {
			return true;
		}
		return false;
	}
	
	public void growArray() {
		Object[] newArr = new Object[this.arr.length * 2];
		for (int i = 0; i < this.arr.length; i++) {
			newArr[i] = arr[i];
		}
		this.arr = newArr;
	}
	
	public boolean isEmpty() {
		if (this.tail == 0) {
			return true;
		}
		return false;
	}

}
