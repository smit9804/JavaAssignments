import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class PuzzleJava{
    public void sumAndGreaterThanTen(int[] arr){
        int sum = 0;
        ArrayList <Integer> y = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++){
            if (arr[i] > 10){
                y.add(arr[i]);
            }
            sum += arr[i];
        }
        System.out.println(sum);
        System.out.println(y);
    }
    public void shuffleString(String[] arr){
        ArrayList<String> newList = new ArrayList<String>();
        ArrayList<String> List5 = new ArrayList<String>();
        for (int i=0; i<arr.length; i++){
            if(arr[i].length() > 5){
                List5.add(arr[i]);
            }
            newList.add(arr[i]);
        }
        Collections.shuffle(newList);
        System.out.println(newList);
        System.out.println(List5);
    }
    public void shuffleAlpha(char[] arr){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        ArrayList<Character> alpha = new ArrayList<Character>();
        for (int i=0; i<arr.length; i++){
            alpha.add(arr[i]);
        }
        Collections.shuffle(alpha);

        char letter = alpha.get(0);
        System.out.println(letter);
        System.out.println("First Letter: " + letter);
        System.out.println("Last Letter: " + alpha.get(25));
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter =='u'){
            System.out.println("First letter is a vowel");
        }
    }
    public void rando55To100(){
        ArrayList<Integer> rando = new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            int num = ThreadLocalRandom.current().nextInt(55,101);
            // This class keeps the current thread separate from others.
            rando.add(num);
        }
        System.out.println(rando);
    }
    public void randoSorted(){
        ArrayList<Integer> randomness = new ArrayList<Integer>();
        int max = 55;
        int min = 100;
        for (int i = 0; i<10; i++){
            int num = ThreadLocalRandom.current().nextInt(55,101);
            if (num < min){
                min = num;
            }
            if (num > max){
                max=num;
            }
            randomness.add(num);
        }
        Collections.sort(randomness);
        System.out.print(randomness);
        System.out.print("Ze smallest, teeniest number is: " + min);
    }
    public void randomString (){
        Random rand = new Random ();
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String str = "";
        for (int i=0; i<5; i++){
            int random = rand.nextInt(26);
            str += alphabet[random];
        }
        System.out.println(str);
    }
    public void randomStringTimes10 (){
        Random rand = new Random();
        StringBuilder randomString = new StringBuilder();
        ArrayList<String> randomList = new ArrayList<String>();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i <10; i++){
            for (int j=0; j<5; j++){
                randomString.append(alpha.charAt(rand.nextInt(alpha.length())));
            }
            String finals = randomString.toString();
            randomList.add(finals);
            randomString.setLength(0);
        }
        System.out.println(randomList);
    }
}