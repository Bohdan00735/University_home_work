package different_tets;

public class help_with_home_work {
    public static void main(String[] args) {
        double s=0.0;
        int m=5;
        int n=5;
        int c=1;
        for (int i =1; i <= n;i++){
            for(int j=1; j<=m; j++) {
                s+=((double) (i/j)/(i+c));
            }
        }
        System.out.println(s);
    }
}
