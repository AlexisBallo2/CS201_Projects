    /**
     * List-based implementation of the queue.
     * @author Mark Allen Weiss
     */

public class QueueLi {
	
    private ListNode front;
    private ListNode back;
    private int currsize=0;
	
    /**
     * Construct the queue.
     */
    public QueueLi( ) {
        front = back = null; 
    }
    
    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return front == null;
    }
    
    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue( Object x ) {
    	
        if( isEmpty( ) )    // Make queue of one element
            back = front = new ListNode( x );
        else {
            
            //code for the case when queue is not empty
            /*TO DO*/
        	
        	
        	ListNode newNode = new ListNode(x); //make new listnode with the object passed
        	back.next = newNode;  //add the new node to the back of the queue
        	back = newNode;  //change the back pointer to the newnode
        	currsize++;   //show the size of the queue has changed
        	
        	
        }
        
      
        
    }
    
    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     */
    public Object dequeue( ) {
        if( isEmpty( ) ) {
        	//prints to error stream
        	System.err.println("Queue empty!");
        	return null;
        } else {
        	   //code for the case when queue is not empty
            /*TO DO*/
        	ListNode temp = front;  //make temp vairable
        	front = front.next;  //change front of queue to next listNode
        	currsize--;    //decrease size of list
        	return temp;  //return the previous top/front
        }
       
    
        
        
    }

    /**
     * Return the least recently inserted item
     * of the queue.
     * @return the least recently inserted item in the queue.
     */
    public Object peek()
    {
    	if( isEmpty( ) ) {
    		//prints to error stream
        	System.err.println("Queue empty!");
        	return null;
    	}
    	//code for the case when queue is not empty
        /*TO DO*/
    	 return front.element; //return the front element!
    }
    
    /**
     * Return the number of elements in the queue.
     * @return the the number of elements in the queue.
     */
    public int size()
    {
    	return currsize;
    }
    
    
}
