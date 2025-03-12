/*You will have to complete the PairNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and searchHashtable()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the PairNode objects
    private PairNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new PairNode[size];
    }

    //This method is called to insert each pair from the 2D Array
	//DO NOT change this method
    public void createFromArray(Object[][] arr){
        for( Object[] x: arr )
            this.insert( x );
    }

    //The insert() method inserts the pair into proper Hashed Index
	//This method is already written including collision resolve using Forward Chaining
    //DO NOT change this method
    public void insert(Object[] keyValuePair){
        String key = (String)keyValuePair[0];
        Integer value = (Integer)keyValuePair[1];
        String srchResult = this.searchHashtable(keyValuePair);
        if ( srchResult==null ) {
            System.out.println("Incomplete searchHashTable() and hashFunction() method");
        } else if ( srchResult.equals( "Found" ) ){
            System.out.println("("+key+","+value+") already Inserted. Cannot reinsert.");
        } else {
            int hashedIndex = this.hashFunction( key );
            PairNode newPNode = new PairNode( key, value );
            if ( this.ht[hashedIndex] == null ){
                this.ht[hashedIndex] = newPNode;
            } else {
                newPNode.next = this.ht[hashedIndex];
                this.ht[hashedIndex] = newPNode;
            }
        }
    }

    //This method basically prints the HashTable
    //DO NOT change this method
    public void printHashTable(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" : " );
            PairNode pNode = ht[i];
            if( pNode==null ) System.out.println("null");
            while (pNode!=null){
                System.out.print("(Key: "+pNode.key+", Value: "+pNode.value+") --> ");
                if (pNode.next==null) System.out.println("null");
                pNode = pNode.next;
            }
        }
    }

	//you need to COMPLETE this method
    private int hashFunction( String key ){
        // TO DO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int length = key.length();
        int i = 0;
        int sum =  0;
        while(i<length){
            String pair = "";
            if(i+1==length){
                pair = key.charAt(i)+"N";
            }
            else{
                pair = key.charAt(i)+""+key.charAt(i+1);// SUBSTRING USE KORSI EKHANE
            }
            int ascii1 = (int) pair.charAt(0);
            int ascii2 = (int) pair.charAt(1);
            int reqAscii = concatenate(ascii1, ascii2);
            sum+= reqAscii;
            i+=2;
        }
        return sum%ht.length; //remove this line
    }
    public int concatenate( int a, int b ){
        int btem = b;
        int length = 0;
        while(btem!=0){
            btem = btem/10;
            length++;
        }
        return (int) (Math.pow(10,length)*a + b);
    }

	//you need to COMPLETE this method
    //Hint: you may need to use Integer.parseInt() to convert from String to Integer
    public String searchHashtable( Object[] keyValuePair ){
        // TO DO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //it'll return either "Found" or "Not Found"
        String str = (String) keyValuePair[0];
        int num = (int) keyValuePair[1];
        int index = hashFunction(str);
        PairNode roam = ht[index];
        while(roam != null){
            if(roam.value.equals(num)&&roam.key.equals(str)){
                return "Found";
            }
            else{
                roam = roam.next;
            }
        }
        return "Not Found"; // remove this line
    }

}
