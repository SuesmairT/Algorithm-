public class MyLinkedList {
            private Node head;
        private int size;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // Конструктор
        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // Метод для вставки элемента по индексу
        public void pushToIndex(int index, int value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }

            Node newNode = new Node(value);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node prev = getNodeAtIndex(index - 1);
                newNode.next = prev.next;
                prev.next = newNode;
            }
            size++;
        }

        // Метод для удаления первого элемента
        public void removeFirst() {
            if (head != null) {
                head = head.next;
                size--;
            }
        }

        // Метод для удаления последнего элемента
        public void removeLast() {
            if (head == null) {
                return;
            }
            if (head.next == null) {
                head = null;
            } else {
                Node secondLast = getNodeAtIndex(size - 2);
                secondLast.next = null;
            }
            size--;
        }

        // Метод для удаления элемента по индексу
        public void removeAtIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else {
                Node prev = getNodeAtIndex(index - 1);
                prev.next = prev.next.next;
                size--;
            }
        }

        // Вспомогательный метод для получения узла по индексу
        private Node getNodeAtIndex(int index) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

