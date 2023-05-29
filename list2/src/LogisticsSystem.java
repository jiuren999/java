import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogisticsSystem {

        Scanner scanner = new Scanner(System.in);

        private Connection connection;

        public LogisticsSystem() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wlgl?characterEncoding=utf8&useSSL=false", "root", "123456");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        public void addOrder() {
            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (order_number, customer_name, customer_address, delivery_date) VALUES (?, ?, ?, ?)");
                System.out.println("请输入订单名字");
                String orderNumber = scanner.next();
                System.out.println("请输入顾客名字");
                String customerName = scanner.next();
                System.out.println("请输入顾客地址");
                String customerAddress = scanner.next();
                System.out.println("请输入递送时间");
                
                statement.setString(1, orderNumber);
                statement.setString(2, customerName);
                statement.setString(3, customerAddress);
                statement.setString(4, deliveryDate);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateOrder(String orderNumber, String deliveryDate) {
            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE orders SET delivery_date = ? WHERE order_number = ?");
                statement.setString(1, deliveryDate);
                statement.setString(2, orderNumber);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteOrder(String orderNumber) {
            try {
                PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_number = ?");
                statement.setString(1, orderNumber);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void viewOrders() {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("Order Number: " + resultSet.getString("order_number"));
                    System.out.println("Customer Name: " + resultSet.getString("customer_name"));
                    System.out.println("Customer Address: " + resultSet.getString("customer_address"));
                    System.out.println("Delivery Date: " + resultSet.getString("delivery_date"));
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            LogisticsSystem logisticsSystem = new LogisticsSystem();
            logisticsSystem.addOrder("123456", "John Smith", "123 Main Street", "2023-05-20");
            logisticsSystem.viewOrders();
            logisticsSystem.updateOrder("123456", "2023-05-22");
            logisticsSystem.viewOrders();
        }

    }
