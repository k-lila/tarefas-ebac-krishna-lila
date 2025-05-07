package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ClientDAOTest.class, ClientServiceTest.class, ProductServiceTest.class, ProductSetTest.class, SaleDAOTest.class })
public class AllTests {
}
