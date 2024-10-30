package io.github.alexopa.democucumber.context;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "io.github.alexopa.democucumber" })
public class TestContext {

}
