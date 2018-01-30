package pl.javastart.couponscalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class PriceCalculator {

    public double calculatePrice(List<Product> products, List<Coupon> coupons) {

        double sum = 0;
        List<Double> options = new LinkedList<>();

        if (products == null){
            return 0;
        }


        if (coupons == null){
            for (Product product : products) {
             sum += product.getPrice();
            }
        } else {
            for (Coupon coupon : coupons) {
                    double internalSum = 0;
                for (Product product : products) {
                    if(product.getCategory().equals(coupon.getCategory())) {
                        internalSum += (product.getPrice() - (product.getPrice() * coupon.getDiscountValueInPercents() / 100));
                    } else if (coupon.getCategory() == null){
                        internalSum += (product.getPrice() - (product.getPrice() * coupon.getDiscountValueInPercents() / 100));
                    } else {
                        internalSum += product.getPrice();
                    }
                }
                options.add(internalSum);
            }
            sum = Collections.min(options);
        }

//        sum *= 100;
//        sum = Math.round(sum);
//        sum /= 100;

        sum = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();

        return sum;
    }

}
