package com.codingrevolution.junit5.rules;

import org.eclipse.jetty.server.Server;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;

public class JUnit4ServerBaseTest {
    static Server server = new Server(9000);

    @ClassRule
    public static ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            server.start();
        }

        @Override
        protected void after() {
            try {
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
