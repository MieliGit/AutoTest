package Sem_2;

import org.example.Composite;
import org.example.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComponentPatternTest {

    @Test
    void onePortfolioTest() {
        //given
        Composite composite = new Composite();
        composite.add(new Product(85L));
        composite.add(new Product(90L));
        composite.add(new Product(45L));
        //when
        Long result = composite.getSum();
        //then
        Assertions.assertEquals(575L, result);
    }

    @Test
    void complexPortfolioTest() {
        //given
        Composite compositeFirstLevel = new Composite();
        Composite compositeNextLevelOne = new Composite();
        Composite compositeNextLevelTwo = new Composite();

        compositeFirstLevel.add(compositeFirstLevel);
        compositeFirstLevel.add(compositeFirstLevel);

        compositeNextLevelOne.add(new Product(85L));
        compositeNextLevelOne.add(new Product(90L));
        compositeNextLevelOne.add(new Product(45L));

        compositeNextLevelTwo.add(new Product(85L));
        compositeNextLevelTwo.add(new Product(90L));
        compositeNextLevelTwo.add(new Product(45L));
        //when
        Long result = compositeFirstLevel.getSum();
        //then
        Assertions.assertEquals(1000L, result);
    }
}
