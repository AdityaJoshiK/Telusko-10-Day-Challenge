import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface CricketPlayer
    {
        int age() default 34;
        String country() default "India";
    }

    // @CricketPlayer(age = 34, country = "India")
    @CricketPlayer 
    class Virat{
        int runs;
        int innings;

        public int getInnings() {
            return innings;
        }

        public int getRuns() {
            return runs;
        }

        public void setRuns(int runs) {
            this.runs = runs;
        }

        public void setInnings(int innings) {
            this.innings = innings;
        }
    }

public class Main {
    public static void main(String[] args) {
        Virat v = new Virat();
        v.setRuns(15000);
        v.setInnings(250);

        System.out.println(v.getInnings());
        System.out.println(v.getRuns());

        Class c = v.getClass();
        // Annotation[] a =c.getAnnotations();

        // for(Annotation n : a)
        // {
        //     System.out.println(n.annotationType());
        // }

        Annotation an = c.getAnnotation(CricketPlayer.class);
        CricketPlayer cp = (CricketPlayer)an;
        System.out.println(cp.age());
        System.out.println(cp.country());
    }
}
