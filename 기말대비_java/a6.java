package 기말대비_java;

class Circle{
    int x, y, r;
    Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public String toString(){
        return "Circle("+x+","+y+") 반지름 "+ r;
    }

    boolean equals(Circle a){
        return x==a.x && y==a.y;
    }
}

public class a6 {
    public static void main(String[] args){
        Circle a = new Circle(2,3,5);
        Circle b = new Circle(2,3,30);
        System.out.println("원 a: " + a);
        System.out.println("원 b: " + b);

        if(a.equals(b)){
            System.out.println("같은 원");
        }
        else{
            System.out.println("다른 원");
        }

    }
}
