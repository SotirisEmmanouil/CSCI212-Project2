import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.StringTokenizer;
import javax.swing.*;

public class Date212GUI extends JFrame {
	
	private static final long serialVersionUID = -3233832004041626841L;	//variables and instances of needed objects
	public static int tokens;
	public static String[] dateListUnsorted;
	public static TextFileInput DateFile,DateFile2;
	public static StringTokenizer DateTokens,DateTokens2;
	public static String FileName = "/Users/sotirisemmanouil/eclipse-workspace/CS212 Project2/src/DateFile.txt";
	public static TextArea unsortedDates;
	public static TextArea sortedDates;  

    public static void openGUI() {
	     Date212GUI DateFrame = new Date212GUI();
	     unsortedDates = new TextArea("Unsorted\n\n");
	     sortedDates = new TextArea("Sorted\n\n");
	     DateFrame.add(unsortedDates,BorderLayout.WEST);
	     DateFrame.add(sortedDates, BorderLayout.EAST);
	       DateFrame.setSize(500,400);
	       DateFrame.setLocation(100, 100);
	       DateFrame.setTitle("Dates");
	       DateFrame.setLayout(new GridLayout(1,2));
	       DateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       DateFrame.setVisible(true);
	       unsortedDates.setEditable(false);
	       sortedDates.setEditable(false);
	       readFromFile(FileName);
	       printLists(dateListUnsorted);
	      
	
	}
	
	
   public static void readFromFile(String filename)  {
	    int k = 0;
	    String line, line2;
	    DateFile = new TextFileInput(filename);
	 	line = DateFile.readLine();
	 				
	    while (line!=null) {							// count the amount of tokens
	 	DateTokens = new StringTokenizer(line,",");
	 		tokens += DateTokens.countTokens();
	 	line = DateFile.readLine();
	 				}
	 	dateListUnsorted = new String[tokens];				// declare an array with the size of the tokens
	 DateFile2 = new TextFileInput(filename);
		line2 = DateFile2.readLine();
		 			
	 	while (line2!= null) {						//while there are more lines, create tokens
	 	DateTokens2 = new StringTokenizer(line2,",");	
	 	while (DateTokens2.hasMoreTokens()) {				//while there are more tokens, append the tokens to the array
	    dateListUnsorted[k++] = DateTokens2.nextToken();		
	 			}
	 	 line2= DateFile2.readLine();				//read the next line
	 				
	 					}
	 				

	 		}
	 
    public static void printLists(String [] list) {			//append the dates via LinkedLists to the GUI
	  UnsortedDate212List unsortedList = new UnsortedDate212List();
		SortedDate212List sortedList = new SortedDate212List(); 
		  for (int i=0;i<list.length;i++) {
			 unsortedList.add(new Date212(list[i]));
			 sortedList.sortedInsert(new Date212(list[i]));
		 }
			unsortedDates.append(unsortedList.printDate212List());	  	
			  sortedDates.append(sortedList.printDate212List());  
	 }
}
