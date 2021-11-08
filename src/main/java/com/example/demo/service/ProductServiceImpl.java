package com.example.demo.service;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements  IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product buyProduct(Product product) {
        Double price=5000.4;
        Double finalPrice=product.getQuantity()*price;
        product.setPrice(finalPrice);
        Product savedProduct=productRepository.save(product);

        Payment payment=new Payment();
        payment.setPaidAmount(finalPrice);
        payment.setProductId(savedProduct.getPid());
        payment.setQuantity(product.getQuantity());
        String url="http://3.110.82.154/payment/makePayment";
        Payment savedPayment=restTemplate.postForObject(url,payment,Payment.class);
        System.out.println(savedPayment);
        return savedProduct;
        

    }
}
