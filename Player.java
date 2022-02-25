
package gamex;


public class Player {
   private String name;
   private String tries;
   private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTries() {
        return tries;
    }

    public void setTries(String tries) {
        this.tries = tries;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Player(String name, String tries, String time) {
        this.name = name;
        this.tries = tries;
        this.time = time;
    } 
    
}
