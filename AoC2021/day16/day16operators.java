import java.util.ArrayList;

public abstract class day16operators implements day16data{
    ArrayList<day16packet> subPackets = new ArrayList<>();
    @Override
    public String read(String unread) {
        if(unread.substring(0,1).equals("0")){
            String tempUnread = unread.substring(16);
            int length = Integer.parseInt(unread.substring(1, 16), 2);
            while(tempUnread.length()+length > unread.substring(16).length()){
                subPackets.add(0,new day16packet());
                tempUnread = subPackets.get(0).read(tempUnread);
            }
            return tempUnread;
        }else{
            String tempUnread = unread.substring(12);
            int amount = Integer.parseInt(unread.substring(1, 12),2);
            for(int i = 0; i < amount; i++){
                subPackets.add(0,new day16packet());
                tempUnread = subPackets.get(0).read(tempUnread);
            }
            return tempUnread;
        }
        
    }

    @Override
    public abstract long combine();

    public int allVersions(){
        int versions = 0;
        for (day16packet day16packet : subPackets) {
            versions = versions + day16packet.allVersions();
        }
        return versions;
    }
    
    
}
