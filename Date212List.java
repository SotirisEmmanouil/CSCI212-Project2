public class Date212List {
   
   protected  Date212Node first = new Date212Node(null);	//protected variables and object instances 
   protected  Date212Node last = first;
   protected  int length = 0;
   
   public int getLength() {					//get length method 
      return length;
   }
   
   public void append(Date212 d) {				//append a node 
      Date212Node t = new Date212Node(d);
      last.next = t;
      last = t;
      length++;
   }
 
   public String printDate212List(){			    //print method for the LinkedList
	    String s = "";
	    Date212Node p = first.next;

	    while(p != null){
	            s += p.data.toString() + "\n";
	            p = p.next;
	        }
	        return s;

	}
 	
   public boolean equals(Object other) {		   //equals method to check if two nodes are equal to each other
    if (other == null || getClass() != other.getClass()|| length != ((Date212List) other).length)
          return false;

      Date212Node nodeThis = first;
      Date212Node nodeOther = ((Date212List) other).first;
      while (nodeThis != null) {
         if (nodeThis.data != nodeOther.data)
              return false;

          nodeThis = nodeThis.next;
          nodeOther = nodeOther.next;
      } 

      return true;
  } 
   
 
}
