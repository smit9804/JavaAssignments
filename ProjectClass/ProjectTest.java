public class ProjectTest{
    public static void main(String[] args){
        Project project1 = new Project("Yabba");
        Project project2 = new Project("Dabba");
        Project project3 = new Project("Freakin", "Description");
        Project project4 = new Project("Doo", "Description", 1000);

        System.out.println(project1.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());
        System.out.println(project4.elevatorPitch());

        project1.setName("Fred");
        project1.setDescription("Freaking Flintstone");
        project1.setCost(2000);

        project2.setName("Barney");
        project2.setDescription("Freakin Rubble");
        project2.setCost(2500);

        project3.setName("Wilma");
        project3.setDescription("Freakin Flintstone");
        project3.setCost(3000);

        project4.setName("Spongebob");
        project4.setDescription("Freakin Squarepants");
        project4.setCost(50000);

        System.out.println(project1.getName());
        System.out.println(project1.getDescription());
        System.out.println(project1.getCost());
        System.out.println(project2.getName());
        System.out.println(project2.getDescription());
        System.out.println(project2.getCost());
        System.out.println(project3.getName());
        System.out.println(project3.getDescription());
        System.out.println(project3.getCost());
        System.out.println(project4.getName());
        System.out.println(project4.getDescription());
        System.out.println(project4.getCost());
    }
}