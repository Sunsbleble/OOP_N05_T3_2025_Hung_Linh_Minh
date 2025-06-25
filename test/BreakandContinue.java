public class BreakandContinue {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            if(i==74) break; // out of for loop
            if(i%9!=0) continue; //next itertion
            System.out.println(i);
        }
    }
}
