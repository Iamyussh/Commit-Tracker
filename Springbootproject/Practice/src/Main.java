public class Main {
    public static void main(String[] args) {
        Task simpletask1 = new SimpleTask("Do Coding");
        Task simpletask2 = new SimpleTask("Write the documentation");


        Tasklist tasks = new Tasklist("EBT");

        tasks.addTask(simpletask1);
        tasks.display();

    }
}