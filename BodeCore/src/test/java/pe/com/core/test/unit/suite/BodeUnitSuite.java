package pe.com.core.test.unit.suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import pe.com.core.entity.Producto;
import pe.com.core.test.unit.test.ProductoTest;

@RunWith(Categories.class)
@SuiteClasses({ProductoTest.class})
public class BodeUnitSuite {

}

