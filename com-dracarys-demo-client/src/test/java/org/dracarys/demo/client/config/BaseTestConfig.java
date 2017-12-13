/**
 *
 */
package org.dracarys.demo.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author Johnny
 *
 */
@ContextConfiguration(locations={
        "classpath:conf/spring/app-client-config-test.xml"})
public abstract class BaseTestConfig extends AbstractTestNGSpringContextTests{
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
}
