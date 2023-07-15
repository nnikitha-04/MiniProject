package pack1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDAO {
    Connection conn = DBUtil.getDBConnection();
    public static final String addProduct = "insert into product values(?,?,?,?)";
    public static final String updateProduct = "update product set productName = ? " +
            ", Price = ? , DOM = ? where Pid = ?";
    public static final String deleteProduct = "delete from product where Pid = ?";
    public static final String selectProductByNo = "select * from product where Pid = ?";
    public static final String selectAll = "select * from product";

    public int addProduct(Product product){
        int count = 0;
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(addProduct);
            preparedStatement.setInt(1,product.getPid());
            preparedStatement.setString(2,product.getProductName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setDate(4,product.getDOM());

            count = preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Insertion Failed : "+e.getMessage());
        }
        return count;
    }

    public int updateProduct(Product product){
        int count = 0;
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(updateProduct);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setDate(3,product.getDOM());
            preparedStatement.setInt(4,product.getPid());

            count = preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Update Failed : "+e.getMessage());
        }
        return count;
    }
    public int deleteProduct(int id){
        int count = 0;
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(deleteProduct);
            preparedStatement.setInt(1,id);

            count = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Delete Failed : "+e.getMessage());
        }
        return count;
    }
    public Product getProductByNo(int Pid){
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectProductByNo);
            preparedStatement.setInt(1,Pid);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product.setPid(resultSet.getInt("Pid"));
                product.setProductName(resultSet.getString("productName"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setDOM(resultSet.getDate("DOM"));
            }
        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
        }
        return product;
    }
    public List<Product> selectAll(){
        List<Product> AllProducts = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(selectAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setPid(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setDOM(resultSet.getDate(4));
                AllProducts.add(product);
            }
        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
        }
        return AllProducts;
    }
}