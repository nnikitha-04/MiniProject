package pack1;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static Scanner sc = new Scanner(System.in);
    public static Product product = new Product();
    public static productDAO dao = new productDAO();


    public static void main(String[] args) {


        boolean flag = true;
        while (flag){
            System.out.println(menu());
            System.out.print("Enter Your Option : ");
            int option = sc.nextInt();
            switch (option){
                case 1 :dao.addProduct(add());
                    break;
                case 2 : dao.updateProduct(update());
                    break;
                case 3 : dao.deleteProduct(deleteProduct());
                    break;
                case 4 : System.out.println(dao.getProductByNo(selectProduct()).toString());
                    break;
                case 5 : List<Product> AllProducts = dao.selectAll();
                        if(AllProducts == null){
                            try{
                                throw new ProductNotFoundException();
                            }catch (ProductNotFoundException e){
                                System.out.println("There are Zero(0) Number Of Products..");
                            }
                        }
                            for(Product item : AllProducts){
                                System.out.println(item.toString());
                            }
                    break;
                case 0 :
                    flag = false;
                    System.out.println("Thank You Visit Again...");
                    break;
                default: System.out.println("Enter Valid Option...");
            }

        }
    }
    public static String menu(){
        return """
                Welcome to Product Management System
                1. Add Product
                2. Update Product
                3. Delete Product
                4. Select Product By ProductId
                5. Select All Products
                0. Exit
                """;
    }
    public static Product add(){
        System.out.print("Enter Product Id : ");
        product.setPid(sc.nextInt());
        System.out.print("Enter Product Name : ");
        product.setProductName(sc.next());
        System.out.print("Enter Product Price : ");
        product.setPrice(sc.nextDouble());
        System.out.print("Enter Date Of Manufacture : ");
        product.setDOM(Date.valueOf(sc.next()));

        return product;
    }
    public static Product update(){
        System.out.print("Enter Product Id to Update : ");
        product.setPid(sc.nextInt());
        System.out.print("Enter new Product Name : ");
        product.setProductName(sc.next());
        System.out.print("Enter new Product Price : ");
        product.setPrice(sc.nextDouble());
        System.out.print("Enter latest Date Of Manufacture : ");
        product.setDOM(Date.valueOf(sc.next()));

        return product;
    }
    public static int deleteProduct(){
        System.out.print("Enter Product Id to Delete : ");
        int id = sc.nextInt();
        return id;
    }
    public static int selectProduct(){
        System.out.print("Enter Product Id to Display : ");
        int id = sc.nextInt();
        return id;
    }
}