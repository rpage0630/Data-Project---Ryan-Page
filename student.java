import java.util.ArrayList;

public class student {
    public int id;
    private ArrayList<days> days = new ArrayList<days>();

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public ArrayList<days> getDays() {return days;}
    public void setDays(ArrayList<days> days) {this.days = days;}
}
