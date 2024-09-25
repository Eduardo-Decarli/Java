import entities.Instrutor;
import entities.User;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Instrutor instrutor = new Instrutor(1, "Alex");

        Scanner sc = new Scanner(System.in);
        Set<User> setCurseA = new HashSet();
        Set<User> setCurseB = new HashSet();
        Set<User> setCurseC = new HashSet();

        System.out.println("How many stydents for course A?");
        int numUserA = sc.nextInt();
        for(int i = 0; i < numUserA; i++ ){
            int idUser = sc.nextInt();
            User user = new User(idUser);
            setCurseA.add(user);
        }

        System.out.println("How many stydents for course B?");
        int numUserB = sc.nextInt();
        for(int i = 0; i < numUserB; i++ ){
            int idUser = sc.nextInt();
            User user = new User(idUser);
            setCurseB.add(user);
        }

        System.out.println("How many stydents for course C?");
        int numUserC = sc.nextInt();
        for(int i = 0; i < numUserC; i++ ){
            int idUser = sc.nextInt();
            User user = new User(idUser);
            setCurseC.add(user);
        }

        Set<User> users = instrutor.consultSet(setCurseA, setCurseB, setCurseC);

        System.out.println("Total students: " + users.size());
    }
}