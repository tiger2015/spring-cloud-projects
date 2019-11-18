package tiger;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName Test
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/14 21:35
 * @Version 1.0
 **/
public class Test {


    @org.junit.Test
    public void test01(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode("admin");
        System.out.println(result);
    }

}
