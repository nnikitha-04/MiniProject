package pack1;

import java.util.List;

public class ProductService implements IProductService {

    private productDAO dao = new productDAO();

    @Override
    public int addProduct(Product product) {
        return dao.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return dao.updateProduct(product);
    }

    @Override
    public int deleteProduct(int id) {
        return dao.deleteProduct(id);
    }

    @Override
    public Product getProductByNo(int Pid) {
        return dao.getProductByNo(Pid);
    }

    @Override
    public List<Product> selectAll() {
        return dao.selectAll();
    }
}