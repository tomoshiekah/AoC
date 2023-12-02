public class day16packet{
    private int version;
    private int type;
    private day16data data;
    public String read(String unread){
        version = Integer.parseInt(unread.substring(0,3), 2);
        type = Integer.parseInt(unread.substring(3, 6), 2);
        if(type == 4){
            data = new day16literal();
        }else if(type == 0){
            data = new day16sum();
        }else if(type == 1){
            data = new day16product();
        }else if(type == 2){
            data = new day16minimum();
        }else if(type == 3){
            data = new day16maximum();
        }else if(type == 5){
            data = new day16greater();
        }else if(type == 6){
            data = new day16less();
        }else{
            data = new day16equal();
        }
        return data.read(unread.substring(6));
    }

    public long combine(){
        return  data.combine();
    }

    public int allVersions(){
        if(type != 4){
            return version + data.allVersions();
        }else{
            return version;
        }
    }
}