/**
 * Implements a BoundedQueue by taking in a size.
 * @author Aditya Majumdar
 *
 */
public class BoundedQueue {

	private int elements[];
    private int front;
    private int back;
    private int count;

    /**
     * Initializes BoundedQueue structure with a given size
     * @param bound - max capacity of queue structure
     */
    public BoundedQueue(int bound)
    {
    	if(bound < 0)
    		throw new IllegalStateException("Cannot have negative queue capacity.");
    	
        elements = new int[bound]; //sets the max size (bound) of the queue
    	
        //keep indices on the front and back insertion/removal points for the q's enQ and deQ methods
        front = 0;
        back = 0;
    }

    /**
     * Inserts a new number into the BoundedQueue (if it isn't already full)
     * Throw an exception if the queue is full.
     * @param numToInsert - integer to be added to queue structure
     */
    public void enqueue(int numToInsert)
    {
    	//If count is equal to the length of the bounded queue, then there are no free spaces to insert a number
    	//Thus, throw an exception stating that
        if (count == elements.length)
            throw new IllegalStateException("The queue is already at capacity. The number " + numToInsert + " could not be inserted.\n");
        
        //put the input at the back index of the queue
        elements[back] = numToInsert;
        
        int prev = ++back;
        
        if(prev == elements.length)
        	back = 0;
        
        ++count; //slightly faster than count++
        //means the element was added successfully
    }
   
    /**
     * Returns the integer at the end of the queue
     * If the queue is empty, throw an exception
     * @return
     */
    public int dequeue() throws IllegalStateException
    {
        if (count == 0)
            throw new IllegalStateException("No elements in BoundedQueue. Dequeue method failed.");
        
        int elem = elements[front];
        elements[front] = 0;
        
        int next = ++front;
        
        if(next == elements.length)
        	front = 0;
        
        --count; //slightly faster than count--
        //decrement count as the element is removed
        
        return elem;
    }
    
    /**
     * Getter method used in testing class.
     * @return - number of elements in queue
     */
    public int getCount()
    {
    	return count;
    }
    
    /**
     * Returns element in a given spot within the queue
     * @param a - index to access
     * @return
     */
    public int getElem(int a)
    {
    	if(elements.length > front+a)
    		return elements[front + a];
    	else
    		return elements[back + a];
    }
}