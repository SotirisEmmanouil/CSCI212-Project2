public class SortedDate212List extends Date212List{

   public void sortedInsert(Date212 d) {
	  Date212Node Node = new Date212Node(d);
	     Date212Node current = first;
	    while(current.next != null && current.next.data.getYear() < Node.data.getYear()) {
	    		current = current.next;
	      }
	      	Node.next = current.next;
	      		current.next = Node;
	   }
} 
