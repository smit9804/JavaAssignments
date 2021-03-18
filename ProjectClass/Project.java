public class Project{
    private String name;
    private String description;
    private double cost;

    public Project(){
        this.name = "";
        this.description = "";
    }
    public Project(String name){
        this.name = name;
        this.description = "";
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name, String description, double cost){
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String elevatorPitch(){
        return (name + "(" +cost+ ")," + description);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getCost(){
        return this.cost;
    }


}