public class myHash {

    public Slot[] hashTable;

    public myHash(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{

        String key;
        String value;

        Slot(String key, String value){
            this.value = value;
            this.key = key;

        }
    }



    public int hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;


    }

    public boolean saveData(String key, String value){

        Integer address = hashFunc(key);
        if(hashTable[address]!=null) {
           if(hashTable[address].key==key) {
               this.hashTable[address].value = value;
               return true;
           }
           else
               while(this.hashTable[address]!=null){
                   address++;
                   if(address>=this.hashTable.length)
                       return false;
                   if(this.hashTable[address]!=null)
                       if(hashTable[address].key==key) {
                           this.hashTable[address].value = value;
                           return true;
                   }
               }
               this.hashTable[address]= new Slot(key, value);
               return true;
        }
        else
            this.hashTable[address] = new Slot(key, value);
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null) {
           if(this.hashTable[address].key==key)
                return this.hashTable[address].value;
           else{
                while(this.hashTable[address]!=null){
                    address++;
                    if(address>=this.hashTable.length)
                        return null;
                    if(this.hashTable[address]!=null)
                        if(this.hashTable[address].key==key)
                            return this.hashTable[address].value;
                }
                return null;
            }
        }
        else
            return null;
    }
    public static  void main(String args []){
        myHash abc = new myHash(20);

        abc.saveData("DaveLee","01022223333");
        abc.saveData("fun-coding","01033334444");
        abc.saveData("David","01044445555");
        abc.saveData("Dave","01055556666");
        abc.saveData("Done","01066667777");

        System.out.println(abc.getData("fun-coding"));
        System.out.println(abc.getData("DaveLee"));
        System.out.println(abc.getData("Done"));
        System.out.println(abc.getData("Dave"));
        System.out.println(abc.getData("David"));
    }
}
