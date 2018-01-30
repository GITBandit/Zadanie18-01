package pl.javastart.couponscalc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Test
    public void shouldReturnZeroForNoProducts() {
        // given
        PriceCalculator priceCalculator = new PriceCalculator();

        // when
        double result = priceCalculator.calculatePrice(null, null);

        // then
        assertThat(result, is(0.));
    }

    @Test
    public void shouldReturnPriceForSingleProductAndNoCoupons() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));

        // when
        double result = priceCalculator.calculatePrice(products, null);

        // then
        assertThat(result, is(5.99));
    }

    @Test
    public void shouldReturnPriceForSingleProductAndOneCoupon() {

        // given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Masło", 5.99, Category.FOOD));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.FOOD, 20));

        // when
        double result = priceCalculator.calculatePrice(products, coupons);

        // then
        assertThat(result, is(4.79));
    }


    @Test
    public void shouldReturnPriceForFewProductsAndOneCoupon(){

        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Chleb",3.50,Category.FOOD));
        products.add(new Product("Żarówka",10,Category.HOME));
        products.add(new Product("Cebula",1.50,Category.FOOD));
        products.add(new Product("Film",20,Category.ENTERTAINMENT));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.FOOD,20));

        //when
        double result = priceCalculator.calculatePrice(products,coupons);

        //then
        assertThat(result, is(34.00));

    }

    @Test
    public void shouldReturnPriceForOneProductAndFewCoupons(){

        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Kawior",100,Category.FOOD));


        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.FOOD,20));
        coupons.add(new Coupon(10));

        //when
        double result = priceCalculator.calculatePrice(products,coupons);

        //then
        assertThat(result, is(80.00));

    }


    @Test
    public void shouldReturnPriceForFewProductsAndFewCoupons(){

        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Widły",50,Category.HOME));
        products.add(new Product("Kawior",100,Category.FOOD));
        products.add(new Product("Kran",50,Category.HOME));
        products.add(new Product("Film",20,Category.ENTERTAINMENT));

        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Category.HOME,20));
        coupons.add(new Coupon(10));

        //when
        double result = priceCalculator.calculatePrice(products,coupons);

        //then
        assertThat(result, is(198.00));


    }


}