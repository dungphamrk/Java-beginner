public class Ex7 {
    public static class QuadraticEquation{
        public double a;
        public double b;
        public double c;
        public double delta;
        public QuadraticEquation(double a, double b, double c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        public void getDiscriminant(){
            this.delta=b*b-4*a*c;
        }
        public boolean hasRealRoots(){
            getDiscriminant();
            return delta >= 0;
        }
        public double getRoot1(){
            if(delta>0)
                return (-b + Math.sqrt(delta))/(2*a);
            if (delta==0)
                return -b/(2*a);
            else
                return Double.NaN;
        }
        public double getRoot2(){
            if(delta>0)
                return (-b - Math.sqrt(delta))/(2*a);
            if (delta==0)
                return -b/(2*a);
            else
                return Double.NaN;
        }
        public void display(){
            if(hasRealRoots()){
                System.out.println("Nghiệm thứ nhất: "+getRoot1());
                System.out.println("Nghiệm thứ hai: "+getRoot2());
            }else{
                System.out.println("Không có nghiệm thực");
            }
        }
    }
    public static void main(String[] args) {
        QuadraticEquation a= new QuadraticEquation(1,2,1);
        a.display();
    }
}
