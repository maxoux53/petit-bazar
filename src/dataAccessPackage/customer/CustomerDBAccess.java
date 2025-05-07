package dataAccessPackage.customer;

import dataAccessPackage.SingletonConnection;

import exceptionPackage.*;
import modelPackage.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDBAccess implements ICustomerDAO {
    @Override
    public void addCustomer(Customer customer) throws ConnectionException, ExistingException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "INSERT INTO pb.customer (id, loyaltyCardNumber, firstName, lastName, birthDate, email, loyaltyPoints, phone) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getId());
            ps.setInt(2, customer.getLoyaltyCardNumber());
            ps.setString(3, customer.getFirstName());
            ps.setString(4, customer.getLastName());
            ps.setDate(5, new java.sql.Date(customer.getBirthDate().getTime()));
            ps.setString(6, customer.getEmail());
            ps.setInt(7, customer.getLoyaltyPoints());

            if (customer.getPhone() != null) {
                ps.setString(8, customer.getPhone());
            } else {
                ps.setNull(8, Types.VARCHAR);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new ExistingException("Erreur : ce client existe déjà");
            } else {
                throw new ConnectionException("Erreur lors de l'ajout du client");
            }
        }
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws ConnectionException, NotFoundException {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "SELECT * FROM pb.customer";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setLoyaltyCardNumber(rs.getInt("loyaltyCardNumber"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(new java.util.Date(rs.getDate("birthDate").getTime()));
                customer.setEmail(rs.getString("email"));
                customer.setLoyaltyPoints(rs.getInt("loyaltyPoints"));

                String phone = rs.getString("phone");

                if (phone != null) {
                    customer.setPhone(phone);
                }

                customers.add(customer);
            }

            if (customers.isEmpty()) {
                throw new NotFoundException("Erreur : aucun client enregistré");
            }

            return customers;
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la récupération des clients");
        }
    }

    @Override
    public Customer getCustomerById(String id) throws ConnectionException, NotFoundException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "SELECT * FROM pb.customer WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setLoyaltyCardNumber(rs.getInt("loyaltyCardNumber"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setBirthDate(new java.util.Date(rs.getDate("birthDate").getTime()));
                customer.setEmail(rs.getString("email"));
                customer.setLoyaltyPoints(rs.getInt("loyaltyPoints"));

                String phone = rs.getString("phone");

                if (phone != null) {
                    customer.setPhone(phone);
                }

                return customer;
            } else {
                throw new NotFoundException("Erreur : client introuvable");
            }
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la récupération du client");
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws ConnectionException, NotFoundException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "UPDATE pb.customer SET loyaltyCardNumber = ?, firstName = ?, lastName = ?, birthDate = ?, " + "email = ?, loyaltyPoints = ?, phone = ? WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getLoyaltyCardNumber());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setDate(4, new java.sql.Date(customer.getBirthDate().getTime()));
            ps.setString(5, customer.getEmail());
            ps.setInt(6, customer.getLoyaltyPoints());

            if (customer.getPhone() != null) {
                ps.setString(7, customer.getPhone());
            } else {
                ps.setNull(7, Types.VARCHAR);
            }

            ps.setString(8, customer.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NotFoundException("Erreur : client introuvable");
            }
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la mise à jour du client");
        }
    }

    @Override
    public void deleteCustomer(String id) throws ConnectionException, NotFoundException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "DELETE FROM pb.customer WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NotFoundException("Erreur : client introuvable");
            }
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la suppression du client");
        }
    }
}