public class day16literal implements day16data{
    String value = "";
    @Override
    public String read(String unread) {
        int currentBit = 0;
        boolean end = false;
        while(!end){
            if(unread.substring(currentBit,currentBit+1).equals("0")){
                end = true;
            }
            value = value + unread.substring(currentBit+1, currentBit+5);
            currentBit = currentBit + 5;
        }
        return unread.substring(currentBit);
    }

    @Override
    public long combine() {
        return Long.parseLong(value,2);
    }
    
    public int allVersions(){
        return 0;
    }
}
