
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
		/*
		System.out.println("Empty Head: " + this.head);
		System.out.println("Empty Tail: " + this.tail);
		*/
		if (!empty()) {
			Object temp = this.arr[this.head];
			//System.out.println("Arr length: " + this.arr.length);
			this.head = (this.head + 1) % this.arr.length;
			/*
			System.out.println("Dequeue Head: " + this.head);
			System.out.println("Dequeue Tail: " + this.tail);
			
			System.out.println("Head == Tail? " + (this.head == this.tail));
			*/
			return temp;
		} 
		return null;
	}

	public void enqueue(Object item) {
		if (((this.tail + 1) % this.arr.length != this.head)) {
			this.arr[this.tail % this.arr.length] = item;
			this.tail = (this.tail + 1) % this.arr.length;
		} else {
			growArray();
			enqueue(item);
		}
	}

	public boolean empty() {
		if (this.head == this.tail) {
			//System.out.println("EmptyHead: " + this.head);
			//System.out.println("Empty Tail: " + this.tail);
			return true;	
		}
		return false;
	}

	public void growArray() {
		Object[] newArr = new Object[this.arr.length * 2];
		this.tail = 0;
		for (int i = this.head; i < this.arr.length + this.head - 1; i++) {
			newArr[this.tail++] = arr[i % this.arr.length];
		}
		this.head = 0;
		this.arr = newArr;
	}

}
