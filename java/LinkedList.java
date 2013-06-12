public class LinkedList {

	private class Node {
		int item;
		public Node next;
		public Node(int item) {
			this.item = item;
			this.next = null;
		}

		public int getItem() {
			return this.item;
		}
	}

	private Node head = null;

	public LinkedList() {
		head = null;
	}

	private int size() {
		int n = 0;

		// Dynamically calculate the size
		Node i = head;
		while (i != null) {
			n = n + 1;
			i = i.next;
		}

		return n;

	}

	public void insertAt(int item, int position) {
		int n = 0;
		if (position == n) {
			// Insert at head
			Node tmp = new Node(item);
			tmp.next = head;
			head = tmp;
		} else {
			Node i = head;
			n += 1;
			while (i.next != null && position > n) {
				i = i.next;
			}
			Node tmp = new Node(item);
			tmp.next = i.next;
			i.next = tmp;
		}
	}

	public void insertSorted(int item) {
		int n = 0;
		if (head == null || item < head.getItem()) {
			// Insert at head
			Node tmp = new Node(item);
			tmp.next = head;
			head = tmp;
		} else {
			Node i = head;
			n += 1;
			while (i.next != null && i.next.getItem() < item) {
				i = i.next;
			}
			Node tmp = new Node(item);
			tmp.next = i.next;
			i.next = tmp;
		}
	}

	public String toString() {
		Node i = head;
		StringBuilder sb = new StringBuilder();
		while (i != null) {
			sb.append(i.getItem());
			sb.append(" -> ");
			i = i.next;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		System.out.println(l.toString());
		l.insertSorted(10);

		l.insertAt(1, 0);
		System.out.println(l.toString());

		l.insertAt(2, 1);
		l.insertAt(99, 99);
		System.out.println(l.toString());

		l.insertSorted(-1);
		System.out.println(l.toString());
	}
}
