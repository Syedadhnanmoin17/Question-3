import java.util.*;

class Fishpond{
    //0=male, 1=female
    static List<Integer> l = new ArrayList<>(Arrays.asList(0,0,1,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,0,1));
    synchronized void fun() {
        Random r=new Random();
        int x=21,y=21;
        x=r.nextInt(l.size());
        y=r.nextInt(l.size());
        while(x==y) y=r.nextInt(l.size());
        System.out.println("Generated Random Positions:"+x+","+y);
        synchronized(l) {
            if(l.get(x)==0 && l.get(y)==0) {
                l.remove(x);
                l.remove(y);
                System.out.println("When two male fish meet : "+l);
                System.out.println("The Size : "+l.size());
            }
            else if(l.get(x)==1 && l.get(y)==1) {
                int d=new Random().nextBoolean()?x:y;
                l.remove(d);
                System.out.println("When two Female Fishes meet : "+l);
                System.out.println("The Size: "+l.size());
            }
            else if((l.get(x)==0 && l.get(y)==1)||(l.get(x)==1 && l.get(y)==0)) {
                int z=r.nextInt(2);
                int z1=r.nextInt(2);
                l.add(z);l.add(z1);
                System.out.println("When Male and Female fish meet : "+l);
                System.out.println("The Size: "+l.size());
            }
        }
    }
}

class Fishprblm extends Thread{

    Fishpond t;
    Fishprblm(Fishpond t){
        this.t=t;
    }
    public void run() {
        t.fun();
    }
}

public class Q3 {
    public static void main(String args[]) {
        Fishpond t=new Fishpond();
        Fishprblm f=new Fishprblm(t);
        f.start();
        Fishprblm f1=new Fishprblm(t);
        f1.start();
        Fishprblm f2=new Fishprblm(t);
        f2.start();
        Fishprblm f3=new Fishprblm(t);
        f3.start();
        Fishprblm f4=new Fishprblm(t);
        f4.start();
    }
}