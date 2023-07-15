package pack1;

import java.util.List;

public interface IProductService {

    public int addProduct(Product product);
    public int updateProduct(Product product);
    public int deleteProduct(int id);
    public Product getProductByNo(int Pid);
    public List<Product> selectAll();
}