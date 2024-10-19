package practice;

class Order {
    String tovary;
    int col;
    double price;

    public Order(String tovary, int col, double price) {
        this.tovary = tovary;
        this.col = col;
        this.price = price;
    }

    void pay(){};
    void dostavka(){};

    @Override
    public String toString() {
        return "Order{" +
                "tovary='" + tovary + '\'' +
                ", col=" + col +
                ", price=" + price +
                '}';
    }
}
interface IPayment{
    void ProcessPayment(double amount);
}
class CreditCardPayment implements IPayment{
    public void ProcessPayment(double amount){
        System.out.println("-"+amount+" s karty");
    }
}
class PayPalPayment implements IPayment{
    public void ProcessPayment(double amount){
        System.out.println("-"+amount+" s paypal");
    }
}
class BankTransferPayment implements IPayment{
    public void ProcessPayment(double amount){
        System.out.println("-"+amount+" s banka");
    }
}

interface IDelivery{
    void DeliverOrder(Order order);
}
class CourierDelivery implements IDelivery{
    @Override
    public void DeliverOrder(Order order) {
        System.out.println("Zakaz: "+order+"\nidet s curier");
    }
}
class PostDelivery implements IDelivery{
    public void DeliverOrder(Order order) {
        System.out.println("Zakaz: "+order+"\nidet s pochty");
    }
}
class PickUpPointDelivery implements IDelivery{
    public void DeliverOrder(Order order) {
        System.out.println("Zakaz: "+order+"\nidet k vam");
    }
}

interface INotification{
    void SendNotification(String message);
}

class EmailNotification implements INotification{
    @Override
    public void SendNotification(String message) {
        System.out.println("Email new message: "+message);
    }
}

class SmsNotification implements INotification{
    @Override
    public void SendNotification(String message) {
        System.out.println("SMS new message: "+message);
    }
}

class DiscountCalculator{
    void Dis(double amout){
        System.out.println("S vas "+ amout);
    }
}

class Main{
    public static void main(String[] args) {
        Order order = new Order("tel", 56, 150000);
        CreditCardPayment cardPayment = new CreditCardPayment();
        cardPayment.ProcessPayment(order.price);
        CourierDelivery courierDelivery = new CourierDelivery();
        courierDelivery.DeliverOrder(order);
        SmsNotification smsNotification= new SmsNotification();
        smsNotification.SendNotification("nikomy ne govori");
        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.Dis(order.price);
    }
}