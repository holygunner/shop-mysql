package com.shop;

public class Query {
	
    public Query(){
    }

    protected static String addProduct(Integer id, String name, int price, boolean accessibility) {   // c id
      return "Insert into products values"
              + "(" + "'" + name + "'" +  id + "," + name + "," + price + "," + accessibility + ")";
    }

    protected static String addProduct(String name, int price, boolean accessibility) {   // без id
        return "Insert into products (name,price,accessibility) values"
                + "(" + "'" + name + "'" + "," + price + "," + accessibility + ")";
    }

    protected static String addProduct(Integer id, String name, int price, boolean accessibility, int producerId) {   // c id и fk производителя
        return "Insert into products values"
                + "(" + "'" + name + "'" +  id + "," + name + "," + price + "," + accessibility + "," + producerId +  ")";
    }

    protected static String addProduct(String name, int price, boolean accessibility, int producerId) {   // без id и с fk производителя
        return "Insert into products (name,price,accessibility,product_fk) values"
                + "(" + "'" + name + "'" + "," + price + "," + accessibility + "," + producerId + ")";
    }



    protected static String deleteProduct(String name) {
        return "delete from products where name=" + "'" +  name + "'";
    }

    protected static String deleteProduct(int id) {
        return "delete from products where id=" + id;
    }


   protected static String selectFromProducts () {
       return "select * from products";
   }

   protected static String selectFromProductsAndProducer () {
        return "select * from products, producer where products.product_fk = producer.id";
   }

    protected static String orderProducts(String category) {
       return selectFromProducts() + " order by " + category;
    }

    protected static String orderProducts(String table, String category) {
       return selectFromProductsAndProducer() + " order by " + table + "." + category;
    }

    protected static String countProduct() {
       return "select count(products.name) from products, producer\n" +
               "where products.product_fk = producer.id\n" +
               "order by products.name";
    }




    protected static String groupProducts() {        
        return " select name,price, sum(price)\n" +
                " from products\n" +
                " group by name,price";
    }


}
