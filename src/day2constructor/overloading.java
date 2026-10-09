package day2constructor;

public class overloading {
    int a,b;
    float c;
    overloading (int a,int b)
    {    this.a=a;
         this.b=b;
        System.out.println(a+" "+b);
    }
    overloading (int b)
    {   this.b=b;
        System.out.println(b);
    }

    public static void main(String[] args) {
      //  overloading obj=new overloading();//error
        overloading obj =new overloading(5);

    }
}
