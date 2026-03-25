package petstore.runner;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:petstore/user/e2eUser.feature");
    }
}