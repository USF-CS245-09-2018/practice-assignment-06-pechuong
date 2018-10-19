
public class ArrayQueue implements Queue {

	private Object[] arr;
	private int tail;
	private int head;

	public ArrayQueue() {
		this.arr = new Object[10];
		this.tail = 0;
		this.head = 0;	
	}
	
	public Object dequeue() {
		if (!isEmpty() || empty()) {
			return this.arr[head++];
		} 
		return null;
	}

	public void enqueue(Object item) {
		if (((this.tail + 1) % this.arr.length) != this.head) {
			this.arr[(this.tail) % this.arr.length] = item;
			this.tail = (this.tail + 1) % this.arr.length;

		} else {
			growArray();
		}
	}

	public boolean empty() {
		if (this.head == this.tail) {
			return true;	
		}
		return false;
	}

	public void growArray() {
		Object[] newArr = new Object[this.arr.length * 2];
		for (int i = this.head; i < this.arr.length + this.head; i++) {
			newArr[this.tail++] = arr[i % arr.length];
		}
		this.head = 0;
		this.arr = newArr;
	}

	public boolean isEmpty() {
		if (this.head == this.tail) {
			return true;	
		}
		return false;
	}

}
