package weatherForecast;

import weatherForecast.client.WeatherWebServiceLocator;
import weatherForecast.client.WeatherWebServiceSoap_BindingStub;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class weatherForecastService {
    public static void main(String[] args) throws RemoteException, ServiceException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询天气的城市：");
        String city = sc.next();
        String result[] = QueryWeatherForecastInfo(city);
        for (String r : result)
            System.out.println(r);
    }

    public static String[] QueryWeatherForecastInfo(String cityName) throws RemoteException, ServiceException {
        WeatherWebServiceLocator locator = new WeatherWebServiceLocator();

        // 调用xxLocator对象的getXXPort()方法生成xxSoapBindingStub对象
        WeatherWebServiceSoap_BindingStub stud = (WeatherWebServiceSoap_BindingStub) locator.getWeatherWebServiceSoap();
        // 输出当天的天气状况
        String[] weather = stud.getWeatherbyCityName(cityName);

        return weather;
    }
}
