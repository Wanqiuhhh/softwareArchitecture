package example.client;

import java.util.Scanner;

public class test {
    public static void main(String[] argv) {
        try {
            HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
            HelloWorld_PortType service = locator.getHelloWorld();
            // If authorization is required
            //((HelloWorldSoapBindingStub)service).setUsername("user3");
            //((HelloWorldSoapBindingStub)service).setPassword("pass3");
            // invoke business method
            Scanner sc  = new Scanner(System.in);
            System.out.println("请输入你的工资：");
            double income = sc.nextDouble();
            double result = service.sayHelloWorldFrom(income);
            System.out.println("需缴税"+result);
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
