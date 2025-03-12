/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        // TO DO
        int length = key.length();
        int sum = 0;
        if(iseven(length)){
            for (int i = 0; i < length; i++) {
                if(iseven(i)){
                    sum+= (int)key.charAt(i);
                }
            }
        }
        if(isodd(length)){
            for (int i = 0; i < length; i++) {
                if(isodd(i)){
                    sum+= (int)key.charAt(i);
                }
            }
        }
        return sum% ht.length; //remove this line
    }
    public boolean iseven(int length){
        if(length%2==0){
            return true;
        }
        return false;
    }
    public boolean isodd(int length){
        if(length%2!=0){
            return true;
        }
        return false;
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value) {
        // TO DO
        int index = hashFunction(key);
        FruitNode inserting_node = new FruitNode(key, value);
        if(ht[index]== null){
            ht[index]= inserting_node;
        }
        else{
            FruitNode temp = ht[index];
            FruitNode previous = null;
            while(temp!=null){
                if((Integer) temp.fruit[1]<value){
                    break;
                }
                if(temp.fruit[0].equals(key)){
                    temp.fruit[1] = value;
                    return;
                }
                previous = temp;
                temp = temp.next;
            }
            if(previous!=null) {
                previous.next = inserting_node;
                inserting_node.next = temp;
            }
            else{
                inserting_node.next = ht[index];
                ht[index] = inserting_node;
            }
        }
    }

}
