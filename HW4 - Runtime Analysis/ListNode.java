	// Basic node stored in a linked list


    public class ListNode
    {
	public Object element;
        public ListNode next;

        //Constructors
        ListNode( Object theElement )
        {
            this( theElement, null );
        }

        ListNode( Object theElement, ListNode n )
        {
            this.element = theElement;
            this.next    = n;
        }
    }
